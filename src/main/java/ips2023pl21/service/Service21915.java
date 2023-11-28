package ips2023pl21.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import ips2023pl21.model.Empleado;
import ips2023pl21.model.horarios.HorarioEntrevista;
import ips2023pl21.persistence.Persistence;
import ips2023pl21.util.Util;

public class Service21915 {
	
	public static final int JUGADOR_NULL = 200;
	public static final int MEDIO_NULL = 300;
	public static final int CONCURRENCE_ERROR = 400;

	private Empleado empleado;
	private String fecha;
	private String horaInicio = "09:00";
	private String horaFin = "10:00";
	public Persistence persistence = Persistence.getInstance();

	public void setFecha(Date fecha) {
		this.fecha = Util.dateToIsoString(fecha);
	}

	public void setHoraInicio(String horaInicioSel) {
		this.horaInicio = horaInicioSel;
	}

	public void setHoraFin(String horaFinSel) {
		this.horaFin = horaFinSel;
	}

	public List<String> getEntrevistas() {
		return persistence.selectHorariosEntrevistasAsignados().stream().map(x -> x.toString()).collect(Collectors.toList());
	}
	
	public List<HorarioEntrevista> getFranjasNoAsignadas() {
		return persistence.selectHorariosEntrevistasNoAsignados();
	}

	public List<String> getJugadoresLibresString(String filter) {
		return persistence.selectJugadoresLibres(fecha).stream().map(x -> x.jugadorToString())
				.filter(x -> x.toLowerCase().contains(filter.toLowerCase())).collect(Collectors.toList());
	}

	public void seleccionaEmpleado(String empleadoString) {
		int id = getIdFromString(empleadoString);
		empleado = persistence.getEmpleado(id);
	}

	private int getIdFromString(String empleadoString) {
		return Integer.parseInt(empleadoString.strip().split(" ")[0]);
	}

	public String getNombreJugadorSeleccionado() {
		return empleado.getNombre() + " " + empleado.getApellido();
	}

	public State addEntrevista() {
		
		if (empleado == null)
			return State.EMPLEADONULL;
		
		if (persistence.existeEntrevista(fecha, empleado.getEid()))
			return State.DIAOCUPADO;
		
		try {
			persistence.insertHorarioEntrevista(fecha, horaInicio, horaFin, empleado.getEid());			
		} 
		catch (IllegalStateException ise) {
			return State.INTERFIEREENTRENAMIENTO;
		}
		catch (Exception e) {
			return State.DBERROR;
		}
				
		return State.SUCCESS;
	}

	public State asignaEntrevista(HorarioEntrevista he, String datosMedio) {
		if (he == null)
			return State.FRANJANULL;
		if (datosMedio == null || datosMedio.isBlank())
			return State.MEDIONULL;
		if (empleado == null)
			return State.EMPLEADONULL;
		try {
			persistence.asignaHorarioEntrevista(he, datosMedio);			
		} 
		catch (Exception e) {
			return State.DBERROR;
		}
		
		return State.SUCCESS;
	}

}
