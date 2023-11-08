package ips2023pl21.model.ventas;

public class VentaMerchandisingDisplayDto {
	private int id;
	private int idProducto;
	private int cantidad;
//	private String nombreProducto;
//	private double precioPorProducto;
//	private double cuantia;
	
	
	public VentaMerchandisingDisplayDto() {
		super();
	}
	
	public VentaMerchandisingDisplayDto(int id, int idProducto, int cantidad) {
		this.id = id;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
//		this.precioPorProducto=precioPorProducto;
//		this.cuantia = cuantia;
	}
	
	
//public VentaMerchandisingDisplayDto(int id, int idProducto, int cantidad, String nombreProducto,
//			double precioPorProducto, double cuantia) {
//		super();
//		this.id = id;
//		this.idProducto = idProducto;
//		this.cantidad = cantidad;
//		this.nombreProducto = nombreProducto;
//		this.precioPorProducto = precioPorProducto;
//		this.cuantia = cuantia;
//	}


//public String getNombreProducto() {
//	return nombreProducto;
//}
//
//public void setNombreProducto(String nombreProducto) {
//	this.nombreProducto = nombreProducto;
//}
//
//public double getPrecioPorProducto() {
//	return precioPorProducto;
//}
//
//public void setPrecioPorProducto(double precioPorProducto) {
//	this.precioPorProducto = precioPorProducto;
//}
//
//public double getCuantia() {
//	return cuantia;
//}
//
//public void setCuantia(double cuantia) {
//	this.cuantia = cuantia;
//}

	//	public String getProducto() {
//		return producto;
//	}
//	public void setProducto(String producto) {
//		this.producto = producto;
//	}
//	public double getPrecioPorProducto() {
//		return precioPorProducto;
//	}
//	public void setPrecioPorProducto(double precioPorProducto) {
//		this.precioPorProducto = precioPorProducto;
//	}
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public int getUnidades() {
//		return unidades;
//	}
//	public void setUnidades(int unidades) {
//		this.unidades = unidades;
//	}
//	public double getCuantia() {
//		return cuantia;
//	}
//	public void setCuantia(double cuantia) {
//		this.cuantia = cuantia;
//	}
	public int getId() {
		return id;
	}
	public void setId(int idVenta) {
		this.id = idVenta;
	}
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
	
}
