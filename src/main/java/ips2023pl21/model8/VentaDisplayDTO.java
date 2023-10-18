package ips2023pl21.model8;

public class VentaDisplayDTO {
	private int id;
	private String concepto;
	private String fecha;
	private String hora;
	private String minuto;
	private double cuantia;
	
	public VentaDisplayDTO(int id,String rowConcepto, String rowFecha, String rowHora,String rowMinuto, double rowCuantia) {
		this.id=id;
		this.concepto=rowConcepto;
		this.fecha=rowFecha;
		this.hora=rowHora;
		this.minuto=rowMinuto;
		this.cuantia=rowCuantia;
	}
	
	


	public VentaDisplayDTO() {
		super();
	}



	public int getId() { return this.id; }
	public String getConcepto() { return this.concepto; }
	public String getFecha() { return this.fecha; }
	public String getHora() { return this.hora; }
	public String getMinuto() {return this.minuto;}
	public double getCuantia() {return this.cuantia;}
	public void setId(int id) { this.id=id; }
	public void setConcepto(String value) { this.concepto=value; }
	public void setFecha(String value) { this.fecha=value; }
	public void setHora(String value) { this.hora=value; }
	public void setMinuto(String value) { this.minuto=value; }
	public void setCuantia(double value) { this.cuantia=value; }
	

}
