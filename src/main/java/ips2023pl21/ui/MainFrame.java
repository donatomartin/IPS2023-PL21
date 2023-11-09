package ips2023pl21.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ips2023pl21.model.entradas.EntradasModel;
import ips2023pl21.model.ventas.VentasModel;
import ips2023pl21.service.*;
import ips2023pl21.service.Service22759;

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
	private static Service22748_9 s22748_9 = new Service22748_9();
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
	private JButton btn22733;
	private JButton btn22739;
	private JButton btn22759;
	private JButton btn22784;
	private JButton btn22785;
	private JButton btn22748;
	private JButton btn22749;
	private JButton btnNewButton;

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 589, 485);
		contentPane = new JPanel();
		contentPane.setBorder(null);

		setMinimumSize(getSize());
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
	
	private static void run21913() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Service21913 service = new Service21913();
					Frame21913 frame = new Frame21913(service);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void run21914() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Frame21914();
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
	
	private void run21916() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Frame21916();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
	private static void run21917() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Service21917( new EntradasModel(),new Frame21917());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private static void run22784() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame22784 frame = new Frame22784(new Service22784());
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private static void run22785() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame22785 frame = new Frame22785(new Service22785());
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private static void run21918() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Service21918( new Frame21918(),new VentasModel());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	private void run22759() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Service22759 service=new Service22759();
					Frame22759 f=new Frame22759(service);
					f.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	public static void run22739() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Frame22739();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void run22733() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Service22733 service=new Service22733();
					Frame22733 frame=new Frame22733(service);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	private static void run22748() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame22748 frame = new Frame22748(s22748_9);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

private static void run22749() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame22749 frame = new Frame22749(s22748_9);
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
			pnCentro.add(getBtn22733());
			pnCentro.add(getBtn22739());
			pnCentro.add(getBtn22759());
			pnCentro.add(getBtn22784());
			pnCentro.add(getBtn22785());
			pnCentro.add(getBtn22748());
			pnCentro.add(getBtn22749());
			pnCentro.add(getBtnNewButton());
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
			btn21911 = new JButton("<html><p>Gestion de empleados</p><p>(21911)</p><html>");
			btn21911.setBackground(new Color(255, 228, 225));
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
			btn21912 = new JButton("<html><p>Horarios Trabajo</p><p>(21912)</p><html>");
			btn21912.setBackground(new Color(255, 228, 181));
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
			btn21913 = new JButton("<html><p>Reserva Instalaciones</p><p>(21913)</p><html>");
			btn21913.setBackground(new Color(255, 228, 225));
			btn21913.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					run21913();
				}
			});
		}
		return btn21913;
	}
	private JButton getBtn21914() {
		if (btn21914 == null) {
			btn21914 = new JButton("<html><p>Añadir Equipos</p><p>(21914)</p><html>");
			btn21914.setBackground(new Color(255, 228, 181));
			btn21914.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					run21914();
				}
			});
		}
		return btn21914;
	}
	private JButton getBtn21915() {
		if (btn21915 == null) {
			btn21915 = new JButton("<html><p>Entrevistas</p><p>(21915)</p><html>");
			btn21915.setBackground(new Color(255, 228, 181));
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
			btn21916 = new JButton("<html><p>Tienda</p><p>(21916, 22758)</p><html>");
			btn21916.setBackground(new Color(255, 228, 225));
			btn21916.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					run21916();
				}
			});
		}
		return btn21916;
	}
	private JButton getBtn21917() {
		if (btn21917 == null) {
			btn21917 = new JButton("<html><p>Compra de Entradas</p><p>(21917)</p><html>");
			btn21917.setBackground(new Color(255, 228, 181));
			btn21917.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					run21917();
				}
			});
		}
		return btn21917;
	}
	private JButton getBtn21918() {
		if (btn21918 == null) {
			btn21918 = new JButton("<html><p>Historial de Ventas</p><p>(21918)</p><html>");
			btn21918.setBackground(new Color(255, 228, 225));
			btn21918.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					run21918();
				}
			});
		}
		return btn21918;
	}
	private JButton getBtn22733() {
		if (btn22733 == null) {
			btn22733 = new JButton("<html><p>Compra de abonos</p><p>(2733)</p><html>");
			btn22733.setBackground(new Color(255, 228, 225));
			btn22733.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					run22733();
				}
			});
		}
		return btn22733;
	}
	private JButton getBtn22739() {
		if (btn22739 == null) {
			btn22739 = new JButton("<html><p>Gestión Partidos</p><p>(22739)</p><html>");
			btn22739.setBackground(new Color(255, 228, 181));
			btn22739.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					run22739();
				}
			});
		}
		return btn22739;
	}
	private JButton getBtn22759() {
		if (btn22759 == null) {
			btn22759 = new JButton("<html><p>Noticias</p><p>(22759)</p><html>");
			btn22759.setBackground(new Color(255, 228, 225));
			btn22759.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					run22759();
				}

			});
		}
		return btn22759;
	}
	private JButton getBtn22784() {
		if (btn22784 == null) {
			btn22784 = new JButton("<html><p>Jardinería</h1><p>(22784)</p><html>");
			btn22784.setBackground(new Color(255, 228, 181));
			btn22784.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					run22784();
				}
				
			});
		}
		return btn22784;
	}
	private JButton getBtn22785() {
		if (btn22785 == null) {
			btn22785 = new JButton("<html><p>Entrenamientos</h1><p>(22784)</p><html>");
			btn22785.setBackground(new Color(255, 228, 181));
			btn22785.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					run22785();
				}
				
			});
		}
		return btn22785;
	}
	
	private JButton getBtn22748() {
		if (btn22748 == null) {
			btn22748 = new JButton("<html><p>Portal de accionistas</h1><p>(22748)</p><html>");
			btn22748.setBackground(new Color(255, 228, 225));
			btn22748.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					run22748();
				}
			});
		}
		return btn22748;
	}
	
	private JButton getBtn22749() {
		if (btn22749 == null) {
			btn22749 = new JButton("<html><p>Ampliaciones de capital</h1><p>(22749)</p><html>");
			btn22749.setBackground(new Color(255, 228, 181));
			btn22749.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					run22749();
				}
			});
		}
		return btn22749;
	}
	
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("");
			btnNewButton.setBackground(new Color(255, 228, 225));
		}
		return btnNewButton;
	}
}
