package ips2023pl21.main;

import java.awt.EventQueue;

import ips2023pl21.service.ClubService21913;
import ips2023pl21.ui.VentanaReservaInstalaciones21013;

public class Main21913 {

	public static void main(String[] args) {
		ClubService21913 cs = new ClubService21913();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaReservaInstalaciones21013 frame = new VentanaReservaInstalaciones21013(cs);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
