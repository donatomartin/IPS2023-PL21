package ips2023pl21.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ips2023pl21.model.Usuario;
import ips2023pl21.model.entradas.EntradasModel;
import ips2023pl21.model.ventas.VentasModel;
import ips2023pl21.service.*;
import ips2023pl21.service.Service22759;
import ips2023pl21.ui.parts.ValueButton;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private static MainService service = new MainService();
	private static Service22748_9 s22748_9 = new Service22748_9();
	
	private static Usuario usuario = new Usuario();

	private JPanel contentPane;
	private JPanel pnWork;
	private JPanel pnNorte;
	private JLabel lbTitle;
	
	private JButton btnRegistro;

	private ValueButton<String> btn21911;
	private ValueButton<String> btn21912;
	private ValueButton<String> btn21913;
	private ValueButton<String> btn21914;
	private ValueButton<String> btn21915;
	private ValueButton<String> btn21916;
	private ValueButton<String> btn21917;
	private ValueButton<String> btn21918;
	private ValueButton<String> btn22733;
	private ValueButton<String> btn22739;
	private ValueButton<String> btn22759;
	private ValueButton<String> btn22784;
	private ValueButton<String> btn22785;
	private ValueButton<String> btn22748;
	private ValueButton<String> btn22749;
	private ValueButton<String> btn23558;
	private ValueButton<String> btn23539;

	@SuppressWarnings("unchecked")
	private ValueButton<String>[] buttons = new ValueButton[] { getBtn21911(), getBtn21912(), getBtn21913(),
			getBtn21914(), getBtn21915(), getBtn21916(), getBtn21917(), getBtn21918(), getBtn22733(), getBtn22739(),
			getBtn22759(), getBtn22784(), getBtn22785(), getBtn22748(), getBtn22749(), getBtn23558(), getBtn23539() 
		};

	private JPanel pnCentro;
	private JPanel pnLogin;
	private JPanel pnCredentials;
	private JTextField txUser;
	private JButton btnLogin;
	private JLabel lbPassword;
	private JLabel lbUser;
	private JPasswordField txPassword;
	

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
		contentPane.add(getPnNorte(), BorderLayout.NORTH);
		contentPane.add(getPnCentro(), BorderLayout.CENTER);
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
					new Service21917(new EntradasModel(), new Frame21917());
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
					Frame22785 frame = new Frame22785(new Service22785(usuario.getPid()));
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
					new Service21918(new Frame21918(), new VentasModel());
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
					Service22759 service = new Service22759();
					Frame22759 f = new Frame22759(service);
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
					Service22733 service = new Service22733();
					Frame22733 frame = new Frame22733(service);
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

