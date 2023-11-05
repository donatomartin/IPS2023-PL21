package ips2023pl21.service;

import java.util.List;

import ips2023pl21.model.equipos.EquipoDeportivo;
import ips2023pl21.persistence.Persistence;

public class Service22739 {
	
	private Persistence p = Persistence.getInstance();
	
	public List<EquipoDeportivo> getEquipos(){
		return p.selectEquipo();
	}

	public EquipoDeportivo getEquipoPorNombre(String string) {
		return p.selectEquipoByNombre(string).get(0);
	}
	
	
	
	
}
