package ips2023pl21.tienda;

import java.util.List;

import ip2023pl21.util.Database;

public class TiendaData {
	
	public static List<Merchandaising> cargarArticulos(){
		Database db = new Database();
		db.createDatabase(false);
		db.loadDatabase();
		List<Merchandaising> articulos = db.executeQueryPojo(Merchandaising.class, 
				"select * from merchandaising");
		
		return articulos;
	}
	
	public static void añadirPrecio(int id, double precio) {
		Database db = new Database();
		db.createDatabase(false);
		db.loadDatabase();
		db.executeUpdate("insert into venta(id,cantidad) values (" + id + "," + precio + ");");
	}
}
