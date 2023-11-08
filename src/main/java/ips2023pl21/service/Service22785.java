package ips2023pl21.service;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import ips2023pl21.model.Empleado;
import ips2023pl21.model.activos.Instalacion;
import ips2023pl21.model.equipos.Equipo;
import ips2023pl21.persistence.Persistence;
import ips2023pl21.ui.UserInterface;
import ips2023pl21.util.Util;

public class Service22785 {
	
	private Persistence p = Persistence.getInstance();
	private Equipo equipo;
	private Instalacion instalacion;
	private Empleado entrenador;
	private String fecha;
	private String horaInicio;
	private String horaFin;
	
	private LocalTime getParsedHoraInicio() {
		return Util.stringHoraToLocalTime(horaInicio);
	}
	
	private LocalTime getParsedHoraFin() {
		return Util.stringHoraToLocalTime(horaFin);
	}
	
	public State login(int eid) {
		Empleado e = p.getEmpleado(eid);
		if (e == null)
			return State.LOGINFAIL_USERNOTFOUND;
		if (!e.getPosicion().equals("entrenador"))
			return State.LOGINFAIL_USERNOTALLOWED;
		
		entrenador = e;
		return State.SUCCESS;
	}

	public List<String> getEquipos(String filter) {
		if (instalacion == null)
			return new ArrayList<>();
		return p.selectEquiposLibres(entrenador.getEid(), instalacion.getId(), fecha, horaInicio, horaFin).stream().map(x -> x.toString())
				.filter(x -> x.toLowerCase().contains(filter.toLowerCase())).collect(Collectors.toList());
	}

	public List<String> getInstalaciones(String filter) {
		return p.selectInstalaciones().stream().map(x -> x.toString())
				.filter(x -> x.toLowerCase().contains(filter.toLowerCase())).collect(Collectors.toList());
	}

	public List<String> getHorarios() {
		return p.selectHorariosEntrenamiento().stream().map(x -> x.toString()).collect(Collectors.toList());
	}

	public State addHorarioEntrenamiento(UserInterface ui) {
		
		if (instalacion == null)
			return State.INSTALACIONNULL;
		else if (equipo == null)
			return State.EQUIPONULL;
		else if (getParsedHoraInicio().isAfter(getParsedHoraFin()))
			return State.INICIOAFTERFIN;		
		
		try {
			p.insertHorarioEntrenamiento(
					entrenador.getEid(),
					equipo.getId(),
					instalacion.getId(),
					fecha,
					horaInicio,
					horaFin,
					ui);		
		} catch (Exception e) {
			e.printStackTrace();
			return State.DBERROR;
		}
		
		return State.SUCCESS;
	}

	public void seleccionaEquipo(String equipo) {
		try {
			this.equipo = p.getEquipo(equipo.split(" ")[0]);
		} catch (Exception e) {
			this.equipo = null;
		}
	}
	
	public String getNombreEquipo() {
		if (equipo == null)
			return "NONE";
		return equipo.getNombre();
	}

	public void seleccionaInstalacion(String instalacion) {
		this.instalacion = p.getInstalacion(Integer.parseInt(instalacion.strip().split(" ")[0]));
	}
	
	public String getNombreInstalacion() {
		if (instalacion == null)
			return "NONE";
		return instalacion.getNombreInstalacion();
	}
	
	public void updateFecha(Date fecha) {
		this.fecha = Util.dateToIsoString(fecha);
	}
	
	public void updateHoraInicio(Date horaInicio) {
		this.horaInicio = Util.localTimeToString(dateToLocalTime(horaInicio));
	}
	
	public void updateHoraFin(Date horaFin) {
		this.horaFin = Util.localTimeToString(dateToLocalTime(horaFin));
	}
	
	private LocalTime dateToLocalTime(Date d) {
		return d.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
	}

}
