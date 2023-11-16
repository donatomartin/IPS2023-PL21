package ips2023pl21.ui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ips2023pl21.model.equipos.Equipo;
import ips2023pl21.service.Service23558;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;

public class Frame23558 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Service23558 cs;
	private JLabel lbTitulo;
	private JPanel pnBotonesAccion;
	private JButton btAñadir;
	private JButton btDarAlta;
	private JPanel pnSeleccion;
	private JPanel pnEquipo;
	private JPanel pnSanos;
	private JPanel pnLesionados;
	private JLabel lbEquipo;
	private JScrollPane scrEquipo;
	private JTable tableEquipos;
	private DefaultTableModel tableModelEquipos = new DefaultTableModel(
			new String[][] {
			},
			new String[] {
				"ID", "Nombre"
			}
		) {
			private static final long serialVersionUID = 1L;
	
			@Override
		    public boolean isCellEditable(int row, int column) {
		        return false;
	    }
	};
	private JLabel lbSanos;
	private JScrollPane scrSanos;
	private JTable tableSanos;
	private DefaultTableModel tableModelSanos = new DefaultTableModel(
			new String[][] {
			},
			new String[] {
				"ID", "Nombre"
			}
		) {
			private static final long serialVersionUID = 1L;
	
			@Override
		    public boolean isCellEditable(int row, int column) {
		        return false;
	    }
	};
	private JLabel lbLesionados;
	private JScrollPane scrLesionados;
	private JTable tableLesionados;

	/**
	 * Create the frame.
	 */
	public Frame23558(Service23558 cs) {
		setTitle("Seguimiento de lesiones");
		this.cs = cs;
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				confirmarSalida();
			}
		});
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 794, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getLbTitulo(), BorderLayout.NORTH);
		contentPane.add(getPnBotonesAccion(), BorderLayout.SOUTH);
		contentPane.add(getPnSeleccion(), BorderLayout.CENTER);
		rellenarTablaEquipos();
	}
	
	private void confirmarSalida() {
		int respuesta = JOptionPane.showConfirmDialog(this, 
				"¿Está seguro de que quiere cerrar el seguimiento de lesiones?");
		if (respuesta == JOptionPane.YES_OPTION) {
			dispose();
		}
	}

	private JLabel getLbTitulo() {
		if (lbTitulo == null) {
			lbTitulo = new JLabel("Seguimiento de lesiones");
			lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lbTitulo.setFont(new Font("Tahoma", Font.BOLD, 45));
		}
		return lbTitulo;
	}
	private JPanel getPnBotonesAccion() {
		if (pnBotonesAccion == null) {
			pnBotonesAccion = new JPanel();
			pnBotonesAccion.add(getBtAñadir());
			pnBotonesAccion.add(getBtDarAlta());
		}
		return pnBotonesAccion;
	}
	private JButton getBtAñadir() {
		if (btAñadir == null) {
			btAñadir = new JButton("Añadir lesionado");
			btAñadir.setForeground(new Color(0, 0, 0));
			btAñadir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return btAñadir;
	}
	private JButton getBtDarAlta() {
		if (btDarAlta == null) {
			btDarAlta = new JButton("Dar de alta");
			btDarAlta.setForeground(new Color(0, 0, 0));
			btDarAlta.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return btDarAlta;
	}
	private JPanel getPnSeleccion() {
		if (pnSeleccion == null) {
			pnSeleccion = new JPanel();
			pnSeleccion.setLayout(new GridLayout(1, 3, 20, 0));
			pnSeleccion.add(getPnEquipo());
			pnSeleccion.add(getPnSanos());
			pnSeleccion.add(getPnLesionados());
		}
		return pnSeleccion;
	}
	private JPanel getPnEquipo() {
		if (pnEquipo == null) {
			pnEquipo = new JPanel();
			pnEquipo.setLayout(new BorderLayout(0, 0));
			pnEquipo.add(getLbEquipo(), BorderLayout.NORTH);
			pnEquipo.add(getScrEquipo(), BorderLayout.CENTER);
		}
		return pnEquipo;
	}
	private JPanel getPnSanos() {
		if (pnSanos == null) {
			pnSanos = new JPanel();
			pnSanos.setLayout(new BorderLayout(0, 0));
			pnSanos.add(getLbSanos(), BorderLayout.NORTH);
			pnSanos.add(getScrSanos(), BorderLayout.CENTER);
		}
		return pnSanos;
	}
	private JPanel getPnLesionados() {
		if (pnLesionados == null) {
			pnLesionados = new JPanel();
			pnLesionados.setLayout(new BorderLayout(0, 0));
			pnLesionados.add(getLbLesionados(), BorderLayout.NORTH);
			pnLesionados.add(getScrLesionados(), BorderLayout.CENTER);
		}
		return pnLesionados;
	}
	private JLabel getLbEquipo() {
		if (lbEquipo == null) {
			lbEquipo = new JLabel("Selecciona equipo:");
			lbEquipo.setForeground(new Color(0, 0, 0));
			lbEquipo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lbEquipo;
	}
	private JScrollPane getScrEquipo() {
		if (scrEquipo == null) {
			scrEquipo = new JScrollPane();
			scrEquipo.setViewportView(getTableEquipos());
		}
		return scrEquipo;
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
	private JLabel getLbSanos() {
		if (lbSanos == null) {
			lbSanos = new JLabel("Selecciona jugador sano:");
			lbSanos.setForeground(new Color(0, 0, 0));
			lbSanos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lbSanos;
	}
	private JScrollPane getScrSanos() {
		if (scrSanos == null) {
			scrSanos = new JScrollPane();
			scrSanos.setViewportView(getTableSanos());
		}
		return scrSanos;
	}
	private JTable getTableSanos() {
		if (tableSanos == null) {
			tableSanos = new JTable();
			tableSanos.setForeground(new Color(0, 0, 0));
			tableSanos.setFont(new Font("Tahoma", Font.PLAIN, 16));
			tableSanos.setModel(tableModelSanos);
			tableSanos.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return tableSanos;
	}
	private JLabel getLbLesionados() {
		if (lbLesionados == null) {
			lbLesionados = new JLabel("Selecciona jugador lesionado:");
			lbLesionados.setForeground(new Color(0, 0, 0));
			lbLesionados.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lbLesionados;
	}
	private JScrollPane getScrLesionados() {
		if (scrLesionados == null) {
			scrLesionados = new JScrollPane();
			scrLesionados.setViewportView(getTableLesionados());
		}
		return scrLesionados;
	}
	private JTable getTableLesionados() {
		if (tableLesionados == null) {
			tableLesionados = new JTable();
			tableLesionados.setForeground(new Color(0, 0, 0));
			tableLesionados.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return tableLesionados;
	}
	private void rellenarTablaEquipos() {
		tableModelEquipos.setRowCount(0);
		List<Equipo> equipos = cs.getEquipos();
		for (Equipo e : equipos) {
			tableModelEquipos.addRow(new Object[]
					{e.getId(), e.getNombre()});
		}
	}
	private void rellenarTablaSanos() {
		
	}
}
