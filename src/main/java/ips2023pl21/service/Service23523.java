package ips2023pl21.service;

import java.util.List;

import ips2023pl21.persistence.Persistence;

public class Service23523 {

	private Persistence p = Persistence.getInstance();

	public List<String> selectIdsAbonado() {
		return p.selectIdsAbonados();
	}

	public void updateAbonadoSorteo(String id) {
		p.updateAbonadoSorteo(id);
		
	}
}
