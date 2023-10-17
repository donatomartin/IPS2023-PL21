package ips2023pl21.tienda;

import java.util.ArrayList;
import java.util.List;

import ip2023pl21.util.Database;

public class TiendaData {
	
	
	public static List<Merchandaising> cargarArticulos(){
		Database db = new Database();
		db.createDatabase(false);
		db.loadDatabase();
		
		List<Object[]> articulos = db.executeQueryArray("select * from merchandaising");
		
		List<Merchandaising> ret = new ArrayList<>();
		
		for(Object[] o : articulos) {
			ret.add(new Merchandaising(o[0].toString(), o[1].toString(), (double) o[2]));
		}
		return ret;
	}
	
	public static void añadirPrecio(int id, double precio) {
		Database db = new Database();
		db.createDatabase(false);
		db.loadDatabase();
		db.executeUpdate("insert into venta(id,cantidad) values (" + id + "," + precio + ");");
	}
}
