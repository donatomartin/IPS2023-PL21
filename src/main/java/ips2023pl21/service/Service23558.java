package ips2023pl21.service;

import java.util.List;

import ips2023pl21.model.Empleado;
import ips2023pl21.model.equipos.Equipo;
import ips2023pl21.model.horarios.HorarioEntrenamiento;
import ips2023pl21.persistence.Persistence;

public class Service23558 {
	
	private Persistence p;
	private Empleado lesionado;
	
	public Service23558() {
		p = Persistence.getInstance();
	}
	
	public Empleado getLesionado() {
		return lesionado;
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

	public void eliminarLesionado(String eid) {
		p.deleteLesionado(eid);
	}

	public void setLesionado(String eid) {
		lesionado = p.getEmpleado(Integer.parseInt(eid));
	}

	public List<HorarioEntrenamiento> getEntrenamientos(String equipoId) {
		return p.getEntrenamientos(equipoId);
	}

}
