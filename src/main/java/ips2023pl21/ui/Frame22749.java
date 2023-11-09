package ips2023pl21.ui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import ips2023pl21.service.Service22748_9;
import ips2023pl21.service.Service22748_9.CapitalFase;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frame22749 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Service22748_9 cs;
	private JLabel lbAmpliacionesDeCapital;
	private JPanel pnCentro;
	private JPanel pnInfo;
	private JPanel pnFase;
	private JPanel pnBlanco1;
	private JPanel pnAccionesVendidas;
	private JPanel pnCapital;
	private JPanel pnBlanco2;
	private JPanel pnAccionesRestantes;
	private JLabel lbFaseActual;
	private JLabel lbFaseInfo;
	private JLabel lbCapital;
	private JLabel lbCapitalInfo;
	private JLabel lbAccionesVendidas;
	private JLabel lbAccionesVendidasInfo;
	private JLabel lbAccionesRestantes;
	private JLabel lbAccionesRestantesInfo;
	private JPanel pnDatos;
	private JPanel pnWest;
	private JLabel lbVacia;
	private JPanel pnEast;
	private JLabel lbVacia_1;
	private JLabel lbIntroduccionDatos;
	private JPanel pnTexto;
	private JPanel pnValorAmpliacion;
	private JTextField txAcciones;
	private JLabel lbAmpliacion;
	private JLabel lbValorAmpliacion;
	private JPanel pnIniciar;
	private JPanel pnAvanzarFase;
	private JPanel pnBotonInciar;
	private JButton btInciar;
	private JPanel pnBotonesFase;
	private JPanel pnTxCambiarFase;
	private JPanel pnBlanco3;
	private JLabel lbCambiarFase;
	private JButton btAvanzar;
	private JButton btFinalizar;

	
	public Frame22749(Service22748_9 cs) {
		setTitle("Ampliaciones de capital");
		this.cs = cs;
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				confirmarSalida();
			}
		});
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 996, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setMinimumSize(getSize());
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getLbAmpliacionesDeCapital(), BorderLayout.NORTH);
		contentPane.add(getPnCentro(), BorderLayout.CENTER);
		if (cs.getFase() != CapitalFase.FUERA_FASE) {
			mostrarPnAvanzarFase();
			actualizacionBotones();
		}
	}
	
	private void confirmarSalida() {
		int respuesta = JOptionPane.showConfirmDialog(this, 
				"¿Está seguro de que quiere cerrar la panalla de ampliaciones de capital?");
		if (respuesta == JOptionPane.YES_OPTION) {
			dispose();
		}
	}

	private JLabel getLbAmpliacionesDeCapital() {
		if (lbAmpliacionesDeCapital == null) {
			lbAmpliacionesDeCapital = new JLabel("Ampliaciones de capital");
			lbAmpliacionesDeCapital.setForeground(new Color(0, 0, 0));
			lbAmpliacionesDeCapital.setHorizontalAlignment(SwingConstants.CENTER);
			lbAmpliacionesDeCapital.setFont(new Font("Tahoma", Font.BOLD, 45));
		}
		return lbAmpliacionesDeCapital;
	}
	private JPanel getPnCentro() {
		if (pnCentro == null) {
			pnCentro = new JPanel();
			pnCentro.setLayout(new BorderLayout(0, 0));
			pnCentro.add(getPnInfo(), BorderLayout.NORTH);
			pnCentro.add(getPnDatos(), BorderLayout.CENTER);
			pnCentro.add(getPnWest(), BorderLayout.WEST);
			pnCentro.add(getPnEast(), BorderLayout.EAST);
		}
		return pnCentro;
	}
	private JPanel getPnInfo() {
		if (pnInfo == null) {
			pnInfo = new JPanel();
			pnInfo.setLayout(new GridLayout(2, 3, 0, 0));
			pnInfo.add(getPnFase());
			pnInfo.add(getPnBlanco1());
			pnInfo.add(getPnAccionesVendidas());
			pnInfo.add(getPnCapital());
			pnInfo.add(getPnBlanco2());
			pnInfo.add(getPnAccionesRestantes());
		}
		return pnInfo;
	}
	private JPanel getPnFase() {
		if (pnFase == null) {
			pnFase = new JPanel();
			pnFase.setLayout(new GridLayout(1, 2, 0, 0));
			pnFase.add(getLbFaseActual());
			pnFase.add(getLbFaseInfo());
		}
		return pnFase;
	}
	private JPanel getPnBlanco1() {
		if (pnBlanco1 == null) {
			pnBlanco1 = new JPanel();
		}
		return pnBlanco1;
	}
	private JPanel getPnAccionesVendidas() {
		if (pnAccionesVendidas == null) {
			pnAccionesVendidas = new JPanel();
			pnAccionesVendidas.setLayout(new GridLayout(0, 2, 0, 0));
			pnAccionesVendidas.add(getLbAccionesVendidas());
			pnAccionesVendidas.add(getLbAccionesVendidasInfo());
		}
		return pnAccionesVendidas;
	}
	private JPanel getPnCapital() {
		if (pnCapital == null) {
			pnCapital = new JPanel();
			pnCapital.setLayout(new GridLayout(1, 2, 0, 0));
			pnCapital.add(getLbCapital());
			pnCapital.add(getLbCapitalInfo());
		}
		return pnCapital;
	}
	private JPanel getPnBlanco2() {
		if (pnBlanco2 == null) {
			pnBlanco2 = new JPanel();
		}
		return pnBlanco2;
	}
	private JPanel getPnAccionesRestantes() {
		if (pnAccionesRestantes == null) {
			pnAccionesRestantes = new JPanel();
			pnAccionesRestantes.setLayout(new GridLayout(0, 2, 0, 0));
			pnAccionesRestantes.add(getLbAccionesRestantes());
			pnAccionesRestantes.add(getLbAccionesRestantesInfo());
		}
		return pnAccionesRestantes;
	}
	private JLabel getLbFaseActual() {
		if (lbFaseActual == null) {
			lbFaseActual = new JLabel("Fase actual: ");
			lbFaseActual.setForeground(new Color(0, 0, 0));
			lbFaseActual.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lbFaseActual;
	}
	private JLabel getLbFaseInfo() {
		if (lbFaseInfo == null) {
			lbFaseInfo = new JLabel("");
			lbFaseInfo.setForeground(new Color(0, 0, 0));
			lbFaseInfo.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lbFaseInfo.setText(textoFase());
		}
		return lbFaseInfo;
	}
	private JLabel getLbCapital() {
		if (lbCapital == null) {
			lbCapital = new JLabel("Capital total: ");
			lbCapital.setForeground(new Color(0, 0, 0));
			lbCapital.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lbCapital;
	}
	private JLabel getLbCapitalInfo() {
		if (lbCapitalInfo == null) {
			lbCapitalInfo = new JLabel("");
			lbCapitalInfo.setForeground(new Color(0, 0, 0));
			lbCapitalInfo.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lbCapitalInfo.setText(cs.getCapitalClub() +" €");
		}
		return lbCapitalInfo;
	}
	private JLabel getLbAccionesVendidas() {
		if (lbAccionesVendidas == null) {
			lbAccionesVendidas = new JLabel("Acciones vendidas: ");
			lbAccionesVendidas.setHorizontalAlignment(SwingConstants.CENTER);
			lbAccionesVendidas.setForeground(new Color(0, 0, 0));
			lbAccionesVendidas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lbAccionesVendidas;
	}
	private JLabel getLbAccionesVendidasInfo() {
		if (lbAccionesVendidasInfo == null) {
			lbAccionesVendidasInfo = new JLabel("");
			lbAccionesVendidasInfo.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lbAccionesVendidasInfo.setText(textoAccionesVendidas());
		}
		return lbAccionesVendidasInfo;
	}
	private JLabel getLbAccionesRestantes() {
		if (lbAccionesRestantes == null) {
			lbAccionesRestantes = new JLabel("Acciones restantes: ");
			lbAccionesRestantes.setForeground(new Color(0, 0, 0));
			lbAccionesRestantes.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lbAccionesRestantes.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lbAccionesRestantes;
	}
	private JLabel getLbAccionesRestantesInfo() {
		if (lbAccionesRestantesInfo == null) {
			lbAccionesRestantesInfo = new JLabel("");
			lbAccionesRestantesInfo.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lbAccionesRestantesInfo.setText(textoAccionesRestantes());
		}
		return lbAccionesRestantesInfo;
	}
	private String textoFase() {
		if(cs.getFase() == CapitalFase.FUERA_FASE) {
			return "Fuera de fase";
		}
		else if (cs.getFase() == CapitalFase.FASE1) {
			return "FASE 1";
		}
		else if (cs.getFase() == CapitalFase.FASE2) {
			return "FASE 2";
		}
		else {
			return "FASE 3";
		}
	}
	private String textoAccionesVendidas() {
		if(cs.getFase() == CapitalFase.FUERA_FASE) {
			return "-";
		}
		return String.valueOf(cs.getAccionesVendidas());
	}
	private String textoAccionesRestantes() {
		if(cs.getFase() == CapitalFase.FUERA_FASE) {
			return "-";
		}
		return String.valueOf(cs.getAccionesRestantes());
	}
	private void iniciarAmpliacion() {
		cs.setFase(CapitalFase.FASE1);
		getLbFaseInfo().setText(textoFase());
		getLbAccionesVendidasInfo().setText(textoAccionesVendidas());
		getLbAccionesRestantesInfo().setText(textoAccionesRestantes());
	}
	private void avanzarFase() {
		if (cs.getFase() == CapitalFase.FASE1) {
			cs.setFase(CapitalFase.FASE2);
			getLbFaseInfo().setText(textoFase());
		}
		else {
			cs.setFase(CapitalFase.FASE3);
			getLbFaseInfo().setText(textoFase());
		}
	}
	private void actualizacionBotones() {
		if(cs.getFase() == CapitalFase.FUERA_FASE) {
			getBtIniciar().setEnabled(true);
			getBtAvanzar().setEnabled(false);
			getBtFinalizar().setEnabled(false);
		}
		else if (cs.getFase() == CapitalFase.FASE1 || cs.getFase() == CapitalFase.FASE2) {
			getBtAvanzar().setEnabled(true);
			getBtIniciar().setEnabled(false);
			getBtFinalizar().setEnabled(false);
		}
		else {
			getBtIniciar().setEnabled(false);
			getBtAvanzar().setEnabled(false);
			getBtFinalizar().setEnabled(true);
		}
	}
	private void finalizarAmpliacion() {
		cs.setFase(CapitalFase.FUERA_FASE);
		getLbFaseInfo().setText(textoFase());
	}
	private boolean confirmarInicio() {
		int respuesta = JOptionPane.showConfirmDialog(null, 
				"¿Está seguro de que quiere inciar una ampliación de capital "
				+ "con " + getTxAcciones().getText()+" acciones nuevas?");
		if (respuesta == JOptionPane.YES_OPTION) {
			return true;
		}
		return false;
	}
	private boolean confirmarAvance() {
		int respuesta = JOptionPane.showConfirmDialog(null, 
				"¿Está seguro de que quiere cambiar de fase?");
		if (respuesta == JOptionPane.YES_OPTION) {
			return true;
		}
		return false;
	}
	private boolean confirmarFinalizacion() {
		int respuesta = JOptionPane.showConfirmDialog(null, 
				"¿Está seguro de que quiere finalizar la ampliación de capital?");
		if (respuesta == JOptionPane.YES_OPTION) {
			return true;
		}
		return false;
	}
	private JPanel getPnDatos() {
		if (pnDatos == null) {
			pnDatos = new JPanel();
			pnDatos.setLayout(new CardLayout(0, 0));
			pnDatos.add(getPnIniciar(), "pnIniciar");
			pnDatos.add(getPnAvanzarFase(), "pnAvanzarFase");
		}
		return pnDatos;
	}
	private JPanel getPnWest() {
		if (pnWest == null) {
			pnWest = new JPanel();
			pnWest.add(getLbVacia());
		}
		return pnWest;
	}
	private JLabel getLbVacia() {
		if (lbVacia == null) {
			lbVacia = new JLabel("                           ");
		}
		return lbVacia;
	}
	private JPanel getPnEast() {
		if (pnEast == null) {
			pnEast = new JPanel();
			pnEast.add(getLbVacia_1());
		}
		return pnEast;
	}
	private JLabel getLbVacia_1() {
		if (lbVacia_1 == null) {
			lbVacia_1 = new JLabel("                           ");
		}
		return lbVacia_1;
	}
	private JLabel getLbIntroduccionDatos() {
		if (lbIntroduccionDatos == null) {
			lbIntroduccionDatos = new JLabel("Introduzca en número de acciones que quiere agregar al mercado:");
			lbIntroduccionDatos.setForeground(new Color(0, 0, 0));
			lbIntroduccionDatos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lbIntroduccionDatos;
	}
	private JPanel getPnTexto() {
		if (pnTexto == null) {
			pnTexto = new JPanel();
			pnTexto.add(getTxAcciones());
		}
		return pnTexto;
	}
	private JPanel getPnValorAmpliacion() {
		if (pnValorAmpliacion == null) {
			pnValorAmpliacion = new JPanel();
			pnValorAmpliacion.add(getLbAmpliacion());
			pnValorAmpliacion.add(getLbValorAmpliacion());
		}
		return pnValorAmpliacion;
	}
	private JTextField getTxAcciones() {
		if (txAcciones == null) {
			txAcciones = new JTextField();
			txAcciones.setForeground(new Color(0, 0, 0));
			txAcciones.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txAcciones.setColumns(10);
			txAcciones.getDocument().addDocumentListener(getDocumentListener());
		}
		return txAcciones;
	}
	private JLabel getLbAmpliacion() {
		if (lbAmpliacion == null) {
			lbAmpliacion = new JLabel("Ampliación de capital: ");
			lbAmpliacion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lbAmpliacion;
	}
	private JLabel getLbValorAmpliacion() {
		if (lbValorAmpliacion == null) {
			lbValorAmpliacion = new JLabel("- €");
			lbValorAmpliacion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lbValorAmpliacion;
	}
	private JPanel getPnIniciar() {
		if (pnIniciar == null) {
			pnIniciar = new JPanel();
			pnIniciar.setLayout(new GridLayout(4, 1, 0, 0));
			pnIniciar.add(getLbIntroduccionDatos());
			pnIniciar.add(getPnTexto());
			pnIniciar.add(getPnValorAmpliacion());
			pnIniciar.add(getPnBotonInciar());
		}
		return pnIniciar;
	}
	private JPanel getPnAvanzarFase() {
		if (pnAvanzarFase == null) {
			pnAvanzarFase = new JPanel();
			pnAvanzarFase.setLayout(new GridLayout(3, 1, 0, 0));
			pnAvanzarFase.add(getPnBlanco3());
			pnAvanzarFase.add(getPanel_1_1());
			pnAvanzarFase.add(getPanel_1());
		}
		return pnAvanzarFase;
	}
	private JPanel getPnBotonInciar() {
		if (pnBotonInciar == null) {
			pnBotonInciar = new JPanel();
			pnBotonInciar.add(getBtIniciar());
		}
		return pnBotonInciar;
	}
	private JButton getBtIniciar() {
		if (btInciar == null) {
			btInciar = new JButton("Iniciar ampliación");
			btInciar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (textoVacio() || textoCaracter()) {
						JOptionPane.showMessageDialog(null, "El número de acciones introducido no es válido");
					}
					else if (confirmarInicio()) {
						int rest = Integer.valueOf(getTxAcciones().getText());
						iniciarAmpliacion();
						insertarAmpliacion();
						actualizacionBotones();
						mostrarPnAvanzarFase();
						guardarLimiteFaseUno();
						cs.setAccionesRestantes(rest);
					}
				}
			});
			btInciar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return btInciar;
	}
	private JPanel getPanel_1() {
		if (pnBotonesFase == null) {
			pnBotonesFase = new JPanel();
			pnBotonesFase.add(getBtAvanzar());
			pnBotonesFase.add(getBtFinalizar());
		}
		return pnBotonesFase;
	}
	private JPanel getPanel_1_1() {
		if (pnTxCambiarFase == null) {
			pnTxCambiarFase = new JPanel();
			pnTxCambiarFase.setLayout(new GridLayout(0, 1, 0, 0));
			pnTxCambiarFase.add(getLbCambiarFase());
		}
		return pnTxCambiarFase;
	}
	private JPanel getPnBlanco3() {
		if (pnBlanco3 == null) {
			pnBlanco3 = new JPanel();
		}
		return pnBlanco3;
	}
	private JLabel getLbCambiarFase() {
		if (lbCambiarFase == null) {
			lbCambiarFase = new JLabel("Pulse el botón para avanzar de fase o finalizar:");
			lbCambiarFase.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		return lbCambiarFase;
	}
	private JButton getBtAvanzar() {
		if (btAvanzar == null) {
			btAvanzar = new JButton("Avanzar fase");
			btAvanzar.setForeground(new Color(0, 0, 0));
			btAvanzar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (confirmarAvance()) {
						avanzarFase();
						actualizacionBotones();
						actualizaVentas();
					}
				}
			});
			btAvanzar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return btAvanzar;
	}
	private JButton getBtFinalizar() {
		if (btFinalizar == null) {
			btFinalizar = new JButton("Finalizar ampliación");
			btFinalizar.setForeground(new Color(0, 0, 0));
			btFinalizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (confirmarFinalizacion()) {
						finalizarAmpliacion();
						mostrarPnIniciar();
						actualizacionBotones();
						actualizarAccionesVendidas();
					}
				}
			});
			btFinalizar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return btFinalizar;
	}
	private void mostrarPnAvanzarFase() {
		getTxAcciones().setText("");
		((CardLayout) getPnDatos().getLayout()).show(getPnDatos(), "pnAvanzarFase");
	}
	private void mostrarPnIniciar() {
		((CardLayout) getPnDatos().getLayout()).show(getPnDatos(), "pnIniciar");
	}
	private boolean textoVacio() {
		if (getTxAcciones().getText().isBlank()) {
			return true;
		}
		return false;
	}
	private boolean textoCaracter() {
		String acciones = getTxAcciones().getText();
		try {
			Integer.valueOf(acciones);
		} catch (NumberFormatException e) {
			return true;
		}
		return false;
	}
	
	private DocumentListener getDocumentListener() {
		DocumentListener dL = new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				updateLabel();
			}
			@Override
			public void removeUpdate(DocumentEvent e) {
				updateLabel();
			}
			@Override
			public void changedUpdate(DocumentEvent e) {
				updateLabel();
			}
			private void updateLabel() {
				if (!textoCaracter()) {
					int nAcciones = Integer.valueOf(getTxAcciones().getText());
					float ampliacion = nAcciones * cs.getPrecioPorAccion();
					getLbValorAmpliacion().setText(ampliacion + " €");
				}
				else if (textoVacio()) {
					getLbValorAmpliacion().setText("-" + " €");
				}
			}
		};
		return dL;
	}
	private void insertarAmpliacion() {
		int accionesNuevas = Integer.valueOf(getTxAcciones().getText());
		cs.insertarAmpliacion(accionesNuevas);
	}
	private void guardarLimiteFaseUno() {
		cs.guardarLimiteFaseUno();
	}
	private void actualizarAccionesVendidas() {
		cs.setAccionesVendidas(0);
		cs.setAccionesRestantes(0);
		getLbAccionesVendidasInfo().setText(textoAccionesVendidas());
		getLbAccionesRestantesInfo().setText(textoAccionesRestantes());
	}
	private void actualizaVentas() {
		getLbAccionesVendidasInfo().setText(textoAccionesVendidas());
		getLbAccionesRestantesInfo().setText(textoAccionesRestantes());
	}
}
