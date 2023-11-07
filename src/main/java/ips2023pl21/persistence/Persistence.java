package ips2023pl21.persistence;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import ips2023pl21.model.Empleado;
import ips2023pl21.model.activos.Instalacion;
import ips2023pl21.model.horarios.HorarioEntrevista;
import ips2023pl21.model.horarios.HorarioJardineria;
import ips2023pl21.model.horarios.HorarioPuntual;
import ips2023pl21.model.horarios.HorarioSemanal;
import ips2023pl21.model.horarios.franjas.FranjaPuntual;
import ips2023pl21.model.horarios.franjas.FranjaSemanal;
import ips2023pl21.util.Database;
import ips2023pl21.util.Util;

public class Persistence {

	// Singleton
	private static Persistence p = new Persistence();

	private Database db = new Database();

	private Persistence() {
		db = new Database();
		db.createDatabase(false);
		db.loadDatabase();
	}

	public static Persistence getInstance() {
		return p;
	}

	// ENTREVISTAS

	public List<HorarioEntrevista> selectEntrevistas() {
		List<HorarioEntrevista> result = db.executeQueryPojo(HorarioEntrevista.class,
				"select * from HorarioEntrevista");
		return result;
	}

	public void insertEntrevista(String fechaSel, String datosMedio, String horaInicio, String horaFin, int eid) {
		db.executeUpdate(
				"insert into HorarioEntrevista (fechaEntrevista, datosMedio, horaInicio, horaFin, eid) values (?,?,?,?,?)",
				fechaSel, datosMedio, horaInicio, horaFin, eid);
	}

	// INSTALACIONES

	public List<Instalacion> selectInstalaciones() {
		List<Instalacion> result = db.executeQueryPojo(Instalacion.class, "select * from Instalacion");
		return result;
	}

	public Instalacion getInstalacion(int id) {
		return db.executeQueryPojo(Instalacion.class, "select * from Instalacion where id=?", id).get(0);
	}

	// EMPLEADOS

	public Empleado getEmpleado(int eid) {
		return db.executeQueryPojo(Empleado.class, "select * from Empleado where eid=?", eid).get(0);
	}

	public Empleado getEmpleado(String nombre, String apellido, String dni) {
		return db.executeQueryPojo(Empleado.class, "select * from Empleado where nombre=? and apellido=? and dni=?",
				nombre, apellido, dni).get(0);
	}

	public List<Empleado> selectEmpleadosNoDeportivos() {
		return db.executeQueryPojo(Empleado.class, "select * from Empleado where tipo = 'nodeportivo'");
	}

	public List<Empleado> selectEmpleadosDeportivos() {
		return db.executeQueryPojo(Empleado.class, "select * from Empleado where tipo = 'deportivo'");
	}

	public List<Empleado> selectEntrenadores() {
		return db.executeQueryPojo(Empleado.class, "select * from Empleado where posicion = 'entrenador'");
	}

	public List<Empleado> selectJugadores() {
		return db.executeQueryPojo(Empleado.class, "select * from Empleado where posicion = 'jugador'");
	}

	public List<Empleado> selectJugadoresProfesionales() {
		return db.executeQueryPojo(Empleado.class, "select * from Empleado where posicion = 'jugador'");
	}

	public List<Empleado> selectJardineros() {
		return db.executeQueryPojo(Empleado.class, "select * from Empleado where posicion = 'jardinero'");
	}

