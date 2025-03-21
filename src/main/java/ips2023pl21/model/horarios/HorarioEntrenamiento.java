package ips2023pl21.model.horarios;

import java.time.LocalTime;

import ips2023pl21.model.activos.Instalacion;
import ips2023pl21.model.equipos.Equipo;
import ips2023pl21.persistence.Persistence;
import ips2023pl21.util.Util;

public class HorarioEntrenamiento {
	
	public HorarioEntrenamiento() {}
	
	private Integer id;
	private String fechaEntrenamiento;
	private String horaInicio;
	private String horaFin;
	private int enid;
	private int iid;
	private int eid;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFechaEntrenamiento() {
		return fechaEntrenamiento;
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
	public int getEnid() {
		return enid;
	}
	public int getIid() {
		return iid;
	}
	public void setFechaEntrenamiento(String fechaEntrenamiento) {
		this.fechaEntrenamiento = fechaEntrenamiento;
	}
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}
	public void setEnid(int enid) {
		this.enid = enid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public void setIid(int iid) {
		this.iid = iid;
	}
	
	@Override
	public String toString() {
		
		Equipo e = Persistence.getInstance().getEquipo(eid);
		String es = e.getNombre();
		Instalacion i = Persistence.getInstance().getInstalacion(iid);
		String is = i.getId() + " " + i.getNombreInstalacion();
		
		return "(%s | %s - %s) %-20s %s".formatted(fechaEntrenamiento, horaInicio, horaFin, es, is);
	}
	public LocalTime getParsedInicio() {
		return Util.stringHoraToLocalTime(horaInicio);
	}
	
	public LocalTime getParsedFin() {
		return Util.stringHoraToLocalTime(horaFin);
	}
}
