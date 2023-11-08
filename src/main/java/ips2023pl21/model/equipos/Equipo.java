package ips2023pl21.model.equipos;

public class Equipo {
	
	public Equipo() {}
	
	private int id;
	private int peid;
	private int seid;
	private String nombre;
	private String categoria;
	private boolean filial;
	
	public int getId() {
		return id;
	}
	public int getPeid() {
		return peid;
	}
	public int getSeid() {
		return seid;
	}
	public String getNombre() {
		return nombre;
	}
	public String getCategoria() {
		return categoria;
	}
	public boolean isFilial() {
		return filial;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setPeid(int peid) {
		this.peid = peid;
	}
	public void setSeid(int seid) {
		this.seid = seid;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public void setFilial(boolean filial) {
		this.filial = filial;
	}
	
	@Override
	public String toString() {
		return "%-30s%-10s%-4b".formatted(nombre, categoria, filial);
	}
	
}
