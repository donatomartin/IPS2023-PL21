package ips2023pl21.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ips2023pl21.service.Service21911;
import ips2023pl21.service.Service21912;
import ips2023pl21.service.Service21915;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pnCentro;
	private JPanel pnNorte;
	private JLabel lbTitle;
	private JButton btn21911;
	private JButton btn21912;
	private JButton btn21913;
	private JButton btn21914;
	private JButton btn21915;
	private JButton btn21916;
	private JButton btn21917;
	private JButton btn21918;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JButton btnNewButton_6;
	private JButton btnNewButton_7;

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

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 472, 481);
		contentPane = new JPanel();
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPnCentro());
		contentPane.add(getPnNorte(), BorderLayout.NORTH);
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

	private JPanel getPnCentro() {
		if (pnCentro == null) {
			pnCentro = new JPanel();
			pnCentro.setBackground(new Color(255, 255, 255));
			pnCentro.setLayout(new GridLayout(0, 4, 0, 0));
			pnCentro.add(getBtn21911());
			pnCentro.add(getBtn21912());
			pnCentro.add(getBtn21913());
			pnCentro.add(getBtn21914());
			pnCentro.add(getBtn21915());
			pnCentro.add(getBtn21916());
			pnCentro.add(getBtn21917());
			pnCentro.add(getBtn21918());
			pnCentro.add(getBtnNewButton());
			pnCentro.add(getBtnNewButton_1());
			pnCentro.add(getBtnNewButton_2());
			pnCentro.add(getBtnNewButton_3());
			pnCentro.add(getBtnNewButton_4());
			pnCentro.add(getBtnNewButton_5());
			pnCentro.add(getBtnNewButton_6());
			pnCentro.add(getBtnNewButton_7());
		}
		return pnCentro;
	}
	private JPanel getPnNorte() {
		if (pnNorte == null) {
			pnNorte = new JPanel();
			pnNorte.add(getLbTitle());
		}
		return pnNorte;
	}
	private JLabel getLbTitle() {
		if (lbTitle == null) {
			lbTitle = new JLabel("Gestion Deportiva");
			lbTitle.setFont(new Font("Tahoma", Font.BOLD, 22));
		}
		return lbTitle;
	}
	private JButton getBtn21911() {
		if (btn21911 == null) {
			btn21911 = new JButton("21911");
			btn21911.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					run21911();
				}
			});
		}
		return btn21911;
	}
	private JButton getBtn21912() {
		if (btn21912 == null) {
			btn21912 = new JButton("21912");
			btn21912.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					run21912();
				}
			});
		}
		return btn21912;
	}
	private JButton getBtn21913() {
		if (btn21913 == null) {
			btn21913 = new JButton("21913");
		}
		return btn21913;
	}
	private JButton getBtn21914() {
		if (btn21914 == null) {
			btn21914 = new JButton("21914");
		}
		return btn21914;
	}
	private JButton getBtn21915() {
		if (btn21915 == null) {
			btn21915 = new JButton("21915");
			btn21915.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					run21915();
				}
			});
		}
		return btn21915;
	}
	private JButton getBtn21916() {
		if (btn21916 == null) {
			btn21916 = new JButton("21916");
		}
		return btn21916;
	}
	private JButton getBtn21917() {
		if (btn21917 == null) {
			btn21917 = new JButton("21917");
		}
		return btn21917;
	}
	private JButton getBtn21918() {
		if (btn21918 == null) {
			btn21918 = new JButton("21918");
		}
		return btn21918;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("New button");
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("New button");
		}
		return btnNewButton_1;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("New button");
		}
		return btnNewButton_2;
	}
	private JButton getBtnNewButton_3() {
		if (btnNewButton_3 == null) {
			btnNewButton_3 = new JButton("New button");
		}
		return btnNewButton_3;
	}
	private JButton getBtnNewButton_4() {
		if (btnNewButton_4 == null) {
			btnNewButton_4 = new JButton("New button");
		}
		return btnNewButton_4;
	}
	private JButton getBtnNewButton_5() {
		if (btnNewButton_5 == null) {
			btnNewButton_5 = new JButton("New button");
		}
		return btnNewButton_5;
	}
	private JButton getBtnNewButton_6() {
		if (btnNewButton_6 == null) {
			btnNewButton_6 = new JButton("New button");
		}
		return btnNewButton_6;
	}
	private JButton getBtnNewButton_7() {
		if (btnNewButton_7 == null) {
			btnNewButton_7 = new JButton("New button");
		}
		return btnNewButton_7;
	}
}
