package ips2023pl21.ui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ips2023pl21.model.Usuario;
import ips2023pl21.model.acciones.Accion;
import ips2023pl21.model.acciones.Accionista;
import ips2023pl21.service.MainService;
import ips2023pl21.service.Service22748_9;
import ips2023pl21.service.Service22748_9.CapitalFase;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPasswordField;

public class Frame22748 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Service22748_9 cs;
	private JPanel pnCentro;
	private JLabel lbTitulo;
	private JPanel pnInicio;
	private JLabel lbId;
	private JPanel pnTxId;
	private JPanel pnVacio_1;
	private JPanel pnBotonesAcceso;
	private JLabel lbTxId;
	private JTextField txId;
	private JPanel pnVacio;
	private JPanel pnVacio_2;
	private JPanel pnVacio_3;
	private JPanel pnVacio_4;
	private JPanel pnVacio_5;
	private JButton btAcceder;
	private JButton btNuevoAccionista;
	private JPanel pnNuevoAccionista;
	private JPanel pnBotonesRegistro;
	private JPanel pnIntroducirDatos;
	private JPanel pnIntroducirNombre;
	private JPanel pnIntroducirApellido;
	private JPanel pnIntroducirDni;
	private JPanel pnIntroducirCuenta;
	private JButton btRegistrarse;
	private JButton btVolver;
	private JLabel lbIntroducirDatos;
	private JLabel lbIntroducirNombre;
	private JTextField txIntroducirNombre;
	private JLabel lbVacia;
	private JLabel lbVacia_1;
	private JLabel lbVacia_2;
	private JLabel lbIntroducirApellido;
	private JLabel lbVacia_3;
	private JLabel lbVacia_4;
	private JLabel lbVacia_5;
	private JLabel lbVacia_6;
	private JTextField txIntroducirApellido;
	private JLabel lbIntroducirDni;
	private JLabel lbVacia_7;
	private JLabel lbVacia_8;
	private JLabel lbVacia_9;
	private JTextField txIntroducirDni;
	private JLabel lbIntroducirCuenta;
	private JLabel lbVacia_10;
	private JLabel lbVacia_11;
	private JLabel lbVacia_12;
	private JTextField txIntroducirCuenta;
	private JPanel pnAcciones;
	private JPanel pnDatos;
	private JPanel pnDatosPersonales;
	private JPanel pnDatosAcciones;
	private JLabel lbNombre;
	private JLabel lbNombreInfo;
	private JLabel lbApellido;
	private JLabel lbApellidoInfo;
	private JLabel lbNAcciones;
	private JLabel lbNAccionesInfo;
	private JLabel lbPrecioPorAccion;
	private JLabel lbValorTotalAcciones;
	private JLabel lbPorcentajeTotal;
	private JLabel lbPrecioPorAccionInfo;
	private JLabel lbValorTotalAccionesInfo;
	private JLabel lbPorcentajeTotalInfo;
	private JPanel pnTablaAcciones;
	private JLabel lbMargen_1;
	private JLabel lbMargen;
	private JPanel pnBotonesCompraVenta;
	private JButton btComprar;
	private JButton btVender;
	private JPanel pnCompra;
	private JPanel pnVenta;
	private JLabel lbVentaAcciones;
	private JLabel lbMargen_3;
	private JLabel lblNewLabel_1;
	private JPanel pnBotonesVender;
	private JButton btAccionVender;
	private JButton btAccionVenderTodo;
	private JButton btCancelarVender;
	private JPanel pnCompraAccionistas;
	private JPanel pnCompraClub;
	private JLabel lbAccionesEnVenta;
	private JPanel pnTableCompra;
	private JLabel lbSeleccionarCompra;
	private JPanel pnBtCompraAccionistas;
	private JButton btAccionComprarAccionistas;
	private JButton btCancelarCompraAccionistas;
	private JLabel lbAmpliacionClub;
	private JPanel pnCompraAmpliacion;
	private JLabel lbAccionesRestantes;
	private JLabel lbSeleccionarCantidad;
	private JPanel pnNumeroAcciones;
	private JPanel pnBtCompraClub;
	private JButton btAccionComprarClub;
	private JButton btCancelarCompraClub;
	private JPanel pnValorAcciones;
	private JLabel lbValorAcciones;
	private JLabel lbValorAccionesInfo;
	private JLabel lbNumeroAcciones;
	private JComboBox<Integer> cbNumeroAcciones;
	private JScrollPane scrAcciones;
	private JTable tableAcciones;
	private DefaultTableModel tableModelAcciones = new DefaultTableModel(
			new String[][] {
			},
			new String[] {
				"ID", "Precio compra", "Precio venta", "Estado"
			}
		) {
			private static final long serialVersionUID = 1L;
	
			@Override
		    public boolean isCellEditable(int row, int column) {
		        return false;
	    }
	};
	private DefaultTableModel tableModelCompra = new DefaultTableModel(
			new String[][] {
			},
			new String[] {
				"ID", "ID vendedor", "Precio"
			}
		) {
			private static final long serialVersionUID = 1L;
	
			@Override
		    public boolean isCellEditable(int row, int column) {
		        return false;
	    }
	};
	private JScrollPane scrCompra;
	private JTable tableCompra;
	private JScrollPane scrollPane;
	private JTable tableVender;
	private DefaultTableModel tableModelVenta = new DefaultTableModel(
			new String[][] {
			},
			new String[] {
				"ID", "Precio compra", "Precio venta"
			}
		) {
			private static final long serialVersionUID = 1L;
	
			@Override
		    public boolean isCellEditable(int row, int column) {
		        return false;
	    }
	};
	private JPanel panel;
	private JLabel lbContrasena;
	private JPasswordField txContrasena;
	private JLabel lbVacia_13;
	private JLabel lbVacia_14;
	private JLabel lbVacia_15;
	
	public Frame22748(Service22748_9 cs, int id) {
		setTitle("Portal de accionistas");
		this.cs = cs;
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				confirmarSalida();
			}
		});
		setBounds(100, 100, 784, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPnCentro());
		contentPane.add(getLbTitulo(), BorderLayout.NORTH);
		this.setLocationRelativeTo(null);
		
		if (id == 0) {
			// Register
			mostrarPnNuevoAccionista();			
		}
		else {
			// Login
			mostrarPnAcciones();
			cargarDatosAccionista(id);
			rellenarTablaAcciones();			
		}
		
		
	}
	
	private void confirmarSalida() {
		int respuesta = JOptionPane.showConfirmDialog(this, 
				"¿Está seguro de que quiere cerrar el portal de accionistas?");
		if (respuesta == JOptionPane.YES_OPTION) {
			dispose();
		}
	}

	private JPanel getPnCentro() {
		if (pnCentro == null) {
			pnCentro = new JPanel();
			pnCentro.setLayout(new CardLayout(0, 0));
			pnCentro.add(getPnInicio(), "pnInicio");
			pnCentro.add(getPnNuevoAccionista(), "pnNuevoAccionista");
			pnCentro.add(getPnAcciones(), "pnAcciones");
			pnCentro.add(getPnCompra(), "pnCompra");
			pnCentro.add(getPnVenta(), "pnVenta");
		}
		return pnCentro;
	}
	private JLabel getLbTitulo() {
		if (lbTitulo == null) {
			lbTitulo = new JLabel("Portal de accionistas");
			lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lbTitulo.setFont(new Font("Tahoma", Font.BOLD, 40));
			lbTitulo.setForeground(new Color(0, 0, 0));
		}
		return lbTitulo;
	}
	private JPanel getPnInicio() {
		if (pnInicio == null) {
			pnInicio = new JPanel();
			pnInicio.setLayout(new GridLayout(4, 1, 0, 0));
			pnInicio.add(getLbId());
			pnInicio.add(getPnTxId());
			pnInicio.add(getPanel_1());
			pnInicio.add(getPanel_2());
		}
		return pnInicio;
	}
	private JLabel getLbId() {
		if (lbId == null) {
			lbId = new JLabel("Introduzca su ID de accionista:");
			lbId.setForeground(new Color(0, 0, 0));
			lbId.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lbId.setVerticalAlignment(SwingConstants.BOTTOM);
		}
		return lbId;
	}
	private JPanel getPnTxId() {
		if (pnTxId == null) {
			pnTxId = new JPanel();
			pnTxId.setLayout(new GridLayout(2, 3, 0, 0));
			pnTxId.add(getLbTxId());
			pnTxId.add(getTxId());
			pnTxId.add(getPanel_1_1());
			pnTxId.add(getPanel_2_1());
			pnTxId.add(getPnVacio_3());
			pnTxId.add(getPnVacio_4());
			pnTxId.add(getPnVacio_5());
		}
		return pnTxId;
	}
	private JPanel getPanel_1() {
		if (pnVacio_1 == null) {
			pnVacio_1 = new JPanel();
		}
		return pnVacio_1;
	}
	private JPanel getPanel_2() {
		if (pnBotonesAcceso == null) {
			pnBotonesAcceso = new JPanel();
			pnBotonesAcceso.add(getBtAcceder());
			pnBotonesAcceso.add(getBtNuevoAccionista());
		}
		return pnBotonesAcceso;
	}
	private JLabel getLbTxId() {
		if (lbTxId == null) {
			lbTxId = new JLabel("ID accionista:");
			lbTxId.setForeground(new Color(0, 0, 0));
			lbTxId.setHorizontalAlignment(SwingConstants.CENTER);
			lbTxId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lbTxId;
	}
	private JTextField getTxId() {
		if (txId == null) {
			txId = new JTextField();
			txId.setForeground(new Color(0, 0, 0));
			txId.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txId.setColumns(10);
		}
		return txId;
	}
	private JPanel getPanel_1_1() {
		if (pnVacio == null) {
			pnVacio = new JPanel();
		}
		return pnVacio;
	}
	private JPanel getPanel_2_1() {
		if (pnVacio_2 == null) {
			pnVacio_2 = new JPanel();
		}
		return pnVacio_2;
	}
	private JPanel getPnVacio_3() {
		if (pnVacio_3 == null) {
			pnVacio_3 = new JPanel();
		}
		return pnVacio_3;
	}
	private JPanel getPnVacio_4() {
		if (pnVacio_4 == null) {
			pnVacio_4 = new JPanel();
		}
		return pnVacio_4;
	}
	private JPanel getPnVacio_5() {
		if (pnVacio_5 == null) {
			pnVacio_5 = new JPanel();
		}
		return pnVacio_5;
	}
	private JButton getBtAcceder() {
		if (btAcceder == null) {
			btAcceder = new JButton("Acceder");
			btAcceder.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(existeAccionista()) {
						int id = Integer.valueOf(getTxId().getText());
						mostrarPnAcciones();
						cargarDatosAccionista(id);
						rellenarTablaAcciones();
					}
					else {
						JOptionPane.showMessageDialog(null, "El accionista no existe. "
								+ "Introduzca de nuevo su ID.");
					}
				}
			});
			btAcceder.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btAcceder.setForeground(new Color(0, 0, 0));
		}
		return btAcceder;
	}
	private JButton getBtNuevoAccionista() {
		if (btNuevoAccionista == null) {
			btNuevoAccionista = new JButton("Nuevo accionista");
			btNuevoAccionista.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (cs.getFase() != CapitalFase.FASE3) {
						JOptionPane.showMessageDialog(null, "Ahora mismo no se pueden "
								+ "añadir nuevos accionistas. Espere a que el club esté "
								+ "en su tercera fase de ampliaciones de capital");
					}
					else {
						mostrarPnNuevoAccionista();
					}
					
				}
			});
			btNuevoAccionista.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btNuevoAccionista.setForeground(new Color(0, 0, 0));
		}
		return btNuevoAccionista;
	}
	private JPanel getPnNuevoAccionista() {
		if (pnNuevoAccionista == null) {
			pnNuevoAccionista = new JPanel();
			pnNuevoAccionista.setLayout(new GridLayout(7, 1, 0, 0));
			pnNuevoAccionista.add(getPanel_1_2());
			pnNuevoAccionista.add(getPanel_2_2());
			pnNuevoAccionista.add(getPnIntroducirApellido());
			pnNuevoAccionista.add(getPnIntroducirDni());
			pnNuevoAccionista.add(getPnIntroducirCuenta());
			pnNuevoAccionista.add(getPanel());
			pnNuevoAccionista.add(getPnBotonesRegistro());
		}
		return pnNuevoAccionista;
	}
	private JPanel getPnBotonesRegistro() {
		if (pnBotonesRegistro == null) {
			pnBotonesRegistro = new JPanel();
			pnBotonesRegistro.add(getBtRegistrarse());
			pnBotonesRegistro.add(getBtVolver());
		}
		return pnBotonesRegistro;
	}
	private JPanel getPanel_1_2() {
		if (pnIntroducirDatos == null) {
			pnIntroducirDatos = new JPanel();
			pnIntroducirDatos.setLayout(new GridLayout(0, 1, 0, 0));
			pnIntroducirDatos.add(getLbIntroducirDatos());
		}
		return pnIntroducirDatos;
	}
	private JPanel getPanel_2_2() {
		if (pnIntroducirNombre == null) {
			pnIntroducirNombre = new JPanel();
			pnIntroducirNombre.setLayout(new GridLayout(0, 4, 0, 0));
			pnIntroducirNombre.add(getLbIntroducirNombre());
			pnIntroducirNombre.add(getTxIntroducirNombre());
			pnIntroducirNombre.add(getLbVacia());
			pnIntroducirNombre.add(getLbVacia_1());
			pnIntroducirNombre.add(getLbVacia_2());
		}
		return pnIntroducirNombre;
	}
	private JPanel getPnIntroducirApellido() {
		if (pnIntroducirApellido == null) {
			pnIntroducirApellido = new JPanel();
			pnIntroducirApellido.setLayout(new GridLayout(0, 4, 0, 0));
			pnIntroducirApellido.add(getLbIntroducirApellido());
			pnIntroducirApellido.add(getTxIntroducirApellido());
			pnIntroducirApellido.add(getLbVacia_3());
			pnIntroducirApellido.add(getLbVacia_4());
			pnIntroducirApellido.add(getLbVacia_5());
			pnIntroducirApellido.add(getLbVacia_6());
		}
		return pnIntroducirApellido;
	}
	private JPanel getPnIntroducirDni() {
		if (pnIntroducirDni == null) {
			pnIntroducirDni = new JPanel();
			pnIntroducirDni.setLayout(new GridLayout(0, 4, 0, 0));
			pnIntroducirDni.add(getLbIntroducirDni());
			pnIntroducirDni.add(getTxIntroducirDni());
			pnIntroducirDni.add(getLbVacia_7());
			pnIntroducirDni.add(getLbVacia_8());
			pnIntroducirDni.add(getLbVacia_9());
		}
		return pnIntroducirDni;
	}
	private JPanel getPnIntroducirCuenta() {
		if (pnIntroducirCuenta == null) {
			pnIntroducirCuenta = new JPanel();
			pnIntroducirCuenta.setLayout(new GridLayout(0, 4, 0, 0));
			pnIntroducirCuenta.add(getLbIntroducirCuenta());
			pnIntroducirCuenta.add(getTxIntroducirCuenta());
			pnIntroducirCuenta.add(getLbVacia_10());
			pnIntroducirCuenta.add(getLbVacia_11());
			pnIntroducirCuenta.add(getLbVacia_12());
		}
		return pnIntroducirCuenta;
	}
	private JButton getBtRegistrarse() {
		if (btRegistrarse == null) {
			btRegistrarse = new JButton("Registrarse y comprar");
			btRegistrarse.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (cs.getAccionesRestantes() == 0) {
						JOptionPane.showMessageDialog(null, "Lo sentimos, pero "
								+ "las acciones destinadas a la ampliación han sido agotadas");
						mostrarPnInicio();
					}
					else if(comprobarCampos()) {
						getBtAccionComprarClub().setEnabled(true);
						getBtCancelarCompraClub().setEnabled(true);
						añadirAccionista();
						mostrarPnCompra();
						getBtAccionComprarAccionistas().setEnabled(false);
						getBtCancelarCompraAccionistas().setEnabled(false);
						rellenarCamposCompra_NuevoAccionista();
					}
					else {
						JOptionPane.showMessageDialog(null, "Los valores introducidos "
								+ "no son correctos. Inténtelo de nuevo");
					}
				}
			});
			btRegistrarse.setForeground(new Color(0, 0, 0));
			btRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return btRegistrarse;
	}
	private JButton getBtVolver() {
		if (btVolver == null) {
			btVolver = new JButton("Volver");
			btVolver.setEnabled(false);
			btVolver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPnInicio();
				}
			});
			btVolver.setForeground(new Color(0, 0, 0));
			btVolver.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return btVolver;
	}
	private JLabel getLbIntroducirDatos() {
		if (lbIntroducirDatos == null) {
			lbIntroducirDatos = new JLabel("Introduzca sus datos personales:");
			lbIntroducirDatos.setForeground(new Color(0, 0, 0));
			lbIntroducirDatos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lbIntroducirDatos;
	}
	private JLabel getLbIntroducirNombre() {
		if (lbIntroducirNombre == null) {
			lbIntroducirNombre = new JLabel("Nombre:");
			lbIntroducirNombre.setForeground(new Color(0, 0, 0));
			lbIntroducirNombre.setHorizontalAlignment(SwingConstants.CENTER);
			lbIntroducirNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lbIntroducirNombre;
	}
	private JTextField getTxIntroducirNombre() {
		if (txIntroducirNombre == null) {
			txIntroducirNombre = new JTextField();
			txIntroducirNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txIntroducirNombre.setColumns(10);
		}
		return txIntroducirNombre;
	}
	private JLabel getLbVacia() {
		if (lbVacia == null) {
			lbVacia = new JLabel("");
		}
		return lbVacia;
	}
	private JLabel getLbVacia_1() {
		if (lbVacia_1 == null) {
			lbVacia_1 = new JLabel("");
		}
		return lbVacia_1;
	}
	private JLabel getLbVacia_2() {
		if (lbVacia_2 == null) {
			lbVacia_2 = new JLabel("");
		}
		return lbVacia_2;
	}
	private JLabel getLbIntroducirApellido() {
		if (lbIntroducirApellido == null) {
			lbIntroducirApellido = new JLabel("Apellido:");
			lbIntroducirApellido.setHorizontalAlignment(SwingConstants.CENTER);
			lbIntroducirApellido.setForeground(new Color(0, 0, 0));
			lbIntroducirApellido.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lbIntroducirApellido;
	}
	private JLabel getLbVacia_3() {
		if (lbVacia_3 == null) {
			lbVacia_3 = new JLabel("");
		}
		return lbVacia_3;
	}
	private JLabel getLbVacia_4() {
		if (lbVacia_4 == null) {
			lbVacia_4 = new JLabel("");
		}
		return lbVacia_4;
	}
	private JLabel getLbVacia_5() {
		if (lbVacia_5 == null) {
			lbVacia_5 = new JLabel("");
		}
		return lbVacia_5;
	}
	private JLabel getLbVacia_6() {
		if (lbVacia_6 == null) {
			lbVacia_6 = new JLabel("");
		}
		return lbVacia_6;
	}
	private JTextField getTxIntroducirApellido() {
		if (txIntroducirApellido == null) {
			txIntroducirApellido = new JTextField();
			txIntroducirApellido.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txIntroducirApellido.setColumns(10);
		}
		return txIntroducirApellido;
	}
	private JLabel getLbIntroducirDni() {
		if (lbIntroducirDni == null) {
			lbIntroducirDni = new JLabel("DNI:");
			lbIntroducirDni.setHorizontalAlignment(SwingConstants.CENTER);
			lbIntroducirDni.setForeground(new Color(0, 0, 0));
			lbIntroducirDni.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lbIntroducirDni;
	}
	private JLabel getLbVacia_7() {
		if (lbVacia_7 == null) {
			lbVacia_7 = new JLabel("");
		}
		return lbVacia_7;
	}
	private JLabel getLbVacia_8() {
		if (lbVacia_8 == null) {
			lbVacia_8 = new JLabel("");
		}
		return lbVacia_8;
	}
	private JLabel getLbVacia_9() {
		if (lbVacia_9 == null) {
			lbVacia_9 = new JLabel("");
		}
		return lbVacia_9;
	}
	private JTextField getTxIntroducirDni() {
		if (txIntroducirDni == null) {
			txIntroducirDni = new JTextField();
			txIntroducirDni.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txIntroducirDni.setColumns(10);
		}
		return txIntroducirDni;
	}
	private JLabel getLbIntroducirCuenta() {
		if (lbIntroducirCuenta == null) {
			lbIntroducirCuenta = new JLabel("Cuenta bancaria:");
			lbIntroducirCuenta.setHorizontalAlignment(SwingConstants.CENTER);
			lbIntroducirCuenta.setForeground(new Color(0, 0, 0));
			lbIntroducirCuenta.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lbIntroducirCuenta;
	}
	private JLabel getLbVacia_10() {
		if (lbVacia_10 == null) {
			lbVacia_10 = new JLabel("");
		}
		return lbVacia_10;
	}
	private JLabel getLbVacia_11() {
		if (lbVacia_11 == null) {
			lbVacia_11 = new JLabel("");
		}
		return lbVacia_11;
	}
	private JLabel getLbVacia_12() {
		if (lbVacia_12 == null) {
			lbVacia_12 = new JLabel("");
		}
		return lbVacia_12;
	}
	private JTextField getTxIntroducirCuenta() {
		if (txIntroducirCuenta == null) {
			txIntroducirCuenta = new JTextField();
			txIntroducirCuenta.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txIntroducirCuenta.setColumns(10);
		}
		return txIntroducirCuenta;
	}
	private JPanel getPnAcciones() {
		if (pnAcciones == null) {
			pnAcciones = new JPanel();
			pnAcciones.setLayout(new BorderLayout(0, 0));
			pnAcciones.add(getPnDatos(), BorderLayout.NORTH);
			pnAcciones.add(getPnTablaAcciones(), BorderLayout.CENTER);
			pnAcciones.add(getLbMargen_1(), BorderLayout.EAST);
			pnAcciones.add(getLbMargen(), BorderLayout.WEST);
			pnAcciones.add(getPnBotonesCompraVenta(), BorderLayout.SOUTH);
		}
		return pnAcciones;
	}
	private JPanel getPnDatos() {
		if (pnDatos == null) {
			pnDatos = new JPanel();
			pnDatos.setLayout(new GridLayout(1, 2, 0, 0));
			pnDatos.add(getPnDatosPersonales());
			pnDatos.add(getPanel_1_3());
		}
		return pnDatos;
	}
	private JPanel getPnDatosPersonales() {
		if (pnDatosPersonales == null) {
			pnDatosPersonales = new JPanel();
			pnDatosPersonales.setLayout(new GridLayout(0, 2, 0, 0));
			pnDatosPersonales.add(getLbNombre());
			pnDatosPersonales.add(getLbNombreInfo());
			pnDatosPersonales.add(getLbApellido());
			pnDatosPersonales.add(getLbApellidoInfo());
			pnDatosPersonales.add(getLbNAcciones());
			pnDatosPersonales.add(getLbNAccionesInfo());
		}
		return pnDatosPersonales;
	}
	private JPanel getPanel_1_3() {
		if (pnDatosAcciones == null) {
			pnDatosAcciones = new JPanel();
			pnDatosAcciones.setLayout(new GridLayout(3, 2, 0, 0));
			pnDatosAcciones.add(getLbPrecioPorAccion());
			pnDatosAcciones.add(getLbPrecioPorAccionInfo());
			pnDatosAcciones.add(getLbValorTotalAcciones());
			pnDatosAcciones.add(getLbValorTotalAccionesInfo());
			pnDatosAcciones.add(getLbPorcentajeTotal());
			pnDatosAcciones.add(getLbPorcentajeTotalInfo());
		}
		return pnDatosAcciones;
	}
	private JLabel getLbNombre() {
		if (lbNombre == null) {
			lbNombre = new JLabel("Nombre: ");
			lbNombre.setForeground(new Color(0, 0, 0));
			lbNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lbNombre;
	}
	private JLabel getLbNombreInfo() {
		if (lbNombreInfo == null) {
			lbNombreInfo = new JLabel("");
			lbNombreInfo.setForeground(new Color(0, 0, 0));
			lbNombreInfo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lbNombreInfo;
	}
	private JLabel getLbApellido() {
		if (lbApellido == null) {
			lbApellido = new JLabel("Apellido:");
			lbApellido.setForeground(new Color(0, 0, 0));
			lbApellido.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lbApellido;
	}
	private JLabel getLbApellidoInfo() {
		if (lbApellidoInfo == null) {
			lbApellidoInfo = new JLabel("");
			lbApellidoInfo.setForeground(new Color(0, 0, 0));
			lbApellidoInfo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lbApellidoInfo;
	}
	private JLabel getLbNAcciones() {
		if (lbNAcciones == null) {
			lbNAcciones = new JLabel("Acciones en posesión:");
			lbNAcciones.setForeground(new Color(0, 0, 0));
			lbNAcciones.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lbNAcciones;
	}
	private JLabel getLbNAccionesInfo() {
		if (lbNAccionesInfo == null) {
			lbNAccionesInfo = new JLabel("");
			lbNAccionesInfo.setForeground(new Color(0, 0, 0));
			lbNAccionesInfo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lbNAccionesInfo;
	}
	private JLabel getLbPrecioPorAccion() {
		if (lbPrecioPorAccion == null) {
			lbPrecioPorAccion = new JLabel("Precio/acción:");
			lbPrecioPorAccion.setForeground(Color.BLACK);
			lbPrecioPorAccion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lbPrecioPorAccion;
	}
	private JLabel getLbValorTotalAcciones() {
		if (lbValorTotalAcciones == null) {
			lbValorTotalAcciones = new JLabel("Valor total acciones: ");
			lbValorTotalAcciones.setForeground(Color.BLACK);
			lbValorTotalAcciones.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lbValorTotalAcciones;
	}
	private JLabel getLbPorcentajeTotal() {
		if (lbPorcentajeTotal == null) {
			lbPorcentajeTotal = new JLabel("% del total de acciones:");
			lbPorcentajeTotal.setForeground(Color.BLACK);
			lbPorcentajeTotal.setFont(new Font("Tahoma", Font.PLAIN, 17));
		}
		return lbPorcentajeTotal;
	}
	private JLabel getLbPrecioPorAccionInfo() {
		if (lbPrecioPorAccionInfo == null) {
			lbPrecioPorAccionInfo = new JLabel("");
			lbPrecioPorAccionInfo.setForeground(Color.BLACK);
			lbPrecioPorAccionInfo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lbPrecioPorAccionInfo;
	}
	private JLabel getLbValorTotalAccionesInfo() {
		if (lbValorTotalAccionesInfo == null) {
			lbValorTotalAccionesInfo = new JLabel("");
			lbValorTotalAccionesInfo.setForeground(Color.BLACK);
			lbValorTotalAccionesInfo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lbValorTotalAccionesInfo;
	}
	private JLabel getLbPorcentajeTotalInfo() {
		if (lbPorcentajeTotalInfo == null) {
			lbPorcentajeTotalInfo = new JLabel("");
			lbPorcentajeTotalInfo.setForeground(Color.BLACK);
			lbPorcentajeTotalInfo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lbPorcentajeTotalInfo;
	}
	private JPanel getPnTablaAcciones() {
		if (pnTablaAcciones == null) {
			pnTablaAcciones = new JPanel();
			pnTablaAcciones.setLayout(new BorderLayout(0, 0));
			pnTablaAcciones.add(getScrAcciones(), BorderLayout.CENTER);
		}
		return pnTablaAcciones;
	}
	private JLabel getLbMargen_1() {
		if (lbMargen_1 == null) {
			lbMargen_1 = new JLabel("                         ");
		}
		return lbMargen_1;
	}
	private JLabel getLbMargen() {
		if (lbMargen == null) {
			lbMargen = new JLabel("                         ");
		}
		return lbMargen;
	}
	private JPanel getPnBotonesCompraVenta() {
		if (pnBotonesCompraVenta == null) {
			pnBotonesCompraVenta = new JPanel();
			pnBotonesCompraVenta.add(getBtComprar());
			pnBotonesCompraVenta.add(getBtVender());
		}
		return pnBotonesCompraVenta;
	}
	private JButton getBtComprar() {
		if (btComprar == null) {
			btComprar = new JButton("Comprar");
			btComprar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (cs.getFase() == CapitalFase.FUERA_FASE) {
						getBtAccionComprarClub().setEnabled(false);
						getBtCancelarCompraClub().setEnabled(false);
						getLbAccionesRestantes().setText("Acciones disponibles de la ampliación: "+ cs.getAccionesRestantes());
						rellenarTablaCompraAcciones();
						mostrarPnCompra();
					}
					else if (cs.getFase() == CapitalFase.FASE1) {
						if (limiteFase1AccionistaActivo() == 0) {
							JOptionPane.showMessageDialog(null, "Ya ha llegado al limite máximo de acciones permitidas durante la Fase 1");
						}
						else {
							getBtAccionComprarClub().setEnabled(true);
							getBtCancelarCompraClub().setEnabled(true);
							getBtAccionComprarAccionistas().setEnabled(true);
							getBtCancelarCompraAccionistas().setEnabled(true);
							getLbAccionesRestantes().setText("Acciones disponibles de la ampliación: "+ cs.getAccionesRestantes());
							rellenarTablaCompraAcciones();
							establecerValorCb_Fase1();
							mostrarPnCompra();
						}
						
					}
					else {
						getBtAccionComprarClub().setEnabled(true);
						getBtCancelarCompraClub().setEnabled(true);
						getBtAccionComprarAccionistas().setEnabled(true);
						getBtCancelarCompraAccionistas().setEnabled(true);
						getLbAccionesRestantes().setText("Acciones disponibles de la ampliación: "+ cs.getAccionesRestantes());
						rellenarTablaCompraAcciones();
						establecerValorCb();
						mostrarPnCompra();
					}
				}
			});
			btComprar.setForeground(new Color(0, 0, 0));
			btComprar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return btComprar;
	}
	private JButton getBtVender() {
		if (btVender == null) {
			btVender = new JButton("Vender");
			btVender.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rellenarTablaVender();
					mostrarPnVenta();
				}
			});
			btVender.setForeground(new Color(0, 0, 0));
			btVender.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return btVender;
	}
	private JPanel getPnCompra() {
		if (pnCompra == null) {
			pnCompra = new JPanel();
			pnCompra.setLayout(new GridLayout(1, 2, 0, 0));
			pnCompra.add(getPnCompraAccionistas());
			pnCompra.add(getPnCompraClub());
		}
		return pnCompra;
	}
	private JPanel getPnVenta() {
		if (pnVenta == null) {
			pnVenta = new JPanel();
			pnVenta.setLayout(new BorderLayout(0, 0));
			pnVenta.add(getLbVentaAcciones(), BorderLayout.NORTH);
			pnVenta.add(getLbMargen_3(), BorderLayout.WEST);
			pnVenta.add(getLblNewLabel_1(), BorderLayout.EAST);
			pnVenta.add(getPnBotonesVender(), BorderLayout.SOUTH);
			pnVenta.add(getScrollPane(), BorderLayout.CENTER);
		}
		return pnVenta;
	}
	private JLabel getLbVentaAcciones() {
		if (lbVentaAcciones == null) {
			lbVentaAcciones = new JLabel("Seleccione las acciones que quiere poner en venta:");
			lbVentaAcciones.setForeground(new Color(0, 0, 0));
			lbVentaAcciones.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lbVentaAcciones;
	}
	private JLabel getLbMargen_3() {
		if (lbMargen_3 == null) {
			lbMargen_3 = new JLabel("                             ");
		}
		return lbMargen_3;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("                             ");
		}
		return lblNewLabel_1;
	}
	private JPanel getPnBotonesVender() {
		if (pnBotonesVender == null) {
			pnBotonesVender = new JPanel();
			pnBotonesVender.add(getBtAccionVender());
			pnBotonesVender.add(getBtAccionVenderTodo());
			pnBotonesVender.add(getBtCancelarVender());
		}
		return pnBotonesVender;
	}
	private JButton getBtAccionVender() {
		if (btAccionVender == null) {
			btAccionVender = new JButton("Vender");
			btAccionVender.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (getTableVender().getSelectedRowCount() ==0) {
						JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna acción para vender");
					}
					else if (comprobarVentaAcciones() == JOptionPane.YES_OPTION) {
						venderAccionesSeleccionadas();
						mostrarPnInicio();
					}
				}
			});
			btAccionVender.setForeground(new Color(0, 0, 0));
			btAccionVender.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return btAccionVender;
	}
	private JButton getBtAccionVenderTodo() {
		if (btAccionVenderTodo == null) {
			btAccionVenderTodo = new JButton("Vender todo");
			btAccionVenderTodo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (comprobarVentaTodasAcciones() == JOptionPane.YES_OPTION) {
						ponerEnVentaTodasAcciones();
						mostrarPnInicio();
					}
				}
			});
			btAccionVenderTodo.setForeground(new Color(0, 0, 0));
			btAccionVenderTodo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return btAccionVenderTodo;
	}
	private JButton getBtCancelarVender() {
		if (btCancelarVender == null) {
			btCancelarVender = new JButton("Cancelar");
			btCancelarVender.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPnAcciones();
				}
			});
			btCancelarVender.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return btCancelarVender;
	}
	private JPanel getPnCompraAccionistas() {
		if (pnCompraAccionistas == null) {
			pnCompraAccionistas = new JPanel();
			pnCompraAccionistas.setLayout(new BorderLayout(0, 0));
			pnCompraAccionistas.add(getLbAccionesEnVenta(), BorderLayout.NORTH);
			pnCompraAccionistas.add(getPnTableCompra(), BorderLayout.CENTER);
		}
		return pnCompraAccionistas;
	}
	private JPanel getPnCompraClub() {
		if (pnCompraClub == null) {
			pnCompraClub = new JPanel();
			pnCompraClub.setLayout(new BorderLayout(0, 0));
			pnCompraClub.add(getLbAmpliacionClub(), BorderLayout.NORTH);
			pnCompraClub.add(getPnCompraAmpliacion(), BorderLayout.CENTER);
		}
		return pnCompraClub;
	}
	private JLabel getLbAccionesEnVenta() {
		if (lbAccionesEnVenta == null) {
			lbAccionesEnVenta = new JLabel("Acciones en venta");
			lbAccionesEnVenta.setHorizontalAlignment(SwingConstants.CENTER);
			lbAccionesEnVenta.setForeground(new Color(0, 0, 0));
			lbAccionesEnVenta.setFont(new Font("Tahoma", Font.BOLD, 30));
		}
		return lbAccionesEnVenta;
	}
	private JPanel getPnTableCompra() {
		if (pnTableCompra == null) {
			pnTableCompra = new JPanel();
			pnTableCompra.setLayout(new BorderLayout(0, 0));
			pnTableCompra.add(getLbSeleccionarCompra(), BorderLayout.NORTH);
			pnTableCompra.add(getPnBtCompraAccionistas(), BorderLayout.SOUTH);
			pnTableCompra.add(getScrCompra(), BorderLayout.CENTER);
		}
		return pnTableCompra;
	}
	private JLabel getLbSeleccionarCompra() {
		if (lbSeleccionarCompra == null) {
			lbSeleccionarCompra = new JLabel("Seleccione las acciones que quiere comprar:");
			lbSeleccionarCompra.setForeground(new Color(0, 0, 0));
			lbSeleccionarCompra.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lbSeleccionarCompra;
	}
	private JPanel getPnBtCompraAccionistas() {
		if (pnBtCompraAccionistas == null) {
			pnBtCompraAccionistas = new JPanel();
			pnBtCompraAccionistas.add(getBtAccionComprarAccionistas());
			pnBtCompraAccionistas.add(getBtCancelarCompraAccionistas());
		}
		return pnBtCompraAccionistas;
	}
	private JButton getBtAccionComprarAccionistas() {
		if (btAccionComprarAccionistas == null) {
			btAccionComprarAccionistas = new JButton("Comprar");
			btAccionComprarAccionistas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (accionesSeleccionadas().size() == 0) {
						JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna accion.");
					}
					else if (comprobarCompra() == JOptionPane.YES_OPTION) {
						mostrarPnInicio();
						comprarAcciones();
						comprobarAccionistaACero();
					}
				}
			});
			btAccionComprarAccionistas.setForeground(new Color(0, 0, 0));
			btAccionComprarAccionistas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return btAccionComprarAccionistas;
	}
	private JButton getBtCancelarCompraAccionistas() {
		if (btCancelarCompraAccionistas == null) {
			btCancelarCompraAccionistas = new JButton("Cancelar");
			btCancelarCompraAccionistas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPnAcciones();
				}
			});
			btCancelarCompraAccionistas.setForeground(new Color(0, 0, 0));
			btCancelarCompraAccionistas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return btCancelarCompraAccionistas;
	}
	private JLabel getLbAmpliacionClub() {
		if (lbAmpliacionClub == null) {
			lbAmpliacionClub = new JLabel("Ampliación capital");
			lbAmpliacionClub.setForeground(new Color(0, 0, 0));
			lbAmpliacionClub.setFont(new Font("Tahoma", Font.BOLD, 30));
			lbAmpliacionClub.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lbAmpliacionClub;
	}
	private JPanel getPnCompraAmpliacion() {
		if (pnCompraAmpliacion == null) {
			pnCompraAmpliacion = new JPanel();
			pnCompraAmpliacion.setLayout(new GridLayout(5, 1, 0, 0));
			pnCompraAmpliacion.add(getLbAccionesRestantes());
			pnCompraAmpliacion.add(getLbSeleccionarCantidad());
			pnCompraAmpliacion.add(getPnNumeroAcciones());
			pnCompraAmpliacion.add(getPnValorAcciones());
			pnCompraAmpliacion.add(getPnBtCompraClub());
		}
		return pnCompraAmpliacion;
	}
	private JLabel getLbAccionesRestantes() {
		if (lbAccionesRestantes == null) {
			lbAccionesRestantes = new JLabel("Acciones restantes: ...");
			lbAccionesRestantes.setForeground(new Color(0, 0, 0));
			lbAccionesRestantes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lbAccionesRestantes;
	}
	private JLabel getLbSeleccionarCantidad() {
		if (lbSeleccionarCantidad == null) {
			lbSeleccionarCantidad = new JLabel("Seleccione las acciones que desea adquirir:");
			lbSeleccionarCantidad.setForeground(new Color(0, 0, 0));
			lbSeleccionarCantidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lbSeleccionarCantidad;
	}
	private JPanel getPnNumeroAcciones() {
		if (pnNumeroAcciones == null) {
			pnNumeroAcciones = new JPanel();
			pnNumeroAcciones.add(getLbNumeroAcciones());
			pnNumeroAcciones.add(getCbNumeroAcciones());
		}
		return pnNumeroAcciones;
	}
	private JPanel getPnBtCompraClub() {
		if (pnBtCompraClub == null) {
			pnBtCompraClub = new JPanel();
			pnBtCompraClub.add(getBtAccionComprarClub());
			pnBtCompraClub.add(getBtCancelarCompraClub());
		}
		return pnBtCompraClub;
	}
	private JButton getBtAccionComprarClub() {
		if (btAccionComprarClub == null) {
			btAccionComprarClub = new JButton("Comprar");
			btAccionComprarClub.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (cs.getFase() == CapitalFase.FASE1) {
						if (comprobarCompraClub() == JOptionPane.YES_OPTION) {
							actualizarAccionesRestantesYVendidas();
							creaAcciones();
							actualizaLimiteAccionista();
							actualizaAccionista();
							mostrarPnInicio();
						}
						
					}
					else if(cs.getFase() == CapitalFase.FASE2) {
						if (comprobarCompraClub() == JOptionPane.YES_OPTION) {
							actualizarAccionesRestantesYVendidas();
							creaAcciones();
							actualizaAccionista();
							mostrarPnInicio();
						}
					}
					else {
						if (comprobarCompraClub() == JOptionPane.YES_OPTION) {
							actualizarAccionesRestantesYVendidas();
							creaAcciones();
							actualizaAccionista();
							mostrarPnInicio();
						}
					}
				}
			});
			btAccionComprarClub.setForeground(new Color(0, 0, 0));
			btAccionComprarClub.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return btAccionComprarClub;
	}
	private JButton getBtCancelarCompraClub() {
		if (btCancelarCompraClub == null) {
			btCancelarCompraClub = new JButton("Cancelar");
			btCancelarCompraClub.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPnAcciones();
				}
			});
			btCancelarCompraClub.setForeground(new Color(0, 0, 0));
			btCancelarCompraClub.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return btCancelarCompraClub;
	}
	private JPanel getPnValorAcciones() {
		if (pnValorAcciones == null) {
			pnValorAcciones = new JPanel();
			pnValorAcciones.add(getLbValorAcciones());
			pnValorAcciones.add(getLbValorAccionesInfo());
		}
		return pnValorAcciones;
	}
	private JLabel getLbValorAcciones() {
		if (lbValorAcciones == null) {
			lbValorAcciones = new JLabel("El valor de las acciones seleccionadas: ");
			lbValorAcciones.setForeground(new Color(0, 0, 0));
			lbValorAcciones.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lbValorAcciones;
	}
	private JLabel getLbValorAccionesInfo() {
		if (lbValorAccionesInfo == null) {
			lbValorAccionesInfo = new JLabel("- €");
			lbValorAccionesInfo.setForeground(new Color(0, 0, 0));
			lbValorAccionesInfo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lbValorAccionesInfo;
	}
	private JLabel getLbNumeroAcciones() {
		if (lbNumeroAcciones == null) {
			lbNumeroAcciones = new JLabel("Número de acciones:");
			lbNumeroAcciones.setForeground(new Color(0, 0, 0));
			lbNumeroAcciones.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lbNumeroAcciones;
	}
	private JComboBox<Integer> getCbNumeroAcciones() {
		if (cbNumeroAcciones == null) {
			cbNumeroAcciones = new JComboBox<Integer>();
			cbNumeroAcciones.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					float valorCompra = cs.getPrecioPorAccion() * 
							(Integer) cbNumeroAcciones.getSelectedItem();
					getLbValorAccionesInfo().setText(valorCompra + " €");
				}
			});
			cbNumeroAcciones.setForeground(new Color(0, 0, 0));
			cbNumeroAcciones.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return cbNumeroAcciones;
	}
	private boolean existeAccionista() {
		int numeroAccionista;
		try {
			numeroAccionista = Integer.valueOf(getTxId().getText());
		} catch (NumberFormatException e) {
			return false;
		}
		if (getTxId().getText().isBlank()) {
			return false;
		}
		else if (cs.existeAccionista(numeroAccionista)) {
			return true;
		}
		return false;
	}
	private void mostrarPnAcciones() {
		getTxId().setText("");
		((CardLayout) getPnCentro().getLayout()).show(getPnCentro(), "pnAcciones");
	}
	public void mostrarPnNuevoAccionista() {
		getTxId().setText("");
		((CardLayout) getPnCentro().getLayout()).show(getPnCentro(), "pnNuevoAccionista");
	}
	private void mostrarPnInicio() {
		getTxIntroducirNombre().setText("");
		getTxIntroducirApellido().setText("");
		getTxIntroducirDni().setText("");
		getTxIntroducirCuenta().setText("");
		((CardLayout) getPnCentro().getLayout()).show(getPnCentro(), "pnInicio");
	}
	private void mostrarPnCompra() {
		getTxIntroducirNombre().setText("");
		getTxIntroducirApellido().setText("");
		getTxIntroducirDni().setText("");
		getTxIntroducirCuenta().setText("");
		((CardLayout) getPnCentro().getLayout()).show(getPnCentro(), "pnCompra");
	}
	private boolean comprobarCampos() {
		if (getTxIntroducirNombre().getText().isBlank() || getTxIntroducirApellido().getText().isBlank() ||
				getTxIntroducirDni().getText().isBlank() || getTxIntroducirCuenta().getText().isBlank() ||
				new String(getTxContrasena().getPassword()).isBlank()){
			return false;
		}
		else if(comprobarExistePersona()) {
			return false;
		}
		return true;
	}
	private boolean comprobarExistePersona() {
		return cs.existePersona(getTxIntroducirNombre().getText(), getTxIntroducirApellido().getText(), getTxIntroducirDni().getText());
	}
	private void añadirAccionista() {
		cs.añadirAccionista(getTxIntroducirNombre().getText(), getTxIntroducirApellido().getText(), getTxIntroducirDni().getText(), getTxIntroducirCuenta().getText());
		int id = cs.countAccionistas();
		JOptionPane.showMessageDialog(null, "Su identificador como accionista es: "+ id);
		
		Usuario u = new Usuario();
		u.setUsuario(""+id);
		u.setPid(id);
		u.setRol("accionista");
		u.setContrasena(new String(getTxContrasena().getPassword()));
		new MainService().addUser(u);
	}
	private JScrollPane getScrAcciones() {
		if (scrAcciones == null) {
			scrAcciones = new JScrollPane();
			scrAcciones.setViewportView(getTableAcciones());
		}
		return scrAcciones;
	}
	private JTable getTableAcciones() {
		if (tableAcciones == null) {
			tableAcciones = new JTable();
			tableAcciones.setRowSelectionAllowed(false);
			tableAcciones.setFont(new Font("Tahoma", Font.PLAIN, 18));
			tableAcciones.setModel(tableModelAcciones);
		}
		return tableAcciones;
	}
	private JScrollPane getScrCompra() {
		if (scrCompra == null) {
			scrCompra = new JScrollPane();
			scrCompra.setViewportView(getTableCompra());
		}
		return scrCompra;
	}
	private JTable getTableCompra() {
		if (tableCompra == null) {
			tableCompra = new JTable();
			tableCompra.setModel(tableModelCompra);
			tableCompra.getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		}
		return tableCompra;
	}
	private void cargarDatosAccionista(int id) {
		Accionista acc = cs.obtenerAccionista(id);
		cs.setAccionistaActivo(acc);
		getLbNombreInfo().setText(acc.getNombreAccionista());
		getLbApellidoInfo().setText(acc.getApellidoAccionista());
		getLbNAccionesInfo().setText(String.valueOf(acc.getNumeroAcciones()));
		getLbPrecioPorAccionInfo().setText(cs.getPrecioPorAccion() + " €");
		float valorTotal = acc.getNumeroAcciones() * cs.getPrecioPorAccion();
		getLbValorTotalAccionesInfo().setText(valorTotal + " €");
		getLbPorcentajeTotalInfo().setText(acc.getPorcentajeCapital() + " %");
	}
	private void rellenarTablaAcciones() {
		tableModelAcciones.setRowCount(0);
		List<Accion> acciones = cs.getAccionesAccionista();
		for (Accion a : acciones) {
			String estado = "";
			if (a.getEnVenta() == 0) {
				estado = "Fuera de venta";
			}
			else {
				estado = "En venta";
			}
			tableModelAcciones.addRow(new Object[]
					{a.getIdAccion(), a.getPrecioCompra(), a.getPrecioVenta(), estado});
		}
	}
	private void rellenarCamposCompra_NuevoAccionista() {
		getLbAccionesRestantes().setText("Acciones disponibles de la ampliación: "+ cs.getAccionesRestantes());
		for (int i = 1; i<=cs.getAccionesRestantes(); i++) {
			getCbNumeroAcciones().addItem(i);
		}
	}
	private void rellenarTablaCompraAcciones() {
		tableModelCompra.setRowCount(0);
		List<Accion> acciones = cs.getAccionesEnVenta();
		for (Accion a : acciones) {
			tableModelCompra.addRow(new Object[]
					{a.getIdAccion(), a.getIdAccionista(), a.getPrecioVenta()});
		}
	}
	private int comprobarCompra() {
		int respuesta = JOptionPane.showConfirmDialog(null, "¿Está seguro de que quiere comprar "
				+ getTableCompra().getSelectedRowCount() + " acciones por el precio de "+ 
				cs.getPrecioPorAccion()*getTableCompra().getSelectedRowCount() + "?");
		return respuesta;
	}
	private List<Integer> accionesSeleccionadas(){
		ListSelectionModel accionesSeleccionadas = getTableCompra().getSelectionModel();
		int[] filasSeleccionadas = accionesSeleccionadas.getSelectedIndices();
		List<Integer> idAcciones = new ArrayList<Integer>();
		
		for (int filaIndex : filasSeleccionadas) {
		    Object valorPrimeraColumna = getTableCompra().getValueAt(filaIndex, 0);
		    idAcciones.add((Integer) valorPrimeraColumna);
		}
		
		return idAcciones;
	}
	private List<Integer> accionistasVendedores(){
		ListSelectionModel accionesSeleccionadas = getTableCompra().getSelectionModel();
		int[] filasSeleccionadas = accionesSeleccionadas.getSelectedIndices();
		List<Integer> idAccionistas = new ArrayList<Integer>(); 
		
		for (int filaIndex : filasSeleccionadas) {
			Object valorPrimeraColumna = getTableCompra().getValueAt(filaIndex, 1);
			idAccionistas.add((Integer) valorPrimeraColumna);
		}
		return idAccionistas;
	}
	private void comprarAcciones() {
		List<Integer> listaCompra = accionesSeleccionadas();
		List<Integer> listaVendedores = accionistasVendedores();

		for (int i=0; i<listaCompra.size(); i++) {
			cs.comprarAccion(listaCompra.get(i), listaVendedores.get(i));
		}
	}
	private void comprobarAccionistaACero() {
		cs.eliminarAcionistaACero();
	}
	private int limiteFase1AccionistaActivo() {
		return cs.getLimiteFase1();
	}
	private void establecerValorCb_Fase1() {
		if (cs.getAccionistaActivo().getLimiteAccionesFaseUno() < cs.getAccionesRestantes()) {
			for (int i=1; i<=cs.getAccionistaActivo().getLimiteAccionesFaseUno(); i++) {
				getCbNumeroAcciones().addItem(i);
			}
		}
		else {
			for (int i=1; i<=cs.getAccionesRestantes(); i++) {
				getCbNumeroAcciones().addItem(i);
			}
		}
	}
	private void establecerValorCb() {
		for (int i=1; i<=cs.getAccionesRestantes(); i++) {
			getCbNumeroAcciones().addItem(i);
		}
	}
	private void actualizarAccionesRestantesYVendidas() {
		cs.setAccionesRestantes
		(cs.getAccionesRestantes()-(int)getCbNumeroAcciones().getSelectedItem());
		cs.setAccionesVendidas
		(cs.getAccionesVendidas()+(int)getCbNumeroAcciones().getSelectedItem());
	}
	private void creaAcciones() {
		for (int i=0; i<(int)getCbNumeroAcciones().getSelectedItem(); i++) {
			cs.crearAccion();
		}
	}
	private void actualizaLimiteAccionista() {
		cs.actualizaLimiteAccionista((Integer)getCbNumeroAcciones().getSelectedItem());
	}
	private void actualizaAccionista() {
		for (int i=0; i<(int)getCbNumeroAcciones().getSelectedItem(); i++) {
			cs.actualizaAccionistaCompraClub();
		}
	}
	private int comprobarCompraClub() {
		int respuesta = JOptionPane.showConfirmDialog(null, "¿Está seguro de que quiere comprar "
				+ getCbNumeroAcciones().getSelectedItem() + " acciones por el precio de "+ 
				cs.getPrecioPorAccion()*(int)getCbNumeroAcciones().getSelectedItem() + "?");
		return respuesta;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTableVender());
		}
		return scrollPane;
	}
	private JTable getTableVender() {
		if (tableVender == null) {
			tableVender = new JTable();
			tableVender.setModel(tableModelVenta);
			tableVender.getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		}
		return tableVender;
	}
	private void rellenarTablaVender() {
		tableModelVenta.setRowCount(0);
		List<Accion> acciones = cs.getAccionesAccionista();
		for (Accion a : acciones) {
			if (a.getEnVenta() == 0) {
				tableModelVenta.addRow(new Object[]
						{a.getIdAccion(), a.getPrecioCompra(), a.getPrecioVenta()});
			}
		}
	}
	private void mostrarPnVenta() {
		((CardLayout) getPnCentro().getLayout()).show(getPnCentro(), "pnVenta");
	}
	private void ponerEnVentaTodasAcciones() {
		cs.ponerEnVentaTodo();
	}
	private int comprobarVentaTodasAcciones() {
		return JOptionPane.showConfirmDialog(null, "¿Esta seguro de que quiere poner en venta "
				+ getTableVender().getRowCount() +" acciones en venta?");
		
	}
	private int comprobarVentaAcciones() {
		return JOptionPane.showConfirmDialog(null, "¿Esta seguro de que quiere poner en venta "
				+ getTableVender().getSelectedRowCount() +" acciones en venta?");
		
	}
	private List<Integer> accionesSeleccionadasVenta(){
		ListSelectionModel accionesSeleccionadas = getTableVender().getSelectionModel();
		int[] filasSeleccionadas = accionesSeleccionadas.getSelectedIndices();
		List<Integer> idAcciones = new ArrayList<Integer>();
		
		for (int filaIndex : filasSeleccionadas) {
		    Object valorPrimeraColumna = getTableVender().getValueAt(filaIndex, 0);
		    idAcciones.add((Integer) valorPrimeraColumna);
		}
		
		return idAcciones;
	}
	private void venderAccionesSeleccionadas() {
		List<Integer> idAcciones = accionesSeleccionadasVenta();
		for (Integer id : idAcciones) {
			cs.ponerEnVenta(id);
		}
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new GridLayout(0, 4, 0, 0));
			panel.add(getLbContrasena());
			panel.add(getTxContrasena());
			panel.add(getLbVacia_13());
			panel.add(getLbVacia_14());
			panel.add(getLbVacia_15());
		}
		return panel;
	}
	private JLabel getLbContrasena() {
		if (lbContrasena == null) {
			lbContrasena = new JLabel("Contraseña:");
			lbContrasena.setHorizontalAlignment(SwingConstants.CENTER);
			lbContrasena.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lbContrasena;
	}
	private JPasswordField getTxContrasena() {
		if (txContrasena == null) {
			txContrasena = new JPasswordField();
			txContrasena.setColumns(10);
		}
		return txContrasena;
	}
	private JLabel getLbVacia_13() {
		if (lbVacia_13 == null) {
			lbVacia_13 = new JLabel("");
		}
		return lbVacia_13;
	}
	private JLabel getLbVacia_14() {
		if (lbVacia_14 == null) {
			lbVacia_14 = new JLabel("");
		}
		return lbVacia_14;
	}
	private JLabel getLbVacia_15() {
		if (lbVacia_15 == null) {
			lbVacia_15 = new JLabel("");
		}
		return lbVacia_15;
	}
}
