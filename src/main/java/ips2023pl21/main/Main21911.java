package ips2023pl21.main;

import java.awt.EventQueue;
import ips2023pl21.service.ClubService21911;
import ips2023pl21.ui.VentanaGestionEmpleados21911;

public class Main21911 {

	public static void main(String[] args) {
		ClubService21911 cs = new ClubService21911();
		System.out.println("Cambios en la rama");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					VentanaGestionEmpleados21911 frame = 
							new VentanaGestionEmpleados21911(cs);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
