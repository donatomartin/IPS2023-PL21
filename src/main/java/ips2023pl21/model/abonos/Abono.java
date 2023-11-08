package ips2023pl21.model.abonos;



public class Abono{
	
	private String tribuna; 
	private String seccion;
	private int fila;
	private int asiento;
	private String fechaCaducidad; //String porque viene de sql
	
	
	public Abono() {
		super();
	}
	
	public Abono(String tribuna, String seccion, int fila, int asiento, String caducidad) {
		super();
		this.tribuna = tribuna;
		this.seccion = seccion;
		this.fila = fila;
		this.asiento = asiento;
		this.fechaCaducidad = caducidad;
	}
//
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
	public String getFechaCaducidad() {
		return fechaCaducidad;
	}
	public void setFechaCaducidad(String caducidad) {
		this.fechaCaducidad = caducidad;
	}
	
	
	
}
