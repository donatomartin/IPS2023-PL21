package ips2023pl21.model.acciones;

public class Accionista {
	
	private int idAccionista;
	private String nombreAccionista;
	private String apellidoAccionista;
	private String dniAccionista;
	private String cuentaBancaria;
	private int numeroAcciones;
	private int limiteAccionesFaseUno;
	private float porcentajeCapital;
	
	public Accionista() {}

	public int getIdAccionista() {
		return idAccionista;
	}

	public void setIdAccionista(int idAccionista) {
		this.idAccionista = idAccionista;
	}

	public String getNombreAccionista() {
		return nombreAccionista;
	}

	public void setNombreAccionista(String nombreAccionista) {
		this.nombreAccionista = nombreAccionista;
	}

	public String getApellidoAccionista() {
		return apellidoAccionista;
	}

	public void setApellidoAccionista(String apellidoAccionista) {
		this.apellidoAccionista = apellidoAccionista;
	}

	public String getDniAccionista() {
		return dniAccionista;
	}

	public void setDniAccionista(String dniAccionista) {
		this.dniAccionista = dniAccionista;
	}

	public String getCuentaBancaria() {
		return cuentaBancaria;
	}

	public void setCuentaBancaria(String cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}

	public int getNumeroAcciones() {
		return numeroAcciones;
	}

	public void setNumeroAcciones(int numeroAcciones) {
		this.numeroAcciones = numeroAcciones;
	}

	public int getLimiteAccionesFaseUno() {
		return limiteAccionesFaseUno;
	}

	public void setLimiteAccionesFaseUno(int limiteAccionesFaseUno) {
		this.limiteAccionesFaseUno = limiteAccionesFaseUno;
	}

	public float getPorcentajeCapital() {
		return porcentajeCapital;
	}

	public void setPorcentajeCapital(float porcentajeCapital) {
		this.porcentajeCapital = porcentajeCapital;
	}
}
