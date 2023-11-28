package ips2023pl21.ui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ips2023pl21.model.compras.JugadoresEnVenta;
import ips2023pl21.model.equipos.Equipo;
import ips2023pl21.service.Service23559;
import ips2023pl21.util.Util;

import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frame23559 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Service23559 cs;
	private JLabel lbTitulo;
	private JPanel pnCentro;
	private JPanel pnEquipo;
	private JPanel pnCompra;
	private JPanel pnSalario;
	private JPanel pnVenta;
	private JLabel lbEquipo;
	private JPanel pnBotones;
	private JButton btComprar;
	private JButton btVender;
	private JPanel pnEquipos;
	private JScrollPane scrEquipos;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTable tableEquipos;
	private DefaultTableModel tableModelEquipos = new DefaultTableModel(
			new String[][] {
			},
			new String[] {
				"ID Equipo", "Nombre Equipo", "Número de jugadores"
			}
		) {
			private static final long serialVersionUID = 1L;
	
			@Override
		    public boolean isCellEditable(int row, int column) {
		        return false;
	    }
	};
	private JLabel lbCompra;
	private JPanel pnBotonesCompra;
	private JButton btComprarJugador;
	private JButton btCancelarJugador;
	private JPanel pnJugadores;
	private JScrollPane scrJugadores;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JTable tableJugadores;
	private DefaultTableModel tableModelJugadores = new DefaultTableModel(
			new String[][] {
			},
			new String[] {
				"DNI", "Nombre", "Apellido", "Teléfono", "Nacimiento", "Edad", "Precio"
			}
		) {
			private static final long serialVersionUID = 1L;
	
			@Override
		    public boolean isCellEditable(int row, int column) {
		        return false;
	    }
	};
	private JLabel lbSalario;
	private JPanel pnIntroducirSalario;
	private JPanel pnBotonesSalario;
	private JButton btAceptar;
	private JButton btCancelarSalario;
	private JLabel lblNewLabel_8;
	private JLabel lbAsignarSalario;
	private JLabel lbSalarioAnual;
	private JTextField txSalario;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_14;
	private JLabel lbJugadoresEquipo;
	private JPanel pnBotonesVenta;
	private JButton btVenta;
	private JButton btCancelarVenta;
	private JPanel pnJugadoresEquipo;
	private JScrollPane scrJugadoresEquipo;
	private JLabel lblNewLabel_15;
	private JLabel lblNewLabel_16;
	private JLabel lblNewLabel_17;
	private JLabel lblNewLabel_18;
	private JTable tableJugadoresEquipo;
	private DefaultTableModel tableModelJugadoresEquipo = new DefaultTableModel(
			new String[][] {
			},
			new String[] {
				"ID", "Nombre", "Salario", "Precio de venta"
			}
		) {
			private static final long serialVersionUID = 1L;
	
			@Override
		    public boolean isCellEditable(int row, int column) {
		        return false;
	    }
	};
	
	public Frame23559(Service23559 cs) {
		this.cs = cs;
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				confirmarSalida();
			}
		});
		setTitle("Mercado de fichajes");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 727, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getLbTitulo(), BorderLayout.NORTH);
		contentPane.add(getPnCentro(), BorderLayout.CENTER);
		rellenarTablaEquipos();
	}
	
	private void confirmarSalida() {
		int respuesta = JOptionPane.showConfirmDialog(this, 
				"¿Está seguro de que quiere cerrar el mercado de fichajes?");
		if (respuesta == JOptionPane.YES_OPTION) {
			dispose();
		}
	}

	private JLabel getLbTitulo() {
		if (lbTitulo == null) {
			lbTitulo = new JLabel("Mercado de fichajes");
			lbTitulo.setForeground(new Color(0, 0, 0));
			lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lbTitulo.setFont(new Font("Tahoma", Font.BOLD, 45));
		}
		return lbTitulo;
	}
	private JPanel getPnCentro() {
		if (pnCentro == null) {
			pnCentro = new JPanel();
			pnCentro.setLayout(new CardLayout(0, 0));
			pnCentro.add(getPnEquipo(), "pnEquipo");
			pnCentro.add(getPnCompra(), "pnCompra");
			pnCentro.add(getPnSalario(), "pnSalario");
			pnCentro.add(getPnVenta(), "pnVenta");
		}
		return pnCentro;
	}
	private JPanel getPnEquipo() {
		if (pnEquipo == null) {
			pnEquipo = new JPanel();
			pnEquipo.setLayout(new BorderLayout(0, 0));
			pnEquipo.add(getLbEquipo(), BorderLayout.NORTH);
			pnEquipo.add(getPnBotones(), BorderLayout.SOUTH);
			pnEquipo.add(getPnEquipos(), BorderLayout.CENTER);
		}
		return pnEquipo;
	}
	private JPanel getPnCompra() {
		if (pnCompra == null) {
			pnCompra = new JPanel();
			pnCompra.setLayout(new BorderLayout(0, 0));
			pnCompra.add(getLbCompra(), BorderLayout.NORTH);
			pnCompra.add(getPnBotonesCompra(), BorderLayout.SOUTH);
			pnCompra.add(getPnJugadores(), BorderLayout.CENTER);
			pnCompra.add(getLblNewLabel_5(), BorderLayout.WEST);
		}
		return pnCompra;
	}
	private JPanel getPnSalario() {
		if (pnSalario == null) {
			pnSalario = new JPanel();
			pnSalario.setLayout(new BorderLayout(0, 0));
			pnSalario.add(getLbSalario(), BorderLayout.NORTH);
			pnSalario.add(getPnIntroducirSalario(), BorderLayout.CENTER);
			pnSalario.add(getPnBotonesSalario(), BorderLayout.SOUTH);
		}
		return pnSalario;
	}
	private JPanel getPnVenta() {
		if (pnVenta == null) {
			pnVenta = new JPanel();
			pnVenta.setLayout(new BorderLayout(0, 0));
			pnVenta.add(getLbJugadoresEquipo(), BorderLayout.NORTH);
			pnVenta.add(getPnBotonesVenta(), BorderLayout.SOUTH);
			pnVenta.add(getPnJugadoresEquipo(), BorderLayout.CENTER);
		}
		return pnVenta;
	}
	private JLabel getLbEquipo() {
		if (lbEquipo == null) {
			lbEquipo = new JLabel("Selecciona el equipo sobre el que vas a trabajar:");
			lbEquipo.setForeground(new Color(0, 0, 0));
			lbEquipo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lbEquipo;
	}
	private JPanel getPnBotones() {
		if (pnBotones == null) {
			pnBotones = new JPanel();
			pnBotones.add(getBtComprar());
			pnBotones.add(getBtVender());
		}
		return pnBotones;
	}
	private JButton getBtComprar() {
		if (btComprar == null) {
			btComprar = new JButton("Comprar");
			btComprar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (getTableEquipos().getSelectedRows().length < 1) {
						JOptionPane.showMessageDialog(null, 
								"No hay ningún equipo seleccionado.");
						return;
					}
					int idEquipo = (int) getTableEquipos().getValueAt(getTableEquipos().getSelectedRow(), 0);
					cs.setEquipo(idEquipo);
					rellenarTablaJugadores();
					mostrarPnCompra();
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
			btVender.setForeground(new Color(0, 0, 0));
			btVender.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return btVender;
	}
	private JPanel getPnEquipos() {
		if (pnEquipos == null) {
			pnEquipos = new JPanel();
			pnEquipos.setLayout(new BorderLayout(0, 0));
			pnEquipos.add(getScrEquipos());
			pnEquipos.add(getLblNewLabel_2(), BorderLayout.WEST);
			pnEquipos.add(getLblNewLabel_3(), BorderLayout.EAST);
			pnEquipos.add(getLblNewLabel(), BorderLayout.NORTH);
			pnEquipos.add(getLblNewLabel_1(), BorderLayout.SOUTH);
		}
		return pnEquipos;
	}
	private JScrollPane getScrEquipos() {
		if (scrEquipos == null) {
			scrEquipos = new JScrollPane();
			scrEquipos.setViewportView(getTableEquipos());
		}
		return scrEquipos;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("                   ");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("                   ");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel(" ");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel(" ");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lblNewLabel_1;
	}
	private JTable getTableEquipos() {
		if (tableEquipos == null) {
			tableEquipos = new JTable();
			tableEquipos.setForeground(new Color(0, 0, 0));
			tableEquipos.setFont(new Font("Tahoma", Font.PLAIN, 16));
			tableEquipos.setModel(tableModelEquipos);
			tableEquipos.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return tableEquipos;
	}
	private JLabel getLbCompra() {
		if (lbCompra == null) {
			lbCompra = new JLabel("Jugadores disponibles para el equipo seleccionado:");
			lbCompra.setForeground(new Color(0, 0, 0));
			lbCompra.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lbCompra;
	}
	private JPanel getPnBotonesCompra() {
		if (pnBotonesCompra == null) {
			pnBotonesCompra = new JPanel();
			pnBotonesCompra.add(getBtComprarJugador());
			pnBotonesCompra.add(getBtCancelarJugador());
		}
		return pnBotonesCompra;
	}
	private JButton getBtComprarJugador() {
		if (btComprarJugador == null) {
			btComprarJugador = new JButton("Comprar");
			btComprarJugador.setForeground(new Color(0, 0, 0));
			btComprarJugador.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return btComprarJugador;
	}
	private JButton getBtCancelarJugador() {
		if (btCancelarJugador == null) {
			btCancelarJugador = new JButton("Cancelar");
			btCancelarJugador.setForeground(new Color(0, 0, 0));
			btCancelarJugador.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return btCancelarJugador;
	}
	private JPanel getPnJugadores() {
		if (pnJugadores == null) {
			pnJugadores = new JPanel();
			pnJugadores.setLayout(new BorderLayout(0, 0));
			pnJugadores.add(getScrollPane_1(), BorderLayout.CENTER);
			pnJugadores.add(getLblNewLabel_4(), BorderLayout.NORTH);
			pnJugadores.add(getLblNewLabel_6(), BorderLayout.SOUTH);
			pnJugadores.add(getLblNewLabel_7(), BorderLayout.EAST);
		}
		return pnJugadores;
	}
	private JScrollPane getScrollPane_1() {
		if (scrJugadores == null) {
			scrJugadores = new JScrollPane();
			scrJugadores.setViewportView(getTableJugadores());
		}
		return scrJugadores;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel(" ");
			lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lblNewLabel_4;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("            ");
			lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lblNewLabel_5;
	}
	private JLabel getLblNewLabel_6() {
		if (lblNewLabel_6 == null) {
			lblNewLabel_6 = new JLabel(" ");
			lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lblNewLabel_6;
	}
	private JLabel getLblNewLabel_7() {
		if (lblNewLabel_7 == null) {
			lblNewLabel_7 = new JLabel("          ");
			lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lblNewLabel_7;
	}
	private JTable getTableJugadores() {
		if (tableJugadores == null) {
			tableJugadores = new JTable();
			tableJugadores.setModel(tableModelJugadores);
			tableJugadores.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return tableJugadores;
	}
	private JLabel getLbSalario() {
		if (lbSalario == null) {
			lbSalario = new JLabel("¿Está seguro de que quiere fichar a "
					+ ""+ cs.getCompra().getNombre()+ " "
							+ cs.getCompra().getApellido()+ " por "
									+ cs.getCompra().getPrecio()+ "€?");
			
			lbSalario.setForeground(new Color(0, 0, 0));
			lbSalario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lbSalario;
	}
	private JPanel getPnIntroducirSalario() {
		if (pnIntroducirSalario == null) {
			pnIntroducirSalario = new JPanel();
			pnIntroducirSalario.setLayout(new GridLayout(0, 3, 0, 0));
			pnIntroducirSalario.add(getLbAsignarSalario());
			pnIntroducirSalario.add(getLblNewLabel_11());
			pnIntroducirSalario.add(getLblNewLabel_9());
			pnIntroducirSalario.add(getLbSalarioAnual());
			pnIntroducirSalario.add(getTxSalario());
			pnIntroducirSalario.add(getLblNewLabel_8());
			pnIntroducirSalario.add(getLblNewLabel_10());
			pnIntroducirSalario.add(getLblNewLabel_14());
			pnIntroducirSalario.add(getLblNewLabel_12());
			pnIntroducirSalario.add(getLblNewLabel_13());
		}
		return pnIntroducirSalario;
	}
	private JPanel getPnBotonesSalario() {
		if (pnBotonesSalario == null) {
			pnBotonesSalario = new JPanel();
			pnBotonesSalario.add(getBtAceptar());
			pnBotonesSalario.add(getBtCancelarSalario());
		}
		return pnBotonesSalario;
	}
	private JButton getBtAceptar() {
		if (btAceptar == null) {
			btAceptar = new JButton("Aceptar");
			btAceptar.setForeground(new Color(0, 0, 0));
			btAceptar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return btAceptar;
	}
	private JButton getBtCancelarSalario() {
		if (btCancelarSalario == null) {
			btCancelarSalario = new JButton("Cancelar");
			btCancelarSalario.setForeground(new Color(0, 0, 0));
			btCancelarSalario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return btCancelarSalario;
	}
	private JLabel getLblNewLabel_8() {
		if (lblNewLabel_8 == null) {
			lblNewLabel_8 = new JLabel("€");
			lblNewLabel_8.setForeground(new Color(0, 0, 0));
			lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lblNewLabel_8;
	}
	private JLabel getLbAsignarSalario() {
		if (lbAsignarSalario == null) {
			lbAsignarSalario = new JLabel("Asígnele un salario: ");
			lbAsignarSalario.setHorizontalAlignment(SwingConstants.CENTER);
			lbAsignarSalario.setForeground(new Color(0, 0, 0));
			lbAsignarSalario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lbAsignarSalario;
	}
	private JLabel getLbSalarioAnual() {
		if (lbSalarioAnual == null) {
			lbSalarioAnual = new JLabel("Salario anual:");
			lbSalarioAnual.setHorizontalAlignment(SwingConstants.CENTER);
			lbSalarioAnual.setForeground(new Color(0, 0, 0));
			lbSalarioAnual.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lbSalarioAnual;
	}
	private JTextField getTxSalario() {
		if (txSalario == null) {
			txSalario = new JTextField();
			txSalario.setForeground(new Color(0, 0, 0));
			txSalario.setFont(new Font("Tahoma", Font.PLAIN, 18));
			txSalario.setColumns(10);
		}
		return txSalario;
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
	private JLabel getLblNewLabel_13() {
		if (lblNewLabel_13 == null) {
			lblNewLabel_13 = new JLabel("");
		}
		return lblNewLabel_13;
	}
	private JLabel getLblNewLabel_14() {
		if (lblNewLabel_14 == null) {
			lblNewLabel_14 = new JLabel("");
		}
		return lblNewLabel_14;
	}
	private JLabel getLbJugadoresEquipo() {
		if (lbJugadoresEquipo == null) {
			lbJugadoresEquipo = new JLabel("Jugadres del equipo seleccionado:");
			lbJugadoresEquipo.setForeground(new Color(0, 0, 0));
			lbJugadoresEquipo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lbJugadoresEquipo;
	}
	private JPanel getPnBotonesVenta() {
		if (pnBotonesVenta == null) {
			pnBotonesVenta = new JPanel();
			pnBotonesVenta.add(getBtVenta());
			pnBotonesVenta.add(getBtCancelarVenta());
		}
		return pnBotonesVenta;
	}
	private JButton getBtVenta() {
		if (btVenta == null) {
			btVenta = new JButton("Poner a la venta");
			btVenta.setForeground(new Color(0, 0, 0));
			btVenta.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return btVenta;
	}
	private JButton getBtCancelarVenta() {
		if (btCancelarVenta == null) {
			btCancelarVenta = new JButton("Cancelar");
			btCancelarVenta.setForeground(new Color(0, 0, 0));
			btCancelarVenta.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return btCancelarVenta;
	}
	private JPanel getPnJugadoresEquipo() {
		if (pnJugadoresEquipo == null) {
			pnJugadoresEquipo = new JPanel();
			pnJugadoresEquipo.setLayout(new BorderLayout(0, 0));
			pnJugadoresEquipo.add(getScrJugadoresEquipo(), BorderLayout.CENTER);
			pnJugadoresEquipo.add(getLblNewLabel_15(), BorderLayout.NORTH);
			pnJugadoresEquipo.add(getLblNewLabel_16(), BorderLayout.SOUTH);
			pnJugadoresEquipo.add(getLblNewLabel_17(), BorderLayout.WEST);
			pnJugadoresEquipo.add(getLblNewLabel_18(), BorderLayout.EAST);
		}
		return pnJugadoresEquipo;
	}
	private JScrollPane getScrJugadoresEquipo() {
		if (scrJugadoresEquipo == null) {
			scrJugadoresEquipo = new JScrollPane();
			scrJugadoresEquipo.setViewportView(getTableJugadoresEquipo());
		}
		return scrJugadoresEquipo;
	}
	private JLabel getLblNewLabel_15() {
		if (lblNewLabel_15 == null) {
			lblNewLabel_15 = new JLabel(" ");
			lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lblNewLabel_15;
	}
	private JLabel getLblNewLabel_16() {
		if (lblNewLabel_16 == null) {
			lblNewLabel_16 = new JLabel(" ");
			lblNewLabel_16.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lblNewLabel_16;
	}
	private JLabel getLblNewLabel_17() {
		if (lblNewLabel_17 == null) {
			lblNewLabel_17 = new JLabel("           ");
			lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lblNewLabel_17;
	}
	private JLabel getLblNewLabel_18() {
		if (lblNewLabel_18 == null) {
			lblNewLabel_18 = new JLabel("           ");
			lblNewLabel_18.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lblNewLabel_18;
	}
	private JTable getTableJugadoresEquipo() {
		if (tableJugadoresEquipo == null) {
			tableJugadoresEquipo = new JTable();
			tableJugadoresEquipo.setModel(tableModelJugadoresEquipo);
			tableJugadoresEquipo.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return tableJugadoresEquipo;
	}
	private void rellenarTablaEquipos() {
		tableModelEquipos.setRowCount(0);
		List<Equipo> equipos = cs.getEquipos();
		for (Equipo e : equipos) {
			tableModelEquipos.addRow(new Object[]
					{e.getId(), e.getNombre(), cs.getJugadoresEquipo(e.getId())});
		}
	}
	private void mostrarPnCompra() {
		((CardLayout) getPnCentro().getLayout()).show(getPnCentro(), "pnCompra");
	}
	private void rellenarTablaJugadores() {
		tableModelJugadores.setRowCount(0);
		List<JugadoresEnVenta> jugadores = cs.getJugadoresEnVenta();
		for (JugadoresEnVenta j : jugadores) {
			int edad = calculaEdad(j.getFechaNacimiento());
			tableModelJugadores.addRow(new Object[]
					{j.getDni(), j.getNombre(), j.getApellido(), j.getTelefono(), 
							j.getFechaNacimiento(), edad, j.getPrecio()});
		}
	}
	private int calculaEdad(String fecha) {
		LocalDate fechaNac = Util.isoStringToDate(fecha).
				toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate fechaActual = LocalDate.now();
		
		Period periodo = Period.between(fechaNac, fechaActual);
        int edad = periodo.getYears();
        
        return edad;
	}
}
