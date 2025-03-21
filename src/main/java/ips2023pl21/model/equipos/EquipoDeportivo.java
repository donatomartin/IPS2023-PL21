package ips2023pl21.model.equipos;

import java.util.ArrayList;
import java.util.List;
import ips2023pl21.model.Empleado;
import ips2023pl21.persistence.Persistence;

public class EquipoDeportivo {

	public static final int MIN_JUGADORES = 7;

	private Persistence p = Persistence.getInstance();

	private String id;
	private String nombre;
	private Empleado primerEntrenador;
	private Empleado segundoEntrenador;
	private List<Empleado> jugadoresEquipo = new ArrayList<Empleado>();
	
	public EquipoDeportivo() {	
	}

	public String getId() {
		return this.id;
	}
	
	public List<Empleado> getEntrenadores() {
		return p.selectEntrenadores();
	}

	public Empleado getEntrenador(int index) {
		return getEntrenadores().get(index);
	}

	public List<Empleado> getJugadores() {
		return p.selectJugadores();
	}

	public Empleado getJugador(int index) {
		return getJugadores().get(index);
	}

	public Empleado getPrimerEntrenador() {
		return this.primerEntrenador;
	}

	public void setPrimerEntrenador(Empleado pE) {
		this.primerEntrenador = pE;
	}

	public void setSegundoEntrenador(Empleado sE) {
		this.segundoEntrenador = sE;
	}

	public Empleado getSegundoEntrenador() {
		return this.segundoEntrenador;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public List<Partido> getPartidos(){
		return p.selectPartidosPorIdEquipo(this.id);
	}

	public boolean añadirJugador(Empleado j) {
		if (isJugadorValid(j)) {
			return jugadoresEquipo.add(j);

		}

		return false;
	}

	private boolean isJugadorValid(Empleado j) {
		if (this instanceof EquipoProfesional) {
			return true;
		} else {
			int edadMax = ((EquipoEnFormacion) this).getEdadMaximaPorCategoria();
			int edad = j.getEdad();
			if (edad > edadMax) {
				return false;
			} else {
				return true;
			}
		}

	}

	public List<Empleado> getJugadoresEquipo() {
		return jugadoresEquipo;
	}

	public void eliminarJugador(int index) {
		jugadoresEquipo.remove(index);

	}

	public void eliminarTodosLosJugadores() {
		jugadoresEquipo.clear();
	}

	public void añadirEquipo() {
		p.insertEquipo(this);
	}

	public void setId(String id) {
		this.id = id;
		
	}
	
}
