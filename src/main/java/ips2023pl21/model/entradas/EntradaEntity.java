package ips2023pl21.model.entradas;

public class EntradaEntity {
	
	private String tribuna;
	private String seccion;
	private int fila;
	private int asiento;
	private int precio=30;
	
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) { //he puesto los setters públicos porque en el ejemplo están públicos
		this.precio = precio;
	}
	public String getTribuna() {
		return tribuna;
	}
	public void setTribuna(String tribuna) {
		this.tribuna = tribuna;
	}
	public String getSeccion() {
		return seccion;
	}
	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}
	public int getFila() {
		return fila;
	}
	public void setFila(int fila) {
		this.fila = fila;
	}
	public int getAsiento() {
		return asiento;
	}
	public void setAsiento(int asiento) {
		this.asiento = asiento;
	}
	
	
}
	
