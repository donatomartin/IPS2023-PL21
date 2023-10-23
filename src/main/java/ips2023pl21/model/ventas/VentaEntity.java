package ips2023pl21.model.ventas;

public class VentaEntity {
	private int id;
	private String concepto;
	private String fecha;
	private String hora;
	private String minuto;
	private int cuantia;
	
	public VentaEntity(int id, String concepto, String fecha, String hora, String minuto, int cuantia) {
		super();
		this.id = id;
		this.concepto = concepto;
		this.fecha = fecha;
		this.hora = hora;
		this.minuto = minuto;
		this.cuantia = cuantia;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getMinuto() {
		return minuto;
	}
	public void setMinuto(String minuto) {
		this.minuto = minuto;
	}
	public int getCuantia() {
		return cuantia;
	}
	public void setCuantia(int cuantia) {
		this.cuantia = cuantia;
	}
	
	

}
