package ips2023pl21.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class HorariosEquipos {
	
	private String idEquipo;
	private String fecha;
	private int horaEntrada;
	private int minutoEntrada;
	private int horaSalida;
	private int minutoSalida;
	private String idInstalacion;
	
	//Fecha exacta cuando empieza, cuando termina
	private LocalDateTime empieza;
	private LocalDateTime acaba;
	
	public HorariosEquipos(){}

	public String getIdEquipo() {
		return idEquipo;
	}

	public void setIdEquipo(String idEquipo) {
		this.idEquipo = idEquipo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getHoraEntrada() {
		return horaEntrada;
	}
	public String getIdInstalacion() {
		return idInstalacion;
	}

	public void setIdInstalacion(String id) {
		this.idInstalacion = id;
	}
	
	public void setHoraEntrada(int horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public int getMinutoentrada() {
		return minutoEntrada;
	}

	public void setMinutoentrada(int minutoentrada) {
		this.minutoEntrada = minutoentrada;
	}

	public int getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(int horaSalida) {
		this.horaSalida = horaSalida;
	}

	public int getMinutoSalida() {
		return minutoSalida;
	}

	public void setMinutoSalida(int minutoSalida) {
		this.minutoSalida = minutoSalida;
	}
	
	public LocalDateTime getEmpieza() {
		LocalDate f = LocalDate.parse(fecha);
		LocalTime time = LocalTime.of(horaEntrada, minutoEntrada);
		
		empieza = LocalDateTime.of(f, time);
		
		return empieza;
	}
	
	public LocalDateTime getAcaba() {
		LocalDate f = LocalDate.parse(fecha);
		LocalTime time = LocalTime.of(horaSalida, minutoSalida);
		acaba = LocalDateTime.of(f, time).plusMinutes(90);
		
		return acaba;
	}
}
