package ips2023pl21.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import ips2023pl21.model.Empleado;
import ips2023pl21.model.compras.Compra;
import ips2023pl21.model.ventas.VentaDisplayDTO;
import ips2023pl21.persistence.Persistence;
import ips2023pl21.util.Util;

public class Service23539 {
	private Persistence p = Persistence.getInstance();
	private double ganancias;
	private double perdidas;
	private String min;
	private String max;
	
	public Service23539() {
		
		
	}
	
	private void calcularFecha(String date) {
	String[]parts=date.split("-");
	this.min=date;
	this.max=parts[0]+"-"+parts[1]+"-31";
	}

	public double calcularGanancias(String date) {
		calcularFecha(date);
		ganancias=0;
		List<VentaDisplayDTO> ventas=p.getVentasByDate(min, max);
		for(VentaDisplayDTO v: ventas) {
			ganancias+=v.getCuantia();
		}
		return ganancias;
	}
	
	public double calcularPerdidas(String date) {
		calcularFecha(date);
		perdidas=0;
		List<Compra> compras=p.getComprasByDate(min,max);
		for(Compra c:compras) {
			perdidas+=c.getCuantia();
		}
		Date d=Util.isoStringToDate(max);
		LocalDate ld=d.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		if(ld.minusDays(1).isBefore(LocalDate.now())) {
			List<Empleado> empleados=p.getEmpleados();
			for(Empleado e:empleados) {
				perdidas+=e.getSalarioAnual()/12.0;
			}
		}
		
		return perdidas;
	}
	
	public double getBalance() {
		return ganancias-perdidas;
	}

	public List<VentaDisplayDTO> getTotalVentas(){
		return p.getTotalVentas();
	}

	public List<Compra> getTotalCompras() {
		return p.getTotalCompras();
	}
	
}
