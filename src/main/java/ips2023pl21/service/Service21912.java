package ips2023pl21.service;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import ips2023pl21.model.EmpleadoNoDeportivo;
import ips2023pl21.model.Franja;
import ips2023pl21.model.FranjaPuntual;
import ips2023pl21.model.FranjaSemanal;
import ips2023pl21.model.HorarioPuntual;
import ips2023pl21.model.HorarioSemanal;
import ips2023pl21.util.Database;
import ips2023pl21.util.UnexpectedException;
import ips2023pl21.util.Util;

public class Service21912 {

	private EmpleadoNoDeportivo empleadoSeleccionado;
	private static HorarioSemanal horarioSemanalSeleccionado;
	private static HorarioPuntual horarioPuntualSeleccionado;
	private static Database db;

	public Service21912() {
		db = new Database();
		db.createDatabase(false);
		db.loadDatabase();
	}

	// Empleados

	public static List<EmpleadoNoDeportivo> getEmpleadosNoDeportivos() {
		List<EmpleadoNoDeportivo> result = db.executeQueryPojo(EmpleadoNoDeportivo.class,
				"select * from empleadonodeportivo");

		return result;
	}

	public EmpleadoNoDeportivo getEmpleadoNoDeportivo(int eid) {
		return db.executeQueryPojo(EmpleadoNoDeportivo.class, "select * from empleadonodeportivo where eid=?", eid)
				.get(0);
	}

	public List<String> getEmpleadosNoDeportivosString(String filter) {
		return getEmpleadosNoDeportivos().stream().map(x -> x.toString())
				.filter(x -> x.toLowerCase().contains(filter.toLowerCase())).collect(Collectors.toList());
	}

	public void seleccionaEmpleado(String empleadoString) {
		if (empleadoString.equals("")) {
			empleadoSeleccionado = null;
			return;
		}
		
		int id = getIdFromString(empleadoString);
		empleadoSeleccionado = getEmpleadoNoDeportivo(id);
	}

	private int getIdFromString(String empleadoString) {
		return Integer.parseInt(empleadoString.strip().split(" ")[0]);
	}

	public String getNombreEmpleadoSeleccionado() {
		return empleadoSeleccionado.getNombre() + " " + empleadoSeleccionado.getApellido();
	}

	// HORARIO SEMANAL

	/**
	 * Select horarios semanales para empleado
	 * 
	 * @return
	 */
	public List<HorarioSemanal> getHorariosSemanales() {
		List<HorarioSemanal> result = db.executeQueryPojo(HorarioSemanal.class,
				"select * from HorarioSemanal where eid=?", empleadoSeleccionado.getEid()).stream().sorted()
				.collect(Collectors.toList());
		return result;
	}

	/**
	 * Lista de horarios semanales a string para empleado
	 * 
	 * @return
	 */
	public List<String> getHorariosSemanalesString() {
		return getHorariosSemanales().stream().map(x -> x.toString()).collect(Collectors.toList());
	}

	/**
	 * Insert horario semanal a empleado
	 * 
	 * @param diaSemana
	 * @param fechaInicio
	 * @return
	 */
	public boolean addHorarioSemanal(String diaSemana, Date fechaInicio) {

		if (!semanaDeAntelacion(fechaInicio))
			return false;

		int numeroDiaSemana = HorarioSemanal.getNumeroDia(diaSemana);
		String fechaString = Util.dateToIsoString2(fechaInicio);
		int eid = empleadoSeleccionado.getEid();

		try {
			db.executeUpdate("insert into HorarioSemanal(diaSemana, fechaInicio, eid) values (?, ?, ?)",
					numeroDiaSemana, fechaString, eid);
			seleccionaHorarioSemanal(numeroDiaSemana, fechaString);
			actualizarHorariosSemanales();
			return true;
		} catch (UnexpectedException e) {
			return false;
		}

	}
	
