package ips2023pl21.model;

import java.time.Year;

public class Empleado {
	
	public static int HORAS_DIARIAS_MAX = 8;
	public static int HORAS_SEMANALES_MAX = 24;
	
	private int eid;
	private String nombre;
	private String apellido;
	private String dni;
	private String telefono;
	private String fechaNacimiento;
	private float salarioAnual;
	private String tipo;
	private String posicion;

	public Empleado() {
	}

	public int getEid() {
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

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public float getSalarioAnual() {
		return salarioAnual;
	}

	public String getTipo() {
		return tipo;
	}

	public String getPosicion() {
		return posicion;
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

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public void setSalarioAnual(float salarioAnual) {
		this.salarioAnual = salarioAnual;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	@Override
	public String toString() {
		return String.format("%4d %-30s %s", eid, apellido + " " + nombre, dni);
	}

	public Object getAtributoTabla(int index) {
		switch (index) {
		case 0:
			return getNombre();
		case 1:
			return getApellido();
		case 2:
			return getDni();
		case 3:
			return getFechaNacimiento();
		default:
			return null;

		}

	}
	
	public int getEdad() {
		int año = Integer.parseInt(getFechaNacimiento().split("-")[0]);
		int añoActual = Year.now().getValue();
		
		int edad = añoActual - año;
		return edad;
	}

	public int[] fechaAEnteros() {
		String[] fecha = fechaNacimiento.split("-");
		int[] fechaEnteros = new int[3];
		for (int i = 0; i < fecha.length; i++) {
			fechaEnteros[i] = Integer.parseInt(fecha[i]);
		}
		return fechaEnteros;
	}

}
