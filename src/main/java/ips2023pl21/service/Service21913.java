package ips2023pl21.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import ips2023pl21.model.FranjaReservas;
import ips2023pl21.model.HorariosEquipos;
import ips2023pl21.model.Instalaciones;
import ips2023pl21.model.Reservas;
import ips2023pl21.util.Database;
import ips2023pl21.util.Util;

public class Service21913 {
	
	public static final String HORARIOS_POR_FECHA = 
			"select * "
			+ "from horarioequipo "
			+ "where fecha = ? and  idInstalacion = ?"; 
	public static final String RESERVAS_POR_FECHA = 
			"select * "
			+ "from reserva "
			+ "where fechareserva = ? and idInstalacion= ?"; 
	public static final String INSERTAR_RESERVA = 
			"insert into reserva "
			+ "(nombreusuario,cuentabancaria,idInstalacion,precioreserva,fechareserva,horaentrada,horasalida,minutoentrada,minutosalida,fechaventa,horaventa,minutoventa)"
			+ "values (?,?,?,?,?,?,?,?,?,?,?,?)";
	
	public static final String OBTENER_INSTALACIONES = "select * from instalacion";
	
	public static final String OBTENER_IDCAMPO = "select * from instalacion "
			+ "where nombreinstalacion = ?";
	
	private Database db;
	private LocalDateTime fechaActual;
	private String fechaSeleccionada;
	private List<HorariosEquipos> horariosFechaSeleccionada;
	private List<Reservas> reservasFechaSeleccionada;
	private Map<LocalDateTime, LocalDateTime> horasOcupadas;
	private Map<LocalDateTime, LocalDateTime> horasDisponibles = new TreeMap<>();
	private Map<FranjaReservas, Boolean> franjasHorarias = new TreeMap<FranjaReservas, Boolean>();
	private FranjaReservas franjaSeleccionada;
	private List<Instalaciones> instalaciones = new ArrayList<Instalaciones>();
	private String idCampo;
	
	public Service21913() {
		//Cargar base de datos
		db = new Database();
		db.createDatabase(false);
		db.loadDatabase();
		
		//Cargar lógica
		horariosFechaSeleccionada = new ArrayList<HorariosEquipos>();
		fechaActual = LocalDateTime.now();
		instalaciones = cargarInstalaciones();
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
	
	public Map<FranjaReservas, Boolean> getFranjasHorarias(){
		return franjasHorarias;
	}
	
	public FranjaReservas getFranjaSeleccionada() {
		return franjaSeleccionada;
	}
	
	public List<Instalaciones> getInstalaciones(){
		return instalaciones;
	}
	
	public void cargarFechaSeleccioanda(String year, String month, String day) throws ParseException {
		String fechaDePantalla = year+"-"+month+"-"+day;
		if (fechaDePantalla.length() < 10) {
			SimpleDateFormat formato0 = new SimpleDateFormat("yyyy-m-d");
			Date fecha = formato0.parse(fechaDePantalla);
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-mm-dd");
			fechaSeleccionada = formato.format(fecha);
		}else {
			fechaSeleccionada = fechaDePantalla;
		}
		
	}
	
	public void cargarHorariosEquipos() {
		horariosFechaSeleccionada = 
				db.executeQueryPojo(HorariosEquipos.class, HORARIOS_POR_FECHA, fechaSeleccionada, idCampo);
		
	}
	
	public void cargarReservas() {
		reservasFechaSeleccionada = 
				db.executeQueryPojo(Reservas.class, RESERVAS_POR_FECHA, fechaSeleccionada, idCampo);
		
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
		LocalDateTime horaInicioAnterior0;
		LocalDate fecha0;
		fecha0 = LocalDate.parse(fechaSeleccionada);
	    LocalTime horaInicio0 = LocalTime.of(8, 0);
	    horaInicioAnterior0 = LocalDateTime.of(fecha0, horaInicio0);
	    
		LocalDateTime horaInicioAnterior = horaInicioAnterior0;
	    
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

	    LocalDateTime horaFinDia = LocalDateTime.of(fecha0, LocalTime.of(22, 0));
	    Duration duracionUltimoIntervalo = Duration.between(horaInicioAnterior, horaFinDia);

	    if (duracionUltimoIntervalo.toHours() >= 1) {
	        LocalDateTime horaIntermediaUltima = horaInicioAnterior;
	        horasDisponibles.put(horaIntermediaUltima, horaIntermediaUltima.plusMinutes(duracionUltimoIntervalo.toMinutes()));
	    }
	 
	    cargarFranjas(horasOcupadas, horasDisponibles);
	}

	public void cargarFranjas(Map<LocalDateTime, LocalDateTime> ocupadas, Map<LocalDateTime, LocalDateTime> disponibles) {
		for (Map.Entry<LocalDateTime, LocalDateTime> f : ocupadas.entrySet()) {
			FranjaReservas nuevaFranja = new FranjaReservas(f.getKey(), f.getValue(), false);
			franjasHorarias.put(nuevaFranja, nuevaFranja.isDisponible());
		}
		for (Map.Entry<LocalDateTime, LocalDateTime> f : disponibles.entrySet()) {
			FranjaReservas nuevaFranja = new FranjaReservas(f.getKey(), f.getValue(), true);
			franjasHorarias.put(nuevaFranja, nuevaFranja.isDisponible());
		}
	}
	
	public void marcarFranjaSeleccionada(String toString) {
		for (Map.Entry<FranjaReservas, Boolean> f : franjasHorarias.entrySet()) {
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
		db.executeUpdate(INSERTAR_RESERVA, nombre, tarjeta, idCampo, precioInt, fechaSeleccionada, 
				horaEntrada, horaSalida, minutoEntrada, minutoSalida,fecha,horaReserva,minutoReserva);
	}
	
	public List<Instalaciones> cargarInstalaciones() {
		return db.executeQueryPojo(Instalaciones.class, OBTENER_INSTALACIONES);
	}
	
	public void cargarInstalacionSeleccionada(String campo) {
		List<Instalaciones> inst = 
				db.executeQueryPojo(Instalaciones.class, OBTENER_IDCAMPO, campo);
		this.idCampo = inst.get(0).getId();
	}
}
