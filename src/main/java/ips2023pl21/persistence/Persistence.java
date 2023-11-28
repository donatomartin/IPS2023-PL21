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

	private Persistence() {
		db = new Database();
		db.createDatabase(false);
		db.loadDatabase();
	}

	public static Persistence getInstance() {
		return p;
	}

	// ENTREVISTAS
	
	public boolean existeEntrevista(String fecha, int eid) {
		List<HorarioEntrevista> result = db.executeQueryPojo(HorarioEntrevista.class,
				"select * from HorarioEntrevista where fechaEntrevista=? and eid=?", fecha, eid);
		return !result.isEmpty();
	}

	public List<HorarioEntrevista> selectHorariosEntrevistasAsignados() {
		List<HorarioEntrevista> result = db.executeQueryPojo(HorarioEntrevista.class,
				"select * from HorarioEntrevista where datosmedio is not null");
		return result;
	}
	
	public List<HorarioEntrevista> selectHorariosEntrevistasNoAsignados() {
		List<HorarioEntrevista> result = db.executeQueryPojo(HorarioEntrevista.class,
				"select * from HorarioEntrevista where datosmedio is null");
		return result;
	}

	public void insertHorarioEntrevista(String fecha, String horaInicio, String horaFin, int eid)
			throws IllegalStateException {
		checkHorarioEntrenamiento(eid, fecha, horaInicio, horaFin);

		db.executeUpdate(
				"insert into HorarioEntrevista (fechaEntrevista, horaInicio, horaFin, eid) values (?,?,?,?)",
				fecha, horaInicio, horaFin, eid);
	}
	
	public void asignaHorarioEntrevista(HorarioEntrevista he, String datosMedio) {
		db.executeUpdate("update HorarioEntrevista set datosMedio=? where fechaEntrevista=? and eid=?", datosMedio, he.getFechaEntrevista(), he.getEid());
	}

	public void deleteHorarioEntrevista(int eqid, String fecha, String horaInicio, String horaFin) {

		db.executeUpdate(
				"delete from HorarioEntrevista where eid=? and fechaEntrevista=? and horaInicio=? and horaFin=?", eqid,
				fecha, horaInicio, horaFin);
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
		List<Empleado> result = db.executeQueryPojo(Empleado.class, "select * from Empleado where eid=?", eid);
		if (result.size() > 0)
			return result.get(0);
		return null;
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
	
	public List<Empleado> getEmpleados() {
		return db.executeQueryPojo(Empleado.class, "select * from empleado");
		
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
		db.executeUpdate("insert into HorarioSemanal(diaSemana, fechaInicio, eid) values (?, ?, ?)", diaSemana,
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

	public void insertFranjaSemanal(int dia, String fechaInicio, int eid, String horaInicio, String horaFin) {
		db.executeUpdate(
				"insert into FranjaSemanal(diaSemana, fechaInicio, eid, horaInicio, horaFin) values (?, ?, ?, ?, ?)",
				dia, fechaInicio, eid, horaInicio, horaFin);
	}

	public void deleteHorarioSemanal(int dia, String fechaInicio, int eid) {
		db.executeUpdate("delete from HorarioSemanal where diaSemana=? and fechaInicio=? and eid=?", dia, fechaInicio,
				eid);
		db.executeUpdate("delete from FranjaSemanal where diaSemana=? and fechaInicio=? and eid=?", dia, fechaInicio,
				eid);
	}

	public List<FranjaSemanal> getFranjasSemanales(int diaSem, String fechaInicio, int eid) {
		List<FranjaSemanal> result = db.executeQueryPojo(FranjaSemanal.class,
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
				.executeQueryPojo(FranjaSemanal.class, "select * from FranjaSemanal where diaSemana=?", diaSem).stream()
				.sorted().collect(Collectors.toList());

		return franjas;
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
		db.executeUpdate("insert into FranjaPuntual(fechaPuntual, eid, horaInicio, horaFin) values (?, ?, ?, ?)",
				fechaPun, eid, horaInicio, horaFin);
	}

	public void removeHorarioPuntual(String fechaPun) {
		db.executeUpdate("delete from HorarioPuntual where fechaPuntual=?", fechaPun);
		db.executeUpdate("delete from FranjaPuntual where fechaPuntual=?", fechaPun);
	}

	public List<FranjaPuntual> getFranjasPuntuales(String fechaPuntual, int eid) {
		List<FranjaPuntual> result = db.executeQueryPojo(FranjaPuntual.class,
				"select * from FranjaPuntual where fechaPuntual=? and eid=?", fechaPuntual, eid).stream().sorted()
				.collect(Collectors.toList());
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

	// CAPITAL CLUB
	public float getCapitalClub() {
		List<AmpliacionCapital> ac = db.executeQueryPojo(AmpliacionCapital.class, "select * from ampliacionCapital");
		float result = ac.get(0).getCapitalTotal();
		return result;
	}

	public int getAccionesClub() {
		List<AmpliacionCapital> ac = db.executeQueryPojo(AmpliacionCapital.class, "select * from ampliacionCapital");
		int result = ac.get(0).getAccionesTotales();
		return result;
	}

	// ABONOS
	public void insertAbono(String tribuna, String seccion, int fila, int asiento, double precio, String dateString) {
		db.executeUpdate(
				"insert into abono (tribuna, seccion, fila, asiento, precio, fechaCaducidad) values (?,?,?,?,?,?)",
				tribuna, seccion, fila, asiento, precio, dateString);
	}

	public List<Abono> selectAbono(String tribuna, String seccion, int fila, int asiento) {
		return db.executeQueryPojo(Abono.class,
				"select * from abono where tribuna=? and seccion=? and fila=? and asiento=?", tribuna, seccion, fila,
				asiento);
	}

	public List<EntradaEntity> getAbonos(String tribuna, String seccion) { 
																						
		return db.executeQueryPojo(EntradaEntity.class, "select * from abono where tribuna=? and seccion=?", tribuna,
				seccion);

	}

	public List<EntradaEntity> getAbonosFila(String tribuna, String seccion, int fila) {
		List<EntradaEntity> entradas = db.executeQueryPojo(EntradaEntity.class,
				"select * from abono where tribuna=? and seccion=? and fila=?", tribuna, seccion, fila);
		for (EntradaEntity e : entradas) {
			System.out.println(e.getTribuna() + e.getSeccion() + e.getFila() + e.getAsiento());
		}
		return entradas;
	}
	

	// ENTRADA

	public void insertarEntrada(String tribuna, String seccion, int fila, int asientoInicial, int i) {
		String queryEntrada = "Insert into Entrada(tribuna, seccion, fila, asiento, precio) VALUES (?,?,?,?,?)";
		db.executeUpdate(queryEntrada, tribuna, seccion, fila, asientoInicial, i);

	}

	public List<EntradaEntity> getTotalEntradas(String tribuna, String seccion, int fila) {
		String query = "SELECT * FROM entrada where tribuna=? and seccion=? and fila=?";
		return db.executeQueryPojo(EntradaEntity.class, query, tribuna, seccion, fila);
	}
	

	// NOTICIAS
	public void insertNoticia(String titulo, String subtitulo, String cuerpo, String img) {
		db.executeUpdate("insert into noticia (titulo, subtitulo, cuerpo, img) values (?,?,?,?)", titulo, subtitulo,
				cuerpo, img);
	}

	public List<Noticia> selectNoticias() {
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
		return ret;
	}

	public EquipoDeportivo selectEquipoPorNombre(String nombre) {

		List<Object[]> equipo = db.executeQueryArray("select * from Equipo where nombre = ?", nombre);
		EquipoDeportivo ret = new EquipoDeportivo();
		ret.setId(equipo.get(0)[0].toString());
		ret.setNombre(equipo.get(0)[3].toString());

//			ret.setCategoria(o[2]);
//			ret.setFilial(o[3]);
		return ret;
	}

	public EquipoDeportivo selectEquipoPorId(String id) {
		List<Object[]> equipo = db.executeQueryArray("select * from Equipo where id = ?", id);
		EquipoDeportivo ret = new EquipoDeportivo();

		ret.setId(equipo.get(0)[0].toString());
		ret.setNombre(equipo.get(0)[3].toString());

//			ret.setCategoria(o[2]);
//			ret.setFilial(o[3]);
		return ret;
	}

	public int getEquipoIdByEmpleadoId(int eid) {

		try {
			var res = db.executeQueryArray("select eqid from juega where eid=?", eid);
			String str = (String) res.get(0)[0].toString();
			return Integer.parseInt(str);
		} catch (Exception e) {
			return -1;
		}

	}

	private int getEmpleadoIdByEquipoId(int eqid) {
		try {
			var res = db.executeQueryArray("select eid from juega where eqid=?", eqid);
			String str = (String) res.get(0)[0].toString();
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
		return ret;
	}

	// ABONADOS

	public boolean existsIdAbonado(String id) {
		List<Object[]> abonado = db.executeQueryArray("select * from Abonado where id = ?", id);
		if (abonado.size() == 1) {
			return true;
		}
		return false;

	}

	public void insertPartidoAbonado(String idAbonado, Partido partido) {
		db.executeUpdate("insert into PartidoAbonado(idAbonado, idPartido) values (?,?)", idAbonado, partido.getId());

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
		return ret;

	}

	public void borrarAbonado(String tribuna, String seccion, int fila, int asiento) {
		db.executeUpdate("remove from abono where tribuna=?, seccion=?, fila=?, asiento=?", tribuna, seccion, fila,
				asiento);

	}

	public void insertAbonado(String nombre) {
		db.executeUpdate("insert into abonado (nombre) values (?)", nombre);

	}

	public List<Object[]> getIdAbonado() {
		return db.executeQueryArray("select max(id)from abonado");
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

	public void insertHorarioJardineria(int eid, int iid, String fecha, String horaInicio, String horaFin)
			throws IllegalStateException {
		checkHorarioEntrenamiento(iid, fecha, horaInicio, horaFin);
		db.executeUpdate(
				"insert into HorarioJardineria (fechaJardineria, horaInicio, horaFin, eid, iid) values (?,?,?,?,?)",
				fecha, horaInicio, horaFin, eid, iid);
	}

	public void deleteHorarioJardineria(int eid, String fecha, String horaInicio, String horaFin) {
		db.executeUpdate(
				"delete from HorarioJardineria where fechaJardineria=? and horaInicio=? and horaFin=? and eid=?", fecha,
				horaInicio, horaFin, eid);
	}

	// HORARIO ENTRENAMIENTO

	public List<HorarioEntrenamiento> selectHorariosEntrenamiento(int iid) {
		List<HorarioEntrenamiento> result = db.executeQueryPojo(HorarioEntrenamiento.class,
				"select * from HorarioEntrenamiento where iid=?", iid);

		return result;
	}

	public List<HorarioEntrenamiento> selectHorariosEntrenamiento(int iid, String fecha) {
		List<HorarioEntrenamiento> result = db.executeQueryPojo(HorarioEntrenamiento.class,
				"select * from HorarioEntrenamiento where iid=? and fechaEntrenamiento=?", iid, fecha);

		return result;
	}

	public List<HorarioEntrenamiento> selectHorariosEntrenamiento() {
		List<HorarioEntrenamiento> result = db.executeQueryPojo(HorarioEntrenamiento.class,
				"select * from HorarioEntrenamiento");

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
		if (result.size() > 0)
			return result.get(0);
		return null;
	}

	public Equipo getEquipo(int id) {
		List<Equipo> result = db.executeQueryPojo(Equipo.class, "select * from Equipo where id=?", id);
		if (result.size() > 0)
			return result.get(0);
		return null;
	}
	
	public List<Equipo> selectAllEquipos(){
		return db.executeQueryPojo(Equipo.class, "select * from equipo");
	}

	// Articulos
	public List<Merchandaising> selectArticulos() {
		List<Object[]> articulos = db.executeQueryArray("select * from merchandaising");

		List<Merchandaising> ret = new ArrayList<>();

		for (Object[] o : articulos) {
			ret.add(new Merchandaising((int) o[0], o[1].toString(), o[2].toString(), (double) o[3]));
		}
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

	}

	// Ampliaciones capital
	public float getPrecioPorAccion() {
		List<AmpliacionCapital> ac = db.executeQueryPojo(AmpliacionCapital.class, "select * from ampliacionCapital");
		float result = ac.get(0).getPrecioAccion();
		return result;
	}

	public void insertAmpliacion(int accionesNuevas) {
		int reset = 0;
		db.executeUpdate("update ampliacioncapital set faseUno = ?, fase = 'Fase 1', vendidas = ?", accionesNuevas,
				reset);
	}

	public void updateLimiteFaseUno() {
		db.executeUpdate("update accionista set limiteAccionesFaseUno = numeroAcciones");
	}

	public String getFase() {
		List<AmpliacionCapital> list = db.executeQueryPojo(AmpliacionCapital.class, "select * from ampliacioncapital");
		return list.get(0).getFase();
	}

	public void updateFase(String fase) {
		db.executeUpdate("update ampliacioncapital set fase = ?", fase);
	}

	// ACCIONISTAS
	public int selectRestantesFase1() {
		return db.executeQueryPojo(AmpliacionCapital.class, 
				"select * from ampliacioncapital").get(0).getFaseUno();
		
	}
	
	public int selectRestantesFase2() {
		return db.executeQueryPojo(AmpliacionCapital.class, 
				"select * from ampliacioncapital").get(0).getFaseDos();
		
	}
	
	public int selectRestantesFase3() {
		return db.executeQueryPojo(AmpliacionCapital.class, 
				"select * from ampliacioncapital").get(0).getFaseTres();
		
	}

	public void updateAccionesFase1(int acc) {
		db.executeUpdate("update AmpliacionCapital set faseUno = ?", acc);
	}

	public void updateAccionesFase2(int acc) {
		db.executeUpdate("update AmpliacionCapital set faseDos = ?", acc);
	}
	
	public void updateAccionesFase3(int acc) {
		db.executeUpdate("update AmpliacionCapital set faseTres = ?", acc);
	}

	public void updateAccionesVendidas(int accionesVendidas) {
		db.executeUpdate("update AmpliacionCapital set vendidas = ?", accionesVendidas);
	}

	public int selectAccionesVendidas() {
		return 
		 db.executeQueryPojo
		 (AmpliacionCapital.class,"select * from AmpliacionCapital").get(0).getVendidas();
	}

	public void updateCapitalTotal(double vendidas) {
		db.executeUpdate("update AmpliacionCapital set capitalTotal = ?", vendidas);
	}
	
	//VENTAS
	public void insertarVenta(String string, String dateSql, int hours, int minutes, double i) {
		String queryVenta = "Insert into Venta(concepto, fecha, hora, minuto, cuantia) VALUES" + "(?,?,?,?,?)";
		db.executeUpdate(queryVenta, "entrada", dateSql, hours, minutes, 30);

	}
	public List<VentaDisplayDTO> getVentasByDate(String min, String max){
//		System.out.println("min:"+minS);
//		System.out.println("max:"+maxS);
		return db.executeQueryPojo(VentaDisplayDTO.class,"select * from venta where fecha>=? "
				+ "and fecha<=?", min, max);
		}
	public List<VentaDisplayDTO> getTotalVentas() {
		return db.executeQueryPojo(VentaDisplayDTO.class, "select * from venta");
	}

	//COMPRAS
		public List<Compra> getComprasByDate(String min, String max) {
			return db.executeQueryPojo(Compra.class,"select * from compra where fecha>=? "
					+ "and fecha<=?", min, max);
		}

		public List<Compra> getTotalCompras() {
			return db.executeQueryPojo(Compra.class,"select * from compra");
		}

		

		

	
	//ACCIONISTAS
	public List<Accionista> selectAccionista(int numeroAccionista) {
		return db.executeQueryPojo(Accionista.class, "select * from accionista " + "where idAccionista=?",
				numeroAccionista);
	}

	public List<Accionista> selectAccionista(String nombre, String apellido, String dni) {
		return db.executeQueryPojo(Accionista.class,
				"select * from accionista " + "where nombreAccionista=? and apellidoAccionista=? and dniAccionista=?",
				nombre, apellido, dni);
	}

	public void insertAccionista(String nombre, String apellido, String dni, String cuenta) {
		db.executeUpdate("insert into accionista(nombreAccionista, apellidoAccionista, "
				+ "dniAccionista, cuentaBancaria, numeroAcciones,porcentajeCapital) values " + "(?,?,?,?, 0, 0.0)",
				nombre, apellido, dni, cuenta);
	}

	public List<Accionista> selectAccionistaById(int id) {
		return db.executeQueryPojo(Accionista.class, "select * from accionista " + "where idAccionista=?", id);
	}

	public List<Accion> selectAccionesByIdAccionista(int accionistaActivo) {
		return db.executeQueryPojo(Accion.class, "select * from accion " + "where idAccionista=?", accionistaActivo);
	}

	public List<Accion> selectAccionesEnVenta(int idAccionista) {
		return db.executeQueryPojo(Accion.class, "select * from accion " + "where idAccionista <> ? and enVenta = 1",
				idAccionista);
	}

	public void updateAccionCompra(Integer idAccion, int idComprador, int idVendedor, float porcentaje) {
		db.executeUpdate("update accion set idAccionista=?, enVenta=0 where idAccion=?", idComprador, idAccion);
		db.executeUpdate("update accionista set numeroAcciones=numeroAcciones+1, "
				+ "porcentajeCapital=porcentajeCapital+? where idAccionista=?", porcentaje, idComprador);
		db.executeUpdate("update accionista set numeroAcciones=numeroAcciones-1, "
				+ "porcentajeCapital=porcentajeCapital-? where idAccionista=?", porcentaje, idVendedor);
	}

	public void deleteAccionistaACero() {
		db.executeUpdate("delete from accionista where numeroAcciones = 0");
	}

	public int selectLimiteFase1(int idAccionista) {
		List<Accionista> acc = db.executeQueryPojo(Accionista.class,
				"select * from accionista " + "where idAccionista=?", idAccionista);
		return acc.get(0).getLimiteAccionesFaseUno();
	}

	public void insertAccion(int idAccionista, double precioPorAccion) {
		db.executeUpdate("insert into accion(idAccionista,precioCompra,enVenta,precioVenta) " + "values (?,?,0,?)",
				idAccionista, precioPorAccion, precioPorAccion);
	}

	public void updateLimiteAccionista(int idAccionista, Integer numAcciones) {
		db.executeUpdate(
				"update accionista set limiteAccionesFaseUno=limiteAccionesFaseUno-? " + "where idAccionista=?",
				numAcciones, idAccionista);
	}

	public void updateCompraAccionista(int idAccionista, float porcentaje) {
		db.executeUpdate("update accionista set numeroAcciones=numeroAcciones+1 where idAccionista=?", idAccionista);
		db.executeUpdate("update accionista set porcentajeCapital=porcentajeCapital+? " + "where idAccionista=?",
				porcentaje, idAccionista);
		db.executeUpdate("update accionista set porcentajeCapital=porcentajeCapital-? " + "where idAccionista<>?",
				porcentaje, idAccionista);
	}

	public void updateAccionesEnVenta(int idAccionista) {
		db.executeUpdate("update accion set enVenta=1 where idAccionista=?", idAccionista);
	}

	public void updatePonerEnVenta(Integer id) {
		db.executeUpdate("update accion set enVenta=1 where idAccion=?", id);
	}

	public int countAccionistas() {
		List<Accionista> acc = db.executeQueryPojo(Accionista.class, "select * from accionista");
		return acc.size();
	}

	public State checkUser(Usuario usuario) {
		List<Usuario> result = db.executeQueryPojo(Usuario.class,
				"select * from usuario where usuario=? and contrasena=?", usuario.getUsuario(),
				usuario.getContrasena());

		if (result.size() == 0)
			return State.LOGINFAIL_USERNOTFOUND;

		usuario.setRol(result.get(0).getRol());
		usuario.setPid(result.get(0).getPid());

		return State.SUCCESS;

	}

	public void addUser(Usuario usuario) {

		db.executeUpdate("insert into usuario(usuario,contrasena,rol,pid) values (?,?,?,?)", usuario.getUsuario(),
				usuario.getContrasena(), usuario.getRol(), usuario.getPid());

	}

	//LESIONES
	public List<Empleado> selectJugadoresPorEquipo(String eqid) {
		List<Juega> l = db.executeQueryPojo(Juega.class, 
				"select * from juega where eqid = ?", eqid);
		
		List<Empleado> jugadores = new ArrayList<Empleado>();
		for (Juega j : l) {
			jugadores.add(db.executeQueryPojo(Empleado.class, 
				"select * from empleado where eid = ?", j.getEid()).get(0));
		}
		return jugadores;
	}

	public List<Empleado> selectLesionado(int eid) {
		List<Lesion> list = db.executeQueryPojo(Lesion.class, "select * from lesion "
				+ "where eid = ?", eid);
		
		List<Empleado> jugadores = new ArrayList<Empleado>();
		for (Lesion j : list) {
			jugadores.add(db.executeQueryPojo(Empleado.class, 
				"select * from empleado where eid = ?", j.getEid()).get(0));
		}
		return jugadores;
	}

	public void deleteLesionado(String eid) {
		db.executeUpdate("delete from lesion where eid=?", eid);
	}

	public List<HorarioEntrenamiento> getEntrenamientos(String equipoId) {
		List<HorarioEntrenamiento> entrenos = db.executeQueryPojo(HorarioEntrenamiento.class,
				"select * from HorarioEntrenamiento where eid=?", equipoId);
		return entrenos;
	}

	public List<Partido> getPartidos(String equipoId) {
		List<Partido> entrenos = db.executeQueryPojo(Partido.class,
				"select * from Partido where idEquipo=?", equipoId);
		return entrenos;
	}

	public void insertLesionado(int eid, Integer ent, Integer part, String causa, String descripcion, String fecha) {
		if (causa.equals("Entrenamiento")) {
			db.executeUpdate("insert into Lesion (eid, causa, enid) values "
					+ "(?,?,?)", eid, causa, ent);
		}
		else if (causa.equals("Partido")) {
			db.executeUpdate("insert into Lesion (eid, causa, pid) values "
					+ "(?,?,?)", eid, causa, part);
		}
		else {
			db.executeUpdate("insert into Lesion (eid, causa, descripcion, fecha) values "
					+ "(?,?,?,?)", eid, causa, descripcion, fecha);
		}
	}

	
	//ACTUALIZACIONES
	public List<Actualizacion> getActualizaciones(int eid) {
		return db.executeQueryPojo(Actualizacion.class,
				"select * from Actualizacion where eid=?", eid);
	}

	public void deleteActualizaciones(int eid) {
		db.executeUpdate("delete from actualizacion where eid = ?", eid);
	}
	public void insertActualizacion(int eid, String texto) {
		db.executeUpdate("insert into actualizacion (eid, texto) values "
				+ "(?,?)", eid, texto);
	}

	public void insertarVentaReserva(String fecha, int horaReserva, int minutoReserva, int precioInt) {
		String queryVenta = "Insert into Venta(concepto, fecha, hora, minuto, cuantia) VALUES" + "(?,?,?,?,?)";
		db.executeUpdate(queryVenta, "reserva", fecha, horaReserva, minutoReserva, 50);

	}

	public void insertarVentaAccion(String fecha, int horaVenta, int minutoVenta, double precioPorAccion) {
		String queryVenta = "Insert into Venta(concepto, fecha, hora, minuto, cuantia) VALUES" + "(?,?,?,?,?)";
		db.executeUpdate(queryVenta, "accion", fecha, horaVenta, minutoVenta, 34.67);

	}

}
