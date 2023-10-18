package ips2023pl21.tienda;

import java.util.ArrayList;
import java.util.Calendar;
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
	
	public static void añadirVenta(TiendaLogica tl) {
		Database db = new Database();
		db.createDatabase(false);
		db.loadDatabase();
		
		Calendar c = Calendar.getInstance();
		String fecha = c.get(Calendar.YEAR) + "-" + c.get(Calendar.MONTH) + "-" + c.get(Calendar.DAY_OF_MONTH);
		
		db.executeUpdate("insert into venta(concepto,fecha,hora,minuto,cuantia) values (?,?,?,?,?)",
				"merchandaising",fecha,c.get(Calendar.HOUR),c.get(Calendar.MINUTE),tl.getPrecioTotal());
		
		for(Merchandaising a : tl.getSeleccionado()) {
			db.executeUpdate("insert into ventamerchandising(concepto,fecha,hora,minuto,cuantia,producto,unidades,precioPorProducto)"
					+ " values(?,?,?,?,?,?,?,?)",
					"merchandaising",fecha,c.get(Calendar.HOUR),c.get(Calendar.MINUTE),
					tl.getPrecioTotal(), a.getNombre(),a.getUnidades(),a.getPrecio());
		}
		
	}
}