	/**
	 * Actualiza la base de datos para que si hay más de una entidad con el mismo día de la semana,
	 * se añada una fechaFin igual a la fechaInicio del siguiente horario vigente.
	 * Además, el horario con la fecha de inicio más tardía no tendrá una fecha de fin.
	 */
	public void actualizarHorariosSemanales() {
	    List<HorarioSemanal> horarios = getHorariosSemanales();
	    
	    if (horarios.size() <= 1) {
	    	return;
	    }
	    
	    for (int i = 0; i < horarios.size() - 1; i++) {
	        HorarioSemanal actual = horarios.get(i);
	        HorarioSemanal siguiente = horarios.get(i + 1);
	        if (actual.getDiaSemana() == siguiente.getDiaSemana()) {
	            actual.setFechaFin(siguiente.getFechaInicio());
	            String fechaFinString = actual.getFechaFin();
	            db.executeUpdate("update HorarioSemanal set fechaFin=? where eid=? and diaSemana=? and fechaInicio=?", 
	                             fechaFinString, empleadoSeleccionado.getEid(), actual.getDiaSemana(), actual.getFechaInicio());
	        }
	    }
	    
	    // Elimina la fecha de fin del horario con la fecha de inicio más tardía
	    HorarioSemanal ultimoHorario = horarios.get(horarios.size() - 1);
	    ultimoHorario.setFechaFin(null);
	    db.executeUpdate("update HorarioSemanal set fechaFin=null where eid=? and diaSemana=? and fechaInicio=?", 
	                     empleadoSeleccionado.getEid(), ultimoHorario.getDiaSemana(), ultimoHorario.getFechaInicio());
	
	
	}



	/**
	 * Insert franjaPuntual a horario
	 * 
	 * @param hi
	 * @param hf
	 * @return
	 */
	public int addToHorarioSemanal(Date hi, Date hf, String diaSemana, Date fechaInicio) {

		String horaInicio = FranjaSemanal.localTimeToString(dateToLocalTime(hi));
		String horaFin = FranjaSemanal.localTimeToString(dateToLocalTime(hf));

		int res = checkFranjaSemanal(horaInicio, horaFin);
		if (res == 0) {
			
		}	
		else if (res == 1) {
			addHorarioSemanal(diaSemana, fechaInicio);
		}
		else
			return res;

		try {
			db.executeUpdate(
					"insert into FranjaSemanal(diaSemana, fechaInicio, horaInicio, horaFin) values (?, ?, ?, ?)",
					horarioSemanalSeleccionado.getDiaSemana(), horarioSemanalSeleccionado.getFechaInicio(), horaInicio,
					horaFin);
		} catch (Exception e) {
			res = -1;
			e.printStackTrace();
		}

		return res;
	}

	/**
	 * Borra horario seleccionado
	 * 
	 * @return
	 */
	public boolean borrarHorarioSemanalSeleccionado() {

		try {
			db.executeUpdate("delete from HorarioSemanal where diaSemana=? and fechaInicio=?",
					horarioSemanalSeleccionado.getDiaSemana(), horarioSemanalSeleccionado.getFechaInicio());
			db.executeUpdate("delete from FranjaSemanal where diaSemana=? and fechaInicio=?",
					horarioSemanalSeleccionado.getDiaSemana(), horarioSemanalSeleccionado.getFechaInicio());
			actualizarHorariosSemanales();
			
			horarioSemanalSeleccionado = null;
			return true;
		} catch (NullPointerException e) {
			return false;
		}

	}

	/**
	 * Selecciona por clave primaria
	 * 
	 * @param numeroDiaSemana
	 * @param fechaInicio
	 */
	public void seleccionaHorarioSemanal(int numeroDiaSemana, String fechaInicio) {

		horarioSemanalSeleccionado = db.executeQueryPojo(HorarioSemanal.class,
				"select * from HorarioSemanal where eid=? and diaSemana=? and fechaInicio=?",
				empleadoSeleccionado.getEid(), numeroDiaSemana, fechaInicio).get(0);
	}

	/**
	 * Selecciona en base a String
	 * 
	 * @param horarioString
	 */
	public void seleccionaHorarioSemanal(String horarioString) {

		String[] parts = horarioString.replace(" ", "").split("\\(");
		int nDia = HorarioSemanal.getNumeroDia(parts[0]);
		String fechaInicio = parts[1].substring(0, 10);

		seleccionaHorarioSemanal(nDia, fechaInicio);

	}

