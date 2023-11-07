package ips2023pl21.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import ips2023pl21.service.Service22785;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.CardLayout;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSpinner;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class Frame22785 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Service22785 service;
	private JPanel pnWork;
	private JPanel pnCabecera;
	private JLabel lbTitle;
	private JLabel lbSubtitle;
	private JPanel pnSeleccionInstalacion;
	private JPanel pnSeleccionEquipo;
	private JPanel pnListInstalacion;
	private JList<String> listInstalaciones;
	private JList<String> listEquipos;
	private DefaultListModel<String> instalacionesListModel = new DefaultListModel<>();
	private DefaultListModel<String> equiposListModel = new DefaultListModel<>();
	private JPanel pnListEquipos;
	private JPanel pnSeleccionHorarios;
	private JButton btnEquipossAtras;
	private JPanel pnHorariosAsignados;
	private JPanel pnBotonesHorarios;
	private JButton btnHorariosAtras;
	private JButton btnHorarios;
	private JPanel pnSpinners;
	private JSpinner spFecha;
	private JSpinner spHoraInicio;
	private JSpinner spHoraFin;
	private JButton btnAddHorario;
	private JTextField txInstalacionFilter;
	private JTextField txEquipoFilter;
	private JTextField txInstalacion;
	private JTextField txEquipo;
	private JList<String> listHorariosAsignados;
	private DefaultListModel<String> horariosListModel = new DefaultListModel<>();
	private JTextField txHorariosFiltro;
	private JPanel pnFiltroInstalacion;
	private JLabel lbFiltraInstalaciones;
	private JButton btnActualizaEquipos;
	private JPanel pnFiltroEquipo;
	private JLabel lbEquipoFilter;
	private JPanel pnLogin;
	private JButton btnNewButton;
	private JTextField textField;
	private JLabel lbIDEntrenador;
	private JLabel lbPasswordEntrenador;
	private JTextField textField_1;

	/**
	 * Create the frame.
	 */
	public Frame22785(Service22785 service) {
		setTitle("Gestión Entrenamientos");
		this.service = service;

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		setMinimumSize(getSize());
		contentPane = new JPanel();
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPnWork());
		contentPane.add(getPnCabecera(), BorderLayout.NORTH);

	}

	private void loadEquipos() {
		equiposListModel.removeAllElements();
		equiposListModel.addAll(service.getEquipos(getTxEquipoFilter().getText()));
	}

	private void loadInstalaciones() {
		instalacionesListModel.removeAllElements();
		instalacionesListModel.addAll(service.getInstalaciones(getTxInstalacionFilter().getText()));
	}

	private void loadHorarios() {
		horariosListModel.removeAllElements();
		horariosListModel.addAll(service.getHorarios());
	}

	private JPanel getPnWork() {
		if (pnWork == null) {
			pnWork = new JPanel();
			pnWork.setLayout(new CardLayout(0, 0));
			pnWork.add(getPnLogin(), "pnLogin");
			pnWork.add(getPnSeleccionInstalacion(), "pnSeleccionInstalacion");
			pnWork.add(getPnSeleccionEquipo(), "pnSeleccionEquipos");
			pnWork.add(getPnHorariosAsignados(), "pnHorarios");
		}
		return pnWork;
	}

	private JPanel getPnCabecera() {
		if (pnCabecera == null) {
			pnCabecera = new JPanel();
			pnCabecera.setBackground(new Color(192, 192, 192));
			pnCabecera.setLayout(new BorderLayout(0, 0));
			pnCabecera.add(getLbTitle(), BorderLayout.NORTH);
			pnCabecera.add(getLbSubtitle(), BorderLayout.CENTER);
		}
		return pnCabecera;
	}

	private JLabel getLbTitle() {
		if (lbTitle == null) {
			lbTitle = new JLabel("Gestión de Entrenamientos");
			lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
			lbTitle.setFont(new Font("Tahoma", Font.BOLD, 22));
		}
		return lbTitle;
	}

	private JLabel getLbSubtitle() {
		if (lbSubtitle == null) {
			lbSubtitle = new JLabel("Horarios de entrenamiento");
			lbSubtitle.setHorizontalAlignment(SwingConstants.CENTER);
			lbSubtitle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return lbSubtitle;
	}

	private JPanel getPnSeleccionInstalacion() {
		if (pnSeleccionInstalacion == null) {
			pnSeleccionInstalacion = new JPanel();
			pnSeleccionInstalacion.setBorder(new EmptyBorder(5, 5, 5, 5));
			pnSeleccionInstalacion.setLayout(new BorderLayout(0, 0));
			pnSeleccionInstalacion.add(getPnListInstalacion());
		}
		return pnSeleccionInstalacion;
	}

	private JPanel getPnSeleccionEquipo() {
		if (pnSeleccionEquipo == null) {
			pnSeleccionEquipo = new JPanel();
			pnSeleccionEquipo.setLayout(new GridLayout(0, 2, 0, 0));
			pnSeleccionEquipo.add(getPnListEquipos());
			pnSeleccionEquipo.add(getPnSeleccionHorarios());
		}
		return pnSeleccionEquipo;
	}

	private JPanel getPnListInstalacion() {
		if (pnListInstalacion == null) {
			pnListInstalacion = new JPanel();
			pnListInstalacion.setLayout(new BorderLayout(0, 0));
			JScrollPane scpn = new JScrollPane(getListInstalaciones());
			pnListInstalacion.add(scpn);
			pnListInstalacion.add(getPnFiltroInstalacion(), BorderLayout.NORTH);
		}
		return pnListInstalacion;
	}

	private JList<String> getListInstalaciones() {
		if (listInstalaciones == null) {
			listInstalaciones = new JList<String>(instalacionesListModel);
			listInstalaciones.setBorder(
					new TitledBorder(null, "Instalaciones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			listInstalaciones.setFont(new Font("Consolas", Font.BOLD, 16));
			listInstalaciones.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (e.getClickCount() == 2) {
						seleccionaInstalacion(listInstalaciones.locationToIndex(e.getPoint()));
					}
				}

			});
			listInstalaciones.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent evt) {
					if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
						seleccionaInstalacion(listInstalaciones.getSelectedIndex());
					}
				}
			});
			loadInstalaciones();
		}
		return listInstalaciones;
	}

	private void seleccionaInstalacion(int index) {
		service.seleccionaInstalacion(instalacionesListModel.getElementAt(index));
		getTxInstalacion().setText(service.getNombreInstalacion());
		((CardLayout) getPnWork().getLayout()).show(getPnWork(), "pnSeleccionEquipos");
		loadEquipos();
	}

	private JPanel getPnListEquipos() {
		if (pnListEquipos == null) {
			pnListEquipos = new JPanel();
			pnListEquipos.setLayout(new BorderLayout(0, 0));
			JScrollPane scpn = new JScrollPane(getListEquipos());
			pnListEquipos.add(scpn);
			pnListEquipos.add(getPnFiltroEquipo(), BorderLayout.NORTH);
		}
		return pnListEquipos;
	}

	private JPanel getPnSeleccionHorarios() {
		if (pnSeleccionHorarios == null) {
			pnSeleccionHorarios = new JPanel();
			pnSeleccionHorarios.setLayout(new BorderLayout(0, 0));
			pnSeleccionHorarios.add(getPanel_2(), BorderLayout.CENTER);
		}
		return pnSeleccionHorarios;
	}

	private JList<String> getListEquipos() {
		if (listEquipos == null) {
			listEquipos = new JList<String>(equiposListModel);
			listEquipos.setBorder(
					new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Equipos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			listEquipos.setFont(new Font("Consolas", Font.BOLD, 16));
			listEquipos.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (e.getClickCount() == 2) {
						seleccionaEquipo(listEquipos.locationToIndex(e.getPoint()));
					}
				}

			});
			listEquipos.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent evt) {
					if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
						seleccionaEquipo(listEquipos.getSelectedIndex());
					}
				}
			});
			loadEquipos();
		}
		return listEquipos;
	}

	private void seleccionaEquipo(int index) {
		service.seleccionaEquipo(equiposListModel.getElementAt(index));
		getTxEquipo().setText(service.getNombreEquipo());
	}

	private JButton getBtnEquiposAtras() {
		if (btnEquipossAtras == null) {
			btnEquipossAtras = new JButton("Atrás");
			btnEquipossAtras.setBackground(new Color(211, 211, 211));
			btnEquipossAtras.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((CardLayout) getPnWork().getLayout()).show(getPnWork(), "pnSeleccionInstalacion");
				}
			});
		}
		return btnEquipossAtras;
	}

	private JPanel getPnHorariosAsignados() {
		if (pnHorariosAsignados == null) {
			pnHorariosAsignados = new JPanel();
			pnHorariosAsignados.setBorder(new EmptyBorder(5, 5, 5, 5));
			pnHorariosAsignados.setLayout(new BorderLayout(0, 0));
			pnHorariosAsignados.add(getPnBotonesHorarios(), BorderLayout.SOUTH);
			JScrollPane scpn = new JScrollPane(getListHorariosAsignados());
			pnHorariosAsignados.add(scpn, BorderLayout.CENTER);
			scpn.setColumnHeaderView(getTxHorariosFiltro());
		}
		return pnHorariosAsignados;
	}

	private JPanel getPnBotonesHorarios() {
		if (pnBotonesHorarios == null) {
			pnBotonesHorarios = new JPanel();
			pnBotonesHorarios.add(getBtnHorariosAtras());
		}
		return pnBotonesHorarios;
	}

	private JButton getBtnHorariosAtras() {
		if (btnHorariosAtras == null) {
			btnHorariosAtras = new JButton("Atrás");
			btnHorariosAtras.setBackground(new Color(211, 211, 211));
			btnHorariosAtras.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((CardLayout) getPnWork().getLayout()).show(getPnWork(), "pnSeleccionEquipos");
				}
			});
		}
		return btnHorariosAtras;
	}

	private JButton getBtnHorarios() {
		if (btnHorarios == null) {
			btnHorarios = new JButton("Ver Horarios");
			btnHorarios.setBackground(new Color(211, 211, 211));
			btnHorarios.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((CardLayout) getPnWork().getLayout()).show(getPnWork(), "pnHorarios");
				}
			});
		}
		return btnHorarios;
	}

	private JPanel getPanel_2() {
		if (pnSpinners == null) {
			pnSpinners = new JPanel();
			pnSpinners.setBorder(new EmptyBorder(5, 5, 5, 5));

			JLabel lbInstalacion = new JLabel("Instalación:");

			JLabel lbEquipo = new JLabel("Equipo:");
			GroupLayout gl_pnSpinners = new GroupLayout(pnSpinners);
			gl_pnSpinners.setHorizontalGroup(gl_pnSpinners.createParallelGroup(Alignment.LEADING).addGroup(gl_pnSpinners
					.createSequentialGroup()
					.addGroup(gl_pnSpinners.createParallelGroup(Alignment.LEADING)
							.addGroup(Alignment.TRAILING,
									gl_pnSpinners.createSequentialGroup()
											.addComponent(getSpHoraInicio(), GroupLayout.PREFERRED_SIZE,
													GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(getSpHoraFin(),
													GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
							.addComponent(getSpFecha(), Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 213,
									Short.MAX_VALUE)
							.addGroup(Alignment.TRAILING,
									gl_pnSpinners.createSequentialGroup()
											.addGroup(gl_pnSpinners.createParallelGroup(Alignment.LEADING, false)
													.addComponent(lbEquipo, GroupLayout.DEFAULT_SIZE,
															GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
													.addComponent(lbInstalacion, GroupLayout.PREFERRED_SIZE, 70,
															GroupLayout.PREFERRED_SIZE))
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addGroup(gl_pnSpinners.createParallelGroup(Alignment.LEADING, false)
													.addComponent(getTxEquipo()).addComponent(getTxInstalacion(),
															GroupLayout.PREFERRED_SIZE, 133,
															GroupLayout.PREFERRED_SIZE)))
							.addComponent(getBtnAddHorario(), Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 213,
									Short.MAX_VALUE)
							.addComponent(getBtnActualizaEquipos(), Alignment.TRAILING, GroupLayout.DEFAULT_SIZE,
									213, Short.MAX_VALUE)
							.addGroup(Alignment.TRAILING, gl_pnSpinners.createSequentialGroup()
									.addComponent(getBtnHorarios(), GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED).addComponent(getBtnEquiposAtras())))
					.addGap(20)));
			gl_pnSpinners.setVerticalGroup(gl_pnSpinners.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_pnSpinners.createSequentialGroup().addContainerGap()
							.addGroup(gl_pnSpinners.createParallelGroup(Alignment.BASELINE).addComponent(lbInstalacion)
									.addComponent(getTxInstalacion(), GroupLayout.PREFERRED_SIZE,
											GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_pnSpinners.createParallelGroup(Alignment.BASELINE).addComponent(lbEquipo)
									.addComponent(getTxEquipo(), GroupLayout.PREFERRED_SIZE,
											GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
							.addComponent(getSpFecha(), GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_pnSpinners.createParallelGroup(Alignment.BASELINE)
									.addComponent(getSpHoraFin(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
											GroupLayout.PREFERRED_SIZE)
									.addComponent(getSpHoraInicio(), GroupLayout.PREFERRED_SIZE,
											GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(getBtnActualizaEquipos())
							.addPreferredGap(ComponentPlacement.RELATED).addComponent(getBtnAddHorario())
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_pnSpinners.createParallelGroup(Alignment.BASELINE)
									.addComponent(getBtnEquiposAtras()).addComponent(getBtnHorarios()))
							.addContainerGap()));
			pnSpinners.setLayout(gl_pnSpinners);
		}
		return pnSpinners;
	}

	private JSpinner getSpFecha() {
		if (spFecha == null) {
			spFecha = new JSpinner();
			spFecha.setModel(new SpinnerDateModel(new Date(1673478000000L), null, null, Calendar.DAY_OF_YEAR));

			Calendar calendar = Calendar.getInstance();
			Date date = calendar.getTime();
			SpinnerDateModel model = new SpinnerDateModel();
			model.setValue(date);
			spFecha.setModel(model);

			JSpinner.DateEditor editor = new JSpinner.DateEditor(spFecha, "dd-MM-yyyy");
			spFecha.setEditor(editor);

			spFecha.addChangeListener(new ChangeListener() {
				@Override
				public void stateChanged(ChangeEvent e) {
					updateFecha();
				}

			});

			updateFecha();
		}
		return spFecha;
	}

	private void updateFecha() {
		service.updateFecha((Date) getSpFecha().getValue());
		loadEquipos();
	}

	private JSpinner getSpHoraInicio() {
		if (spHoraInicio == null) {
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.HOUR_OF_DAY, 9);
			calendar.set(Calendar.MINUTE, 0);
			Date date = calendar.getTime();
			SpinnerDateModel sm = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
			spHoraInicio = new JSpinner(sm);
			spHoraInicio.setFont(new Font("Tahoma", Font.PLAIN, 14));
			JSpinner.DateEditor editor = new JSpinner.DateEditor(spHoraInicio, "HH:mm");
			spHoraInicio.setEditor(editor);

			spHoraInicio.addChangeListener(new ChangeListener() {
				@Override
				public void stateChanged(ChangeEvent e) {
					updateHoraInicio();
				}

			});

			updateHoraInicio();
		}
		return spHoraInicio;
	}

	private void updateHoraInicio() {
		service.updateHoraInicio((Date) getSpHoraInicio().getValue());
		loadEquipos();
	}

	private JSpinner getSpHoraFin() {
		if (spHoraFin == null) {
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.HOUR_OF_DAY, 17);
			calendar.set(Calendar.MINUTE, 0);
			Date date = calendar.getTime();
			SpinnerDateModel sm = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
			spHoraFin = new JSpinner(sm);
			spHoraFin.setFont(new Font("Tahoma", Font.PLAIN, 14));
			JSpinner.DateEditor editor = new JSpinner.DateEditor(spHoraFin, "HH:mm");
			spHoraFin.setEditor(editor);

			spHoraFin.addChangeListener(new ChangeListener() {
				@Override
				public void stateChanged(ChangeEvent e) {
					updateHoraFin();
				}

			});

			updateHoraFin();
		}
		return spHoraFin;
	}

	private void updateHoraFin() {
		service.updateHoraFin((Date) getSpHoraFin().getValue());
		loadEquipos();
	}

	private JButton getBtnAddHorario() {
		if (btnAddHorario == null) {
			btnAddHorario = new JButton("Añadir Horario");
			btnAddHorario.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addHorario();
				}
			});
			btnAddHorario.setBackground(new Color(211, 211, 211));
		}
		return btnAddHorario;
	}

	private void addHorario() {

		Service22785.state res = service.addHorarioEntrenamiento();

		switch (res) {
		case SUCCESS:
			getTxEquipo().setText("NONE");
			service.seleccionaEquipo("");
			break;
		case EQUIPONULL:
			JOptionPane.showMessageDialog(null, "Error: Equipo no seleccionado.", "Error",
					JOptionPane.ERROR_MESSAGE);
			break;
		case INSTALACIONNULL:
			JOptionPane.showMessageDialog(null, "Error: Instalación no especificada.", "Error",
					JOptionPane.ERROR_MESSAGE);
			break;
		case INICIOAFTERFIN:
			JOptionPane.showMessageDialog(null, "Error: La hora de fin no puede ser anterior a la de inicio.", "Error",
					JOptionPane.ERROR_MESSAGE);
			break;
		case CONCURRENCEERROR:
			JOptionPane.showMessageDialog(null, "Error: Error de concurrencia.", "Error", JOptionPane.ERROR_MESSAGE);
			break;
		default:
			break;
		}

		loadEquipos();
		loadHorarios();
	}

	private JTextField getTxInstalacionFilter() {
		if (txInstalacionFilter == null) {
			txInstalacionFilter = new JTextField();
			txInstalacionFilter.setColumns(10);
			txInstalacionFilter.getDocument().addDocumentListener(new DocumentListener() {

				public void changedUpdate(DocumentEvent e) {
					loadInstalaciones();
				}

				public void removeUpdate(DocumentEvent e) {
					loadInstalaciones();
				}

				public void insertUpdate(DocumentEvent e) {
					loadInstalaciones();
				}

			});
		}
		return txInstalacionFilter;
	}

	private JTextField getTxEquipoFilter() {
		if (txEquipoFilter == null) {
			txEquipoFilter = new JTextField();
			txEquipoFilter.setColumns(10);
			txEquipoFilter.getDocument().addDocumentListener(new DocumentListener() {

				public void changedUpdate(DocumentEvent e) {
					loadEquipos();
				}

				public void removeUpdate(DocumentEvent e) {
					loadEquipos();
				}

				public void insertUpdate(DocumentEvent e) {
					loadEquipos();
				}

			});
		}
		return txEquipoFilter;
	}

	private JTextField getTxInstalacion() {
		if (txInstalacion == null) {
			txInstalacion = new JTextField();
			txInstalacion.setText("NONE");
			txInstalacion.setEditable(false);
			txInstalacion.setColumns(10);
		}
		return txInstalacion;
	}

	private JTextField getTxEquipo() {
		if (txEquipo == null) {
			txEquipo = new JTextField();
			txEquipo.setText("NONE");
			txEquipo.setEditable(false);
			txEquipo.setColumns(10);
		}
		return txEquipo;
	}

	private JList<String> getListHorariosAsignados() {
		if (listHorariosAsignados == null) {
			listHorariosAsignados = new JList<String>(horariosListModel);
			loadHorarios();
		}
		return listHorariosAsignados;
	}

	private JTextField getTxHorariosFiltro() {
		if (txHorariosFiltro == null) {
			txHorariosFiltro = new JTextField();
			txHorariosFiltro.setColumns(10);
			txHorariosFiltro.getDocument().addDocumentListener(new DocumentListener() {

				public void changedUpdate(DocumentEvent e) {
					loadHorarios();
				}

				public void removeUpdate(DocumentEvent e) {
					loadHorarios();
				}

				public void insertUpdate(DocumentEvent e) {
					loadHorarios();
				}

			});

		}
		return txHorariosFiltro;
	}

	private JPanel getPnFiltroInstalacion() {
		if (pnFiltroInstalacion == null) {
			pnFiltroInstalacion = new JPanel();
			pnFiltroInstalacion.setLayout(new BorderLayout(0, 0));
			pnFiltroInstalacion.add(getLbFiltraInstalaciones(), BorderLayout.EAST);
			pnFiltroInstalacion.add(getTxInstalacionFilter());
		}
		return pnFiltroInstalacion;
	}

	private JLabel getLbFiltraInstalaciones() {
		if (lbFiltraInstalaciones == null) {
			lbFiltraInstalaciones = new JLabel("Filtra Instalación");
			lbFiltraInstalaciones.setBorder(new EmptyBorder(0, 5, 0, 5));
		}
		return lbFiltraInstalaciones;
	}

	private JButton getBtnActualizaEquipos() {
		if (btnActualizaEquipos == null) {
			btnActualizaEquipos = new JButton("Actualiza Equipos");
			btnActualizaEquipos.setBackground(new Color(211, 211, 211));
			btnActualizaEquipos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					loadEquipos();
				}
			});
		}
		return btnActualizaEquipos;
	}

	private JPanel getPnFiltroEquipo() {
		if (pnFiltroEquipo == null) {
			pnFiltroEquipo = new JPanel();
			pnFiltroEquipo.setLayout(new BorderLayout(0, 0));
			pnFiltroEquipo.add(getTxEquipoFilter());
			pnFiltroEquipo.add(getLbEquipoFilter(), BorderLayout.EAST);
		}
		return pnFiltroEquipo;
	}

	private JLabel getLbEquipoFilter() {
		if (lbEquipoFilter == null) {
			lbEquipoFilter = new JLabel("Filtra Equipo");
		}
		return lbEquipoFilter;
	}

	private JPanel getPnLogin() {
		if (pnLogin == null) {
			pnLogin = new JPanel();
			GroupLayout gl_pnLogin = new GroupLayout(pnLogin);
			gl_pnLogin.setHorizontalGroup(gl_pnLogin.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnLogin.createSequentialGroup().addGap(130)
							.addGroup(gl_pnLogin.createParallelGroup(Alignment.TRAILING)
									.addComponent(getLbIDEntrenador(), Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 220,
											Short.MAX_VALUE)
									.addComponent(getTextField_1(), Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 220,
											Short.MAX_VALUE)
									.addComponent(getTextField(), Alignment.LEADING, 220, 220, Short.MAX_VALUE)
									.addComponent(getBtnNewButton(), Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 220,
											Short.MAX_VALUE)
									.addComponent(getLbPasswordEntrenador(), Alignment.LEADING,
											GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
							.addGap(136)));
			gl_pnLogin.setVerticalGroup(gl_pnLogin.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnLogin.createSequentialGroup().addGap(59).addComponent(getLbIDEntrenador())
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(getTextField(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addGap(18).addComponent(getLbPasswordEntrenador())
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(getTextField_1(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addGap(31).addComponent(getBtnNewButton()).addContainerGap(61, Short.MAX_VALUE)));
			pnLogin.setLayout(gl_pnLogin);
		}
		return pnLogin;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Log In");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					login();
				}
			});
			btnNewButton.setBackground(new Color(211, 211, 211));
		}
		return btnNewButton;
	}

	private void login() {
		((CardLayout)getPnWork().getLayout()).show(getPnWork(), "pnSeleccionInstalacion");
	}

	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setColumns(10);
		}
		return textField;
	}

	private JLabel getLbIDEntrenador() {
		if (lbIDEntrenador == null) {
			lbIDEntrenador = new JLabel("ID entrenador:");
		}
		return lbIDEntrenador;
	}

	private JLabel getLbPasswordEntrenador() {
		if (lbPasswordEntrenador == null) {
			lbPasswordEntrenador = new JLabel("Contraseña:");
		}
		return lbPasswordEntrenador;
	}

	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setColumns(10);
		}
		return textField_1;
	}
}
