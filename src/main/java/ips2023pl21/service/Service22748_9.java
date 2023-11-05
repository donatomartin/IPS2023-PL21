package ips2023pl21.service;

import ips2023pl21.persistence.Persistence;

public class Service22748_9 {
	
	private Persistence p = Persistence.getInstance();
	private CapitalFase fase;
	private int accionesVendidas;
	private int accionesRestantes;
	
	public enum CapitalFase{
		FUERA_FASE,
		FASE1,
		FASE2,
		FASE3;
	}
	
	public Service22748_9() {
		this.fase = CapitalFase.FUERA_FASE;
		accionesVendidas = 0;
	}
	
	public int getAccionesVendidas() {
		return accionesVendidas;
	}

	public void setAccionesVendidas(int accionesRestantes) {
		this.accionesVendidas = accionesRestantes;
	}
	
	public int getAccionesRestantes() {
		return accionesRestantes;
	}

	public void setAccionesRestantes(int accionesRestantes) {
		this.accionesRestantes = accionesRestantes;
	}
	
	public CapitalFase getFase() {
		return fase;
	}

	public void setFase(CapitalFase fase) {
		this.fase = fase;
	}

	public float getCapitalClub() {
		return p.getCapitalClub();
	}

	public float getPrecioPorAccion() {
		return p.getPrecioPorAccion();
	}
	
	public void insertarAmpliacion(int accionesNuevas) {
		p.insertAmpliacion(accionesNuevas);
	}
	
	public void guardarLimiteFaseUno() {
		p.updateLimiteFaseUno();
	}
}
