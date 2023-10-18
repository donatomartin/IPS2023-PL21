package ips2023pl12.ui7;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;

public class EntradasView extends JFrame {
	
	private JFrame frame;
	private JButton btnComprar;
	private ButtonGroup grupoTribuna;
	private ButtonGroup grupoSeccion;
	private JSpinner spinnerNumEntradas;
	private JButton btnCancelar;

//	public static void main(String[] args) {
//		EntradasView v=new EntradasView();
//		v.getFrame().setVisible(true);
//
//	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public EntradasView() {
		initialize();
		frame.setLocationRelativeTo(null);
		
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.WHITE);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		frame.setTitle("Compra Entradas");
		frame.setName("Entradas");
		frame.setBounds(0, 0, 646, 422);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.getContentPane().setBackground(Color.white);
		setContentPane(getContentPane());
		JPanel panelTitular = new JPanel();
		panelTitular.setBackground(Color.WHITE);
		frame.getContentPane().add(panelTitular, BorderLayout.NORTH);
		
		JLabel lbEntradas = new JLabel("Compra de entradas");
		panelTitular.add(lbEntradas);
		lbEntradas.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lbEntradas.setHorizontalAlignment(SwingConstants.TRAILING);
		
		JPanel PanelCentro = new JPanel();
		PanelCentro.setBackground(Color.WHITE);
		frame.getContentPane().add(PanelCentro, BorderLayout.CENTER);
		
		JPanel panelTribuna = new JPanel();
		panelTribuna.setBackground(Color.WHITE);
		
		grupoTribuna=new ButtonGroup();
		
		JLabel lbTribuna = new JLabel("Elija tribuna:");
		panelTribuna.add(lbTribuna);
		lbTribuna.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JRadioButton rdbtnTribunaA = new JRadioButton("A");
		rdbtnTribunaA.setBackground(Color.WHITE);
		rdbtnTribunaA.setMnemonic('A');
		rdbtnTribunaA.setSelected(true);
		rdbtnTribunaA.setActionCommand("A");
		panelTribuna.add(rdbtnTribunaA);
		grupoTribuna.add(rdbtnTribunaA);
		
		JRadioButton rdbtnTribunaB = new JRadioButton("B");
		rdbtnTribunaB.setBackground(Color.WHITE);
		rdbtnTribunaB.setMnemonic('B');
		rdbtnTribunaB.setActionCommand("B");
		panelTribuna.add(rdbtnTribunaB);
		grupoTribuna.add(rdbtnTribunaB);
		
		JRadioButton rdbtnTribunaC = new JRadioButton("C");
		rdbtnTribunaC.setBackground(Color.WHITE);
		rdbtnTribunaC.setMnemonic('C');
		rdbtnTribunaC.setActionCommand("C");
		panelTribuna.add(rdbtnTribunaC);
		grupoTribuna.add(rdbtnTribunaC);
		
		JRadioButton rdbtnTribunaD = new JRadioButton("D");
		rdbtnTribunaD.setBackground(Color.WHITE);
		rdbtnTribunaD.setMnemonic('D');
		rdbtnTribunaD.setActionCommand("D");
		panelTribuna.add(rdbtnTribunaD);
		grupoTribuna.add(rdbtnTribunaD);
		
		grupoSeccion=new ButtonGroup();
		PanelCentro.setLayout(new BorderLayout(0, 0));
		PanelCentro.add(panelTribuna, BorderLayout.CENTER);
		
		JPanel panelSeccion = new JPanel();
		panelSeccion.setBackground(Color.WHITE);
		panelTribuna.add(panelSeccion);
		panelSeccion.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lbSeccion = new JLabel("Elija sección:");
		panelSeccion.add(lbSeccion);
		lbSeccion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JRadioButton rdbtnSeccionA = new JRadioButton("A");
		rdbtnSeccionA.setBackground(Color.WHITE);
		panelSeccion.add(rdbtnSeccionA);
		rdbtnSeccionA.setMnemonic('A');
		rdbtnSeccionA.setActionCommand("A");
		rdbtnSeccionA.setSelected(true);
		grupoSeccion.add(rdbtnSeccionA);
		
		JRadioButton rdbtnSeccionB = new JRadioButton("B");
		rdbtnSeccionB.setBackground(Color.WHITE);
		panelSeccion.add(rdbtnSeccionB);
		rdbtnSeccionB.setMnemonic('B');
		rdbtnSeccionB.setActionCommand("B");
		grupoSeccion.add(rdbtnSeccionB);
		
		JRadioButton rdbtnSeccionC = new JRadioButton("C");
		rdbtnSeccionC.setBackground(Color.WHITE);
		panelSeccion.add(rdbtnSeccionC);
		rdbtnSeccionC.setMnemonic('C');
		rdbtnSeccionC.setActionCommand("C");
		grupoSeccion.add(rdbtnSeccionC);
		
		JRadioButton rdbtnSeccionD = new JRadioButton("D");
		rdbtnSeccionD.setBackground(Color.WHITE);
		panelSeccion.add(rdbtnSeccionD);
		rdbtnSeccionD.setMnemonic('D');
		rdbtnSeccionD.setActionCommand("D");
		grupoSeccion.add(rdbtnSeccionD);
		
		JRadioButton rdbtnSeccionE = new JRadioButton("E");
		rdbtnSeccionE.setBackground(Color.WHITE);
		panelSeccion.add(rdbtnSeccionE);
		rdbtnSeccionE.setMnemonic('E');
		rdbtnSeccionE.setActionCommand("E");
		grupoSeccion.add(rdbtnSeccionE);
		
		JRadioButton rdbtnSeccionF = new JRadioButton("F");
		rdbtnSeccionF.setBackground(Color.WHITE);
		panelSeccion.add(rdbtnSeccionF);
		rdbtnSeccionF.setMnemonic('F');
		rdbtnSeccionF.setActionCommand("F");
		grupoSeccion.add(rdbtnSeccionF);
		
		JPanel panelNumeroEntradas = new JPanel();
		panelNumeroEntradas.setBackground(Color.WHITE);
		PanelCentro.add(panelNumeroEntradas, BorderLayout.SOUTH);
		panelNumeroEntradas.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lbNumEntradas = new JLabel("Número de entradas:");
		panelNumeroEntradas.add(lbNumEntradas);
		lbNumEntradas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		spinnerNumEntradas = new JSpinner();
		panelNumeroEntradas.add(spinnerNumEntradas);
		spinnerNumEntradas.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), new Integer(15), new Integer(1)));
		
		
		JPanel panelBienvenida = new JPanel();
		panelBienvenida.setBackground(Color.WHITE);
		PanelCentro.add(panelBienvenida, BorderLayout.NORTH);
		panelBienvenida.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lbBienvenida = new JLabel("¡Bienvenido! Está a punto de realizar su compra.");
		lbBienvenida.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelBienvenida.add(lbBienvenida);
		
		JPanel panelSur = new JPanel();
		panelSur.setBackground(Color.WHITE);
		frame.getContentPane().add(panelSur, BorderLayout.SOUTH);
		
		btnComprar = new JButton("Comprar");
		btnComprar.setMnemonic('p');
		btnComprar.setBackground(Color.GREEN);
		panelSur.add(btnComprar);
		btnComprar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setMnemonic('c');
		btnCancelar.setBackground(Color.RED);
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelSur.add(btnCancelar);
		
	}
	
	public JFrame getFrame() { return this.frame; }
	public JButton getBtnComprar() { return this.btnComprar; }
	public ButtonGroup getButtonGroupTribuna() {return this.grupoTribuna;}
	public ButtonGroup getButtonGroupSecion() {return this.grupoSeccion;}
	public JSpinner getSpinnerNumEntradas() {return this.spinnerNumEntradas;}
	public JButton getBtnCancelar() {return this.btnCancelar;}
}
