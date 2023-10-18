package ips2023pl21.model;

public class EmpleadoNoDeportivo implements Empleado{
	private Integer eid;
	private String nombre;
	private String apellido;
	private String dni;
	private String telefono;
	private String fechaNacimiento;
	private float salarioAnual;
	private String posicion;
	
	
	public EmpleadoNoDeportivo(int id, String nombre, String apellido, String dni, String fechaNacimiento,
			float salarioAnual, String telefono, String posicion) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
		this.salarioAnual = salarioAnual;
		this.posicion = posicion;
	}
	
	public EmpleadoNoDeportivo() {}
	


	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public Integer getId() {
		return eid;
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
	
	public String getPosicion(){
		return this.posicion;
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

	public void setId(Integer id) {
	this.eid = id;
}
	
	public void setPosicion(String pos) {
		this.posicion = pos;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
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
