package ips2023pl21.service;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import ips2023pl21.model.Empleado;
import ips2023pl21.model.horarios.HorarioPuntual;
import ips2023pl21.model.horarios.HorarioSemanal;
import ips2023pl21.model.horarios.franjas.Franja;
import ips2023pl21.model.horarios.franjas.FranjaPuntual;
import ips2023pl21.model.horarios.franjas.FranjaSemanal;
import ips2023pl21.persistence.Persistence;
import ips2023pl21.util.UnexpectedException;
import ips2023pl21.util.Util;

public class Service21912 {

	private Empleado empleado;
	private static HorarioSemanal horarioSemanal;
	private static HorarioPuntual horarioPuntual;
	public Persistence p = Persistence.getInstance();

	// Empleados

	public List<String> getEmpleadosNoDeportivos(String filter) {
		return p.selectEmpleadosNoDeportivos().stream().map(x -> x.toString())
				.filter(x -> x.toLowerCase().contains(filter.toLowerCase())).collect(Collectors.toList());
	}

	public void seleccionaEmpleado(String empleadoString) {

		if (empleadoString.equals("")) {
			empleado = null;
			return;
		}

		int id = getIdFromString(empleadoString);
		empleado = p.getEmpleado(id);

		horarioPuntual = null;
		horarioSemanal = null;

	}

	private int getIdFromString(String empleadoString) {
		return Integer.parseInt(empleadoString.strip().split(" ")[0]);
	}

	public String getNombreEmpleadoSeleccionado() {
		return empleado.getNombre() + " " + empleado.getApellido();
	}

	// HORARIO SEMANAL

	/**
	 * Lista de horarios semanales a string para empleado
	 * 
	 * @return
	 */
	public List<String> getHorariosSemanales() {
		return p.selectHorariosSemanales(empleado.getEid()).stream().map(x -> x.toString())
				.collect(Collectors.toList());
	}

	/**
	 * Insert horario semanal a empleado
	 * 
	 * @param diaSemana
	 * @param fechaInicio
	 * @return
	 */
	public State addHorarioSemanal(String diaSemana, Date fechaInicio) {
		if (!semanaDeAntelacion(fechaInicio))
			return State.NOSEMANADEANTELACION;

		int numeroDiaSemana = HorarioSemanal.getNumeroDia(diaSemana);
		String fechaString = Util.dateToIsoString(fechaInicio);
		int eid = empleado.getEid();

		try {
			p.insertHorarioSemanal(numeroDiaSemana, fechaString, eid);
			seleccionaHorarioSemanal(numeroDiaSemana, fechaString);
			actualizarHorariosSemanales();
			return State.SUCCESS;
		} catch (UnexpectedException e) {
			return State.DBERROR;
		}

	}

	/**
	 * Actualiza la base de datos para que si hay más de una entidad con el mismo
	 * día de la semana, se añada una fechaFin igual a la fechaInicio del siguiente
	 * horario vigente. Además, el horario con la fecha de inicio más tardía no
	 * tendrá una fecha de fin.
	 */
	public void actualizarHorariosSemanales() {

		List<HorarioSemanal> horarios = p.selectHorariosSemanales(getEid());

		if (horarios.size() == 0) {
			return;
		}

		for (int i = 0; i < horarios.size() - 1; i++) {
			HorarioSemanal actual = horarios.get(i);
			HorarioSemanal siguiente = horarios.get(i + 1);
			if (actual.getDiaSemana() == siguiente.getDiaSemana()) {
				actual.setFechaFin(siguiente.getFechaInicio());
				String fechaFinString = actual.getFechaFin();
				p.updateFechaFin(getEid(), actual, fechaFinString);
			}
		}

		// Elimina la fecha de fin del horario con la fecha de inicio más tardía
		HorarioSemanal ultimoHorario = horarios.get(horarios.size() - 1);
		ultimoHorario.setFechaFin(null);
		p.deleteFechaFin(getEid(), ultimoHorario);

	}

