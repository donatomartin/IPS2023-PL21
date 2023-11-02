package ips2023pl21.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import ips2023pl21.service.Service22784;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.CardLayout;
import javax.swing.JList;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
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

public class Frame22784 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Service22784 service;
	private JPanel pnWork;
	private JPanel pnCabecera;
	private JLabel lbTitle;
	private JLabel lbSubtitle;
	private JPanel pnSeleccionInstalacion;
	private JPanel pnSeleccionJardineros;
	private JPanel pnListInstalacion;
	private JList<String> listInstalaciones;
	private JList<String> listJardineros;
	private DefaultListModel<String> instalacionesListModel = new DefaultListModel<>();
	private DefaultListModel<String> jardinerosListModel = new DefaultListModel<>();
	private JPanel pnListJardineros;
	private JPanel pnSeleccionHorarios;
	private JPanel pnBotonesJardineros;
	private JButton btnJardinerosAtras;
	private JPanel pnHorariosAsignados;
	private JTable tblHorariosAsignados;
	private JPanel pnBotonesHorarios;
	private JButton btnHorariosAtras;
	private JButton btnHorarios;
	private JPanel pnSpinners;
	private JSpinner spFecha;
	private JSpinner spHoraInicio;
	private JSpinner spHoraFin;
	private JButton btnNewButton;
	private JTextField txInstalacionFilter;
	private JTextField txJardineroFilter;
	private JTextField txInstalacion;
	private JTextField txJardinero;

	/**
	 * Create the frame.
	 */
	public Frame22784(Service22784 service) {
		setTitle("Gestión Jardinería");
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
	
	private void loadJardineros() {
		jardinerosListModel.removeAllElements();
		jardinerosListModel.addAll(service.getJardineros(getTxJardineroFilter().getText()));
	}
	
	private void loadInstalaciones() {
		instalacionesListModel.removeAllElements();
		instalacionesListModel.addAll(service.getInstalaciones(getTxInstalacionFilter().getText()));
	}

	private JPanel getPnWork() {
		if (pnWork == null) {
			pnWork = new JPanel();
			pnWork.setLayout(new CardLayout(0, 0));
			pnWork.add(getPnSeleccionInstalacion(), "pnSeleccionInstalacion");
			pnWork.add(getPnSeleccionJardineros(), "pnSeleccionJardineros");
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
			lbTitle = new JLabel("Gestión de Jardinería");
			lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
			lbTitle.setFont(new Font("Tahoma", Font.BOLD, 22));
		}
		return lbTitle;
	}

	private JLabel getLbSubtitle() {
		if (lbSubtitle == null) {
			lbSubtitle = new JLabel("Horarios de trabajo");
			lbSubtitle.setHorizontalAlignment(SwingConstants.CENTER);
			lbSubtitle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return lbSubtitle;
	}

	private JPanel getPnSeleccionInstalacion() {
		if (pnSeleccionInstalacion == null) {
			pnSeleccionInstalacion = new JPanel();
			pnSeleccionInstalacion.setLayout(new BorderLayout(0, 0));
			pnSeleccionInstalacion.add(getPnListInstalacion());
		}
		return pnSeleccionInstalacion;
	}

	private JPanel getPnSeleccionJardineros() {
		if (pnSeleccionJardineros == null) {
			pnSeleccionJardineros = new JPanel();
			pnSeleccionJardineros.setLayout(new GridLayout(0, 2, 0, 0));
			pnSeleccionJardineros.add(getPnListJardineros());
			pnSeleccionJardineros.add(getPnSeleccionHorarios());
		}
		return pnSeleccionJardineros;
	}

	private JPanel getPnListInstalacion() {
		if (pnListInstalacion == null) {
			pnListInstalacion = new JPanel();
			pnListInstalacion.setLayout(new BorderLayout(0, 0));
			JScrollPane scpn = new JScrollPane(getListInstalaciones());
			pnListInstalacion.add(scpn);
			scpn.setColumnHeaderView(getTxInstalacionFilter());
		}
		return pnListInstalacion;
	}

	private JList<String> getListInstalaciones() {
		if (listInstalaciones == null) {
			listInstalaciones = new JList<String>(instalacionesListModel);
			listInstalaciones.setBorder(new EmptyBorder(5, 5, 5, 5));
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
		getTxInstalacion().setText(service.getInstalacion().getNombreInstalacion());
		((CardLayout)getPnWork().getLayout()).show(getPnWork(), "pnSeleccionJardineros");
	}

	private JPanel getPnListJardineros() {
		if (pnListJardineros == null) {
			pnListJardineros = new JPanel();
			pnListJardineros.setLayout(new BorderLayout(0, 0));
			JScrollPane scpn = new JScrollPane(getListJardineros());
			pnListJardineros.add(scpn);
			scpn.setColumnHeaderView(getTxJardineroFilter());
		}
		return pnListJardineros;
	}

	private JPanel getPnSeleccionHorarios() {
		if (pnSeleccionHorarios == null) {
			pnSeleccionHorarios = new JPanel();
			pnSeleccionHorarios.setLayout(new BorderLayout(0, 0));
			pnSeleccionHorarios.add(getPnBotonesJardineros(), BorderLayout.SOUTH);
			pnSeleccionHorarios.add(getPanel_2(), BorderLayout.CENTER);
		}
		return pnSeleccionHorarios;
	}

	private JList<String> getListJardineros() {
		if (listJardineros == null) {
			listJardineros = new JList<String>(jardinerosListModel);
			listJardineros.setBorder(new EmptyBorder(5, 5, 5, 5));
			listJardineros.setFont(new Font("Consolas", Font.BOLD, 16));
			listJardineros.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (e.getClickCount() == 2) {
						seleccionaJardinero(listJardineros.locationToIndex(e.getPoint()));
					}
				}
				
			});
			listJardineros.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent evt) {
					if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
						seleccionaJardinero(listJardineros.getSelectedIndex());
					}
				}
			});
			loadJardineros();
		}
		return listJardineros;
	}
	
	private void seleccionaJardinero(int index) {
		service.seleccionaJardinero(jardinerosListModel.getElementAt(index));
		getTxJardinero().setText(service.getJardinero().getNombre() + " " + service.getJardinero().getApellido());
	}

	private JPanel getPnBotonesJardineros() {
		if (pnBotonesJardineros == null) {
			pnBotonesJardineros = new JPanel();
			pnBotonesJardineros.setBorder(new EmptyBorder(5, 15, 15, 15));
			pnBotonesJardineros.setLayout(new BorderLayout(0, 0));
			pnBotonesJardineros.add(getBtnJardinerosAtras(), BorderLayout.EAST);
			pnBotonesJardineros.add(getBtnHorarios(), BorderLayout.CENTER);
		}
		return pnBotonesJardineros;
	}

	private JButton getBtnJardinerosAtras() {
		if (btnJardinerosAtras == null) {
			btnJardinerosAtras = new JButton("Atrás");
			btnJardinerosAtras.setBackground(new Color(211, 211, 211));
			btnJardinerosAtras.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((CardLayout)getPnWork().getLayout()).show(getPnWork(), "pnSeleccionInstalacion");
				}
			});
		}
		return btnJardinerosAtras;
	}
	private JPanel getPnHorariosAsignados() {
		if (pnHorariosAsignados == null) {
			pnHorariosAsignados = new JPanel();
			pnHorariosAsignados.setBorder(new EmptyBorder(5, 5, 5, 5));
			pnHorariosAsignados.setLayout(new BorderLayout(0, 0));
			pnHorariosAsignados.add(getTblHorariosAsignados());
			pnHorariosAsignados.add(getPnBotonesHorarios(), BorderLayout.SOUTH);
		}
		return pnHorariosAsignados;
	}
	private JTable getTblHorariosAsignados() {
		if (tblHorariosAsignados == null) {
			tblHorariosAsignados = new JTable();
		}
		return tblHorariosAsignados;
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
					((CardLayout)getPnWork().getLayout()).show(getPnWork(), "pnSeleccionJardineros");
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
					((CardLayout)getPnWork().getLayout()).show(getPnWork(), "pnHorarios");
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
			
			JLabel lbJardinero = new JLabel("Jardinero:");
			GroupLayout gl_pnSpinners = new GroupLayout(pnSpinners);
			gl_pnSpinners.setHorizontalGroup(
				gl_pnSpinners.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_pnSpinners.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_pnSpinners.createParallelGroup(Alignment.LEADING)
							.addGroup(Alignment.TRAILING, gl_pnSpinners.createSequentialGroup()
								.addGap(83)
								.addComponent(getSpHoraInicio())
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(getSpHoraFin()))
							.addComponent(getSpFecha(), Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
							.addComponent(getBtnNewButton(), Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
							.addGroup(gl_pnSpinners.createSequentialGroup()
								.addGroup(gl_pnSpinners.createParallelGroup(Alignment.LEADING, false)
									.addComponent(lbJardinero, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lbInstalacion, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_pnSpinners.createParallelGroup(Alignment.LEADING)
									.addComponent(getTxJardinero(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(getTxInstalacion(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addContainerGap())
			);
			gl_pnSpinners.setVerticalGroup(
				gl_pnSpinners.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_pnSpinners.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_pnSpinners.createParallelGroup(Alignment.BASELINE)
							.addComponent(lbInstalacion)
							.addComponent(getTxInstalacion(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_pnSpinners.createParallelGroup(Alignment.BASELINE)
							.addComponent(lbJardinero)
							.addComponent(getTxJardinero(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
						.addComponent(getSpFecha(), GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_pnSpinners.createParallelGroup(Alignment.BASELINE)
							.addComponent(getSpHoraFin(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(getSpHoraInicio(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addComponent(getBtnNewButton())
						.addGap(28))
			);
			pnSpinners.setLayout(gl_pnSpinners);
		}
		return pnSpinners;
	}
	private JSpinner getSpFecha() {
		if (spFecha == null) {
			spFecha = new JSpinner();
			spFecha.setModel(new SpinnerDateModel(new Date(1673478000000L), null, null, Calendar.DAY_OF_YEAR));
			JSpinner.DateEditor editor = new JSpinner.DateEditor(spFecha, "dd-MM-yyyy");	
			spFecha.setEditor(editor);
		}
		return spFecha;
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
		}
		return spHoraInicio;
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
		}
		return spHoraFin;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Añadir Horario");
			btnNewButton.setBackground(new Color(211, 211, 211));
		}
		return btnNewButton;
	}
	private JTextField getTxInstalacionFilter() {
		if (txInstalacionFilter == null) {
			txInstalacionFilter = new JTextField();
			txInstalacionFilter.setColumns(10);
		}
		return txInstalacionFilter;
	}
	private JTextField getTxJardineroFilter() {
		if (txJardineroFilter == null) {
			txJardineroFilter = new JTextField();
			txJardineroFilter.setColumns(10);
		}
		return txJardineroFilter;
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
	private JTextField getTxJardinero() {
		if (txJardinero == null) {
			txJardinero = new JTextField();
			txJardinero.setText("NONE");
			txJardinero.setEditable(false);
			txJardinero.setColumns(10);
		}
		return txJardinero;
	}
}
