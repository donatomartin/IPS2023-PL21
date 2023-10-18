package ips2023pl21.model;

public interface Empleado {

	Integer getId();
	String getFechaNacimiento();
	String getNombre();
	String getApellido();
	String getDni();
	String getTelefono();
	float getSalarioAnual();
	String getPosicion();
	void setNombre(String nombre);
	void setApellido(String apellido);
	void setDni(String dni);
	void setTelefono(String telefono);
	void setSalarioAnual(float salario);
	public void setFechaNacimiento(String fechaNacimiento);
	void setPosicion(String pos);
	void setId(Integer id);
	int[] fechaAEnteros();
	String toString();
}