	/**
	 * Comprueba requisitos para franja semanal
	 * 
	 * @param horaInicio
	 * @param horaFin
	 * @return
	 */
	private int checkFranjaSemanal(String horaInicio, String horaFin) {

		Franja franja = new Franja();
		franja.setHoraInicio(horaInicio);
		franja.setHoraFin(horaFin);

		if (horarioSemanalSeleccionado == null)
			return 1; // Horario no seleccionado

		if (franja.getParsedFin().isBefore(franja.getParsedInicio()))
			return 2; // Fin antes que principio

		int minutosTotalesDiarios = (int) franja.getMinutosTotales();
		List<FranjaSemanal> franjas = getFranjasSemanales(getDiaSemanaSel(), getFechaIniSel());
		for (FranjaSemanal f : franjas) {
			minutosTotalesDiarios += f.getMinutosTotales();
			if (franja.solapa(f))
				return 3; // Solapa entre franjas
		}

		if (minutosTotalesDiarios > EmpleadoNoDeportivo.HORAS_DIARIAS_MAX * 60)
			return 4; // Horas diarias sobrepasadas

		int[] minutosTotalesArr = new int[7];
		minutosTotalesArr[getDiaSemanaSel()] = minutosTotalesDiarios;

		for (HorarioSemanal h : getHorariosSemanales()) {

			if (h.getDiaSemana() == getDiaSemanaSel())
				continue;

			minutosTotalesArr[h.getDiaSemana()] = 0;
			for (Franja f : getFranjasSemanales(h.getDiaSemana(), h.getFechaInicio()))
				minutosTotalesArr[h.getDiaSemana()] += f.getMinutosTotales();

		}

		int minutosTotales = 0;
		for (int i = 0; i < minutosTotalesArr.length; i++) {
			minutosTotales += minutosTotalesArr[i];
		}

		if (minutosTotales > EmpleadoNoDeportivo.HORAS_SEMANALES_MAX * 60)
			return 5; // Horas semanales sobrepasadas

		return 0;

	}

	// Horario Puntual

	/**
	 * Select horarios puntuales para empleado
	 * 
	 * @return
	 */
	public List<HorarioPuntual> getHorariosPuntuales() {
		List<HorarioPuntual> result = db.executeQueryPojo(HorarioPuntual.class,
				"select * from HorarioPuntual where eid=?", empleadoSeleccionado.getEid()).stream().sorted()
				.collect(Collectors.toList());

		return result;
	}

	/**
	 * Lista de horarios puntuales a String para empleado
	 * 
	 * @return
	 */
	public List<String> getHorariosPuntualesString() {
		return getHorariosPuntuales().stream().map(x -> x.toString()).collect(Collectors.toList());
	}

	/**
	 * Insert horario puntual para empleado
	 * 
	 * @param fechaPuntual
	 * @return
	 */
	public boolean addHorarioPuntual(Date fechaPuntual) {
		if (!semanaDeAntelacion(fechaPuntual))
			return false;

		String fechaString = Util.dateToIsoString2(fechaPuntual);
		int eid = empleadoSeleccionado.getEid();

		try {
			db.executeUpdate("insert into HorarioPuntual(fechaPuntual, eid) values (?, ?)", fechaString, eid);
			seleccionaHorarioPuntual(fechaString);
			return true;
		} catch (UnexpectedException e) {
			return false;
		}
	}
	
	public int addToHorarioPuntual(Date hi, Date hf, Date fechaPuntual) {
		// PARAMS
		String horaInicio = FranjaSemanal.localTimeToString(dateToLocalTime(hi));
		String horaFin = FranjaSemanal.localTimeToString(dateToLocalTime(hf));

		int res = checkFranjaPuntual(horaInicio, horaFin);
		if (res == 0) {
		}	
		else if (res == 1) {
			addHorarioPuntual(fechaPuntual);
		}
		else
			return res;

		try {
			db.executeUpdate(
					"insert into FranjaPuntual(fechaPuntual, horaInicio, horaFin) values (?, ?, ?)",
					getFechaPunSel(), horaInicio, horaFin);
		} catch (Exception e) {
			res = -1;
		}

		return res;
	}
	
	/**
	 * Delete horario puntual seleccionado
	 * 
	 * @return
	 */
	public boolean borrarHorarioPuntualSeleccionado() {
		try {
			db.executeUpdate("delete from HorarioPuntual where fechaPuntual=?",
					getFechaPunSel());
			db.executeUpdate("delete from FranjaPuntual where fechaPuntual=?",
					getFechaPunSel());
			horarioPuntualSeleccionado = null;
			return true;
		} catch (NullPointerException e) {
			return false;
		}
	}
	
