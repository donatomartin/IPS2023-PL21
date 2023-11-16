package ips2023pl21.model.acciones;

public class AmpliacionCapital {
	
	private int idAmpliacion;
	private int faseUno;
	private int faseDos;
	private int faseTres;
	private float capitalTotal;
	private float precioAccion;
	private int accionesTotales;
	private String fase;
	private int vendidas;
	
	public AmpliacionCapital() {}

	public Integer getIdAmpliacion() {
		return idAmpliacion;
	}

	public void setIdAmpliacion(Integer idAmpliacion) {
		this.idAmpliacion = idAmpliacion;
	}

	public int getFaseUno() {
		return faseUno;
	}

	public void setFaseUno(int faseUno) {
		this.faseUno = faseUno;
	}

	public int getFaseDos() {
		return faseDos;
	}

	public void setFaseDos(int faseDos) {
		this.faseDos = faseDos;
	}

	public int getFaseTres() {
		return faseTres;
	}

	public void setFaseTres(int faseTres) {
		this.faseTres = faseTres;
	}

	public float getCapitalTotal() {
		return capitalTotal;
	}

	public void setCapitalTotal(float capitalTotal) {
		this.capitalTotal = capitalTotal;
	}

	public float getPrecioAccion() {
		return precioAccion;
	}

	public void setPrecioAccion(float precioAccion) {
		this.precioAccion = precioAccion;
	}

	public int getAccionesTotales() {
		return accionesTotales;
	}

	public void setAccionesTotales(int accionesTotales) {
		this.accionesTotales = accionesTotales;
	}

	public String getFase() {
		return fase;
	}

	public void setFase(String fase) {
		this.fase = fase;
	}

	public void setIdAmpliacion(int idAmpliacion) {
		this.idAmpliacion = idAmpliacion;
	}

	public int getVendidas() {
		return vendidas;
	}

	public void setVendidas(int vendidas) {
		this.vendidas = vendidas;
	}

}
