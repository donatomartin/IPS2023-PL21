package ips2023pl21;

import java.awt.EventQueue;

import ips2023pl21.service.Service21915;
import ips2023pl21.ui.Frame21915;

public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Service21915 service = new Service21915();
					Frame21915 frame = new Frame21915(service);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
