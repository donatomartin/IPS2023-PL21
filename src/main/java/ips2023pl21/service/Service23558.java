package ips2023pl21.service;

import java.util.List;

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

}
