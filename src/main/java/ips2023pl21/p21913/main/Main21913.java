package ips2023pl21.p21913.main;

import java.awt.EventQueue;

import ips2023pl21.p21913.service.ClubService21913;
import ips2023pl21.p21913.ui.VentanaReservaInstalaciones21913;

public class Main21913 {

	public static void main(String[] args) {
		ClubService21913 cs = new ClubService21913();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaReservaInstalaciones21913 frame = new VentanaReservaInstalaciones21913(cs);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
