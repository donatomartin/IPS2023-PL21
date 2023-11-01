package ips2023pl21.persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import ips2023pl21.model.abonos.Abono;
import ips2023pl21.model.empleados.EmpleadoNoDeportivo;
import ips2023pl21.model.empleados.JugadorProfesional;
import ips2023pl21.model.entradas.EntradaEntity;
import ips2023pl21.model.horarios.Entrevista;
import ips2023pl21.model.horarios.FranjaPuntual;
import ips2023pl21.model.horarios.FranjaSemanal;
import ips2023pl21.model.horarios.HorarioPuntual;
import ips2023pl21.model.horarios.HorarioSemanal;
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

	public List<Entrevista> selectEntrevistas() {
		List<Entrevista> result = db.executeQueryPojo(Entrevista.class, "select * from Entrevista");
		return result;
	}

	public void insertEntrevista(String fechaSel, String datosMedio, String horaInicio, String horaFin, int eid) {
		db.executeUpdate(
				"insert into Entrevista(fechaEntrevista, datosMedio, horaInicio, horaFin, eid) values (?,?,?,?,?)",
				fechaSel, datosMedio, horaInicio, horaFin, eid);
	}

	// JUGADORES PROFESIONALES

	public List<JugadorProfesional> selectJugadoresProfesionales() {
		return db.executeQueryPojo(JugadorProfesional.class, "select * from JugadorProfesional");
	}

	public JugadorProfesional getJugador(int id) {
		JugadorProfesional result = db.executeQueryPojo(JugadorProfesional.class,
				"select * from JugadorProfesional where eid=%d".formatted(id)).get(0);
		return result;
	}

	public List<JugadorProfesional> getJugadoresLibres(String fechaSel) {

		List<Integer> idsJugadoresConEntrevista = new ArrayList<>();

		for (Entrevista entrevista : selectEntrevistas()) {

			if (entrevista.getFechaEntrevista().equals(fechaSel))
				idsJugadoresConEntrevista.add(entrevista.getEid());

		}

		List<JugadorProfesional> jugadoresLibres = new ArrayList<>();

		for (JugadorProfesional jugador : selectJugadoresProfesionales()) {
			if (!idsJugadoresConEntrevista.contains(jugador.getEid())) {
				jugadoresLibres.add(jugador);
			}
		}

		return jugadoresLibres;

	}

	// EMPLEADOS NO DEPORTIVOS

	public List<EmpleadoNoDeportivo> selectEmpleadosNoDeportivos() {
		List<EmpleadoNoDeportivo> result = db.executeQueryPojo(EmpleadoNoDeportivo.class,
				"select * from empleadonodeportivo");

		return result;
	}

	public EmpleadoNoDeportivo getEmpleadoNoDeportivo(int eid) {
		return db.executeQueryPojo(EmpleadoNoDeportivo.class, "select * from empleadonodeportivo where eid=?", eid)
				.get(0);
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
	
	//ABONOS
	public void insertAbono(String tribuna, String seccion, int fila, int asiento, double precio, String dateString) {
		db.executeUpdate("insert into abono (tribuna, seccion, fila, asiento, precio, fechaCaducidad) values (?,?,?,?,?,?)",
				tribuna, seccion, fila, asiento, precio, dateString);
	}

	public List<Abono> selectAbono(String tribuna, String seccion, int fila, int asiento) {
		 return db.executeQueryPojo(Abono.class, "select * from abono where tribuna=? and seccion=? and fila=? and asiento=?" , tribuna, seccion, fila,asiento);
	}

	public List<EntradaEntity> getAsientosOcupados(String tribuna, String seccion) { //aqui cambiar abono por entrada y aplicar herencia
		return db.executeQueryPojo(EntradaEntity.class, "select * from abono where tribuna=? and seccion=?", tribuna, seccion);
		
	}
}
