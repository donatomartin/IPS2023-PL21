package ips2023pl21.tienda;

public class Merchandaising {

	private String nombre;
	private String tipo;
	private int precio;
	private int unidades;
	
	public Merchandaising(String nombre, String tipo, int precio) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.precio = precio;
		this.unidades = 0;
	}

	public String getNombre() {
		return nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public int getPrecio() {
		return precio;
	}
	
	public int getUnidades() {
		return this.unidades;
	}
	
	public void actualizarUnidades(int añadir) {
		this.unidades = this.unidades + añadir;
	}
	
	public void setUnidades(int un) {
		this.unidades = un;
	}
	
	public int getPrecioTotalArticulo() {
		return this.precio*this.unidades;
	}

	@Override
	public String toString() {
		return "Nombre: " + nombre + ", Tipo: " + tipo + ", Precio: " + precio + ", Unidades: " + unidades;
	}
}
