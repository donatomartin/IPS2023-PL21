package ips2023pl21.service;

import java.util.List;
import java.util.stream.Collectors;

import ips2023pl21.model.Empleado;
import ips2023pl21.persistence.Persistence;

public class Service21915 {
	
	public static final int SUCCESS = 100;
	public static final int JUGADOR_NULL = 200;
	public static final int MEDIO_NULL = 300;
	public static final int CONCURRENCE_ERROR = 400;

	private Empleado empleadoSel;
	private String fechaSel;
	private String horaInicioSel = "09:00";
	private String horaFinSel = "10:00";
	public Persistence persistence = Persistence.getInstance();

	public void setFecha(String fechaSel) {
		this.fechaSel = fechaSel;
	}

	public void setHoraInicio(String horaInicioSel) {
		this.horaInicioSel = horaInicioSel;
	}

	public void setHoraFin(String horaFinSel) {
		this.horaFinSel = horaFinSel;
	}

	public List<String> getEntrevistas() {
		return persistence.selectEntrevistas().stream().map(x -> x.toString()).collect(Collectors.toList());
	}

	public List<String> getJugadoresLibresString(String filter) {
		return persistence.selectJugadoresLibres(fechaSel).stream().map(x -> x.toString())
				.filter(x -> x.toLowerCase().contains(filter.toLowerCase())).collect(Collectors.toList());
	}

	public void seleccionaEmpleado(String empleadoString) {
		int id = getIdFromString(empleadoString);
		empleadoSel = persistence.getEmpleado(id);
	}

	private int getIdFromString(String empleadoString) {
		return Integer.parseInt(empleadoString.strip().split(" ")[0]);
	}

	public String getNombreJugadorSeleccionado() {
		return empleadoSel.getNombre() + " " + empleadoSel.getApellido();
	}

	public int addEntrevista(String datosMedio) {
		
		if (empleadoSel == null)
			return Service21915.JUGADOR_NULL;

		if (datosMedio.isBlank())
			return Service21915.MEDIO_NULL;
		
		try {
			persistence.insertEntrevista(fechaSel, datosMedio, horaInicioSel, horaFinSel, empleadoSel.getEid());			
		} catch (Exception e) {
			return Service21915.CONCURRENCE_ERROR;
		}
		
		empleadoSel = null;
		
		return Service21915.SUCCESS;
	}

}
