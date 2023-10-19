package ips2023pl21.p21913.model;

import java.time.LocalDateTime;

public class Franja implements Comparable<Franja>{
	
	private LocalDateTime inicio;
	private LocalDateTime fin;
	private boolean disponible;
	
	public Franja(LocalDateTime inicio, LocalDateTime fin, boolean disponible) {
		this.inicio = inicio;
		this.fin = fin;
		this.disponible = disponible;
	}
	
	public LocalDateTime getInicio() {
		return inicio;
	}
	public LocalDateTime getFin() {
		return fin;
	}
	public boolean isDisponible() {
		return disponible;
	}
	
	public String toString() {
		String str = "";
		if (isDisponible()) {
			str = "Disponibles: " + getInicio().getHour() + ":" + getInicio().getMinute() +
					" - " + getFin().getHour() + ":" + getFin().getMinute();
		}
		else {
			str = "Ocupadas: " + getInicio().getHour() + ":" + getInicio().getMinute() +
					" - " + getFin().getHour() + ":" + getFin().getMinute();
		}
		return str;
	}

	@Override
	public int compareTo(Franja o) {
		if (this.getInicio().isBefore(o.getInicio())) {
			return -1;
		}
		else if (this.getInicio().isAfter(o.getInicio())) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
}
