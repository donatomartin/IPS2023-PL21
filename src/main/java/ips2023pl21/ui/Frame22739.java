package ips2023pl21.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import ips2023pl21.model.activos.Merchandaising;
import ips2023pl21.model.equipos.EquipoDeportivo;
import ips2023pl21.model.equipos.Partido;
import ips2023pl21.service.Service22739;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.List;
import java.util.Calendar;
import javax.swing.JCheckBox;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

public class Frame22739 extends JFrame {

	private static final long serialVersionUID = 1L;

	private Service22739 service = new Service22739();

	private ProcesaBotonPartido pBP;

	private JPanel contentPane;
	private JPanel pnCrearComprar;
	private JPanel pnCrearPartido;
	private JPanel pnSeleccionarPartido;
	private JButton btCrearPartido;
	private JButton btComprarPartido;
	private JPanel pnCrearLabel;
	private JLabel lbCrearPartido;
	private JPanel pnCrearBt;
	private JButton btCrear;
	private JPanel pnCrearContenido;
	private JPanel pnLocal;
	private JPanel pnVisitante;
	private JPanel pnFecha;
	private JPanel pnSuplemento;
	private JLabel lbLocal;
	private JComboBox<String> cbLocal;
	private JLabel lbVisiante;
	private JTextField tfVisitante;
	private JLabel lbFecha;
	private JSpinner spFecha;
	private JCheckBox chckSuplemento;
	private JSpinner spSuplemento;
	private JPanel pnCabeceraSeleccion;
	private JPanel pnSocioNoSocio;
	private JButton btSocio;
	private JButton btNoSocio;
	private JComboBox<String> cbEquipo;
	private JLabel lbPartidos;
	private JScrollPane spPartidos;
	private JPanel pnPartidos;
	private JButton btVolverCrear;
	private JPanel pnVolverCompra;
	private JButton btVolverCompra;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame22739 frame = new Frame22739();
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
	public Frame22739() {

		pBP = new ProcesaBotonPartido();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 847, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		contentPane.add(getPnCrearComprar(), "crearComprar");
		contentPane.add(getPnCrearPartido(), "crear");
		contentPane.add(getPnSocioNoSocio(), "socio");
		contentPane.add(getPnSeleccionarPartido(), "seleccionar");
	}

