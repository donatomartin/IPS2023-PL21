package ips2023pl21.service;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import ips2023pl21.model.empleados.EmpleadoNoDeportivo;
import ips2023pl21.model.horarios.HorarioPuntual;
import ips2023pl21.model.horarios.HorarioSemanal;
import ips2023pl21.model.horarios.franjas.Franja;
import ips2023pl21.model.horarios.franjas.FranjaPuntual;
import ips2023pl21.model.horarios.franjas.FranjaSemanal;
import ips2023pl21.persistence.Persistence;
import ips2023pl21.util.UnexpectedException;
import ips2023pl21.util.Util;

public class Service21912 {

	private EmpleadoNoDeportivo empleadoSeleccionado;
	private static HorarioSemanal horarioSemanalSeleccionado;
	private static HorarioPuntual horarioPuntualSeleccionado;
	public Persistence p = Persistence.getInstance();

	// Empleados

	public List<String> getEmpleadosNoDeportivos(String filter) {
		return p.selectEmpleadosNoDeportivos().stream().map(x -> x.toString())
				.filter(x -> x.toLowerCase().contains(filter.toLowerCase())).collect(Collectors.toList());
	}

	public void seleccionaEmpleado(String empleadoString) {
		if (empleadoString.equals("")) {
			empleadoSeleccionado = null;
			return;
		}

		int id = getIdFromString(empleadoString);
		empleadoSeleccionado = p.getEmpleadoNoDeportivo(id);
	}

	private int getIdFromString(String empleadoString) {
		return Integer.parseInt(empleadoString.strip().split(" ")[0]);
	}

	public String getNombreEmpleadoSeleccionado() {
		return empleadoSeleccionado.getNombre() + " " + empleadoSeleccionado.getApellido();
	}

	// HORARIO SEMANAL

	/**
	 * Lista de horarios semanales a string para empleado
	 * 
	 * @return
	 */
	public List<String> getHorariosSemanales() {
		return p.selectHorariosSemanales(empleadoSeleccionado.getEid()).stream().map(x -> x.toString())
				.collect(Collectors.toList());
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
		String fechaString = Util.dateToIsoString(fechaInicio);
		int eid = empleadoSeleccionado.getEid();

		try {
			p.insertHorarioSemanal(numeroDiaSemana, fechaString, eid);
			seleccionaHorarioSemanal(numeroDiaSemana, fechaString);
			actualizarHorariosSemanales();
			return true;
		} catch (UnexpectedException e) {
			return false;
		}

	}

	/**
	 * Actualiza la base de datos para que si hay más de una entidad con el mismo
	 * día de la semana, se añada una fechaFin igual a la fechaInicio del siguiente
	 * horario vigente. Además, el horario con la fecha de inicio más tardía no
	 * tendrá una fecha de fin.
	 */
	public void actualizarHorariosSemanales() {

		List<HorarioSemanal> horarios = p.selectHorariosSemanales(getEidSel());

		if (horarios.size() == 0) {
			return;
		}

		for (int i = 0; i < horarios.size() - 1; i++) {
			HorarioSemanal actual = horarios.get(i);
			HorarioSemanal siguiente = horarios.get(i + 1);
			if (actual.getDiaSemana() == siguiente.getDiaSemana()) {
				actual.setFechaFin(siguiente.getFechaInicio());
				String fechaFinString = actual.getFechaFin();
				p.updateFechaFin(getEidSel(), actual, fechaFinString);
			}
		}

		// Elimina la fecha de fin del horario con la fecha de inicio más tardía
		HorarioSemanal ultimoHorario = horarios.get(horarios.size() - 1);
		ultimoHorario.setFechaFin(null);
		p.deleteFechaFin(getEidSel(), ultimoHorario);

	}

