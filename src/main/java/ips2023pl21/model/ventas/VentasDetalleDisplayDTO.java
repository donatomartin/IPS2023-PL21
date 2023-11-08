package ips2023pl21.model.ventas;

public class VentasDetalleDisplayDTO {
	private int id;
	private String nombre;
	private int unidades;
	private double precioPorProducto;
	private double total; //precio
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getUnidades() {
		return unidades;
	}
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	public double getPrecioPorProducto() {
		return precioPorProducto;
	}
	public void setPrecioPorProducto(double precioPorProducto) {
		this.precioPorProducto = precioPorProducto;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public VentasDetalleDisplayDTO(int id, String nombre, int unidades, double precioPorProducto, double total) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.unidades = unidades;
		this.precioPorProducto = precioPorProducto;
		this.total = total;
	}
	public VentasDetalleDisplayDTO() {
		super();
	}
	
	

}
