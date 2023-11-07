package ips2023pl21.service;

import java.util.List;

import ips2023pl21.model.equipos.EquipoDeportivo;
import ips2023pl21.model.equipos.Partido;
import ips2023pl21.persistence.Persistence;

public class Service22739 {
	
	private Persistence p = Persistence.getInstance();
	
	public List<EquipoDeportivo> getEquipos(){
		return p.selectEquipo();
	}

	public EquipoDeportivo getEquipoPorNombre(String string) {
		return p.selectEquipoPorNombre(string);
		
	}

	public void insertPartido(Partido partido) {
		p.insertPartido(partido);
		
	}

	public List<Partido> getPartidosPorEquipo(String id) {
		return p.selectPartidosPorIdEquipo(id);
	}
	
	public boolean existsIdAbonado(String id) {
		return p.existsIdAbonado(id);
	}

	public List<Partido> getPartidosNoSeleccionadosPorAbonadoYEquipo(String idAbonado,String idEquipo) {
		return p.getPartidosNoSeleccionadosPorAbonadoYEquipo(idAbonado,idEquipo);
	}
	
}
