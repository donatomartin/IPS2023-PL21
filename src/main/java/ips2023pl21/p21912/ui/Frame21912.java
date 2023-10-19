package ips2023pl21.p21912.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import ips2023pl21.p21912.service.Service21912;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.List;
import java.util.Calendar;
import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JSpinner;

public class Frame21912 extends JFrame {

	private Service21912 service;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pnTitle;
	private JLabel lbTitle;
	private JLabel lblNewLabel;
	private JPanel pnWork;
	private JPanel pnSeleccionEmpleado;
	private JPanel pnFiltro;
	private JTextField txFilterEmployee;
	private JPanel pnList;
	private JList<String> employeeList;
	private DefaultListModel<String> empleadoListModel = new DefaultListModel<String>();
	private DefaultListModel<String> semanalListModel = new DefaultListModel<String>();
	private DefaultListModel<String> puntualListModel = new DefaultListModel<String>();
	private JPanel pnSelectHorarioModalidad;
	private JLabel lbInstruccionSeleccionEmpleado;
	private JPanel pnGestionHorarioPuntual;
	private JPanel pnGestionHorarioSemanal;
	private JLabel lbEmployeeName1;
	private JLabel lbInstruccionSeleccionModalidad;
	private JPanel pnBotonesModalidad;
	private JButton btnHorarioPuntual;
	private JButton btnHorarioSemanal;
	private JPanel panel;
	private JPanel pnModalidadBotones;
	private JButton btnAtrasModalidad;
	private JPanel pnBotonesPuntual;
	private JButton btnAtrasPuntual;
	private JPanel pnBotonesSemanal;
	private JButton btnAtrasSemanal;
	private JPanel pnGestionHorarioPuntual1;
	private JPanel pnGestionHorarioSemanal1;
	private JComboBox<String> cbDiaSemana;
	private JPanel pnDiaSemana;
	private JLabel lbDiaSemana;
	private JPanel pnFormularioSemanal;
	private JPanel pnListHorarioSemanal;
	private JPanel pnFranja;
	private JList<String> listHorariosSemanales;
	private JSpinner spHoraInicioSemanal;
	private JLabel lbHoraInicioSemana;
	private JLabel lbHoraFinSemana;
	private JSpinner spHoraFinSemanal;
	private JButton btnAnadirFranjaSemana;
	private JLabel lbNombreEmpleado;
	private JPanel pnNombreEmpleado;
	private JPanel pnHoraInicioSemanal;
	private JPanel pnHoraFinSemanal;
	private JPanel pnNorteDiaSemana;
	private JPanel pnFormularioPuntual;
	private JPanel pnListHorarioPuntual;
	private JPanel pnNombreEmpleadoPuntual;
	private JLabel lbNombreEmpleadoPuntual;
	private JPanel pnSeleccionFechaPuntual;
	private JPanel pnFechaPuntual;
	private JLabel lbFechaPuntual;
	private JList<String> listHorariosPuntuales;
	private JButton btnAddHorarioSemanal;
	private JSpinner spFechaPuntual;
	private JPanel pnFechaInicio;
	private JLabel lbFechaInicio;
	private JSpinner spFechaInicio;
	private JPanel pnBotonesHorariosSemanales;
	private JButton btnBorrarHorarioSemanal;
	private JPanel pnDiaSemana1;
	private JPanel pnBtnPuntual;
	private JPanel pnBotonesHorariosPuntual;
	private JButton btnAddHorarioPuntual;
	private JButton btnRemoveHorarioPuntual;
	private JButton btnAddFranjaPuntual;
	private JPanel pnFechaPuntual1;
	private JPanel pnFranjasPuntuales;
	private JPanel pnFechaPuntual2;
	private JLabel lbHoraInicioPuntual;
	private JSpinner spHoraInicioPuntual;
	private JPanel pnHoraInicioPuntual;
	private JPanel pnHoraFinPuntual;
	private JLabel lbHoraFinPuntual;
	private JSpinner spHoraFinPuntual;
	private JPanel pnFechaPuntual3;

