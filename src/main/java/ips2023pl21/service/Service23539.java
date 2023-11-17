package ips2023pl21.service;

import java.util.Date;
import java.util.List;

import ips2023pl21.model.ventas.VentaDisplayDTO;
import ips2023pl21.persistence.Persistence;
import ips2023pl21.util.Util;

public class Service23539 {
	private Persistence p = Persistence.getInstance();
	private double ganancias;
	private double perdidas;
	private Date min;
	private Date max;
	
	public Service23539(Date date) {
		int year=date.getYear();
		int month=date.getMonth();
		this.min=Util.isoStringToDate(year+"-"+month+"-01");
		this.max=Util.isoStringToDate(year+"-"+month+"-31");
	}

	public void calcularGanancias(Date date) {
		ganancias=0;
		List<VentaDisplayDTO> ventas=p.getVentasByDate(min, max);
		for(VentaDisplayDTO v: ventas) {
			ganancias+=v.getCuantia();
		}
	}
	
	public void calcularPerdidas() {
		perdidas=0;
		//TODO : hacer tabla compras y meter ahi las iyecciones de capital y la compra de jugadoress
	}
	
	public double getBalance() {
		return ganancias-perdidas;
	}

	public double getGanancias() {
		return ganancias;
	}
}
