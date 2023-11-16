package ips2023pl21.service;

import java.util.List;

import ips2023pl21.model.Empleado;
import ips2023pl21.model.equipos.Equipo;
import ips2023pl21.persistence.Persistence;

public class Service23558 {
	
	private Persistence p;
	
	public Service23558() {
		p = Persistence.getInstance();
	}
	
	public List<Equipo> getEquipos(){
		return p.selectAllEquipos();
	}

	public List<Empleado> getJugadoresEquipo(String eqid) {
		return p.selectJugadoresPorEquipo(eqid);
	}

	public boolean isLesionado(int eid) {
		List<Empleado> list = p.selectLesionado(eid);
		if (list.isEmpty()) {
			return false;
		}
		return true;
	}

}