	public class ProcesaBotonPartido implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton) e.getSource();
			int actionCommand = Integer.parseInt(source.getActionCommand());

		}
	}

	private void irAPn(String panel) {
		((CardLayout) contentPane.getLayout()).show(contentPane, panel);
	}

	private void crearBotonesPartidos() {
		getPnPartidos().removeAll();
		getPnPartidos().updateUI();
		System.out.println(getCbEquipo().getSelectedItem().toString());

		EquipoDeportivo equipo = service.getEquipoPorNombre(getCbEquipo().getSelectedItem().toString());

		String id = equipo.getId();
		List<Partido> partidos = service.getPartidosPorEquipo(id);

		if (partidos.size() <= 0) {
			JOptionPane.showMessageDialog(null, "no hay partidos para el equipo seleccionado");
		} else {
			for (int i = 0; i < partidos.size(); i++) {
				getPnPartidos().add(nuevoBotonPartido(i, id));
			}
		}

	}

	private Component nuevoBotonPartido(Integer posicion, String id) {
		JButton boton = new JButton("");
		String textoBt;
		Partido p = service.getPartidosPorEquipo(id).get(posicion);

		boton.addActionListener(pBP);
		textoBt = "Partido " + posicion + 1 + " " + p.getLocal() + " vs " + p.getVisitante();

		boton.setBackground(Color.white);
		boton.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
		boton.setActionCommand(posicion.toString());

		boton.setVerticalAlignment(SwingConstants.CENTER);

		boton.setText(textoBt);
		return boton;
	}

	private JPanel getPnCrearComprar() {
		if (pnCrearComprar == null) {
			pnCrearComprar = new JPanel();
			pnCrearComprar.setLayout(new GridLayout(1, 0, 0, 0));
			pnCrearComprar.add(getBtCrearPartido());
			pnCrearComprar.add(getBtComprarPartido());
		}
		return pnCrearComprar;
	}

	private JPanel getPnCrearPartido() {
		if (pnCrearPartido == null) {
			pnCrearPartido = new JPanel();
			pnCrearPartido.setLayout(new BorderLayout(0, 0));
			pnCrearPartido.add(getPnCrearLabel(), BorderLayout.NORTH);
			pnCrearPartido.add(getPnCrearBt(), BorderLayout.SOUTH);
			pnCrearPartido.add(getPnCrearContenido(), BorderLayout.CENTER);
		}
		return pnCrearPartido;
	}

	private JPanel getPnSeleccionarPartido() {
		if (pnSeleccionarPartido == null) {
			pnSeleccionarPartido = new JPanel();
			pnSeleccionarPartido.setLayout(new BorderLayout(0, 0));
			pnSeleccionarPartido.add(getPnCabeceraSeleccion(), BorderLayout.NORTH);
			pnSeleccionarPartido.add(getSpPartidos(), BorderLayout.CENTER);
			pnSeleccionarPartido.add(getPnVolverCompra(), BorderLayout.SOUTH);
		}
		return pnSeleccionarPartido;
	}

	private JButton getBtCrearPartido() {
		if (btCrearPartido == null) {
			btCrearPartido = new JButton("Crear Partido");
			btCrearPartido.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					irAPn("crear");
					cargarComboBoxEquiposCrearPartido();
				}
			});
		}
		return btCrearPartido;
	}

	private JButton getBtComprarPartido() {
		if (btComprarPartido == null) {
			btComprarPartido = new JButton("Comprar Entrada a Partido");
			btComprarPartido.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					irAPn("socio");
				}
			});
		}
		return btComprarPartido;
	}

	private void cargarComboBoxEquiposCrearPartido() {
		getCbLocal().removeAllItems();
		List<EquipoDeportivo> es = service.getEquipos();

		for (EquipoDeportivo e : es) {
			getCbLocal().addItem(e.getNombre());
		}
	}

	private void cargarComboBoxEquiposComprarPartido() {
		//getCbEquipo().removeAllItems();
		List<EquipoDeportivo> es = service.getEquipos();
		
		for (EquipoDeportivo e : es) {
			getCbEquipo().addItem(e.getNombre());
		}
	}

	private JPanel getPnCrearLabel() {
		if (pnCrearLabel == null) {
			pnCrearLabel = new JPanel();
			pnCrearLabel.add(getLbCrearPartido());
		}
		return pnCrearLabel;
	}

	private JLabel getLbCrearPartido() {
		if (lbCrearPartido == null) {
			lbCrearPartido = new JLabel("Crear Partido");
		}
		return lbCrearPartido;
	}

	private JPanel getPnCrearBt() {
		if (pnCrearBt == null) {
			pnCrearBt = new JPanel();
			pnCrearBt.add(getBtCrear());
			pnCrearBt.add(getBtVolverCrear());
		}
		return pnCrearBt;
	}

	private JButton getBtCrear() {
		if (btCrear == null) {
			btCrear = new JButton("Crear");
			btCrear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkCrear();
				}
			});
		}
		return btCrear;
	}

	private void checkCrear() {
		// TODO

		if (getTfVisitante().getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "Faltan datos");
		} else {
//			try {

			Partido partido = new Partido();

			EquipoDeportivo local = service.getEquipoPorNombre(getCbLocal().getSelectedItem().toString());
			System.out.print(local.getNombre());
			partido.setLocal(local);
//				partido.setFecha();
			partido.setVisitante(getTfVisitante().getText());

			service.insertPartido(partido);
			JOptionPane.showMessageDialog(null, "Partido creado");
			irAPn("crearComprar");
//			} catch (Exception e) {
//				JOptionPane.showMessageDialog(null,"No se pudo crear el partido");
//			}

		}

	}

	private JPanel getPnCrearContenido() {
		if (pnCrearContenido == null) {
			pnCrearContenido = new JPanel();
			pnCrearContenido.setLayout(new GridLayout(0, 2, 0, 0));
			pnCrearContenido.add(getPnLocal());
			pnCrearContenido.add(getPnVisitante());
			pnCrearContenido.add(getPnFecha());
			pnCrearContenido.add(getPnSuplemento());
		}
		return pnCrearContenido;
	}

	private JPanel getPnLocal() {
		if (pnLocal == null) {
			pnLocal = new JPanel();
			pnLocal.add(getLbLocal());
			pnLocal.add(getCbLocal());
		}
		return pnLocal;
	}

	private JPanel getPnVisitante() {
		if (pnVisitante == null) {
			pnVisitante = new JPanel();
			pnVisitante.add(getLbVisiante());
			pnVisitante.add(getTfVisitante());
		}
		return pnVisitante;
	}

	private JPanel getPnFecha() {
		if (pnFecha == null) {
			pnFecha = new JPanel();
			pnFecha.add(getLbFecha());
			pnFecha.add(getSpFecha());
		}
		return pnFecha;
	}

	private JPanel getPnSuplemento() {
		if (pnSuplemento == null) {
			pnSuplemento = new JPanel();
			pnSuplemento.add(getChckSuplemento());
			pnSuplemento.add(getSpSuplemento());
		}
		return pnSuplemento;
	}

	private JLabel getLbLocal() {
		if (lbLocal == null) {
			lbLocal = new JLabel("Local");
		}
		return lbLocal;
	}

	private JComboBox<String> getCbLocal() {
		if (cbLocal == null) {
			cbLocal = new JComboBox<String>();
		}
		return cbLocal;
	}

	private JLabel getLbVisiante() {
		if (lbVisiante == null) {
			lbVisiante = new JLabel("Visitante");
		}
		return lbVisiante;
	}

	private JTextField getTfVisitante() {
		if (tfVisitante == null) {
			tfVisitante = new JTextField();
			tfVisitante.setColumns(10);
		}
		return tfVisitante;
	}

	private JLabel getLbFecha() {
		if (lbFecha == null) {
			lbFecha = new JLabel("Fecha");
		}
		return lbFecha;
	}

	private JSpinner getSpFecha() {
		if (spFecha == null) {
			spFecha = new JSpinner();
			spFecha.setModel(new SpinnerDateModel(new Date(1699052400000L), null, null, Calendar.DAY_OF_YEAR));
		}
		return spFecha;
	}

	private JCheckBox getChckSuplemento() {
		if (chckSuplemento == null) {
			chckSuplemento = new JCheckBox("Suplemento");
			chckSuplemento.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					activarSuplemento();
				}
			});
		}
		return chckSuplemento;
	}

	private void activarSuplemento() {
		getSpSuplemento().setEnabled(!getSpSuplemento().isEnabled());

		if (!getSpSuplemento().isEnabled()) {
			getSpSuplemento().setValue(0);
		}

	}

	private JSpinner getSpSuplemento() {
		if (spSuplemento == null) {
			spSuplemento = new JSpinner();
			spSuplemento.setEnabled(false);
			spSuplemento
					.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		}
		return spSuplemento;
	}

	private JPanel getPnCabeceraSeleccion() {
		if (pnCabeceraSeleccion == null) {
			pnCabeceraSeleccion = new JPanel();
			pnCabeceraSeleccion.add(getLbPartidos());
			pnCabeceraSeleccion.add(getCbEquipo());
		}
		return pnCabeceraSeleccion;
	}

	private JPanel getPnSocioNoSocio() {
		if (pnSocioNoSocio == null) {
			pnSocioNoSocio = new JPanel();
			pnSocioNoSocio.setLayout(new GridLayout(1, 0, 0, 0));
			pnSocioNoSocio.add(getBtSocio());
			pnSocioNoSocio.add(getBtNoSocio());
		}
		return pnSocioNoSocio;
	}

	private JButton getBtSocio() {
		if (btSocio == null) {
			btSocio = new JButton("Socio");
			btSocio.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					comprobarSocio();
					
				}
			});
		}
		return btSocio;
	}

	private void comprobarSocio() {
		// TODO
		JOptionPane.showInputDialog(null, "Escribe tu id de socio");
		// comprobar si el socio existe
		if (false) {
			JOptionPane.showMessageDialog(null, "El socio no existe");
		} else {
			irAPn("seleccionar");
			cargarPaginaCompraDePartido();
			// cargar partidos que el socio no tiene comprados
		}

	}

	private JButton getBtNoSocio() {
		if (btNoSocio == null) {
			btNoSocio = new JButton("No Socio");
			btNoSocio.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					irAPn("seleccionar");
					cargarPaginaCompraDePartido();
				}

			});
		}
		return btNoSocio;
	}
	
	private void cargarPaginaCompraDePartido() {
		cargarComboBoxEquiposComprarPartido();
		crearBotonesPartidos();
	}

	private JComboBox<String> getCbEquipo() {
		if (cbEquipo == null) {
			cbEquipo = new JComboBox<String>();
			cbEquipo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					crearBotonesPartidos();
				}
			});
		}
		return cbEquipo;
	}

	private JLabel getLbPartidos() {
		if (lbPartidos == null) {
			lbPartidos = new JLabel("Partidos Equipo: ");
		}
		return lbPartidos;
	}

	private JScrollPane getSpPartidos() {
		if (spPartidos == null) {
			spPartidos = new JScrollPane();
			spPartidos.setViewportView(getPnPartidos());
		}
		return spPartidos;
	}

	private JPanel getPnPartidos() {
		if (pnPartidos == null) {
			pnPartidos = new JPanel();
			pnPartidos.setLayout(new GridLayout(0, 1, 0, 0));
		}
		return pnPartidos;
	}
	private JButton getBtVolverCrear() {
		if (btVolverCrear == null) {
			btVolverCrear = new JButton("Volver");
			btVolverCrear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					irAPn("crearComprar");
				}
			});
		}
		return btVolverCrear;
	}
	private JPanel getPnVolverCompra() {
		if (pnVolverCompra == null) {
			pnVolverCompra = new JPanel();
			pnVolverCompra.add(getBtVolverCompra());
		}
		return pnVolverCompra;
	}
	private JButton getBtVolverCompra() {
		if (btVolverCompra == null) {
			btVolverCompra = new JButton("Volver");
			btVolverCompra.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getCbEquipo().removeAllItems();
					irAPn("crearComprar");
				}
			});
		}
		return btVolverCompra;
	}
}
