package ips2023pl21.model;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class FranjaSemanal extends Franja {
	
	private int diaSemana;
	private String fechaInicio;
	
	public FranjaSemanal() {}
	
	public int getDiaSemana() {
		return diaSemana;
	}
	public String getFechaInicio() {
		return fechaInicio;
	}
	
	public void setDiaSemana(int diaSemana) {
		this.diaSemana = diaSemana;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public static String localTimeToString(LocalTime dateToLocalTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String formattedTime = dateToLocalTime.format(formatter);
        return formattedTime;
	}
	
}
