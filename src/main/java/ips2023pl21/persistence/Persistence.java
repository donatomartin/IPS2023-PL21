package ips2023pl21.persistence;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import ips2023pl21.model.Empleado;
import ips2023pl21.model.Usuario;
import ips2023pl21.model.abonos.Abono;
import ips2023pl21.model.equipos.CategoriaEquipo;
import ips2023pl21.model.equipos.EquipoDeportivo;
import ips2023pl21.model.equipos.EquipoEnFormacion;
import ips2023pl21.model.equipos.EquipoProfesional;
import ips2023pl21.model.equipos.Partido;
import ips2023pl21.model.activos.Instalacion;
import ips2023pl21.model.activos.Merchandaising;
import ips2023pl21.model.activos.TiendaLogica;
import ips2023pl21.model.compras.Compra;
import ips2023pl21.model.compras.JugadoresEnVenta;
import ips2023pl21.model.entradas.EntradaEntity;
import ips2023pl21.model.equipos.Equipo;
import ips2023pl21.model.horarios.HorarioEntrenamiento;
import ips2023pl21.model.acciones.Accion;
import ips2023pl21.model.acciones.Accionista;
import ips2023pl21.model.acciones.AmpliacionCapital;
import ips2023pl21.model.horarios.HorarioEntrevista;
import ips2023pl21.model.horarios.HorarioJardineria;
import ips2023pl21.model.horarios.HorarioPuntual;
import ips2023pl21.model.horarios.HorarioSemanal;
import ips2023pl21.model.horarios.franjas.FranjaPuntual;
import ips2023pl21.model.horarios.franjas.FranjaSemanal;
import ips2023pl21.model.lesiones.Actualizacion;
import ips2023pl21.model.lesiones.Juega;
import ips2023pl21.model.lesiones.Lesion;
import ips2023pl21.model.noticias.Noticia;
import ips2023pl21.model.ventas.VentaDisplayDTO;
import ips2023pl21.service.State;
import ips2023pl21.util.Database;
import ips2023pl21.util.Util;
import ips2023pl21.ui.UserInterface;

public class Persistence {

	// Singleton
	private static Persistence p = new Persistence();

	private Database db = new Database();
	private Logger logger;

	private Persistence() {
		db = new Database();
		db.createDatabase(false);
		db.loadDatabase();

		logger = new Logger("Unknown");
	}

