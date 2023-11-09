package ips2023pl21.model.acciones;

public class Accion {
	
	private int idAccion;
	private int idAccionista;
	private float precioCompra;
	private int enVenta;
	private float precioVenta;
	
	public Accion(){}

	public int getIdAccion() {
		return idAccion;
	}

	public void setIdAccion(int idAccion) {
		this.idAccion = idAccion;
	}

	public int getIdAccionista() {
		return idAccionista;
	}

	public void setIdAccionista(int idAccionista) {
		this.idAccionista = idAccionista;
	}

	public float getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(float precioCompra) {
		this.precioCompra = precioCompra;
	}

	public int getEnVenta() {
		return enVenta;
	}

	public void setEnVenta(int enVenta) {
		this.enVenta = enVenta;
	}

	public float getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(float precioVenta) {
		this.precioVenta = precioVenta;
	}
	
}
