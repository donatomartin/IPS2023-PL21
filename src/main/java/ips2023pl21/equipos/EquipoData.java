package ips2023pl21.equipos;

import java.util.ArrayList;
import java.util.List;

import ip2023pl21.util.Database;

public class EquipoData {

	public static void añadirEquipo(EquipoDeportivo equipoDeportivo) {
		Database db = new Database();
		db.createDatabase(false);
		db.loadDatabase();
		
		if(equipoDeportivo instanceof EquipoEnFormacion) {
			db.executeUpdate("insert into equipo(nombre,categoria,esFilial) values ('null','" + 
					((EquipoEnFormacion)equipoDeportivo).categoria + "','null');");
		} else if(equipoDeportivo instanceof EquipoProfesional) {
			db.executeUpdate("insert into equipo(nombre,categoria,esFilial) values ('null','null','" + 
						((EquipoProfesional)equipoDeportivo).isFilial() + "');");
		}
	}
	
	public static List<EmpleadoDeportivo> cargarEmpleadosDeportivos(String posicion) {
		Database db = new Database();
		db.createDatabase(false);
		db.loadDatabase();
		
		List<Object[]> empleados = db.executeQueryArray("select * from empleadodeportivo where posicion = ?",posicion);
		List<EmpleadoDeportivo> ret = new ArrayList<EmpleadoDeportivo>();
		
		for(Object[] o : empleados) {
			
			float salary = Float.valueOf(o[5].toString());
			ret.add(new EmpleadoDeportivo((int)o[0] ,o[1].toString(),o[2].toString(),o[3].toString(),o[4].toString(),
					 salary ,o[6].toString(), o[7].toString()));
		}
		
		return ret;
		
	}

}
