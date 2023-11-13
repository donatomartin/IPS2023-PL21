package ips2023pl21.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import ips2023pl21.model.entradas.EntradasModel;
import ips2023pl21.model.equipos.EquipoDeportivo;
import ips2023pl21.model.equipos.Partido;
import ips2023pl21.service.Service21917;
import ips2023pl21.service.Service22739;
import ips2023pl21.util.Util;

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
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JCheckBox;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import java.awt.Dimension;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Frame22739 extends JFrame {

	private static final long serialVersionUID = 1L;

	private Service22739 service = new Service22739();

	private ProcesaBotonPartido pBP;

	private JFrame frame;
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
	private JPanel pnAbonadoNoAbonado;
	private JButton btAbonado;
	private JButton btNoAbonado;
	private JComboBox<String> cbEquipo;
	private JLabel lbPartidos;
	private JScrollPane spPartidos;
	private JPanel pnPartidos;
	private JButton btVolverCrear;
	private JPanel pnVolverCompra;
	private JButton btVolverCompra;
	private JButton btActualizarPartidos;
	
	private boolean abonado;
	private String idAbonado;
	private List<Partido> partidos = new ArrayList<>();
	private JPanel panel_1;
	private JPanel pnCargarPartidos;
	private JPanel pnCrearCargar;


	/**
	 * Create the frame.
	 */
	public Frame22739() {
		pBP = new ProcesaBotonPartido();

		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 400);
		frame.setMinimumSize(new Dimension(700, 500));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		frame.getContentPane().add(getPnCrearComprar(), "crearComprar");
		frame.getContentPane().add(getPnCrearCargar(), "crearCargar");
		frame.getContentPane().add(getPnCrearPartido(), "crear");
		frame.getContentPane().add(getPnCargarPartidos(), "cargar");
		frame.getContentPane().add(getPnAbonadoNoAbonado(), "Abonado");
		frame.getContentPane().add(getPnSeleccionarPartido(), "seleccionar");

		frame.setVisible(true);
	}

	public class ProcesaBotonPartido implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(abonado) {
				JButton source = (JButton) e.getSource();		
				int actionCommand = Integer.parseInt(source.getActionCommand());
				//crearBotonesPartidos();
				JOptionPane.showMessageDialog(null, "Entrada comprada");
				service.insertPartidoAbonado(idAbonado,partidos.get(actionCommand));
				crearBotonesPartidos();
			} else {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							new Service21917( new EntradasModel(),new Frame21917());
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				irAPn("crearComprar");
			}
		}
	}
	
	private void crearBotonesPartidos() {
		partidos.clear();
		getPnPartidos().removeAll();
		getPnPartidos().updateUI();
		
		EquipoDeportivo equipo = service.getEquipoPorNombre(getCbEquipo().getSelectedItem().toString());
		
		String id = equipo.getId();
		List<Partido> partidos;
		if(!abonado) {
			partidos = service.getPartidosPorEquipo(id);
		} else {
			partidos = service.getPartidosNoSeleccionadosPorAbonadoYEquipo(idAbonado,id);
		}
		
		if (partidos.size() > 0) {
			for (int i = 0; i < partidos.size(); i++) {
				getPnPartidos().add(nuevoBotonPartido(i, partidos.get(i)));
			}
		} else {
			JOptionPane.showMessageDialog(null, "no hay partidos para el equipo seleccionado");
		}

	}

	private Component nuevoBotonPartido(Integer posicion, Partido partido) {
		partidos.add(partido);
		String textBt = partido.toString();

		JButton boton = new JButton("");
		boton.addActionListener(pBP);

		boton.setBackground(Color.white);
		boton.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
		boton.setActionCommand(posicion.toString());

		boton.setVerticalAlignment(SwingConstants.CENTER);

		boton.setText(textBt);
		return boton;
	}

	private void irAPn(String panel) {
		((CardLayout) frame.getContentPane().getLayout()).show(frame.getContentPane(), panel);
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
					irAPn("crearCargar");
				}
			});
		}
		return btCrearPartido;
	}
	
	private void irACrearPartido() {
		irAPn("crear");
		cargarComboBoxEquiposCrearPartido();
		getSpSuplemento().setValue(0);
		getSpSuplemento().setEnabled(false);
		getChckSuplemento().setSelected(false);
		
		getTfVisitante().setText("");
	}

	private JButton getBtComprarPartido() {
		if (btComprarPartido == null) {
			btComprarPartido = new JButton("Comprar Entrada a Partido");
			btComprarPartido.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					irAPn("Abonado");
					cargarComboBoxEquiposComprarPartido();
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
		getCbEquipo().removeAllItems();
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
		if (getTfVisitante().getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "Faltan datos");
		} else {
			try {

				Partido partido = new Partido();
				
				EquipoDeportivo local = service.getEquipoPorNombre(getCbLocal().getSelectedItem().toString());
				partido.setLocal(local);
				
				String fecha = Util.dateToIsoString((Date)getSpFecha().getValue());
				partido.setFecha(fecha);
				
				partido.setVisitante(getTfVisitante().getText());
				partido.setSuplemento(Float.parseFloat(getSpSuplemento().getValue().toString()));
				
				String id = getCbLocal().getSelectedItem().toString() + "-" + getTfVisitante().getText() + "-" + fecha;
				partido.setId(id);

				service.insertPartido(partido);
				JOptionPane.showMessageDialog(null, "Partido creado");
				irAPn("crearComprar");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "No se pudo crear el partido");
			}

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
			FlowLayout flowLayout = (FlowLayout) pnLocal.getLayout();
			flowLayout.setHgap(15);
			flowLayout.setVgap(100);
			pnLocal.add(getLbLocal());
			pnLocal.add(getCbLocal());
		}
		return pnLocal;
	}

	private JPanel getPnVisitante() {
		if (pnVisitante == null) {
			pnVisitante = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnVisitante.getLayout();
			flowLayout.setVgap(100);
			pnVisitante.add(getLbVisiante());
			pnVisitante.add(getTfVisitante());
		}
		return pnVisitante;
	}

	private JPanel getPnFecha() {
		if (pnFecha == null) {
			pnFecha = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnFecha.getLayout();
			flowLayout.setVgap(20);
			flowLayout.setHgap(10);
			pnFecha.add(getLbFecha());
			pnFecha.add(getSpFecha());
		}
		return pnFecha;
	}

	private JPanel getPnSuplemento() {
		if (pnSuplemento == null) {
			pnSuplemento = new JPanel();
			pnSuplemento.setBorder(new EmptyBorder(20, 40, 40, 40));
			GroupLayout gl_pnSuplemento = new GroupLayout(pnSuplemento);
			gl_pnSuplemento.setHorizontalGroup(
				gl_pnSuplemento.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnSuplemento.createSequentialGroup()
						.addComponent(getPanel_1(), GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(20, Short.MAX_VALUE))
			);
			gl_pnSuplemento.setVerticalGroup(
				gl_pnSuplemento.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnSuplemento.createSequentialGroup()
						.addComponent(getPanel_1(), GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(86, Short.MAX_VALUE))
			);
			pnSuplemento.setLayout(gl_pnSuplemento);
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

			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DAY_OF_YEAR, 7);
			Date date = calendar.getTime();
			SpinnerDateModel model = new SpinnerDateModel();
			model.setValue(date);
			spFecha.setModel(model);
			JSpinner.DateEditor editor = new JSpinner.DateEditor(spFecha, "dd-MM-yyyy");
			spFecha.setEditor(editor);
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
					.setModel(new SpinnerNumberModel(Float.valueOf(0), Float.valueOf(0), null, Float.valueOf(1)));
			spSuplemento.setPreferredSize(new Dimension(0,100));
		}
		return spSuplemento;
	}

	private JPanel getPnCabeceraSeleccion() {
		if (pnCabeceraSeleccion == null) {
			pnCabeceraSeleccion = new JPanel();
			pnCabeceraSeleccion.add(getLbPartidos());
			pnCabeceraSeleccion.add(getCbEquipo());
			pnCabeceraSeleccion.add(getBtActualizarPartidos());
		}
		return pnCabeceraSeleccion;
	}

	private JPanel getPnAbonadoNoAbonado() {
		if (pnAbonadoNoAbonado == null) {
			pnAbonadoNoAbonado = new JPanel();
			pnAbonadoNoAbonado.setLayout(new GridLayout(1, 0, 0, 0));
			pnAbonadoNoAbonado.add(getBtAbonado());
			pnAbonadoNoAbonado.add(getBtNoAbonado());
		}
		return pnAbonadoNoAbonado;
	}

	private JButton getBtAbonado() {
		if (btAbonado == null) {
			btAbonado = new JButton("Abonado");
			btAbonado.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					comprobarAbonado();

				}
			});
		}
		return btAbonado;
	}

	private void comprobarAbonado() {
		String id = JOptionPane.showInputDialog(null, "Escribe tu id de Abonado");
		
		if (!service.existsIdAbonado(id)) {
			JOptionPane.showMessageDialog(null, "El Abonado no existe");
		} else {
			abonado = true;
			idAbonado = id;
			irAPn("seleccionar");
			crearBotonesPartidos();
		}

	}

	private JButton getBtNoAbonado() {
		if (btNoAbonado == null) {
			btNoAbonado = new JButton("No Abonado");
			btNoAbonado.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					noAbonado();
				}

			});
		}
		return btNoAbonado;
	}
	
	private void noAbonado() {
		irAPn("seleccionar");
		abonado = false;
		crearBotonesPartidos();
	}
	
	private JComboBox<String> getCbEquipo() {
		if (cbEquipo == null) {
			cbEquipo = new JComboBox<String>();
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
					irAPn("crearComprar");
					abonado = false;
				}
			});
		}
		return btVolverCompra;
	}
	private JButton getBtActualizarPartidos() {
		if (btActualizarPartidos == null) {
			btActualizarPartidos = new JButton("Actualizar");
			btActualizarPartidos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					crearBotonesPartidos();
				}
			});
		}
		return btActualizarPartidos;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setPreferredSize(new Dimension(0,15));
			GroupLayout gl_panel_1 = new GroupLayout(panel_1);
			gl_panel_1.setHorizontalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_1.createSequentialGroup()
						.addContainerGap()
						.addComponent(getChckSuplemento(), GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(getSpSuplemento(), GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
						.addGap(24))
			);
			gl_panel_1.setVerticalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_1.createSequentialGroup()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(getChckSuplemento(), GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
							.addComponent(getSpSuplemento(), GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
						.addContainerGap())
			);
			panel_1.setLayout(gl_panel_1);
		}
		return panel_1;
	}
	private JPanel getPnCargarPartidos() {
		if (pnCargarPartidos == null) {
			pnCargarPartidos = new JPanel();
		}
		return pnCargarPartidos;
	}
	private JPanel getPnCrearCargar() {
		if (pnCrearCargar == null) {
			pnCrearCargar = new JPanel();
		}
		return pnCrearCargar;
	}
}
