package ips2023pl21.model.equipos;

import java.util.ArrayList;
import java.util.List;

import ips2023pl21.model.empleados.EmpleadoDeportivo;
import ips2023pl21.service.Service21914_16;

public class EquipoDeportivo {
	
	public static final int MIN_JUGADORES  = 7;
	
	private List<EmpleadoDeportivo> entrenadores = new ArrayList<EmpleadoDeportivo>();
	private List<EmpleadoDeportivo> jugadores = new ArrayList<EmpleadoDeportivo>();

	private EmpleadoDeportivo primerEntrenador;
	private EmpleadoDeportivo segundoEntrenador;
	private List<EmpleadoDeportivo> jugadoresEquipo = new ArrayList<EmpleadoDeportivo>();
	
	
	public EquipoDeportivo() {
		this.primerEntrenador = null;
		this.segundoEntrenador = null;
		
		entrenadores = Service21914_16.cargarEmpleadosDeportivos("entrenador");
		jugadores = Service21914_16.cargarEmpleadosDeportivos("jugador");
	}
	
	public List<EmpleadoDeportivo> getEntrenadoresTabla() {
		return entrenadores;
	}
	
	public EmpleadoDeportivo getEntrenador(int index) {
		return entrenadores.get(index);
	}
	
	public List<EmpleadoDeportivo> getJugadoresTabla() {
		return jugadores;
	}
	
	public EmpleadoDeportivo getJugador(int index) {
		return jugadores.get(index);
	}
	
	public EmpleadoDeportivo getPrimerEntrenador() {
		return this.primerEntrenador;
	}
	public void setPrimerEntrenador(EmpleadoDeportivo pE) {
		this.primerEntrenador = pE;
	}
	
	public void setSegundoEntrenador(EmpleadoDeportivo sE) {
		this.segundoEntrenador = sE;
	}
	public EmpleadoDeportivo getSegundoEntrenador() {
		return this.segundoEntrenador;
	}
	
	public boolean añadirJugador(EmpleadoDeportivo j) {
		if(isJugadorValid(j)) {
			return jugadoresEquipo.add(j);
			
		}
		
		return false;
	}
	private boolean isJugadorValid(EmpleadoDeportivo j) {
		if(this instanceof EquipoProfesional) {
			return true;
		} else {
			int edadMax = ((EquipoEnFormacion)this).getEdadMaximaPorCategoria();
			int edad = j.getEdad();
			if(edad > edadMax) {
				return false;
			} else {
				return true;
			}
		}
		
	}

	public List<EmpleadoDeportivo> getJugadoresEquipo(){
		return new ArrayList<EmpleadoDeportivo>(jugadoresEquipo);
	}
	
	public void eliminarJugador(int index) {
		jugadoresEquipo.remove(index);
		
	}
	
	public void eliminarTodosLosJugadores() {
		jugadoresEquipo.clear();
	}

	public void añadirEquipo() {
		Service21914_16.añadirEquipo(this);
	}
	
	
	
}
