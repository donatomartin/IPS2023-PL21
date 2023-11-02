package ips2023pl21;

import java.awt.EventQueue;

import ips2023pl21.service.Service22759;
import ips2023pl21.ui.Frame22759;
import ips2023pl21.ui.MainFrame;

public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					MainFrame frame = new MainFrame();
//					frame.setVisible(true);
					
					Frame22759 f=new Frame22759(new Service22759());
					f.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
