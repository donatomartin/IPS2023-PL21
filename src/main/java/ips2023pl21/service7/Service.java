package ips2023pl21.service7;

import ip2023pl21.util.Database;
import ips2023pl12.ui7.EntradasView;
import ips2923pl21.model7.EntradasController;
import ips2923pl21.model7.EntradasModel;

public class Service {
	
	public void run() {
		Database db = new Database();
		db.createDatabase(false);
		db.loadDatabase();
		EntradasController c=new EntradasController(new EntradasModel(), new EntradasView());
	}

}
