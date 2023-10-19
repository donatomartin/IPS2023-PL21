package ips2023pl21.p21915.model;

public class Empleado {
	private int eid;
	private String nombre;
	private String apellido;
	private String dni;
	private String telefono;
	private String fechaNacimiento;
	private float salarioAnual;
	
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
	
	@Override
	public String toString() {
	    return String.format("%4d %-30s %s", eid, apellido + " " + nombre, dni);
	}

}
