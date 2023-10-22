package ips2023pl21.model;

public class Empleado {
	private int eid;
	private String nombre;
	private String apellido;
	private String dni;
	private String telefono;
	private String fechaNacimiento;
	private float salarioAnual;
	private String posicion;
	
	public Empleado() {}
	
	public int getEid() {
		return eid;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public String getDni() {
		return dni;
	}
	public String getTelefono() {
		return telefono;
	}
	public float getSalarioAnual() {
		return salarioAnual;
	}
	
	public void setEid(int eid) {
		this.eid = eid;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public void setSalarioAnual(float salario) {
		this.salarioAnual = salario;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	
	@Override
	public String toString() {
	    return String.format("%4d %-30s %s", eid, apellido + " " + nombre, dni);
	}
	
	public int[] fechaAEnteros() {
		String[] fecha = fechaNacimiento.split("-");
		int[] fechaEnteros = new int[3];
		for (int i=0; i<fecha.length;i++) {
			fechaEnteros[i] = Integer.parseInt(fecha[i]);
		}
		return fechaEnteros;
	}

}
