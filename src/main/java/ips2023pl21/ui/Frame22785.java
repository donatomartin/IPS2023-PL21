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
import ips2023pl21.service.State;

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
import javax.swing.BoxLayout;

public class Frame22785 extends JFrame implements UserInterface {

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
	private JPanel pnFiltroInstalacion;
	private JLabel lbFiltraInstalaciones;
	private JButton btnActualizaEquipos;
	private JPanel pnFiltroEquipo;
	private JLabel lbEquipoFilter;
	private JPanel pnLogin;
	private JButton btnLogin;
	private JTextField txId;
	private JLabel lbIDEntrenador;
	private JLabel lbPasswordEntrenador;
	private JTextField txPassword;
	private JButton btnLogout;
	private JPanel panel;
	private JLabel lbSeleccionados;

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
			pnSeleccionInstalacion.setLayout(new BorderLayout(5, 5));
			pnSeleccionInstalacion.add(getPnListInstalacion());
			pnSeleccionInstalacion.add(getBtnLogout(), BorderLayout.SOUTH);
		}
		return pnSeleccionInstalacion;
	}

	private JPanel getPnSeleccionEquipo() {
		if (pnSeleccionEquipo == null) {
			pnSeleccionEquipo = new JPanel();
			pnSeleccionEquipo.setBorder(new EmptyBorder(5, 5, 5, 5));
			pnSeleccionEquipo.setLayout(new GridLayout(0, 2, 0, 0));
			pnSeleccionEquipo.add(getPnListEquipos());
			pnSeleccionEquipo.add(getPnSeleccionHorarios());
		}
		return pnSeleccionEquipo;
	}

	private JPanel getPnListInstalacion() {
		if (pnListInstalacion == null) {
			pnListInstalacion = new JPanel();
			pnListInstalacion.setLayout(new BorderLayout(0, 5));
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
		if (index == -1)
			return;
		service.seleccionaInstalacion(instalacionesListModel.getElementAt(index));
		getTxInstalacion().setText(service.getNombreInstalacion());
		((CardLayout) getPnWork().getLayout()).show(getPnWork(), "pnSeleccionEquipos");
		seleccionaEquipo(-1);
		loadEquipos();
	}

	private JPanel getPnListEquipos() {
		if (pnListEquipos == null) {
			pnListEquipos = new JPanel();
			pnListEquipos.setLayout(new BorderLayout(0, 5));
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
			pnSeleccionHorarios.add(getPnSpinners(), BorderLayout.CENTER);
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
		if (index == -1) {
			service.seleccionaEquipo("");
			getTxEquipo().setText("NONE");
			return;
		}
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
			pnHorariosAsignados.setLayout(new BorderLayout(0, 0));
			pnHorariosAsignados.add(getPnBotonesHorarios(), BorderLayout.SOUTH);
			JScrollPane scpn = new JScrollPane(getListHorariosAsignados());
			pnHorariosAsignados.add(scpn, BorderLayout.CENTER);
		}
		return pnHorariosAsignados;
	}

	private JPanel getPnBotonesHorarios() {
		if (pnBotonesHorarios == null) {
			pnBotonesHorarios = new JPanel();
			pnBotonesHorarios.setBorder(new EmptyBorder(0, 5, 5, 5));
			pnBotonesHorarios.setBackground(new Color(211, 211, 211));
			pnBotonesHorarios.setLayout(new BorderLayout(0, 0));
			pnBotonesHorarios.add(getPanel(), BorderLayout.EAST);
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

	private JPanel getPnSpinners() {
		if (pnSpinners == null) {
			pnSpinners = new JPanel();
			pnSpinners.setBorder(new EmptyBorder(5, 5, 5, 5));

			JLabel lbInstalacion = new JLabel("Instalación:");

			JLabel lbJardinero = new JLabel("Jardinero:");
			GroupLayout gl_pnSpinners = new GroupLayout(pnSpinners);
			gl_pnSpinners.setHorizontalGroup(
				gl_pnSpinners.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnSpinners.createSequentialGroup()
						.addGroup(gl_pnSpinners.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_pnSpinners.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_pnSpinners.createSequentialGroup()
									.addContainerGap()
									.addGroup(gl_pnSpinners.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lbJardinero, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lbInstalacion, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_pnSpinners.createParallelGroup(Alignment.LEADING)
										.addComponent(getTxInstalacion(), GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
										.addComponent(getTxEquipo(), GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
									.addGap(35))
								.addGroup(gl_pnSpinners.createSequentialGroup()
									.addGroup(gl_pnSpinners.createParallelGroup(Alignment.TRAILING)
										.addComponent(getSpFecha(), Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
										.addComponent(getBtnActualizaEquipos(), Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
										.addComponent(getBtnAddHorario(), Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
										.addGroup(gl_pnSpinners.createSequentialGroup()
											.addComponent(getBtnHorarios(), GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(getBtnEquiposAtras()))
										.addGroup(gl_pnSpinners.createSequentialGroup()
											.addContainerGap()
											.addComponent(getSpHoraInicio(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(getSpHoraFin(), GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)))
									.addGap(35)))
							.addGroup(gl_pnSpinners.createSequentialGroup()
								.addContainerGap()
								.addComponent(getLbSeleccionados())))
						.addGap(0))
			);
			gl_pnSpinners.setVerticalGroup(
				gl_pnSpinners.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_pnSpinners.createSequentialGroup()
						.addContainerGap()
						.addComponent(getLbSeleccionados())
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_pnSpinners.createParallelGroup(Alignment.BASELINE)
							.addComponent(getTxInstalacion(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lbInstalacion))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_pnSpinners.createParallelGroup(Alignment.BASELINE)
							.addComponent(getTxEquipo(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lbJardinero))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(getSpFecha(), GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
						.addGroup(gl_pnSpinners.createParallelGroup(Alignment.BASELINE)
							.addComponent(getSpHoraFin(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(getSpHoraInicio(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(getBtnActualizaEquipos())
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(getBtnAddHorario())
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_pnSpinners.createParallelGroup(Alignment.BASELINE)
							.addComponent(getBtnHorarios())
							.addComponent(getBtnEquiposAtras()))
						.addContainerGap())
			);
			pnSpinners.setLayout(gl_pnSpinners);
		}
		return pnSpinners;
	}
	
	private JLabel getLbSeleccionados() {
		if (lbSeleccionados == null) {
			lbSeleccionados = new JLabel("SELECCIONADOS");
			lbSeleccionados.setFont(new Font("Tahoma", Font.BOLD, 13));
		}
		return lbSeleccionados;
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

		State res = service.addHorarioEntrenamiento(this);

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
		case DBERROR:
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

	private JPanel getPnFiltroInstalacion() {
		if (pnFiltroInstalacion == null) {
			pnFiltroInstalacion = new JPanel();
			pnFiltroInstalacion.setLayout(new BoxLayout(pnFiltroInstalacion, BoxLayout.Y_AXIS));
			pnFiltroInstalacion.add(getLbFiltraInstalaciones());
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
			pnFiltroEquipo.setLayout(new BoxLayout(pnFiltroEquipo, BoxLayout.Y_AXIS));
			pnFiltroEquipo.add(getLbEquipoFilter());
			pnFiltroEquipo.add(getTxEquipoFilter());
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
									.addComponent(getTxPassword(), Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 220,
											Short.MAX_VALUE)
									.addComponent(getTxId(), Alignment.LEADING, 220, 220, Short.MAX_VALUE)
									.addComponent(getBtnLogin(), Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 220,
											Short.MAX_VALUE)
									.addComponent(getLbPasswordEntrenador(), Alignment.LEADING,
											GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
							.addGap(136)));
			gl_pnLogin.setVerticalGroup(gl_pnLogin.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnLogin.createSequentialGroup().addGap(59).addComponent(getLbIDEntrenador())
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(getTxId(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addGap(18).addComponent(getLbPasswordEntrenador())
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(getTxPassword(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addGap(31).addComponent(getBtnLogin()).addContainerGap(61, Short.MAX_VALUE)));
			pnLogin.setLayout(gl_pnLogin);
		}
		return pnLogin;
	}

	private JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("Log In");
			btnLogin.setMnemonic('l');
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					login();
				}
			});
			btnLogin.setBackground(new Color(211, 211, 211));
		}
		return btnLogin;
	}

	private void login() {
		if (getTxId().getText().isBlank())
			return;
		
		State res = service.login(Integer.parseInt(getTxId().getText()));
		
		switch (res) {
		case LOGINFAIL_USERNOTALLOWED:
			JOptionPane.showMessageDialog(null, "Error: El empleado no es un entrenador.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		case LOGINFAIL_USERNOTFOUND:
			JOptionPane.showMessageDialog(null, "Error: El entrenador no está registrado en la base de datos.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		default:
		break;
		}
		
		((CardLayout)getPnWork().getLayout()).show(getPnWork(), "pnSeleccionInstalacion");
		getTxId().setText("");
		getTxPassword().setText("");
	}

	private JTextField getTxId() {
		if (txId == null) {
			txId = new JTextField();
			txId.setColumns(10);
		}
		return txId;
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

	private JTextField getTxPassword() {
		if (txPassword == null) {
			txPassword = new JTextField();
			txPassword.setColumns(10);
		}
		return txPassword;
	}
	
	private JButton getBtnLogout() {
		if (btnLogout == null) {
			btnLogout = new JButton("Sign Out");
			btnLogout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((CardLayout)getPnWork().getLayout()).show(getPnWork(), "pnLogin");
				}
			});
			btnLogout.setBackground(new Color(211, 211, 211));
		}
		return btnLogout;
	}

	@Override
	public boolean confirm(String msg) {
	    int option = JOptionPane.showConfirmDialog(this, msg, "Confirmación", JOptionPane.YES_NO_OPTION);

	    if (option == JOptionPane.YES_OPTION) {
	        return true;
	    } else {
	        return false;
	    }
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(new Color(211, 211, 211));
			panel.add(getBtnHorariosAtras());
		}
		return panel;
	}
}
