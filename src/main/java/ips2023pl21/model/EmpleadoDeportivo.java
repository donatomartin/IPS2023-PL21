package ips2023pl21.model;

public class EmpleadoDeportivo implements Empleado{
	private String nombre;
	private String apellido;
	private String dni;
	private String telefono;
	private String fechaNacimiento;
	private float salarioAnual;
	private String posicion;
	

	public EmpleadoDeportivo(String nombre, String apellido, String dni, String fechaNacimiento,
			float salarioAnual, String telefono, String posicion) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
		this.salarioAnual = salarioAnual;
		this.posicion = posicion;
	}
	
	public EmpleadoDeportivo() {};
	
	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	
	public String getApellido() {
		return apellido;
	}

	@Override
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public String getDni() {
		return dni;
	}

	@Override
	public String getTelefono() {
		return telefono;
	}

	@Override
	public float getSalarioAnual() {
		return salarioAnual;
	}

	@Override
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Override
	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public void setSalarioAnual(float salario) {
		this.salarioAnual = salario;
	}

	@Override
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public int[] fechaAEnteros() {
		String[] fecha = fechaNacimiento.split("-");
		int[] fechaEnteros = new int[3];
		for (int i=0; i<fecha.length;i++) {
			fechaEnteros[i] = Integer.parseInt(fecha[i]);
		}
		return fechaEnteros;
	}
	
	public String toString() {
		return (this.nombre + " - "+ this.apellido+" - "+this.dni);
	}

}
