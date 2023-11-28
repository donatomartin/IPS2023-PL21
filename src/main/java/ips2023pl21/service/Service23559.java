package ips2023pl21.service;

import java.util.List;

import ips2023pl21.model.compras.JugadoresEnVenta;
import ips2023pl21.model.equipos.Equipo;
import ips2023pl21.persistence.Persistence;

public class Service23559 {

	private Persistence p;
	private JugadoresEnVenta compra;
	private Equipo equipo;
	
	public Service23559() {
		p = Persistence.getInstance();
	}

	public JugadoresEnVenta getCompra() {
		return compra;
	}

	public void setCompra(JugadoresEnVenta compra) {
		this.compra = compra;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(int id) {
		this.equipo = p.selectEquipoById(id);
	}

	public List<Equipo> getEquipos() {
		return p.selectAllEquipos();
	}

	public int getJugadoresEquipo(int id) {
		return p.selectJugadoresByEquipo(id);
	}

	public List<JugadoresEnVenta> getJugadoresEnVenta() {
		return p.selectJugadoresEnVenta();
	}
	
}