	/**
	 * Selecciona por clave primaria
	 * 
	 * @param numeroDiaSemana
	 * @param fechaInicio
	 */
	public void seleccionaHorarioPuntual(String fechaPuntual) {

		horarioPuntualSeleccionado = db.executeQueryPojo(HorarioPuntual.class,
				"select * from HorarioPuntual where eid=? and fechaPuntual=?",
				empleadoSeleccionado.getEid(), fechaPuntual).get(0);
	}

	/**
	 * Selecciona en base a String
	 * 
	 * @param horarioString
	 */
	public void seleccionaHorarioPuntual2(String horarioString) {

		String[] parts = horarioString.split(" ");
		String fechaInicio = parts[0];

		seleccionaHorarioPuntual(fechaInicio);

	}
	
	public int checkFranjaPuntual(String horaInicio, String horaFin) {
		
		Franja franja = new Franja();
		franja.setHoraInicio(horaInicio);
		franja.setHoraFin(horaFin);

		if (horarioPuntualSeleccionado == null)
			return 1; // Horario no seleccionado

		if (franja.getParsedFin().isBefore(franja.getParsedInicio()))
			return 2; // Fin antes que principio

		int minutosTotalesDiarios = (int) franja.getMinutosTotales();
		List<FranjaPuntual> franjas = getFranjasPuntuales(getFechaPunSel());
		for (FranjaPuntual f : franjas) {
			minutosTotalesDiarios += f.getMinutosTotales();
			if (franja.solapa(f))
				return 3; // Solapa entre franjas
		}

		if (minutosTotalesDiarios > EmpleadoNoDeportivo.HORAS_DIARIAS_MAX * 60)
			return 4; // Horas diarias sobrepasadas

		int[] minutosTotalesArr = new int[7];
		minutosTotalesArr[horarioPuntualSeleccionado.getDiaDeLaSemana()-1] = minutosTotalesDiarios;

		for (HorarioSemanal h : getHorariosSemanales()) {

			if (h.getDiaSemana() == horarioPuntualSeleccionado.getDiaDeLaSemana())	// Skipea el propio día a sobrescribir
				continue;

			if (Util.isoStringToDate2(h.getFechaInicio()).after(Util.isoStringToDate2(getFechaPunSel())))	// Skipea si todavía no está vigente el horario
				continue;
			
			minutosTotalesArr[h.getDiaSemana()] = 0;
			for (Franja f : getFranjasSemanales(h.getDiaSemana(), h.getFechaInicio()))
				minutosTotalesArr[h.getDiaSemana()] += f.getMinutosTotales();

		}

		int minutosTotales = 0;
		for (int i = 0; i < minutosTotalesArr.length; i++) {
			minutosTotales += minutosTotalesArr[i];
		}

		if (minutosTotales > EmpleadoNoDeportivo.HORAS_SEMANALES_MAX * 60)
			return 5; // Horas semanales sobrepasadas

		return 0;

	}
	
	

	// Franjas

	public static List<FranjaSemanal> getFranjasSemanales(int diaSem, String fechaIn) {
		List<FranjaSemanal> result = db
				.executeQueryPojo(FranjaSemanal.class,
						"select * from FranjaSemanal where diaSemana=? and fechaInicio=?", diaSem, fechaIn)
				.stream().sorted().collect(Collectors.toList());
		return result;
	}

	public static List<FranjaPuntual> getFranjasPuntuales(String fechaPuntual) {
		List<FranjaPuntual> result = db
				.executeQueryPojo(FranjaPuntual.class, "select * from FranjaPuntual where fechaPuntual=?", fechaPuntual)
				.stream().sorted().collect(Collectors.toList());
		;
		return result;
	}

	// Util

	private boolean semanaDeAntelacion(Date fecha) {

		Date ahora = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(ahora);
		calendar.add(Calendar.DATE, 6);
		Date dentroDeSieteDias = calendar.getTime();

		if (fecha.after(dentroDeSieteDias))
			return true;

		return false;
	}

	private LocalTime dateToLocalTime(Date d) {
		return d.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
	}

	private int getDiaSemanaSel() {
		return horarioSemanalSeleccionado.getDiaSemana();
	}

	private String getFechaIniSel() {
		return horarioSemanalSeleccionado.getFechaInicio();
	}
	
	private String getFechaPunSel() {
		return horarioPuntualSeleccionado.getFechaPuntual();
	}

}
