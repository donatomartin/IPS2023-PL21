package ips2023pl21.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import ips2023pl21.model.abonos.Abono;
import ips2023pl21.model.entradas.EntradaEntity;
import ips2023pl21.persistence.Persistence;
import ips2023pl21.util.Database;
import ips2023pl21.util.UnexpectedException;
import ips2023pl21.util.Util;

public class Service22733 {
	
	public Persistence p = Persistence.getInstance();
	

	public boolean comprar(String tribuna, String seccion, int fila, int asiento, String fechaNacimiento, String
			nombre) {
		if(comprobarDisponibilidad(tribuna, seccion, fila, asiento)) {
			LocalDate localDate=LocalDate.now();
			int year=Integer.valueOf(fechaNacimiento.split("-")[0]);
			int currentYear=localDate.getYear();
			double precio=30;
			switch(tribuna) {
			case "A":
				precio=100;
				break;
			case "B":
				precio=200;
				break;
			case "C":
				precio=150;
				break;
			case "D":
				precio=300;
				break;
			}
			if(currentYear-year>=65 || currentYear-year<=18) { 
				precio-=precio*0.33; 
			}
			try {
				String dateString=currentYear+1+"-06-30";
				p.insertAbono(tribuna, seccion, fila, asiento, precio, dateString);
//			
				//insertar en abonado
				p.insertAbonado(nombre);
				return true;
				
			}catch(UnexpectedException e) {
				e.printStackTrace();
			}
		}
		return false;
		
		
	}

	private boolean comprobarDisponibilidad(String tribuna, String seccion, int fila, int asiento) {
		List<Abono> abonos=p.selectAbono(tribuna, seccion, fila, asiento);
		if(abonos.isEmpty()) {
			return true;
		}else {
			Abono abono=abonos.get(0);
			if(Util.isoStringToDate(abono.getFechaCaducidad()).before(new Date())) { 
				//borrar el abono que no sirve
				p.borrarAbonado(tribuna, seccion, fila, asiento);
				return true;
			}
			return false;
		}
	}

	public List<EntradaEntity> getAsientosOcupados(String tribuna, String seccion) {
		return p.getAsientosOcupados(tribuna, seccion);
	}

	public int getIdAbonado() {
		return (Integer)(p.getIdAbonado().get(0)[0]);
	}
	

}
