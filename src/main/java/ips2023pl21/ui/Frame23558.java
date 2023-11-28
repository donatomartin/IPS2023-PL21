package ips2023pl21.ui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import ips2023pl21.model.Empleado;
import ips2023pl21.model.equipos.Equipo;
import ips2023pl21.model.equipos.Partido;
import ips2023pl21.model.horarios.HorarioEntrenamiento;
import ips2023pl21.model.lesiones.Actualizacion;
import ips2023pl21.service.Service23558;
import ips2023pl21.util.Util;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerDateModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSpinner;

public class Frame23558 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Service23558 cs;
	private JLabel lbTitulo;
	private JPanel pnPrincipal;
	private JPanel pnSeleccionAccion;
	private JPanel pnBotonesAccion;
	private JButton btAñadir;
	private JButton btDarAlta;
	private JPanel pnSeleccionJugadores;
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
	private ListSelectionModel  selectionModelEquipo;
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
	private DefaultTableModel tableModelLesionados = new DefaultTableModel(
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
	private JPanel pnAñadirLesion;
	private JPanel pnOrigen;
	private JPanel pnDatosLesion;
	private JPanel pnAñadir;
	private JPanel pnLesionado;
	private JPanel pnCausa;
	private JLabel lbAñadir;
	private JLabel lbLesionado;
	private JLabel lblNewLabel;
	private JPanel pnRadioBotones;
	private JRadioButton rbEntrenamiento;
	private JRadioButton rbPartido;
	private JRadioButton rbCausaAjena;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btAñadirLesion;
	private JButton btCancelar;
	private JPanel pnCausaAjena;
	private JScrollPane scrEntrenamientos;
	private JScrollPane scrPartidos;
	private JTable tableEntrenamientos;
	private DefaultTableModel tableModelEntrenamientos = new DefaultTableModel(
			new String[][] {
			},
			new String[] {
				"ID", "Hora"
			}
		) {
			private static final long serialVersionUID = 1L;
	
			@Override
		    public boolean isCellEditable(int row, int column) {
		        return false;
	    }
	};
	private JTable tablePartidos;
	private DefaultTableModel tableModelPartidos = new DefaultTableModel(
			new String[][] {
			},
			new String[] {
				"ID", "Fecha"
			}
		) {
			private static final long serialVersionUID = 1L;
	
			@Override
		    public boolean isCellEditable(int row, int column) {
		        return false;
	    }
	};
	private JTextPane txCausasAjenas;
	private JButton btActualizar;
	private ActualizarLesion actualiza;
	private JPanel pnFecha;
	private JLabel lblNewLabel_3;
	private JSpinner spFecha;
	private JLabel lblNewLabel_4;
	private JLabel lbFecha;

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
		setBounds(100, 100, 794, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPnPrincipal(), BorderLayout.CENTER);
		contentPane.add(getLbTitulo(), BorderLayout.NORTH);
		rellenarTablaEquipos();
	}
	
	private void confirmarSalida() {
		int respuesta = JOptionPane.showConfirmDialog(this, 
				"¿Está seguro de que quiere cerrar el seguimiento de lesiones?");
		if (respuesta == JOptionPane.YES_OPTION) {
			dispose();
		}
	}
	
	private JPanel getPnPrincipal() {
		if (pnPrincipal == null) {
			pnPrincipal = new JPanel();
			pnPrincipal.setLayout(new CardLayout(0,0));
			pnPrincipal.add(getPnSeleccionAccion(), "pnSeleccionAccion");
			pnPrincipal.add(getPnAñadirLesion(), "pnAñadirLesion");
		}
		return pnPrincipal;
	}
	
	private JPanel getPnSeleccionAccion() {
		if (pnSeleccionAccion == null) {
			pnSeleccionAccion = new JPanel();
			pnSeleccionAccion.setLayout(new BorderLayout(0,0));
			pnSeleccionAccion.add(getPnBotonesAccion(), BorderLayout.SOUTH);
			pnSeleccionAccion.add(getPnSeleccionJugadores(), BorderLayout.CENTER);
		}
		return pnSeleccionAccion;
	}

	private JLabel getLbTitulo() {
		if (lbTitulo == null) {
			lbTitulo = new JLabel("Seguimiento de lesiones");
			lbTitulo.setForeground(new Color(0, 0, 0));
			lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			lbTitulo.setFont(new Font("Tahoma", Font.BOLD, 45));
		}
		return lbTitulo;
	}
	private JPanel getPnBotonesAccion() {
		if (pnBotonesAccion == null) {
			pnBotonesAccion = new JPanel();
			pnBotonesAccion.add(getBtAñadir());
			pnBotonesAccion.add(getBtActualizar());
			pnBotonesAccion.add(getBtDarAlta());
		}
		return pnBotonesAccion;
	}
	private JButton getBtAñadir() {
		if (btAñadir == null) {
			btAñadir = new JButton("Añadir lesionado");
			btAñadir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (getTableSanos().getSelectedRows().length < 1) {
						JOptionPane.showMessageDialog(null, 
								"No hay ningún jugador seleccionado en la tabla de jugadores sanos");
						return;
					}
					int respuesta = JOptionPane.showConfirmDialog(null, 
							"Está seguro de que quiere dar de baja al jugador seleccionado?");
					if (respuesta == JOptionPane.YES_OPTION) {
						int fila = getTableSanos().getSelectedRow();
						String eid = getTableSanos().getValueAt(fila, 0).toString();
						cs.setLesionado(eid);
						getLbLesionado().setText(cs.getLesionado().getNombre()+" "+cs.getLesionado().getApellido());
						mostrarPnAñadirLesion();
						rellenarTablaEntrenamientos();
						rellenarTablaPartidos();
					}
					
				}
			});
			btAñadir.setForeground(new Color(0, 0, 0));
			btAñadir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return btAñadir;
	}
	private JButton getBtDarAlta() {
		if (btDarAlta == null) {
			btDarAlta = new JButton("Dar de alta");
			btDarAlta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (getTableLesionados().getSelectedRows().length < 1) {
						JOptionPane.showMessageDialog(null, 
								"No hay ningún jugador seleccionado en la tabla de jugadores lesionados");
						return;
					}
					int respuesta = JOptionPane.showConfirmDialog(null, 
							"¿Está seguro de que quiere dar de alta al jugador seleccionado?");
					if (respuesta == JOptionPane.YES_OPTION) {
						eliminarLesionado();
						eliminarActualizacionesLesionado();
						rellenarTablaSanos();
						rellenarTablaLesionados();
					}
				}
			});
			btDarAlta.setForeground(new Color(0, 0, 0));
			btDarAlta.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return btDarAlta;
	}
	private JPanel getPnSeleccionJugadores() {
		if (pnSeleccionJugadores == null) {
			pnSeleccionJugadores = new JPanel();
			pnSeleccionJugadores.setLayout(new GridLayout(1, 3, 20, 0));
			pnSeleccionJugadores.add(getPnEquipo());
			pnSeleccionJugadores.add(getPnSanos());
			pnSeleccionJugadores.add(getPnLesionados());
		}
		return pnSeleccionJugadores;
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
			selectionModelEquipo = tableEquipos.getSelectionModel();
			selectionModelEquipo.addListSelectionListener(new ListSelectionListener() {
	            @Override
	            public void valueChanged(ListSelectionEvent e) {
	                if (!e.getValueIsAdjusting()) { 
	                    rellenarTablaSanos();
	                    rellenarTablaLesionados();
	                }
	            }
	        });
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
			tableLesionados.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (e.getClickCount()== 2) {
						int row = getTableLesionados().getSelectedRow();
						String eid = getTableLesionados().getValueAt(row, 0).toString();
						cs.setLesionado(eid);
						
						actualiza = new ActualizarLesion(cs);
						actualiza.getLbNombreYApellido_1().setText(cs.getLesionado().getNombre()+" "+cs.getLesionado().getApellido());
						actualiza.escribeActualizaciones(cs);
						actualiza.mostrarPnVisualizarActualizacion();
						actualiza.setVisible(true);
					}
				}
			});
			tableLesionados.setForeground(new Color(0, 0, 0));
			tableLesionados.setFont(new Font("Tahoma", Font.PLAIN, 16));
			tableLesionados.setModel(tableModelLesionados);
			tableLesionados.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
		tableModelSanos.setRowCount(0);
		int fila = getTableEquipos().getSelectedRow();
		String eqid = getTableEquipos().getValueAt(fila, 0).toString();
		List<Empleado> jugadoresEquipo = cs.getJugadoresEquipo(eqid);
		List<Empleado> sanos = new ArrayList<Empleado>();
		for (Empleado e : jugadoresEquipo) {
			if (!cs.isLesionado(e.getEid())) {
				sanos.add(e);
			}
		}
		
		for (Empleado e : sanos) {
			tableModelSanos.addRow(new Object[]
					{e.getEid(), e.getNombre()});
		}
	}
	
	private void rellenarTablaLesionados() {
		tableModelLesionados.setRowCount(0);
		int fila = getTableEquipos().getSelectedRow();
		String eqid = getTableEquipos().getValueAt(fila, 0).toString();
		List<Empleado> jugadoresEquipo = cs.getJugadoresEquipo(eqid);
		
		List<Empleado> lesionados = new ArrayList<Empleado>();
		for (Empleado e : jugadoresEquipo) {
			if (cs.isLesionado(e.getEid())) {
				lesionados.add(e);
			}
		}
		
		for (Empleado e : lesionados) {
			tableModelLesionados.addRow(new Object[]
					{e.getEid(), e.getNombre()});
		}
	}
	private void eliminarLesionado() {
		int fila = getTableLesionados().getSelectedRow();
		String eid = getTableLesionados().getValueAt(fila, 0).toString();
		cs.eliminarLesionado(eid);
	}
	private JPanel getPnAñadirLesion() {
		if (pnAñadirLesion == null) {
			pnAñadirLesion = new JPanel();
			pnAñadirLesion.setLayout(new BorderLayout(0, 0));
			pnAñadirLesion.add(getPnOrigen(), BorderLayout.NORTH);
			pnAñadirLesion.add(getPnDatosLesion());
			pnAñadirLesion.add(getPnAñadir(), BorderLayout.SOUTH);
		}
		return pnAñadirLesion;
	}
	private void mostrarPnAñadirLesion() {
		((CardLayout) getPnPrincipal().getLayout()).show(getPnPrincipal(), "pnAñadirLesion");
		getTableSanos().clearSelection();
		getTableLesionados().clearSelection();
	}
	private JPanel getPnOrigen() {
		if (pnOrigen == null) {
			pnOrigen = new JPanel();
			pnOrigen.setLayout(new GridLayout(2, 1, 0, 0));
			pnOrigen.add(getPnLesionado());
			pnOrigen.add(getPnCausa());
		}
		return pnOrigen;
	}
	private JPanel getPnDatosLesion() {
		if (pnDatosLesion == null) {
			pnDatosLesion = new JPanel();
			pnDatosLesion.setLayout(new GridLayout(1, 3, 0, 0));
			pnDatosLesion.add(getScrEntrenamientos());
			pnDatosLesion.add(getScrPartidos());
			pnDatosLesion.add(getPnCausaAjena());
		}
		return pnDatosLesion;
	}
	private JPanel getPnAñadir() {
		if (pnAñadir == null) {
			pnAñadir = new JPanel();
			pnAñadir.add(getBtAñadirLesion());
			pnAñadir.add(getBtCancelar());
		}
		return pnAñadir;
	}
	private JPanel getPnLesionado() {
		if (pnLesionado == null) {
			pnLesionado = new JPanel();
			pnLesionado.setLayout(new GridLayout(0, 2, 0, 0));
			pnLesionado.add(getLbAñadir());
			pnLesionado.add(getLbLesionado());
		}
		return pnLesionado;
	}
	private JPanel getPnCausa() {
		if (pnCausa == null) {
			pnCausa = new JPanel();
			pnCausa.setLayout(new GridLayout(2, 1, 0, 0));
			pnCausa.add(getLblNewLabel());
			pnCausa.add(getPnRadioBotones());
		}
		return pnCausa;
	}
	private JLabel getLbAñadir() {
		if (lbAñadir == null) {
			lbAñadir = new JLabel("Añadir a lesionados:");
			lbAñadir.setForeground(new Color(0, 0, 0));
			lbAñadir.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lbAñadir.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lbAñadir;
	}
	private JLabel getLbLesionado() {
		if (lbLesionado == null) {
			lbLesionado = new JLabel("");
			lbLesionado.setForeground(new Color(0, 0, 0));
			lbLesionado.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lbLesionado.setText("");
		}
		return lbLesionado;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Seleccione el origen de la lesión:");
			lblNewLabel.setForeground(new Color(0, 0, 0));
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lblNewLabel;
	}
	private JPanel getPnRadioBotones() {
		if (pnRadioBotones == null) {
			pnRadioBotones = new JPanel();
			pnRadioBotones.setLayout(new GridLayout(1, 3, 0, 0));
			pnRadioBotones.add(getRbEntrenamiento());
			pnRadioBotones.add(getRbPartido());
			pnRadioBotones.add(getRbCausaAjena());
		}
		return pnRadioBotones;
	}
	private JRadioButton getRbEntrenamiento() {
		if (rbEntrenamiento == null) {
			rbEntrenamiento = new JRadioButton("Entrenamiento");
			rbEntrenamiento.setSelected(true);
			buttonGroup.add(rbEntrenamiento);
			rbEntrenamiento.setForeground(new Color(0, 0, 0));
			rbEntrenamiento.setHorizontalAlignment(SwingConstants.CENTER);
			rbEntrenamiento.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return rbEntrenamiento;
	}
	private JRadioButton getRbPartido() {
		if (rbPartido == null) {
			rbPartido = new JRadioButton("Partido");
			buttonGroup.add(rbPartido);
			rbPartido.setForeground(new Color(0, 0, 0));
			rbPartido.setHorizontalAlignment(SwingConstants.CENTER);
			rbPartido.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return rbPartido;
	}
	private JRadioButton getRbCausaAjena() {
		if (rbCausaAjena == null) {
			rbCausaAjena = new JRadioButton("Causa ajena");
			rbCausaAjena.setForeground(new Color(0, 0, 0));
			buttonGroup.add(rbCausaAjena);
			rbCausaAjena.setHorizontalAlignment(SwingConstants.CENTER);
			rbCausaAjena.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return rbCausaAjena;
	}
	private JButton getBtAñadirLesion() {
		if (btAñadirLesion == null) {
			btAñadirLesion = new JButton("Añadir");
			btAñadirLesion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (getRbEntrenamiento().isSelected()) {
						if (getTableEntrenamientos().getSelectedRows().length < 1) {
							JOptionPane.showMessageDialog(null, 
									"No hay ningún entrenamiento seleccionado");
							return;
						}
						int filaEnt = getTableEntrenamientos().getSelectedRow();
						Integer entId = (Integer) getTableEntrenamientos().getValueAt(filaEnt, 0);
						if (confirmarAccion()) {
							mostrarPnSeleccionAccion();
							cs.añadirLesionado(
									entId,
									null,
									getRbEntrenamiento().getText(), 
									getTxCausasAjenas().getText(), 
									getSpFecha().getValue().toString());
						}
					}
					
					else if (getRbPartido().isSelected()) {
						if (getTablePartidos().getSelectedRows().length < 1) {
							JOptionPane.showMessageDialog(null, 
									"No hay ningún partido seleccionado");
							return;
						}
						int filaPart = getTablePartidos().getSelectedRow(); 
						Integer partId = Integer.valueOf((String)getTablePartidos().getValueAt(filaPart, 0));
						if (confirmarAccion()) {
							mostrarPnSeleccionAccion(); 
							cs.añadirLesionado(
									null,
									partId,
									getRbPartido().getText(), 
									getTxCausasAjenas().getText(), 
									getSpFecha().getValue().toString());
						}
					}
					
					else {
						Date date = (Date)getSpFecha().getValue();
						if (date.after(Date.from(Instant.now()))) {
							JOptionPane.showMessageDialog(null, "La fecha seleccionada no es válida. Es futura.");
							return;
						}
						if (confirmarAccion()) {
							mostrarPnSeleccionAccion();
							cs.añadirLesionado(
									null, 
									null,
									getRbCausaAjena().getText(), 
									getTxCausasAjenas().getText(), 
									getSpFecha().getValue().toString());
						}
					}
					rellenarTablaLesionados();
					rellenarTablaSanos();
				}
			});
			btAñadirLesion.setForeground(new Color(0, 0, 0));
			btAñadirLesion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return btAñadirLesion;
	}
	private boolean confirmarAccion() {
		int respuesta = JOptionPane.showConfirmDialog(null, 
				"Está seguro de que quiere añadir a lesionados este jugador?");
		if (respuesta == JOptionPane.YES_OPTION) {
			return true;
		}
		return false;
	}
	private JButton getBtCancelar() {
		if (btCancelar == null) {
			btCancelar = new JButton("Cancelar");
			btCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPnSeleccionAccion();
				}
			});
			btCancelar.setForeground(new Color(0, 0, 0));
			btCancelar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return btCancelar;
	}
	private JPanel getPnCausaAjena() {
		if (pnCausaAjena == null) {
			pnCausaAjena = new JPanel();
			pnCausaAjena.setLayout(new GridLayout(2, 1, 0, 0));
			pnCausaAjena.add(getTxCausasAjenas());
			pnCausaAjena.add(getPnFecha());
		}
		return pnCausaAjena;
	}
	private JScrollPane getScrEntrenamientos() {
		if (scrEntrenamientos == null) {
			scrEntrenamientos = new JScrollPane();
			scrEntrenamientos.setViewportView(getTableEntrenamientos());
		}
		return scrEntrenamientos;
	}
	private JScrollPane getScrPartidos() {
		if (scrPartidos == null) {
			scrPartidos = new JScrollPane();
			scrPartidos.setViewportView(getTablePartidos());
		}
		return scrPartidos;
	}
	private JTable getTableEntrenamientos() {
		if (tableEntrenamientos == null) {
			tableEntrenamientos = new JTable();
			tableEntrenamientos.setFont(new Font("Tahoma", Font.PLAIN, 16));
			tableEntrenamientos.setForeground(new Color(0, 0, 0));
			tableEntrenamientos.setModel(tableModelEntrenamientos);
			tableEntrenamientos.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return tableEntrenamientos;
	}
	private JTable getTablePartidos() {
		if (tablePartidos == null) {
			tablePartidos = new JTable();
			tablePartidos.setForeground(new Color(0, 0, 0));
			tablePartidos.setFont(new Font("Tahoma", Font.PLAIN, 16));
			tablePartidos.setModel(tableModelPartidos);
			tablePartidos.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return tablePartidos;
	}
	private JTextPane getTxCausasAjenas() {
		if (txCausasAjenas == null) {
			txCausasAjenas = new JTextPane();
			txCausasAjenas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return txCausasAjenas;
	}
	private JButton getBtActualizar() {
		if (btActualizar == null) {
			btActualizar = new JButton("Actualizar lesionado");
			btActualizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (getTableLesionados().getSelectedRows().length < 1) {
						JOptionPane.showMessageDialog(null, 
								"No hay ningún jugador seleccionado en la tabla de jugadores lesionados");
						return;
					}
					int respuesta = JOptionPane.showConfirmDialog(null, 
							"¿Está seguro de que quiere actualizar el jugador seleccionado?");
					if (respuesta == JOptionPane.YES_OPTION) {
						int fila = getTableLesionados().getSelectedRow();
						String eid = getTableLesionados().getValueAt(fila, 0).toString();
						cs.setLesionado(eid);
						mostrarPnActualizarLesionado();
					}
				}
			});
			btActualizar.setForeground(new Color(0, 0, 0));
			btActualizar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return btActualizar;
	}
	private void mostrarPnActualizarLesionado() {
		actualiza = new ActualizarLesion(cs);
		actualiza.getLbNombreYApellido().setText(cs.getLesionado().getNombre()+" "+cs.getLesionado().getApellido());
		actualiza.mostrarPnAñadirActuazalizacion();
		actualiza.setVisible(true);
	}
	private void mostrarPnSeleccionAccion() {
		((CardLayout) getPnPrincipal().getLayout()).show(getPnPrincipal(), "pnSeleccionAccion");
		getRbEntrenamiento().setSelected(true);
		getTxCausasAjenas().setText("");
	}
	private void rellenarTablaEntrenamientos() {
		while (getTableEntrenamientos().getModel().getRowCount()>0) {
			DefaultTableModel modelo = (DefaultTableModel) getTableEntrenamientos().getModel();
			modelo.removeRow(0);
		}
		int fila = getTableEquipos().getSelectedRow();
		String equipoId = getTableEquipos().getValueAt(fila, 0).toString();
		List<HorarioEntrenamiento> entrenos = cs.getEntrenamientos(equipoId);
		
		for (HorarioEntrenamiento e : entrenos) {
			Date date = Util.isoStringToDate(e.getFechaEntrenamiento());
			if (date.before(Date.from(Instant.now()))) {
				tableModelEntrenamientos.addRow(new Object[]
						{e.getId(), e.getFechaEntrenamiento()});
			}
		}
	}
	private void rellenarTablaPartidos() {
		while (getTablePartidos().getModel().getRowCount()>0) {
			DefaultTableModel modelo = (DefaultTableModel) getTablePartidos().getModel();
			modelo.removeRow(0);
		}
		int fila = getTableEquipos().getSelectedRow();
		String equipoId = getTableEquipos().getValueAt(fila, 0).toString();
		List<Partido> partidos = cs.getPartidos(equipoId);
		
		for (Partido e : partidos) {
			Date date = Util.isoStringToDate(e.getFecha());
			if (date.before(Date.from(Instant.now()))) {
				tableModelPartidos.addRow(new Object[]
						{e.getId(), e.getFecha()});
			}
		}
	}
	private JPanel getPnFecha() {
		if (pnFecha == null) {
			pnFecha = new JPanel();
			pnFecha.setLayout(new GridLayout(3, 2, 0, 0));
			pnFecha.add(getLblNewLabel_3());
			pnFecha.add(getLblNewLabel_4());
			pnFecha.add(getLbFecha());
			pnFecha.add(getSpFecha());
		}
		return pnFecha;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("");
		}
		return lblNewLabel_3;
	}
	private JSpinner getSpFecha() {
		if (spFecha == null) {
			spFecha = new JSpinner();
			spFecha.setFont(new Font("Tahoma", Font.PLAIN, 16));
			spFecha.setModel(new SpinnerDateModel(new Date(1697061600000L), null, null, Calendar.DAY_OF_YEAR));
			JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spFecha, "yyyy-MM-dd");
			spFecha.setEditor(dateEditor);
		}
		return spFecha;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("");
		}
		return lblNewLabel_4;
	}
	private JLabel getLbFecha() {
		if (lbFecha == null) {
			lbFecha = new JLabel("Fecha:");
			lbFecha.setHorizontalAlignment(SwingConstants.CENTER);
			lbFecha.setForeground(new Color(0, 0, 0));
			lbFecha.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lbFecha;
	}
	private void eliminarActualizacionesLesionado() {
		cs.eliminarActualizaciones();
	}
	

	private class ActualizarLesion extends JFrame {
		private static final long serialVersionUID = 1L;
		private Service23558 cs;
		private JPanel contentPane;
		private JLabel lbActualizaciones;
		private JPanel pnCentral;
		private JPanel pnAñadirActualizacion;
		private JPanel pnVisualizarActualizacion;
		private JPanel pnJugador;
		private JLabel lbJugador;
		private JLabel lbNombreYApellido;
		private JPanel pnBotonesActualizacion;
		private JButton btAceptarActualizacion;
		private JButton btCancelarActualizacion;
		private JPanel pnActualizacion;
		private JLabel lbActualizacion;
		private JLabel lblNewLabel_1;
		private JPanel pnTexto;
		private JTextField txActualizacion;
		private JLabel lblNewLabel;
		private JLabel lblNewLabel_2;
		private JLabel lbRestriccion;
		private JPanel pnJugador_1;
		private JLabel lbJugador_1;
		private JLabel lbNombreYApellido_1;
		private JPanel pnBotonesActualizacion_1;
		private JButton btAceptarActualizacion_1;
		private JPanel pnActualizaciones;
		private JLabel lbTodasActualizaciones;
		private JScrollPane scrList;
		private JList<String> listTodasActualizaciones;
		DefaultListModel<String> listModel = new DefaultListModel<>();

		public ActualizarLesion(Service23558 cs) {
			this.cs = cs;
			setTitle("Actualización de lesiones");
			setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			setBounds(100, 100, 791, 457);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setLocationRelativeTo(null);
			addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					dispose();
				}
			});
			setContentPane(contentPane);
			contentPane.setLayout(new BorderLayout(0, 0));
			contentPane.add(getLbActualizaciones(), BorderLayout.NORTH);
			contentPane.add(getPnCentral(), BorderLayout.CENTER);
		}

		
		private JLabel getLbActualizaciones() {
			if (lbActualizaciones == null) {
				lbActualizaciones = new JLabel("Actualizaciones");
				lbActualizaciones.setForeground(new Color(0, 0, 0));
				lbActualizaciones.setFont(new Font("Tahoma", Font.BOLD, 40));
				lbActualizaciones.setHorizontalAlignment(SwingConstants.CENTER);
			}
			return lbActualizaciones;
		}
		private JPanel getPnCentral() {
			if (pnCentral == null) {
				pnCentral = new JPanel();
				pnCentral.setLayout(new CardLayout(0, 0));
				pnCentral.add(getPnAñadirActualizacion(), "pnAñadirActuazalizacion");
				pnCentral.add(getPnVisualizarActualizacion(), "pnVisualizarActualizacion");
			}
			return pnCentral;
		}
		private JPanel getPnAñadirActualizacion() {
			if (pnAñadirActualizacion == null) {
				pnAñadirActualizacion = new JPanel();
				pnAñadirActualizacion.setLayout(new BorderLayout(0, 0));
				pnAñadirActualizacion.add(getPnJugador(), BorderLayout.NORTH);
				pnAñadirActualizacion.add(getPnBotonesActualizacion(), BorderLayout.SOUTH);
				pnAñadirActualizacion.add(getPnActualizacion(), BorderLayout.CENTER);
			}
			return pnAñadirActualizacion;
		}
		private JPanel getPnVisualizarActualizacion() {
			if (pnVisualizarActualizacion == null) {
				pnVisualizarActualizacion = new JPanel();
				pnVisualizarActualizacion.setLayout(new BorderLayout(0, 0));
				pnVisualizarActualizacion.add(getPnJugador_1(), BorderLayout.NORTH);
				pnVisualizarActualizacion.add(getPnBotonesActualizacion_1(), BorderLayout.SOUTH);
				pnVisualizarActualizacion.add(getPnActualizaciones(), BorderLayout.CENTER);
			}
			return pnVisualizarActualizacion;
		}
		private JPanel getPnJugador() {
			if (pnJugador == null) {
				pnJugador = new JPanel();
				pnJugador.add(getLbJugador());
				pnJugador.add(getLbNombreYApellido());
			}
			return pnJugador;
		}
		private JLabel getLbJugador() {
			if (lbJugador == null) {
				lbJugador = new JLabel("Jugador lesionado:	");
				lbJugador.setForeground(new Color(0, 0, 0));
				lbJugador.setFont(new Font("Tahoma", Font.PLAIN, 18));
			}
			return lbJugador;
		}
		private JLabel getLbNombreYApellido() {
			if (lbNombreYApellido == null) {
				lbNombreYApellido = new JLabel("");
				lbNombreYApellido.setForeground(new Color(0, 0, 0));
				lbNombreYApellido.setFont(new Font("Tahoma", Font.PLAIN, 18));
				lbNombreYApellido.setText("");
			}
			return lbNombreYApellido;
		}
		private JPanel getPnBotonesActualizacion() {
			if (pnBotonesActualizacion == null) {
				pnBotonesActualizacion = new JPanel();
				pnBotonesActualizacion.add(getBtAceptarActualizacion());
				pnBotonesActualizacion.add(getBtCancelarActualizacion());
			}
			return pnBotonesActualizacion;
		}
		private JButton getBtAceptarActualizacion() {
			if (btAceptarActualizacion == null) {
				btAceptarActualizacion = new JButton("Aceptar");
				btAceptarActualizacion.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(getTxActualizacion().getText().isBlank()) {
							JOptionPane.showMessageDialog(null, "El texto de actualización está vacío");
							return;
						}
						añadirActualizacion();
						getTxActualizacion().setText("");
						dispose();
					}
				});
				btAceptarActualizacion.setForeground(new Color(0, 0, 0));
				btAceptarActualizacion.setFont(new Font("Tahoma", Font.PLAIN, 18));
			}
			return btAceptarActualizacion;
		}
		private JButton getBtCancelarActualizacion() {
			if (btCancelarActualizacion == null) {
				btCancelarActualizacion = new JButton("Cancelar");
				btCancelarActualizacion.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						getTxActualizacion().setText("");
						dispose();
					}
				});
				btCancelarActualizacion.setForeground(new Color(0, 0, 0));
				btCancelarActualizacion.setFont(new Font("Tahoma", Font.PLAIN, 18));
			}
			return btCancelarActualizacion;
		}
		private JPanel getPnActualizacion() {
			if (pnActualizacion == null) {
				pnActualizacion = new JPanel();
				pnActualizacion.setLayout(new GridLayout(0, 3, 0, 0));
				pnActualizacion.add(getLbActualizacion());
				pnActualizacion.add(getPnTexto());
			}
			return pnActualizacion;
		}
		private JLabel getLbActualizacion() {
			if (lbActualizacion == null) {
				lbActualizacion = new JLabel("Actualización de lesión:");
				lbActualizacion.setForeground(new Color(0, 0, 0));
				lbActualizacion.setHorizontalAlignment(SwingConstants.CENTER);
				lbActualizacion.setFont(new Font("Tahoma", Font.PLAIN, 18));
			}
			return lbActualizacion;
		}
		private JLabel getLblNewLabel_1() {
			if (lblNewLabel_1 == null) {
				lblNewLabel_1 = new JLabel("");
			}
			return lblNewLabel_1;
		}
		private JPanel getPnTexto() {
			if (pnTexto == null) {
				pnTexto = new JPanel();
				pnTexto.setLayout(new GridLayout(0, 1, 0, 0));
				pnTexto.add(getLblNewLabel_2());
				pnTexto.add(getLblNewLabel());
				pnTexto.add(getTxActualizacion());
				pnTexto.add(getLbRestriccion());
				pnTexto.add(getLblNewLabel_1());
			}
			return pnTexto;
		}
		private JTextField getTxActualizacion() {
			if (txActualizacion == null) {
				txActualizacion = new JTextField();
				txActualizacion.setForeground(new Color(0, 0, 0));
				txActualizacion.setFont(new Font("Tahoma", Font.PLAIN, 18));
				txActualizacion.setColumns(10);
			}
			return txActualizacion;
		}
		private JLabel getLblNewLabel() {
			if (lblNewLabel == null) {
				lblNewLabel = new JLabel("");
			}
			return lblNewLabel;
		}
		private JLabel getLblNewLabel_2() {
			if (lblNewLabel_2 == null) {
				lblNewLabel_2 = new JLabel("");
			}
			return lblNewLabel_2;
		}
		private JLabel getLbRestriccion() {
			if (lbRestriccion == null) {
				lbRestriccion = new JLabel("*Intente ser breve en la actualización");
				lbRestriccion.setForeground(new Color(0, 0, 0));
				lbRestriccion.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lbRestriccion.setVerticalAlignment(SwingConstants.TOP);
			}
			return lbRestriccion;
		}
		private JPanel getPnJugador_1() {
			if (pnJugador_1 == null) {
				pnJugador_1 = new JPanel();
				pnJugador_1.add(getLbJugador_1());
				pnJugador_1.add(getLbNombreYApellido_1());
			}
			return pnJugador_1;
		}
		private JLabel getLbJugador_1() {
			if (lbJugador_1 == null) {
				lbJugador_1 = new JLabel("Jugador lesionado:");
				lbJugador_1.setForeground(Color.BLACK);
				lbJugador_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
			}
			return lbJugador_1;
		}
		private JLabel getLbNombreYApellido_1() {
			if (lbNombreYApellido_1 == null) {
				lbNombreYApellido_1 = new JLabel("<dynamic> <dynamic>");
				lbNombreYApellido_1.setForeground(Color.BLACK);
				lbNombreYApellido_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
			}
			return lbNombreYApellido_1;
		}
		private JPanel getPnBotonesActualizacion_1() {
			if (pnBotonesActualizacion_1 == null) {
				pnBotonesActualizacion_1 = new JPanel();
				pnBotonesActualizacion_1.add(getBtAceptarActualizacion_1());
			}
			return pnBotonesActualizacion_1;
		}
		private JButton getBtAceptarActualizacion_1() {
			if (btAceptarActualizacion_1 == null) {
				btAceptarActualizacion_1 = new JButton("Aceptar");
				btAceptarActualizacion_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btAceptarActualizacion_1.setForeground(Color.BLACK);
				btAceptarActualizacion_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
			}
			return btAceptarActualizacion_1;
		}
		private JPanel getPnActualizaciones() {
			if (pnActualizaciones == null) {
				pnActualizaciones = new JPanel();
				pnActualizaciones.setLayout(new GridLayout(0, 3, 0, 0));
				pnActualizaciones.add(getLbTodasActualizaciones());
				pnActualizaciones.add(getScrList());
			}
			return pnActualizaciones;
		}
		private JLabel getLbTodasActualizaciones() {
			if (lbTodasActualizaciones == null) {
				lbTodasActualizaciones = new JLabel("Actualizaciones jugador:");
				lbTodasActualizaciones.setHorizontalAlignment(SwingConstants.CENTER);
				lbTodasActualizaciones.setForeground(new Color(0, 0, 0));
				lbTodasActualizaciones.setFont(new Font("Tahoma", Font.PLAIN, 18));
			}
			return lbTodasActualizaciones;
		}
		private JScrollPane getScrList() {
			if (scrList == null) {
				scrList = new JScrollPane();
				scrList.setForeground(new Color(0, 0, 0));
				scrList.setViewportView(getListTodasActualizaciones());
			}
			return scrList;
		}
		private JList<String> getListTodasActualizaciones() {
			if (listTodasActualizaciones == null) {
				listTodasActualizaciones = new JList<String>(listModel);
				listTodasActualizaciones.setFont(new Font("Tahoma", Font.PLAIN, 15));
			}
			return listTodasActualizaciones;
		}
		
		private void mostrarPnAñadirActuazalizacion() {
			((CardLayout) getPnCentral().getLayout()).show(getPnCentral(), "pnAñadirLesion");
		}
		private void mostrarPnVisualizarActualizacion() {
			((CardLayout) getPnCentral().getLayout()).show(getPnCentral(), "pnVisualizarActualizacion");
		}
		
		private void escribeActualizaciones(Service23558 cs) {
		    DefaultListModel<String> model = (DefaultListModel<String>) getListTodasActualizaciones().getModel();
		    List<Actualizacion> act = cs.getActualizaciones(cs.getLesionado().getEid());
		    int maxLength = 35;

		    for (Actualizacion a : act) {
		        String texto = a.getTexto();

		        while (texto.length() > maxLength) {
		            int index = texto.substring(0, maxLength).lastIndexOf(' ');
		            if (index == -1) {
		                model.addElement(texto.substring(0, maxLength));
		                texto = texto.substring(maxLength);
		            } 
		            else {
		                model.addElement(texto.substring(0, index));
		                texto = texto.substring(index + 1); 
		            }
		        }

		        if (texto.length() > 0) {
		            model.addElement(texto);
		            model.addElement("_____________________________");
		            model.addElement("");
		        } else {
		            model.addElement(""); 
		        }
		    }
		}
		private void añadirActualizacion() {
			cs.añadirActualizacion(getTxActualizacion().getText());
		}
	}
}
