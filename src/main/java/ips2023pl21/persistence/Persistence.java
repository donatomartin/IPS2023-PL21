package ips2023pl21.persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import ips2023pl21.model.Empleado;
import ips2023pl21.model.equipos.CategoriaEquipo;
import ips2023pl21.model.equipos.EquipoDeportivo;
import ips2023pl21.model.equipos.EquipoEnFormacion;
import ips2023pl21.model.equipos.EquipoProfesional;
import ips2023pl21.model.equipos.Partido;
import ips2023pl21.model.horarios.HorarioEntrevista;
import ips2023pl21.model.horarios.HorarioPuntual;
import ips2023pl21.model.horarios.HorarioSemanal;
import ips2023pl21.model.horarios.franjas.FranjaPuntual;
import ips2023pl21.model.horarios.franjas.FranjaSemanal;
import ips2023pl21.model.noticias.Noticia;
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

	public List<EntradaEntity> getAbonosFila(String tribuna, String seccion, int fila) {
		return db.executeQueryPojo(EntradaEntity.class, "select * from abono where tribuna=? and seccion=? and fila=?", tribuna, seccion, fila);
	}
	
	//ENTRADA

	public void insertarEntrada(String tribuna, String seccion, int fila, int asientoInicial, int i) {
		String queryEntrada="Insert into Entrada(tribuna, seccion, fila, asiento, precio) VALUES (?,?,?,?,?)";
		db.executeUpdate(queryEntrada, tribuna,seccion,fila,asientoInicial,i);
		
	}

	public void insertarVenta(String string, String dateSql, int hours, int minutes, int i) {
		String queryVenta="Insert into Venta(concepto, fecha, hora, minuto, cuantia) VALUES"
				+ "(?,?,?,?,?)";
		db.executeUpdate(queryVenta,"entrada", hours,minutes,30);
		
	}

	public List<EntradaEntity> getTotalEntradas(String tribuna, String seccion, int fila) {
		String query="SELECT * FROM entrada where tribuna=? and seccion=? and fila=?";
		return db.executeQueryPojo(EntradaEntity.class,query, tribuna, seccion, fila);
	}

	

	
	
	
	//NOTICIAS
	public void insertNoticia(String titulo, String subtitulo, String cuerpo, String img) {
		db.executeUpdate("insert into noticia (titulo, subtitulo, cuerpo, img) values (?,?,?,?)", titulo, subtitulo, cuerpo, img);
	}

	public List<Noticia> selectNoticias() {
		return db.executeQueryPojo(Noticia.class, "select * from noticia");
		
		
	}

	// EQUIPOS 
	
	public void insertEquipo(EquipoDeportivo equipo) {
		CategoriaEquipo categoria = null;
		boolean filial = false;
		
		if(equipo instanceof EquipoEnFormacion) {
			categoria = ((EquipoEnFormacion)equipo).categoria;
		} else {
			filial = ((EquipoProfesional) equipo).isFilial();
		}
		db.executeUpdate("insert into Equipo(nombre, categoria, esFilial) values (?,?,?)", equipo.getNombre(),categoria, filial);
	}
	
	public List<EquipoDeportivo> selectEquipo(){
		List<Object[]> equipos = db.executeQueryArray("select * from Equipo");
		List<EquipoDeportivo> ret = new ArrayList<>();
		
		for(Object[] o : equipos) {
			EquipoDeportivo equipo = new EquipoDeportivo();
			
			equipo.setNombre(o[1].toString());

			ret.add(equipo);
		}
		return ret;
	}
	
	public EquipoDeportivo selectEquipoPorNombre(String nombre) {
		
		List<Object[]> equipo = db.executeQueryArray("select * from Equipo where nombre = ?",nombre);
		EquipoDeportivo ret = new EquipoDeportivo();
		//TODO
		ret.setId(equipo.get(0)[0].toString());
		ret.setNombre(equipo.get(0)[1].toString());
			
//			ret.setCategoria(o[2]);
//			ret.setFilial(o[3]);
		return ret;
	}
	
	public EquipoDeportivo selectEquipoPorId(String id) {
		List<Object[]> equipo = db.executeQueryArray("select * from Equipo where id = ?",id);
		EquipoDeportivo ret = new EquipoDeportivo();
		//TODO

		ret.setId(equipo.get(0)[0].toString());
		ret.setNombre(equipo.get(0)[1].toString());
			
//			ret.setCategoria(o[2]);
//			ret.setFilial(o[3]);
		return ret;
	}
	
	
	// PARTIDOS
	
	public void insertPartido(Partido partido) {
		db.executeUpdate("insert into Partido(id, idEquipo, equipoVisitante, fecha, suplemento) values (?,?,?,?,?)", 
				partido.getId(), partido.getLocal().getId(), partido.getVisitante(),partido.getFecha(),partido.getSuplemento());
	}

	public List<Partido> selectPartidosPorIdEquipo(String id) {
		List<Object[]> partidos = db.executeQueryArray("select * from Partido where idEquipo = ?", id);
		
		List<Partido> ret = new ArrayList<>();
		
		for(Object[] o : partidos) {
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
	
	public List<Partido> selectPartidosPorId(String id){
		List<Object[]> partidos = db.executeQueryArray("select * from Partido where id = ?", id);
		
		List<Partido> ret = new ArrayList<>();
		
		for(Object[] o : partidos) {
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
		List<Object[]> abonado = db.executeQueryArray("select * from Abonado where id = ?",id);
		if(abonado.size() == 1) {
			return true;
		}
		return false;
		
	}

	public void insertPartidoAbonado(String idAbonado, Partido partido) {
		db.executeUpdate("insert into PartidoAbonado(idAbonado, idPartido) values (?,?)", 
				 idAbonado ,partido.getId());
		
	}
	
	public List<Partido> getPartidosNoSeleccionadosPorAbonadoYEquipo(String idAbonado, String idEquipo) {
		List<Partido> partidos = selectPartidosPorIdEquipo(idEquipo);
		
		List<Partido> partidosAbonados = selectPartidosAbonadosPorIdAbonado(idAbonado);
		List<Partido> ret = new ArrayList<>();
		
		for(Partido p : partidos) {
			if(!partidosAbonados.contains(p)) {
				ret.add(p);
			}
		}
		return ret;
	}
	
	public List<Partido> selectPartidosAbonadosPorIdAbonado(String idAbonado){
		List<Object[]> partidosAbonados = db.executeQueryArray("select * from PartidoAbonado where idAbonado = ?", idAbonado);
		List<Partido> ret =new ArrayList<>();
		
		for(Object[] o : partidosAbonados) {
			String idPartido = o[1].toString();
			ret.addAll(selectPartidosPorId(idPartido));
		}
		return ret;
		
	}
	
}
