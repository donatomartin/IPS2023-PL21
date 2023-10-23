package ips2023pl21.ui;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ips2023pl21.model.empleados.EmpleadoDeportivo;
import ips2023pl21.model.equipos.CategoriaEquipo;
import ips2023pl21.model.equipos.EquipoDeportivo;
import ips2023pl21.model.equipos.EquipoEnFormacion;
import ips2023pl21.model.equipos.EquipoProfesional;

public class Frame21914 {

	EquipoDeportivo equipo;
	
	DefaultTableModel modeloTablaEntrenadores;
	DefaultTableModel modeloTablaJugadores;
	
	private JFrame frame;
	private JPanel pnSeleccionTipoEquipo;
	private JLabel lbSeleccionTipoEquipo;
	private JPanel pnBotonesSeleccion;
	private JButton btEquipoFormacion;
	private JButton btEquipoProfesional;
	private JPanel pnAñadirEquipo;
	private JButton btAñadirEquipo;
	private JButton btVolver;
	private JCheckBox chbxFilial;
	private JButton btAñadirEntrenador;
	private JLabel lbTipoEquipo;
	private JLabel lbDatosEntrenador;
	private JLabel lbDatosSegundo;
	private JPanel pnSeleccionCategoria;
	private JComboBox<Object> cbCategoria;
	private JLabel lbCategoria;
	private JButton btContinuarCategoria;
	private JButton btAñadirSegundo;
	private JButton btAñadirJugador;
	private JScrollPane spJugadores;
	private JList<EmpleadoDeportivo> listJugadores;
	private DefaultListModel<EmpleadoDeportivo> modeloListJugador;
	private JButton btEliminarTodos;
	private JButton btEliminarEntrenador;
	private JButton btEliminarSegundo;
	private JButton btEliminarJugador;
	private JPanel pnCategoria;
	private JPanel pnBotonesCategoria;
	private JPanel pnBotonesAñadir;
	private JTable tbEntrenadores;
	private JScrollPane spEntrenadores;
	private JScrollPane spJugadoresTabla;
	private JTable tbJugadores;
	private JPanel pnTipoEquipo;
	private JPanel pnAñadir;
	private JPanel pnJugadores;
	private JPanel pnEntrenadores;
	private JPanel pnBotonesEntrenadores;
	private JPanel pnDatosEntrenadores;
	private JPanel pnAñadirJugador;
	private JPanel pnJugadoresSeleccionados;
	private JPanel pnBotonesEliminar;