	public List<Empleado> selectJardinerosLibres(String fecha, String horaInicio, String horaFin, int iid) {

		LocalTime sHoraInicio = Util.stringHoraToLocalTime(horaInicio);
		LocalTime sHoraFin = Util.stringHoraToLocalTime(horaFin);

		Set<Integer> idsJardinerosLibres =  new HashSet<>();
		List<Empleado> jardinerosLibres = new ArrayList<>();

		for (FranjaSemanal fs : getFranjasSemanales(HorarioSemanal.getDiaDeLaSemana(fecha))) {
			
			LocalTime pHoraInicio = fs.getParsedInicio();
			LocalTime pHoraFin = fs.getParsedFin();
			
			if (contenido(sHoraInicio, sHoraFin, pHoraInicio, pHoraFin))
				idsJardinerosLibres.add(fs.getEid());
					
		}
		
		for (HorarioPuntual hp : selectHorariosPuntuales(fecha)) {

		}
		
		if (idsJardinerosLibres.size() == 0)
			return jardinerosLibres;
		
		for (HorarioJardineria jardineria : selectHorariosJardineria(iid)) {
			if (jardineria.getFechaJardineria().equals(fecha)) {

				LocalTime pHoraInicio = jardineria.getpParsedInicio();
				LocalTime pHoraFin = jardineria.getParsedFin();

				if (solapa(sHoraInicio, sHoraFin, pHoraInicio, pHoraFin))
					idsJardinerosLibres.remove(jardineria.getEid());
			}
		}
		
		for (Empleado j: selectJardineros())
			if (idsJardinerosLibres.contains(j.getEid()))
				jardinerosLibres.add(j);
			

		return jardinerosLibres;
	}

	public static boolean contenido(LocalTime horaInicio1, LocalTime horaFin1, LocalTime horaInicio2, LocalTime horaFin2) {
		return ((horaInicio1.isAfter(horaInicio2) || horaInicio1.equals(horaInicio2) )&& (horaFin1.isBefore(horaFin2) || horaFin1.equals(horaFin2)));
	}

	public static boolean solapa(LocalTime horaInicio1, LocalTime horaFin1, LocalTime horaInicio2, LocalTime horaFin2) {
		return (horaInicio1.isBefore(horaFin2) && horaFin1.isAfter(horaInicio2))
				|| (horaInicio2.isBefore(horaFin1) && horaFin2.isAfter(horaInicio1));
	}

	public List<Empleado> selectJugadoresLibres(String fechaSel) {

		List<Integer> idsJugadoresConEntrevista = new ArrayList<>();

		for (HorarioEntrevista entrevista : selectEntrevistas()) {

			if (entrevista.getFechaEntrevista().equals(fechaSel))
				idsJugadoresConEntrevista.add(entrevista.getEid());

		}

		List<Empleado> jugadoresLibres = new ArrayList<>();

		for (Empleado jugador : selectJugadoresProfesionales()) {
			if (!idsJugadoresConEntrevista.contains(jugador.getEid())) {
				jugadoresLibres.add(jugador);
			}
		}

		return jugadoresLibres;

	}

	public void insertarEmpleado(String nombre, String apellido, String dni, String fechaNacimiento, double salario,
			String telefono, String tipo, String posicion) {

		db.executeUpdate(
				"insert into Empleado(nombre, apellido, dni, fechaNacimiento, salarioAnual, telefono, tipo, posicion) values (?,?,?,?,?,?,?,?)",
				nombre, apellido, dni, fechaNacimiento, salario, telefono, tipo, posicion);

	}

	public void deleteEmpleado(String nombre, String apellido, String dni, String tipo) {
		String sqlElimminar = "delete from empleado where nombre = ? and apellido = ? and dni = ? and tipo = ?";
		db.executeUpdate(sqlElimminar, nombre, apellido, dni, tipo);
	}

	public void updateEmpleado(String nombre, String apellido, String dni, String fecha, double salario,
			String telefono, Object posicion, String nombreEmpleadoGestion, String apellidoEmpleadoGestion,
			String dniEmpleadoGestion) {
		String updateEmpleado = "update empleado set nombre = ?, apellido = ?, dni = ?, fechaNacimiento = ?, "
				+ "salarioAnual = ?, telefono = ?, posicion = ?" + "where nombre = ? and apellido = ? and dni = ?";
		db.executeUpdate(updateEmpleado, nombre, apellido, dni, fecha, salario, telefono, posicion,
				nombreEmpleadoGestion, apellidoEmpleadoGestion, dniEmpleadoGestion);
	}

