package ips2023pl21.persistence;

import java.util.ArrayList;
import java.util.List;

import ips2023pl21.model.Entrevista;
import ips2023pl21.model.JugadorProfesional;
import ips2023pl21.util.Database;

public class Persistence {
	
	// Singleton
	private static Persistence p = new Persistence();

	private Database db = new Database();

	private Persistence() {
		db = new Database();
		db.createDatabase(false);
		db.loadDatabase();
	}
	
	public static Persistence getInstance() {
		return p;
	}

	public List<Entrevista> getEntrevistas() {
		List<Entrevista> result = db.executeQueryPojo(Entrevista.class, "select * from Entrevista");
		return result;
	}

	public List<JugadorProfesional> getJugadores() {
		return db.executeQueryPojo(JugadorProfesional.class, "select * from JugadorProfesional");
	}

	public JugadorProfesional getJugador(int id) {
		JugadorProfesional result = db.executeQueryPojo(JugadorProfesional.class,
				"select * from JugadorProfesional where eid=%d".formatted(id)).get(0);
		return result;
	}
	
	public void insertEntrevista(String fechaSel, String datosMedio, String horaInicio, String horaFin, int eid) {
		db.executeUpdate("insert into Entrevista(fechaEntrevista, datosMedio, horaInicio, horaFin, eid) values (?,?,?,?,?)", fechaSel, datosMedio, horaInicio, horaFin, eid);
	}

	public List<JugadorProfesional> getJugadoresLibres(String fechaSel) {
		
		List<Integer> idsJugadoresConEntrevista = new ArrayList<>();
		   
	    for (Entrevista entrevista : getEntrevistas()) {
	    	
	    	if (entrevista.getFechaEntrevista().equals(fechaSel))
	        	idsJugadoresConEntrevista.add(entrevista.getEid());
	        
	    }

	    List<JugadorProfesional> jugadoresLibres = new ArrayList<>();
	    
	    for (JugadorProfesional jugador : getJugadores()) {
	        if (!idsJugadoresConEntrevista.contains(jugador.getEid())) {
	            jugadoresLibres.add(jugador);
	        }
	    }

	    return jugadoresLibres;
		
	}

}