	/**
	 * Create the frame.
	 */
	public Frame21912(Service21912 service) {
		setTitle("Gestion Horarios");
		this.service = service;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		setMinimumSize(getSize());
		contentPane = new JPanel();

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPnTitle(), BorderLayout.NORTH);
		contentPane.add(getPnWork(), BorderLayout.CENTER);
	}

	private JPanel getPnTitle() {
		if (pnTitle == null) {
			pnTitle = new JPanel();
			pnTitle.setBackground(new Color(192, 192, 192));
			pnTitle.setLayout(new BorderLayout(0, 0));
			pnTitle.add(getLbTitle(), BorderLayout.NORTH);
			pnTitle.add(getLblNewLabel());
		}
		return pnTitle;
	}

	private JLabel getLbTitle() {
		if (lbTitle == null) {
			lbTitle = new JLabel("Gestion de Horarios");
			lbTitle.setFont(new Font("Tahoma", Font.BOLD, 22));
			lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lbTitle;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Empleados no deportivos");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel;
	}

	private JPanel getPnWork() {
		if (pnWork == null) {
			pnWork = new JPanel();
			pnWork.setLayout(new CardLayout(0, 0));
			pnWork.add(getPnSeleccionEmpleado(), "seleccionEmpleado");
			pnWork.add(getPnSelectHorarioModalidad(), "seleccionModalidad");
			pnWork.add(getPnGestionHorarioPuntual(), "horarioPuntual");
			pnWork.add(getPnGestionHorarioSemanal(), "horarioSemanal");
		}
		return pnWork;
	}

	private JPanel getPnSeleccionEmpleado() {
		if (pnSeleccionEmpleado == null) {
			pnSeleccionEmpleado = new JPanel();
			pnSeleccionEmpleado.setBorder(new EmptyBorder(5, 5, 5, 5));
			pnSeleccionEmpleado.setLayout(new BorderLayout(5, 5));
			pnSeleccionEmpleado.add(getPnFiltro(), BorderLayout.NORTH);
			pnSeleccionEmpleado.add(getPnList(), BorderLayout.CENTER);
		}
		return pnSeleccionEmpleado;
	}

	private JPanel getPnFiltro() {
		if (pnFiltro == null) {
			pnFiltro = new JPanel();
			pnFiltro.setLayout(new BoxLayout(pnFiltro, BoxLayout.Y_AXIS));
			pnFiltro.add(getLbInstruccionSeleccionEmpleado());
			pnFiltro.add(getTxFilterEmployee());
		}
		return pnFiltro;
	}

	private JTextField getTxFilterEmployee() {
		if (txFilterEmployee == null) {
			txFilterEmployee = new JTextField();
			txFilterEmployee.setColumns(10);
			txFilterEmployee.getDocument().addDocumentListener(new DocumentListener() {

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
		return txFilterEmployee;
	}

	public void filter() {
		loadEmpleadoListModel(getTxFilterEmployee().getText());
	}

	private JPanel getPnList() {
		if (pnList == null) {
			pnList = new JPanel();
			pnList.setLayout(new BorderLayout(0, 0));
			JScrollPane listScrollPane = new JScrollPane(getListEmpleados());
			pnList.add(listScrollPane);
		}
		return pnList;
	}

	private JList<String> getListEmpleados() {
		if (employeeList == null) {
			loadEmpleadoListModel("");
			employeeList = new JList<String>(empleadoListModel);
			employeeList.setBorder(new EmptyBorder(5, 5, 5, 5));
			employeeList.setFont(new Font("Consolas", Font.BOLD, 15));

			// Añadir MouseListener para el doble click
			employeeList.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					if (evt.getClickCount() == 2) {
						// Doble-click detectado
						int index = employeeList.locationToIndex(evt.getPoint());
						seleccionarEmpleado(index);
					}
				}
			});

			// Añadir KeyListener para el Enter
			employeeList.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent evt) {
					if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
						// Enter detectado
						int index = employeeList.getSelectedIndex();
						seleccionarEmpleado(index);
					}
				}
			});

		}
		return employeeList;
	}

	private void seleccionarEmpleado(int index) {
		service.seleccionaEmpleado(empleadoListModel.getElementAt(index));
		loadEmpleadoListModel("");
		loadSemanalListModel();
		loadPuntualListModel();
		getLbEmployeeName1().setText(service.getNombreEmpleadoSeleccionado());
		getLbNombreEmpleadoSemanal().setText(service.getNombreEmpleadoSeleccionado());
		getLbNombreEmpleadoPuntual().setText(service.getNombreEmpleadoSeleccionado());
		((CardLayout) pnWork.getLayout()).show(pnWork, "seleccionModalidad");
	}

	private void loadEmpleadoListModel(String filter) {
		empleadoListModel.removeAllElements();
		empleadoListModel.addAll(service.getEmpleadosNoDeportivosString(filter));
	}

	private JPanel getPnSelectHorarioModalidad() {
		if (pnSelectHorarioModalidad == null) {
			pnSelectHorarioModalidad = new JPanel();
			pnSelectHorarioModalidad.setBorder(new EmptyBorder(0, 0, 0, 0));
			pnSelectHorarioModalidad.setLayout(new BorderLayout(0, 0));
			pnSelectHorarioModalidad.add(getPanel(), BorderLayout.NORTH);
			pnSelectHorarioModalidad.add(getPnBotonesModalidad());
			pnSelectHorarioModalidad.add(getPnModalidadBotones(), BorderLayout.SOUTH);
		}
		return pnSelectHorarioModalidad;
	}

	private JLabel getLbInstruccionSeleccionEmpleado() {
		if (lbInstruccionSeleccionEmpleado == null) {
			lbInstruccionSeleccionEmpleado = new JLabel("Seleccione al empleado");
		}
		return lbInstruccionSeleccionEmpleado;
	}

	private JPanel getPnGestionHorarioPuntual() {
		if (pnGestionHorarioPuntual == null) {
			pnGestionHorarioPuntual = new JPanel();
			pnGestionHorarioPuntual.setLayout(new BorderLayout(0, 0));
			pnGestionHorarioPuntual.add(getPnBotonesPuntual(), BorderLayout.SOUTH);
			pnGestionHorarioPuntual.add(getPnGestionHorarioPuntual1(), BorderLayout.CENTER);
		}
		return pnGestionHorarioPuntual;
	}

	private JPanel getPnGestionHorarioSemanal() {
		if (pnGestionHorarioSemanal == null) {
			pnGestionHorarioSemanal = new JPanel();
			pnGestionHorarioSemanal.setLayout(new BorderLayout(0, 0));
			pnGestionHorarioSemanal.add(getPnBotonesSemanal(), BorderLayout.SOUTH);
			pnGestionHorarioSemanal.add(getPnGestionHorarioSemanal1(), BorderLayout.CENTER);
		}
		return pnGestionHorarioSemanal;
	}

	private JLabel getLbEmployeeName1() {
		if (lbEmployeeName1 == null) {
			lbEmployeeName1 = new JLabel("Nombre Empleado");
			lbEmployeeName1.setHorizontalAlignment(SwingConstants.CENTER);
			lbEmployeeName1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lbEmployeeName1;
	}

	private JLabel getLbInstruccionSeleccionModalidad() {
		if (lbInstruccionSeleccionModalidad == null) {
			lbInstruccionSeleccionModalidad = new JLabel("seleccione el tipo de horario a modificar:");
			lbInstruccionSeleccionModalidad.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lbInstruccionSeleccionModalidad;
	}

	private JPanel getPnBotonesModalidad() {
		if (pnBotonesModalidad == null) {
			pnBotonesModalidad = new JPanel();
			pnBotonesModalidad.setBorder(new EmptyBorder(10, 10, 10, 10));
			pnBotonesModalidad.setLayout(new GridLayout(0, 2, 10, 0));
			pnBotonesModalidad.add(getBtnHorarioSemanal());
			pnBotonesModalidad.add(getBtnHorarioPuntual());
		}
		return pnBotonesModalidad;
	}

	private JButton getBtnHorarioPuntual() {
		if (btnHorarioPuntual == null) {
			btnHorarioPuntual = new JButton("Excepciones");
			btnHorarioPuntual.setFont(new Font("Tahoma", Font.BOLD, 18));
			btnHorarioPuntual.setBackground(new Color(211, 211, 211));
			btnHorarioPuntual.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					showHorarioPuntualPanel();
				}

			});
		}
		return btnHorarioPuntual;
	}

	private void showHorarioPuntualPanel() {
		((CardLayout) getPnWork().getLayout()).show(pnWork, "horarioPuntual");
	}

	private JButton getBtnHorarioSemanal() {
		if (btnHorarioSemanal == null) {
			btnHorarioSemanal = new JButton("Semanal");
			btnHorarioSemanal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showHorarioSemanalPanel();
				}
			});
			btnHorarioSemanal.setFont(new Font("Tahoma", Font.BOLD, 18));
			btnHorarioSemanal.setBackground(new Color(211, 211, 211));
		}
		return btnHorarioSemanal;
	}

	private void showHorarioSemanalPanel() {
		((CardLayout) getPnWork().getLayout()).show(pnWork, "horarioSemanal");
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBorder(new EmptyBorder(5, 0, 0, 0));
			panel.setLayout(new BorderLayout(0, 0));
			panel.add(getLbEmployeeName1(), BorderLayout.NORTH);
			panel.add(getLbInstruccionSeleccionModalidad(), BorderLayout.CENTER);
		}
		return panel;
	}

	private JPanel getPnModalidadBotones() {
		if (pnModalidadBotones == null) {
			pnModalidadBotones = new JPanel();
			pnModalidadBotones.setBorder(new EmptyBorder(5, 5, 5, 5));
			pnModalidadBotones.setLayout(new BorderLayout(0, 0));
			pnModalidadBotones.add(getBtnAtrasModalidad(), BorderLayout.EAST);
		}
		return pnModalidadBotones;
	}

	private JButton getBtnAtrasModalidad() {
		if (btnAtrasModalidad == null) {
			btnAtrasModalidad = new JButton("Atrás");
			btnAtrasModalidad.setBackground(new Color(211, 211, 211));
			btnAtrasModalidad.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((CardLayout) pnWork.getLayout()).show(pnWork, "seleccionEmpleado");
				}
			});
		}
		return btnAtrasModalidad;
	}

	private JPanel getPnBotonesPuntual() {
		if (pnBotonesPuntual == null) {
			pnBotonesPuntual = new JPanel();
			pnBotonesPuntual.setBorder(new EmptyBorder(5, 5, 5, 5));
			pnBotonesPuntual.setLayout(new BorderLayout(0, 0));
			pnBotonesPuntual.add(getBtnAtrasPuntual(), BorderLayout.EAST);
		}
		return pnBotonesPuntual;
	}

	private JButton getBtnAtrasPuntual() {
		if (btnAtrasPuntual == null) {
			btnAtrasPuntual = new JButton("Atrás");
			btnAtrasPuntual.setBackground(new Color(211, 211, 211));
			btnAtrasPuntual.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showPnSeleccionModalidad();
				}
			});
		}
		return btnAtrasPuntual;
	}

	private void showPnSeleccionModalidad() {
		((CardLayout) getPnWork().getLayout()).show(pnWork, "seleccionModalidad");
	}

	private JPanel getPnBotonesSemanal() {
		if (pnBotonesSemanal == null) {
			pnBotonesSemanal = new JPanel();
			pnBotonesSemanal.setBorder(new EmptyBorder(5, 5, 5, 5));
			pnBotonesSemanal.setLayout(new BorderLayout(0, 0));
			pnBotonesSemanal.add(getBtnAtrasSemanal(), BorderLayout.EAST);
		}
		return pnBotonesSemanal;
	}

	private JButton getBtnAtrasSemanal() {
		if (btnAtrasSemanal == null) {
			btnAtrasSemanal = new JButton("Atrás");
			btnAtrasSemanal.setBackground(new Color(211, 211, 211));
			btnAtrasSemanal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showPnSeleccionModalidad();
				}
			});
		}
		return btnAtrasSemanal;
	}

	private JPanel getPnGestionHorarioPuntual1() {
		if (pnGestionHorarioPuntual1 == null) {
			pnGestionHorarioPuntual1 = new JPanel();
			pnGestionHorarioPuntual1.setLayout(new GridLayout(0, 2, 0, 0));
			pnGestionHorarioPuntual1.add(getPnFormularioPuntual());
			pnGestionHorarioPuntual1.add(getPnListHorarioPuntual());
		}
		return pnGestionHorarioPuntual1;
	}

	private JPanel getPnGestionHorarioSemanal1() {
		if (pnGestionHorarioSemanal1 == null) {
			pnGestionHorarioSemanal1 = new JPanel();
			pnGestionHorarioSemanal1.setLayout(new GridLayout(0, 2, 0, 0));
			pnGestionHorarioSemanal1.add(getPnFormularioSemanal());
			pnGestionHorarioSemanal1.add(getPnListHorarioSemanal());
		}
		return pnGestionHorarioSemanal1;
	}

	private JComboBox<String> getCbDiaSemana() {
	    if (cbDiaSemana == null) {
	        cbDiaSemana = new JComboBox<String>();
	        cbDiaSemana.setFont(new Font("Tahoma", Font.PLAIN, 16));
	        cbDiaSemana.setBackground(new Color(255, 255, 255));
	        cbDiaSemana.setModel(new DefaultComboBoxModel<String>(
	                new String[] { "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo" }));

	        // Añadir ActionListener
	        cbDiaSemana.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                service.deseleccionadHorarioSemanal();
	            }
	        });
	    }
	    return cbDiaSemana;
	}

	private JPanel getPnDiaSemana() {
		if (pnDiaSemana == null) {
			pnDiaSemana = new JPanel();
			pnDiaSemana.setLayout(new BorderLayout(0, 0));
			pnDiaSemana.add(getPnFechaInicio(), BorderLayout.SOUTH);
			pnDiaSemana.add(getPnDiaSemana1(), BorderLayout.CENTER);
		}
		return pnDiaSemana;
	}

	private JLabel getLbDiaSemana() {
		if (lbDiaSemana == null) {
			lbDiaSemana = new JLabel("Día de la semana:");
		}
		return lbDiaSemana;
	}

	private JPanel getPnFormularioSemanal() {
		if (pnFormularioSemanal == null) {
			pnFormularioSemanal = new JPanel();
			pnFormularioSemanal.setLayout(new BoxLayout(pnFormularioSemanal, BoxLayout.Y_AXIS));
			pnFormularioSemanal.add(getPnNombreEmpleado());
			pnFormularioSemanal.add(getPnDiaSemana());
			pnFormularioSemanal.add(getPnFranja());
		}
		return pnFormularioSemanal;
	}

	private JPanel getPnListHorarioSemanal() {
		if (pnListHorarioSemanal == null) {
			pnListHorarioSemanal = new JPanel();
			pnListHorarioSemanal.setBorder(new TitledBorder(
					new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
					"Horarios", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			pnListHorarioSemanal.setLayout(new BorderLayout(0, 0));
			JScrollPane scpnFranjasSemanales = new JScrollPane(getListHorariosSemanales());
			pnListHorarioSemanal.add(scpnFranjasSemanales);
		}
		return pnListHorarioSemanal;
	}

	private JPanel getPnFranja() {
		if (pnFranja == null) {
			pnFranja = new JPanel();
			pnFranja.setBorder(new EmptyBorder(5, 5, 5, 5));
			pnFranja.setLayout(new GridLayout(0, 1, 0, 0));
			pnFranja.add(getPnHoraInicioSemanal());
			pnFranja.add(getPnHoraFinSemanal());
			pnFranja.add(getBtnAnadirFranjaSemana());
			pnFranja.add(getPnBotonesHorariosSemanales());
		}
		return pnFranja;
	}

	private JList<String> getListHorariosSemanales() {
		if (listHorariosSemanales == null) {
			listHorariosSemanales = new JList<String>(semanalListModel);
			listHorariosSemanales.setFont(new Font("Consolas", Font.BOLD, 14));

			listHorariosSemanales.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					seleccionaHorarioSemanal(listHorariosSemanales.getSelectedValue());
				}
			});

		}
		return listHorariosSemanales;
	}

	private void seleccionaHorarioSemanal(String horarioString) {
		service.seleccionaHorarioSemanal(horarioString);
	}

	private void loadSemanalListModel() {
		semanalListModel.removeAllElements();
		List<String> horariosSemanales = service.getHorariosSemanalesString();
		semanalListModel.addAll(horariosSemanales);
	}

	private void loadPuntualListModel() {
		puntualListModel.removeAllElements();
		puntualListModel.addAll(service.getHorariosPuntualesString());
	}

	private JSpinner getSpHoraInicioSemanal() {
		if (spHoraInicioSemanal == null) {
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.HOUR_OF_DAY, 9);
			calendar.set(Calendar.MINUTE, 0);
			Date date = calendar.getTime();
			SpinnerDateModel sm = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
			spHoraInicioSemanal = new JSpinner(sm);
			spHoraInicioSemanal.setFont(new Font("Tahoma", Font.PLAIN, 16));
			JSpinner.DateEditor de = new JSpinner.DateEditor(spHoraInicioSemanal, "HH:mm");
			spHoraInicioSemanal.setEditor(de);
		}
		return spHoraInicioSemanal;
	}

	private JLabel getLbHoraInicioSemana() {
		if (lbHoraInicioSemana == null) {
			lbHoraInicioSemana = new JLabel("Hora de inicio");
		}
		return lbHoraInicioSemana;
	}

	private JLabel getLbHoraFinSemana() {
		if (lbHoraFinSemana == null) {
			lbHoraFinSemana = new JLabel("Hora de fin");
		}
		return lbHoraFinSemana;
	}

	private JSpinner getSpHoraFinSemanal() {
		if (spHoraFinSemanal == null) {
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.HOUR_OF_DAY, 17);
			calendar.set(Calendar.MINUTE, 0);
			Date date = calendar.getTime();
			SpinnerDateModel sm = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
			spHoraFinSemanal = new JSpinner(sm);
			spHoraFinSemanal.setFont(new Font("Tahoma", Font.PLAIN, 16));
			JSpinner.DateEditor de = new JSpinner.DateEditor(spHoraFinSemanal, "HH:mm");
			spHoraFinSemanal.setEditor(de);
		}
		return spHoraFinSemanal;
	}

	private JButton getBtnAnadirFranjaSemana() {
		if (btnAnadirFranjaSemana == null) {
			btnAnadirFranjaSemana = new JButton("Añade Franja");
			btnAnadirFranjaSemana.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addToHorarioSemanal();
				}
			});
			btnAnadirFranjaSemana.setBackground(new Color(211, 211, 211));
		}
		return btnAnadirFranjaSemana;
	}

	private void addToHorarioSemanal() {
		
		int res = service.addToHorarioSemanal((Date) getSpHoraInicioSemanal().getValue(),
				(Date) getSpHoraFinSemanal().getValue(), getCbDiaSemana().getSelectedItem().toString(), (Date) getSpFechaInicio().getValue());
			
		if (res == 2) {
			// FIN ANTES QUE PRINCIPIO
			JOptionPane.showMessageDialog(null, "Error: La hora de finalización es anterior a la hora de inicio.", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else if (res == 3) {
			// SOLAPA ENTRE FRANJAS
			JOptionPane.showMessageDialog(null, "Error: Solapamiento entre franjas horarias.", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else if (res == 4) {
			// SOBREPASADO LIMITE DIARIO
			JOptionPane.showMessageDialog(null, "Error: Se ha sobrepasado el límite diario.", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else if (res == 5) {
			// SOBREPASADO LIMITE SEMANAL
			JOptionPane.showMessageDialog(null, "Error: Se ha sobrepasado el límite semanal.", "Error", JOptionPane.ERROR_MESSAGE);
		}
			
		loadSemanalListModel();

	}


	private JLabel getLbNombreEmpleadoSemanal() {
		if (lbNombreEmpleado == null) {
			lbNombreEmpleado = new JLabel("None");
			lbNombreEmpleado.setFont(new Font("Tahoma", Font.BOLD, 15));
			lbNombreEmpleado.setHorizontalAlignment(SwingConstants.LEFT);
		}
		return lbNombreEmpleado;
	}

	private JPanel getPnNombreEmpleado() {
		if (pnNombreEmpleado == null) {
			pnNombreEmpleado = new JPanel();
			pnNombreEmpleado.setBorder(new EmptyBorder(5, 5, 5, 5));
			pnNombreEmpleado.setLayout(new BoxLayout(pnNombreEmpleado, BoxLayout.X_AXIS));
			pnNombreEmpleado.add(getLbNombreEmpleadoSemanal());
		}
		return pnNombreEmpleado;
	}

	private JPanel getPnHoraInicioSemanal() {
		if (pnHoraInicioSemanal == null) {
			pnHoraInicioSemanal = new JPanel();
			pnHoraInicioSemanal.setLayout(new BorderLayout(0, 0));
			pnHoraInicioSemanal.add(getLbHoraInicioSemana(), BorderLayout.CENTER);
			pnHoraInicioSemanal.add(getSpHoraInicioSemanal(), BorderLayout.EAST);
		}
		return pnHoraInicioSemanal;
	}

	private JPanel getPnHoraFinSemanal() {
		if (pnHoraFinSemanal == null) {
			pnHoraFinSemanal = new JPanel();
			pnHoraFinSemanal.setLayout(new BorderLayout(0, 0));
			pnHoraFinSemanal.add(getLbHoraFinSemana());
			pnHoraFinSemanal.add(getSpHoraFinSemanal(), BorderLayout.EAST);
		}
		return pnHoraFinSemanal;
	}

	private JPanel getPnNorteDiaSemana() {
		if (pnNorteDiaSemana == null) {
			pnNorteDiaSemana = new JPanel();
			pnNorteDiaSemana.setBorder(new EmptyBorder(5, 5, 5, 5));
			pnNorteDiaSemana.setLayout(new BorderLayout(5, 0));
			pnNorteDiaSemana.add(getLbDiaSemana(), BorderLayout.WEST);
			pnNorteDiaSemana.add(getCbDiaSemana());
		}
		return pnNorteDiaSemana;
	}

	private JPanel getPnFormularioPuntual() {
		if (pnFormularioPuntual == null) {
			pnFormularioPuntual = new JPanel();
			pnFormularioPuntual.setLayout(new BorderLayout(0, 0));
			pnFormularioPuntual.add(getPnNombreEmpleadoPuntual(), BorderLayout.NORTH);
			pnFormularioPuntual.add(getPnSeleccionFechaPuntual(), BorderLayout.CENTER);
		}
		return pnFormularioPuntual;
	}

	private JPanel getPnListHorarioPuntual() {
		if (pnListHorarioPuntual == null) {
			pnListHorarioPuntual = new JPanel();
			pnListHorarioPuntual
					.setBorder(new TitledBorder(null, "Horarios", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnListHorarioPuntual.setLayout(new BorderLayout(0, 0));
			JScrollPane scpn = new JScrollPane(getListHorariosPuntuales());
			pnListHorarioPuntual.add(scpn);
		}
		return pnListHorarioPuntual;
	}

	private JPanel getPnNombreEmpleadoPuntual() {
		if (pnNombreEmpleadoPuntual == null) {
			pnNombreEmpleadoPuntual = new JPanel();
			pnNombreEmpleadoPuntual.setLayout(new BorderLayout(0, 0));
			pnNombreEmpleadoPuntual.add(getLbNombreEmpleadoPuntual());
		}
		return pnNombreEmpleadoPuntual;
	}

	private JLabel getLbNombreEmpleadoPuntual() {
		if (lbNombreEmpleadoPuntual == null) {
			lbNombreEmpleadoPuntual = new JLabel("None");
			lbNombreEmpleadoPuntual.setFont(new Font("Tahoma", Font.BOLD, 15));
			lbNombreEmpleadoPuntual.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lbNombreEmpleadoPuntual;
	}

	private JPanel getPnSeleccionFechaPuntual() {
		if (pnSeleccionFechaPuntual == null) {
			pnSeleccionFechaPuntual = new JPanel();
			pnSeleccionFechaPuntual.setBorder(new EmptyBorder(5, 5, 5, 5));
			pnSeleccionFechaPuntual.setLayout(new BorderLayout(0, 0));
			pnSeleccionFechaPuntual.add(getPnFechaPuntual(), BorderLayout.CENTER);
			pnSeleccionFechaPuntual.add(getPnBtnPuntual(), BorderLayout.SOUTH);
		}
		return pnSeleccionFechaPuntual;
	}

	private JPanel getPnFechaPuntual() {
		if (pnFechaPuntual == null) {
			pnFechaPuntual = new JPanel();
			pnFechaPuntual.setLayout(new BorderLayout(0, 0));
			pnFechaPuntual.add(getPnFechaPuntual1(), BorderLayout.CENTER);
			pnFechaPuntual.add(getPnFranjasPuntuales(), BorderLayout.SOUTH);
		}
		return pnFechaPuntual;
	}

	private JLabel getLbFechaPuntual() {
		if (lbFechaPuntual == null) {
			lbFechaPuntual = new JLabel("Fecha Puntual");
		}
		return lbFechaPuntual;
	}

	private JList<String> getListHorariosPuntuales() {
		if (listHorariosPuntuales == null) {
			listHorariosPuntuales = new JList<String>(puntualListModel);
			listHorariosPuntuales.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent evt) {
					seleccionaHorarioPuntual(listHorariosPuntuales.getSelectedValue());
				}
			});
		}
		return listHorariosPuntuales;
	}

	private void seleccionaHorarioPuntual(String horarioString) {
		service.seleccionaHorarioPuntual2(horarioString);
	}

	private JButton getBtnAddHorarioSemanal() {
		if (btnAddHorarioSemanal == null) {
			btnAddHorarioSemanal = new JButton("Añade Horario");
			btnAddHorarioSemanal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addHorarioSemanal();
				}
			});
			btnAddHorarioSemanal.setBackground(new Color(211, 211, 211));
		}
		return btnAddHorarioSemanal;
	}

	private void addHorarioSemanal() {
		service.addHorarioSemanal(getCbDiaSemana().getSelectedItem().toString(), (Date) getSpFechaInicio().getValue());
		loadSemanalListModel();
	}

	private JSpinner getSpFechaPuntual() {
		if (spFechaPuntual == null) {
			spFechaPuntual = new JSpinner();
			spFechaPuntual.setFont(new Font("Tahoma", Font.PLAIN, 15));
			spFechaPuntual.setModel(new SpinnerDateModel(new Date(1697061600000L), null, null, Calendar.DAY_OF_YEAR));
			
			// Obtén la fecha actual y añade 7 días
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DAY_OF_YEAR, 7);
			Date date = calendar.getTime();

			// Crea un modelo con la fecha y establece el formato para que no muestre las horas
			SpinnerDateModel model = new SpinnerDateModel();
			model.setValue(date);
			spFechaPuntual.setModel(model);

			// Establece el formato de la fecha para que no muestre las horas
			JSpinner.DateEditor editor = new JSpinner.DateEditor(spFechaPuntual, "dd-MM-yyyy");
			
			spFechaPuntual.setEditor(editor);
			
			spFechaPuntual.addChangeListener(new ChangeListener() {
			    public void stateChanged(ChangeEvent e) {
			    	service.deseleccionaHorarioPuntual();
			    }
			});
		}
		return spFechaPuntual;
	}

	private JPanel getPnFechaInicio() {
		if (pnFechaInicio == null) {
			pnFechaInicio = new JPanel();
			pnFechaInicio.setBorder(new EmptyBorder(5, 5, 5, 5));
			pnFechaInicio.setLayout(new BorderLayout(5, 0));
			pnFechaInicio.add(getLbFechaInicio(), BorderLayout.WEST);
			pnFechaInicio.add(getSpFechaInicio());
		}
		return pnFechaInicio;
	}

	private JLabel getLbFechaInicio() {
		if (lbFechaInicio == null) {
			lbFechaInicio = new JLabel("Fecha Inicio:");
		}
		return lbFechaInicio;
	}

	private JSpinner getSpFechaInicio() {
		if (spFechaInicio == null) {
			spFechaInicio = new JSpinner();
			spFechaInicio.setFont(new Font("Tahoma", Font.PLAIN, 15));

			// Obtén la fecha actual y añade 7 días
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DAY_OF_YEAR, 7);
			Date date = calendar.getTime();

			// Crea un modelo con la fecha y establece el formato para que no muestre las
			// horas
			SpinnerDateModel model = new SpinnerDateModel();
			model.setValue(date);
			spFechaInicio.setModel(model);

			// Establece el formato de la fecha para que no muestre las horas
			JSpinner.DateEditor editor = new JSpinner.DateEditor(spFechaInicio, "dd-MM-yyyy");
			spFechaInicio.setEditor(editor);
			
			spFechaInicio.addChangeListener(new ChangeListener() {
			    public void stateChanged(ChangeEvent e) {
			    	service.deseleccionadHorarioSemanal();
			    }
			});
		}
		return spFechaInicio;
	}

	private JPanel getPnBotonesHorariosSemanales() {
		if (pnBotonesHorariosSemanales == null) {
			pnBotonesHorariosSemanales = new JPanel();
			pnBotonesHorariosSemanales.setLayout(new GridLayout(0, 2, 0, 0));
			pnBotonesHorariosSemanales.add(getBtnAddHorarioSemanal());
			pnBotonesHorariosSemanales.add(getBtnBorrarHorarioSemanal());
		}
		return pnBotonesHorariosSemanales;
	}

	private JButton getBtnBorrarHorarioSemanal() {
		if (btnBorrarHorarioSemanal == null) {
			btnBorrarHorarioSemanal = new JButton("Borra Horario");
			btnBorrarHorarioSemanal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					borrarHorarioSemanal();
				}
			});
			btnBorrarHorarioSemanal.setBackground(new Color(211, 211, 211));
		}
		return btnBorrarHorarioSemanal;
	}

	private void borrarHorarioSemanal() {
		service.borrarHorarioSemanalSeleccionado();
		loadSemanalListModel();
	}

	private JPanel getPnDiaSemana1() {
		if (pnDiaSemana1 == null) {
			pnDiaSemana1 = new JPanel();
			pnDiaSemana1.setLayout(new BorderLayout(0, 0));
			pnDiaSemana1.add(getPnNorteDiaSemana(), BorderLayout.SOUTH);
		}
		return pnDiaSemana1;
	}

	private JPanel getPnBtnPuntual() {
		if (pnBtnPuntual == null) {
			pnBtnPuntual = new JPanel();
			pnBtnPuntual.setLayout(new BorderLayout(0, 0));
			pnBtnPuntual.add(getPnBotonesHorariosPuntual());
			pnBtnPuntual.add(getBtnAddFranjaPuntual(), BorderLayout.NORTH);
		}
		return pnBtnPuntual;
	}

	private JPanel getPnBotonesHorariosPuntual() {
		if (pnBotonesHorariosPuntual == null) {
			pnBotonesHorariosPuntual = new JPanel();
			pnBotonesHorariosPuntual.setLayout(new GridLayout(0, 2, 0, 0));
			pnBotonesHorariosPuntual.add(getBtnAddHorarioPuntual());
			pnBotonesHorariosPuntual.add(getBtnRemoveHorarioPuntual());
		}
		return pnBotonesHorariosPuntual;
	}

	private JButton getBtnAddHorarioPuntual() {
		if (btnAddHorarioPuntual == null) {
			btnAddHorarioPuntual = new JButton("Añade Horario");
			btnAddHorarioPuntual.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addHorarioPuntual();
				}
			});
			btnAddHorarioPuntual.setBackground(new Color(211, 211, 211));
		}
		return btnAddHorarioPuntual;
	}

	private JButton getBtnRemoveHorarioPuntual() {
		if (btnRemoveHorarioPuntual == null) {
			btnRemoveHorarioPuntual = new JButton("Borra Horario");
			btnRemoveHorarioPuntual.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					borraHorarioPuntual();
				}
			});
			btnRemoveHorarioPuntual.setBackground(new Color(211, 211, 211));
		}
		return btnRemoveHorarioPuntual;
	}

	private void borraHorarioPuntual() {
		service.borrarHorarioPuntualSeleccionado();
		loadPuntualListModel();
	}

	private JButton getBtnAddFranjaPuntual() {
		if (btnAddFranjaPuntual == null) {
			btnAddFranjaPuntual = new JButton("Añade Franja");
			btnAddFranjaPuntual.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addToHorarioPuntual();
				}
			});
			btnAddFranjaPuntual.setBackground(new Color(211, 211, 211));
		}
		return btnAddFranjaPuntual;
	}

	private void addHorarioPuntual() {
		service.addHorarioPuntual((Date) getSpFechaPuntual().getValue());
		loadPuntualListModel();
	}

	private void addToHorarioPuntual() {
		int res = service.addToHorarioPuntual((Date) getSpHoraInicioPuntual().getValue(),
				(Date) getSpHoraFinPuntual().getValue(), (Date) getSpFechaPuntual().getValue());
		
		if (res == 2) {
			// FIN ANTES QUE PRINCIPIO
			JOptionPane.showMessageDialog(null, "Error: La hora de finalización es anterior a la hora de inicio.", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else if (res == 3) {
			// SOLAPA ENTRE FRANJAS
			JOptionPane.showMessageDialog(null, "Error: Solapamiento entre franjas horarias.", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else if (res == 4) {
			// SOBREPASADO LIMITE DIARIO
			JOptionPane.showMessageDialog(null, "Error: Se ha sobrepasado el límite diario.", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else if (res == 5) {
			// SOBREPASADO LIMITE SEMANAL
			JOptionPane.showMessageDialog(null, "Error: Se ha sobrepasado el límite semanal.", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		loadPuntualListModel();
	}

	private JPanel getPnFechaPuntual1() {
		if (pnFechaPuntual1 == null) {
			pnFechaPuntual1 = new JPanel();
			pnFechaPuntual1.setLayout(new BorderLayout(0, 0));
			pnFechaPuntual1.add(getPnFechaPuntual2(), BorderLayout.SOUTH);
		}
		return pnFechaPuntual1;
	}

	private JPanel getPnFranjasPuntuales() {
		if (pnFranjasPuntuales == null) {
			pnFranjasPuntuales = new JPanel();
			pnFranjasPuntuales.setLayout(new GridLayout(0, 2, 0, 0));
			pnFranjasPuntuales.add(getPnHoraInicioPuntual());
			pnFranjasPuntuales.add(getPnHoraFinPuntual());
		}
		return pnFranjasPuntuales;
	}

	private JPanel getPnFechaPuntual2() {
		if (pnFechaPuntual2 == null) {
			pnFechaPuntual2 = new JPanel();
			pnFechaPuntual2.setLayout(new BorderLayout(0, 0));
			pnFechaPuntual2.add(getPnFechaPuntual3(), BorderLayout.EAST);
		}
		return pnFechaPuntual2;
	}

	private JLabel getLbHoraInicioPuntual() {
		if (lbHoraInicioPuntual == null) {
			lbHoraInicioPuntual = new JLabel("Hora Inicio:");
		}
		return lbHoraInicioPuntual;
	}

	private JSpinner getSpHoraInicioPuntual() {
		if (spHoraInicioPuntual == null) {
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.HOUR_OF_DAY, 9);
			calendar.set(Calendar.MINUTE, 0);
			Date date = calendar.getTime();
			SpinnerDateModel sm = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
			spHoraInicioPuntual = new JSpinner(sm);
			spHoraInicioPuntual.setFont(new Font("Tahoma", Font.PLAIN, 16));
			JSpinner.DateEditor de = new JSpinner.DateEditor(spHoraInicioPuntual, "HH:mm");
			spHoraInicioPuntual.setEditor(de);
		}
		return spHoraInicioPuntual;
	}

	private JPanel getPnHoraInicioPuntual() {
		if (pnHoraInicioPuntual == null) {
			pnHoraInicioPuntual = new JPanel();
			pnHoraInicioPuntual.setBorder(new EmptyBorder(5, 5, 5, 5));
			pnHoraInicioPuntual.setLayout(new GridLayout(0, 1, 0, 0));
			pnHoraInicioPuntual.add(getLbHoraInicioPuntual());
			pnHoraInicioPuntual.add(getSpHoraInicioPuntual());
		}
		return pnHoraInicioPuntual;
	}

	private JPanel getPnHoraFinPuntual() {
		if (pnHoraFinPuntual == null) {
			pnHoraFinPuntual = new JPanel();
			pnHoraFinPuntual.setBorder(new EmptyBorder(5, 5, 5, 5));
			pnHoraFinPuntual.setLayout(new GridLayout(0, 1, 0, 0));
			pnHoraFinPuntual.add(getLbHoraFinPuntual());
			pnHoraFinPuntual.add(getSpHoraFinPuntual());
		}
		return pnHoraFinPuntual;
	}

	private JLabel getLbHoraFinPuntual() {
		if (lbHoraFinPuntual == null) {
			lbHoraFinPuntual = new JLabel("Hora Fin:");
		}
		return lbHoraFinPuntual;
	}

	private JSpinner getSpHoraFinPuntual() {
		if (spHoraFinPuntual == null) {
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.HOUR_OF_DAY, 17);
			calendar.set(Calendar.MINUTE, 0);
			Date date = calendar.getTime();
			SpinnerDateModel sm = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
			spHoraFinPuntual = new JSpinner(sm);
			spHoraFinPuntual.setFont(new Font("Tahoma", Font.PLAIN, 16));
			JSpinner.DateEditor de = new JSpinner.DateEditor(spHoraFinPuntual, "HH:mm");
			spHoraFinPuntual.setEditor(de);
		}
		return spHoraFinPuntual;
	}

	private JPanel getPnFechaPuntual3() {
		if (pnFechaPuntual3 == null) {
			pnFechaPuntual3 = new JPanel();
			pnFechaPuntual3.add(getLbFechaPuntual());
			pnFechaPuntual3.add(getSpFechaPuntual());
		}
		return pnFechaPuntual3;
	}
}
