package ips2023pl21.service;

import java.util.List;

import ips2023pl21.model.activos.*;
import ips2023pl21.model.equipos.*;
import ips2023pl21.persistence.Persistence;
import ips2023pl21.util.PDFGenerator;

public class Service21914_16 {

	private Persistence p = Persistence.getInstance();
	
	public void añadirEquipo(EquipoDeportivo equipoDeportivo) {
		p.insertEquipo(equipoDeportivo);
		
	}
	
	public List<Merchandaising> cargarArticulos(){
		return p.selectArticulos();
	}
	
	public void añadirVenta(TiendaLogica tl) {
		p.insertVenta(tl);
		PDFGenerator.generarPDF(tl);
	}

	public boolean isGanadorSorteo(int idAbonado) {
		return p.isGanadorSorteo(idAbonado);
	}

	public void deleteGanadorAbonado(String idAbonado) {
		p.deleteGanadorAbonado(idAbonado);
		
	}

}
