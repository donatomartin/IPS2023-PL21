package ips2023pl21.model.horarios;

import java.util.Calendar;

import ips2023pl21.model.horarios.franjas.FranjaPuntual;
import ips2023pl21.persistence.Persistence;
import ips2023pl21.util.Util;

public class HorarioPuntual implements Comparable<HorarioPuntual> {

	private String fechaPuntual;
	private int eid;

	public HorarioPuntual() {}

	public String getFechaPuntual() {
		return fechaPuntual;
	}
	
	public int getEid() {
		return eid;
	}

	public void setFechaPuntual(String fechaEspecificada) {
		this.fechaPuntual = fechaEspecificada;
	}
	
	public void setEid(int eid) {
		this.eid = eid;
	}
	
	public int getDiaDeLaSemana() {
		
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(Util.isoStringToDate(this.fechaPuntual));
	    
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
	    
	    for (FranjaPuntual f: Persistence.getInstance().getFranjasPuntuales(fechaPuntual, eid)) {
	        result += " || " + f.toString();
	    }

	    return result;
	}

	@Override
	public int compareTo(HorarioPuntual o) {
		return Util.isoStringToDate(getFechaPuntual()).compareTo(Util.isoStringToDate(o.getFechaPuntual()));
	}

}
