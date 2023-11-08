package ips2023pl21.service;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import ips2023pl21.model.Empleado;
import ips2023pl21.model.activos.Instalacion;
import ips2023pl21.persistence.Persistence;
import ips2023pl21.util.Util;

public class Service22784 {
	
	public enum state {
		SUCCESS,
		CONCURRENCEERROR,
		INSTALACIONNULL,
		JARDINERONULL,
		INICIOAFTERFIN,
		INTERFIEREENTRENAMIENTO
	}
	
	private Persistence p = Persistence.getInstance();
	private Instalacion instalacion;
	private Empleado jardinero;
	private String fecha;
	private String horaInicio;
	private String horaFin;
	
	private LocalTime getParsedHoraInicio() {
		return Util.stringHoraToLocalTime(horaInicio);
	}
	
	private LocalTime getParsedHoraFin() {
		return Util.stringHoraToLocalTime(horaFin);
	}

	public List<String> getJardineros(String filter) {
		if (instalacion == null)
			return new ArrayList<>();
		return p.selectJardinerosLibres(fecha, horaInicio, horaFin, instalacion.getId()).stream().map(x -> x.toString())
				.filter(x -> x.toLowerCase().contains(filter.toLowerCase())).collect(Collectors.toList());
	}

	public List<String> getInstalaciones(String filter) {
		return p.selectInstalaciones().stream().map(x -> x.toString())
				.filter(x -> x.toLowerCase().contains(filter.toLowerCase())).collect(Collectors.toList());
	}

	public List<String> getHorarios() {
		return p.selectHorariosJardineria().stream().map(x -> x.toString()).collect(Collectors.toList());
	}

	public state addHorarioJardineria() {
		
		if (instalacion == null)
			return state.INSTALACIONNULL;
		else if (jardinero == null)
			return state.JARDINERONULL;
		else if (getParsedHoraInicio().isAfter(getParsedHoraFin()))
			return state.INICIOAFTERFIN;
		
		try {
			p.insertHorarioJardineria(
					jardinero.getEid(),
					instalacion.getId(),
					fecha,
					horaInicio,
					horaFin);		
		}
		catch (IllegalStateException ise) {
			return state.INTERFIEREENTRENAMIENTO;
		}
		catch (Exception e) {
			return state.CONCURRENCEERROR;
		}
		
		return state.SUCCESS;
	}

	public void seleccionaJardinero(String jardinero) {
		try {
			this.jardinero = p.getEmpleado(Integer.parseInt(jardinero.strip().split(" ")[0]));
		} catch (Exception e) {
			this.jardinero = null;
		}
	}
	
	public String getNombreJardinero() {
		if (jardinero == null)
			return "NONE";
		return jardinero.getNombre() + " " + jardinero.getApellido();
	}

	public void seleccionaInstalacion(String instalacion) {
		this.instalacion = p.getInstalacion(Integer.parseInt(instalacion.strip().split(" ")[0]));
	}
	
	public String getNombreInstalacion() {
		if (instalacion == null)
			return "NONE";
		return instalacion.getNombreInstalacion();
	}

	public Instalacion getInstalacion() {
		return instalacion;
	}

	public Empleado getJardinero() {
		return jardinero;
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
