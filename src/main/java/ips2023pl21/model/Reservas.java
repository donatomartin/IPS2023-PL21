package ips2023pl21.model;

public class Reservas {

	//Atributos de la propia reserva
		private String nombreUsuario;
		private String cuentaBancaria;
		private int precioReserva;
		private String fechaReserva;
		private int horaReservaEntrada;
		private int minutoReservaEntrada;
		private int horaReservaSalida;
		private int minutoReservaSalida;
		
		//Atributos almacenados para el historial de ventas
		private String fechaVenta;
		private int horaVenta;
		private int minutoVenta;

		
		public Reservas() {}
}
