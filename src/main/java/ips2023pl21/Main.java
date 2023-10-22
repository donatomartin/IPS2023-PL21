package ips2023pl21;

import java.awt.EventQueue;

import ips2023pl21.service.Service21911;
import ips2023pl21.service.Service21912;
import ips2023pl21.service.Service21915;
import ips2023pl21.ui.Frame21911;
import ips2023pl21.ui.Frame21912;
import ips2023pl21.ui.Frame21915;

public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		run21911();
		run21912();
		run21915();
	}

	private static void run21911() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Service21911 cs = new Service21911();
					Frame21911 frame = new Frame21911(cs);
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private static void run21912() {
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

	private static void run21915() {
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
