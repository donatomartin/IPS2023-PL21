package ips2023pl21;

import java.awt.EventQueue;

import ips2023pl21.service.Service22733;
import ips2023pl21.ui.Frame22733;
import ips2023pl21.ui.MainFrame;

public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
