package ips2023pl21.model;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Franja implements Comparable<Franja> {
	
	protected String horaInicio;
	protected String horaFin;
	
	public String getHoraInicio() {
		return horaInicio;
	}
	public String getHoraFin() {
		return horaFin;
	}
	public LocalTime getParsedInicio() {
		return parse(horaInicio);
	}
	public LocalTime getParsedFin() {
		return parse(horaFin);
	}
	
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}
	
	public long getMinutosTotales() {
		return ChronoUnit.MINUTES.between(parse(horaInicio), parse(horaFin));
	}
	
	protected LocalTime parse(String hora) {
		return LocalTime.parse(hora, DateTimeFormatter.ofPattern("HH:mm"));
	}
	
	public boolean solapa(Franja otraFranja) {
        return (getParsedInicio().isBefore(otraFranja.getParsedFin()) && 
        		getParsedFin().isAfter(otraFranja.getParsedInicio())) || 
               (otraFranja.getParsedInicio().isBefore(getParsedFin()) &&
            	otraFranja.getParsedFin().isAfter(getParsedInicio()));
    }
	
	@Override
	public String toString() {
		return String.format(horaInicio + "-" + horaFin);
	}

	@Override
	public int compareTo(Franja f) {
		return this.getParsedInicio().compareTo(f.getParsedInicio());
	}

}