	public static Persistence getInstance() {
		return p;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	// ENTREVISTAS

	public boolean existeEntrevista(String fecha, int eid) {
		List<HorarioEntrevista> result = db.executeQueryPojo(HorarioEntrevista.class,
				"select * from HorarioEntrevista where fechaEntrevista=? and eid=?", fecha, eid);
		
		logger.logSelect("HorarioEntrevista");
		return !result.isEmpty();
	}

	public List<HorarioEntrevista> selectHorariosEntrevistasAsignados() {
		List<HorarioEntrevista> result = db.executeQueryPojo(HorarioEntrevista.class,
				"select * from HorarioEntrevista where datosmedio is not null");
		
		logger.logSelect("HorarioEntrevista");
		return result;
	}

	public List<HorarioEntrevista> selectHorariosEntrevistasNoAsignados() {
		List<HorarioEntrevista> result = db.executeQueryPojo(HorarioEntrevista.class,
				"select * from HorarioEntrevista where datosmedio is null");
		
		logger.logSelect("HorarioEntrevista");
		return result;
	}

	public void insertHorarioEntrevista(String fecha, String horaInicio, String horaFin, int eid)
			throws IllegalStateException {
		checkHorarioEntrenamiento(eid, fecha, horaInicio, horaFin);

		db.executeUpdate("insert into HorarioEntrevista (fechaEntrevista, horaInicio, horaFin, eid) values (?,?,?,?)",
				fecha, horaInicio, horaFin, eid);
		logger.logInsert("HorarioEntrevista", fecha + " para " + getEmpleado(eid).getNombre());
	}

	public void asignaHorarioEntrevista(HorarioEntrevista he, String datosMedio) {

		db.executeUpdate("update HorarioEntrevista set datosMedio=? where fechaEntrevista=? and eid=?", datosMedio,
				he.getFechaEntrevista(), he.getEid());
		
		String datos = datosMedio + ", " + he.getFechaEntrevista() + ", " + he.getEid();
		logger.logUpdate("HorarioEntrevista",datos,"datosMedio, fechaEntrevista, eid");
	}

	public void deleteHorarioEntrevista(int eqid, String fecha, String horaInicio, String horaFin) {

		db.executeUpdate(
				"delete from HorarioEntrevista where eid=? and fechaEntrevista=? and horaInicio=? and horaFin=?", eqid,
				fecha, horaInicio, horaFin);
		logger.logDelete("HorarioEntrevista", "horarios " + fecha + " " + horaInicio + " " + horaFin);
	}

	// INSTALACIONES

	public List<Instalacion> selectInstalaciones() {
		List<Instalacion> result = db.executeQueryPojo(Instalacion.class, "select * from Instalacion");
		
		logger.logSelect("Instalacion");
		return result;
	}

	public Instalacion getInstalacion(int id) {
		
		logger.logSelect("Instalacion"); 
		return db.executeQueryPojo(Instalacion.class, "select * from Instalacion where id=?", id).get(0);
		
	}

	// EMPLEADOS

	public Empleado getEmpleado(int eid) {
		List<Empleado> result = db.executeQueryPojo(Empleado.class, "select * from Empleado where eid=?", eid);
		
		logger.logSelect("Empleado");
		if (result.size() > 0)
			return result.get(0);
		return null;
	}

	public Empleado getEmpleado(String nombre, String apellido, String dni) {
		logger.logSelect("Empleado");
		return db.executeQueryPojo(Empleado.class, "select * from Empleado where nombre=? and apellido=? and dni=?",
				nombre, apellido, dni).get(0);
	}

	public List<Empleado> selectEmpleadosNoDeportivos() {
		logger.logSelect("Empleado");
		return db.executeQueryPojo(Empleado.class, "select * from Empleado where tipo = 'nodeportivo'");
	}

	public List<Empleado> selectEmpleadosDeportivos() {
		logger.logSelect("Empleado");
		return db.executeQueryPojo(Empleado.class, "select * from Empleado where tipo = 'deportivo'");
	}

	public List<Empleado> selectEntrenadores() {
		logger.logSelect("Empleado");
		return db.executeQueryPojo(Empleado.class, "select * from Empleado where posicion = 'entrenador'");
	}

	public List<Empleado> selectJugadores() {
		logger.logSelect("Empleado");
		return db.executeQueryPojo(Empleado.class, "select * from Empleado where posicion = 'jugador'");
	}

	public List<Empleado> selectJugadoresProfesionales() {
		logger.logSelect("Empleado");
		return db.executeQueryPojo(Empleado.class, "select * from Empleado where posicion = 'jugador'");
	}

	public List<Empleado> selectJardineros() {
		logger.logSelect("Empleado");
		return db.executeQueryPojo(Empleado.class, "select * from Empleado where posicion = 'jardineria'");
	}

	public List<Empleado> selectJardinerosLibres(List<HorarioJardineria> hna, String fecha, String horaInicio,
			String horaFin, int iid) {

		LocalTime sHoraInicio = Util.stringHoraToLocalTime(horaInicio);
		LocalTime sHoraFin = Util.stringHoraToLocalTime(horaFin);
		Date sFecha = Util.isoStringToDate(fecha);

		Set<Integer> idsJardinerosLibres = new HashSet<>();
		List<Empleado> jardinerosLibres = new ArrayList<>();

		for (FranjaSemanal fs : getFranjasSemanales(HorarioSemanal.getDiaDeLaSemana(fecha))) {

			LocalTime pHoraInicio = fs.getParsedInicio();
			LocalTime pHoraFin = fs.getParsedFin();

			Date pFecha = Util.isoStringToDate(fs.getFechaInicio());

			if (sFecha.before(pFecha))
				continue;

			if (contenido(sHoraInicio, sHoraFin, pHoraInicio, pHoraFin))
				idsJardinerosLibres.add(fs.getEid());
		}

		for (FranjaPuntual fp : getFranjasPuntuales(fecha)) {
			LocalTime pHoraInicio = fp.getParsedInicio();
			LocalTime pHoraFin = fp.getParsedFin();

			if (contenido(sHoraInicio, sHoraFin, pHoraInicio, pHoraFin))
				idsJardinerosLibres.add(fp.getEid());
		}

		if (idsJardinerosLibres.size() == 0)
			return jardinerosLibres;

		List<HorarioJardineria> horarios = selectHorariosJardineria();
		horarios.addAll(hna);

		for (HorarioJardineria jardineria : horarios) {

			if (jardineria.getFechaJardineria().equals(fecha)) {

				LocalTime pHoraInicio = jardineria.getParsedInicio();
				LocalTime pHoraFin = jardineria.getParsedFin();

				if (solapa(sHoraInicio, sHoraFin, pHoraInicio, pHoraFin))
					idsJardinerosLibres.remove(jardineria.getEid());
			}
		}

		for (Empleado j : selectJardineros())
			if (idsJardinerosLibres.contains(j.getEid()))
				jardinerosLibres.add(j);

		return jardinerosLibres;
	}

	public static boolean contenido(LocalTime horaInicio1, LocalTime horaFin1, LocalTime horaInicio2,
			LocalTime horaFin2) {
		return ((horaInicio1.isAfter(horaInicio2) || horaInicio1.equals(horaInicio2))
				&& (horaFin1.isBefore(horaFin2) || horaFin1.equals(horaFin2)));
	}

	public static boolean solapa(LocalTime horaInicio1, LocalTime horaFin1, LocalTime horaInicio2, LocalTime horaFin2) {
		return (horaInicio1.isBefore(horaFin2) && horaFin1.isAfter(horaInicio2))
				|| (horaInicio2.isBefore(horaFin1) && horaFin2.isAfter(horaInicio1)
						|| (coincidenBordes(horaInicio1, horaInicio2, horaFin1, horaFin2)));
	}

	public static boolean coincidenBordes(LocalTime horaInicio1, LocalTime horaFin1, LocalTime horaInicio2,
			LocalTime horaFin2) {

		if (Util.localTimeToString(horaInicio1).equals(Util.localTimeToString(horaInicio2)))
			return true;
		if (Util.localTimeToString(horaFin1).equals(Util.localTimeToString(horaFin2)))
			return true;

		return false;
	}

	public List<Empleado> selectJugadoresLibres(String fechaSel) {

		List<Integer> idsJugadoresConEntrevista = new ArrayList<>();

		for (HorarioEntrevista entrevista : selectHorariosEntrevistasAsignados()) {

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

		posicion = Util.normalizeString(posicion);

		db.executeUpdate(
				"insert into Empleado(nombre, apellido, dni, fechaNacimiento, salarioAnual, telefono, tipo, posicion) values (?,?,?,?,?,?,?,?)",
				nombre, apellido, dni, fechaNacimiento, salario, telefono, tipo, posicion);
		logger.logInsert("Empleado", nombre);

	}

	public void deleteEmpleado(String nombre, String apellido, String dni, String tipo) {
		String sqlElimminar = "delete from empleado where nombre = ? and apellido = ? and dni = ? and tipo = ?";
		db.executeUpdate(sqlElimminar, nombre, apellido, dni, tipo);
		logger.logDelete("Empleado", dni);
	}

	public void updateEmpleado(String nombre, String apellido, String dni, String fecha, double salario,
			String telefono, Object posicion, String nombreEmpleadoGestion, String apellidoEmpleadoGestion,
			String dniEmpleadoGestion) {
		String updateEmpleado = "update empleado set nombre = ?, apellido = ?, dni = ?, fechaNacimiento = ?, "
				+ "salarioAnual = ?, telefono = ?, posicion = ?" + "where nombre = ? and apellido = ? and dni = ?";
		db.executeUpdate(updateEmpleado, nombre, apellido, dni, fecha, salario, telefono, posicion,
				nombreEmpleadoGestion, apellidoEmpleadoGestion, dniEmpleadoGestion);
		
		String datos = nombre+ ", " +apellido+ ", " +dni+ ", " +fecha+ ", " +salario+ ", " +telefono+ ", " +posicion+ ", " +
				nombreEmpleadoGestion+ ", " +apellidoEmpleadoGestion+ ", " +dniEmpleadoGestion;
		logger.logUpdate("empleado",datos,"nombre, apellido, dni, fechaNacimiento, salarioAnual, telefono, posicion");
	}

	public List<Empleado> getEmpleados() {	
		logger.logSelect("Empleado");
		return db.executeQueryPojo(Empleado.class, "select * from empleado");

	}

	// HORARIO SEMANAL

	public List<HorarioSemanal> selectHorariosSemanales(String fecha) {
		int diaSemana = HorarioSemanal.getNumeroDia(fecha);
		
		logger.logSelect("HorarioSemanal");
		return db.executeQueryPojo(HorarioSemanal.class, "select * from HorarioSemanal where diaSemana=?", diaSemana)
				.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
	}

	public List<HorarioSemanal> selectHorariosSemanales() {

		List<HorarioSemanal> result = db.executeQueryPojo(HorarioSemanal.class, "select * from HorarioSemanal").stream()
				.sorted().collect(Collectors.toList());
		
		logger.logSelect("HorarioSemanal");
		return result;
	}

	public List<HorarioSemanal> selectHorariosSemanales(int eid) {
		List<HorarioSemanal> result = db
				.executeQueryPojo(HorarioSemanal.class, "select * from HorarioSemanal where eid=?", eid).stream()
				.sorted().collect(Collectors.toList());
		
		logger.logSelect("HorarioSemanal");
		return result;
	}

	public HorarioSemanal getHorarioSemanal(int eid, int numeroDiaSemana, String fechaInicio) {
		
		logger.logSelect("HorarioSemanal");
		return db.executeQueryPojo(HorarioSemanal.class,
				"select * from HorarioSemanal where eid=? and diaSemana=? and fechaInicio=?", eid, numeroDiaSemana,
				fechaInicio).get(0);
	}

	public void insertHorarioSemanal(int diaSemana, String fechaString, int eid) {
		db.executeUpdate("insert into HorarioSemanal(diaSemana, fechaInicio, eid) values (?, ?, ?)", diaSemana,
				fechaString, eid);
		logger.logInsert("HorarioSemanal", diaSemana + " " + fechaString + " para " + getEmpleado(eid).getNombre());
	}

	public void updateFechaFin(int eid, HorarioSemanal actual, String fechaFinString) {
		db.executeUpdate("update HorarioSemanal set fechaFin=? where eid=? and diaSemana=? and fechaInicio=?",
				fechaFinString, eid, actual.getDiaSemana(), actual.getFechaInicio());
		
		String datos = fechaFinString;
		logger.logUpdate("HorarioSemanal",datos,"fechaFin");
	}

	public void deleteFechaFin(int eid, HorarioSemanal ultimoHorario) {
		db.executeUpdate("update HorarioSemanal set fechaFin=null where eid=? and diaSemana=? and fechaInicio=?", eid,
				ultimoHorario.getDiaSemana(), ultimoHorario.getFechaInicio());
		
		String datos = "null";
		logger.logUpdate("HorarioSemanal",datos,"fechaFin");
	}

	public void insertFranjaSemanal(int dia, String fechaInicio, int eid, String horaInicio, String horaFin) {
		db.executeUpdate(
				"insert into FranjaSemanal(diaSemana, fechaInicio, eid, horaInicio, horaFin) values (?, ?, ?, ?, ?)",
				dia, fechaInicio, eid, horaInicio, horaFin);
		logger.logInsert("FranjaSemanal", dia + " " + fechaInicio + " para " + getEmpleado(eid).getNombre());
	}

	public void deleteHorarioSemanal(int dia, String fechaInicio, int eid) {
		db.executeUpdate("delete from HorarioSemanal where diaSemana=? and fechaInicio=? and eid=?", dia, fechaInicio,
				eid);
		db.executeUpdate("delete from FranjaSemanal where diaSemana=? and fechaInicio=? and eid=?", dia, fechaInicio,
				eid);
		logger.logDelete("HorarioSemanal / FranjaSemanal", "horarios para el empleado " + getEmpleado(eid).getNombre() + " " + fechaInicio);
	}

	public List<FranjaSemanal> getFranjasSemanales(int diaSem, String fechaInicio, int eid) {
		List<FranjaSemanal> result = db.executeQueryPojo(FranjaSemanal.class,
				"select * from FranjaSemanal where diaSemana=? and fechaInicio=? and eid=?", diaSem, fechaInicio, eid)
				.stream().sorted().collect(Collectors.toList());
		
		logger.logSelect("FranjaSemanal");
		return result;
	}

	public List<FranjaSemanal> getFranjasSemanales(int diaSem, String fechaInicio) {
		List<FranjaSemanal> result = db
				.executeQueryPojo(FranjaSemanal.class,
						"select * from FranjaSemanal where diaSemana=? and fechaInicio=?", diaSem, fechaInicio)
				.stream().sorted().collect(Collectors.toList());
		
		logger.logSelect("FranjaSemanal");
		return result;
	}

	public List<FranjaSemanal> getFranjasSemanales(int diaSem) {

		List<FranjaSemanal> franjas = db
				.executeQueryPojo(FranjaSemanal.class, "select * from FranjaSemanal where diaSemana=?", diaSem).stream()
				.sorted().collect(Collectors.toList());
		
		logger.logSelect("FranjaSemanal");
		return franjas;
	}

	// HORARIO PUNTUAL

	public List<HorarioPuntual> selectHorariosPuntuales(String fecha) {
		List<HorarioPuntual> result = db.executeQueryPojo(HorarioPuntual.class,
				"select * from HorarioPuntual where fechaPuntual=?", fecha);
		
		logger.logSelect("HorarioPuntual");
		return result;

	}

	public List<HorarioPuntual> selectHorariosPuntuales(int eid) {
		List<HorarioPuntual> result = db
				.executeQueryPojo(HorarioPuntual.class, "select * from HorarioPuntual where eid=?", eid).stream()
				.sorted().collect(Collectors.toList());
		
		
		logger.logSelect("HorarioPuntual");
		return result;
	}

	public HorarioPuntual getHorarioPuntual(int eid, String fechaPuntual) {
		
		logger.logSelect("HorarioPuntual");
		return db.executeQueryPojo(HorarioPuntual.class, "select * from HorarioPuntual where eid=? and fechaPuntual=?",
				eid, fechaPuntual).get(0);
	}

	public void insertHorarioPuntual(String fechaString, int eid) {
		db.executeUpdate("insert into HorarioPuntual(fechaPuntual, eid) values (?, ?)", fechaString, eid);
		logger.logInsert("HorarioPuntual", fechaString + " para " + getEmpleado(eid).getNombre());
	}

	public void insertFranjaPuntual(String fechaPun, int eid, String horaInicio, String horaFin) {
		db.executeUpdate("insert into FranjaPuntual(fechaPuntual, eid, horaInicio, horaFin) values (?, ?, ?, ?)",
				fechaPun, eid, horaInicio, horaFin);
		logger.logInsert("FranjaPuntual", fechaPun + " para " + getEmpleado(eid).getNombre());
	}

	public void removeHorarioPuntual(String fechaPun) {
		db.executeUpdate("delete from HorarioPuntual where fechaPuntual=?", fechaPun);
		db.executeUpdate("delete from FranjaPuntual where fechaPuntual=?", fechaPun);
		logger.logDelete("HorarioPuntual", fechaPun);
	}

	public List<FranjaPuntual> getFranjasPuntuales(String fechaPuntual, int eid) {
		List<FranjaPuntual> result = db.executeQueryPojo(FranjaPuntual.class,
				"select * from FranjaPuntual where fechaPuntual=? and eid=?", fechaPuntual, eid).stream().sorted()
				.collect(Collectors.toList());
		
		logger.logSelect("FranjaPuntual");
		return result;
	}

	public List<FranjaPuntual> getFranjasPuntuales(String fechaPuntual) {
		List<FranjaPuntual> result = db
				.executeQueryPojo(FranjaPuntual.class, "select * from FranjaPuntual where fechaPuntual=?", fechaPuntual)
				.stream().sorted().collect(Collectors.toList());
		
		logger.logSelect("FranjaPuntual");
		return result;
	}

	// CAPITAL CLUB
	public float getCapitalClub() {
		List<AmpliacionCapital> ac = db.executeQueryPojo(AmpliacionCapital.class, "select * from ampliacionCapital");
		float result = ac.get(0).getCapitalTotal();
		
		logger.logSelect("ampliacionCapital");
		return result;
	}

	public int getAccionesClub() {
		List<AmpliacionCapital> ac = db.executeQueryPojo(AmpliacionCapital.class, "select * from ampliacionCapital");
		int result = ac.get(0).getAccionesTotales();
		
		logger.logSelect("ampliacionCapital");
		return result;
	}

	// ABONOS
	public void insertAbono(String tribuna, String seccion, int fila, int asiento, double precio, String dateString) {
		db.executeUpdate(
				"insert into abono (tribuna, seccion, fila, asiento, precio, fechaCaducidad) values (?,?,?,?,?,?)",
				tribuna, seccion, fila, asiento, precio, dateString);
		logger.logInsert("Abono", tribuna + " " + seccion + " " + fila + " " + asiento);
	}

	public List<Abono> selectAbono(String tribuna, String seccion, int fila, int asiento) {
		logger.logSelect("abono");
		return db.executeQueryPojo(Abono.class,
				"select * from abono where tribuna=? and seccion=? and fila=? and asiento=?", tribuna, seccion, fila,
				asiento);
	}

	public List<EntradaEntity> getAbonos(String tribuna, String seccion) {
		logger.logSelect("abono");
		return db.executeQueryPojo(EntradaEntity.class, "select * from abono where tribuna=? and seccion=?", tribuna,
				seccion);

	}

	public List<EntradaEntity> getAbonosFila(String tribuna, String seccion, int fila) {
		logger.logSelect("abono");
		return db.executeQueryPojo(EntradaEntity.class, "select * from abono where tribuna=? and seccion=? and fila=?",
				tribuna, seccion, fila);
	}

	// ENTRADA

	public void insertarEntrada(String tribuna, String seccion, int fila, int asientoInicial, int i) {
		String queryEntrada = "Insert into Entrada(tribuna, seccion, fila, asiento, precio) VALUES (?,?,?,?,?)";
		db.executeUpdate(queryEntrada, tribuna, seccion, fila, asientoInicial, i);
		logger.logInsert("Entrada", tribuna + " " + seccion + " " + fila);

	}

	public List<EntradaEntity> getTotalEntradas(String tribuna, String seccion, int fila) {
		String query = "SELECT * FROM entrada where tribuna=? and seccion=? and fila=?";
		logger.logSelect("entrada");
		return db.executeQueryPojo(EntradaEntity.class, query, tribuna, seccion, fila);
	}

	// NOTICIAS
	public void insertNoticia(String titulo, String subtitulo, String cuerpo, String img) {
		db.executeUpdate("insert into noticia (titulo, subtitulo, cuerpo, img) values (?,?,?,?)", titulo, subtitulo,
				cuerpo, img);
		logger.logInsert("Noticia", titulo);
	}

	public List<Noticia> selectNoticias() {
		logger.logSelect("noticia");
		return db.executeQueryPojo(Noticia.class, "select * from noticia");

	}

	// EQUIPOS

	public void insertEquipo(EquipoDeportivo equipo) {
		CategoriaEquipo categoria = null;
		boolean filial = false;

		if (equipo instanceof EquipoEnFormacion) {
			categoria = ((EquipoEnFormacion) equipo).categoria;
		} else {
			filial = ((EquipoProfesional) equipo).isFilial();
		}
		db.executeUpdate("insert into Equipo(peid,seid,nombre, categoria, esFilial) values (?,?,?,?,?)",
				equipo.getPrimerEntrenador().getEid(), equipo.getSegundoEntrenador().getEid(), equipo.getNombre(),
				categoria, filial);

		String eqid = selectEquipoPorNombre(equipo.getNombre()).getId();

		for (Empleado j : equipo.getJugadoresEquipo()) {
			db.executeUpdate("insert into Juega(eqid,eid) values (?,?)", eqid, j.getEid());
		}
		
		logger.logInsert("Equipo / Juega", equipo.getNombre());
	}

	public List<EquipoDeportivo> selectEquipo() {
		List<Object[]> equipos = db.executeQueryArray("select * from Equipo");
		List<EquipoDeportivo> ret = new ArrayList<>();

		for (Object[] o : equipos) {
			EquipoDeportivo equipo = new EquipoDeportivo();
			equipo.setId(o[0].toString());
			equipo.setNombre(o[3].toString());

			ret.add(equipo);
		}
		
		logger.logSelect("Equipo");
		return ret;
	}

	public EquipoDeportivo selectEquipoPorNombre(String nombre) {

		List<Object[]> equipo = db.executeQueryArray("select * from Equipo where nombre = ?", nombre);
		EquipoDeportivo ret = null;

		if (equipo.size() > 0) {
			ret = new EquipoDeportivo();
			ret.setId(equipo.get(0)[0].toString());
			ret.setNombre(equipo.get(0)[3].toString());
		}

		logger.logSelect("Equipo");
		return ret;
	}

	public EquipoDeportivo selectEquipoPorId(String id) {
		List<Object[]> equipo = db.executeQueryArray("select * from Equipo where id = ?", id);
		EquipoDeportivo ret = new EquipoDeportivo();

		ret.setId(equipo.get(0)[0].toString());
		ret.setNombre(equipo.get(0)[3].toString());

		logger.logSelect("Equipo");
		return ret;
	}

	public int getEquipoIdByEmpleadoId(int eid) {

		try {
			var res = db.executeQueryArray("select eqid from juega where eid=?", eid);
			String str = (String) res.get(0)[0].toString();
			
			logger.logSelect("juega");
			return Integer.parseInt(str);
		} catch (Exception e) {
			return -1;
		}

	}

	private int getEmpleadoIdByEquipoId(int eqid) {
		try {
			var res = db.executeQueryArray("select eid from juega where eqid=?", eqid);
			String str = (String) res.get(0)[0].toString();
			
			logger.logSelect("juega");
			return Integer.parseInt(str);
		} catch (Exception e) {
			return -1;
		}
	}

	public String getNombreEquipoByEmpleadoId(int eid) {

		try {
			int id = getEquipoIdByEmpleadoId(eid);
			var res = db.executeQueryArray("select nombre from equipo where id=?", id);
			var res1 = (String) res.get(0)[0];
			
			logger.logSelect("Equipo");
			return res1;
		} catch (Exception e) {
			return null;
		}

	}

	// PARTIDOS

	public void insertPartido(Partido partido) {
		db.executeUpdate("insert into Partido(id, idEquipo, equipoVisitante, fecha, suplemento) values (?,?,?,?,?)",
				partido.getId(), partido.getLocal().getId(), partido.getVisitante(), partido.getFecha(),
				partido.getSuplemento());
		logger.logInsert("Partido", partido.getFecha());
	}

	public List<Partido> selectPartidosPorIdEquipo(String id) {
		List<Object[]> partidos = db.executeQueryArray("select * from Partido where idEquipo = ?", id);

		List<Partido> ret = new ArrayList<>();

		for (Object[] o : partidos) {
			Partido p = new Partido();

			p.setId(o[0].toString());
			p.setLocal(selectEquipoPorId(o[1].toString()));
			p.setVisitante(o[2].toString());
			p.setFecha(o[3].toString());
			p.setSuplemento(Float.parseFloat(o[4].toString()));

			ret.add(p);
		}
		
		logger.logSelect("Partido");
		return ret;
	}

	public List<Partido> selectPartidosPorId(String id) {
		List<Object[]> partidos = db.executeQueryArray("select * from Partido where id = ?", id);

		List<Partido> ret = new ArrayList<>();

		for (Object[] o : partidos) {
			Partido p = new Partido();

			p.setId(o[0].toString());
			p.setLocal(selectEquipoPorId(o[1].toString()));
			p.setVisitante(o[2].toString());
			p.setFecha(o[3].toString());
			p.setSuplemento(Float.parseFloat(o[4].toString()));

			ret.add(p);
		}
		
		logger.logSelect("Partido");
		return ret;
	}

	public boolean existsPartido(Partido partido) {

		if (partido != null) {
			String idEquipo = partido.getLocal().getId();
			String visitante = partido.getVisitante();
			String fecha = partido.getFecha();

			List<Object[]> partidos = db.executeQueryArray(
					"select * from Partido where idEquipo = ? and " + "equipoVisitante = ? and fecha = ?", idEquipo,
					visitante, fecha);
			
			logger.logSelect("Partido");
			return partidos.size() == 0 ? false : true;
		}
		return false;
	}

	// ABONADOS

	public boolean existsIdAbonado(String id) {
		List<Object[]> abonado = db.executeQueryArray("select * from Abonado where id = ?", id);
		if (abonado.size() == 1) {
			logger.logSelect("Abonado");
			return true;
		}
		return false;

	}

	public List<String> selectIdsAbonados() {
		List<Object[]> abonados = db.executeQueryArray("select * from Abonado");
		List<String> ids = new ArrayList<>();

		for (Object[] o : abonados) {
			ids.add(o[0].toString());
		}
		logger.logSelect("Abonado");
		return ids;
	}

	public void updateAbonadoSorteo(String idAbonado) {
		db.executeUpdate("update Abonado set sorteo = 1 where id = ?", idAbonado);
		
		String datos = "1";
		logger.logUpdate("Abonado",datos,"sorteo");
	}

	public void deleteGanadorAbonado(String idAbonado) {
		db.executeUpdate("update Abonado set sorteo = 0 where id = ?", idAbonado);

		String datos = "0";
		logger.logUpdate("Abonado",datos,"sorteo");
	}

	public void insertPartidoAbonado(String idAbonado, Partido partido) {
		db.executeUpdate("insert into PartidoAbonado(idAbonado, idPartido) values (?,?)", idAbonado, partido.getId());
		logger.logInsert("PartidoAbonado", partido.getFecha());

	}

	public List<Partido> getPartidosNoSeleccionadosPorAbonadoYEquipo(String idAbonado, String idEquipo) {
		List<Partido> partidos = selectPartidosPorIdEquipo(idEquipo);

		List<Partido> partidosAbonados = selectPartidosAbonadosPorIdAbonado(idAbonado);
		List<Partido> ret = new ArrayList<>();

		for (Partido p : partidos) {
			if (!partidosAbonados.contains(p)) {
				ret.add(p);
			}
		}
		return ret;
	}

	public List<Partido> selectPartidosAbonadosPorIdAbonado(String idAbonado) {
		List<Object[]> partidosAbonados = db.executeQueryArray("select * from PartidoAbonado where idAbonado = ?",
				idAbonado);
		List<Partido> ret = new ArrayList<>();

		for (Object[] o : partidosAbonados) {
			String idPartido = o[1].toString();
			ret.addAll(selectPartidosPorId(idPartido));
		}
		
		logger.logSelect("PartidoAbonado");
		return ret;

	}

	public void borrarAbonado(String tribuna, String seccion, int fila, int asiento) {
		db.executeUpdate("remove from abono where tribuna=?, seccion=?, fila=?, asiento=?", tribuna, seccion, fila,
				asiento);
		logger.logMessage("Abonado borrado");

	}

	public void insertAbonado(String nombre) {
		db.executeUpdate("insert into abonado (nombre) values (?)", nombre);
		db.executeUpdate("insert into abonado (nombre,sorteo) values (?,0)", nombre);
		logger.logInsert("Abonado", nombre);

	}

	public List<Object[]> getIdAbonado() {
		logger.logSelect("abonado");

		return db.executeQueryArray("select max(id)from abonado");
	}

	public boolean isGanadorSorteo(int idAbonado) {
		if (existsIdAbonado(String.valueOf(idAbonado))) {
			List<Object[]> ganador = db.executeQueryArray("select * from abonado where id = ?", idAbonado);
			int res = Integer.parseInt(ganador.get(0)[2].toString());
			
			logger.logSelect("abonado");
			return res == 1;
		}
		return false;

	}

	// HORARIO JARDINERIA

	public List<HorarioJardineria> selectHorariosJardineria() {
		List<HorarioJardineria> result = db.executeQueryPojo(HorarioJardineria.class,
				"select * from HorarioJardineria");
		
		logger.logSelect("HorarioJardineria");

		return result;
	}

	public List<HorarioJardineria> selectHorariosJardineria(int iid) {
		List<HorarioJardineria> result = db.executeQueryPojo(HorarioJardineria.class,
				"select * from HorarioJardineria where iid=?", iid);
		
		logger.logSelect("HorarioJardineria");

		return result;
	}

	public void insertHorarioJardineria(int eid, int iid, String fecha, String horaInicio, String horaFin)
			throws IllegalStateException {
		checkHorarioEntrenamiento(iid, fecha, horaInicio, horaFin);
		db.executeUpdate(
				"insert into HorarioJardineria (fechaJardineria, horaInicio, horaFin, eid, iid) values (?,?,?,?,?)",
				fecha, horaInicio, horaFin, eid, iid);
		logger.logInsert("HorarioJardineria", fecha + "para" + getEmpleado(eid).getNombre());
	}

	public void deleteHorarioJardineria(int eid, String fecha, String horaInicio, String horaFin) {
		db.executeUpdate(
				"delete from HorarioJardineria where fechaJardineria=? and horaInicio=? and horaFin=? and eid=?", fecha,
				horaInicio, horaFin, eid);
		logger.logDelete("HorarioJardineria", "horarios para el empleado " + getEmpleado(eid).getNombre());
	}

	// HORARIO ENTRENAMIENTO

	public List<HorarioEntrenamiento> selectHorariosEntrenamiento(int iid) {
		List<HorarioEntrenamiento> result = db.executeQueryPojo(HorarioEntrenamiento.class,
				"select * from HorarioEntrenamiento where iid=?", iid);
		
		logger.logSelect("HorarioEntrenamiento");

		return result;
	}

	public List<HorarioEntrenamiento> selectHorariosEntrenamiento(int iid, String fecha) {
		List<HorarioEntrenamiento> result = db.executeQueryPojo(HorarioEntrenamiento.class,
				"select * from HorarioEntrenamiento where iid=? and fechaEntrenamiento=?", iid, fecha);

		logger.logSelect("HorarioEntrenamiento");
		
		return result;
	}

	public List<HorarioEntrenamiento> selectHorariosEntrenamiento() {
		List<HorarioEntrenamiento> result = db.executeQueryPojo(HorarioEntrenamiento.class,
				"select * from HorarioEntrenamiento");

		logger.logSelect("HorarioEntrenamiento");
		
		return result;
	}

	public void insertHorarioEntrenamiento(int enid, int eqid, int iid, String fecha, String horaInicio, String horaFin,
			UserInterface ui) {

		LocalTime sHoraInicio = Util.stringHoraToLocalTime(horaInicio);
		LocalTime sHoraFin = Util.stringHoraToLocalTime(horaFin);

		for (HorarioJardineria hj : selectHorariosJardineria()) {

			if (iid != hj.getIid())
				continue;

			if (!fecha.equals(hj.getFechaJardineria()))
				continue;

			LocalTime pHoraInicio = hj.getParsedInicio();
			LocalTime pHoraFin = hj.getParsedFin();

			if (solapa(pHoraInicio, pHoraFin, sHoraInicio, sHoraFin)) {
				if (ui.confirm("Estás seguro? Hay horarios de jardinería que serán eliminados si continúas.")) {
					deleteHorarioJardineria(hj.getEid(), fecha, Util.localTimeToString(pHoraInicio),
							Util.localTimeToString(pHoraFin));
					break;
				} else {
					return;
				}
			}
		}

		for (HorarioEntrevista he : selectHorariosEntrevistasAsignados()) {

			if (!fecha.equals(he.getFechaEntrevista()))
				continue;

			LocalTime pHoraInicio = he.getParsedInicio();
			LocalTime pHoraFin = he.getParsedFin();

			if (solapa(pHoraInicio, pHoraFin, sHoraInicio, sHoraFin)
					&& (he.getEid() == getEmpleadoIdByEquipoId(eqid))) {
				if (ui.confirm("Estás seguro? Hay entrevistas que serán eliminadas si continúas.")) {
					deleteHorarioEntrevista(he.getEid(), fecha, Util.localTimeToString(pHoraInicio),
							Util.localTimeToString(pHoraFin));
					break;
				} else {
					return;
				}
			}

		}

		insertaHorarioEntrenamientoInner(enid, eqid, iid, fecha, horaInicio, horaFin);

	}

	private void insertaHorarioEntrenamientoInner(int enid, int eid, int iid, String fecha, String horaInicio,
			String horaFin) {
		db.executeUpdate(
				"insert into HorarioEntrenamiento (fechaEntrenamiento, horaInicio, horaFin, enid, eid, iid) values (?,?,?,?,?,?)",
				fecha, horaInicio, horaFin, enid, eid, iid);
		logger.logInsert("HorarioEntrenamiento", fecha + " para " + getInstalacion(iid).getNombreInstalacion());
	}

	private void checkHorarioEntrenamiento(int id, String fecha, String horaInicio, String horaFin)
			throws IllegalStateException {

		LocalTime sHoraInicio = Util.stringHoraToLocalTime(horaInicio);
		LocalTime sHoraFin = Util.stringHoraToLocalTime(horaFin);

		for (HorarioEntrenamiento he : selectHorariosEntrenamiento()) {
			if (he.getFechaEntrenamiento().equals(fecha)
					&& (he.getIid() == id || he.getEid() == getEquipoIdByEmpleadoId(id))) {

				LocalTime pHoraInicio = he.getParsedInicio();
				LocalTime pHoraFin = he.getParsedFin();

				if (solapa(sHoraInicio, sHoraFin, pHoraInicio, pHoraFin))
					throw new IllegalStateException();
			}
		}
	}

	// EQUIPO

	public List<Equipo> selectEquipos(int eid) {
		List<Equipo> result = db.executeQueryPojo(Equipo.class, "select * from Equipo where peid=? or seid=?", eid,
				eid);

		logger.logSelect("Equipo");
		
		return result;
	}

	public List<Equipo> selectEquiposLibres(int eid, int iid, String fecha, String horaInicio, String horaFin) {

		LocalTime sHoraInicio = Util.stringHoraToLocalTime(horaInicio);
		LocalTime sHoraFin = Util.stringHoraToLocalTime(horaFin);

		Set<Integer> idsEquiposLibres = selectEquipos(eid).stream().map(x -> x.getId()).collect(Collectors.toSet());
		List<Equipo> equiposLibres = new ArrayList<>();

		for (HorarioEntrenamiento he : selectHorariosEntrenamiento()) {
			if (he.getFechaEntrenamiento().equals(fecha) && iid == he.getIid()) {

				LocalTime pHoraInicio = he.getParsedInicio();
				LocalTime pHoraFin = he.getParsedFin();

				if (solapa(sHoraInicio, sHoraFin, pHoraInicio, pHoraFin))
					idsEquiposLibres.remove(he.getEid());
			}
		}

		for (Equipo e : selectEquipos(eid))
			if (idsEquiposLibres.contains(e.getId()))
				equiposLibres.add(e);

		return equiposLibres;
	}

	public Equipo getEquipo(String nombre) {
		List<Equipo> result = db.executeQueryPojo(Equipo.class, "select * from Equipo where nombre=?", nombre);
		if (result.size() > 0) {
			logger.logSelect("Equipo");
			
			return result.get(0);
		}	
		return null;
	}

	public Equipo getEquipo(int id) {
		List<Equipo> result = db.executeQueryPojo(Equipo.class, "select * from Equipo where id=?", id);
		if (result.size() > 0) {
			logger.logSelect("Equipo");
			
			return result.get(0);
		}
		return null;
	}

	public List<Equipo> selectAllEquipos() {
		logger.logSelect("Equipo");
		
		return db.executeQueryPojo(Equipo.class, "select * from equipo");
		
	}

	// Articulos
	public List<Merchandaising> selectArticulos() {
		List<Object[]> articulos = db.executeQueryArray("select * from merchandaising");

		List<Merchandaising> ret = new ArrayList<>();

		for (Object[] o : articulos) {
			ret.add(new Merchandaising((int) o[0], o[1].toString(), o[2].toString(), (double) o[3]));
		}
		
		logger.logSelect("merchandaising");

		return ret;

	}

	public void insertVenta(TiendaLogica tl) {
		Calendar c = Calendar.getInstance();
		String fecha = c.get(Calendar.YEAR) + "-" + c.get(Calendar.MONTH) + "-" + c.get(Calendar.DAY_OF_MONTH);

		db.executeUpdate("insert into venta(concepto,fecha,hora,minuto,cuantia) values (?,?,?,?,?)", "merchandising",
				fecha, c.get(Calendar.HOUR), c.get(Calendar.MINUTE), tl.getPrecioTotal());

		for (Merchandaising a : tl.getSeleccionado()) {
			db.executeUpdate("insert into ventamerchandising(id,idProducto,cantidad)" + " values(?,?,?)",
					UUID.randomUUID().toString(), a.getId(), a.getUnidades());
		}

		logger.logInsert("Venta / VentaMerchandising", tl.getNombre());

	}

	// Ampliaciones capital
	public float getPrecioPorAccion() {
		List<AmpliacionCapital> ac = db.executeQueryPojo(AmpliacionCapital.class, "select * from ampliacionCapital");
		float result = ac.get(0).getPrecioAccion();
		
		logger.logSelect("ampliacionCapital");
		
		return result;
	}

	public void insertAmpliacion(int accionesNuevas) {
		int reset = 0;
		db.executeUpdate("update ampliacioncapital set faseUno = ?, fase = 'Fase 1', vendidas = ?", accionesNuevas,
				reset);
<<<<<<< HEAD
		
		String datos = accionesNuevas + ", " + "Fase 1, " + reset;
		logger.logUpdate("ampliacioncapital",datos,"faseUno, fase, vendidas");
=======
		logger.logInsert("AmpliacionCapital", "accionesNuevas: " + accionesNuevas);
>>>>>>> branch 'master' of https://github.com/DonatoMartin/IPS2023-PL21
	}

	public void updateLimiteFaseUno() {
		db.executeUpdate("update accionista set limiteAccionesFaseUno = numeroAcciones");
		
		String datos = "numeroAcciones";
		logger.logUpdate("accionista",datos,"limiteAccionesFaseUno");
	}

	public String getFase() {
		List<AmpliacionCapital> list = db.executeQueryPojo(AmpliacionCapital.class, "select * from ampliacioncapital");
		
		logger.logSelect("ampliacionCapital");
		return list.get(0).getFase();
	}

	public void updateFase(String fase) {
		db.executeUpdate("update ampliacioncapital set fase = ?", fase);
		
		String datos = fase;
		logger.logUpdate("ampliacioncapital",datos,"fase");
	}

	// ACCIONISTAS
	public int selectRestantesFase1() {
		logger.logSelect("ampliacionCapital");
		return db.executeQueryPojo(AmpliacionCapital.class, "select * from ampliacioncapital").get(0).getFaseUno();

	}

	public int selectRestantesFase2() {
		logger.logSelect("ampliacionCapital");
		return db.executeQueryPojo(AmpliacionCapital.class, "select * from ampliacioncapital").get(0).getFaseDos();

	}

	public int selectRestantesFase3() {
		logger.logSelect("ampliacionCapital");
		return db.executeQueryPojo(AmpliacionCapital.class, "select * from ampliacioncapital").get(0).getFaseTres();

	}

	public void updateAccionesFase1(int acc) {
		db.executeUpdate("update AmpliacionCapital set faseUno = ?", acc);
		
		String datos = String.valueOf(acc);
		logger.logUpdate("ampliacioncapital",datos,"faseUno");
	}

	public void updateAccionesFase2(int acc) {
		db.executeUpdate("update AmpliacionCapital set faseDos = ?", acc);
		
		String datos = String.valueOf(acc);
		logger.logUpdate("ampliacioncapital",datos,"faseDos");
	}

	public void updateAccionesFase3(int acc) {
		db.executeUpdate("update AmpliacionCapital set faseTres = ?", acc);
		
		String datos = String.valueOf(acc);
		logger.logUpdate("ampliacioncapital",datos,"faseTres");
	}

	public void updateAccionesVendidas(int accionesVendidas) {
		db.executeUpdate("update AmpliacionCapital set vendidas = ?", accionesVendidas);
		
		String datos = String.valueOf(accionesVendidas);
		logger.logUpdate("ampliacioncapital",datos,"vendidas");
	}

	public int selectAccionesVendidas() {
		logger.logSelect("ampliacionCapital");
		return db.executeQueryPojo(AmpliacionCapital.class, "select * from AmpliacionCapital").get(0).getVendidas();
	}

	public void updateCapitalTotal(double vendidas) {
		db.executeUpdate("update AmpliacionCapital set capitalTotal = ?", vendidas);
		
		String datos = String.valueOf(vendidas);
		logger.logUpdate("ampliacioncapital",datos,"capitalTotal");
	}

	// VENTAS
	public void insertarVenta(String string, String dateSql, int hours, int minutes, double i) {
		String queryVenta = "Insert into Venta(concepto, fecha, hora, minuto, cuantia) VALUES" + "(?,?,?,?,?)";
		db.executeUpdate(queryVenta, "entrada", dateSql, hours, minutes, 30);
		logger.logInsert("Venta", dateSql);
	}

	public List<VentaDisplayDTO> getVentasByDate(String min, String max) {
		logger.logSelect("venta");
		return db.executeQueryPojo(VentaDisplayDTO.class, "select * from venta where fecha>=? " + "and fecha<=?", min,
				max);
	}

	public List<VentaDisplayDTO> getTotalVentas() {
		logger.logSelect("venta");
		return db.executeQueryPojo(VentaDisplayDTO.class, "select * from venta");
	}

	// COMPRAS
	public List<Compra> getComprasByDate(String min, String max) {
		logger.logSelect("compra");
		return db.executeQueryPojo(Compra.class, "select * from compra where fecha>=? " + "and fecha<=?", min, max);
	}

	public List<Compra> getTotalCompras() {
		logger.logSelect("compra");
		return db.executeQueryPojo(Compra.class, "select * from compra");
	}

	// ACCIONISTAS
	public List<Accionista> selectAccionista(int numeroAccionista) {
		logger.logSelect("accionista");
		return db.executeQueryPojo(Accionista.class, "select * from accionista " + "where idAccionista=?",
				numeroAccionista);
	}

	public List<Accionista> selectAccionista(String nombre, String apellido, String dni) {
		logger.logSelect("accionista");
		return db.executeQueryPojo(Accionista.class,
				"select * from accionista " + "where nombreAccionista=? and apellidoAccionista=? and dniAccionista=?",
				nombre, apellido, dni);
	}

	public void insertAccionista(String nombre, String apellido, String dni, String cuenta) {
		db.executeUpdate("insert into accionista(nombreAccionista, apellidoAccionista, "
				+ "dniAccionista, cuentaBancaria, numeroAcciones,porcentajeCapital) values " + "(?,?,?,?, 0, 0.0)",
				nombre, apellido, dni, cuenta);
		logger.logInsert("Accionista", nombre);
	}

	public List<Accionista> selectAccionistaById(int id) {
		logger.logSelect("accionista");
		return db.executeQueryPojo(Accionista.class, "select * from accionista " + "where idAccionista=?", id);
	}

	public List<Accion> selectAccionesByIdAccionista(int accionistaActivo) {
		logger.logSelect("accion");
		return db.executeQueryPojo(Accion.class, "select * from accion " + "where idAccionista=?", accionistaActivo);
	}

	public List<Accion> selectAccionesEnVenta(int idAccionista) {
		logger.logSelect("accion");
		return db.executeQueryPojo(Accion.class, "select * from accion " + "where idAccionista <> ? and enVenta = 1",
				idAccionista);
	}

	public void updateAccionCompra(Integer idAccion, int idComprador, int idVendedor, float porcentaje) {
		db.executeUpdate("update accion set idAccionista=?, enVenta=0 where idAccion=?", idComprador, idAccion);
		
		String datos = idComprador + ", " + idAccion;
		logger.logUpdate("accion",datos,"idAccionista, enVenta");
		
		db.executeUpdate("update accionista set numeroAcciones=numeroAcciones+1, "
				+ "porcentajeCapital=porcentajeCapital+? where idAccionista=?", porcentaje, idComprador);
		
		String datosDos = porcentaje + ", " + idComprador;
		logger.logUpdate("accionista",datosDos,"numeroAcciones, porcentajeCapital");
		
		db.executeUpdate("update accionista set numeroAcciones=numeroAcciones-1, "
				+ "porcentajeCapital=porcentajeCapital-? where idAccionista=?", porcentaje, idVendedor);

		String datosTres = porcentaje + "";
		logger.logUpdate("accionista",datosTres,"numeroAcciones,porcentajeCapital");
	}

	public void deleteAccionistaACero() {
		db.executeUpdate("delete from accionista where numeroAcciones = 0");
		logger.logDelete("Accionista", "accionistas sin acciones");
	}

	public int selectLimiteFase1(int idAccionista) {
		List<Accionista> acc = db.executeQueryPojo(Accionista.class,
				"select * from accionista " + "where idAccionista=?", idAccionista);
		
		logger.logSelect("accionista");

		return acc.get(0).getLimiteAccionesFaseUno();
	}

	public void insertAccion(int idAccionista, double precioPorAccion) {
		db.executeUpdate("insert into accion(idAccionista,precioCompra,enVenta,precioVenta) " + "values (?,?,0,?)",
				idAccionista, precioPorAccion, precioPorAccion);
		logger.logInsert("Accion", "Accionista " + idAccionista);
	}

	public void updateLimiteAccionista(int idAccionista, Integer numAcciones) {
		db.executeUpdate(
				"update accionista set limiteAccionesFaseUno=limiteAccionesFaseUno-? " + "where idAccionista=?",
				numAcciones, idAccionista);
		
		String datosTres = numAcciones + "";
		logger.logUpdate("accionista",datosTres,"limiteAccionesFaseUno");
	}

	public void updateCompraAccionista(int idAccionista, float porcentaje) {
		db.executeUpdate("update accionista set numeroAcciones=numeroAcciones+1 where idAccionista=?", idAccionista);
		
		String datos = "numAcciones + 1";
		logger.logUpdate("accionista",datos,"numeroAcciones");
		
		db.executeUpdate("update accionista set porcentajeCapital=porcentajeCapital+? " + "where idAccionista=?",
				porcentaje, idAccionista);
		
		String datosDos = porcentaje + "";
		logger.logUpdate("accionista",datosDos,"porcentajeCapital");
		
		db.executeUpdate("update accionista set porcentajeCapital=porcentajeCapital-? " + "where idAccionista<>?",
				porcentaje, idAccionista);
		
		String datosTres = porcentaje + "";
		logger.logUpdate("accionista",datosTres,"porcentajeCapital");
	}

	public void updateAccionesEnVenta(int idAccionista) {
		db.executeUpdate("update accion set enVenta=1 where idAccionista=?", idAccionista);
		logger.logMessage("Acciones en venta actualizadas");
	}

	public void updatePonerEnVenta(Integer id) {
		db.executeUpdate("update accion set enVenta=1 where idAccion=?", id);
		logger.logMessage("Acción puesta en venta");
	}

	public int countAccionistas() {
		List<Accionista> acc = db.executeQueryPojo(Accionista.class, "select * from accionista");
		return acc.size();
	}

	public State checkUser(Usuario usuario) {
		List<Usuario> result = db.executeQueryPojo(Usuario.class,
				"select * from usuario where usuario=? and contrasena=?", usuario.getUsuario(),
				usuario.getContrasena());
		
		logger.logSelect("usuario");
		
		if (result.size() == 0) 
			return State.LOGINFAIL_USERNOTFOUND;
			

		usuario.setRol(result.get(0).getRol());
		usuario.setPid(result.get(0).getPid());

		return State.SUCCESS;

	}

	public void addUser(Usuario usuario) {

		db.executeUpdate("insert into usuario(usuario,contrasena,rol,pid) values (?,?,?,?)", usuario.getUsuario(),
				usuario.getContrasena(), usuario.getRol(), usuario.getPid());

		logger.logInsert("Usuario", usuario.getRol() + " " + usuario.getUsuario());

	}

	// LESIONES
	public List<Empleado> selectJugadoresPorEquipo(String eqid) {
		List<Juega> l = db.executeQueryPojo(Juega.class, "select * from juega where eqid = ?", eqid);
		logger.logSelect("juega");
		
		List<Empleado> jugadores = new ArrayList<Empleado>();
		for (Juega j : l) {
			jugadores.add(
					db.executeQueryPojo(Empleado.class, "select * from empleado where eid = ?", j.getEid()).get(0));
			logger.logSelect("empleado");
		}
		return jugadores;
	}

	public List<Empleado> selectLesionado(int eid) {
		List<Lesion> list = db.executeQueryPojo(Lesion.class, "select * from lesion " + "where eid = ?", eid);
		logger.logSelect("lesion");
		
		List<Empleado> jugadores = new ArrayList<Empleado>();
		for (Lesion j : list) {
			jugadores.add(
					db.executeQueryPojo(Empleado.class, "select * from empleado where eid = ?", j.getEid()).get(0));
			logger.logSelect("empleado");
		}
		return jugadores;
	}

	public void deleteLesionado(String eid) {
		db.executeUpdate("delete from lesion where eid=?", eid);
		logger.logDelete("Lesion", getEmpleado(Integer.parseInt(eid)).getNombre());
	}

	public List<HorarioEntrenamiento> getEntrenamientos(String equipoId) {
		List<HorarioEntrenamiento> entrenos = db.executeQueryPojo(HorarioEntrenamiento.class,
				"select * from HorarioEntrenamiento where eid=?", equipoId);
		logger.logSelect("HorarioEntrenamiento");
		
		return entrenos;
	}

	public List<Partido> getPartidos(String equipoId) {
		List<Partido> entrenos = db.executeQueryPojo(Partido.class, "select * from Partido where idEquipo=?", equipoId);
		logger.logSelect("Partido");
		
		return entrenos;
	}

	public void insertLesionado(int eid, Integer ent, Integer part, String causa, String descripcion, String fecha) {
		if (causa.equals("Entrenamiento")) {
			db.executeUpdate("insert into Lesion (eid, causa, enid) values " + "(?,?,?)", eid, causa, ent);
		} else if (causa.equals("Partido")) {
			db.executeUpdate("insert into Lesion (eid, causa, pid) values " + "(?,?,?)", eid, causa, part);
		} else {
			db.executeUpdate("insert into Lesion (eid, causa, descripcion, fecha) values " + "(?,?,?,?)", eid, causa,
					descripcion, fecha);
		}

		logger.logInsert("Lesion", getEmpleado(eid).getNombre());
	}

	// ACTUALIZACIONES
	public List<Actualizacion> getActualizaciones(int eid) {
		logger.logSelect("Actualizacion");
		return db.executeQueryPojo(Actualizacion.class, "select * from Actualizacion where eid=?", eid);
	}

	public void deleteActualizaciones(int eid) {
		db.executeUpdate("delete from actualizacion where eid = ?", eid);
		logger.logDelete("Actualizacion", getEmpleado(eid).getNombre());
	}

	public void insertActualizacion(int eid, String texto) {
		db.executeUpdate("insert into actualizacion (eid, texto) values " + "(?,?)", eid, texto);
		logger.logInsert("Actualizacion", getEmpleado(eid).getNombre());
	}

	public void insertarVentaReserva(String fecha, int horaReserva, int minutoReserva, int precioInt) {
		String queryVenta = "Insert into Venta(concepto, fecha, hora, minuto, cuantia) VALUES" + "(?,?,?,?,?)";
		db.executeUpdate(queryVenta, "reserva", fecha, horaReserva, minutoReserva, 50);
		logger.logInsert("Venta", fecha);

	}

	public void insertarVentaAccion(String fecha, int horaVenta, int minutoVenta, double precioPorAccion) {
		String queryVenta = "Insert into Venta(concepto, fecha, hora, minuto, cuantia) VALUES" + "(?,?,?,?,?)";
		db.executeUpdate(queryVenta, "accion", fecha, horaVenta, minutoVenta, 34.67);
		logger.logMessage("Venta acción creada");

	}

	public int selectNumJugadoresByEquipo(int id) {
		List<Juega> j = db.executeQueryPojo(Juega.class, "select * from Juega where eqid = ?", id);
		logger.logSelect("Juega");
		return j.size();
	}

	public Equipo selectEquipoById(int id) {
		List<Equipo> e = db.executeQueryPojo(Equipo.class, "select * from Equipo where id = ?", id);
		logger.logSelect("Equipo");
		return e.get(0);
	}

	public List<JugadoresEnVenta> selectJugadoresEnVenta() {
		List<JugadoresEnVenta> j = db.executeQueryPojo(JugadoresEnVenta.class, "select * from JugadoresEnVenta");
		logger.logSelect("JugadoresEnVenta");
		return j;
	}

	public List<Empleado> selectJugadoresByEquipo(int id) {
		List<Juega> j = db.executeQueryPojo(Juega.class, "select * from Juega where eqid = ?", id);
		logger.logSelect("Juega");
		List<Empleado> jugadoresEquipo = new ArrayList<>();
		for (Juega jugador : j) {
			List<Empleado> e = db.executeQueryPojo(Empleado.class, "select * from empleado where eid = ?", jugador.getEid());
			jugadoresEquipo.add(e.get(0));
			logger.logSelect("empleado");
		}
		return jugadoresEquipo;
	}

	public JugadoresEnVenta selectJugadorEnVentaByDni(String dni) {
		List<JugadoresEnVenta> j = db.executeQueryPojo(JugadoresEnVenta.class, 
				"select * from JugadoresEnVenta where dni =?", dni);
		logger.logSelect("JugadoresEnVenta");
		
		return j.get(0);
	}

	public void deleteJugadorEnVenta(String dni) {
		db.executeUpdate("delete from JugadoresEnVenta where dni = ?", dni);
		logger.logDelete("JugadoresEnVenta", dni);
	}

	public void insertJuega(int id, String dni) {
		List<Empleado> es = db.executeQueryPojo(Empleado.class, "select * from empleado where dni = ?", dni);
		logger.logSelect("empleado");
		Empleado e = es.get(0);
		db.executeUpdate("insert into Juega (eqid, eid) values (?,?)", id, e.getEid());
	}

	public void insertCompra(Date d, float cuantia, String dni) {
		List<Empleado> es = db.executeQueryPojo(Empleado.class, "select * from empleado where dni = ?", dni);
		logger.logSelect("empleado");
		int eid = es.get(0).getEid();
		
		db.executeUpdate("insert into compra (cuantia, fecha, eid) values (?,?,?)", cuantia, d, eid);
	}

	public void deleteEmpleadoById(int eid) {
		db.executeUpdate("delete from empleado where eid=?", eid);
		logger.logDelete("Empleado", getEmpleado(eid).getNombre());
	}

	public void deleteJuega(int eid) {
		db.executeUpdate("delete from juega where eid=?", eid);
		logger.logDelete("Juega", "participaciones para el empleado " + getEmpleado(eid).getNombre());
	}

	public void insertarVentaJugador(String fecha, int horaVenta,
			int minutoVenta, double precio) {
		String queryVenta = "Insert into Venta(concepto, fecha, hora, minuto, cuantia) VALUES" + "(?,?,?,?,?)";
		db.executeUpdate(queryVenta, "jugador", fecha, horaVenta, minutoVenta, precio);
		logger.logInsert("Venta", fecha);
	}

	public void deleteHorarioEntrevistaById(int eid) {
		db.executeUpdate("delete from horarioentrevista where eid=?", eid);
		logger.logDelete("HorarioEntrevista", "horarios para el empleado " + getEmpleado(eid).getNombre());
	}

}
