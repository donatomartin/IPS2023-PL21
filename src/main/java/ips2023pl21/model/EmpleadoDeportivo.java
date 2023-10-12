package ips2023pl21.model;

public class EmpleadoDeportivo extends EmpleadoNoDeportivo{
	private String posicion;
	

	public EmpleadoDeportivo(int id, String nombre, String apellido, String dni, String fechaNacimiento,
			float salarioAnual, String telefono, String posicion) {
		super(id, nombre, apellido, dni, fechaNacimiento, salarioAnual, telefono);
		this.posicion = posicion;
	}
	
	public EmpleadoDeportivo() {};
	
	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

}
