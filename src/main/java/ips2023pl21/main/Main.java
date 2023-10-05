package ips2023pl21.main;

import java.util.List;

import ip2023pl21.util.Database;

public class Main {

	public static void main(String[] args) {
		Database db = new Database();
		db.createDatabase(false);
		db.loadDatabase();
		List<EmpleadoDeportivo> lista = db.executeQueryPojo(EmpleadoDeportivo.class, 
				"select * from empleadodeportivo");
		
		for(EmpleadoDeportivo ed : lista) {
			System.out.println(ed.getNombre());
		}
	}

}
