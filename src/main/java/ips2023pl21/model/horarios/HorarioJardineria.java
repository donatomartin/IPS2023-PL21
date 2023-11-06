package ips2023pl21.model.horarios;

import java.time.LocalTime;

import ips2023pl21.model.Empleado;
import ips2023pl21.model.activos.Instalacion;
import ips2023pl21.persistence.Persistence;
import ips2023pl21.util.Util;

public class HorarioJardineria {
	
	public HorarioJardineria() {}
	
	private String fechaJardineria;
	private String horaInicio;
	private String horaFin;
	private int iid;
	private int eid;
	
	public String getFechaJardineria() {
		return fechaJardineria;
	}
	public String getHoraInicio() {
		return horaInicio;
	}
	public String getHoraFin() {
		return horaFin;
	}
	public int getEid() {
		return eid;
	}
	public void setFechaJardineria(String fechaJardineria) {
		this.fechaJardineria = fechaJardineria;
	}
	public void setIid(int iid) {
		this.iid = iid;
	}
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}
	public int getIid() {
		return iid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	
	@Override
	public String toString() {
		
		Empleado e = Persistence.getInstance().getEmpleado(eid);
		String js = e.getNombre() + " " + e.getApellido();
		Instalacion i = Persistence.getInstance().getInstalacion(iid);
		String is = i.getId() + " " + i.getNombreInstalacion();
		
		return "(%s | %s - %s) %-20s %s".formatted(fechaJardineria, horaInicio, horaFin, js, is);
	}
	public LocalTime getHoraInicioParsed() {
		return Util.stringHoraToLocalTime(horaInicio);
	}
	
	public LocalTime getHoraFinParsed() {
		return Util.stringHoraToLocalTime(horaFin);
	}
}