	// HORARIO SEMANAL

	public List<HorarioSemanal> selectHorariosSemanales(String fecha) {
		int diaSemana = HorarioSemanal.getNumeroDia(fecha);
		return db.executeQueryPojo(HorarioSemanal.class, "select * from HorarioSemanal where diaSemana=?", diaSemana)
				.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
	}

	public List<HorarioSemanal> selectHorariosSemanales() {
		List<HorarioSemanal> result = db.executeQueryPojo(HorarioSemanal.class, "select * from HorarioSemanal").stream()
				.sorted().collect(Collectors.toList());
		return result;
	}

	public List<HorarioSemanal> selectHorariosSemanales(int eid) {
		List<HorarioSemanal> result = db
				.executeQueryPojo(HorarioSemanal.class, "select * from HorarioSemanal where eid=?", eid).stream()
				.sorted().collect(Collectors.toList());
		return result;
	}

	public HorarioSemanal getHorarioSemanal(int eid, int numeroDiaSemana, String fechaInicio) {
		return db.executeQueryPojo(HorarioSemanal.class,
				"select * from HorarioSemanal where eid=? and diaSemana=? and fechaInicio=?", eid, numeroDiaSemana,
				fechaInicio).get(0);
	}

	public void insertHorarioSemanal(int diaSemana, String fechaString, int eid) {
		db.executeUpdate("insert into HorarioSemanal(diaSemana, fechaInicio, eid) values (?, ?, ?)", diaSemana,fechaString, eid);
	}

	public void updateFechaFin(int eid, HorarioSemanal actual, String fechaFinString) {
		db.executeUpdate("update HorarioSemanal set fechaFin=? where eid=? and diaSemana=? and fechaInicio=?",
				fechaFinString, eid, actual.getDiaSemana(), actual.getFechaInicio());
	}

	public void deleteFechaFin(int eid, HorarioSemanal ultimoHorario) {
		db.executeUpdate("update HorarioSemanal set fechaFin=null where eid=? and diaSemana=? and fechaInicio=?", eid,
				ultimoHorario.getDiaSemana(), ultimoHorario.getFechaInicio());
	}

	public void insertFranjaSemanal(int dia, String fechaInicio, int eid, String horaInicio, String horaFin) {
		db.executeUpdate("insert into FranjaSemanal(diaSemana, fechaInicio, eid, horaInicio, horaFin) values (?, ?, ?, ?, ?)",
				dia, fechaInicio, eid, horaInicio, horaFin);
	}

	public void deleteHorarioSemanal(int dia, String fechaInicio, int eid) {
		System.out.println(getFranjasSemanales(dia, fechaInicio, eid));
		db.executeUpdate("delete from HorarioSemanal where diaSemana=? and fechaInicio=? and eid=?", dia, fechaInicio, eid);
		db.executeUpdate("delete from FranjaSemanal where diaSemana=? and fechaInicio=? and eid=?", dia, fechaInicio, eid);
	}

	public List<FranjaSemanal> getFranjasSemanales(int diaSem, String fechaInicio, int eid) {
		List<FranjaSemanal> result = db
				.executeQueryPojo(FranjaSemanal.class,
						"select * from FranjaSemanal where diaSemana=? and fechaInicio=? and eid=?", diaSem, fechaInicio, eid)
				.stream().sorted().collect(Collectors.toList());
		return result;
	}
	
	public List<FranjaSemanal> getFranjasSemanales(int diaSem, String fechaInicio) {
		List<FranjaSemanal> result = db
				.executeQueryPojo(FranjaSemanal.class,
						"select * from FranjaSemanal where diaSemana=? and fechaInicio=?", diaSem, fechaInicio)
				.stream().sorted().collect(Collectors.toList());
		return result;
	}
	
