package ips2023pl21.service;

import java.time.LocalTime;
import java.time.ZoneId;
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
		OLDDATE
	}
	
	private Persistence p = Persistence.getInstance();
	private Instalacion instalacion;
	private Empleado jardinero;

	public List<String> getJardineros(String filter) {
		return p.selectJardineros().stream().map(x -> x.toString())
				.filter(x -> x.toLowerCase().contains(filter.toLowerCase())).collect(Collectors.toList());
	}

	public List<String> getInstalaciones(String filter) {
		return p.selectInstalaciones().stream().map(x -> x.toString())
				.filter(x -> x.toLowerCase().contains(filter.toLowerCase())).collect(Collectors.toList());
	}

	public List<String> getHorarios() {
		return p.selectHorariosJardineria().stream().map(x -> x.toString()).collect(Collectors.toList());
	}

	public state addHorarioJardineria(Date fecha, Date horaInicio, Date horaFin) {
		
		if (instalacion == null)
			return state.INSTALACIONNULL;
		else if (jardinero == null)
			return state.JARDINERONULL;
		else if (!horaInicio.before(horaFin))
			return state.INICIOAFTERFIN;
		
		try {
			p.insertHorarioJardineria(
					jardinero.getEid(),
					instalacion.getId(),
					Util.dateToIsoString(fecha),
					Util.localTimeToString(dateToLocalTime(horaInicio)),
					Util.localTimeToString(dateToLocalTime(horaFin)));			
		} catch (Exception e) {
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

	private LocalTime dateToLocalTime(Date d) {
		return d.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
	}

}
