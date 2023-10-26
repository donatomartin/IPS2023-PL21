package ips2023pl21.ui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Component;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import ips2023pl21.model.*;
import ips2023pl21.model.activos.Merchandaising;
import ips2023pl21.model.activos.TiendaLogica;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.JScrollPane;

public class Frame21916 {
	
	TiendaLogica tl;
	
	private ProcesaBotonProducto pBP;
	private ProcesaBotonSeleccion pBS;
	
	private JFrame frame;
	private JPanel pnHeaderTienda;
	private JLabel lbTienda;
	private JPanel pnButtonsTienda;
	private JButton btConfirmarTienda;
	private JButton btSalirTienda;
	private JLabel lbPrecioTienda;
	
	private JPanel pnContenido;
	private JPanel pnSeleccion;
	private JButton btEliminarTodo;
	private JScrollPane spProductos;
	private JPanel pnProductos;
	private JScrollPane spSeleccion;
	
	/**
	 * Create the application.
	 */
	public Frame21916() {
		tl = new TiendaLogica();
		pBP = new ProcesaBotonProducto();
		pBS = new ProcesaBotonSeleccion();
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setSize(new Dimension(1000, 500));
		frame.setBounds(200, 200, 950, 600);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.getContentPane().add(getPnHeaderTienda(), BorderLayout.NORTH);
		frame.getContentPane().add(getPnButtonsTienda(), BorderLayout.SOUTH);
		frame.getContentPane().add(getPnContenido(), BorderLayout.CENTER);
		frame.setSize(new Dimension(1100,500));
		frame.setMinimumSize(new Dimension(1100, 500));
		
		frame.setVisible(true);
		
		
	}
	private JPanel getPnHeaderTienda() {
		if (pnHeaderTienda == null) {
			pnHeaderTienda = new JPanel();
			pnHeaderTienda.setLayout(new GridLayout(0, 2, 0, 0));
			pnHeaderTienda.add(getLbTienda());
			pnHeaderTienda.add(getLbPrecioTienda());
		}
		return pnHeaderTienda;
	}
	private JLabel getLbTienda() {
		if (lbTienda == null) {
			lbTienda = new JLabel("Tienda");
			lbTienda.setHorizontalAlignment(SwingConstants.LEFT);
		}
		return lbTienda;
	}
	private JPanel getPnButtonsTienda() {
		if (pnButtonsTienda == null) {
			pnButtonsTienda = new JPanel();
			pnButtonsTienda.setLayout(new GridLayout(0, 3, 0, 0));
			pnButtonsTienda.add(getBtSalirTienda());
			pnButtonsTienda.add(getBtConfirmarTienda());
			pnButtonsTienda.add(getBtEliminarTodo());
		}
		return pnButtonsTienda;
	}
	private JButton getBtConfirmarTienda() {
		if (btConfirmarTienda == null) {
			btConfirmarTienda = new JButton("Confirmar");
			btConfirmarTienda.setEnabled(false);
			btConfirmarTienda.setBackground(new Color(255, 255, 255));
			btConfirmarTienda.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					finalizarCompra();
				}
			});
		}
		return btConfirmarTienda;
	}
	private void finalizarCompra() {
		String[] botones = {"Si" , "No"};
		int res = JOptionPane.showOptionDialog(null, "Precio: " + tl.getPrecioTotal() + "\n" + 
		"¿Desea confirmar la compra?","Confirmacion", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
		botones,botones[0]);
		
		if(res == 0) {
			tl.guardarPrecio();
			System.exit(0);
		}
		
	}
	
	private JButton getBtSalirTienda() {
		if (btSalirTienda == null) {
			btSalirTienda = new JButton("Salir");
			btSalirTienda.setBackground(new Color(255, 255, 255));
			btSalirTienda.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return btSalirTienda;
	}
	private JLabel getLbPrecioTienda() {
		if (lbPrecioTienda == null) {
			lbPrecioTienda = new JLabel("Precio: 0 €");
			lbPrecioTienda.setHorizontalAlignment(SwingConstants.RIGHT);
			lbPrecioTienda.setHorizontalTextPosition(SwingConstants.RIGHT);
			lbPrecioTienda.setAlignmentX(Component.RIGHT_ALIGNMENT);
			lbPrecioTienda.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		return lbPrecioTienda;
	}
	
	private JPanel getPnSeleccion() {
		if (pnSeleccion == null) {
			pnSeleccion = new JPanel();
			pnSeleccion.setLayout(new GridLayout(0, 6, 3, 3));
		}
		return pnSeleccion;
	}
	
	private void crearBotonesProductos(boolean enabled) {
		if(enabled) {
			for(int i = 0; i < tl.getMerchandaising().size(); i++) {
				getPnProductos().add(nuevoBotonProductos(i,enabled));
			}
		} else {
			for(int i = 0; i < tl.getMerchandaising().size(); i++) {
				getPnSeleccion().add(nuevoBotonProductos(i,enabled));
			}
		}
		
	}
	
	private Component nuevoBotonProductos(Integer posicion, boolean enabled) {
		JButton boton = new JButton("");
		boton.setMinimumSize(new Dimension(1000000,1000000));
		String textoBt;
		Merchandaising m = tl.getMerchandaising().get(posicion);
		if(enabled) {
			boton.addActionListener(pBP);
			textoBt = "<html>" + m.getNombre() + "<br>" +
					  m.getTipo() + "<br> Precio: " +
					  m.getPrecio() + "<html>";
			
		} else {
			boton.addActionListener(pBS);
			textoBt = "<html>" + m.getNombre() + "<br>" +
					  m.getTipo() + "<br> uds: " +
					  m.getUnidades() + "<html>";
		}
		boton.setBackground(Color.white);
		boton.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
		boton.setActionCommand(posicion.toString());
		
		boton.setVerticalAlignment(SwingConstants.CENTER);
		
		boton.setText(textoBt);
		boton.setToolTipText("Articulo: " + m.getNombre() + 
				", Precio: " + m.getPrecio());
		boton.setEnabled(enabled);
		return boton;
	}
	
	public class ProcesaBotonProducto implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton) e.getSource();		
			int actionCommand = Integer.parseInt(source.getActionCommand());
			
			//Añade el articulo
			Merchandaising m = tl.getArticulo(actionCommand);
			int unidades;
			
			try {
				String text = JOptionPane.showInputDialog("¿Cuantas unidades quiere de "
						+ tl.getArticulo(Integer.parseInt(source.getActionCommand())).getNombre() + "?");
				unidades = Integer.parseInt(text);
				
				if(unidades < 0) {
					throw new NumberFormatException();
				}
				
				tl.actualizarArticulosEnCesta(m, unidades);
				actualizarPrecio();
				getBtEliminarTodo().setEnabled(true);
				getBtConfirmarTienda().setEnabled(true);
				getPnSeleccion().getComponent(actionCommand).setEnabled(true);
				((JButton)getPnSeleccion().getComponent(actionCommand)).setText("<html>" + m.getNombre() + "<br>" +
																				m.getTipo() + "<br> uds: " +
																				m.getUnidades() + "<html>");

			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "numero no valido");
			}
				
		}
	}

	
	public class ProcesaBotonSeleccion implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton) e.getSource();		
			int actionCommand = Integer.parseInt(source.getActionCommand());
			
			//Busca el articulo
			Merchandaising m = tl.getArticulo(actionCommand);
			int unidades;
			
			try {
				String text = JOptionPane.showInputDialog("¿Cuantas unidades quiere eliminar de "
						+ tl.getArticulo(Integer.parseInt(source.getActionCommand())).getNombre() + "?");
				unidades = Integer.parseInt(text);
				
				if(unidades < 0) {
					throw new NumberFormatException();
				}
				
				tl.actualizarArticulosEnCesta(m, -unidades);
				actualizarPrecio();
				getBtEliminarTodo().setEnabled(true);
				getBtConfirmarTienda().setEnabled(true);
				
				
				if(m.getUnidades() <= 0) {
					source.setEnabled(false);
				}
				
				if(tl.getPrecioTotal() <= 0) {
					getBtConfirmarTienda().setEnabled(false);
					getBtEliminarTodo().setEnabled(false);
				}

			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "numero no valido");
			}
			
		}
		
	}
	private void actualizarPrecio() {
		double precioTotal = tl.getPrecioTotal();
		getLbPrecioTienda().setText("Precio: " + Double.toString(precioTotal) +" €");
	}
	
	private void eliminarTodosLosArticulos() {
		tl.eliminarSeleccion();
		actualizarPrecio();
		getBtConfirmarTienda().setEnabled(false);
		getBtEliminarTodo().setEnabled(false);
	}

	private JPanel getPnContenido() {
		if (pnContenido == null) {
			pnContenido = new JPanel();
			pnContenido.setLayout(new BorderLayout(0, 0));
			pnContenido.add(getSpProductos(), BorderLayout.WEST);
			pnContenido.add(getSpSeleccion(), BorderLayout.EAST);
		}
		return pnContenido;
	}
	private JButton getBtEliminarTodo() {
		if (btEliminarTodo == null) {
			btEliminarTodo = new JButton("Eliminar (Todo)");
			btEliminarTodo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					eliminarTodosLosArticulos();
				}
			});
			btEliminarTodo.setBackground(new Color(255, 255, 255));
			btEliminarTodo.setMnemonic('t');
			btEliminarTodo.setEnabled(false);
		}
		return btEliminarTodo;
	}
	private JScrollPane getSpProductos() {
		if (spProductos == null) {
			spProductos = new JScrollPane();
			spProductos.setViewportView(getPnProductos());
			crearBotonesProductos(true);
		}
		return spProductos;
	}
	private JPanel getPnProductos() {
		if (pnProductos == null) {
			pnProductos = new JPanel();
			pnProductos.setLayout(new GridLayout(0, 6, 3, 3));
		}
		return pnProductos;
	}
	private JScrollPane getSpSeleccion() {
		if (spSeleccion == null) {
			spSeleccion = new JScrollPane();
			spSeleccion.setViewportView(getPnSeleccion());
			crearBotonesProductos(false);
		}
		return spSeleccion;
	}
}
