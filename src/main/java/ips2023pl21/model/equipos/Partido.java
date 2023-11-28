package ips2023pl21.model.equipos;

import java.util.Objects;

import ips2023pl21.persistence.Persistence;

public class Partido {
	
	private Persistence p = Persistence.getInstance();
	
	private String id;
	private EquipoDeportivo local;
	private String visitante;
	private String fecha;
	private float suplemento;
	
	public Partido(){}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	@Override
	public int hashCode() {
		return Objects.hash(fecha, id, local, visitante);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Partido other = (Partido) obj;
		return Objects.equals(fecha, other.fecha) && Objects.equals(id, other.id) && Objects.equals(local.getId(), other.local.getId())
				&& Objects.equals(visitante, other.visitante);
	}

	@Override
	public String toString() {
		return "Partido: " + local.getNombre() + " vs. " + visitante + ", Fecha: " + fecha + ", Suplemento: "
				+ suplemento;
	}


}
