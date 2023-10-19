package ips2023pl21.p21913.service;


import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import ip2023pl21.p21913.util.Database;
import ip2023pl21.p21913.util.Util;
import ips2023pl21.p21913.model.Franja;
import ips2023pl21.p21913.model.HorariosEquipos;
import ips2023pl21.p21913.model.Reservas;

public class ClubService21913 {
	
	public static final String HORARIOS_POR_FECHA = 
			"select * "
			+ "from horarioequipo "
			+ "where fecha = ?";
	public static final String RESERVAS_POR_FECHA = 
			"select * "
			+ "from reserva "
			+ "where fechareserva = ?";
	public static final String INSERTAR_RESERVA = 
			"insert into reserva "
			+ "(nombreusuario,cuentabancaria,precioreserva,fechareserva,horaentrada,horasalida,minutoentrada,minutosalida,fechaventa,horaventa,minutoventa)"
			+ "values (?,?,?,?,?,?,?,?,?,?,?)";
	
	private Database db;
	private LocalDateTime fechaActual;
	private String fechaSeleccionada;
	private List<HorariosEquipos> horariosFechaSeleccionada;
	private List<Reservas> reservasFechaSeleccionada;
	private Map<LocalDateTime, LocalDateTime> horasOcupadas;
	private Map<LocalDateTime, LocalDateTime> horasDisponibles = new TreeMap<>();
	private Map<Franja, Boolean> franjasHorarias = new TreeMap<Franja, Boolean>();
	private Franja franjaSeleccionada;
	
	public ClubService21913() {
		//Cargar base de datos
		db = new Database();
		db.createDatabase(false);
		db.loadDatabase();
		
		//Cargar lógica
		horariosFechaSeleccionada = new ArrayList<HorariosEquipos>();
		fechaActual = LocalDateTime.now();
	}
	
	public List<HorariosEquipos> getHorariosEquipos(){
		return horariosFechaSeleccionada;
	}
	
	public List<Reservas> getReservas(){
		return reservasFechaSeleccionada;
	}
	
	public LocalDateTime getFechaActual() {
		return fechaActual;
	}
	
	public String getFechaSeleccionada() {
		return fechaSeleccionada;
	}
	
	public Map<Franja, Boolean> getFranjasHorarias(){
		return franjasHorarias;
	}
	
	public Franja getFranjaSeleccionada() {
		return franjaSeleccionada;
	}
	
	public void cargarFechaSeleccioanda(String year, String month, String day) {
		fechaSeleccionada = year+"-"+month+"-"+day;
	}
	
	public void cargarHorariosEquipos() {
		horariosFechaSeleccionada = 
				db.executeQueryPojo(HorariosEquipos.class, HORARIOS_POR_FECHA, fechaSeleccionada);
		
	}
	
	public void cargarReservas() {
		reservasFechaSeleccionada = 
				db.executeQueryPojo(Reservas.class, RESERVAS_POR_FECHA, fechaSeleccionada);
		
	}
	
	public Map<LocalDateTime, LocalDateTime> getHorasOcupadas(){
		return horasOcupadas;
	}
	
	public void cargarHorasOcupadas() {
		Map<LocalDateTime, LocalDateTime> horasOcupadas =
				new HashMap<LocalDateTime, LocalDateTime>();
		for (HorariosEquipos h : horariosFechaSeleccionada) {
			horasOcupadas.put(h.getEmpieza(), h.getAcaba());
		}
		for (Reservas r : reservasFechaSeleccionada) {
			horasOcupadas.put(r.getEmpieza(), r.getAcaba());
		}
		
		horasOcupadas = new TreeMap<LocalDateTime, LocalDateTime>(horasOcupadas);
		
		this.horasOcupadas = horasOcupadas;
	}
	
	public void horarioInstalaciones() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
	    LocalDate fecha = LocalDate.parse(fechaSeleccionada, formatter);
	    LocalTime horaInicio = LocalTime.of(8, 0);
	    LocalDateTime horaInicioAnterior = LocalDateTime.of(fecha, horaInicio);
	    
	    horasDisponibles.clear();

	    for (Map.Entry<LocalDateTime, LocalDateTime> entrada : horasOcupadas.entrySet()) {
	        LocalDateTime horaFinal = entrada.getKey();
	        Duration duracion = Duration.between(horaInicioAnterior, horaFinal);

	        if (duracion.toHours() >= 1 && horaFinal.getHour() <= 22) {
	            LocalDateTime horaIntermedia = horaInicioAnterior;
	            horasDisponibles.put(horaIntermedia, horaIntermedia.plusMinutes(duracion.toMinutes()));
	        }

	        horaInicioAnterior = entrada.getValue();
	    }

	    LocalDateTime horaFinDia = LocalDateTime.of(fecha, LocalTime.of(22, 0));
	    Duration duracionUltimoIntervalo = Duration.between(horaInicioAnterior, horaFinDia);

	    if (duracionUltimoIntervalo.toHours() >= 1) {
	        LocalDateTime horaIntermediaUltima = horaInicioAnterior;
	        horasDisponibles.put(horaIntermediaUltima, horaIntermediaUltima.plusMinutes(duracionUltimoIntervalo.toMinutes()));
	    }
	 
	    cargarFranjas(horasOcupadas, horasDisponibles);
	}

	public void cargarFranjas(Map<LocalDateTime, LocalDateTime> ocupadas, Map<LocalDateTime, LocalDateTime> disponibles) {
		for (Map.Entry<LocalDateTime, LocalDateTime> f : ocupadas.entrySet()) {
			Franja nuevaFranja = new Franja(f.getKey(), f.getValue(), false);
			franjasHorarias.put(nuevaFranja, nuevaFranja.isDisponible());
		}
		for (Map.Entry<LocalDateTime, LocalDateTime> f : disponibles.entrySet()) {
			Franja nuevaFranja = new Franja(f.getKey(), f.getValue(), true);
			franjasHorarias.put(nuevaFranja, nuevaFranja.isDisponible());
		}
	}
	
	public void marcarFranjaSeleccionada(String toString) {
		for (Map.Entry<Franja, Boolean> f : franjasHorarias.entrySet()) {
			if (f.getKey().toString().equals(toString)) {
				franjaSeleccionada = f.getKey();
			}
		}
	}

	public void cargarReserva(String nombre, String tarjeta, String precio, int horaEntrada, int horaSalida, int minutoEntrada, int minutoSalida) {
		fechaActual = LocalDateTime.now();
		Date d = Date.from(fechaActual.atZone(ZoneId.systemDefault()).toInstant());
		String fecha = Util.dateToIsoString(d);
		int horaReserva = fechaActual.getHour();
		int minutoReserva = fechaActual.getMinute();
		int precioInt = Integer.parseInt(precio);
		db.executeUpdate(INSERTAR_RESERVA, nombre, tarjeta, precioInt, fechaSeleccionada, 
				horaEntrada, horaSalida, minutoEntrada, minutoSalida,fecha,horaReserva,minutoReserva);
	}
}
