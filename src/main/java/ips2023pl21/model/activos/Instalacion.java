package ips2023pl21.model.activos;

public class Instalacion {

	private int id;
	private String nombreInstalacion;
	
	public Instalacion() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombreInstalacion() {
		return nombreInstalacion;
	}
	public void setNombreInstalacion(String nombre) {
		this.nombreInstalacion = nombre;
	}
	
	@Override
	public String toString() {
		return id + " " + nombreInstalacion + " ";
	}
	
}
