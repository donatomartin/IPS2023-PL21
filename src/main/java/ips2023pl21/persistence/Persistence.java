package ips2023pl21.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ips2023pl21.model.Empleado;
import ips2023pl21.model.acciones.Accion;
import ips2023pl21.model.acciones.Accionista;
import ips2023pl21.model.acciones.AmpliacionCapital;
import ips2023pl21.model.horarios.HorarioEntrevista;
import ips2023pl21.model.horarios.HorarioPuntual;
import ips2023pl21.model.horarios.HorarioSemanal;
import ips2023pl21.model.horarios.franjas.FranjaPuntual;
import ips2023pl21.model.horarios.franjas.FranjaSemanal;
import ips2023pl21.util.Database;

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
		List<HorarioEntrevista> result = db.executeQueryPojo(HorarioEntrevista.class, "select * from Entrevista");
		return result;
	}

	public void insertEntrevista(String fechaSel, String datosMedio, String horaInicio, String horaFin, int eid) {
		db.executeUpdate(
				"insert into Entrevista(fechaEntrevista, datosMedio, horaInicio, horaFin, eid) values (?,?,?,?,?)",
				fechaSel, datosMedio, horaInicio, horaFin, eid);
	}

	// EMPLEADOS

	public Empleado getEmpleado(int eid) {
		return db.executeQueryPojo(Empleado.class, "select * from Empleado where eid=?", eid)
				.get(0);
	}
	
	public Empleado getEmpleado(String nombre, String apellido, String dni) {
		return db.executeQueryPojo(Empleado.class, "select * from Empleado where nombre=? and apellido=? and dni=?", nombre, apellido, dni).get(0);
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
	
	public void insertarEmpleado(String nombre, String apellido, String dni, String fechaNacimiento, double salario, String telefono, String tipo, String posicion) {
		
		db.executeUpdate("insert into Empleado(nombre, apellido, dni, fechaNacimiento, salarioAnual, telefono, tipo, posicion) values (?,?,?,?,?,?,?,?)",
				nombre,
				apellido,
				dni,
				fechaNacimiento,
				salario,
				telefono,
				tipo,
				posicion);
		
	}
	
	public void deleteEmpleado(String nombre, String apellido, String dni, String tipo) {
		String sqlElimminar = "delete from empleado where nombre = ? and apellido = ? and dni = ? and tipo = ?";
		db.executeUpdate(sqlElimminar, nombre, apellido, dni, tipo);
	}
	
	public void updateEmpleado(String nombre, String apellido, String dni, String fecha, double salario,
			String telefono, Object posicion, String nombreEmpleadoGestion, String apellidoEmpleadoGestion,
			String dniEmpleadoGestion) {
		String updateEmpleado = "update empleado set nombre = ?, apellido = ?, dni = ?, fechaNacimiento = ?, "
				+ "salarioAnual = ?, telefono = ?, posicion = ?"
				+ "where nombre = ? and apellido = ? and dni = ?";
		db.executeUpdate(updateEmpleado, nombre, apellido, dni, fecha, salario, telefono, posicion, nombreEmpleadoGestion, apellidoEmpleadoGestion, dniEmpleadoGestion);
	}

	// HORARIO SEMANAL

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

	public void insertHorarioSemanal(int numeroDiaSemana, String fechaString, int eid) {
		db.executeUpdate("insert into HorarioSemanal(diaSemana, fechaInicio, eid) values (?, ?, ?)", numeroDiaSemana,
				fechaString, eid);
	}

	public void updateFechaFin(int eid, HorarioSemanal actual, String fechaFinString) {
		db.executeUpdate("update HorarioSemanal set fechaFin=? where eid=? and diaSemana=? and fechaInicio=?",
				fechaFinString, eid, actual.getDiaSemana(), actual.getFechaInicio());
	}

	public void deleteFechaFin(int eid, HorarioSemanal ultimoHorario) {
		db.executeUpdate("update HorarioSemanal set fechaFin=null where eid=? and diaSemana=? and fechaInicio=?", eid,
				ultimoHorario.getDiaSemana(), ultimoHorario.getFechaInicio());
	}

	public void insertFranjaSemanal(int dia, String fechaInicio, String horaInicio, String horaFin) {
		db.executeUpdate("insert into FranjaSemanal(diaSemana, fechaInicio, horaInicio, horaFin) values (?, ?, ?, ?)",
				dia, fechaInicio, horaInicio, horaFin);
	}

	public void deleteHorarioSemanal(int dia, String fechaIni) {
		db.executeUpdate("delete from HorarioSemanal where diaSemana=? and fechaInicio=?", dia, fechaIni);
		db.executeUpdate("delete from FranjaSemanal where diaSemana=? and fechaInicio=?", dia, fechaIni);
	}

	public List<FranjaSemanal> getFranjasSemanales(int diaSem, String fechaIn) {
		List<FranjaSemanal> result = db
				.executeQueryPojo(FranjaSemanal.class,
						"select * from FranjaSemanal where diaSemana=? and fechaInicio=?", diaSem, fechaIn)
				.stream().sorted().collect(Collectors.toList());
		return result;
	}

	// HORARIO PUNTUAL

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

	public void insertFranjaPuntual(String fechaPun, String horaInicio, String horaFin) {
		db.executeUpdate("insert into FranjaPuntual(fechaPuntual, horaInicio, horaFin) values (?, ?, ?)", fechaPun,
				horaInicio, horaFin);
	}

	public void removeHorarioPuntual(String fechaPun) {
		db.executeUpdate("delete from HorarioPuntual where fechaPuntual=?", fechaPun);
		db.executeUpdate("delete from FranjaPuntual where fechaPuntual=?", fechaPun);
	}

	public List<FranjaPuntual> getFranjasPuntuales(String fechaPuntual) {
		List<FranjaPuntual> result = db
				.executeQueryPojo(FranjaPuntual.class, "select * from FranjaPuntual where fechaPuntual=?", fechaPuntual)
				.stream().sorted().collect(Collectors.toList());
		;
		return result;
	}
	
	//CAPITAL CLUB
	public float getCapitalClub() {
		List<AmpliacionCapital> ac = db.
				executeQueryPojo(AmpliacionCapital.class, "select * from ampliacionCapital");
		float result = ac.get(0).getCapitalTotal();
		return result;
	}
	
	public int getAccionesClub() {
		List<AmpliacionCapital> ac = db.
				executeQueryPojo(AmpliacionCapital.class, "select * from ampliacionCapital");
		int result = ac.get(0).getAccionesTotales();
		return result;
	}

	public float getPrecioPorAccion() {
		List<AmpliacionCapital> ac = db.
				executeQueryPojo(AmpliacionCapital.class, "select * from ampliacionCapital");
		float result = ac.get(0).getPrecioAccion();
		return result;
	}
	
	public void insertAmpliacion(int accionesNuevas) {
		db.executeUpdate("update ampliacioncapital set faseUno = ?", accionesNuevas);
	}
	
	public void updateLimiteFaseUno() {
		db.executeUpdate("update accionista set limiteAccionesFaseUno = numeroAcciones");
	}

	
	//ACCIONISTAS
	public List<Accionista> selectAccionista(int numeroAccionista) {
		return db.executeQueryPojo(Accionista.class, "select * from accionista "
				+ "where idAccionista=?", numeroAccionista);
	}

	public List<Accionista> selectAccionista(String nombre, String apellido, String dni) {
		return db.executeQueryPojo(Accionista.class, "select * from accionista "
				+ "where nombreAccionista=? and apellidoAccionista=? and dniAccionista=?", nombre, apellido, dni);
	}

	public void insertAccionista(String nombre, String apellido, String dni, String cuenta) {
		db.executeUpdate("insert into accionista(nombreAccionista, apellidoAccionista, "
				+ "dniAccionista, cuentaBancaria, numeroAcciones,porcentajeCapital) values "
				+ "(?,?,?,?, 0, 0.0)", nombre, apellido, dni, cuenta);
	}

	public List<Accionista> selectAccionistaById(int id) {
		return db.executeQueryPojo(Accionista.class, "select * from accionista "
				+ "where idAccionista=?", id);
	}

	public List<Accion> selectAccionesByIdAccionista(int accionistaActivo) {
		return db.executeQueryPojo(Accion.class, "select * from accion "
				+ "where idAccionista=?", accionistaActivo);
	}

	public List<Accion> selectAccionesEnVenta(int idAccionista) {
		return db.executeQueryPojo(Accion.class, "select * from accion "
				+ "where idAccionista <> ? and enVenta = 1", idAccionista);
	}

	public void updateAccionCompra(Integer idAccion, int idComprador, int idVendedor, float porcentaje) {
		db.executeUpdate("update accion set idAccionista=? where idAccion=?", idComprador, idAccion);
		db.executeUpdate("update accionista set numeroAcciones=numeroAcciones+1, "
				+ "porcentajeCapital=porcentajeCapital+? where idAccionista=?", porcentaje, idComprador);
		db.executeUpdate("update accionista set numeroAcciones=numeroAcciones-1, "
				+ "porcentajeCapital=porcentajeCapital-? where idAccionista=?", porcentaje, idVendedor);
	}

	public void deleteAccionistaACero() {
		db.executeUpdate("delete from accionista where numeroAcciones = 0");
	}

	public int selectLimiteFase1(int idAccionista) {
		List<Accionista> acc = db.executeQueryPojo(Accionista.class, "select * from accionista "
				+ "where idAccionista=?", idAccionista);
		return acc.get(0).getLimiteAccionesFaseUno();
	}

	public void insertAccion(int idAccionista, double precioPorAccion) {
		db.executeUpdate("insert into accion(idAccionista,precioCompra,enVenta,precioVenta) "
				+ "values (?,?,0,?)", idAccionista, precioPorAccion, precioPorAccion);
	}

	public void updateLimiteAccionista(int idAccionista, Integer numAcciones) {
		db.executeUpdate("update accionista set limiteAccionesFaseUno=limiteAccionesFaseUno-? "
				+ "where idAccionista=?", numAcciones, idAccionista);
	}

	public void updateCompraAccionista(int idAccionista, float porcentaje) {
		db.executeUpdate("update accionista set numeroAcciones=numeroAcciones+1 where idAccionista=?", idAccionista);
		db.executeUpdate("update accionista set porcentajeCapital=porcentajeCapital+? "
				+ "where idAccionista=?", porcentaje, idAccionista);
		db.executeUpdate("update accionista set porcentajeCapital=porcentajeCapital-? "
				+ "where idAccionista<>?", porcentaje, idAccionista);
	}

	public void updateAccionesEnVenta(int idAccionista) {
		db.executeUpdate("update accion set enVenta=1 where idAccionista=?", idAccionista);
	}

	public void updatePonerEnVenta(Integer id) {
		db.executeUpdate("update accion set enVenta=1 where idAccion=?", id);
	}
}
