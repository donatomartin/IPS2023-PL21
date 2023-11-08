package ips2023pl21.model.horarios;

import java.util.Date;

import ips2023pl21.model.horarios.franjas.FranjaSemanal;
import ips2023pl21.persistence.Persistence;
import ips2023pl21.util.Util;

public class HorarioSemanal implements Comparable<HorarioSemanal> {

	private int diaSemana;
	private String fechaInicio;
	private String fechaFin;
	
	public HorarioSemanal() {}

	public int getDiaSemana() {
		return diaSemana;
	}
	public String getFechaInicio() {
		return fechaInicio;
	}
	public String getFechaFin() {
		return fechaFin;
	}
	
	public void setDiaSemana(int diaSemana) {
		this.diaSemana = diaSemana;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	@Override
	public String toString() {
		
		String result = "%-10s".formatted(getNombreDia(diaSemana));
		result += "(" + fechaInicio;
		
		if (fechaFin != null)
			result += " -> " + fechaFin;
		
		result += ") ";

		for (FranjaSemanal f : Persistence.getInstance().getFranjasSemanales(diaSemana, fechaInicio)) {
			result += f.toString() + " || ";
		}

		return result.toString();
	}
	
	// Util

	public static String getNombreDia(int dia) {
		switch (dia) {
		case 1:
			return "Lunes";
		case 2:
			return "Martes";
		case 3:
			return "Miercoles";
		case 4:
			return "Jueves";
		case 5:
			return "Viernes";
		case 6:
			return "Sabado";
		default:
			return "Domingo";
		}
	}

	public static int getNumeroDia(String dia) {
		switch (dia) {
		case "Lunes":
			return 1;
		case "Martes":
			return 2;
		case "Miercoles":
			return 3;
		case "Jueves":
			return 4;
		case "Viernes":
			return 5;
		case "Sabado":
			return 6;
		default:
			return 7;
		}
	}

	@Override
	public int compareTo(HorarioSemanal o) {

	    // Primero compara los días de la semana
	    int comparacionDia = Integer.compare(this.diaSemana, o.diaSemana);
	    if (comparacionDia != 0) {
	        return comparacionDia;
	    }

        Date fechaInicioThis = Util.isoStringToDate(fechaInicio);
        Date fechaInicioO = Util.isoStringToDate(o.getFechaInicio());

        // Si los días de la semana son iguales, compara las fechas de inicio
        return fechaInicioThis.compareTo(fechaInicioO);
	}

}
