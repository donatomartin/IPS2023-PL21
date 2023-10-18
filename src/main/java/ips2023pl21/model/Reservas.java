package ips2023pl21.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Reservas {

	//Atributos de la propia reserva
	private String nombreUsuario;
	private String cuentaBancaria;
	private int precioReserva;
	private String fechaReserva;
	private int horaEntrada;
	private int minutoEntrada;
	private int horaSalida;
	private int minutoSalida;
	
	//Fecha exacta cuando empieza cuando termina
	private LocalDateTime empieza;
	private LocalDateTime acaba;
	
	//Atributos almacenados para el historial de ventas
	private String fechaVenta;
	private int horaVenta;
	private int minutoVenta;

	
	public Reservas() {}


	public String getNombreUsuario() {
		return nombreUsuario;
	}


	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}


	public String getCuentaBancaria() {
		return cuentaBancaria;
	}


	public void setCuentaBancaria(String cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}


	public int getPrecioReserva() {
		return precioReserva;
	}


	public void setPrecioReserva(int precioReserva) {
		this.precioReserva = precioReserva;
	}


	public String getFechaReserva() {
		return fechaReserva;
	}


	public void setFechaReserva(String fechaReserva) {
		this.fechaReserva = fechaReserva;
	}


	public int getHoraEntrada() {
		return horaEntrada;
	}


	public void setHoraEntrada(int horaEntrada) {
		this.horaEntrada = horaEntrada;
	}


	public int getMinutoEntrada() {
		return minutoEntrada;
	}


	public void setMinutoEntrada(int minutoEntrada) {
		this.minutoEntrada = minutoEntrada;
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


	public String getFechaVenta() {
		return fechaVenta;
	}


	public void setFechaVenta(String fechaVenta) {
		this.fechaVenta = fechaVenta;
	}


	public int getHoraVenta() {
		return horaVenta;
	}


	public void setHoraVenta(int horaVenta) {
		this.horaVenta = horaVenta;
	}


	public int getMinutoVenta() {
		return minutoVenta;
	}


	public void setMinutoVenta(int minutoVenta) {
		this.minutoVenta = minutoVenta;
	}
	
	public LocalDateTime getEmpieza() {
		CharSequence f = this.fechaReserva;
		LocalDate fecha = LocalDate.parse(f);
		LocalTime time = LocalTime.of(horaEntrada, minutoEntrada);
		empieza = LocalDateTime.of(fecha, time);
		
		return empieza;
	}
	
	public LocalDateTime getAcaba() {
		CharSequence f = this.fechaReserva;
		LocalDate fecha = LocalDate.parse(f);
		LocalTime time = LocalTime.of(horaSalida, minutoSalida);
		acaba = LocalDateTime.of(fecha, time);
		
		return acaba;
	}
		
}
