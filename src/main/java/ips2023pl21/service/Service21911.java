package ips2023pl21.service;

import java.util.ArrayList;
import java.util.List;

import ips2023pl21.model.empleados.Empleado;
import ips2023pl21.model.empleados.EmpleadoDeportivo;
import ips2023pl21.model.empleados.EmpleadoNoDeportivo;
import ips2023pl21.util.Database;

public class Service21911 {
	
	public static final String TODOS_EMPLEADOS_DEPORTIVOS = "select * from empleadodeportivo";
	public static final String TODOS_EMPLEADOS_NO_DEPORTIVOS = "select * from empleadonodeportivo";
	public static final String EMPLEADO_NO_DEPORTIVO_GESTIONAR = 
			"select * from empleadonodeportivo where nombre = ? and apellido = ? and dni = ?";
	public static final String EMPLEADO_DEPORTIVO_GESTIONAR = 
			"select * from empleadodeportivo where nombre = ? and apellido = ? and dni = ?";
	public static final String UPDATE_EMPLEADO_DEPORTIVO = 
			"update empleadodeportivo set nombre = ?, apellido = ?, dni = ?, fechaNacimiento = ?, "
			+ "salarioAnual = ?, telefono = ?, posicion = ?"
			+ "where nombre = ? and apellido = ? and dni = ?";
	public static final String UPDATE_EMPLEADO_NO_DEPORTIVO = 
			"update empleadonodeportivo set nombre = ?, apellido = ?, dni = ?, fechaNacimiento = ?, "
			+ "salarioAnual = ?, telefono = ?, posicion = ?"
			+ "where nombre = ? and apellido = ? and dni = ?";
	
	
	private Database db;
	private StateAction stateAction;
	private StateTipoEmpleado stateTipo;
	private List<Empleado> listaEmpleados;
	private String nombreEmpleadoGestion;
	private String apellidoEmpleadoGestion;
	private String dniEmpleadoGestion;
	private List<String> listaPosicionNoDeportiva;
	private List<String> listaPosicionDeportiva;
	
	public enum StateTipoEmpleado{
		DEPORTIVO,
		NO_DEPORTIVO;
	}
	
	public enum StateAction{
		AÑADIR,
		MODIFICAR,
		ELIMINAR;
	}
	
	public Service21911() {
		db = new Database();
		db.createDatabase(false);
		db.loadDatabase();
		listaEmpleados = new ArrayList<Empleado>();
		setStateTipo(StateTipoEmpleado.DEPORTIVO);
		listaPosicionNoDeportiva = new ArrayList<String>(List.of("Entradas y abonos", "Tienda", "Cocina", "Jardinería", "Seguridad", "Redes sociales"));
		listaPosicionDeportiva = new ArrayList<String>(List.of("Técnico", "Jugador"));
	}
	
	public StateAction getStateAction() {
		return this.stateAction;
	}
	
	public StateTipoEmpleado getStateTipo() {
		return this.stateTipo;
	}
	
	public List<Empleado> getListaEmpleados(){
		return this.listaEmpleados;
	}
	
	public String getNombreEmpleadoGestion() {
		return nombreEmpleadoGestion;
	}
	
	public String getApellidoEmpleadoGestion() {
		return apellidoEmpleadoGestion;
	}
	
	public String getDniEmpleadoGestion() {
		return dniEmpleadoGestion;
	}
	
	public Database getDatabase() {
		return this.db;
	}
	
	public List<String> getListaPosicionNoDeportiva(){
		return listaPosicionNoDeportiva;
	}
	
	public List<String> getListaPosicionDeportiva(){
		return listaPosicionDeportiva;
	}
	
	public void setStateAction(StateAction st) {
		this.stateAction=st;
	}
	
	public void setStateTipo(StateTipoEmpleado st) {
		this.stateTipo=st;
	}
	
	public void setListaEmpleados(List<Empleado> l) {
		this.listaEmpleados = l;
	}
	
	
	public void cargarEmpleadosDeportivos(){
		if(listaEmpleados.size() > 0) {
			listaEmpleados.clear();
		}
		List<EmpleadoDeportivo> led = 
				db.executeQueryPojo(EmpleadoDeportivo.class, TODOS_EMPLEADOS_DEPORTIVOS);
		for(EmpleadoDeportivo ed : led) {
			listaEmpleados.add(ed);
		}
	}
	
	public void cargarEmpleadosNoDeportivos(){
		if(listaEmpleados.size() > 0) {
			listaEmpleados.clear();
		}
		List<EmpleadoNoDeportivo> lend = 
				db.executeQueryPojo(EmpleadoNoDeportivo.class, TODOS_EMPLEADOS_NO_DEPORTIVOS);
		for(EmpleadoNoDeportivo ed : lend) {
			listaEmpleados.add(ed);
		}
	}
	
	public void tableToEmpleado(String nombre, String apellido, String dni) {
		nombreEmpleadoGestion = nombre;
		apellidoEmpleadoGestion = apellido;
		dniEmpleadoGestion = dni;
	}
	
