package ips2023pl21.ui;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.text.DateFormatter;

import ips2023pl21.util.Util;

//import com.sun.jmx.mbeanserver.Util;

import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.SpringLayout;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JToggleButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Component;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;

import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class Frame21918 extends JFrame{
	
	
	private JFrame frame;
	private JButton btVerVentas;
	private JFormattedTextField textFieldFechaFinal;
	private JTable tableVentas;
	private JButton btCancelar;
	private JTable tableDetalles;
	private JFormattedTextField textFieldFechaInicial;
	private JTextField textFieldIngresosTotales;
	private JButton btTodasVentas;
	
	public Frame21918() {
		initialize();
		frame.setLocationRelativeTo(null);
		
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.WHITE);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(true);
		frame.setTitle("Historial Ventas");
		frame.setBounds(0, 0, 800, 800);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setMinimumSize(new Dimension(40,40));
		
		
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setBackground(UIManager.getColor("scrollbar"));
		frame.getContentPane().add(panelTitulo, BorderLayout.NORTH);
		
		JLabel lbTitulo = new JLabel("Historial de Ventas");
		panelTitulo.add(lbTitulo);
		lbTitulo.setFont(new Font("Stencil", Font.PLAIN, 36));
		
		JPanel panelCentro = new JPanel();
		panelCentro.setBackground(Color.WHITE);
		frame.getContentPane().add(panelCentro, BorderLayout.CENTER);
				
				JPanel pnNorteCentro = new JPanel();
				pnNorteCentro.setBackground(Color.WHITE);
				pnNorteCentro.setMinimumSize(new Dimension(79, 10));
				pnNorteCentro.setAlignmentX(Component.LEFT_ALIGNMENT);
				
				JPanel pnFechaInicial = new JPanel();
				pnFechaInicial.setBackground(Color.WHITE);
				
				JLabel lbFechaInicial = new JLabel("Introduzca fecha inicial:");
				pnFechaInicial.add(lbFechaInicial);
				lbFechaInicial.setFont(new Font("Tahoma", Font.PLAIN, 16));
				
				DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd"); 
				DateFormatter dateFormatter1 = new DateFormatter(dateFormat); 
				textFieldFechaInicial = new JFormattedTextField(dateFormatter1);
				textFieldFechaInicial.setColumns(10);

				
				pnFechaInicial.add(textFieldFechaInicial);
				
				JPanel pnFechaFinal = new JPanel();
				pnFechaFinal.setBackground(Color.WHITE);
				
				
				JLabel lbFechaIFinal = new JLabel("Introduzca fecha final:");
				pnFechaFinal.add(lbFechaIFinal);
				lbFechaIFinal.setFont(new Font("Tahoma", Font.PLAIN, 16));
				
				
				textFieldFechaFinal = new JFormattedTextField(dateFormatter1);
				pnFechaFinal.add(textFieldFechaFinal);
				textFieldFechaFinal.setColumns(10);
				
				btVerVentas = new JButton("Ver ventas");
				btVerVentas.setBackground(UIManager.getColor("scrollbar"));
				btVerVentas.setMnemonic('v');
				pnFechaFinal.add(btVerVentas);
				btVerVentas.setFont(new Font("Tahoma", Font.PLAIN, 16));
				
				JPanel pnVentas = new JPanel();
				pnVentas.setBackground(Color.WHITE);
				pnVentas.setLayout(new BorderLayout(0, 0));
				
				JLabel lbVentas = new JLabel("Ventas:");
				pnVentas.add(lbVentas, BorderLayout.NORTH);
				lbVentas.setFont(new Font("Tahoma", Font.PLAIN, 16));
				
				JScrollPane scrollPaneVentas = new JScrollPane();
				scrollPaneVentas.setBackground(Color.WHITE);
				scrollPaneVentas.setFont(new Font("Tahoma", Font.PLAIN, 16));
				pnVentas.add(scrollPaneVentas);
				
				tableVentas = new JTable();
				tableVentas.setBackground(Color.WHITE);
				tableVentas.setFont(new Font("Tahoma", Font.PLAIN, 16));
				tableVentas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				tableVentas.setDefaultEditor(Object.class, null); //readonly
				scrollPaneVentas.setViewportView(tableVentas);
				
				JPanel pnDetalles = new JPanel();
				pnDetalles.setBackground(Color.WHITE);
				pnDetalles.setLayout(new BorderLayout(0, 0));
				
				JLabel lbDetalles = new JLabel("Detalles:");
				lbDetalles.setFont(new Font("Tahoma", Font.PLAIN, 16));
				pnDetalles.add(lbDetalles, BorderLayout.NORTH);
				
				JScrollPane scrollPaneDetalles = new JScrollPane();
				scrollPaneDetalles.setBackground(Color.WHITE);
				pnDetalles.add(scrollPaneDetalles);
				
				tableDetalles = new JTable();
				tableDetalles.setBackground(Color.WHITE);
				tableDetalles.setFont(new Font("Tahoma", Font.PLAIN, 16));
				scrollPaneDetalles.setViewportView(tableDetalles);
				
				JPanel panel = new JPanel();
				panel.setBackground(Color.WHITE);
				GroupLayout gl_panelCentro = new GroupLayout(panelCentro);
				gl_panelCentro.setHorizontalGroup(
					gl_panelCentro.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelCentro.createSequentialGroup()
							.addGap(30)
							.addComponent(pnNorteCentro, GroupLayout.DEFAULT_SIZE, 712, Short.MAX_VALUE)
							.addGap(44))
						.addGroup(gl_panelCentro.createSequentialGroup()
							.addGroup(gl_panelCentro.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panelCentro.createSequentialGroup()
									.addContainerGap()
									.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panelCentro.createSequentialGroup()
									.addGap(50)
									.addComponent(pnVentas, GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
									.addGap(18)
									.addComponent(pnDetalles, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)))
							.addGap(53))
				);
				gl_panelCentro.setVerticalGroup(
					gl_panelCentro.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelCentro.createSequentialGroup()
							.addGap(76)
							.addComponent(pnNorteCentro, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addGroup(gl_panelCentro.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelCentro.createSequentialGroup()
									.addComponent(pnDetalles, 0, 0, Short.MAX_VALUE)
									.addGap(34)
									.addComponent(panel, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
									.addGap(18))
								.addGroup(gl_panelCentro.createSequentialGroup()
									.addComponent(pnVentas, GroupLayout.PREFERRED_SIZE, 373, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())))
				);
				
				btTodasVentas = new JButton("Ver todas");
				btTodasVentas.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btTodasVentas.setFont(new Font("Tahoma", Font.PLAIN, 16));
				pnNorteCentro.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
				pnNorteCentro.add(pnFechaInicial);
				pnNorteCentro.add(pnFechaFinal);
				pnNorteCentro.add(btTodasVentas);
				
				JLabel lbIngresosTotales = new JLabel("Ingresos Totales: ");
				lbIngresosTotales.setFont(new Font("Tahoma", Font.PLAIN, 16));
				panel.add(lbIngresosTotales);
				
				textFieldIngresosTotales = new JTextField();
				textFieldIngresosTotales.setFont(new Font("Tahoma", Font.PLAIN, 16));
				textFieldIngresosTotales.setEditable(false);
				panel.add(textFieldIngresosTotales);
				textFieldIngresosTotales.setColumns(10);
				panelCentro.setLayout(gl_panelCentro);
				
				JPanel pnCancelar = new JPanel();
				pnCancelar.setBackground(Color.WHITE);
				frame.getContentPane().add(pnCancelar, BorderLayout.SOUTH);
				
				btCancelar = new JButton("Cancelar");
				btCancelar.setBackground(Color.RED);
				btCancelar.setFont(new Font("Tahoma", Font.PLAIN, 16));
				btCancelar.setMnemonic('c');
				pnCancelar.add(btCancelar);
		
		
	}
	
	public JFrame getFrame() { return this.frame; }
	public JButton getBtVerVentas() { return this.btVerVentas; }
	public String getFechaFinal() { return this.textFieldFechaFinal.getText(); }
	public String getFechaInicial() { return this.textFieldFechaInicial.getText(); }
	public JTable getTableVentas() {return this.tableVentas;}
	public JButton getBtCancelar() {return this.btCancelar;}
	public JTable getTableDetalles() {return this.tableDetalles;}
	public JFormattedTextField getTxFieldFechaInicial() {return this.textFieldFechaInicial;}
	public JFormattedTextField getTxFieldFechaFinal() {return this.textFieldFechaFinal;}
	public JTextField getTxFieldIngresosTotales() {return this.textFieldIngresosTotales;}
	public JButton getBtTodasVentas() {return btTodasVentas;}
}
