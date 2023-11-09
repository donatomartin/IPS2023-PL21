package ips2023pl21.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import ips2023pl21.service.Service21915;
import ips2023pl21.service.State;

import java.awt.BorderLayout;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JCheckBox;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class Frame21915 extends JFrame {

	private Service21915 service;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pnAsignacionFranja;
	private JPanel pnSeleccionJugador;
	private JPanel pnFiltro;
	private JTextField txFilterEmpleado;
	private JPanel pnList;
	private JList<String> empleadoList;
	private DefaultListModel<String> empleadoListModel = new DefaultListModel<String>();
	private JPanel pnCabecera;
	private JLabel lbTitulo;
	private JLabel lblNewLabel;
	private JPanel pnBotonesAsignacionFranja;
	private JTextField txEmpleadoSeleccionado;
	private JPanel pnCuerpo;
	private JPanel pnSeleccionFecha;
	private JLabel lbSeleccionFecha;
	private JSpinner spFecha;
	private JPanel pnFecha;
	private JLabel lbHoraFin;
	private JSpinner spHoraFin;
	private JSpinner spHoraInicio;
	private JLabel lbHoraInicio;
	private JPanel pnInicio;
	private JPanel pnFin;
	private JCheckBox chckbxNewCheckBox;
	private JButton addEntrevista;
	private JTextField txMedio;
	private JLabel lbDatosMedio;
	private JButton btnVerEntrevistas;
	private JPanel pnEntrevistas;
	private JList<String> listEntrevistas;
	private DefaultListModel<String> entrevistasListModel = new DefaultListModel<String>();
	private JButton btnAtrasEntrevistas;
	private JLabel lbSubtitulo;
	private JPanel pnSeleccionFranja;
	private JPanel pnBotonesAsignacionFranja1;
	private JButton btnAtrasSeleccion;
	private JPanel pnWork;
	private JButton btnSeleccionaHorario;
	private JPanel pnBotonesSeleccionFranja;
	private JPanel pnListHeader;
	private JPanel pnJugadorSeleccionado;
	private JPanel pnBotonesEntrevistas;
	private JPanel pnBotonAtrasEntrevista;
	private JPanel pnFechaFecha;
	private JPanel pnFechaFranja;
	private JPanel panel_2;
	private JButton btnActualizar;
	private JLabel lbFilterEmpleado;

	public Frame21915(Service21915 service) {
		setTitle("Gestion Entrevistas");
		this.service = service;

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		setMinimumSize(getSize());
		contentPane = new JPanel();

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		contentPane.add(pnCabecera(), BorderLayout.NORTH);
		contentPane.add(getPnWork());

		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		String horaInicio = format.format(getSpHoraInicio().getValue());
		String horaFin = format.format(getSpHoraFin().getValue());
		format = new SimpleDateFormat("dd-MM-yyyy");

		service.setFecha((Date) getSpFecha().getValue());
		service.setHoraInicio(horaInicio);
		service.setHoraFin(horaFin);

		filter();
		loadEntrevistas();

	}

	private void loadEntrevistas() {
		entrevistasListModel.removeAllElements();
		entrevistasListModel.addAll(service.getEntrevistas());
	}

	private JPanel getPnWork() {
		if (pnWork == null) {
			pnWork = new JPanel();
			pnWork.setLayout(new CardLayout(0, 0));
			pnWork.add(getPnSeleccionFranja(), "pnSeleccionFranja");
			pnWork.add(getPnAsignacionFranja(), "pnAsignacionFranja");
			pnWork.add(getPnEntrevistas(), "pnEntrevistas");
		}
		return pnWork;
	}

	private JPanel getPnAsignacionFranja() {
		if (pnAsignacionFranja == null) {
			pnAsignacionFranja = new JPanel();
			pnAsignacionFranja.setLayout(new BorderLayout(0, 0));
			pnAsignacionFranja.add(getPnBotonesAsignacionFranja(), BorderLayout.SOUTH);
			pnAsignacionFranja.add(getPnCuerpo(), BorderLayout.CENTER);
		}
		return pnAsignacionFranja;
	}

	private JPanel getPnSeleccionJugador() {
		if (pnSeleccionJugador == null) {
			pnSeleccionJugador = new JPanel();
			pnSeleccionJugador.setBorder(new EmptyBorder(5, 5, 5, 5));
			pnSeleccionJugador.setLayout(new BorderLayout(5, 5));
			pnSeleccionJugador.add(getPnFiltro(), BorderLayout.NORTH);
			pnSeleccionJugador.add(getPnList(), BorderLayout.CENTER);
		}
		return pnSeleccionJugador;
	}

	private JPanel getPnFiltro() {
		if (pnFiltro == null) {
			pnFiltro = new JPanel();
			pnFiltro.setLayout(new BoxLayout(pnFiltro, BoxLayout.Y_AXIS));
			pnFiltro.add(getLbFilterEmpleado());
			pnFiltro.add(getTxFilterEmpleado());
		}
		return pnFiltro;
	}

	private JTextField getTxFilterEmpleado() {
		if (txFilterEmpleado == null) {
			txFilterEmpleado = new JTextField();
			txFilterEmpleado.setColumns(10);
			txFilterEmpleado.getDocument().addDocumentListener(new DocumentListener() {

				public void changedUpdate(DocumentEvent e) {
					filter();
				}

				public void removeUpdate(DocumentEvent e) {
					filter();
				}

				public void insertUpdate(DocumentEvent e) {
					filter();
				}

			});
		}
		return txFilterEmpleado;
	}

	public void filter() {
		loadJugadorListModel(getTxFilterEmpleado().getText());
	}

	private JPanel getPnList() {
		if (pnList == null) {
			pnList = new JPanel();
			pnList.setLayout(new BorderLayout(0, 0));
			JScrollPane listScrollPane = new JScrollPane(getListEmpleados());
			pnList.add(listScrollPane);
			listScrollPane.setColumnHeaderView(getPnListHeader());
		}
		return pnList;
	}

	private JList<String> getListEmpleados() {
		if (empleadoList == null) {
			empleadoList = new JList<String>(empleadoListModel);
			empleadoList.setToolTipText("dobleClick o Enter para seleccionar");
			empleadoList.setBorder(new EmptyBorder(5, 5, 5, 5));
			empleadoList.setFont(new Font("Consolas", Font.BOLD, 15));

			// Añadir MouseListener para el doble click
			empleadoList.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					if (evt.getClickCount() == 2) {
						int index = empleadoList.locationToIndex(evt.getPoint());
						seleccionarEmpleado(index);

					}
				}
			});

			// Añadir KeyListener para el Enter
			empleadoList.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent evt) {
					if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
						// Enter detectado
						int index = empleadoList.getSelectedIndex();
						seleccionarEmpleado(index);
					}
				}
			});

		}
		return empleadoList;
	}

	private void seleccionarEmpleado(int index) {
		service.seleccionaEmpleado(empleadoListModel.getElementAt(index));
		getTxEmpleadoSeleccionado().setText(service.getNombreJugadorSeleccionado());
	}

	private void loadJugadorListModel(String filter) {
		empleadoListModel.removeAllElements();
		empleadoListModel.addAll(service.getJugadoresLibresString(filter));
	}

	private JPanel pnCabecera() {
		if (pnCabecera == null) {
			pnCabecera = new JPanel();
			pnCabecera.setBackground(new Color(192, 192, 192));
			pnCabecera.setLayout(new BorderLayout(0, 0));
			pnCabecera.add(getLbTitulo(), BorderLayout.NORTH);
			pnCabecera.add(getLbSubtitulo());
		}
		return pnCabecera;
	}

	private JLabel getLbTitulo() {
		if (lbTitulo == null) {
			lbTitulo = new JLabel("Gestión de Entrevistas");
			lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lbTitulo.setFont(new Font("Tahoma", Font.BOLD, 22));
		}
		return lbTitulo;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Seleccionado:");
			lblNewLabel.setBorder(new EmptyBorder(0, 0, 1, 0));
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel;
	}

	private JPanel getPnBotonesAsignacionFranja() {
		if (pnBotonesAsignacionFranja == null) {
			pnBotonesAsignacionFranja = new JPanel();
			pnBotonesAsignacionFranja.setBorder(new EmptyBorder(5, 5, 5, 5));
			pnBotonesAsignacionFranja.setBackground(new Color(211, 211, 211));
			pnBotonesAsignacionFranja.setLayout(new BorderLayout(5, 0));
			pnBotonesAsignacionFranja.add(getPnBotonesAsignacionFranja1(), BorderLayout.EAST);
		}
		return pnBotonesAsignacionFranja;
	}

	private JTextField getTxEmpleadoSeleccionado() {
		if (txEmpleadoSeleccionado == null) {
			txEmpleadoSeleccionado = new JTextField();
			txEmpleadoSeleccionado.setBorder(null);
			txEmpleadoSeleccionado.setFont(new Font("Tahoma", Font.BOLD, 15));
			txEmpleadoSeleccionado.setText("NONE");
			txEmpleadoSeleccionado.setEditable(false);
			txEmpleadoSeleccionado.setColumns(10);
		}
		return txEmpleadoSeleccionado;
	}

	private JPanel getPnCuerpo() {
		if (pnCuerpo == null) {
			pnCuerpo = new JPanel();
			pnCuerpo.setLayout(new BoxLayout(pnCuerpo, BoxLayout.Y_AXIS));
			pnCuerpo.add(getPnSeleccionFecha());
		}
		return pnCuerpo;
	}

	private JPanel getPnSeleccionFecha() {
		if (pnSeleccionFecha == null) {
			pnSeleccionFecha = new JPanel();
			pnSeleccionFecha.setLayout(new GridLayout(0, 1, 0, 0));
			pnSeleccionFecha.add(getPnSeleccionJugador());
		}
		return pnSeleccionFecha;
	}

	private JLabel getLbSeleccionFecha() {
		if (lbSeleccionFecha == null) {
			lbSeleccionFecha = new JLabel("Fecha");
		}
		return lbSeleccionFecha;
	}

	private JSpinner getSpFecha() {
		if (spFecha == null) {
			Calendar calendar = Calendar.getInstance();
			Date date = calendar.getTime();
			SpinnerDateModel sm = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
			spFecha = new JSpinner(sm);
			spFecha.setFont(new Font("Tahoma", Font.PLAIN, 16));
			JSpinner.DateEditor de = new JSpinner.DateEditor(spFecha, "dd-MM-yyyy");
			spFecha.setEditor(de);

			// Agregar ChangeListener al JSpinner
			spFecha.addChangeListener(new ChangeListener() {
				@Override
				public void stateChanged(ChangeEvent e) {
					updateFecha(e);
				}

			});
		}
		return spFecha;
	}

	private void updateFecha(ChangeEvent e) {
		JSpinner spinner = (JSpinner) e.getSource();
		service.setFecha((Date) spinner.getValue());
		filter();
	}

	private JPanel getPnFecha() {
		if (pnFecha == null) {
			pnFecha = new JPanel();
			GroupLayout gl_pnFecha = new GroupLayout(pnFecha);
			gl_pnFecha
					.setHorizontalGroup(gl_pnFecha.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
							gl_pnFecha
									.createSequentialGroup().addGap(154).addComponent(getPnFechaFranja(),
											GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(171)));
			gl_pnFecha.setVerticalGroup(gl_pnFecha.createParallelGroup(Alignment.LEADING).addGroup(gl_pnFecha
					.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
					.addComponent(getPnFechaFranja(), GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
					.addGap(66)));
			pnFecha.setLayout(gl_pnFecha);
		}
		return pnFecha;
	}

	private JLabel getLbHoraFin() {
		if (lbHoraFin == null) {
			lbHoraFin = new JLabel("Hora Fin");
			lbHoraFin.setHorizontalAlignment(SwingConstants.TRAILING);
		}
		return lbHoraFin;
	}

	private JSpinner getSpHoraFin() {
		if (spHoraFin == null) {
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.HOUR_OF_DAY, 10);
			calendar.set(Calendar.MINUTE, 0);
			Date date = calendar.getTime();
			SpinnerDateModel sm = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
			spHoraFin = new JSpinner(sm);
			spHoraFin.setFont(new Font("Tahoma", Font.PLAIN, 16));
			JSpinner.DateEditor de = new JSpinner.DateEditor(spHoraFin, "HH:mm");
			spHoraFin.setEditor(de);

			// Agregar ChangeListener al JSpinner
			spHoraFin.addChangeListener(new ChangeListener() {
				@Override
				public void stateChanged(ChangeEvent e) {
					updateHoraFin(e);
				}

			});

		}
		return spHoraFin;
	}

	private void updateHoraFin(ChangeEvent e) {
		JSpinner spinner = (JSpinner) e.getSource();
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		String horaFin = format.format(spinner.getValue());
		service.setHoraFin(horaFin);
		filter();
	}

	private JSpinner getSpHoraInicio() {
		if (spHoraInicio == null) {
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.HOUR_OF_DAY, 9);
			calendar.set(Calendar.MINUTE, 0);
			Date date = calendar.getTime();
			SpinnerDateModel sm = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
			spHoraInicio = new JSpinner(sm);
			spHoraInicio.setFont(new Font("Tahoma", Font.PLAIN, 16));
			JSpinner.DateEditor de = new JSpinner.DateEditor(spHoraInicio, "HH:mm");
			spHoraInicio.setEditor(de);

			// Agregar ChangeListener al JSpinner
			spHoraInicio.addChangeListener(new ChangeListener() {
				@Override
				public void stateChanged(ChangeEvent e) {
					updateHoraInicio(e);
				}
			});

		}
		return spHoraInicio;
	}

	private void updateHoraInicio(ChangeEvent e) {
		JSpinner spinner = (JSpinner) e.getSource();
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		String horaInicio = format.format(spinner.getValue());
		service.setHoraInicio(horaInicio);
		filter();
	}

	private JLabel getLbHoraInicio() {
		if (lbHoraInicio == null) {
			lbHoraInicio = new JLabel("Hora Inicio");
			lbHoraInicio.setHorizontalAlignment(SwingConstants.TRAILING);
		}
		return lbHoraInicio;
	}

	private JPanel getPnInicio() {
		if (pnInicio == null) {
			pnInicio = new JPanel();
			pnInicio.setBorder(new EmptyBorder(5, 5, 5, 5));
			pnInicio.setLayout(new GridLayout(0, 2, 5, 0));
			pnInicio.add(getLbHoraInicio());
			pnInicio.add(getSpHoraInicio());
		}
		return pnInicio;
	}

	private JPanel getPanel_1_1() {
		if (pnFin == null) {
			pnFin = new JPanel();
			pnFin.setBorder(new EmptyBorder(5, 5, 5, 5));
			pnFin.setLayout(new GridLayout(0, 2, 5, 0));
			pnFin.add(getLbHoraFin());
			pnFin.add(getSpHoraFin());
		}
		return pnFin;
	}

	private JCheckBox getChckbxNewCheckBox() {
		if (chckbxNewCheckBox == null) {
			chckbxNewCheckBox = new JCheckBox("Día Completo");
			chckbxNewCheckBox.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if (e.getStateChange() == ItemEvent.SELECTED) {
						disableFranjas();
					} else {
						enableFranjas();
					}
				}
			});
		}
		return chckbxNewCheckBox;
	}

	private void disableFranjas() {
		getSpHoraInicio().setEnabled(false);
		getSpHoraFin().setEnabled(false);
		service.setHoraInicio("00:00");
		service.setHoraFin("23:59");
		loadJugadorListModel(getTxFilterEmpleado().getText());

	}

	private void enableFranjas() {
		getSpHoraInicio().setEnabled(true);
		getSpHoraFin().setEnabled(true);
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		String horaInicio = format.format(getSpHoraInicio().getValue());
		String horaFin = format.format(getSpHoraFin().getValue());
		service.setHoraInicio(horaInicio);
		service.setHoraFin(horaFin);
		loadJugadorListModel(getTxFilterEmpleado().getText());
	}

	private JButton getAddEntrevista() {
		if (addEntrevista == null) {
			addEntrevista = new JButton("Añadir");
			addEntrevista.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addEntrevista();
				}
			});
			addEntrevista.setBackground(new Color(211, 211, 211));
		}
		return addEntrevista;
	}

	private void addEntrevista() {
		State res = service.addEntrevista(getTxMedio().getText());

		switch (res) {
		case EMPLEADONULL:
			JOptionPane.showMessageDialog(null, "Error: Jugador no seleccionado.", "Error", JOptionPane.ERROR_MESSAGE);
			break;
		case MEDIONULL:
			JOptionPane.showMessageDialog(null, "Error: Medio no especificado.", "Error", JOptionPane.ERROR_MESSAGE);
			break;
		case INTERFIEREENTRENAMIENTO:
			JOptionPane.showMessageDialog(null, "Error: Hay un entrenamiento programado para este intervalo.", "Error",
					JOptionPane.ERROR_MESSAGE);
			break;
		case DBERROR:
			JOptionPane.showMessageDialog(null, "Error: Error de concurrencia.", "Error", JOptionPane.ERROR_MESSAGE);
			filter();
			break;
		case SUCCESS:
			getTxEmpleadoSeleccionado().setText("NONE");
			getTxMedio().setText("");
			break;
		default:
			break;
		}

		loadJugadorListModel(getTxFilterEmpleado().getText());
		loadEntrevistasModel();
	}

	private void loadEntrevistasModel() {

		entrevistasListModel.removeAllElements();
		entrevistasListModel.addAll(service.getEntrevistas());

	}

	private JTextField getTxMedio() {
		if (txMedio == null) {
			txMedio = new JTextField();
			txMedio.setColumns(10);
		}
		return txMedio;
	}

	private JLabel getLbDatosMedio() {
		if (lbDatosMedio == null) {
			lbDatosMedio = new JLabel("Datos Medio:");
		}
		return lbDatosMedio;
	}

	private JButton getBtnVerEntrevistas() {
		if (btnVerEntrevistas == null) {
			btnVerEntrevistas = new JButton("Ver entrevistas");
			btnVerEntrevistas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((CardLayout) getPnWork().getLayout()).show(getPnWork(), "pnEntrevistas");
				}
			});
			btnVerEntrevistas.setBackground(new Color(211, 211, 211));
		}
		return btnVerEntrevistas;
	}

	private JPanel getPnEntrevistas() {
		if (pnEntrevistas == null) {
			pnEntrevistas = new JPanel();
			pnEntrevistas.setLayout(new BorderLayout(0, 0));
			JScrollPane scpn = new JScrollPane(getListEntrevistas());
			pnEntrevistas.add(scpn, BorderLayout.CENTER);
			pnEntrevistas.add(getPnBotonesEntrevistas(), BorderLayout.SOUTH);
		}
		return pnEntrevistas;
	}

	private JList<String> getListEntrevistas() {
		if (listEntrevistas == null) {
			listEntrevistas = new JList<String>(entrevistasListModel);
			listEntrevistas.setFont(new Font("Consolas", Font.BOLD, 15));
		}
		return listEntrevistas;
	}

	private JButton getBtnAtrasEntrevistas() {
		if (btnAtrasEntrevistas == null) {
			btnAtrasEntrevistas = new JButton("Atrás");
			btnAtrasEntrevistas.setBackground(new Color(211, 211, 211));
			btnAtrasEntrevistas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((CardLayout) getPnWork().getLayout()).show(getPnWork(), "pnAsignacionFranja");
				}
			});
		}
		return btnAtrasEntrevistas;
	}

	private JLabel getLbSubtitulo() {
		if (lbSubtitulo == null) {
			lbSubtitulo = new JLabel("Jugadores Profesionales");
			lbSubtitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lbSubtitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return lbSubtitulo;
	}

	private JPanel getPnSeleccionFranja() {
		if (pnSeleccionFranja == null) {
			pnSeleccionFranja = new JPanel();
			pnSeleccionFranja.setLayout(new BorderLayout(0, 0));
			pnSeleccionFranja.add(getPnFecha());
			pnSeleccionFranja.add(getPanel_1(), BorderLayout.SOUTH);
		}
		return pnSeleccionFranja;
	}

	private JPanel getPnBotonesAsignacionFranja1() {
		if (pnBotonesAsignacionFranja1 == null) {
			pnBotonesAsignacionFranja1 = new JPanel();
			pnBotonesAsignacionFranja1.setBackground(new Color(211, 211, 211));
			pnBotonesAsignacionFranja1.add(getLbDatosMedio());
			pnBotonesAsignacionFranja1.add(getTxMedio());
			pnBotonesAsignacionFranja1.add(getAddEntrevista());
			pnBotonesAsignacionFranja1.add(getBtnAtrasSeleccion());
			pnBotonesAsignacionFranja1.add(getBtnVerEntrevistas());

		}
		return pnBotonesAsignacionFranja1;
	}

	private JButton getBtnAtrasSeleccion() {
		if (btnAtrasSeleccion == null) {
			btnAtrasSeleccion = new JButton("Atrás");
			btnAtrasSeleccion.setBackground(new Color(211, 211, 211));
			btnAtrasSeleccion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((CardLayout) getPnWork().getLayout()).show(getPnWork(), "pnSeleccionFranja");
				}
			});
		}
		return btnAtrasSeleccion;
	}

	private JButton getBtnSeleccionaHorario() {
		if (btnSeleccionaHorario == null) {
			btnSeleccionaHorario = new JButton("Siguiente");
			btnSeleccionaHorario.setBackground(new Color(211, 211, 211));
			btnSeleccionaHorario.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((CardLayout) getPnWork().getLayout()).show(getPnWork(), "pnAsignacionFranja");
				}
			});
		}
		return btnSeleccionaHorario;
	}

	private JPanel getPanel_1() {
		if (pnBotonesSeleccionFranja == null) {
			pnBotonesSeleccionFranja = new JPanel();
			pnBotonesSeleccionFranja.setBackground(new Color(211, 211, 211));
			pnBotonesSeleccionFranja.setBorder(new EmptyBorder(5, 5, 5, 5));
			pnBotonesSeleccionFranja.setLayout(new BorderLayout(0, 0));
			pnBotonesSeleccionFranja.add(getPanel_2(), BorderLayout.EAST);
		}
		return pnBotonesSeleccionFranja;
	}

	private JPanel getPnListHeader() {
		if (pnListHeader == null) {
			pnListHeader = new JPanel();
			pnListHeader.setLayout(new BorderLayout(0, 0));
			pnListHeader.add(getPanel_1_2(), BorderLayout.WEST);
		}
		return pnListHeader;
	}

	private JPanel getPanel_1_2() {
		if (pnJugadorSeleccionado == null) {
			pnJugadorSeleccionado = new JPanel();
			pnJugadorSeleccionado.add(getLblNewLabel());
			pnJugadorSeleccionado.add(getTxEmpleadoSeleccionado());
		}
		return pnJugadorSeleccionado;
	}

	private JPanel getPnBotonesEntrevistas() {
		if (pnBotonesEntrevistas == null) {
			pnBotonesEntrevistas = new JPanel();
			pnBotonesEntrevistas.setBorder(new EmptyBorder(5, 5, 5, 5));
			pnBotonesEntrevistas.setBackground(new Color(211, 211, 211));
			pnBotonesEntrevistas.setLayout(new BorderLayout(0, 0));
			pnBotonesEntrevistas.add(getPanel_1_3(), BorderLayout.EAST);
		}
		return pnBotonesEntrevistas;
	}

	private JPanel getPanel_1_3() {
		if (pnBotonAtrasEntrevista == null) {
			pnBotonAtrasEntrevista = new JPanel();
			pnBotonAtrasEntrevista.setBackground(new Color(211, 211, 211));
			pnBotonAtrasEntrevista.add(getBtnActualizar());
			pnBotonAtrasEntrevista.add(getBtnAtrasEntrevistas());
		}
		return pnBotonAtrasEntrevista;
	}

	private JPanel getPanel_1_4() {
		if (pnFechaFecha == null) {
			pnFechaFecha = new JPanel();
			pnFechaFecha.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			pnFechaFecha.add(getLbSeleccionFecha());
			pnFechaFecha.add(getSpFecha());
		}
		return pnFechaFecha;
	}

	private JPanel getPnFechaFranja() {
		if (pnFechaFranja == null) {
			pnFechaFranja = new JPanel();
			pnFechaFranja.setLayout(new BoxLayout(pnFechaFranja, BoxLayout.Y_AXIS));
			pnFechaFranja.add(getPanel_1_4());
			pnFechaFranja.add(getChckbxNewCheckBox());
			pnFechaFranja.add(getPnInicio());
			pnFechaFranja.add(getPanel_1_1());
		}
		return pnFechaFranja;
	}

	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setBackground(new Color(211, 211, 211));
			panel_2.add(getBtnSeleccionaHorario());
		}
		return panel_2;
	}

	private JButton getBtnActualizar() {
		if (btnActualizar == null) {
			btnActualizar = new JButton("Actualizar");
			btnActualizar.setBackground(new Color(211, 211, 211));
			btnActualizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					loadEntrevistas();
				}
			});
		}
		return btnActualizar;
	}

	private JLabel getLbFilterEmpleado() {
		if (lbFilterEmpleado == null) {
			lbFilterEmpleado = new JLabel("Filtra Jugador");
		}
		return lbFilterEmpleado;
	}
}
