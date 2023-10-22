package ips2023pl21.model;

public class Empleado {
	private int id;
	private String nombre;
	private String apellido;
	private String dni;
	private String telefono;
	private String fechaNacimiento;
	private float salarioAnual;
	
	
	public Empleado(int id, String nombre, String apellido, String dni, String fechaNacimiento,
			float salarioAnual, String telefono) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
		this.salarioAnual = salarioAnual;
	}
	
	public Empleado() {}
	
	
	public int getId() {
		return id;
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


	public void setId(int id) {
		this.id = id;
	}


	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	
}
