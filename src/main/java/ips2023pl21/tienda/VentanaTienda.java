package ips2023pl21.tienda;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Font;
import java.awt.Dimension;

public class VentanaTienda {
	
	TiendaLogica tl;
	
	private ProcesaBotonProducto pBP;
	
	private JFrame frame;
	private JScrollPane SpnProductosSeleccionados;
	private JPanel pnHeaderTienda;
	private JLabel lbTienda;
	private JPanel pnButtonsTienda;
	private JButton btConfirmarTienda;
	private JButton btSalirTienda;
	private JLabel lbPrecioTienda;
	private JPanel pnProductos;
	private JList<Merchandaising> listArticulosSeleccionados;
	
	private DefaultListModel<Merchandaising> modeloListArticulosSeleccionados;
	private JSpinner spUnidades;
	private JButton btEliminarTodo;
	private JButton btEliminarUnidades;
	private JPanel pnContenido;
	private JLabel lbUnidades;
	private JPanel pnUnidades;
	private JPanel pnPrecio;
	private JPanel pnSeleccion;
	private JPanel pnBotonesEliminar;
	
	/**
	 * Create the application.
	 */
	public VentanaTienda() {
		tl = new TiendaLogica();
		pBP = new ProcesaBotonProducto();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 950, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.getContentPane().add(getPnHeaderTienda(), BorderLayout.NORTH);
		frame.getContentPane().add(getPnButtonsTienda(), BorderLayout.SOUTH);
		frame.getContentPane().add(getPnContenido(), BorderLayout.CENTER);
		
		frame.setVisible(true);
	}

	private JScrollPane getSpnProductosSeleccionados() {
		if (SpnProductosSeleccionados == null) {
			SpnProductosSeleccionados = new JScrollPane();
			SpnProductosSeleccionados.setAlignmentX(Component.LEFT_ALIGNMENT);
			SpnProductosSeleccionados.setViewportView(getListArticulosSeleccionados());
		}
		return SpnProductosSeleccionados;
	}
	private JPanel getPnHeaderTienda() {
		if (pnHeaderTienda == null) {
			pnHeaderTienda = new JPanel();
			pnHeaderTienda.add(getLbTienda());
		}
		return pnHeaderTienda;
	}
	private JLabel getLbTienda() {
		if (lbTienda == null) {
			lbTienda = new JLabel("Tienda");
		}
		return lbTienda;
	}
	private JPanel getPnButtonsTienda() {
		if (pnButtonsTienda == null) {
			pnButtonsTienda = new JPanel();
			pnButtonsTienda.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			pnButtonsTienda.add(getBtConfirmarTienda());
			pnButtonsTienda.add(getBtSalirTienda());
		}
		return pnButtonsTienda;
	}
	private JButton getBtConfirmarTienda() {
		if (btConfirmarTienda == null) {
			btConfirmarTienda = new JButton("Confirmar");
			btConfirmarTienda.setEnabled(false);
			btConfirmarTienda.setBackground(new Color(255, 255, 255));
			btConfirmarTienda.setHorizontalAlignment(SwingConstants.RIGHT);
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
			btSalirTienda.setHorizontalAlignment(SwingConstants.RIGHT);
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
			lbPrecioTienda = new JLabel("Precio: 0");
			lbPrecioTienda.setHorizontalTextPosition(SwingConstants.RIGHT);
			lbPrecioTienda.setAlignmentX(Component.RIGHT_ALIGNMENT);
			lbPrecioTienda.setHorizontalAlignment(SwingConstants.RIGHT);
			lbPrecioTienda.setFont(new Font("Tahoma", Font.PLAIN, 20));
		}
		return lbPrecioTienda;
	}
	private JPanel getPnProductos() {
		if (pnProductos == null) {
			pnProductos = new JPanel();
			pnProductos.setLayout(new GridLayout(0, 1, 10, 0));
			crearBotonesProductos();
		}
		return pnProductos;
	}
	private void crearBotonesProductos() {
		for(int i = 0; i < tl.getMerchandaising().size(); i++) {
			getPnProductos().add(nuevoBotonProductos(i));
		}
	}
	
