package ips2023pl21.ui;

import javax.swing.JFrame;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ips2023pl21.model.Empleado;
import ips2023pl21.model.EmpleadoDeportivo;
import ips2023pl21.model.EmpleadoNoDeportivo;
import ips2023pl21.service.Service21911;
import ips2023pl21.service.Service21911.StateAction;
import ips2023pl21.service.Service21911.StateTipoEmpleado;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;


public class Frame21911 extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private Service21911 cs;
	private JPanel contentPane;
	private JPanel pnTitulo;
	private JLabel lbTitulo;
	private JPanel pnCentral;
	private JPanel pnSeleccionAccion;
	private JLabel lbSeleccionar;
	private JButton btAñadir;
	private JButton btElimminar;
	private JButton btModificar;
	private JPanel pnBotones;
	private JPanel pnConfirmacion;
	private JLabel lbTipoEmpleado;
	private JRadioButton rdbtDeportivo;
	private JRadioButton rdbtNoDeportivo;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPanel pnEtiqueta;
	private JLabel lbEspacio1;
	private JLabel lbEspacio2;
	private JLabel lbEspacio3;
	private JPanel pnEtiqueta2;
	private JPanel pnRadioButtons;
	private JPanel pnBotones2;
	private JButton btCancelar;
	private JButton btAceptar;
	private JLabel lbEspacio5;
	private JLabel lbEspacio6;
	private JPanel pnAñadirYModificar;
	private JPanel pnModificarEmpleado;
	private JPanel pnEtiqueta3;
	private JLabel lbCambios;
	private JPanel pnFormulario;
	private JPanel pnConfirmarCambios;
	private JPanel pnNombre;
	private JPanel pnApellido;
	private JPanel pnDni;
	private JPanel pnTelefono;
	private JPanel pnFechaNacimiento;
	private JPanel pnSalarioAnual;
	private JPanel pnPosicion;
	private JButton btConfirmar;
	private JLabel lbNombre;
	private JTextField txNombre;
	private JLabel lbApellido;
	private JTextField txApellido;
	private JLabel lbDni;
	private JTextField txDni;
	private JLabel lbTelefono;
	private JTextField txTelefono;
	private JLabel lbFecha;
	private JComboBox<Integer> cbDia;
	private JComboBox<Integer> cbMes;
	private JComboBox<Integer> cbAño;
	private JPanel pnDia;
	private JPanel pnMes;
	private JPanel pnAño;
	private JLabel lbDia;
	private JLabel lbMes;
	private JLabel lbAño;
	private JLabel lbSalario;
	private JTextField txSalario;
	private JLabel lbPosicion;
	private JButton btVolver;
	private JPanel pnEtiqueta4;
	private JLabel lbIntroducirFiltros;
	private JPanel pnSeleccion;
	private JPanel pnIntroduccion;
	private JPanel pnBusqueda;
	private JPanel pnBotonModificar;
	private JButton btModificarFin;
	private JButton btCancelarModificar;
	private JLabel lbSeleccDni;
	private JLabel lbSeleccApellido;
	private JLabel lbSeleccNombre;
	private JTextField txSeleccNombre;
	private JTextField txSeleccApellido;
	private JTextField txSeleccDni;
	private JPanel pnBuscar;
	private JPanel pnSeleccionBusqueda;
	private JButton btBuscar;
	private JLabel lbInfoSelecc;
	private JScrollPane scrSeleccion;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JPanel pnEliminarEmpleado;
	private JPanel pnEtiqueta4_1;
	private JLabel lbIntroducirFiltros_1;
	private JPanel pnSeleccion_1;
	private JPanel pnIntroduccion_1;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_4_1;
	private JLabel lbSeleccNombre_1;
	private JTextField txSeleccNombre_1;
	private JLabel lblNewLabel_7_1;
	private JLabel lblNewLabel_3_1;
	private JLabel lblNewLabel_8_1;
	private JLabel lblNewLabel_12_1;
	private JLabel lbSeleccApellido_1;
	private JTextField txSeleccApellido_1;
	private JLabel lblNewLabel_10_1;
	private JLabel lblNewLabel_11_1;
	private JLabel lblNewLabel_6_1;
	private JLabel lblNewLabel_9_1;
	private JLabel lbSeleccDni_1;
	private JTextField txSeleccDni_1;
	private JLabel lblNewLabel_5_1;
	private JLabel lblNewLabel_2_1;
	private JPanel pnBusqueda_1;
	private JPanel pnBotonModificar_1;
	private JButton btEliminarFin;
	private JButton btCancelarEliminar;
	private JPanel pnBuscar_1;
	private JButton btBuscar_1;
	private JPanel pnSeleccionBusqueda_1;
	private JLabel lbInfoSelecc_1;
	private JScrollPane scrSeleccion_1;
	private JLabel lbExplicacion;
	private JLabel lbExplicacion_1;
	private JComboBox<String> cbPosicion;
	private JTable tableModificar;
	private DefaultTableModel tableModelModificar = new DefaultTableModel(
			new String[][] {
			},
			new String[] {
				"Nombre", "Apellido", "DNI"
			}
		) {
			private static final long serialVersionUID = 1L;
	
			@Override
		    public boolean isCellEditable(int row, int column) {
		        return false;
	    }
	};
	private JTable tableEliminar;
	private DefaultTableModel tableModelEliminar = new DefaultTableModel(
			new String[][] {
			},
			new String[] {
				"Nombre", "Apellido", "DNI"
			}
		) {
			private static final long serialVersionUID = 1L;
	
			@Override
		    public boolean isCellEditable(int row, int column) {
		        return false;
	    }
	};
	
	

	/**
	 * Constructor de la ventana para añadir, modificar o eliminar empleados
	 */
	public Frame21911(Service21911 cs) {
		this.cs = cs;
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				confirmarSalida();
			}
		});
		setTitle("Gestión de empleados");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 722, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		pnTitulo = new JPanel();
		contentPane.add(pnTitulo, BorderLayout.NORTH);
		pnTitulo.setLayout(new GridLayout(0, 1, 0, 0));
		pnTitulo.add(getLbTitulo());
		contentPane.add(getPnCentral());
	}

	private void confirmarSalida() {
		int respuesta = JOptionPane.showConfirmDialog(this, 
				"¿Está seguro de que quiere cerrar la aplicación?");
		if (respuesta == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	private JLabel getLbTitulo() {
		if (lbTitulo == null) {
			lbTitulo = new JLabel("Gestión de empleados");
			lbTitulo.setForeground(new Color(0, 0, 0));
			lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lbTitulo.setFont(new Font("Tahoma", Font.BOLD, 40));
		}
		return lbTitulo;
	}
	private JPanel getPnCentral() {
		if (pnCentral == null) {
			pnCentral = new JPanel();
			pnCentral.setLayout(new CardLayout(0, 0));
			pnCentral.add(getPnSeleccionAccion(), "pnSeleccionAccion");
			pnCentral.add(getPnConfirmacion(), "pnConfirmacion");
			pnCentral.add(getPnAñadirYModificar(), "pnAñadirYModificar");
			pnCentral.add(getPnModificarEmpleado(), "pnModificarEmpleado");
			pnCentral.add(getPnEliminarEmpleado(), "pnEliminarEmpleado");
		}
		return pnCentral;
	}
	private JPanel getPnSeleccionAccion() {
		if (pnSeleccionAccion == null) {
			pnSeleccionAccion = new JPanel();
			pnSeleccionAccion.setLayout(new BorderLayout(0, 0));
			pnSeleccionAccion.add(getPnBotones(), BorderLayout.SOUTH);
			pnSeleccionAccion.add(getPnEtiqueta(), BorderLayout.CENTER);
		}
		return pnSeleccionAccion;
	}
	private JLabel getLbSeleccionar() {
		if (lbSeleccionar == null) {
			lbSeleccionar = new JLabel("Selecciona la acción que deseas llevar a cabo:");
			lbSeleccionar.setForeground(new Color(0, 0, 0));
			lbSeleccionar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		return lbSeleccionar;
	}
	private JButton getBtAñadir() {
		if (btAñadir == null) {
			btAñadir = new JButton("Añadir empleado");
			btAñadir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPanelConfirmacion();
					cs.setStateAction(StateAction.AÑADIR);
				}
			});
			btAñadir.setForeground(new Color(0, 0, 0));
			btAñadir.setBackground(new Color(0, 128, 0));
			btAñadir.setFont(new Font("Tahoma", Font.BOLD, 17));
		}
		return btAñadir;
	}
	private JButton getBtElimminar() {
		if (btElimminar == null) {
			btElimminar = new JButton("Eliminar empleado");
			btElimminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPanelConfirmacion();
					cs.setStateAction(StateAction.ELIMINAR);
				}
			});
			btElimminar.setForeground(new Color(0, 0, 0));
			btElimminar.setBackground(new Color(255, 0, 0));
			btElimminar.setFont(new Font("Tahoma", Font.BOLD, 17));
		}
		return btElimminar;
	}
	private JButton getBtModificar() {
		if (btModificar == null) {
			btModificar = new JButton("Modificar empleado");
			btModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPanelConfirmacion();
					cs.setStateAction(StateAction.MODIFICAR);
				}
			});
			btModificar.setForeground(new Color(0, 0, 0));
			btModificar.setBackground(new Color(255, 215, 0));
			btModificar.setFont(new Font("Tahoma", Font.BOLD, 17));
		}
		return btModificar;
	}
	private JPanel getPnBotones() {
		if (pnBotones == null) {
			pnBotones = new JPanel();
			pnBotones.setLayout(new GridLayout(2, 3, 0, 0));
			pnBotones.add(getBtAñadir());
			pnBotones.add(getLbEspacio1());
			pnBotones.add(getBtElimminar());
			pnBotones.add(getLbEspacio2());
			pnBotones.add(getBtModificar());
			pnBotones.add(getLbEspacio3());
		}
		return pnBotones;
	}
	
	private void mostrarPanelConfirmacion() {
		((CardLayout) getPnCentral().getLayout()).show(getPnCentral(), "pnConfirmacion");
	}
	private JPanel getPnConfirmacion() {
		if (pnConfirmacion == null) {
			pnConfirmacion = new JPanel();
			pnConfirmacion.setLayout(new BorderLayout(0, 0));
			pnConfirmacion.add(getPnEtiqueta2(), BorderLayout.NORTH);
			pnConfirmacion.add(getPnRadioButtons(), BorderLayout.CENTER);
			pnConfirmacion.add(getPnBotones2(), BorderLayout.SOUTH);
		}
		return pnConfirmacion;
	}
	private JLabel getLbTipoEmpleado() {
		if (lbTipoEmpleado == null) {
			lbTipoEmpleado = new JLabel("Selecciona el tipo de empleado sobre el que quiere trabajar:\r\n");
			lbTipoEmpleado.setForeground(new Color(0, 0, 0));
			lbTipoEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lbTipoEmpleado;
	}
	private JRadioButton getRdbtDeportivo() {
		if (rdbtDeportivo == null) {
			rdbtDeportivo = new JRadioButton("Deportivo");
			rdbtDeportivo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cs.setStateTipo(StateTipoEmpleado.DEPORTIVO);
				}
			});
			rdbtDeportivo.setHorizontalAlignment(SwingConstants.CENTER);
			rdbtDeportivo.setForeground(new Color(0, 0, 0));
			buttonGroup.add(rdbtDeportivo);
			rdbtDeportivo.setSelected(true);
			rdbtDeportivo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return rdbtDeportivo;
	}
	private JRadioButton getRdbtNoDeportivo() {
		if (rdbtNoDeportivo == null) {
			rdbtNoDeportivo = new JRadioButton("No deportivo");
			rdbtNoDeportivo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cs.setStateTipo(StateTipoEmpleado.NO_DEPORTIVO);
				}
			});
			rdbtNoDeportivo.setHorizontalAlignment(SwingConstants.CENTER);
			rdbtNoDeportivo.setForeground(new Color(0, 0, 0));
			buttonGroup.add(rdbtNoDeportivo);
			rdbtNoDeportivo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return rdbtNoDeportivo;
	}
	private JPanel getPnEtiqueta() {
		if (pnEtiqueta == null) {
			pnEtiqueta = new JPanel();
			pnEtiqueta.setLayout(new GridLayout(0, 1, 0, 0));
			pnEtiqueta.add(getLbSeleccionar());
		}
		return pnEtiqueta;
	}
	private JLabel getLbEspacio1() {
		if (lbEspacio1 == null) {
			lbEspacio1 = new JLabel("");
		}
		return lbEspacio1;
	}

	private JLabel getLbEspacio2() {
		if (lbEspacio2 == null) {
			lbEspacio2 = new JLabel("");
		}
		return lbEspacio2;
	}
	private JLabel getLbEspacio3() {
		if (lbEspacio3 == null) {
			lbEspacio3 = new JLabel("");
		}
		return lbEspacio3;
	}
	private JPanel getPnEtiqueta2() {
		if (pnEtiqueta2 == null) {
			pnEtiqueta2 = new JPanel();
			pnEtiqueta2.setLayout(new GridLayout(0, 1, 0, 0));
			pnEtiqueta2.add(getLbTipoEmpleado());
		}
		return pnEtiqueta2;
	}
	private JPanel getPnRadioButtons() {
		if (pnRadioButtons == null) {
			pnRadioButtons = new JPanel();
			pnRadioButtons.setLayout(new GridLayout(4, 1, 0, 0));
			pnRadioButtons.add(getLbEspacio6());
			pnRadioButtons.add(getRdbtDeportivo());
			pnRadioButtons.add(getRdbtNoDeportivo());
			pnRadioButtons.add(getLbEspacio5());
		}
		return pnRadioButtons;
	}
	private JPanel getPnBotones2() {
		if (pnBotones2 == null) {
			pnBotones2 = new JPanel();
			pnBotones2.add(getBtAceptar());
			pnBotones2.add(getBtCancelar());
		}
		return pnBotones2;
	}
	private JButton getBtCancelar() {
		if (btCancelar == null) {
			btCancelar = new JButton("Cancelar");
			btCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPanelSeleccionAccion();
				}
			});
			btCancelar.setForeground(Color.BLACK);
			btCancelar.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btCancelar.setBackground(Color.RED);
		}
		return btCancelar;
	}
	private JButton getBtAceptar() {
		if (btAceptar == null) {
			btAceptar = new JButton("Aceptar");
			btAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPantallaAccion();
					cargarListaEmpleados();
					rellenarListaDeSeleccion();
					rellenarCbPosicion();
				}
			});
			btAceptar.setForeground(Color.BLACK);
			btAceptar.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btAceptar.setBackground(new Color(0, 128, 0));
		}
		return btAceptar;
	}
	private JLabel getLbEspacio5() {
		if (lbEspacio5 == null) {
			lbEspacio5 = new JLabel("");
		}
		return lbEspacio5;
	}
	private JLabel getLbEspacio6() {
		if (lbEspacio6 == null) {
			lbEspacio6 = new JLabel("");
		}
		return lbEspacio6;
	}
	
	private void mostrarPanelSeleccionAccion() {
		((CardLayout) getPnCentral().getLayout()).show(getPnCentral(), "pnSeleccionAccion");
	}
	private JPanel getPnAñadirYModificar() {
		if (pnAñadirYModificar == null) {
			pnAñadirYModificar = new JPanel();
			pnAñadirYModificar.setLayout(new BorderLayout(0, 0));
			pnAñadirYModificar.add(getPnEtiqueta3(), BorderLayout.NORTH);
			pnAñadirYModificar.add(getPnFormulario(), BorderLayout.CENTER);
			pnAñadirYModificar.add(getPnConfirmarCambios(), BorderLayout.SOUTH);
		}
		return pnAñadirYModificar;
	}
	private JPanel getPnModificarEmpleado() {
		if (pnModificarEmpleado == null) {
			pnModificarEmpleado = new JPanel();
			pnModificarEmpleado.setLayout(new BorderLayout(0, 0));
			pnModificarEmpleado.add(getPnEtiqueta4(), BorderLayout.NORTH);
			pnModificarEmpleado.add(getPnSeleccion());
			pnModificarEmpleado.add(getPnBotonModificar(), BorderLayout.SOUTH);
		}
		return pnModificarEmpleado;
	}
	private JPanel getPnEtiqueta3() {
		if (pnEtiqueta3 == null) {
			pnEtiqueta3 = new JPanel();
			pnEtiqueta3.setLayout(new GridLayout(0, 1, 0, 0));
			pnEtiqueta3.add(getLbCambios());
		}
		return pnEtiqueta3;
	}
	private JLabel getLbCambios() {
		if (lbCambios == null) {
			lbCambios = new JLabel("Introduce los cambios que desees:");
			lbCambios.setForeground(new Color(0, 0, 0));
			lbCambios.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lbCambios;
	}
	private JPanel getPnFormulario() {
		if (pnFormulario == null) {
			pnFormulario = new JPanel();
			pnFormulario.setLayout(new GridLayout(7, 1, 0, 0));
			pnFormulario.add(getPnNombre());
			pnFormulario.add(getPnApellido());
			pnFormulario.add(getPnDni());
			pnFormulario.add(getPnTelefono());
			pnFormulario.add(getPnFechaNacimiento());
			pnFormulario.add(getPnSalarioAnual());
			pnFormulario.add(getPnPosicion());
		}
		return pnFormulario;
	}
	private JPanel getPnConfirmarCambios() {
		if (pnConfirmarCambios == null) {
			pnConfirmarCambios = new JPanel();
			pnConfirmarCambios.add(getBtConfirmar());
			pnConfirmarCambios.add(getBtVolver());
		}
		return pnConfirmarCambios;
	}
	private JPanel getPnNombre() {
		if (pnNombre == null) {
			pnNombre = new JPanel();
			pnNombre.setLayout(new GridLayout(0, 3, 0, 0));
			pnNombre.add(getLbNombre());
			pnNombre.add(getTxNombre());
		}
		return pnNombre;
	}
	private JPanel getPnApellido() {
		if (pnApellido == null) {
			pnApellido = new JPanel();
			pnApellido.setLayout(new GridLayout(0, 3, 0, 0));
			pnApellido.add(getLbApellido());
			pnApellido.add(getTxApellido());
		}
		return pnApellido;
	}
	private JPanel getPnDni() {
		if (pnDni == null) {
			pnDni = new JPanel();
			pnDni.setLayout(new GridLayout(0, 3, 0, 0));
			pnDni.add(getLbDni());
			pnDni.add(getTxDni());
		}
		return pnDni;
	}
	private JPanel getPnTelefono() {
		if (pnTelefono == null) {
			pnTelefono = new JPanel();
			pnTelefono.setLayout(new GridLayout(0, 3, 0, 0));
			pnTelefono.add(getLbTelefono());
			pnTelefono.add(getTxTelefono());
		}
		return pnTelefono;
	}
	private JPanel getPnFechaNacimiento() {
		if (pnFechaNacimiento == null) {
			pnFechaNacimiento = new JPanel();
			pnFechaNacimiento.setLayout(new GridLayout(0, 4, 0, 0));
			pnFechaNacimiento.add(getLbFecha());
			pnFechaNacimiento.add(getPnDia());
			pnFechaNacimiento.add(getPnMes());
			pnFechaNacimiento.add(getPnAño());
		}
		return pnFechaNacimiento;
	}
	private JPanel getPnSalarioAnual() {
		if (pnSalarioAnual == null) {
			pnSalarioAnual = new JPanel();
			pnSalarioAnual.setLayout(new GridLayout(0, 3, 0, 0));
			pnSalarioAnual.add(getLbSalario());
			pnSalarioAnual.add(getTxSalario());
		}
		return pnSalarioAnual;
	}
	private JPanel getPnPosicion() {
		if (pnPosicion == null) {
			pnPosicion = new JPanel();
			pnPosicion.setLayout(new GridLayout(0, 3, 0, 0));
			pnPosicion.add(getLbPosicion());
			pnPosicion.add(getCbPosicion());
		}
		return pnPosicion;
	}
	private JButton getBtConfirmar() {
		if (btConfirmar == null) {
			btConfirmar = new JButton("Confirmar cambios");
			btConfirmar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (camposVacios()) {
						JOptionPane.showMessageDialog(null, "Existen campos vacíos");
					}
					else {
						int respuesta = JOptionPane.showConfirmDialog(null, 
						"¿Está seguro de los cambios que va a introducir?");
						if (respuesta == JOptionPane.YES_OPTION) {
							realizarCambios();
							volverEstadoInicial();
						}
					}
				}
			});
			btConfirmar.setBackground(new Color(0, 128, 0));
			btConfirmar.setForeground(new Color(0, 0, 0));
			btConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		}
		return btConfirmar;
	}
	private JLabel getLbNombre() {
		if (lbNombre == null) {
			lbNombre = new JLabel("Nombre:");
			lbNombre.setForeground(new Color(0, 0, 0));
			lbNombre.setHorizontalAlignment(SwingConstants.CENTER);
			lbNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		}
		return lbNombre;
	}
	private JTextField getTxNombre() {
		if (txNombre == null) {
			txNombre = new JTextField();
			txNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
			txNombre.setColumns(10);
		}
		return txNombre;
	}
	private JLabel getLbApellido() {
		if (lbApellido == null) {
			lbApellido = new JLabel("Apellido:");
			lbApellido.setForeground(new Color(0, 0, 0));
			lbApellido.setHorizontalAlignment(SwingConstants.CENTER);
			lbApellido.setFont(new Font("Tahoma", Font.PLAIN, 15));
		}
		return lbApellido;
	}
	private JTextField getTxApellido() {
		if (txApellido == null) {
			txApellido = new JTextField();
			txApellido.setFont(new Font("Tahoma", Font.PLAIN, 15));
			txApellido.setColumns(10);
		}
		return txApellido;
	}
	private JLabel getLbDni() {
		if (lbDni == null) {
			lbDni = new JLabel("DNI:");
			lbDni.setHorizontalAlignment(SwingConstants.CENTER);
			lbDni.setForeground(new Color(0, 0, 0));
			lbDni.setFont(new Font("Tahoma", Font.PLAIN, 15));
		}
		return lbDni;
	}
	private JTextField getTxDni() {
		if (txDni == null) {
			txDni = new JTextField();
			txDni.setFont(new Font("Tahoma", Font.PLAIN, 15));
			txDni.setColumns(10);
		}
		return txDni;
	}
	private JLabel getLbTelefono() {
		if (lbTelefono == null) {
			lbTelefono = new JLabel("Teléfono:");
			lbTelefono.setForeground(new Color(0, 0, 0));
			lbTelefono.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lbTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lbTelefono;
	}
	private JTextField getTxTelefono() {
		if (txTelefono == null) {
			txTelefono = new JTextField();
			txTelefono.setFont(new Font("Tahoma", Font.PLAIN, 15));
			txTelefono.setColumns(10);
		}
		return txTelefono;
	}
	private JLabel getLbFecha() {
		if (lbFecha == null) {
			lbFecha = new JLabel("Fecha de nacimiento:");
			lbFecha.setHorizontalAlignment(SwingConstants.CENTER);
			lbFecha.setForeground(new Color(0, 0, 0));
			lbFecha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		}
		return lbFecha;
	}
	private JComboBox<Integer> getCbDia() {
		if (cbDia == null) {
			cbDia = new JComboBox<Integer>();
			for (int i = 1; i <= 31; i++) {
	            cbDia.addItem(i);
	        }
		}
		return cbDia;
	}
	private JComboBox<Integer> getCbMes() {
		if (cbMes == null) {
			cbMes = new JComboBox<Integer>();
			cbMes = new JComboBox<Integer>();
			for (int i = 1; i <= 12; i++) {
	            cbMes.addItem(i);
	        }
		}
		return cbMes;
	}
	private JComboBox<Integer> getCbAño() {
		if (cbAño == null) {
			cbAño = new JComboBox<Integer>();
			cbAño= new JComboBox<Integer>();
			for (int i = 2023; i>= 1923; i--) {
	            cbAño.addItem(i);
	        }
		}
		return cbAño;
	}
	private JPanel getPnDia() {
		if (pnDia == null) {
			pnDia = new JPanel();
			pnDia.setLayout(new GridLayout(0, 2, 0, 0));
			pnDia.add(getCbDia());
			pnDia.add(getLbDia());
		}
		return pnDia;
	}
	private JPanel getPnMes() {
		if (pnMes == null) {
			pnMes = new JPanel();
			pnMes.setLayout(new GridLayout(0, 2, 0, 0));
			pnMes.add(getCbMes());
			pnMes.add(getLbMes());
		}
		return pnMes;
	}
	private JPanel getPnAño() {
		if (pnAño == null) {
			pnAño = new JPanel();
			pnAño.setLayout(new GridLayout(0, 2, 0, 0));
			pnAño.add(getCbAño());
			pnAño.add(getLbAño());
		}
		return pnAño;
	}
	private JLabel getLbDia() {
		if (lbDia == null) {
			lbDia = new JLabel("dia");
			lbDia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lbDia;
	}
	private JLabel getLbMes() {
		if (lbMes == null) {
			lbMes = new JLabel("mes");
			lbMes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lbMes;
	}
	private JLabel getLbAño() {
		if (lbAño == null) {
			lbAño = new JLabel("año");
			lbAño.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lbAño;
	}
	private JLabel getLbSalario() {
		if (lbSalario == null) {
			lbSalario = new JLabel("Salario anual:");
			lbSalario.setForeground(new Color(0, 0, 0));
			lbSalario.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lbSalario.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lbSalario;
	}
	private JTextField getTxSalario() {
		if (txSalario == null) {
			txSalario = new JTextField();
			txSalario.setFont(new Font("Tahoma", Font.PLAIN, 15));
			txSalario.setColumns(10);
		}
		return txSalario;
	}
	private JLabel getLbPosicion() {
		if (lbPosicion == null) {
			lbPosicion = new JLabel("Posición:");
			lbPosicion.setForeground(new Color(0, 0, 0));
			lbPosicion.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lbPosicion.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lbPosicion;
	}
	
	private void mostrarPantallaAñadir() {
		((CardLayout) getPnCentral().getLayout()).show(getPnCentral(), "pnAñadirYModificar");
	}
	private JButton getBtVolver() {
		if (btVolver == null) {
			btVolver = new JButton("Volver");
			btVolver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPanelConfirmacion();
					resetearPantallaAñadirYModificar();
				}
			});
			btVolver.setBackground(new Color(255, 0, 0));
			btVolver.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btVolver.setForeground(new Color(0, 0, 0));
		}
		return btVolver;
	}
	
	private void mostrarPantallaSeleccionEmpleado() {
		if (cs.getStateAction() == StateAction.MODIFICAR) {
			((CardLayout) getPnCentral().getLayout()).show(getPnCentral(), "pnModificarEmpleado");
		}
		else {
			((CardLayout) getPnCentral().getLayout()).show(getPnCentral(), "pnEliminarEmpleado");
		}

	}
	private JPanel getPnEtiqueta4() {
		if (pnEtiqueta4 == null) {
			pnEtiqueta4 = new JPanel();
			pnEtiqueta4.setLayout(new GridLayout(0, 1, 0, 0));
			pnEtiqueta4.add(getLbIntroducirFiltros());
			pnEtiqueta4.add(getLbExplicacion());
		}
		return pnEtiqueta4;
	}
	private JLabel getLbIntroducirFiltros() {
		if (lbIntroducirFiltros == null) {
			lbIntroducirFiltros = new JLabel("Introduzca, si lo desea, los datos del usuario que quiere modificar.");
			lbIntroducirFiltros.setForeground(new Color(0, 0, 0));
			lbIntroducirFiltros.setFont(new Font("Tahoma", Font.PLAIN, 17));
		}
		return lbIntroducirFiltros;
	}
	private JPanel getPnSeleccion() {
		if (pnSeleccion == null) {
			pnSeleccion = new JPanel();
			pnSeleccion.setLayout(new GridLayout(1, 2, 0, 0));
			pnSeleccion.add(getPnIntroduccion());
			pnSeleccion.add(getPnBusqueda());
		}
		return pnSeleccion;
	}
	private JPanel getPnIntroduccion() {
		if (pnIntroduccion == null) {
			pnIntroduccion = new JPanel();
			pnIntroduccion.setLayout(new GridLayout(9, 2, 0, 0));
			pnIntroduccion.add(getLblNewLabel_1());
			pnIntroduccion.add(getLblNewLabel_4());
			pnIntroduccion.add(getLbSeleccNombre());
			pnIntroduccion.add(getTxSeleccNombre());
			pnIntroduccion.add(getLblNewLabel_7());
			pnIntroduccion.add(getLblNewLabel_3());
			pnIntroduccion.add(getLblNewLabel_8());
			pnIntroduccion.add(getLblNewLabel_12());
			pnIntroduccion.add(getLbSeleccApellido());
			pnIntroduccion.add(getTxSeleccApellido());
			pnIntroduccion.add(getLblNewLabel_10());
			pnIntroduccion.add(getLblNewLabel_11());
			pnIntroduccion.add(getLblNewLabel_6());
			pnIntroduccion.add(getLblNewLabel_9());
			pnIntroduccion.add(getLbSeleccDni());
			pnIntroduccion.add(getTxSeleccDni());
			pnIntroduccion.add(getLblNewLabel_5());
			pnIntroduccion.add(getLblNewLabel_2());
		}
		return pnIntroduccion;
	}
	private JPanel getPnBusqueda() {
		if (pnBusqueda == null) {
			pnBusqueda = new JPanel();
			pnBusqueda.setLayout(new BorderLayout(0, 0));
			pnBusqueda.add(getPnBuscar(), BorderLayout.NORTH);
			pnBusqueda.add(getPnSeleccionBusqueda());
		}
		return pnBusqueda;
	}
	private JPanel getPnBotonModificar() {
		if (pnBotonModificar == null) {
			pnBotonModificar = new JPanel();
			pnBotonModificar.add(getBtModificarFin());
			pnBotonModificar.add(getBtCancelarModificar());
		}
		return pnBotonModificar;
	}
	private JButton getBtModificarFin() {
		if (btModificarFin == null) {
			btModificarFin = new JButton("Modificar");
			btModificarFin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (getTableModificar().getSelectedRow() == -1) {
						JOptionPane.showMessageDialog(null, "No ha seleccionado ningún empleado");
					}
					else {
						int row = getTableModificar().getSelectedRow();
						//Logica
						cs.tableToEmpleado(getTableModificar().getValueAt(row,0).toString(), 
								getTableModificar().getValueAt(row, 1).toString(), getTableModificar().getValueAt(row, 2).toString());
						//UI
						resetearPantallaModificar();
						rellenarValoresAModificar();
						mostrarPantallaAñadir();
						rellenarCbPosicion();
					}
				}
			});
			btModificarFin.setBackground(new Color(0, 128, 0));
			btModificarFin.setForeground(new Color(0, 0, 0));
			btModificarFin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		return btModificarFin;
	}
	private JButton getBtCancelarModificar() {
		if (btCancelarModificar == null) {
			btCancelarModificar = new JButton("Cancelar");
			btCancelarModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					volverPantallaConfirmacion();
					resetearPantallaModificar();
				}
			});
			btCancelarModificar.setForeground(new Color(0, 0, 0));
			btCancelarModificar.setBackground(new Color(255, 0, 0));
			btCancelarModificar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		return btCancelarModificar;
	}
	private JLabel getLbSeleccDni() {
		if (lbSeleccDni == null) {
			lbSeleccDni = new JLabel("DNI");
			lbSeleccDni.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lbSeleccDni.setForeground(new Color(0, 0, 0));
			lbSeleccDni.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lbSeleccDni;
	}
	private JLabel getLbSeleccApellido() {
		if (lbSeleccApellido == null) {
			lbSeleccApellido = new JLabel("Apellido");
			lbSeleccApellido.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lbSeleccApellido.setForeground(new Color(0, 0, 0));
			lbSeleccApellido.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lbSeleccApellido;
	}
	private JLabel getLbSeleccNombre() {
		if (lbSeleccNombre == null) {
			lbSeleccNombre = new JLabel("Nombre");
			lbSeleccNombre.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lbSeleccNombre.setForeground(new Color(0, 0, 0));
			lbSeleccNombre.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lbSeleccNombre;
	}
	private JTextField getTxSeleccNombre() {
		if (txSeleccNombre == null) {
			txSeleccNombre = new JTextField();
			txSeleccNombre.setColumns(10);
		}
		return txSeleccNombre;
	}
	private JTextField getTxSeleccApellido() {
		if (txSeleccApellido == null) {
			txSeleccApellido = new JTextField();
			txSeleccApellido.setColumns(10);
		}
		return txSeleccApellido;
	}
	private JTextField getTxSeleccDni() {
		if (txSeleccDni == null) {
			txSeleccDni = new JTextField();
			txSeleccDni.setColumns(10);
		}
		return txSeleccDni;
	}
	private JPanel getPnBuscar() {
		if (pnBuscar == null) {
			pnBuscar = new JPanel();
			pnBuscar.add(getBtBuscar());
		}
		return pnBuscar;
	}
	private JPanel getPnSeleccionBusqueda() {
		if (pnSeleccionBusqueda == null) {
			pnSeleccionBusqueda = new JPanel();
			pnSeleccionBusqueda.setLayout(new BorderLayout(0, 0));
			pnSeleccionBusqueda.add(getLbInfoSelecc(), BorderLayout.NORTH);
			pnSeleccionBusqueda.add(getScrSeleccion(), BorderLayout.CENTER);
		}
		return pnSeleccionBusqueda;
	}
	private JButton getBtBuscar() {
		if (btBuscar == null) {
			btBuscar = new JButton("Buscar");
			btBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (getTxSeleccNombre().getText().isBlank() && 
						getTxSeleccApellido().getText().isBlank() &&
						getTxSeleccDni().getText().isBlank()) {
						JOptionPane.showMessageDialog(null, "Los tres campos de búsqueda están vacíos.");
						tableModelModificar.setRowCount(0);
						for(Empleado end : cs.getListaEmpleados()) {
							tableModelModificar.addRow(new Object[]{end.getNombre(), end.getApellido(), end.getDni()});
						}
					}
					else {
						buscarEmpleadoModificar();
					}
					
				}
			});
			btBuscar.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btBuscar.setForeground(new Color(0, 0, 0));
			btBuscar.setBackground(new Color(30, 144, 255));
		}
		return btBuscar;
	}
	private JLabel getLbInfoSelecc() {
		if (lbInfoSelecc == null) {
			lbInfoSelecc = new JLabel("Seleccione el empleado:");
			lbInfoSelecc.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lbInfoSelecc.setForeground(new Color(0, 0, 0));
		}
		return lbInfoSelecc;
	}
	private JScrollPane getScrSeleccion() {
		if (scrSeleccion == null) {
			scrSeleccion = new JScrollPane();
			scrSeleccion.setViewportView(getTableModificar());
		}
		return scrSeleccion;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
		}
		return lblNewLabel_1;
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
	private JLabel getLblNewLabel_7() {
		if (lblNewLabel_7 == null) {
			lblNewLabel_7 = new JLabel("");
		}
		return lblNewLabel_7;
	}
	private JLabel getLblNewLabel_8() {
		if (lblNewLabel_8 == null) {
			lblNewLabel_8 = new JLabel("");
		}
		return lblNewLabel_8;
	}
	private JLabel getLblNewLabel_9() {
		if (lblNewLabel_9 == null) {
			lblNewLabel_9 = new JLabel("");
		}
		return lblNewLabel_9;
	}
	private JLabel getLblNewLabel_10() {
		if (lblNewLabel_10 == null) {
			lblNewLabel_10 = new JLabel("");
		}
		return lblNewLabel_10;
	}
	private JLabel getLblNewLabel_11() {
		if (lblNewLabel_11 == null) {
			lblNewLabel_11 = new JLabel("");
		}
		return lblNewLabel_11;
	}
	private JLabel getLblNewLabel_12() {
		if (lblNewLabel_12 == null) {
			lblNewLabel_12 = new JLabel("");
		}
		return lblNewLabel_12;
	}
	private JPanel getPnEliminarEmpleado() {
		if (pnEliminarEmpleado == null) {
			pnEliminarEmpleado = new JPanel();
			pnEliminarEmpleado.setLayout(new BorderLayout(0, 0));
			pnEliminarEmpleado.add(getPnEtiqueta4_1(), BorderLayout.NORTH);
			pnEliminarEmpleado.add(getPnSeleccion_1(), BorderLayout.CENTER);
			pnEliminarEmpleado.add(getPnBotonModificar_1(), BorderLayout.SOUTH);
		}
		return pnEliminarEmpleado;
	}
	private JPanel getPnEtiqueta4_1() {
		if (pnEtiqueta4_1 == null) {
			pnEtiqueta4_1 = new JPanel();
			pnEtiqueta4_1.setLayout(new GridLayout(0, 1, 0, 0));
			pnEtiqueta4_1.add(getLbIntroducirFiltros_1());
			pnEtiqueta4_1.add(getLbExplicacion_1());
		}
		return pnEtiqueta4_1;
	}
	private JLabel getLbIntroducirFiltros_1() {
		if (lbIntroducirFiltros_1 == null) {
			lbIntroducirFiltros_1 = new JLabel("Introduzca, si lo desea, los datos del usuario que quiere eliminar.");
			lbIntroducirFiltros_1.setForeground(Color.BLACK);
			lbIntroducirFiltros_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		}
		return lbIntroducirFiltros_1;
	}
	private JPanel getPnSeleccion_1() {
		if (pnSeleccion_1 == null) {
			pnSeleccion_1 = new JPanel();
			pnSeleccion_1.setLayout(new GridLayout(1, 2, 0, 0));
			pnSeleccion_1.add(getPnIntroduccion_1());
			pnSeleccion_1.add(getPnBusqueda_1());
		}
		return pnSeleccion_1;
	}
	private JPanel getPnIntroduccion_1() {
		if (pnIntroduccion_1 == null) {
			pnIntroduccion_1 = new JPanel();
			pnIntroduccion_1.setLayout(new GridLayout(9, 2, 0, 0));
			pnIntroduccion_1.add(getLblNewLabel_1_1());
			pnIntroduccion_1.add(getLblNewLabel_4_1());
			pnIntroduccion_1.add(getLbSeleccNombre_1());
			pnIntroduccion_1.add(getTxSeleccNombre_1());
			pnIntroduccion_1.add(getLblNewLabel_7_1());
			pnIntroduccion_1.add(getLblNewLabel_3_1());
			pnIntroduccion_1.add(getLblNewLabel_8_1());
			pnIntroduccion_1.add(getLblNewLabel_12_1());
			pnIntroduccion_1.add(getLbSeleccApellido_1());
			pnIntroduccion_1.add(getTxSeleccApellido_1());
			pnIntroduccion_1.add(getLblNewLabel_10_1());
			pnIntroduccion_1.add(getLblNewLabel_11_1());
			pnIntroduccion_1.add(getLblNewLabel_6_1());
			pnIntroduccion_1.add(getLblNewLabel_9_1());
			pnIntroduccion_1.add(getLbSeleccDni_1());
			pnIntroduccion_1.add(getTxSeleccDni_1());
			pnIntroduccion_1.add(getLblNewLabel_5_1());
			pnIntroduccion_1.add(getLblNewLabel_2_1());
		}
		return pnIntroduccion_1;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("");
		}
		return lblNewLabel_1_1;
	}
	private JLabel getLblNewLabel_4_1() {
		if (lblNewLabel_4_1 == null) {
			lblNewLabel_4_1 = new JLabel("");
		}
		return lblNewLabel_4_1;
	}
	private JLabel getLbSeleccNombre_1() {
		if (lbSeleccNombre_1 == null) {
			lbSeleccNombre_1 = new JLabel("Nombre");
			lbSeleccNombre_1.setHorizontalAlignment(SwingConstants.CENTER);
			lbSeleccNombre_1.setForeground(Color.BLACK);
			lbSeleccNombre_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lbSeleccNombre_1;
	}
	private JTextField getTxSeleccNombre_1() {
		if (txSeleccNombre_1 == null) {
			txSeleccNombre_1 = new JTextField();
			txSeleccNombre_1.setColumns(10);
		}
		return txSeleccNombre_1;
	}
	private JLabel getLblNewLabel_7_1() {
		if (lblNewLabel_7_1 == null) {
			lblNewLabel_7_1 = new JLabel("");
		}
		return lblNewLabel_7_1;
	}
	private JLabel getLblNewLabel_3_1() {
		if (lblNewLabel_3_1 == null) {
			lblNewLabel_3_1 = new JLabel("");
		}
		return lblNewLabel_3_1;
	}
	private JLabel getLblNewLabel_8_1() {
		if (lblNewLabel_8_1 == null) {
			lblNewLabel_8_1 = new JLabel("");
		}
		return lblNewLabel_8_1;
	}
	private JLabel getLblNewLabel_12_1() {
		if (lblNewLabel_12_1 == null) {
			lblNewLabel_12_1 = new JLabel("");
		}
		return lblNewLabel_12_1;
	}
	private JLabel getLbSeleccApellido_1() {
		if (lbSeleccApellido_1 == null) {
			lbSeleccApellido_1 = new JLabel("Apellido");
			lbSeleccApellido_1.setHorizontalAlignment(SwingConstants.CENTER);
			lbSeleccApellido_1.setForeground(Color.BLACK);
			lbSeleccApellido_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lbSeleccApellido_1;
	}
	private JTextField getTxSeleccApellido_1() {
		if (txSeleccApellido_1 == null) {
			txSeleccApellido_1 = new JTextField();
			txSeleccApellido_1.setColumns(10);
		}
		return txSeleccApellido_1;
	}
	private JLabel getLblNewLabel_10_1() {
		if (lblNewLabel_10_1 == null) {
			lblNewLabel_10_1 = new JLabel("");
		}
		return lblNewLabel_10_1;
	}
	private JLabel getLblNewLabel_11_1() {
		if (lblNewLabel_11_1 == null) {
			lblNewLabel_11_1 = new JLabel("");
		}
		return lblNewLabel_11_1;
	}
	private JLabel getLblNewLabel_6_1() {
		if (lblNewLabel_6_1 == null) {
			lblNewLabel_6_1 = new JLabel("");
		}
		return lblNewLabel_6_1;
	}
	private JLabel getLblNewLabel_9_1() {
		if (lblNewLabel_9_1 == null) {
			lblNewLabel_9_1 = new JLabel("");
		}
		return lblNewLabel_9_1;
	}
	private JLabel getLbSeleccDni_1() {
		if (lbSeleccDni_1 == null) {
			lbSeleccDni_1 = new JLabel("DNI");
			lbSeleccDni_1.setHorizontalAlignment(SwingConstants.CENTER);
			lbSeleccDni_1.setForeground(Color.BLACK);
			lbSeleccDni_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lbSeleccDni_1;
	}
	private JTextField getTxSeleccDni_1() {
		if (txSeleccDni_1 == null) {
			txSeleccDni_1 = new JTextField();
			txSeleccDni_1.setColumns(10);
		}
		return txSeleccDni_1;
	}
	private JLabel getLblNewLabel_5_1() {
		if (lblNewLabel_5_1 == null) {
			lblNewLabel_5_1 = new JLabel("");
		}
		return lblNewLabel_5_1;
	}
	private JLabel getLblNewLabel_2_1() {
		if (lblNewLabel_2_1 == null) {
			lblNewLabel_2_1 = new JLabel("");
		}
		return lblNewLabel_2_1;
	}
	private JPanel getPnBusqueda_1() {
		if (pnBusqueda_1 == null) {
			pnBusqueda_1 = new JPanel();
			pnBusqueda_1.setLayout(new BorderLayout(0, 0));
			pnBusqueda_1.add(getPnBuscar_1(), BorderLayout.NORTH);
			pnBusqueda_1.add(getPnSeleccionBusqueda_1(), BorderLayout.CENTER);
		}
		return pnBusqueda_1;
	}
	private JPanel getPnBotonModificar_1() {
		if (pnBotonModificar_1 == null) {
			pnBotonModificar_1 = new JPanel();
			pnBotonModificar_1.add(getBtEliminarFin());
			pnBotonModificar_1.add(getBtCancelarEliminar());
		}
		return pnBotonModificar_1;
	}
	private JButton getBtEliminarFin() {
		if (btEliminarFin == null) {
			btEliminarFin = new JButton("Eliminar");
			btEliminarFin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (getTableEliminar().getSelectedRow() == -1) {
						JOptionPane.showMessageDialog(null, "No ha seleccionado ningún empleado");
					}
					else {
						int row = getTableEliminar().getSelectedRow();
						//Logica
						cs.tableToEmpleado(getTableEliminar().getValueAt(row,0).toString(), 
								getTableEliminar().getValueAt(row, 1).toString(), getTableEliminar().getValueAt(row, 2).toString());
						//UI y Logica
						eliminarEmpleado();
					}
				}
			});
			btEliminarFin.setForeground(Color.BLACK);
			btEliminarFin.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btEliminarFin.setBackground(new Color(0, 128, 0));
		}
		return btEliminarFin;
	}
	private JButton getBtCancelarEliminar() {
		if (btCancelarEliminar == null) {
			btCancelarEliminar = new JButton("Cancelar");
			btCancelarEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					volverPantallaConfirmacion();
					resetearPantallaEliminar();
				}
			});
			btCancelarEliminar.setForeground(Color.BLACK);
			btCancelarEliminar.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btCancelarEliminar.setBackground(Color.RED);
		}
		return btCancelarEliminar;
	}
	private JPanel getPnBuscar_1() {
		if (pnBuscar_1 == null) {
			pnBuscar_1 = new JPanel();
			pnBuscar_1.add(getBtBuscar_1());
		}
		return pnBuscar_1;
	}
	private JButton getBtBuscar_1() {
		if (btBuscar_1 == null) {
			btBuscar_1 = new JButton("Buscar");
			btBuscar_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (getTxSeleccNombre_1().getText().isBlank() && 
						getTxSeleccApellido_1().getText().isBlank() &&
						getTxSeleccDni_1().getText().isBlank()) {
						JOptionPane.showMessageDialog(null, "Los tres campos de búsqueda están vacíos.");
						tableModelEliminar.setRowCount(0);
						for(Empleado end : cs.getListaEmpleados()) {
							tableModelEliminar.addRow(new Object[]{end.getNombre(), end.getApellido(), end.getDni()});
						}
					}
					else {
						buscarEmpleadoEliminar();
					}
				}
			});
			btBuscar_1.setForeground(Color.BLACK);
			btBuscar_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btBuscar_1.setBackground(new Color(30, 144, 255));
		}
		return btBuscar_1;
	}
	private JPanel getPnSeleccionBusqueda_1() {
		if (pnSeleccionBusqueda_1 == null) {
			pnSeleccionBusqueda_1 = new JPanel();
			pnSeleccionBusqueda_1.setLayout(new BorderLayout(0, 0));
			pnSeleccionBusqueda_1.add(getLbInfoSelecc_1(), BorderLayout.NORTH);
			pnSeleccionBusqueda_1.add(getScrSeleccion_1(), BorderLayout.CENTER);
		}
		return pnSeleccionBusqueda_1;
	}
	private JLabel getLbInfoSelecc_1() {
		if (lbInfoSelecc_1 == null) {
			lbInfoSelecc_1 = new JLabel("Seleccione el empleado:");
			lbInfoSelecc_1.setForeground(Color.BLACK);
			lbInfoSelecc_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lbInfoSelecc_1;
	}
	private JScrollPane getScrSeleccion_1() {
		if (scrSeleccion_1 == null) {
			scrSeleccion_1 = new JScrollPane();
			scrSeleccion_1.setViewportView(getTableEliminar());
		}
		return scrSeleccion_1;
	}
	private void mostrarPantallaAccion() {
		if (cs.getStateAction()==StateAction.AÑADIR) {
			mostrarPantallaAñadir();
		}
		else {
			mostrarPantallaSeleccionEmpleado();
		}
	}
	private void cargarListaEmpleados() {
		if(getRdbtDeportivo().isSelected()) {
			cs.cargarEmpleadosDeportivos();
		}
		else {
			cs.cargarEmpleadosNoDeportivos();
		}
	}
	private void resetearPantallaAñadirYModificar() {
		getTxNombre().setText("");
		getTxApellido().setText("");
		getTxDni().setText("");
		getTxTelefono().setText("");
		getCbAño().setSelectedIndex(0);
		getCbDia().setSelectedIndex(0);
		getCbMes().setSelectedIndex(0);
		getTxSalario().setText("");
	}
	private void rellenarListaDeSeleccion() {
		tableModelModificar.setRowCount(0);
		tableModelEliminar.setRowCount(0);
		if(cs.getStateAction() == StateAction.MODIFICAR) {
		for (Empleado end: cs.getListaEmpleados()) {
			tableModelModificar.addRow(new Object[]{end.getNombre(), end.getApellido(), end.getDni()});
			}
		}
		else if(cs.getStateAction() == StateAction.ELIMINAR) {
			for (Empleado end: cs.getListaEmpleados()) {
				tableModelEliminar.addRow(new Object[]{end.getNombre(), end.getApellido(), end.getDni()});
			}
		}
	}
	private void volverPantallaConfirmacion() {
		((CardLayout) getPnCentral().getLayout()).show(getPnCentral(), "pnConfirmacion");
	}
	private void resetearPantallaModificar() {
		tableModelModificar.setRowCount(0);
		getTxSeleccNombre().setText("");
		getTxSeleccApellido().setText("");
		getTxSeleccDni().setText("");
	}
	private void resetearPantallaEliminar() {
		tableModelEliminar.setRowCount(0);
		getTxSeleccNombre_1().setText("");
		getTxSeleccApellido_1().setText("");
		getTxSeleccDni_1().setText("");
	}
	private void rellenarValoresAModificar() {
		if (cs.getStateTipo() == StateTipoEmpleado.DEPORTIVO) {
			EmpleadoDeportivo ed = cs.cargarEmpleadoDeportivoAGestionar();
			getTxNombre().setText(ed.getNombre());
			getTxApellido().setText(ed.getApellido());
			getTxDni().setText(ed.getDni());
			getTxTelefono().setText(ed.getTelefono());
			int[] fechaEnteros = ed.fechaAEnteros();
			getCbAño().setSelectedItem(fechaEnteros[0]);
			getCbMes().setSelectedItem(fechaEnteros[1]);
			getCbDia().setSelectedItem(fechaEnteros[2]);
			getTxSalario().setText(String.valueOf(ed.getSalarioAnual()));
		}
		else if(cs.getStateTipo() == StateTipoEmpleado.NO_DEPORTIVO) {
			EmpleadoNoDeportivo end = cs.cargarEmpleadoNoDeportivoAGestionar();
			getTxNombre().setText(end.getNombre());
			getTxApellido().setText(end.getApellido());
			getTxDni().setText(end.getDni());
			getTxTelefono().setText(end.getTelefono());
			int[] fechaEnteros = end.fechaAEnteros();
			getCbAño().setSelectedItem(fechaEnteros[0]);
			getCbMes().setSelectedItem(fechaEnteros[1]);
			getCbDia().setSelectedItem(fechaEnteros[2]);
			getTxSalario().setText(String.valueOf(end.getSalarioAnual()));
		}
	}
	private JLabel getLbExplicacion() {
		if (lbExplicacion == null) {
			lbExplicacion = new JLabel("Puede introducir el nombre, apellido o las 3 cosas para filtrar en la lista de empleados.");
			lbExplicacion.setForeground(new Color(0, 0, 0));
			lbExplicacion.setFont(new Font("Tahoma", Font.PLAIN, 17));
		}
		return lbExplicacion;
	}
	private JLabel getLbExplicacion_1() {
		if (lbExplicacion_1 == null) {
			lbExplicacion_1 = new JLabel("Puede introducir el nombre, apellido o las 3 cosas para filtrar en la lista de empleados.");
			lbExplicacion_1.setForeground(new Color(0, 0, 0));
			lbExplicacion_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		}
		return lbExplicacion_1;
	}
	private void eliminarEmpleado() {
		int respuesta = JOptionPane.showConfirmDialog(null, 
		"¿Está seguro de que quiere eliminar a "+ 
		cs.getNombreEmpleadoGestion() +" " +cs.getApellidoEmpleadoGestion() + "?");
		if(respuesta == JOptionPane.YES_OPTION) {
			cs.eliminarEmpleadoClub();
			int respuesta2 = JOptionPane.showConfirmDialog(null, 
			"¿Desea seguir eliminando usuarios del sistema?", "Empleado eliminado", JOptionPane.YES_NO_OPTION);
			if (respuesta2 == JOptionPane.YES_OPTION) {
				resetearPantallaEliminar();
				cargarListaEmpleados();
				rellenarListaDeSeleccion();
			}
			else{
				resetearPantallaEliminar();
				mostrarPanelSeleccionAccion();
			}
		}
	}
	private boolean camposVacios() {
		if (getTxNombre().getText().isBlank() || getTxApellido().getText().isBlank() ||
			getTxDni().getText().isBlank() || getTxTelefono().getText().isBlank() ||
			getTxSalario().getText().isBlank()) {
			return true;
		}
		return false;
	}
	private void realizarCambios() {
		if (cs.getStateAction() == StateAction.AÑADIR) {
			if (cs.getStateTipo() == StateTipoEmpleado.DEPORTIVO) {
				cs.añadirEmpleadoDeportivo(getTxNombre().getText(), getTxApellido().getText(), 
				getTxDni().getText(), getTxTelefono().getText(), getCbAño().getSelectedItem(), 
				getCbMes().getSelectedItem(), getCbDia().getSelectedItem(), 
				getTxSalario().getText(), getCbPosicion().getSelectedItem());
			}
			else if (cs.getStateTipo() == StateTipoEmpleado.NO_DEPORTIVO) {
				cs.añadirEmpleadoNoDeportivo(getTxNombre().getText(), getTxApellido().getText(), 
				getTxDni().getText(), getTxTelefono().getText(), getCbAño().getSelectedItem(), 
				getCbMes().getSelectedItem(), getCbDia().getSelectedItem(), 
				getTxSalario().getText(), getCbPosicion().getSelectedItem());
			}
			
		}
		else if (cs.getStateAction() == StateAction.MODIFICAR) {
			if (cs.getStateTipo() == StateTipoEmpleado.DEPORTIVO) {
				cs.modificarEmpleadoDeportivo(getTxNombre().getText(), getTxApellido().getText(), 
				getTxDni().getText(), getTxTelefono().getText(), getCbAño().getSelectedItem(), 
				getCbMes().getSelectedItem(), getCbDia().getSelectedItem(), 
				getTxSalario().getText(), getCbPosicion().getSelectedItem());
			}
			else if (cs.getStateTipo() == StateTipoEmpleado.NO_DEPORTIVO) {
				cs.modificarEmpleadoNoDeportivo(getTxNombre().getText(), getTxApellido().getText(), 
				getTxDni().getText(), getTxTelefono().getText(), getCbAño().getSelectedItem(), 
				getCbMes().getSelectedItem(), getCbDia().getSelectedItem(), 
				getTxSalario().getText(), getCbPosicion().getSelectedItem());
			}
		}
	}
	private void volverEstadoInicial() {
		//Logica
		cs.estadoInicial();
		//UI
		mostrarPanelSeleccionAccion();
		resetearPantallaAñadirYModificar();
		getRdbtDeportivo().setSelected(true);
	}
	private void buscarEmpleadoModificar() {
	    tableModelModificar.setRowCount(0);

	    String nombre = getTxSeleccNombre().getText();
	    String apellido = getTxSeleccApellido().getText();
	    String dni = getTxSeleccDni().getText();
	    boolean encontrado = false;

	    for (Empleado e : cs.getListaEmpleados()) {
	        boolean mostrar = true;

	        if (!nombre.isBlank() && !e.getNombre().equals(nombre)) {
	            mostrar = false;
	        }

	        if (!apellido.isBlank() && !e.getApellido().equals(apellido)) {
	            mostrar = false;
	        }

	        if (!dni.isBlank() && !e.getDni().equals(dni)) {
	            mostrar = false;
	        }

	        if (mostrar) {
	            tableModelModificar.addRow(new Object[]{e.getNombre(), e.getApellido(), e.getDni()});
	            encontrado = true;
	        }
	    }

	    if (!encontrado) {
	        for (Empleado e : cs.getListaEmpleados()) {
	            tableModelModificar.addRow(new Object[]{e.getNombre(), e.getApellido(), e.getDni()});
	        }
	        JOptionPane.showMessageDialog(null, "No se ha encontrado ningún empleado con esas características. Se muestran todos los empleados.");
	    }
	}

	private void buscarEmpleadoEliminar() {
		tableModelEliminar.setRowCount(0);

	    String nombre = getTxSeleccNombre_1().getText();
	    String apellido = getTxSeleccApellido_1().getText();
	    String dni = getTxSeleccDni_1().getText();
	    boolean encontrado = false;

	    for (Empleado e : cs.getListaEmpleados()) {
	        boolean mostrar = true;

	        if (!nombre.isBlank() && !e.getNombre().equals(nombre)) {
	            mostrar = false;
	        }

	        if (!apellido.isBlank() && !e.getApellido().equals(apellido)) {
	            mostrar = false;
	        }

	        if (!dni.isBlank() && !e.getDni().equals(dni)) {
	            mostrar = false;
	        }

	        if (mostrar) {
	            tableModelEliminar.addRow(new Object[]{e.getNombre(), e.getApellido(), e.getDni()});
	            encontrado = true;
	        }
	    }

	    if (!encontrado) {
	        for (Empleado e : cs.getListaEmpleados()) {
	            tableModelEliminar.addRow(new Object[]{e.getNombre(), e.getApellido(), e.getDni()});
	        }
	        JOptionPane.showMessageDialog(null, "No se ha encontrado ningún empleado con esas características. Se muestran todos los empleados.");
	    }
	}
	private JComboBox<String> getCbPosicion() {
		if (cbPosicion == null) {
			cbPosicion = new JComboBox<String>();
			cbPosicion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return cbPosicion;
	}
	private void rellenarCbPosicion() {
		cbPosicion.removeAllItems();
		if (cs.getStateTipo()==StateTipoEmpleado.DEPORTIVO) {
			
			for(String s : cs.getListaPosicionDeportiva()) {
				cbPosicion.addItem(s);
			}
		}
		else {
			
			for(String s : cs.getListaPosicionNoDeportiva()) {
				cbPosicion.addItem(s);
			}
		}
	}
	private JTable getTableModificar() {
		if (tableModificar == null) {
			tableModificar = new JTable();
			tableModificar.setForeground(new Color(0, 0, 0));
			tableModificar.setFont(new Font("Tahoma", Font.PLAIN, 15));
			tableModificar.setModel(tableModelModificar);
			tableModificar.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return tableModificar;
	}
	private JTable getTableEliminar() {
		if (tableEliminar == null) {
			tableEliminar = new JTable();
			tableEliminar.setForeground(new Color(0, 0, 0));
			tableEliminar.setFont(new Font("Tahoma", Font.PLAIN, 15));
			tableEliminar.setModel(tableModelEliminar);
			tableEliminar.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return tableEliminar;
	}
}
