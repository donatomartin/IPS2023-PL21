package ips2023pl21.model.equipos;

import ips2023pl21.persistence.Persistence;

public class Partido {
	
	private Persistence p = Persistence.getInstance();
	
	private EquipoDeportivo local;
	private String visitante;
	private String fecha;
	private float suplemento;
	
	public EquipoDeportivo getLocal() {
		return local;
	}
	public void setLocal(EquipoDeportivo local) {
		this.local = local;
	}
	public String getVisitante() {
		return visitante;
	}
	public void setVisitante(String visitante) {
		this.visitante = visitante;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public float getSuplemento() {
		return suplemento;
	}
	public void setSuplemento(float suplemento) {
		this.suplemento = suplemento;
	}
	
	
	public void crearPartido() {
		p.insertPartido(this);
	}
	
}