	/**
	 * Create the application
	 */
	public Frame21914() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 960, 605);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		frame.getContentPane().add(getPnSeleccionTipoEquipo(), "seleccion");
		frame.getContentPane().add(getPnAñadirEquipo(), "añadir");
		frame.getContentPane().add(getPnSeleccionCategoria(), "categoria");
		
		frame.setVisible(true);
	}

	private JPanel getPnSeleccionTipoEquipo() {
		if (pnSeleccionTipoEquipo == null) {
			pnSeleccionTipoEquipo = new JPanel();
			pnSeleccionTipoEquipo.setLayout(new BorderLayout(0, 0));
			pnSeleccionTipoEquipo.add(getLbSeleccionTipoEquipo(), BorderLayout.NORTH);
			pnSeleccionTipoEquipo.add(getPnBotonesSeleccion(), BorderLayout.CENTER);
		}
		return pnSeleccionTipoEquipo;
	}
	private JLabel getLbSeleccionTipoEquipo() {
		if (lbSeleccionTipoEquipo == null) {
			lbSeleccionTipoEquipo = new JLabel("¿Que equipo quieres añadir?");
			lbSeleccionTipoEquipo.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lbSeleccionTipoEquipo.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lbSeleccionTipoEquipo;
	}
	private JPanel getPnBotonesSeleccion() {
		if (pnBotonesSeleccion == null) {
			pnBotonesSeleccion = new JPanel();
			pnBotonesSeleccion.setLayout(new GridLayout(0, 2, 0, 0));
			pnBotonesSeleccion.add(getBtEquipoProfesional());
			pnBotonesSeleccion.add(getBtEquipoFormacion());
		}
		return pnBotonesSeleccion;
	}
	private JButton getBtEquipoFormacion() {
		if (btEquipoFormacion == null) {
			btEquipoFormacion = new JButton("Equipo en Formacion");
			btEquipoFormacion.setMnemonic('f');
			btEquipoFormacion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pasarASeleccionCategoria();
				}
			});
		}
		return btEquipoFormacion;
	}
	private JButton getBtEquipoProfesional() {
		if (btEquipoProfesional == null) {
			btEquipoProfesional = new JButton("Equipo Profesional");
			btEquipoProfesional.setMnemonic('p');
			btEquipoProfesional.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pasarAAñadirProfesional();
				}
			});
		}
		return btEquipoProfesional;
	}
	
	private void pasarAAñadirProfesional() {
		equipo = new EquipoProfesional();
		irAPn("añadir");
		getLbTipoEquipo().setText("Equipo Profesional");
		getChbxFilial().setEnabled(true);
		añadirDatosATablas();
	}
	

	private void pasarASeleccionCategoria() {
		equipo = new EquipoEnFormacion();
		irAPn("categoria");
	}
	
	private void pasarAAñadirEnFormacion() {
		((EquipoEnFormacion)equipo).setCategoria((CategoriaEquipo)getCbCategoria().getSelectedItem());
		irAPn("añadir");
		getLbTipoEquipo().setText("Equipo en Formacion");
		getChbxFilial().setEnabled(false);
		añadirDatosATablas();
	}
	
	private void irAPn(String pnName) {
		((CardLayout)frame.getContentPane().getLayout()).show(frame.getContentPane(),pnName);
	}
	
	private void añadirDatosATablas() {
		Object[] añadir = new Object[4];
		//Entrenadores
		for(EmpleadoDeportivo e : equipo.getEntrenadoresTabla()) {
			añadir[0] =  e.getAtributoTabla(0);
			añadir[1] =  e.getAtributoTabla(1);
			añadir[2] =  e.getAtributoTabla(2);
			añadir[3] =  e.getAtributoTabla(3);
			
			modeloTablaEntrenadores.addRow(añadir);
		}
		//Jugadores
		for(EmpleadoDeportivo e : equipo.getJugadoresTabla()) {
			añadir[0] =  e.getAtributoTabla(0);
			añadir[1] =  e.getAtributoTabla(1);
			añadir[2] =  e.getAtributoTabla(2);
			añadir[3] =  e.getAtributoTabla(3);
//			
			modeloTablaJugadores.addRow(añadir);
		}
		
		
	}
	
	private JPanel getPnAñadirEquipo() {
		if (pnAñadirEquipo == null) {
			pnAñadirEquipo = new JPanel();
			pnAñadirEquipo.setLayout(new BorderLayout(0, 0));
			pnAñadirEquipo.add(getPnBotonesAñadir(), BorderLayout.SOUTH);
			pnAñadirEquipo.add(getPnTipoEquipo(), BorderLayout.NORTH);
			pnAñadirEquipo.add(getPnAñadir());
		}
		return pnAñadirEquipo;
	}
	private JButton getBtAñadirEquipo() {
		if (btAñadirEquipo == null) {
			btAñadirEquipo = new JButton("Añadir Equipo");
			btAñadirEquipo.setMnemonic('a');
			btAñadirEquipo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					añadirEquipo();
				}
			});
			btAñadirEquipo.setEnabled(false);
		}
		return btAñadirEquipo;
	}
	private void añadirEquipo() {
		equipo.añadirEquipo();
		JOptionPane.showMessageDialog(null, "Equipo añadido se volver al inicio");
		reiniciarElementos();
		
	}
	private void reiniciarElementos() {
		irAPn("seleccion");
		int rowsEn = getTbEntrenadores().getRowCount() - 1;
		int rowJu = getTbJugadores().getRowCount() - 1; 
		for(int i = rowsEn; i >= 0; i--) {
			modeloTablaEntrenadores.removeRow(i);
		}
		for(int j = rowJu; j >= 0; j--) {
			modeloTablaJugadores.removeRow(j);
		}
		equipo = null;
		
		modeloListJugador.removeAllElements();
		getLbDatosEntrenador().setText("No se ha añadido Entrenador todavia");
		getLbDatosSegundo().setText("No se ha añadido Segundo Entrenador todavia");
		
		getBtAñadirEntrenador().setEnabled(true);
		getBtEliminarEntrenador().setEnabled(false);
		getBtAñadirSegundo().setEnabled(true);
		getBtEliminarSegundo().setEnabled(false);
		getBtEliminarTodos().setEnabled(false);
		getBtEliminarJugador().setEnabled(false);
		getBtAñadirEquipo().setEnabled(false);
		
		getChbxFilial().setSelected(false);
		
	}

	private void comprobarAñadirEquipo() {
		if(equipo.getPrimerEntrenador() != null && equipo.getSegundoEntrenador() != null &&
		   equipo.getJugadoresEquipo().size() >= EquipoDeportivo.MIN_JUGADORES) {
			getBtAñadirEquipo().setEnabled(true);
		}
	}
	
	private JButton getBtVolver() {
		if (btVolver == null) {
			btVolver = new JButton("Volver");
			btVolver.setMnemonic('v');
			btVolver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					volverAtras();
				}
			});
		}
		return btVolver;
	}
	
	private void volverAtras() {
		String[] botones = {"Si" , "No"};
		int res = JOptionPane.showOptionDialog(null, "¿Quieres volver atras?, Se perdera el progreso",
				"Volver", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
		botones,botones[0]);
		
		if(res == 0) {
			irAPn("seleccion");
			
			reiniciarElementos();
		}
	}
	private JCheckBox getChbxFilial() {
		if (chbxFilial == null) {
			chbxFilial = new JCheckBox("Filial");
			chbxFilial.setMnemonic('f');
			chbxFilial.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((EquipoProfesional)equipo).setFilial(chbxFilial.isSelected());
				}
			});
		}
		return chbxFilial;
	}
	private JButton getBtAñadirEntrenador() {
		if (btAñadirEntrenador == null) {
			btAñadirEntrenador = new JButton("Añadir Entrenador");
			btAñadirEntrenador.setMnemonic('e');
			btAñadirEntrenador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					añadirEntrenador();
				}
			});
		}
		return btAñadirEntrenador;
	}
	
	private void añadirEntrenador() {
		int selected = getTbEntrenadores().getSelectedRow();
		if(selected != -1) {
			EmpleadoDeportivo primerEntrenador = equipo.getEntrenador(selected);
			if(equipo.getSegundoEntrenador()== null || 
			   primerEntrenador.getDni() != equipo.getSegundoEntrenador().getDni()) {
				equipo.setPrimerEntrenador(primerEntrenador);
				getBtAñadirEntrenador().setEnabled(false);
				getLbDatosEntrenador().setText("Datos Entrenador: " + equipo.getPrimerEntrenador().toString());
				getBtEliminarEntrenador().setEnabled(true);
				
				comprobarAñadirEquipo();
			} else {
				JOptionPane.showMessageDialog(null, "Este entrenador ya se ha añadido");
			}
			
		} else {
			JOptionPane.showMessageDialog(null, "Selecciona un entrenador");
		}
		
	}

	private JLabel getLbTipoEquipo() {
		if (lbTipoEquipo == null) {
			lbTipoEquipo = new JLabel("Tipo");
			lbTipoEquipo.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lbTipoEquipo;
	}
	private JLabel getLbDatosEntrenador() {
		if (lbDatosEntrenador == null) {
			lbDatosEntrenador = new JLabel("No se ha añadido un Entrenador todavia");
		}
		return lbDatosEntrenador;
	}
	private JLabel getLbDatosSegundo() {
		if (lbDatosSegundo == null) {
			lbDatosSegundo = new JLabel("No se ha añadido un Segundo Entrenador todavia");
		}
		return lbDatosSegundo;
	}
	private JPanel getPnSeleccionCategoria() {
		if (pnSeleccionCategoria == null) {
			pnSeleccionCategoria = new JPanel();
			pnSeleccionCategoria.setLayout(new BorderLayout(0, 0));
			pnSeleccionCategoria.add(getPnCategoria());
			pnSeleccionCategoria.add(getPnBotonesCategoria(), BorderLayout.SOUTH);
		}
		return pnSeleccionCategoria;
	}
	private JComboBox<Object> getCbCategoria() {
		if (cbCategoria == null) {
			cbCategoria = new JComboBox<Object>();
			cbCategoria.setModel(new DefaultComboBoxModel<Object>(CategoriaEquipo.values()));
		}
		return cbCategoria;
	}
	private JLabel getLbCategoria() {
		if (lbCategoria == null) {
			lbCategoria = new JLabel("Categoria: ");
			lbCategoria.setLabelFor(getCbCategoria());
			lbCategoria.setDisplayedMnemonic('t');
			lbCategoria.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lbCategoria;
	}
	private JButton getBtContinuarCategoria() {
		if (btContinuarCategoria == null) {
			btContinuarCategoria = new JButton("Continuar");
			btContinuarCategoria.setVerticalAlignment(SwingConstants.BOTTOM);
			btContinuarCategoria.setMnemonic('c');
			btContinuarCategoria.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					pasarAAñadirEnFormacion();
				}
			});
		}
		return btContinuarCategoria;
	}
	private JButton getBtAñadirSegundo() {
		if (btAñadirSegundo == null) {
			btAñadirSegundo = new JButton("Añadir Segundo En.");
			btAñadirSegundo.setMnemonic('s');
			btAñadirSegundo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					añadirSegundo();
				}
			});
		}
		return btAñadirSegundo;
	}

	private void añadirSegundo() {
		int selected = getTbEntrenadores().getSelectedRow();
		if(selected != -1) {
			EmpleadoDeportivo segundoEntrenador = equipo.getEntrenador(selected);
			if(equipo.getPrimerEntrenador()== null || 
			   segundoEntrenador.getDni() != equipo.getPrimerEntrenador().getDni()) {
				equipo.setSegundoEntrenador(segundoEntrenador);
				getBtAñadirSegundo().setEnabled(false);
				getLbDatosSegundo().setText("Datos Entrenador: " + equipo.getSegundoEntrenador().toString());
				getBtEliminarSegundo().setEnabled(true);
				
				comprobarAñadirEquipo();
			} else {
				JOptionPane.showMessageDialog(null, "Este entrenador ya se ha añadido");
			}
			
		} else {
			JOptionPane.showMessageDialog(null, "Selecciona un entrenador");
		}	


	}

	private JButton getBtAñadirJugador() {
		if (btAñadirJugador == null) {
			btAñadirJugador = new JButton("Añadir Jugador");
			btAñadirJugador.setMnemonic('j');
			btAñadirJugador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					añadirJugador();
				}
			});
		}
		return btAñadirJugador;
	}
	
	private void añadirJugador() {
		int selected = getTbJugadores().getSelectedRow();
		if(selected != -1) {
			EmpleadoDeportivo jugador = equipo.getJugador(selected);
			if(!equipo.getJugadoresEquipo().contains(jugador)){
				if(equipo.añadirJugador(jugador)) {
					modeloListJugador.removeAllElements();
					modeloListJugador.addAll(equipo.getJugadoresEquipo());
					getBtEliminarTodos().setEnabled(true);
					getBtEliminarJugador().setEnabled(true);
					
					comprobarAñadirEquipo();
				} else {
					JOptionPane.showMessageDialog(null, "Este jugador no es valido");
				}
				
			} else {
				JOptionPane.showMessageDialog(null, "Este jugador ya se ha añadido");
			}
			
		} else {
			JOptionPane.showMessageDialog(null, "Selecciona un jugador");
		}
	}

	private JScrollPane getSpJugadores() {
		if (spJugadores == null) {
			spJugadores = new JScrollPane();
			spJugadores.setViewportView(getListJugadores());
		}
		return spJugadores;
	}
	private JList<EmpleadoDeportivo> getListJugadores() {
		if (listJugadores == null) {
			modeloListJugador = new DefaultListModel<EmpleadoDeportivo>();
			listJugadores = new JList<EmpleadoDeportivo>(modeloListJugador);
			listJugadores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return listJugadores;
	}
	private JButton getBtEliminarTodos() {
		if (btEliminarTodos == null) {
			btEliminarTodos = new JButton("Eliminar Todos");
			btEliminarTodos.setMnemonic('t');
			btEliminarTodos.setEnabled(false);
			btEliminarTodos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					eliminarTodosLosJugadores();
				}
			});
		}
		return btEliminarTodos;
	}
	
	private void eliminarTodosLosJugadores() {
		equipo.eliminarTodosLosJugadores();
		modeloListJugador.removeAllElements();
		getBtEliminarTodos().setEnabled(false);
		getBtEliminarJugador().setEnabled(false);
		
	}
	private JButton getBtEliminarEntrenador() {
		if (btEliminarEntrenador == null) {
			btEliminarEntrenador = new JButton("Eliminar Entrenador");
			btEliminarEntrenador.setMnemonic('n');
			btEliminarEntrenador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					eliminarEntrenador();
				}
			});
			btEliminarEntrenador.setEnabled(false);
		}
		return btEliminarEntrenador;
	}
	private void eliminarEntrenador() {
		equipo.setPrimerEntrenador(null);
		getLbDatosEntrenador().setText("No se ha añadido un Entrenador todavia");
		getBtAñadirEntrenador().setEnabled(true);
		getBtEliminarEntrenador().setEnabled(false);
	}
	
	private JButton getBtEliminarSegundo() {
		if (btEliminarSegundo == null) {
			btEliminarSegundo = new JButton("Eliminar Segundo En.");
			btEliminarSegundo.setMnemonic('e');
			btEliminarSegundo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					eliminarSegundo();
				}
			});
			btEliminarSegundo.setEnabled(false);
		}
		return btEliminarSegundo;
	}	
	private void eliminarSegundo() {
		equipo.setSegundoEntrenador(null);
		getLbDatosSegundo().setText("No se ha añadido un Segundo Entrenador todavia");
		getBtAñadirSegundo().setEnabled(true);
		getBtEliminarSegundo().setEnabled(false);
		
	}
	
	private JButton getBtEliminarJugador() {
		if (btEliminarJugador == null) {
			btEliminarJugador = new JButton("Eliminar (Selección)");
			btEliminarJugador.setMnemonic('l');
			btEliminarJugador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					eliminarJugador();
				}
			});
			btEliminarJugador.setEnabled(false);
		}
		return btEliminarJugador;
	}
	
	private void eliminarJugador() {
		if(!getListJugadores().isSelectionEmpty()) {
			int index  = getListJugadores().getSelectedIndex();
			
			equipo.eliminarJugador(index);
			
			modeloListJugador.removeAllElements();
			modeloListJugador.addAll(equipo.getJugadoresEquipo());
		}
		
	}
	private JPanel getPnCategoria() {
		if (pnCategoria == null) {
			pnCategoria = new JPanel();
			pnCategoria.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			pnCategoria.add(getLbCategoria());
			pnCategoria.add(getCbCategoria());
		}
		return pnCategoria;
	}
	private JPanel getPnBotonesCategoria() {
		if (pnBotonesCategoria == null) {
			pnBotonesCategoria = new JPanel();
			pnBotonesCategoria.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			pnBotonesCategoria.add(getBtContinuarCategoria());
		}
		return pnBotonesCategoria;
	}
	private JPanel getPnBotonesAñadir() {
		if (pnBotonesAñadir == null) {
			pnBotonesAñadir = new JPanel();
			pnBotonesAñadir.add(getBtVolver());
			pnBotonesAñadir.add(getChbxFilial());
			pnBotonesAñadir.add(getBtAñadirEquipo());
		}
		return pnBotonesAñadir;
	}
	private JTable getTbEntrenadores() {
		if (tbEntrenadores == null) {
			modeloTablaEntrenadores = new DefaultTableModel();
			modeloTablaEntrenadores.addColumn("Nombre");
			modeloTablaEntrenadores.addColumn("Apellido");
			modeloTablaEntrenadores.addColumn("DNI");
			modeloTablaEntrenadores.addColumn("Nacimiento");
			tbEntrenadores = new JTable(modeloTablaEntrenadores);
			tbEntrenadores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return tbEntrenadores;
	}
	private JScrollPane getSpEntrenadores() {
		if (spEntrenadores == null) {
			spEntrenadores = new JScrollPane();
			spEntrenadores.setViewportView(getTbEntrenadores());
		}
		return spEntrenadores;
	}
	private JScrollPane getSpJugadoresTabla() {
		if (spJugadoresTabla == null) {
			spJugadoresTabla = new JScrollPane();
			spJugadoresTabla.setViewportView(getTbJugadores());
		}
		return spJugadoresTabla;
	}
	private JTable getTbJugadores() {
		if (tbJugadores == null) {
			modeloTablaJugadores = new DefaultTableModel();
			modeloTablaJugadores.addColumn("Nombre");
			modeloTablaJugadores.addColumn("Apellido");
			modeloTablaJugadores.addColumn("DNI");
			modeloTablaJugadores.addColumn("Nacimiento");
			tbJugadores = new JTable(modeloTablaJugadores);
			tbJugadores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return tbJugadores;
	}
	private JPanel getPnTipoEquipo() {
		if (pnTipoEquipo == null) {
			pnTipoEquipo = new JPanel();
			pnTipoEquipo.add(getLbTipoEquipo());
		}
		return pnTipoEquipo;
	}
	private JPanel getPnAñadir() {
		if (pnAñadir == null) {
			pnAñadir = new JPanel();
			pnAñadir.setLayout(new GridLayout(0, 1, 0, 25));
			pnAñadir.add(getPnEntrenadores());
			pnAñadir.add(getPnJugadores());
		}
		return pnAñadir;
	}
	private JPanel getPnJugadores() {
		if (pnJugadores == null) {
			pnJugadores = new JPanel();
			pnJugadores.setLayout(new GridLayout(0, 3, 10, 10));
			pnJugadores.add(getSpJugadoresTabla());
			pnJugadores.add(getPnAñadirJugador());
			pnJugadores.add(getPnJugadoresSeleccionados());
		}
		return pnJugadores;
	}
	private JPanel getPnEntrenadores() {
		if (pnEntrenadores == null) {
			pnEntrenadores = new JPanel();
			pnEntrenadores.setLayout(new GridLayout(0, 3, 10, 0));
			pnEntrenadores.add(getSpEntrenadores());
			pnEntrenadores.add(getPnBotonesEntrenadores());
			pnEntrenadores.add(getPnDatosEntrenadores());
		}
		return pnEntrenadores;
	}
	private JPanel getPnBotonesEntrenadores() {
		if (pnBotonesEntrenadores == null) {
			pnBotonesEntrenadores = new JPanel();
			pnBotonesEntrenadores.setLayout(new GridLayout(0, 2, 2, 50));
			pnBotonesEntrenadores.add(getBtAñadirEntrenador());
			pnBotonesEntrenadores.add(getBtEliminarEntrenador());
			pnBotonesEntrenadores.add(getBtAñadirSegundo());
			pnBotonesEntrenadores.add(getBtEliminarSegundo());
		}
		return pnBotonesEntrenadores;
	}
	private JPanel getPnDatosEntrenadores() {
		if (pnDatosEntrenadores == null) {
			pnDatosEntrenadores = new JPanel();
			pnDatosEntrenadores.setLayout(new GridLayout(0, 1, 0, 50));
			pnDatosEntrenadores.add(getLbDatosEntrenador());
			pnDatosEntrenadores.add(getLbDatosSegundo());
		}
		return pnDatosEntrenadores;
	}
	private JPanel getPnAñadirJugador() {
		if (pnAñadirJugador == null) {
			pnAñadirJugador = new JPanel();
			pnAñadirJugador.setLayout(new GridLayout(0, 1, 0, 0));
			pnAñadirJugador.add(getBtAñadirJugador());
		}
		return pnAñadirJugador;
	}
	private JPanel getPnJugadoresSeleccionados() {
		if (pnJugadoresSeleccionados == null) {
			pnJugadoresSeleccionados = new JPanel();
			pnJugadoresSeleccionados.setLayout(new BorderLayout(0, 0));
			pnJugadoresSeleccionados.add(getSpJugadores(), BorderLayout.CENTER);
			pnJugadoresSeleccionados.add(getPnBotonesEliminar(), BorderLayout.SOUTH);
		}
		return pnJugadoresSeleccionados;
	}
	private JPanel getPnBotonesEliminar() {
		if (pnBotonesEliminar == null) {
			pnBotonesEliminar = new JPanel();
			pnBotonesEliminar.add(getBtEliminarTodos());
			pnBotonesEliminar.add(getBtEliminarJugador());
		}
		return pnBotonesEliminar;
	}
}
