package ips2023pl21.model.horarios;

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
	
	@Override
	public String toString() {
		
	    String result = "<html><p>%-10s<ul>".formatted(fechaPuntual);;
	    
	    for (FranjaPuntual f: Persistence.getInstance().getFranjasPuntuales(fechaPuntual, eid)) {
	        result += "<li>" + f.toString() + "</li>";
	    }

	    result += "</ul><html>";
	    
	    return result;
	}

	@Override
	public int compareTo(HorarioPuntual o) {
		return Util.isoStringToDate(getFechaPuntual()).compareTo(Util.isoStringToDate(o.getFechaPuntual()));
	}

}
