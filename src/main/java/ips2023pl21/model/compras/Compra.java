package ips2023pl21.model.compras;

public class Compra {
	private int id;
	private float cuantia;
	private String fecha;
	private String eid;
	
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

	public float getCuantia() {
		return cuantia;
	}

	public void setCuantia(float cuantia) {
		this.cuantia = cuantia;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getDni() {
		return eid;
	}

	public void setDni(String dni) {
		this.eid = dni;
	}

}
