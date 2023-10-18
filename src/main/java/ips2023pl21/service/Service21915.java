package ips2023pl21.service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ips2023pl21.model.Entrevista;
import ips2023pl21.model.JugadorProfesional;
import ips2023pl21.util.Database;
import ips2023pl21.util.Util;

public class Service21915 {

	private JugadorProfesional jugadorSel;
	private String fechaSel;
	private String horaInicioSel = "09:00";
	private String horaFinSel = "10:00";
	public static Database db;

	public Service21915() {
		db = new Database();
		db.createDatabase(false);
		db.loadDatabase();
	}
	
	public void setFecha(String fechaSel) {
		this.fechaSel = fechaSel;
	}
	
	public void setHoraInicio(String horaInicioSel) {
		this.horaInicioSel = horaInicioSel;
	}
	
	public void setHoraFin(String horaFinSel) {
		this.horaFinSel = horaFinSel;
	}
	
	public List<Entrevista> getEntrevistas() {
		List<Entrevista> result = db.executeQueryPojo(Entrevista.class, "select * from Entrevista");
		return result;
	}
	
	public List<String> getEntrevistasString() {
		return getEntrevistas().stream().map(x -> x.toString()).collect(Collectors.toList());
	}

	public List<JugadorProfesional> getJugadoresLibres() {
		
		LocalTime horaInicio = Util.stringHoraToLocalTime(horaInicioSel);
		LocalTime horaFin = Util.stringHoraToLocalTime(horaFinSel);
		
	    // Obtén todos los jugadores
	    List<JugadorProfesional> todosLosJugadores = getJugadores();

	    // Obtén todas las entrevistas
	    List<Entrevista> todasLasEntrevistas = getEntrevistas();

	    // Crea una lista para almacenar los IDs de los jugadores que tienen entrevistas
	    List<Integer> idsJugadoresConEntrevista = new ArrayList<>();

	    
	    // Crea una lista para almacenar los jugadores libres
	    List<JugadorProfesional> jugadoresLibres = new ArrayList<>();
	    
	    // Recorre todas las entrevistas y agrega los IDs de los jugadores a la lista
	    for (Entrevista entrevista : todasLasEntrevistas) {
	        // Comprueba si la franja horaria seleccionada se solapa con la de la entrevista
	        if (solapa(horaInicio, horaFin, entrevista)) {
	            return jugadoresLibres;
	        }
	        
	    }

	    // Recorre todos los jugadores y agrega a la lista aquellos que no tienen entrevistas
	    for (JugadorProfesional jugador : todosLosJugadores) {
	        if (!idsJugadoresConEntrevista.contains(jugador.getEid())) {
	            jugadoresLibres.add(jugador);
	        }
	    }

	    return jugadoresLibres;
	    
	}

	private boolean solapa(LocalTime horaInicio, LocalTime horaFin, Entrevista entrevista) {
	    return entrevista.getFechaEntrevista().equals(fechaSel) &&
	        ((horaInicio.isAfter(entrevista.getHoraInicioParsed()) && horaInicio.isBefore(entrevista.getHoraFinParsed())) ||
	         (horaFin.isAfter(entrevista.getHoraInicioParsed()) && horaFin.isBefore(entrevista.getHoraFinParsed())) ||
	         (horaInicio.isBefore(entrevista.getHoraInicioParsed()) && horaFin.isAfter(entrevista.getHoraFinParsed())) ||
	         (horaInicio.equals(entrevista.getHoraInicioParsed()) || horaInicio.equals(entrevista.getHoraFinParsed())) ||
	         (horaFin.equals(entrevista.getHoraInicioParsed()) || horaFin.equals(entrevista.getHoraFinParsed())));
	}

	private List<JugadorProfesional> getJugadores() {
		return db.executeQueryPojo(JugadorProfesional.class, "select * from JugadorProfesional");
	}


	public List<String> getJugadoresLibresString(String filter) {
		return getJugadoresLibres().stream().map(x -> x.toString())
				.filter(x -> x.toLowerCase().contains(filter.toLowerCase())).collect(Collectors.toList());
	}

	public static JugadorProfesional getJugador(int id) {
		JugadorProfesional result = db
				.executeQueryPojo(JugadorProfesional.class, "select * from JugadorProfesional where eid=%d".formatted(id)).get(0);
		return result;
	}

	public void seleccionaEmpleado(String empleadoString) {
		int id = getIdFromString(empleadoString);
		jugadorSel = getJugador(id);
	}

	private int getIdFromString(String empleadoString) {
		return Integer.parseInt(empleadoString.strip().split(" ")[0]);
	}

	public String getNombreEmpleadoSeleccionado() {
		return jugadorSel.getNombre() + " " + jugadorSel.getApellido();
	}
	
	public int addEntrevista(String datosMedio, String horaInicio, String horaFin) {
		if (jugadorSel == null)
			return 1; // JUGADOR NULL
		
		if (datosMedio.isBlank())
			return 2; // NO HAY MEDIo
		
		try {
			db.executeUpdate("insert into Entrevista(fechaEntrevista, datosMedio, horaInicio, horaFin, eid) values (?,?,?,?,?)", fechaSel, datosMedio, horaInicio, horaFin, jugadorSel.getEid());			
		} catch (Exception e) {
			e.printStackTrace();
			return 3; // PRIMARY KEY ERROR
		}
		
		jugadorSel = null;
		return 0;
	}
	
	public int addEntrevista(String datosMedio) {
		return addEntrevista(datosMedio, horaInicioSel, horaFinSel);
	}
	
}
