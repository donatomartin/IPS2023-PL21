package ips2023pl21.model;

import java.util.Calendar;

import ips2023pl21.service.Service21912;
import ips2023pl21.util.Util;

public class HorarioPuntual implements Comparable<HorarioPuntual> {

	private String fechaPuntual;

	public HorarioPuntual() {}

	public String getFechaPuntual() {
		return fechaPuntual;
	}

	public void setFechaPuntual(String fechaEspecificada) {
		this.fechaPuntual = fechaEspecificada;
	}
	
	public int getDiaDeLaSemana() {
		
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(Util.isoStringToDate2(this.fechaPuntual));
	    
	    // Los calendarios empiezan en domingo
	    int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
	    if (dayOfWeek == 0) {
	        dayOfWeek = 7;
	    }
	    
	    return dayOfWeek;
	}
	
	@Override
	public String toString() {
		
	    String result = "%-10s".formatted(fechaPuntual);;
	    
	    for (FranjaPuntual f: Service21912.getFranjasPuntuales(fechaPuntual)) {
	        result += " || " + f.toString();
	    }

	    return result;
	}

	@Override
	public int compareTo(HorarioPuntual o) {
		return Util.isoStringToDate2(getFechaPuntual()).compareTo(Util.isoStringToDate2(o.getFechaPuntual()));
	}

}
