package ips2023pl21.ui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ips2023pl21.model.activos.Instalaciones;
import ips2023pl21.model.horarios.FranjaReservas;
import ips2023pl21.service.Service21913;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.time.DateTimeException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frame21913 extends JFrame {

	private static final long serialVersionUID = 1L;
	private Service21913 cs;
	private JPanel contentPane;
	private JPanel pnTitulo;
	private JPanel pnCentral;
	private JLabel lbTitulo;
	private JPanel pnSeleccionFranja;
	private JPanel pnIntroduccionDatos;
	private JPanel pnFecha;
	private JPanel pnFranja;
	private JLabel lbFecha;
	private JPanel pnDia;
	private JPanel pnMes;
	private JPanel pnAño;
	private JPanel pnBuscar;
	private JLabel lbDia;
	private JComboBox<Integer> cbDia;
	private JLabel lbMes;
	private JComboBox<Integer> cbMes;
	private JLabel lbAño;
	private JComboBox<Integer> cbAño;
	private JButton btBuscar;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lbFranja;
	private JPanel pnLbFranjas;
	private JLabel lbFechaFranja;
	private JPanel pnAvanzar;
	private JButton btAvanzar;
	private JScrollPane scrFranjas;
	private JList<String> listFranjas;
	private DefaultListModel<String> modelListFranjas;
	private JPanel pnBotones;
	private JButton btConfirmar;
	private JButton btVolver;
	private JPanel pnFormulario;
	private JPanel pnDatosPersonales;
	private JPanel pnHoras;
	private JLabel lbDatos;
	private JPanel pnNombre;
	private JPanel pnTarjeta;
	private JPanel pnPrecio;
	private JLabel lbNombre;
	private JTextField txNombre;
	private JLabel lbTarjeta;
	private JTextField txTarjeta;
	private JLabel lbPrecio;
	private JTextField txPrecio;
	private JPanel pnHoraEntrada;
	private JPanel pnHoraSalida;
	private JPanel pnEtiquetas;
	private JLabel lbIntroducirHoras;
	private JLabel lbFranjaHoraria;
	private JLabel lbHoraEntrada;
	private JComboBox<Integer> cbHoraEntrada;
	private JLabel lbPuntos;
	private JComboBox<Integer> cbMinutoEntrada;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lbHoraSalida;
	private JComboBox<Integer> cbHoraSalida;
	private JComboBox<Integer> cbMinutoSalida;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JPanel pnCampo;
	private JLabel lbCampo;
	private JComboBox<String> cbCampos;
	private JPanel panel_3;

	/**
	 * Create the frame.
	 */
	public Frame21913(Service21913 cs) {
		this.cs = cs;
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				confirmarSalida();
			}
		});
		setTitle("Reserva de las instalaciones deportivas");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 750, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPnTitulo(), BorderLayout.NORTH);
		contentPane.add(getPnCentral(), BorderLayout.CENTER);
	}
	private void confirmarSalida() {
		int respuesta = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea cerrar la aplicación?");
		if (respuesta == JOptionPane.YES_OPTION) {
			dispose();
		}
	}

	private JPanel getPnTitulo() {
		if (pnTitulo == null) {
			pnTitulo = new JPanel();
			pnTitulo.add(getLbTitulo());
		}
		return pnTitulo;
	}
	private JPanel getPnCentral() {
		if (pnCentral == null) {
			pnCentral = new JPanel();
			pnCentral.setLayout(new CardLayout(0, 0));
			pnCentral.add(getPnSeleccionFranja(), "pnSeleccionFranja");
			pnCentral.add(getPnIntroduccionDatos(), "pnIntroduccionDatos");
		}
		return pnCentral;
	}
	private JLabel getLbTitulo() {
		if (lbTitulo == null) {
			lbTitulo = new JLabel("Reserva de las instalciones");
			lbTitulo.setForeground(new Color(0, 0, 0));
			lbTitulo.setFont(new Font("Tahoma", Font.BOLD, 45));
		}
		return lbTitulo;
	}
	private JPanel getPnSeleccionFranja() {
		if (pnSeleccionFranja == null) {
			pnSeleccionFranja = new JPanel();
			pnSeleccionFranja.setLayout(new GridLayout(0, 2, 0, 0));
			pnSeleccionFranja.add(getPnFecha());
			pnSeleccionFranja.add(getPnFranja());
		}
		return pnSeleccionFranja;
	}
	private JPanel getPnIntroduccionDatos() {
		if (pnIntroduccionDatos == null) {
			pnIntroduccionDatos = new JPanel();
			pnIntroduccionDatos.setLayout(new BorderLayout(0, 0));
			pnIntroduccionDatos.add(getPnBotones(), BorderLayout.SOUTH);
			pnIntroduccionDatos.add(getPnFormulario(), BorderLayout.CENTER);
		}
		return pnIntroduccionDatos;
	}
	private JPanel getPnFecha() {
		if (pnFecha == null) {
			pnFecha = new JPanel();
			pnFecha.setLayout(new GridLayout(6, 1, 0, 0));
			pnFecha.add(getLbFecha());
			pnFecha.add(getPnDia());
			pnFecha.add(getPnMes());
			pnFecha.add(getPnAño());
			pnFecha.add(getPnCampo());
			pnFecha.add(getPnBuscar());
		}
		return pnFecha;
	}
	private JPanel getPnFranja() {
		if (pnFranja == null) {
			pnFranja = new JPanel();
			pnFranja.setLayout(new BorderLayout(0, 0));
			pnFranja.add(getPnLbFranjas(), BorderLayout.NORTH);
			pnFranja.add(getPnAvanzar(), BorderLayout.SOUTH);
			pnFranja.add(getScrFranjas(), BorderLayout.CENTER);
		}
		return pnFranja;
	}
	private JLabel getLbFecha() {
		if (lbFecha == null) {
			lbFecha = new JLabel("Introduzca la datos de la reserva:");
			lbFecha.setForeground(new Color(0, 0, 0));
			lbFecha.setFont(new Font("Tahoma", Font.PLAIN, 22));
		}
		return lbFecha;
	}
	private JPanel getPnDia() {
		if (pnDia == null) {
			pnDia = new JPanel();
			pnDia.setLayout(new GridLayout(2, 2, 0, 0));
			pnDia.add(getLbDia());
			pnDia.add(getCbDia());
			pnDia.add(getPanel());
		}
		return pnDia;
	}
	private JPanel getPnMes() {
		if (pnMes == null) {
			pnMes = new JPanel();
			pnMes.setLayout(new GridLayout(2, 2, 0, 0));
			pnMes.add(getLbMes());
			pnMes.add(getCbMes());
			pnMes.add(getPanel_1());
		}
		return pnMes;
	}
	private JPanel getPnAño() {
		if (pnAño == null) {
			pnAño = new JPanel();
			pnAño.setLayout(new GridLayout(2, 2, 0, 0));
			pnAño.add(getLbAño());
			pnAño.add(getCbAño());
			pnAño.add(getPanel_2());
		}
		return pnAño;
	}
	private JPanel getPnBuscar() {
		if (pnBuscar == null) {
			pnBuscar = new JPanel();
			pnBuscar.setLayout(new FlowLayout());
			pnBuscar.add(getBtBuscar(), BorderLayout.SOUTH);
		}
		return pnBuscar;
	}
	private JLabel getLbDia() {
		if (lbDia == null) {
			lbDia = new JLabel("Día:");
			lbDia.setForeground(new Color(0, 0, 0));
			lbDia.setHorizontalAlignment(SwingConstants.CENTER);
			lbDia.setFont(new Font("Tahoma", Font.PLAIN, 22));
		}
		return lbDia;
	}
	private JComboBox<Integer> getCbDia() {
		if (cbDia == null) {
			cbDia = new JComboBox<Integer>();
			cbDia.setForeground(new Color(0, 0, 0));
			cbDia.setFont(new Font("Tahoma", Font.PLAIN, 18));
			for (int i=1; i<32;i++) {
				cbDia.addItem(i);
			}
		}
		return cbDia;
	}
	private JLabel getLbMes() {
		if (lbMes == null) {
			lbMes = new JLabel("Mes:");
			lbMes.setHorizontalAlignment(SwingConstants.CENTER);
			lbMes.setForeground(new Color(0, 0, 0));
			lbMes.setFont(new Font("Tahoma", Font.PLAIN, 22));
		}
		return lbMes;
	}
	private JComboBox<Integer> getCbMes() {
		if (cbMes == null) {
			cbMes = new JComboBox<Integer>();
			cbMes.setForeground(new Color(0, 0, 0));
			cbMes.setFont(new Font("Tahoma", Font.PLAIN, 18));
			for (int i=1; i<=12;i++) {
				cbMes.addItem(i);
			}
		}
		return cbMes;
	}
	private JLabel getLbAño() {
		if (lbAño == null) {
			lbAño = new JLabel("Año:");
			lbAño.setHorizontalAlignment(SwingConstants.CENTER);
			lbAño.setForeground(new Color(0, 0, 0));
			lbAño.setFont(new Font("Tahoma", Font.PLAIN, 22));
		}
		return lbAño;
	}
	private JComboBox<Integer> getCbAño() {
		if (cbAño == null) {
			cbAño = new JComboBox<Integer>();
			cbAño.setForeground(new Color(0, 0, 0));
			cbAño.setFont(new Font("Tahoma", Font.PLAIN, 18));
			cbAño.addItem(2023);
			cbAño.addItem(2024);
		}
		return cbAño;
	}
	private JButton getBtBuscar() {
		if (btBuscar == null) {
			btBuscar = new JButton("Buscar");
			btBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (isFechaValida()) {
						getBtAvanzar().setEnabled(true);
						cargarInstalacionSeleccionada();
						cargarFechaSeleccionada();
						cargarHorariosEquipos();
						cargarReservas();
						cargarHorasOcupadas();
						cargarFranjasHorarias();
						getLbFechaFranja().setText(cs.getFechaSeleccionada());
						rellenarFranjasHorarias();
					}
					else {
						getLbFechaFranja().setText("");
						JOptionPane.showMessageDialog(null, 
								"La fecha introducida no es válida. "
								+ "Revise si ha introducido una fehca correcta.");
					}
				}
			});
			btBuscar.setAlignmentX(Component.CENTER_ALIGNMENT);
			btBuscar.setBackground(new Color(30, 144, 255));
			btBuscar.setForeground(new Color(0, 0, 0));
			btBuscar.setFont(new Font("Tahoma", Font.PLAIN, 22));
		}
		return btBuscar;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
		}
		return panel;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
		}
		return panel_1;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
		}
		return panel_2;
	}
	private JPanel getPnLbFranjas() {
		if (pnLbFranjas == null) {
			pnLbFranjas = new JPanel();
			pnLbFranjas.setLayout(new GridLayout(0, 1, 0, 0));
			pnLbFranjas.add(getLbFranja_1());
			pnLbFranjas.add(getLbFechaFranja());
		}
		return pnLbFranjas;
	}
	private JLabel getLbFranja_1() {
		if (lbFranja == null) {
			lbFranja = new JLabel("Franjas de horas libres para el día:");
			lbFranja.setHorizontalAlignment(SwingConstants.CENTER);
			lbFranja.setForeground(Color.BLACK);
			lbFranja.setFont(new Font("Tahoma", Font.PLAIN, 23));
		}
		return lbFranja;
	}
	private JLabel getLbFechaFranja() {
		if (lbFechaFranja == null) {
			lbFechaFranja = new JLabel("");
			lbFechaFranja.setForeground(new Color(0, 0, 255));
			lbFechaFranja.setFont(new Font("Tahoma", Font.PLAIN, 25));
			lbFechaFranja.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lbFechaFranja;
	}
	private JPanel getPnAvanzar() {
		if (pnAvanzar == null) {
			pnAvanzar = new JPanel();
			pnAvanzar.add(getBtAvanzar());
		}
		return pnAvanzar;
	}
	private JButton getBtAvanzar() {
		if (btAvanzar == null) {
			btAvanzar = new JButton("Avanzar");
			btAvanzar.setEnabled(false);
			btAvanzar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (getListFranjas().getSelectedValue() == null) {
						JOptionPane.showMessageDialog(null, 
								"No se ha seleccionado ninguna franja horaria.");
					}
					else if(getListFranjas().getSelectedValue().contains("Ocupadas: ")) {
						JOptionPane.showMessageDialog(null, 
								"La franja seleccionada esta ocupada.");
					}
					else {
						mostrarPnIntroduccionDatos();
						getLbFranjaHoraria().setText(getListFranjas().getSelectedValue());
						cs.marcarFranjaSeleccionada(getListFranjas().getSelectedValue());
					}
					
				}
			});
			btAvanzar.setBackground(new Color(0, 128, 0));
			btAvanzar.setForeground(new Color(0, 0, 0));
			btAvanzar.setFont(new Font("Tahoma", Font.PLAIN, 22));
		}
		return btAvanzar;
	}
	private JScrollPane getScrFranjas() {
		if (scrFranjas == null) {
			scrFranjas = new JScrollPane();
			scrFranjas.setViewportView(getListFranjas());
		}
		return scrFranjas;
	}
	private JList<String> getListFranjas(){
		if (listFranjas == null) {
			modelListFranjas = new DefaultListModel<String>();
			listFranjas = new JList<String>(modelListFranjas);
			listFranjas.setFont(new Font("Tahoma", Font.PLAIN, 20));
			listFranjas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return listFranjas;
	}
	private JPanel getPnBotones() {
		if (pnBotones == null) {
			pnBotones = new JPanel();
			pnBotones.add(getBtConfirmar());
			pnBotones.add(getBtVolver());
		}
		return pnBotones;
	}
	private JButton getBtConfirmar() {
		if (btConfirmar == null) {
			btConfirmar = new JButton("Confirmar");
			btConfirmar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (textosVacios()) {
						JOptionPane.showMessageDialog(null, 
							"Compruebe que los textos de nombre y tarjeta bancaria no están vacíos");
					}
					else if(horaSeleccionadaFueraRango()) {
						JOptionPane.showMessageDialog(null, 
								"La hora seleccionada es inválida. "
								+ "Compruebe que las horas son correctas y están dentro de la franja seleccionada.");
					}
					else {
						String nombre = getTxNombre().getText();
						String tarjeta = getTxTarjeta().getText();
						String precio = getTxPrecio().getText();
						int horaEntrada = (int) getCbHoraEntrada().getSelectedItem();
						int minutoEntrada = (int) getCbMinutoEntrada().getSelectedItem();
						int horaSalida = (int) getCbHoraSalida().getSelectedItem();
						int minutoSalida = (int) getCbMinutoSalida().getSelectedItem();
						int respuesta = JOptionPane.showConfirmDialog(null, 
						"¿Está seguro de que quiere hacer una reserva a nombre de "+ 
						nombre + "?");
						
						if (respuesta == JOptionPane.YES_OPTION) {
							cs.cargarReserva(nombre,tarjeta,precio,horaEntrada,horaSalida,minutoEntrada,minutoSalida);
							mostrarPnSeleccionFranja();
						}
					}
				}
			});
			btConfirmar.setBackground(new Color(0, 128, 0));
			btConfirmar.setForeground(new Color(0, 0, 0));
			btConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		return btConfirmar;
	}
	private JButton getBtVolver() {
		if (btVolver == null) {
			btVolver = new JButton("Volver");
			btVolver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPnSeleccionFranja();
				}
			});
			btVolver.setBackground(new Color(255, 0, 0));
			btVolver.setForeground(new Color(0, 0, 0));
			btVolver.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		return btVolver;
	}
	private JPanel getPnFormulario() {
		if (pnFormulario == null) {
			pnFormulario = new JPanel();
			pnFormulario.setLayout(new GridLayout(1, 2, 0, 0));
			pnFormulario.add(getPnDatosPersonales());
			pnFormulario.add(getPnHoras());
		}
		return pnFormulario;
	}
	private JPanel getPnDatosPersonales() {
		if (pnDatosPersonales == null) {
			pnDatosPersonales = new JPanel();
			pnDatosPersonales.setLayout(new GridLayout(4, 1, 0, 0));
			pnDatosPersonales.add(getLbDatos());
			pnDatosPersonales.add(getPnNombre());
			pnDatosPersonales.add(getPnTarjeta());
			pnDatosPersonales.add(getPnPrecio());
		}
		return pnDatosPersonales;
	}
	private JPanel getPnHoras() {
		if (pnHoras == null) {
			pnHoras = new JPanel();
			pnHoras.setLayout(new GridLayout(3, 1, 0, 0));
			pnHoras.add(getPnEtiquetas());
			pnHoras.add(getPnHoraEntrada());
			pnHoras.add(getPnHoraSalida());
		}
		return pnHoras;
	}
	private JLabel getLbDatos() {
		if (lbDatos == null) {
			lbDatos = new JLabel("Introduzca los datos de la reserva:");
			lbDatos.setForeground(new Color(0, 0, 0));
			lbDatos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		return lbDatos;
	}
	private JPanel getPnNombre() {
		if (pnNombre == null) {
			pnNombre = new JPanel();
			pnNombre.add(getLbNombre());
			pnNombre.add(getTxNombre());
		}
		return pnNombre;
	}
	private JPanel getPnTarjeta() {
		if (pnTarjeta == null) {
			pnTarjeta = new JPanel();
			pnTarjeta.add(getLbTarjeta());
			pnTarjeta.add(getTxTarjeta());
		}
		return pnTarjeta;
	}
	private JPanel getPnPrecio() {
		if (pnPrecio == null) {
			pnPrecio = new JPanel();
			pnPrecio.add(getLbPrecio());
			pnPrecio.add(getTxPrecio());
		}
		return pnPrecio;
	}
	private JLabel getLbNombre() {
		if (lbNombre == null) {
			lbNombre = new JLabel("Nombre:");
			lbNombre.setForeground(new Color(0, 0, 0));
			lbNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		return lbNombre;
	}
	private JTextField getTxNombre() {
		if (txNombre == null) {
			txNombre = new JTextField();
			txNombre.setHorizontalAlignment(SwingConstants.CENTER);
			txNombre.setForeground(new Color(0, 0, 0));
			txNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
			txNombre.setColumns(10);
		}
		return txNombre;
	}
	private JLabel getLbTarjeta() {
		if (lbTarjeta == null) {
			lbTarjeta = new JLabel("Número de tarjeta:");
			lbTarjeta.setForeground(new Color(0, 0, 0));
			lbTarjeta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		return lbTarjeta;
	}
	private JTextField getTxTarjeta() {
		if (txTarjeta == null) {
			txTarjeta = new JTextField();
			txTarjeta.setHorizontalAlignment(SwingConstants.CENTER);
			txTarjeta.setFont(new Font("Tahoma", Font.PLAIN, 20));
			txTarjeta.setForeground(new Color(0, 0, 0));
			txTarjeta.setColumns(10);
		}
		return txTarjeta;
	}
	private JLabel getLbPrecio() {
		if (lbPrecio == null) {
			lbPrecio = new JLabel("Precio:");
			lbPrecio.setForeground(new Color(0, 0, 0));
			lbPrecio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		return lbPrecio;
	}
	private JTextField getTxPrecio() {
		if (txPrecio == null) {
			txPrecio = new JTextField();
			txPrecio.setHorizontalAlignment(SwingConstants.CENTER);
			txPrecio.setText("50");
			txPrecio.setEditable(false);
			txPrecio.setForeground(new Color(0, 0, 0));
			txPrecio.setFont(new Font("Tahoma", Font.PLAIN, 20));
			txPrecio.setColumns(10);
		}
		return txPrecio;
	}
	private JPanel getPnHoraEntrada() {
		if (pnHoraEntrada == null) {
			pnHoraEntrada = new JPanel();
			pnHoraEntrada.setLayout(new GridLayout(2, 4, 0, 0));
			pnHoraEntrada.add(getLbHoraEntrada());
			pnHoraEntrada.add(getCbHoraEntrada());
			pnHoraEntrada.add(getLbPuntos());
			pnHoraEntrada.add(getCbMinutoEntrada());
			pnHoraEntrada.add(getLblNewLabel_2());
			pnHoraEntrada.add(getLblNewLabel_3());
			pnHoraEntrada.add(getLblNewLabel_4());
		}
		return pnHoraEntrada;
	}
	private JPanel getPnHoraSalida() {
		if (pnHoraSalida == null) {
			pnHoraSalida = new JPanel();
			pnHoraSalida.setLayout(new GridLayout(2, 4, 0, 0));
			pnHoraSalida.add(getLbHoraSalida());
			pnHoraSalida.add(getCbHoraSalida());
			pnHoraSalida.add(getLblNewLabel());
			pnHoraSalida.add(getCbMinutoSalida());
			pnHoraSalida.add(getLblNewLabel_1());
			pnHoraSalida.add(getLblNewLabel_5());
			pnHoraSalida.add(getLblNewLabel_6());
		}
		return pnHoraSalida;
	}
	private JPanel getPnEtiquetas() {
		if (pnEtiquetas == null) {
			pnEtiquetas = new JPanel();
			pnEtiquetas.setLayout(new GridLayout(2, 1, 0, 0));
			pnEtiquetas.add(getLbIntroducirHoras());
			pnEtiquetas.add(getLbFranjaHoraria());
		}
		return pnEtiquetas;
	}
	private JLabel getLbIntroducirHoras() {
		if (lbIntroducirHoras == null) {
			lbIntroducirHoras = new JLabel("Introduzca unas horas en la franja:");
			lbIntroducirHoras.setHorizontalAlignment(SwingConstants.CENTER);
			lbIntroducirHoras.setForeground(new Color(0, 0, 0));
			lbIntroducirHoras.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		return lbIntroducirHoras;
	}
	private JLabel getLbFranjaHoraria() {
		if (lbFranjaHoraria == null) {
			lbFranjaHoraria = new JLabel("");
			lbFranjaHoraria.setForeground(new Color(0, 0, 255));
			lbFranjaHoraria.setFont(new Font("Tahoma", Font.PLAIN, 24));
			lbFranjaHoraria.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lbFranjaHoraria;
	}
	private JLabel getLbHoraEntrada() {
		if (lbHoraEntrada == null) {
			lbHoraEntrada = new JLabel("Entrada:");
			lbHoraEntrada.setHorizontalAlignment(SwingConstants.CENTER);
			lbHoraEntrada.setForeground(new Color(0, 0, 0));
			lbHoraEntrada.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lbHoraEntrada;
	}
	private JComboBox<Integer> getCbHoraEntrada() {
		if (cbHoraEntrada == null) {
			cbHoraEntrada = new JComboBox<Integer>();
			cbHoraEntrada.setFont(new Font("Tahoma", Font.PLAIN, 18));
			for (int i=8;i<22;i++) {
				cbHoraEntrada.addItem(i);
			}
		}
		return cbHoraEntrada;
	}
	private JLabel getLbPuntos() {
		if (lbPuntos == null) {
			lbPuntos = new JLabel(":");
			lbPuntos.setForeground(new Color(0, 0, 0));
			lbPuntos.setHorizontalAlignment(SwingConstants.CENTER);
			lbPuntos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lbPuntos;
	}
	private JComboBox<Integer> getCbMinutoEntrada() {
		if (cbMinutoEntrada == null) {
			cbMinutoEntrada = new JComboBox<Integer>();
			cbMinutoEntrada.setFont(new Font("Tahoma", Font.PLAIN, 18));
			for (int i=0; i<60;i++) {
				cbMinutoEntrada.addItem(i);
			}
		}
		return cbMinutoEntrada;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("");
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("");
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("");
		}
		return lblNewLabel_4;
	}
	private JLabel getLbHoraSalida() {
		if (lbHoraSalida == null) {
			lbHoraSalida = new JLabel("Salida:");
			lbHoraSalida.setHorizontalAlignment(SwingConstants.CENTER);
			lbHoraSalida.setForeground(new Color(0, 0, 0));
			lbHoraSalida.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lbHoraSalida;
	}
	private JComboBox<Integer> getCbHoraSalida() {
		if (cbHoraSalida == null) {
			cbHoraSalida = new JComboBox<Integer>();
			cbHoraSalida.setFont(new Font("Tahoma", Font.PLAIN, 18));
			for (int i=9; i<23; i++) {
				cbHoraSalida.addItem(i);
			}
		}
		return cbHoraSalida;
	}
	private JComboBox<Integer> getCbMinutoSalida() {
		if (cbMinutoSalida == null) {
			cbMinutoSalida = new JComboBox<Integer>();
			cbMinutoSalida.setFont(new Font("Tahoma", Font.PLAIN, 18));
			for (int i=0; i<60;i++) {
				cbMinutoSalida.addItem(i);
			}
		}
		return cbMinutoSalida;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel(":");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("");
		}
		return lblNewLabel_5;
	}
	private JLabel getLblNewLabel_6() {
		if (lblNewLabel_6 == null) {
			lblNewLabel_6 = new JLabel("");
		}
		return lblNewLabel_6;
	}
	private void mostrarPnIntroduccionDatos() {
		((CardLayout) getPnCentral().getLayout()).show(getPnCentral(), "pnIntroduccionDatos");
	}
	private boolean isFechaValida() {
		LocalDateTime fechaBuscar;
		int year = (int) getCbAño().getSelectedItem();
		int month = (int) getCbMes().getSelectedItem();
		int day = (int) getCbDia().getSelectedItem();
		try {
			//A partir de las 21 horas del mismo dia ya no deja reservar.
			//Porque solo se puede reservar hasta las 10 de la noche.
			fechaBuscar = LocalDateTime.of(year, month, day, 21, 0);
		}catch(DateTimeException e) {
			return false;
		}
		
		if (cs.getFechaActual().isBefore(fechaBuscar)) {
			return true;
		}
		return false;
	}
	private void cargarFechaSeleccionada() {
		String year = String.valueOf(getCbAño().getSelectedItem());
		String month = String.valueOf(getCbMes().getSelectedItem());
		String day = String.valueOf(getCbDia().getSelectedItem());
		
		try {
			cs.cargarFechaSeleccioanda(year, month, day);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Ha habido un problema con la fecha introducida.");
		}
	}
	private void cargarHorariosEquipos() {
		cs.cargarHorariosEquipos();
	}
	private void cargarReservas() {
		cs.cargarReservas();
	}
	private void cargarHorasOcupadas() {
		cs.cargarHorasOcupadas();
	}
	private void cargarFranjasHorarias() {
		cs.getFranjasHorarias().clear();
		cs.horarioInstalaciones();
	}
	private void mostrarPnSeleccionFranja() {
		((CardLayout) getPnCentral().getLayout()).show(getPnCentral(), "pnSeleccionFranja");
		reiniciarPaneles();
	}
	private void rellenarFranjasHorarias() {
		modelListFranjas.removeAllElements();
		Map<String, Color> colorMap = new HashMap<>();
		for (Map.Entry<FranjaReservas, Boolean> f : cs.getFranjasHorarias().entrySet()) {
			String str = f.getKey().toString();
			Color color = null;
			if  (f.getValue()) {
				color = Color.GREEN;
			}
			else {
				color = Color.RED;
			}
			colorMap.put(str, color);
		}
		
		for(Map.Entry<FranjaReservas, Boolean> f : cs.getFranjasHorarias().entrySet()) {
			modelListFranjas.addElement(f.getKey().toString());
		}
		
		getListFranjas().setCellRenderer(new CustomListCellRenderer(colorMap));
		
	}
	private void reiniciarPaneles() {
		modelListFranjas.removeAllElements();
		getLbFechaFranja().setText("");
		getCbAño().setSelectedIndex(0);
		getCbMes().setSelectedIndex(0);
		getCbDia().setSelectedIndex(0);
		getCbHoraEntrada().setSelectedIndex(0);
		getCbMinutoEntrada().setSelectedIndex(0);
		getCbHoraSalida().setSelectedIndex(0);
		getCbMinutoSalida().setSelectedIndex(0);
		getBtAvanzar().setEnabled(false);
		getTxNombre().setText("");
		getTxTarjeta().setText("");
	}
	
	private boolean textosVacios() {
		if (getTxNombre().getText().isBlank() || getTxTarjeta().getText().isBlank()) {
			return true;
		}
		return false;
		
	}
	
	private boolean horaSeleccionadaFueraRango() {
		//Fecha seleccionada
		int y = cs.getFranjaSeleccionada().getInicio().getYear();
		int m = cs.getFranjaSeleccionada().getInicio().getMonthValue();
		int d = cs.getFranjaSeleccionada().getInicio().getDayOfMonth();
		LocalDate date = LocalDate.of(y, m, d);
		
		//Horas entrada y salida
		int horaEntrada = (int) getCbHoraEntrada().getSelectedItem();
		int minutoEntrada = (int) getCbMinutoEntrada().getSelectedItem();
		LocalTime e = LocalTime.of(horaEntrada, minutoEntrada);
		LocalDateTime entrada = LocalDateTime.of(date, e);
		
		int horaSalida = (int) getCbHoraSalida().getSelectedItem();
		int minutoSalida = (int) getCbMinutoSalida().getSelectedItem();
		LocalTime s = LocalTime.of(horaSalida, minutoSalida);
		LocalDateTime salida = LocalDateTime.of(date, s);
		
		//Comprobaciones
		if (salida.isBefore(entrada)) {
			return true;
		}
		else if(entrada.isBefore(cs.getFranjaSeleccionada().getInicio()) || 
				salida.isAfter(cs.getFranjaSeleccionada().getFin())){
			return true;
		}
		else if (entrada.isBefore(LocalDateTime.now())) {
			return true;
		}
		else if (Duration.between(entrada, salida).toMinutes() < 60 ) {
			return true;
		}
		return false;
	}
	
	private class CustomListCellRenderer implements ListCellRenderer<String> {
	    private final DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();
	    private Map<String, Color> colorMap;

	    public CustomListCellRenderer(Map<String, Color> colorMap) {
	        this.colorMap = colorMap;
	    }

		@Override
		public Component getListCellRendererComponent(JList<? extends String> list, String value, int index, boolean isSelected, boolean cellHasFocus) {
		JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        Color customColor = colorMap.get(value);

        if (customColor != null) {
            renderer.setForeground(customColor);
        }

        return renderer;
		}
	}
	private JPanel getPnCampo() {
		if (pnCampo == null) {
			pnCampo = new JPanel();
			pnCampo.setLayout(new GridLayout(2, 2, 0, 0));
			pnCampo.add(getLbCampo());
			pnCampo.add(getCbCampos());
			pnCampo.add(getPanel_3());
		}
		return pnCampo;
	}
	private JLabel getLbCampo() {
		if (lbCampo == null) {
			lbCampo = new JLabel("Campo:");
			lbCampo.setForeground(new Color(0, 0, 0));
			lbCampo.setHorizontalAlignment(SwingConstants.CENTER);
			lbCampo.setFont(new Font("Tahoma", Font.PLAIN, 22));
		}
		return lbCampo;
	}
	private JComboBox<String> getCbCampos() {
		if (cbCampos == null) {
			cbCampos = new JComboBox<String>();
			cbCampos.setFont(new Font("Tahoma", Font.PLAIN, 18));
			for (Instalaciones s : cs.cargarInstalaciones()) {
				cbCampos.addItem(s.getNombreInstalacion());
			}
		}
		return cbCampos;
	}
	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
		}
		return panel_3;
	}
	private void cargarInstalacionSeleccionada() {
		cs.cargarInstalacionSeleccionada(getCbCampos().getSelectedItem().toString());
	}
}
