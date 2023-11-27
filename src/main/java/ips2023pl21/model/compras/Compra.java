package ips2023pl21.model.compras;

public class Compra {
	private int id;
	private int cuantia;
	private String fecha;
	
	public Compra() {
		super();
	}
	
	public Compra(int id, int cuantia, String fecha) {
		super();
		this.id = id;
		this.cuantia = cuantia;
		this.fecha = fecha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCuantia() {
		return cuantia;
	}

	public void setCuantia(int cuantia) {
		this.cuantia = cuantia;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	

}
