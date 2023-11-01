package ips2023pl21.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import ips2023pl21.model.abonos.Abono;
import ips2023pl21.persistence.Persistence;
import ips2023pl21.model.entradas.EntradaEntity;
import ips2023pl21.util.UnexpectedException;
import ips2023pl21.util.Util;

public class Service22733 {
	
	private Abono abonoModel;
	public Persistence p = Persistence.getInstance();
	
	public Service22733() {
		
	}

	public boolean comprar(String tribuna, String seccion, int fila, int asiento, String fechaNacimiento) {
		if(comprobarDisponibilidad(tribuna, seccion, fila, asiento)) {
			Date date=Util.isoStringToDate(fechaNacimiento);
			LocalDate localDate=LocalDate.now();
			int year=date.getYear();
			int currentYear=localDate.getYear();
			double precio=30;
			switch(tribuna) {
			case "A":
				precio+=100;
				break;
			case "B":
				precio+=200;
				break;
			case "C":
				precio+=150;
				break;
			case "D":
				precio+=300;
				break;
			}
			if(currentYear-year>=65 || currentYear-year<=18) { 
				precio-=precio*0.33; 
			}
			try {
				String dateString=currentYear+1+"-06-30";
				p.insertAbono(tribuna, seccion, fila, asiento, precio, dateString);
				System.out.println("Entrada insertada: "+tribuna+seccion+fila+asiento+ " fecha:"+dateString);
				return true;
			}catch(UnexpectedException e) {
				e.printStackTrace();
			}
		}
		return false;
		
		
	}

	private boolean comprobarDisponibilidad(String tribuna, String seccion, int fila, int asiento) {
		List<Abono> abonos=p.selectAbono(tribuna, seccion, fila, asiento);
		System.out.println("Imprimiento abono:");
//		for(Abono a : abonos) {
//			System.out.println(a.getTribuna()+a.getSeccion()+a.getFila()+a.getAsiento());
//		}
		if(abonos.isEmpty()) {
			return true;
		}else {
			Abono abono=abonos.get(0);
//			String date=Util.dateToIsoString(new Date());
//			System.out.println(Util.dateToIsoString(new Date()));
			if(Util.isoStringToDate(abono.getFechaCaducidad()).before(new Date())) { 
				//borrar el abono que no sirve
				return true;
			}
			return false;
		}
	}

	public List<EntradaEntity> getAsientosOcupados(String tribuna, String seccion) {
		return p.getAsientosOcupados(tribuna, seccion);
	}
	

}