private static void run23539() {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				Frame23539_1 frame = new Frame23539_1(new Service23539());
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
}
	
	private static void run23558() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Service23558 cs = new Service23558();
					Frame23558 frame = new Frame23558(cs);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	private JPanel getPnWork() {
		if (pnWork == null) {
			pnWork = new JPanel();
			pnWork.setBackground(new Color(255, 235, 205));
			pnWork.setLayout(new GridLayout(4, 4, 0, 0));
		}
		return pnWork;
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

	private ValueButton<String> getBtn21911() {
		if (btn21911 == null) {
			btn21911 = new ValueButton<String>("<html><p>Gestion de empleados</p><p>(21911)</p><html>");
			btn21911.setValue("admin");
			btn21911.setBackground(new Color(240, 255, 240));
			btn21911.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					run21911();
				}
			});
		}
		return btn21911;
	}

	private ValueButton<String> getBtn21912() {
		if (btn21912 == null) {
			btn21912 = new ValueButton<String>("<html><p>Horarios Trabajo</p><p>(21912)</p><html>");
			btn21912.setValue("admin");
			btn21912.setBackground(new Color(240, 255, 240));
			btn21912.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					run21912();
				}
			});
		}
		return btn21912;
	}

	private ValueButton<String> getBtn21913() {
		if (btn21913 == null) {
			btn21913 = new ValueButton<String>("<html><p>Reserva Instalaciones</p><p>(21913)</p><html>");
			btn21913.setValue("ginstalaciones");
			btn21913.setBackground(new Color(240, 255, 240));
			btn21913.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					run21913();
				}
			});
		}
		return btn21913;
	}

	private ValueButton<String> getBtn21914() {
		if (btn21914 == null) {
			btn21914 = new ValueButton<String>("<html><p>Añadir Equipos</p><p>(21914)</p><html>");
			btn21914.setValue("admin");
			btn21914.setBackground(new Color(240, 255, 240));
			btn21914.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					run21914();
				}
			});
		}
		return btn21914;
	}

	private ValueButton<String> getBtn21915() {
		if (btn21915 == null) {
			btn21915 = new ValueButton<String>("<html><p>Entrevistas</p><p>(21915)</p><html>");
			btn21915.setValue("entrenador");
			btn21915.setBackground(new Color(240, 255, 240));
			btn21915.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					run21915();
				}
			});
		}
		return btn21915;
	}

	private ValueButton<String> getBtn21916() {
		if (btn21916 == null) {
			btn21916 = new ValueButton<String>("<html><p>Tienda</p><p>(21916, 22758)</p><html>");
			btn21916.setValue("gventas");
			btn21916.setBackground(new Color(240, 255, 240));
			btn21916.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					run21916();
				}
			});
		}
		return btn21916;
	}

	private ValueButton<String> getBtn21917() {
		if (btn21917 == null) {
			btn21917 = new ValueButton<String>("<html><p>Compra de Entradas</p><p>(21917)</p><html>");
			btn21917.setValue("gventas");
			btn21917.setBackground(new Color(240, 255, 240));
			btn21917.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					run21917();
				}
			});
		}
		return btn21917;
	}

	private ValueButton<String> getBtn21918() {
		if (btn21918 == null) {
			btn21918 = new ValueButton<String>("<html><p>Historial de Ventas</p><p>(21918)</p><html>");
			btn21918.setValue("gventas");
			btn21918.setBackground(new Color(240, 255, 240));
			btn21918.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					run21918();
				}
			});
		}
		return btn21918;
	}

	private ValueButton<String> getBtn22733() {
		if (btn22733 == null) {
			btn22733 = new ValueButton<String>("<html><p>Compra de abonos</p><p>(2733)</p><html>");
			btn22733.setValue("gventas");
			btn22733.setBackground(new Color(240, 255, 240));
			btn22733.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					run22733();
				}
			});
		}
		return btn22733;
	}

	private ValueButton<String> getBtn22739() {
		if (btn22739 == null) {
			btn22739 = new ValueButton<String>("<html><p>Gestión Partidos</p><p>(22739)</p><html>");
			btn22739.setValue("gventas");
			btn22739.setBackground(new Color(240, 255, 240));
			btn22739.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					run22739();
				}
			});
		}
		return btn22739;
	}

	private ValueButton<String> getBtn22759() {
		if (btn22759 == null) {
			btn22759 = new ValueButton<String>("<html><p>Noticias</p><p>(22759)</p><html>");
			btn22759.setValue("cm");
			btn22759.setBackground(new Color(240, 255, 240));
			btn22759.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					run22759();
				}

			});
		}
		return btn22759;
	}

	private ValueButton<String> getBtn22784() {
		if (btn22784 == null) {
			btn22784 = new ValueButton<String>("<html><p>Jardinería</h1><p>(22784)</p><html>");
			btn22784.setValue("admin");
			btn22784.setBackground(new Color(240, 255, 240));
			btn22784.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					run22784();
				}

			});
		}
		return btn22784;
	}

	private ValueButton<String> getBtn22785() {
		if (btn22785 == null) {
			btn22785 = new ValueButton<String>("<html><p>Entrenamientos</h1><p>(22784)</p><html>");
			btn22785.setValue("entrenador");
			btn22785.setBackground(new Color(240, 255, 240));
			btn22785.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					run22785();
				}

			});
		}
		return btn22785;
	}

	private ValueButton<String> getBtn22748() {
		if (btn22748 == null) {
			btn22748 = new ValueButton<String>("<html><p>Portal de accionistas</h1><p>(22748)</p><html>");
			btn22748.setValue("accionista");
			btn22748.setBackground(new Color(240, 255, 240));
			btn22748.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					run22748();
				}
			});
		}
		return btn22748;
	}
	
	private ValueButton<String> getBtn22749() {
		if (btn22749 == null) {
			btn22749 = new ValueButton<String>("<html><p>Ampliaciones de capital</h1><p>(22749)</p><html>");
			btn22749.setValue("admin");
			btn22749.setBackground(new Color(240, 255, 240));
			btn22749.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					run22749();
				}
			});
		}
		return btn22749;
	}

	
	private ValueButton<String> getBtn23558() {
		if (btn23558 == null) {
			btn23558 = new ValueButton<String>("<html><p>Gestión y actualización de lesiones</h1><p>(23558)</p><html>");
			btn23558.setValue("admin");
			btn23558.setBackground(new Color(240, 255, 240));
			btn23558.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					run23558();
				}
			});
		}
		return btn23558;
	}
	
	private ValueButton<String> getBtn23539() {
		if (btn23539 == null) {
			btn23539 = new ValueButton<String>("<html><p>Gráfico balance compra - venta</h1><p>(23539)</p><html>");
			btn23539.setValue("gventas");
			btn23539.setBackground(new Color(240, 255, 240));
			btn23539.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					run23539();
				}
			});
		}
		return btn23558;
	}

	private JPanel getPnCentro() {
		if (pnCentro == null) {
			pnCentro = new JPanel();
			pnCentro.setLayout(new CardLayout(0, 0));
			pnCentro.add(getPnLogin(), "login");
			pnCentro.add(getPnWork(), "work");
		}
		return pnCentro;
	}

	private JPanel getPnLogin() {
		if (pnLogin == null) {
			pnLogin = new JPanel();
			pnLogin.setLayout(new BoxLayout(pnLogin, BoxLayout.X_AXIS));
			pnLogin.add(getPnCredentials());
		}
		return pnLogin;
	}

	private JPanel getPnCredentials() {
		if (pnCredentials == null) {
			pnCredentials = new JPanel();
			GroupLayout gl_pnCredentials = new GroupLayout(pnCredentials);
			gl_pnCredentials.setHorizontalGroup(
				gl_pnCredentials.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_pnCredentials.createSequentialGroup()
						.addContainerGap(343, Short.MAX_VALUE)
						.addGroup(gl_pnCredentials.createParallelGroup(Alignment.LEADING)
							.addComponent(getLbUser(), GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_pnCredentials.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(getBtnLogin())
								.addGroup(gl_pnCredentials.createSequentialGroup()
									.addComponent(getLbPassword())
									.addGap(148))
								.addComponent(getTxPassword())
								.addComponent(getTxUser())
								.addComponent(getBtnRegistro())))
						.addGap(32))
			);
			gl_pnCredentials.setVerticalGroup(
				gl_pnCredentials.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_pnCredentials.createSequentialGroup()
						.addContainerGap(135, Short.MAX_VALUE)
						.addComponent(getLbUser())
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(getTxUser(), GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addGap(22)
						.addComponent(getLbPassword())
						.addGap(17)
						.addComponent(getTxPassword(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(getBtnLogin())
						.addGap(67)
						.addComponent(getBtnRegistro())
						.addGap(44))
			);
			pnCredentials.setLayout(gl_pnCredentials);
		}
		return pnCredentials;
	}

	private JTextField getTxUser() {
		if (txUser == null) {
			txUser = new JTextField();
			txUser.setColumns(10);
		}
		return txUser;
	}

	private JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("Log In");
			btnLogin.setMnemonic('l');
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					usuario = new Usuario();
					usuario.setUsuario(getTxUser().getText());
					usuario.setContrasena(new String(getTxPassword().getPassword()));
					State res = service.checkUser(usuario);

					switch (res) {
					case ENCRYPTION_ERROR:
						JOptionPane.showMessageDialog(null, "Error: Could not encrypt.", "Error",
								JOptionPane.ERROR_MESSAGE);
						break;
					case LOGINFAIL_USERNOTFOUND:
						JOptionPane.showMessageDialog(null, "Error: Usuario o contraseña incorrectos.", "Error",
								JOptionPane.ERROR_MESSAGE);
						break;
					case LOGINFAIL_USERNOTALLOWED:
						JOptionPane.showMessageDialog(null, "Error: Usuario no permitido en el sistema.", "Error",
								JOptionPane.ERROR_MESSAGE);
						break;
					case SUCCESS:
						for (ValueButton<String> button : buttons) {
							if (usuario.getRol().equals(button.getValue())) {
								getPnWork().add(button);
							}
						}
						((CardLayout) getPnCentro().getLayout()).show(getPnCentro(), "work");
						break;
					default:
						break;
					}

				}
			});
		}
		return btnLogin;

	}

	private JLabel getLbPassword() {
		if (lbPassword == null) {
			lbPassword = new JLabel("Contraseña");
		}
		return lbPassword;
	}

	private JLabel getLbUser() {
		if (lbUser == null) {
			lbUser = new JLabel("Usuario");
		}
		return lbUser;
	}

	private JPasswordField getTxPassword() {
		if (txPassword == null) {
			txPassword = new JPasswordField();
		}
		return txPassword;
	}
	private JButton getBtnRegistro() {
		if (btnRegistro == null) {
			btnRegistro = new JButton("Registrate");
			btnRegistro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JTextField usuarioField = new JTextField();
					JPasswordField contrasenaField = new JPasswordField();
					JTextField rolField = new JTextField();
					JTextField pidField = new JTextField();
					Object[] message = {
						"Usuario:", usuarioField,
						"Contraseña:", contrasenaField,
						"Rol:", rolField,
						"Id (optional):", pidField
					};

					int option = JOptionPane.showConfirmDialog(null, message, "Registro", JOptionPane.OK_CANCEL_OPTION);
					if (option == JOptionPane.OK_OPTION) {
						String usuario = usuarioField.getText();
						String contrasena = new String(contrasenaField.getPassword());
						String rol = rolField.getText();
						
						int pid = 0;
						if (!pidField.getText().isBlank())
							try {
								pid = Integer.parseInt(pidField.getText());
							} catch(Exception exception) {
							}
						
						Usuario u = new Usuario();
						u.setUsuario(usuario);
						u.setContrasena(contrasena);
						u.setRol(rol);
						u.setPid(pid);
						
						State res = service.addUser(u);
						
						switch (res) {
						case SUCCESS:
							JOptionPane.showMessageDialog(null, "Success: User created.", "Sing in",
									JOptionPane.INFORMATION_MESSAGE);
							break;
						case ENCRYPTION_ERROR:
							JOptionPane.showMessageDialog(null, "Error: Could not encrypt.", "Error",
									JOptionPane.ERROR_MESSAGE);
							break;
						case SINGINFAIL_USEREXISTS:
							JOptionPane.showMessageDialog(null, "Error: User already exists.", "Error",
									JOptionPane.ERROR_MESSAGE);
							break;
							
						default: break;
						}
					}
				}
			});
		}
		return btnRegistro;
	}

}