	/**
	 * Insert franjaPuntual a horario
	 * 
	 * @param hi
	 * @param hf
	 * @return
	 */
	public int addToHorarioSemanal(Date hi, Date hf, String diaSemana, Date fechaInicio) {

		String horaInicio = Util.localTimeToString(dateToLocalTime(hi));
		String horaFin = Util.localTimeToString(dateToLocalTime(hf));

		int res = checkFranjaSemanal(horaInicio, horaFin);
		if (res == 0) {

		} else if (res == 1) {
			addHorarioSemanal(diaSemana, fechaInicio);
			return 1;
		} else
			return res;

		try {
			p.insertFranjaSemanal(getDiaSemanaSel(), getFechaIniSel(), horaInicio, horaFin);
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
			p.deleteHorarioSemanal(getDiaSemanaSel(), getFechaIniSel());
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

		horarioSemanalSeleccionado = p.getHorarioSemanal(getEidSel(), numeroDiaSemana, fechaInicio);
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
		List<FranjaSemanal> franjas = p.getFranjasSemanales(getDiaSemanaSel(), getFechaIniSel());
		for (FranjaSemanal f : franjas) {
			minutosTotalesDiarios += f.getMinutosTotales();
			if (franja.solapa(f))
				return 3; // Solapa entre franjas
		}

		if (minutosTotalesDiarios > EmpleadoNoDeportivo.HORAS_DIARIAS_MAX * 60)
			return 4; // Horas diarias sobrepasadas

		int[] minutosTotalesArr = new int[7];
		minutosTotalesArr[getDiaSemanaSel() - 1] = minutosTotalesDiarios;

		for (HorarioSemanal h : p.selectHorariosSemanales(getEidSel())) {

			if (h.getDiaSemana() == getDiaSemanaSel())
				continue;

			minutosTotalesArr[h.getDiaSemana() - 1] = 0;
			for (Franja f : p.getFranjasSemanales(h.getDiaSemana(), h.getFechaInicio()))
				minutosTotalesArr[h.getDiaSemana() - 1] += f.getMinutosTotales();

		}

		int minutosTotales = 0;
		for (int i = 0; i < minutosTotalesArr.length; i++) {
			minutosTotales += minutosTotalesArr[i];
		}

		if (minutosTotales > EmpleadoNoDeportivo.HORAS_SEMANALES_MAX * 60)
			return 5; // Horas semanales sobrepasadas

		return 0;

	}

	public void deseleccionadHorarioSemanal() {
		horarioSemanalSeleccionado = null;
	}

	// Horario Puntual

	/**
	 * Lista de horarios puntuales a String para empleado
	 * 
	 * @return
	 */
	public List<String> getHorariosPuntualesString() {
		return p.selectHorariosPuntuales(getEidSel()).stream().map(x -> x.toString()).collect(Collectors.toList());
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

		String fechaString = Util.dateToIsoString(fechaPuntual);
		int eid = empleadoSeleccionado.getEid();

		try {
			p.insertHorarioPuntual(fechaString, eid);
			seleccionaHorarioPuntual(fechaString);
			return true;
		} catch (UnexpectedException e) {
			return false;
		}
	}

	public int addToHorarioPuntual(Date hi, Date hf, Date fechaPuntual) {

		// PARAMS
		String horaInicio = Util.localTimeToString(dateToLocalTime(hi));
		String horaFin = Util.localTimeToString(dateToLocalTime(hf));

		int res = checkFranjaPuntual(horaInicio, horaFin);
		if (res == 0) {
		} else if (res == 1) {
			addHorarioPuntual(fechaPuntual);
			return res;
		} else
			return res;

		try {
			p.insertFranjaPuntual(getFechaPunSel(), horaInicio, horaFin);
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
			p.removeHorarioPuntual(getFechaPunSel());
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

		horarioPuntualSeleccionado = p.getHorarioPuntual(getEidSel(), fechaPuntual);
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
		List<FranjaPuntual> franjas = p.getFranjasPuntuales(getFechaPunSel());
		for (FranjaPuntual f : franjas) {
			minutosTotalesDiarios += f.getMinutosTotales();
			if (franja.solapa(f))
				return 3; // Solapa entre franjas
		}

		if (minutosTotalesDiarios > EmpleadoNoDeportivo.HORAS_DIARIAS_MAX * 60)
			return 4; // Horas diarias sobrepasadas

		int[] minutosTotalesArr = new int[7];
		minutosTotalesArr[horarioPuntualSeleccionado.getDiaDeLaSemana() - 1] = minutosTotalesDiarios;

		for (HorarioSemanal h : p.selectHorariosSemanales(getEidSel())) {

			if (h.getDiaSemana() == horarioPuntualSeleccionado.getDiaDeLaSemana()) // Skipea el propio día a
																					// sobrescribir
				continue;

			if (Util.isoStringToDate(h.getFechaInicio()).after(Util.isoStringToDate(getFechaPunSel()))) // Skipea si
																										// todavía no
																										// está vigente
																										// el horario
				continue;

			minutosTotalesArr[h.getDiaSemana() - 1] = 0;
			for (Franja f : p.getFranjasSemanales(h.getDiaSemana(), h.getFechaInicio()))
				minutosTotalesArr[h.getDiaSemana() - 1] += f.getMinutosTotales();

		}

		int minutosTotales = 0;
		for (int i = 0; i < minutosTotalesArr.length; i++) {
			minutosTotales += minutosTotalesArr[i];
		}

		if (minutosTotales > EmpleadoNoDeportivo.HORAS_SEMANALES_MAX * 60)
			return 5; // Horas semanales sobrepasadas

		return 0;

	}

	public void deseleccionaHorarioPuntual() {
		horarioPuntualSeleccionado = null;
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

	private int getEidSel() {
		return empleadoSeleccionado.getEid();
	}

}
