package ips2023pl21.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import ips2023pl21.model.Empleado;
import ips2023pl21.model.compras.JugadoresEnVenta;
import ips2023pl21.model.equipos.Equipo;
import ips2023pl21.persistence.Persistence;
import ips2023pl21.util.Util;

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

	public void setCompra(String dni) {
		this.compra = p.selectJugadorEnVentaByDni(dni);
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

	public int getNumJugadoresEquipo(int id) {
		return p.selectNumJugadoresByEquipo(id);
	}

	public List<JugadoresEnVenta> getJugadoresEnVenta() {
		return p.selectJugadoresEnVenta();
	}

	public List<Empleado> getJugadoresEquipo() {
		return p.selectJugadoresByEquipo(equipo.getId());
	}

	public void eliminarJugadorEnVenta() {
		p.deleteJugadorEnVenta(compra.getDni());
	}

	public void añadirEmpleado(float salario) {
		p.insertarEmpleado(compra.getNombre(), compra.getApellido(), 
				compra.getDni(), compra.getFechaNacimiento(), salario, compra.getTelefono(),
				"deportivo", "jugador");
	}

	public void añadirJuega() {
		p.insertJuega(equipo.getId(), compra.getDni());
	}

	public void añadirCompra() {
		LocalDateTime fechaActual = LocalDateTime.now();
		Date d = Date.from(fechaActual.atZone(ZoneId.systemDefault()).toInstant());
		float cuantia = compra.getPrecio();
		String dni = compra.getDni();
		p.insertCompra(d, cuantia, dni);
	}

	public void eliminarEmpleado(int eid) {
		p.deleteEmpleadoById(eid);
	}

	public void eliminarJuega(int eid) {
		p.deleteJuega(eid);
	}

	public void añadirVenta(float precio) {
		LocalDateTime fechaActual = LocalDateTime.now();
		Date d = Date.from(fechaActual.atZone(ZoneId.systemDefault()).toInstant());
		String fecha = Util.dateToIsoString(d);
		int horaVenta = fechaActual.getHour();
		int minutoventa = fechaActual.getMinute();
		
		p.insertarVentaJugador
		(fecha, horaVenta, minutoventa, precio);
	}

	public void eliminarHorarioEntrevista(int eid) {
		p.deleteHorarioEntrevistaById(eid);
	}

	public void eliminarHorarioEntrenamiento(int id) {
		String eid = String.valueOf(id);
		p.deleteLesionado(eid);
	}

	public void eliminarActualizacion(int eid) {
		p.deleteActualizaciones(eid);
	}
	
}