	private Component nuevoBotonProductos(Integer posicion) {
		JButton boton = new JButton("");
		boton.setBackground(Color.white);
		boton.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
		boton.setActionCommand(posicion.toString());
		boton.addActionListener(pBP);
		boton.setVerticalAlignment(SwingConstants.CENTER);
		Merchandaising m = tl.getMerchandaising().get(posicion);
		boton.setText(m.getNombre() + " \n" +
					  m.getTipo() + " \n" +
					  m.getPrecio());
		boton.setToolTipText("Articulo: " + m.getNombre() + 
				", Precio: " + m.getPrecio());

		return boton;
	}
	
	public class ProcesaBotonProducto implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton) e.getSource();
			
			
			//Añade el articulo
			Merchandaising m = tl.getArticulo(Integer.parseInt(source.getActionCommand()));
			int unidades = (int) getSpUnidades().getValue();
//			int res = JOptionPane.showConfirmDialog(null, "¿Quieres añadir " + unidades + 
//					" unidad(es) de " + m.getNombre() + "?");
			
			String[] botones = {"Si" , "No"};
			int res = JOptionPane.showOptionDialog(null, "¿Quieres añadir " + unidades + 
					" unidad(es) de " + m.getNombre() + "?","Confirmacion", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
			botones,botones[0]);
			
			if(res == 0) {
				tl.actualizarArticulosEnCesta(m, unidades);
				actualizarPrecioYLista();
				getBtEliminarTodo().setEnabled(true);
				getBtEliminarUnidades().setEnabled(true);
				getBtConfirmarTienda().setEnabled(true);
			}
		}

		
	}
	private void actualizarPrecioYLista() {
		getSpUnidades().setValue(1);
		//Añade a la lista
		modeloListArticulosSeleccionados.removeAllElements();
		modeloListArticulosSeleccionados.addAll(tl.getSeleccionado());;
		//calcula el precio
		int precioTotal = tl.getPrecioTotal();
		getLbPrecioTienda().setText("Precio: " + Integer.toString(precioTotal));
	}
	
	private JList<Merchandaising> getListArticulosSeleccionados() {
		if (listArticulosSeleccionados == null) {
			modeloListArticulosSeleccionados = new DefaultListModel<Merchandaising>();
			listArticulosSeleccionados = new JList<Merchandaising>(modeloListArticulosSeleccionados);
			listArticulosSeleccionados.setAlignmentX(Component.LEFT_ALIGNMENT);
			listArticulosSeleccionados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//			listArticulosSeleccionados.setToolTipText("Pulsa la tecla Supr para eliminar el articulo seleccionado");
//			listArticulosSeleccionados.addKeyListener(pS);
		}
		return listArticulosSeleccionados;
	}
	private JSpinner getSpUnidades() {
		if (spUnidades == null) {
			spUnidades = new JSpinner();
			spUnidades.setPreferredSize(new Dimension(100, 20));
			spUnidades.setMinimumSize(new Dimension(20, 20));
			spUnidades.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		}
		return spUnidades;
	}
	private JButton getBtEliminarTodo() {
		if (btEliminarTodo == null) {
			btEliminarTodo = new JButton("Eliminar (Todo)");
			btEliminarTodo.setMnemonic('t');
			btEliminarTodo.setEnabled(false);
			btEliminarTodo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					eliminarTodosLosArticulos();
				}
			});
		}
		return btEliminarTodo;
	}
	private void eliminarTodosLosArticulos() {
		String[] botones = {"Si" , "No"};
		int res = JOptionPane.showOptionDialog(null, "¿Quieres eliminar todos los articulos seleccionados?"
				,"Confirmacion", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
		botones,botones[0]);
		
		if(res == 0) {
			tl.eliminarSeleccion();
			
			getLbPrecioTienda().setText("Precio: " + Integer.toString( tl.getPrecioTotal()));

			modeloListArticulosSeleccionados.removeAllElements();		
			getSpUnidades().setValue(1);
			getBtEliminarTodo().setEnabled(false);
			getBtEliminarUnidades().setEnabled(false);
			getBtConfirmarTienda().setEnabled(false);
		}
		
	}
	private JButton getBtEliminarUnidades() {
		if (btEliminarUnidades == null) {
			btEliminarUnidades = new JButton("Eliminar (Unidades)");
			btEliminarUnidades.setMnemonic('e');
			btEliminarUnidades.setEnabled(false);
			btEliminarUnidades.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					eliminarUdsArticuloSeleccionado();
				}
			});
		}
		return btEliminarUnidades;
	}
	private void eliminarUdsArticuloSeleccionado() {
		if(!getListArticulosSeleccionados().isSelectionEmpty()) {
			int index  = getListArticulosSeleccionados().getSelectedIndex();
			Merchandaising m = tl.getSeleccionado().get(index);
			int unidades = (int) getSpUnidades().getValue();
			
			String[] botones = {"Si" , "No"};
			int res = JOptionPane.showOptionDialog(null, "¿Quieres eliminar " + unidades + 
					" unidad(es) de " + m.getNombre() + "?","Confirmacion", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
			botones,botones[0]);
			
			if(res == 0) {
				tl.actualizarArticulosEnCesta(m, - unidades);
				
				int precio = tl.getPrecioTotal();
				getLbPrecioTienda().setText("Precio: " + precio);
				
				modeloListArticulosSeleccionados.removeAllElements();
				modeloListArticulosSeleccionados.addAll(tl.getSeleccionado());
				
				getSpUnidades().setValue(1);
			}
			
			if(modeloListArticulosSeleccionados.isEmpty()) {
				getBtEliminarTodo().setEnabled(false);
				getBtEliminarUnidades().setEnabled(false);
				getBtConfirmarTienda().setEnabled(false);
			}
		}
		
	}
	private JPanel getPnContenido() {
		if (pnContenido == null) {
			pnContenido = new JPanel();
			pnContenido.setLayout(new BorderLayout(0, 0));
			pnContenido.add(getPnProductos(), BorderLayout.WEST);
			pnContenido.add(getPnUnidades());
			pnContenido.add(getPnPrecio(), BorderLayout.NORTH);
			pnContenido.add(getPnSeleccion(), BorderLayout.EAST);
		}
		return pnContenido;
	}
	private JLabel getLbUnidades() {
		if (lbUnidades == null) {
			lbUnidades = new JLabel("Unidades:");
			lbUnidades.setHorizontalTextPosition(SwingConstants.CENTER);
			lbUnidades.setHorizontalAlignment(SwingConstants.CENTER);
			lbUnidades.setDisplayedMnemonic('u');
			lbUnidades.setLabelFor(getSpUnidades());
		}
		return lbUnidades;
	}
	private JPanel getPnUnidades() {
		if (pnUnidades == null) {
			pnUnidades = new JPanel();
			FlowLayout fl_pnUnidades = new FlowLayout(FlowLayout.CENTER, 5, 5);
			fl_pnUnidades.setAlignOnBaseline(true);
			pnUnidades.setLayout(fl_pnUnidades);
			pnUnidades.add(getLbUnidades());
			pnUnidades.add(getSpUnidades());
		}
		return pnUnidades;
	}
	private JPanel getPnPrecio() {
		if (pnPrecio == null) {
			pnPrecio = new JPanel();
			pnPrecio.setLayout(new FlowLayout(FlowLayout.RIGHT, 100, 5));
			pnPrecio.add(getLbPrecioTienda());
		}
		return pnPrecio;
	}
	private JPanel getPnSeleccion() {
		if (pnSeleccion == null) {
			pnSeleccion = new JPanel();
			pnSeleccion.setLayout(new BorderLayout(1000, 0));
			pnSeleccion.add(getSpnProductosSeleccionados(), BorderLayout.CENTER);
			pnSeleccion.add(getPnBotonesEliminar(), BorderLayout.SOUTH);
		}
		return pnSeleccion;
	}
	private JPanel getPnBotonesEliminar() {
		if (pnBotonesEliminar == null) {
			pnBotonesEliminar = new JPanel();
			pnBotonesEliminar.add(getBtEliminarUnidades());
			pnBotonesEliminar.add(getBtEliminarTodo());
		}
		return pnBotonesEliminar;
	}
}
