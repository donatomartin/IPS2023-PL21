package ips2023pl21.service7;

import ip2023pl21.util.Database;
import ips2023pl21.model8.VentasController;
import ips2023pl21.model8.VentasModel;
import ips2023pl21.ui8.VentasView;

public class Service {

	public void run() {
		Database db = new Database();
		db.createDatabase(false);
		db.loadDatabase();
		VentasController v=new VentasController(new VentasView(), new VentasModel());
	}
}