	/**
	 * Insert franjaPuntual a horario
	 * 
	 * @param hi
	 * @param hf
	 * @return
	 */
	public State addToHorarioSemanal(Date hi, Date hf, String diaSemana, Date fechaInicio) {

		String horaInicio = Util.localTimeToString(dateToLocalTime(hi));
		String horaFin = Util.localTimeToString(dateToLocalTime(hf));

		State res = checkFranjaSemanal(horaInicio, horaFin);

		if (res == State.HORARIONULL) {
			State resh = addHorarioSemanal(diaSemana, fechaInicio);
			if (resh != State.SUCCESS)
				res = resh;
			return res;
		}
		
		if (res == State.SUCCESS) {
			try {
				p.insertFranjaSemanal(getDiaSemana(), getFechaInicio(), getEid(), horaInicio, horaFin);
			} catch (Exception e) {
				res = State.SOLAPAFRANJAS;
				
			}			
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
			p.deleteHorarioSemanal(getDiaSemana(), getFechaInicio(), getEid());
			actualizarHorariosSemanales();

			horarioSemanal = null;
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
		try {
			horarioSemanal = p.getHorarioSemanal(getEid(), numeroDiaSemana, fechaInicio);
		} catch (Exception e) {
			horarioSemanal = null;
		}

	}

	/**
	 * Selecciona en base a String
	 * 
	 * @param horarioString
	 */
	public void seleccionaHorarioSemanal(String horarioString) {

		String[] parts = Util.removeHtml(horarioString).replace(" ", "").split("\\(");
		
		if (parts.length < 2 || parts[1].length() < 10)
			return;
		
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
	private State checkFranjaSemanal(String horaInicio, String horaFin) {

		Franja franja = new Franja();
		franja.setHoraInicio(horaInicio);
		franja.setHoraFin(horaFin);

		if (horarioSemanal == null)
			return State.HORARIONULL;

		if (franja.getParsedFin().isBefore(franja.getParsedInicio()))
			return State.INICIOAFTERFIN;

		int minutosTotalesDiarios = (int) franja.getMinutosTotales();
		List<FranjaSemanal> franjas = p.getFranjasSemanales(getDiaSemana(), getFechaInicio(), getEid());
		for (FranjaSemanal f : franjas) {
			minutosTotalesDiarios += f.getMinutosTotales();
			if (franja.solapa(f))
				return State.SOLAPAFRANJAS;
		}

		if (minutosTotalesDiarios > Empleado.HORAS_DIARIAS_MAX * 60)
			return State.OVERDAILYMAX;

		int[] minutosTotalesArr = new int[7];
		minutosTotalesArr[getDiaSemana() - 1] = minutosTotalesDiarios;

		for (HorarioSemanal h : p.selectHorariosSemanales(getEid())) {

			if (h.getDiaSemana() == getDiaSemana())
				continue;

			minutosTotalesArr[h.getDiaSemana() - 1] = 0;
			for (Franja f : p.getFranjasSemanales(h.getDiaSemana(), h.getFechaInicio(), getEid()))
				minutosTotalesArr[h.getDiaSemana() - 1] += f.getMinutosTotales();

		}

		int minutosTotales = 0;
		for (int i = 0; i < minutosTotalesArr.length; i++) {
			minutosTotales += minutosTotalesArr[i];
		}

		if (minutosTotales > Empleado.HORAS_SEMANALES_MAX * 60)
			return State.OVERWEEKLYMAX;

		return State.SUCCESS;

	}

	// Horario Puntual

	/**
	 * Lista de horarios puntuales a String para empleado
	 * 
	 * @return
	 */
	public List<String> getHorariosPuntualesString() {
		return p.selectHorariosPuntuales(getEid()).stream().map(x -> x.toString()).collect(Collectors.toList());
	}

	/**
	 * Insert horario puntual para empleado
	 * 
	 * @param fechaPuntual
	 * @return
	 */
	public State addHorarioPuntual(Date fechaPuntual) {
		if (!semanaDeAntelacion(fechaPuntual))
			return State.NOSEMANADEANTELACION;

		String fechaString = Util.dateToIsoString(fechaPuntual);
		int eid = empleado.getEid();

		try {
			p.insertHorarioPuntual(fechaString, eid);
			seleccionaHorarioPuntual(fechaString);
			return State.SUCCESS;
		} catch (UnexpectedException e) {
			return State.DBERROR;
		}
	}

	public State addToHorarioPuntual(Date hi, Date hf, Date fechaPuntual) {

		// PARAMS
		String horaInicio = Util.localTimeToString(dateToLocalTime(hi));
		String horaFin = Util.localTimeToString(dateToLocalTime(hf));

		State res = checkFranjaPuntual(horaInicio, horaFin);
		
		if (res == State.HORARIONULL) {
			State resh = addHorarioPuntual(fechaPuntual);
			if (resh != State.SUCCESS)
				res = resh;
			return res;
		}
		
		if (res == State.SUCCESS) {
			try {
				p.insertFranjaPuntual(getFechaPuntual(), getEid(), horaInicio, horaFin);
			} catch (Exception e) {
				res = State.SOLAPAFRANJAS;
			}			
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
			p.removeHorarioPuntual(getFechaPuntual());
			horarioPuntual = null;
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

		try {
			horarioPuntual = p.getHorarioPuntual(getEid(), fechaPuntual);
		} catch (Exception e) {
			horarioPuntual = null;
		}
	}

	/**
	 * Selecciona en base a String
	 * 
	 * @param horarioString
	 */
	public void seleccionaHorarioPuntualHtml(String horarioString) {

		String[] parts = Util.removeHtml(horarioString).split(":");
		
		String fechaInicio = parts[0];

		seleccionaHorarioPuntual(fechaInicio);

	}

	public State checkFranjaPuntual(String horaInicio, String horaFin) {

		Franja franja = new Franja();
		franja.setHoraInicio(horaInicio);
		franja.setHoraFin(horaFin);

		if (horarioPuntual == null)
			return State.HORARIONULL;

		if (franja.getParsedFin().isBefore(franja.getParsedInicio()))
			return State.INICIOAFTERFIN;

		int minutosTotalesDiarios = (int) franja.getMinutosTotales();
		List<FranjaPuntual> franjas = p.getFranjasPuntuales(getFechaPuntual(), getEid());
		for (FranjaPuntual f : franjas) {
			minutosTotalesDiarios += f.getMinutosTotales();
			if (franja.solapa(f))
				return State.SOLAPAFRANJAS;
		}

		if (minutosTotalesDiarios > Empleado.HORAS_DIARIAS_MAX * 60)
			return State.OVERDAILYMAX;

		int[] minutosTotalesArr = new int[7];
		minutosTotalesArr[HorarioSemanal.getDiaDeLaSemana(horarioPuntual.getFechaPuntual())
				- 1] = minutosTotalesDiarios;

		for (HorarioSemanal h : p.selectHorariosSemanales(getEid())) {

			if (h.getDiaSemana() == HorarioSemanal.getDiaDeLaSemana(horarioPuntual.getFechaPuntual()))
				continue;

			if (Util.isoStringToDate(h.getFechaInicio()).after(Util.isoStringToDate(getFechaPuntual())))
				continue;

			minutosTotalesArr[h.getDiaSemana() - 1] = 0;
			for (Franja f : p.getFranjasSemanales(h.getDiaSemana(), h.getFechaInicio(), getEid()))
				minutosTotalesArr[h.getDiaSemana() - 1] += f.getMinutosTotales();

		}

		int minutosTotales = 0;
		for (int i = 0; i < minutosTotalesArr.length; i++) {
			minutosTotales += minutosTotalesArr[i];
		}

		if (minutosTotales > Empleado.HORAS_SEMANALES_MAX * 60)
			return State.OVERWEEKLYMAX; // Horas semanales sobrepasadas

		return State.SUCCESS;

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

	private int getDiaSemana() {
		return horarioSemanal.getDiaSemana();
	}

	private String getFechaInicio() {
		return horarioSemanal.getFechaInicio();
	}

	private String getFechaPuntual() {
		return horarioPuntual.getFechaPuntual();
	}

	private int getEid() {
		return empleado.getEid();
	}

}