	public List<FranjaSemanal> getFranjasSemanales(int diaSem) {
		List<FranjaSemanal> franjas = db
				.executeQueryPojo(FranjaSemanal.class,
						"select * from FranjaSemanal where diaSemana=?", diaSem)
				.stream().sorted().collect(Collectors.toList());
		
		Map<Integer, FranjaSemanal> firstByDayOfWeek = franjas.stream()
				.collect(Collectors.toMap(FranjaSemanal::getDiaSemana, Function.identity(), (a, b) -> b));
		
		List<FranjaSemanal> result = franjas.stream()
				.filter(f -> f.equals(firstByDayOfWeek.get(f.getDiaSemana())))
				.collect(Collectors.toList());
		
		return result;
	}

	// HORARIO PUNTUAL

	public List<HorarioPuntual> selectHorariosPuntuales(String fecha) {
		List<HorarioPuntual> result = db.executeQueryPojo(HorarioPuntual.class,
				"select * from HorarioPuntual where fechaPuntual=?", fecha);
		return result;

	}

	public List<HorarioPuntual> selectHorariosPuntuales(int eid) {
		List<HorarioPuntual> result = db
				.executeQueryPojo(HorarioPuntual.class, "select * from HorarioPuntual where eid=?", eid).stream()
				.sorted().collect(Collectors.toList());

		return result;
	}

	public HorarioPuntual getHorarioPuntual(int eid, String fechaPuntual) {
		return db.executeQueryPojo(HorarioPuntual.class, "select * from HorarioPuntual where eid=? and fechaPuntual=?",
				eid, fechaPuntual).get(0);
	}

	public void insertHorarioPuntual(String fechaString, int eid) {
		db.executeUpdate("insert into HorarioPuntual(fechaPuntual, eid) values (?, ?)", fechaString, eid);
	}

	public void insertFranjaPuntual(String fechaPun, int eid, String horaInicio, String horaFin) {
		db.executeUpdate("insert into FranjaPuntual(fechaPuntual, eid, horaInicio, horaFin) values (?, ?, ?, ?)", fechaPun, eid,
				horaInicio, horaFin);
	}

	public void removeHorarioPuntual(String fechaPun) {
		db.executeUpdate("delete from HorarioPuntual where fechaPuntual=?", fechaPun);
		db.executeUpdate("delete from FranjaPuntual where fechaPuntual=?", fechaPun);
	}
	
	public List<FranjaPuntual> getFranjasPuntuales(String fechaPuntual, int eid) {
		List<FranjaPuntual> result = db
				.executeQueryPojo(FranjaPuntual.class, "select * from FranjaPuntual where fechaPuntual=? and eid=?", fechaPuntual, eid)
				.stream().sorted().collect(Collectors.toList());
		;
		return result;
	}


	public List<FranjaPuntual> getFranjasPuntuales(String fechaPuntual) {
		List<FranjaPuntual> result = db
				.executeQueryPojo(FranjaPuntual.class, "select * from FranjaPuntual where fechaPuntual=?", fechaPuntual)
				.stream().sorted().collect(Collectors.toList());
		;
		return result;
	}

	// HORARIO JARDINERIA

	public List<HorarioJardineria> selectHorariosJardineria() {
		List<HorarioJardineria> result = db.executeQueryPojo(HorarioJardineria.class,
				"select * from HorarioJardineria");

		return result;
	}

	public List<HorarioJardineria> selectHorariosJardineria(int iid) {
		List<HorarioJardineria> result = db.executeQueryPojo(HorarioJardineria.class,
				"select * from HorarioJardineria where iid=?", iid);

		return result;
	}

	public void insertHorarioJardineria(int eid, int id, String fecha, String horaInicio, String horaFin) {
		db.executeUpdate(
				"insert into HorarioJardineria (fechaJardineria, horaInicio, horaFin, eid, iid) values (?,?,?,?,?)",
				fecha, horaInicio, horaFin, eid, id);
	}

}
