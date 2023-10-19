package ips2023pl21.p21915.model;

import java.time.LocalTime;

import ips2023pl21.p21915.service.Service21915;
import ips2023pl21.p21915.util.Util;

public class Entrevista {
	
	public Entrevista() {}
	
	private String fechaEntrevista;
	private String datosMedio;
	private String horaInicio;
	private String horaFin;
	private int eid;
	
	public String getFechaEntrevista() {
		return fechaEntrevista;
	}
	public String getDatosMedio() {
		return datosMedio;
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
	public void setFechaEntrevista(String fechaEntrevista) {
		this.fechaEntrevista = fechaEntrevista;
	}
	public void setDatosMedio(String datosMedio) {
		this.datosMedio = datosMedio;
	}
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	
	@Override
	public String toString() {
		JugadorProfesional j = Service21915.getJugador(eid);
		String js = j.getNombre() + " " + j.getApellido();
		return "(%s | %s - %s) %-30s %s".formatted(fechaEntrevista, horaInicio, horaFin, js, datosMedio);
	}
	public LocalTime getHoraInicioParsed() {
		return Util.stringHoraToLocalTime(horaInicio);
	}
	
	public LocalTime getHoraFinParsed() {
		return Util.stringHoraToLocalTime(horaFin);
	}

}
