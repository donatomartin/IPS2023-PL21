package ips2023pl21.model8;

public class VentaMerchandisingDisplayDto {
	private int id;
	private String producto;
	private int unidades;
	private double precioPorProducto;
	private double cuantia;
	
	
	public VentaMerchandisingDisplayDto() {
		super();
	}
	public VentaMerchandisingDisplayDto(int id, String nombreProducto, int unidades,double precioPorProducto, double cuantia) {
		this.id = id;
		this.producto = nombreProducto;
		this.unidades = unidades;
		this.precioPorProducto=precioPorProducto;
		this.cuantia = cuantia;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public double getPrecioPorProducto() {
		return precioPorProducto;
	}
	public void setPrecioPorProducto(double precioPorProducto) {
		this.precioPorProducto = precioPorProducto;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUnidades() {
		return unidades;
	}
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	public double getCuantia() {
		return cuantia;
	}
	public void setCuantia(double cuantia) {
		this.cuantia = cuantia;
	}
	
}
