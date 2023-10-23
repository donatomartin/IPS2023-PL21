package ips2023pl21.model.empleados;

import java.time.Year;

public class EmpleadoDeportivo extends Empleado {
	
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

	public Object getAtributoTabla(int index) {
		switch(index) {
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
		int año = Integer.parseInt(getFechaNacimiento().split("-")[0]) ;	
		int añoActual = Year.now().getValue();
		
		int edad = añoActual - año;
		
		return edad;
	}

	@Override
	public String toString() {
		return getNombre() + ", " + getApellido() + ", " + getDni();
	}

}