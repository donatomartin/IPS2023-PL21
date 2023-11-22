package ips2023pl21;

import java.awt.EventQueue;

import ips2023pl21.service.Service23539;
import ips2023pl21.ui.Frame23539;
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
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					Frame23539 f=new Frame23539(new Service23539());
					f.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