	public EmpleadoNoDeportivo cargarEmpleadoNoDeportivoAGestionar() {
		List<EmpleadoNoDeportivo> empleadoGestion =
		db.executeQueryPojo(
				EmpleadoNoDeportivo.class, EMPLEADO_NO_DEPORTIVO_GESTIONAR, 
				nombreEmpleadoGestion, apellidoEmpleadoGestion, dniEmpleadoGestion);
		return empleadoGestion.get(0);
	}
	
	public EmpleadoDeportivo cargarEmpleadoDeportivoAGestionar() {
		List<EmpleadoDeportivo> empleadoGestion =
		db.executeQueryPojo(
				EmpleadoDeportivo.class, EMPLEADO_DEPORTIVO_GESTIONAR, 
				nombreEmpleadoGestion, apellidoEmpleadoGestion, dniEmpleadoGestion);
		return empleadoGestion.get(0);
	}
	
	public void eliminarEmpleadoClub() {
		String[] sql = new String[1];
		
		String sqlDeportivo = "delete from empleadodeportivo where nombre = '" + getNombreEmpleadoGestion()+
				"' and apellido = '"+ getApellidoEmpleadoGestion()+ "' and dni = '"+ getDniEmpleadoGestion()+"'";
		String sqlNoDeportivo = "delete from empleadonodeportivo where nombre = '" + getNombreEmpleadoGestion()+
				"' and apellido = '"+ getApellidoEmpleadoGestion()+ "' and dni = '"+ getDniEmpleadoGestion()+"'";
		
		if (this.stateTipo == StateTipoEmpleado.DEPORTIVO) {
			sql[0] = sqlDeportivo;
			db.executeBatch(sql);
		}else {
			sql[0] = sqlNoDeportivo;
			db.executeBatch(sql);
		}
	}
	
	public void añadirEmpleadoDeportivo(String nombre, String apellido, String dni, String telefono, Object cbaño, Object cbmes, Object cbdia, String txsalario, Object posicion) {
		String año = String.valueOf(cbaño);
		String mes = String.valueOf(cbmes);
		String dia = String.valueOf(cbdia);
		String fecha = año+"-"+mes+"-"+dia;
		double salario = Double.parseDouble(txsalario);
		String sql = "insert into empleadodeportivo (nombre,apellido,dni,fechaNacimiento,salarioAnual,telefono,posicion)"
				+ "values (" + "'"+nombre+"'"+","+"'"+apellido+"'"+","+
				"'"+dni+"'"+","+"'"+fecha+"'"+","+salario+","+
				"'"+telefono+"'"+","+"'"+posicion+"'"+")";
		
		String[] sqls = new String[1];
		sqls[0]=sql;
		db.executeBatch(sqls);
	}
	
	public void añadirEmpleadoNoDeportivo(String nombre, String apellido, String dni, String telefono, Object cbaño, Object cbmes, Object cbdia, String txsalario, Object posicion) {
		String año = String.valueOf(cbaño);
		String mes = String.valueOf(cbmes);
		String dia = String.valueOf(cbdia);
		String fecha = año+"-"+mes+"-"+dia;
		double salario = Double.parseDouble(txsalario);
		String sql = "insert into empleadonodeportivo (nombre,apellido,dni,fechaNacimiento,salarioAnual,telefono,posicion)"
				+ "values (" + "'"+nombre+"'"+","+"'"+apellido+"'"+","+
				"'"+dni+"'"+","+"'"+fecha+"'"+","+salario+","+
				"'"+telefono+"'"+","+"'"+posicion+"'"+")";
		
		String[] sqls = new String[1];
		sqls[0]=sql;
		db.executeBatch(sqls);
	}
	
	public void modificarEmpleadoDeportivo(String nombre, String apellido, String dni, String telefono, Object cbaño, Object cbmes, Object cbdia, String txsalario, Object posicion) {
		String año = String.valueOf(cbaño);
		String mes = String.valueOf(cbmes);
		String dia = String.valueOf(cbdia);
		String fecha = año+"-"+mes+"-"+dia;
		double salario = Double.parseDouble(txsalario);
		
		db.executeUpdate(UPDATE_EMPLEADO_DEPORTIVO, nombre,apellido,dni,fecha,salario,telefono,posicion,nombreEmpleadoGestion,apellidoEmpleadoGestion,dniEmpleadoGestion);
	}
	
	public void modificarEmpleadoNoDeportivo(String nombre, String apellido, String dni, String telefono, Object cbaño, Object cbmes, Object cbdia, String txsalario, Object posicion) {
		String año = String.valueOf(cbaño);
		String mes = String.valueOf(cbmes);
		String dia = String.valueOf(cbdia);
		String fecha = año+"-"+mes+"-"+dia;
		double salario = Double.parseDouble(txsalario);
		
		db.executeUpdate(UPDATE_EMPLEADO_NO_DEPORTIVO, nombre,apellido,dni,fecha,salario,telefono,posicion, nombreEmpleadoGestion,apellidoEmpleadoGestion,dniEmpleadoGestion);
	}
	
	public void estadoInicial() {
		setStateAction(null);
		setStateTipo(StateTipoEmpleado.DEPORTIVO);
		nombreEmpleadoGestion = null;
		apellidoEmpleadoGestion = null;
		dniEmpleadoGestion = null;
		listaEmpleados = new ArrayList<Empleado>();
	}
}
