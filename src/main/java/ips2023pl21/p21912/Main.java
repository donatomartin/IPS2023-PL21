package ips2023pl21.p21912;

import java.awt.EventQueue;

import ips2023pl21.p21912.service.Service21912;
import ips2023pl21.p21912.ui.Frame21912;

public class Main {
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Service21912 service = new Service21912();
					Frame21912 frame = new Frame21912(service);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
