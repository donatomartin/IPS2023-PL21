package ips2023pl21.ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.FlowLayout;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.GridLayout;

public class Frame22733 extends JFrame{
	private JFrame frame;
	private JLabel lbTitulo;
	private JLabel lbDescripcion;
	private JLabel lblNewLabel;
	private JButton btnComprar;
	private JButton btCancelar;
	private JPanel panelEscoger;
	private JLabel lbTribuna;
	private JRadioButton rdbtnTribunaA;
	private JRadioButton rdbtnTribunaB;
	private JRadioButton rdbtnTribunaC;
	private JRadioButton rdbtnTribunaD;
	private JPanel panelSeccion;
	private JLabel lbSeccion;
	private JRadioButton rdbtnSeccionA;
	private JRadioButton rdbtnSeccionB;
	private JRadioButton rdbtnSeccionC;
	private JRadioButton rdbtnSeccionD;
	private JRadioButton rdbtnSeccionE;
	private JRadioButton rdbtnSeccionF;
	private JLabel lbFila;
	private JSpinner spinnerFila;
	private JPanel panelFila;
	private JPanel panelTitulo;
	private JPanel panelBotonesSur;
	private JPanel panelTribuna;
	private JPanel panelFechaNacimiento;
	private JLabel lbFechaNacimiento;
	private JTextField txtFieldFechaNacimiento;
	private JPanel panelAsientosOcupados;
	private JPanel panelAsiento;
	private JLabel lblAsiento;
	private JSpinner spinnerAsiento;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JButton btnNewButton_6;
	private JButton btnNewButton_7;
	private JButton btnNewButton_8;
	private JButton btnNewButton_9;
	private JButton btnNewButton_10;
	private JButton btnNewButton_11;
	private JButton btnNewButton_12;
	private JButton btnNewButton_13;
	private JButton btnNewButton_14;
	private JButton btnNewButton_14_1;
	private JButton btnNewButton_14_2;
	private JButton btnNewButton_14_3;
	private JButton btnNewButton_14_4;
	private JButton btnNewButton_14_5;
	private JButton btnNewButton_14_6;
	private JButton btnNewButton_14_7;
	private JButton btnNewButton_14_8;
	private JButton btnNewButton_14_9;
	private JButton btnNewButton_14_10;
	private JButton btnNewButton_14_11;
	private JButton btnNewButton_14_12;
	private JButton btnNewButton_14_13;
	private JButton btnNewButton_14_14;
	private JButton btnNewButton_14_15;
	private JButton btnNewButton_14_16;
	private JButton btnNewButton_14_17;
	private JButton btnNewButton_14_18;
	private JButton btnNewButton_14_19;
	private JButton btnNewButton_14_20;
	private JButton btnNewButton_14_21;
	private JButton btnNewButton_14_22;
	private JButton btnNewButton_14_23;
	private JButton btnNewButton_14_24;
	private JButton btnNewButton_14_25;
	private JButton btnNewButton_14_26;
	private JButton btnNewButton_14_27;
	private JButton btnNewButton_14_28;
	private JButton btnNewButton_14_29;
	private JButton btnNewButton_14_30;
	private JButton btnNewButton_14_31;
	private JButton btnNewButton_14_32;
	private JButton btnNewButton_14_33;
	private JButton btnNewButton_14_34;
	private JButton btnNewButton_14_35;
	private JButton btnNewButton_14_36;
	private JButton btnNewButton_14_37;
	private JButton btnNewButton_14_38;
	private JButton btnNewButton_14_39;
	private JButton btnNewButton_14_40;
	private JButton btnNewButton_14_41;
	private JButton btnNewButton_14_42;
	private JButton btnNewButton_14_43;
	
	
	
	public Frame22733() {
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(getPanelEscoger());
		getContentPane().add(getPanelTitulo(), BorderLayout.NORTH);
		getContentPane().add(getPanelBotonesSur(), BorderLayout.SOUTH);
	}
	private JLabel getLbTitulo() {
		if (lbTitulo == null) {
			lbTitulo = new JLabel("Compra de abonos");
			lbTitulo.setBackground(Color.WHITE);
			lbTitulo.setFont(new Font("Verdana Pro Black", Font.PLAIN, 19));
		}
		return lbTitulo;
	}
	private JLabel getLbDescripcion() {
		if (lbDescripcion == null) {
			lbDescripcion = new JLabel("Está a punto de realizar una compra de abonos.");
			lbDescripcion.setBackground(Color.WHITE);
			lbDescripcion.setFont(new Font("Verdana", Font.PLAIN, 16));
		}
		return lbDescripcion;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("El abono tiene una duración de un año. Dede el 1 de julio hasta el 31 de junio.");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return lblNewLabel;
	}
	private JButton getBtnComprar() {
		if (btnComprar == null) {
			btnComprar = new JButton("Comprar");
			btnComprar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnComprar.setBackground(Color.GREEN);
			btnComprar.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnComprar.setMnemonic('m');
		}
		return btnComprar;
	}
	public JButton getBtCancelar() {
		if (btCancelar == null) {
			btCancelar = new JButton("Cancelar");
			btCancelar.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btCancelar.setBackground(Color.RED);
		}
		return btCancelar;
	}
	public JFrame getFrame() { return this.frame; }
	private JPanel getPanelEscoger() {
		if (panelEscoger == null) {
			panelEscoger = new JPanel();
			panelEscoger.setBackground(Color.WHITE);
			GroupLayout gl_panelEscoger = new GroupLayout(panelEscoger);
			gl_panelEscoger.setHorizontalGroup(
				gl_panelEscoger.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_panelEscoger.createSequentialGroup()
						.addGap(127)
						.addComponent(getLbDescripcion(), GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
						.addGap(131))
					.addGroup(Alignment.LEADING, gl_panelEscoger.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panelEscoger.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panelEscoger.createSequentialGroup()
								.addGap(10)
								.addComponent(getPanelFechaNacimiento(), GroupLayout.PREFERRED_SIZE, 407, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
							.addGroup(gl_panelEscoger.createSequentialGroup()
								.addComponent(getLblNewLabel(), GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
								.addGap(42))))
					.addGroup(gl_panelEscoger.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panelEscoger.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panelEscoger.createSequentialGroup()
								.addComponent(getPanelSeccion(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGap(18))
							.addGroup(gl_panelEscoger.createSequentialGroup()
								.addComponent(getPanelTribuna(), GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
								.addGap(72))
							.addGroup(gl_panelEscoger.createSequentialGroup()
								.addGroup(gl_panelEscoger.createParallelGroup(Alignment.TRAILING)
									.addComponent(getPanelAsiento(), GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
									.addComponent(getPanelFila(), GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE))
								.addGap(82)))
						.addGap(18)
						.addComponent(getPanelAsientosOcupados(), GroupLayout.PREFERRED_SIZE, 373, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
			);
			gl_panelEscoger.setVerticalGroup(
				gl_panelEscoger.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panelEscoger.createSequentialGroup()
						.addGap(21)
						.addComponent(getLbDescripcion())
						.addGap(18)
						.addComponent(getLblNewLabel())
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(getPanelFechaNacimiento(), GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addGroup(gl_panelEscoger.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panelEscoger.createSequentialGroup()
								.addComponent(getPanelTribuna(), GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(getPanelSeccion(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(getPanelFila(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(getPanelAsiento(), GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
								.addGap(23))
							.addGroup(gl_panelEscoger.createSequentialGroup()
								.addComponent(getPanelAsientosOcupados(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addContainerGap())))
			);
			panelEscoger.setLayout(gl_panelEscoger);
		}
		return panelEscoger;
	}
	private JLabel getLbTribuna() {
		if (lbTribuna == null) {
			lbTribuna = new JLabel("Elija tribuna:");
			lbTribuna.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return lbTribuna;
	}
	private JRadioButton getRdbtnTribunaA() {
		if (rdbtnTribunaA == null) {
			rdbtnTribunaA = new JRadioButton("A");
			rdbtnTribunaA.setSelected(true);
			rdbtnTribunaA.setMnemonic('A');
			rdbtnTribunaA.setBackground(Color.WHITE);
			rdbtnTribunaA.setActionCommand("A");
		}
		return rdbtnTribunaA;
	}
	private JRadioButton getRdbtnTribunaB() {
		if (rdbtnTribunaB == null) {
			rdbtnTribunaB = new JRadioButton("B");
			rdbtnTribunaB.setMnemonic('B');
			rdbtnTribunaB.setBackground(Color.WHITE);
			rdbtnTribunaB.setActionCommand("B");
		}
		return rdbtnTribunaB;
	}
	private JRadioButton getRdbtnTribunaC() {
		if (rdbtnTribunaC == null) {
			rdbtnTribunaC = new JRadioButton("C");
			rdbtnTribunaC.setMnemonic('C');
			rdbtnTribunaC.setBackground(Color.WHITE);
			rdbtnTribunaC.setActionCommand("C");
		}
		return rdbtnTribunaC;
	}
	private JRadioButton getRdbtnTribunaD() {
		if (rdbtnTribunaD == null) {
			rdbtnTribunaD = new JRadioButton("D");
			rdbtnTribunaD.setMnemonic('D');
			rdbtnTribunaD.setBackground(Color.WHITE);
			rdbtnTribunaD.setActionCommand("D");
		}
		return rdbtnTribunaD;
	}
	private JPanel getPanelSeccion() {
		if (panelSeccion == null) {
			panelSeccion = new JPanel();
			panelSeccion.setBackground(Color.WHITE);
			panelSeccion.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panelSeccion.add(getLbSeccion());
			panelSeccion.add(getRdbtnSeccionA());
			panelSeccion.add(getRdbtnSeccionB());
			panelSeccion.add(getRdbtnSeccionC());
			panelSeccion.add(getRdbtnSeccionD());
			panelSeccion.add(getRdbtnSeccionE());
			panelSeccion.add(getRdbtnSeccionF());
		}
		return panelSeccion;
	}
	private JLabel getLbSeccion() {
		if (lbSeccion == null) {
			lbSeccion = new JLabel("Elija sección:");
			lbSeccion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return lbSeccion;
	}
	private JRadioButton getRdbtnSeccionA() {
		if (rdbtnSeccionA == null) {
			rdbtnSeccionA = new JRadioButton("A");
			rdbtnSeccionA.setSelected(true);
			rdbtnSeccionA.setMnemonic('A');
			rdbtnSeccionA.setBackground(Color.WHITE);
			rdbtnSeccionA.setActionCommand("A");
		}
		return rdbtnSeccionA;
	}
	private JRadioButton getRdbtnSeccionB() {
		if (rdbtnSeccionB == null) {
			rdbtnSeccionB = new JRadioButton("B");
			rdbtnSeccionB.setMnemonic('B');
			rdbtnSeccionB.setBackground(Color.WHITE);
			rdbtnSeccionB.setActionCommand("B");
		}
		return rdbtnSeccionB;
	}
	private JRadioButton getRdbtnSeccionC() {
		if (rdbtnSeccionC == null) {
			rdbtnSeccionC = new JRadioButton("C");
			rdbtnSeccionC.setMnemonic('C');
			rdbtnSeccionC.setBackground(Color.WHITE);
			rdbtnSeccionC.setActionCommand("C");
		}
		return rdbtnSeccionC;
	}
	private JRadioButton getRdbtnSeccionD() {
		if (rdbtnSeccionD == null) {
			rdbtnSeccionD = new JRadioButton("D");
			rdbtnSeccionD.setMnemonic('D');
			rdbtnSeccionD.setBackground(Color.WHITE);
			rdbtnSeccionD.setActionCommand("D");
		}
		return rdbtnSeccionD;
	}
	private JRadioButton getRdbtnSeccionE() {
		if (rdbtnSeccionE == null) {
			rdbtnSeccionE = new JRadioButton("E");
			rdbtnSeccionE.setMnemonic('E');
			rdbtnSeccionE.setBackground(Color.WHITE);
			rdbtnSeccionE.setActionCommand("E");
		}
		return rdbtnSeccionE;
	}
	private JRadioButton getRdbtnSeccionF() {
		if (rdbtnSeccionF == null) {
			rdbtnSeccionF = new JRadioButton("F");
			rdbtnSeccionF.setMnemonic('F');
			rdbtnSeccionF.setBackground(Color.WHITE);
			rdbtnSeccionF.setActionCommand("F");
		}
		return rdbtnSeccionF;
	}
	private JLabel getLbFila() {
		if (lbFila == null) {
			lbFila = new JLabel("Elija fila:");
			lbFila.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return lbFila;
	}
	private JSpinner getSpinnerFila() {
		if (spinnerFila == null) {
			spinnerFila = new JSpinner();
			spinnerFila.setFont(new Font("Tahoma", Font.PLAIN, 16));
			spinnerFila.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), new Integer(9), new Integer(9)));
		}
		return spinnerFila;
	}
	private JPanel getPanelFila() {
		if (panelFila == null) {
			panelFila = new JPanel();
			panelFila.setBackground(Color.WHITE);
			panelFila.add(getLbFila());
			panelFila.add(getSpinnerFila());
		}
		return panelFila;
	}
	private JPanel getPanelTitulo() {
		if (panelTitulo == null) {
			panelTitulo = new JPanel();
			panelTitulo.setBackground(Color.WHITE);
			panelTitulo.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panelTitulo.add(getLbTitulo());
		}
		return panelTitulo;
	}
	private JPanel getPanelBotonesSur() {
		if (panelBotonesSur == null) {
			panelBotonesSur = new JPanel();
			panelBotonesSur.setBackground(Color.WHITE);
			panelBotonesSur.add(getBtnComprar());
			panelBotonesSur.add(getBtCancelar());
		}
		return panelBotonesSur;
	}
	private JPanel getPanelTribuna() {
		if (panelTribuna == null) {
			panelTribuna = new JPanel();
			panelTribuna.setBackground(Color.WHITE);
			panelTribuna.add(getLbTribuna());
			panelTribuna.add(getRdbtnTribunaA());
			panelTribuna.add(getRdbtnTribunaB());
			panelTribuna.add(getRdbtnTribunaC());
			panelTribuna.add(getRdbtnTribunaD());
		}
		return panelTribuna;
	}
	private JPanel getPanelFechaNacimiento() {
		if (panelFechaNacimiento == null) {
			panelFechaNacimiento = new JPanel();
			panelFechaNacimiento.setBackground(Color.WHITE);
			panelFechaNacimiento.add(getLbFechaNacimiento());
			panelFechaNacimiento.add(getTxtFieldFechaNacimiento());
		}
		return panelFechaNacimiento;
	}
	private JLabel getLbFechaNacimiento() {
		if (lbFechaNacimiento == null) {
			lbFechaNacimiento = new JLabel("Introduzca su fecha de nacimiento:");
			lbFechaNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return lbFechaNacimiento;
	}
	private JTextField getTxtFieldFechaNacimiento() {
		if (txtFieldFechaNacimiento == null) {
			txtFieldFechaNacimiento = new JTextField();
			txtFieldFechaNacimiento.setColumns(10);
		}
		return txtFieldFechaNacimiento;
	}
	private JPanel getPanelAsientosOcupados() {
		if (panelAsientosOcupados == null) {
			panelAsientosOcupados = new JPanel();
			panelAsientosOcupados.setLayout(new GridLayout(10, 15, 0, 0));
			panelAsientosOcupados.add(getBtnNewButton_1());
			panelAsientosOcupados.add(getBtnNewButton());
			panelAsientosOcupados.add(getBtnNewButton_2());
			panelAsientosOcupados.add(getBtnNewButton_3());
			panelAsientosOcupados.add(getBtnNewButton_4());
			panelAsientosOcupados.add(getBtnNewButton_5());
			panelAsientosOcupados.add(getBtnNewButton_6());
			panelAsientosOcupados.add(getBtnNewButton_8());
			panelAsientosOcupados.add(getBtnNewButton_9());
			panelAsientosOcupados.add(getBtnNewButton_10());
			panelAsientosOcupados.add(getBtnNewButton_7());
			panelAsientosOcupados.add(getBtnNewButton_11());
			panelAsientosOcupados.add(getBtnNewButton_12());
			panelAsientosOcupados.add(getBtnNewButton_14());
			panelAsientosOcupados.add(getBtnNewButton_14_1());
			panelAsientosOcupados.add(getBtnNewButton_14_2());
			panelAsientosOcupados.add(getBtnNewButton_13());
			panelAsientosOcupados.add(getBtnNewButton_14_6());
			panelAsientosOcupados.add(getBtnNewButton_14_4());
			panelAsientosOcupados.add(getBtnNewButton_14_7());
			panelAsientosOcupados.add(getBtnNewButton_14_3());
			panelAsientosOcupados.add(getBtnNewButton_14_5());
			panelAsientosOcupados.add(getBtnNewButton_14_10());
			panelAsientosOcupados.add(getBtnNewButton_14_8());
			panelAsientosOcupados.add(getBtnNewButton_14_9());
			panelAsientosOcupados.add(getBtnNewButton_14_13());
			panelAsientosOcupados.add(getBtnNewButton_14_16());
			panelAsientosOcupados.add(getBtnNewButton_14_11());
			panelAsientosOcupados.add(getBtnNewButton_14_12());
			panelAsientosOcupados.add(getBtnNewButton_14_14());
			panelAsientosOcupados.add(getBtnNewButton_14_18());
			panelAsientosOcupados.add(getBtnNewButton_14_15());
			panelAsientosOcupados.add(getBtnNewButton_14_17());
			panelAsientosOcupados.add(getBtnNewButton_14_19());
			panelAsientosOcupados.add(getBtnNewButton_14_23());
			panelAsientosOcupados.add(getBtnNewButton_14_22());
			panelAsientosOcupados.add(getBtnNewButton_14_21());
			panelAsientosOcupados.add(getBtnNewButton_14_28());
			panelAsientosOcupados.add(getBtnNewButton_14_20());
			panelAsientosOcupados.add(getBtnNewButton_14_26());
			panelAsientosOcupados.add(getBtnNewButton_14_25());
			panelAsientosOcupados.add(getBtnNewButton_14_24());
			panelAsientosOcupados.add(getBtnNewButton_14_27());
			panelAsientosOcupados.add(getBtnNewButton_14_31());
			panelAsientosOcupados.add(getBtnNewButton_14_36());
			panelAsientosOcupados.add(getBtnNewButton_14_29());
			panelAsientosOcupados.add(getBtnNewButton_14_30());
			panelAsientosOcupados.add(getBtnNewButton_14_32());
			panelAsientosOcupados.add(getBtnNewButton_14_33());
			panelAsientosOcupados.add(getBtnNewButton_14_34());
			panelAsientosOcupados.add(getBtnNewButton_14_35());
			panelAsientosOcupados.add(getBtnNewButton_14_37());
			panelAsientosOcupados.add(getBtnNewButton_14_40());
			panelAsientosOcupados.add(getBtnNewButton_14_38());
			panelAsientosOcupados.add(getBtnNewButton_14_39());
			panelAsientosOcupados.add(getBtnNewButton_14_41());
			panelAsientosOcupados.add(getBtnNewButton_14_42());
			panelAsientosOcupados.add(getBtnNewButton_14_43());
		}
		return panelAsientosOcupados;
	}
	private JPanel getPanelAsiento() {
		if (panelAsiento == null) {
			panelAsiento = new JPanel();
			panelAsiento.setBackground(Color.WHITE);
			panelAsiento.add(getLblAsiento());
			panelAsiento.add(getSpinnerAsiento());
		}
		return panelAsiento;
	}
	private JLabel getLblAsiento() {
		if (lblAsiento == null) {
			lblAsiento = new JLabel("Elija asiento:");
			lblAsiento.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return lblAsiento;
	}
	private JSpinner getSpinnerAsiento() {
		if (spinnerAsiento == null) {
			spinnerAsiento = new JSpinner();
			spinnerAsiento.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return spinnerAsiento;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("New button");
		}
		return btnNewButton;
	}
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("New button");
		}
		return btnNewButton_1;
	}
	private JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("New button");
		}
		return btnNewButton_2;
	}
	private JButton getBtnNewButton_3() {
		if (btnNewButton_3 == null) {
			btnNewButton_3 = new JButton("New button");
		}
		return btnNewButton_3;
	}
	private JButton getBtnNewButton_4() {
		if (btnNewButton_4 == null) {
			btnNewButton_4 = new JButton("New button");
		}
		return btnNewButton_4;
	}
	private JButton getBtnNewButton_5() {
		if (btnNewButton_5 == null) {
			btnNewButton_5 = new JButton("New button");
		}
		return btnNewButton_5;
	}
	private JButton getBtnNewButton_6() {
		if (btnNewButton_6 == null) {
			btnNewButton_6 = new JButton("New button");
		}
		return btnNewButton_6;
	}
	private JButton getBtnNewButton_7() {
		if (btnNewButton_7 == null) {
			btnNewButton_7 = new JButton("New button");
		}
		return btnNewButton_7;
	}
	private JButton getBtnNewButton_8() {
		if (btnNewButton_8 == null) {
			btnNewButton_8 = new JButton("New button");
		}
		return btnNewButton_8;
	}
	private JButton getBtnNewButton_9() {
		if (btnNewButton_9 == null) {
			btnNewButton_9 = new JButton("New button");
		}
		return btnNewButton_9;
	}
	private JButton getBtnNewButton_10() {
		if (btnNewButton_10 == null) {
			btnNewButton_10 = new JButton("New button");
		}
		return btnNewButton_10;
	}
	private JButton getBtnNewButton_11() {
		if (btnNewButton_11 == null) {
			btnNewButton_11 = new JButton("New button");
		}
		return btnNewButton_11;
	}
	private JButton getBtnNewButton_12() {
		if (btnNewButton_12 == null) {
			btnNewButton_12 = new JButton("New button");
		}
		return btnNewButton_12;
	}
	private JButton getBtnNewButton_13() {
		if (btnNewButton_13 == null) {
			btnNewButton_13 = new JButton("New button");
		}
		return btnNewButton_13;
	}
	private JButton getBtnNewButton_14() {
		if (btnNewButton_14 == null) {
			btnNewButton_14 = new JButton("New button");
		}
		return btnNewButton_14;
	}
	private JButton getBtnNewButton_14_1() {
		if (btnNewButton_14_1 == null) {
			btnNewButton_14_1 = new JButton("New button");
		}
		return btnNewButton_14_1;
	}
	private JButton getBtnNewButton_14_2() {
		if (btnNewButton_14_2 == null) {
			btnNewButton_14_2 = new JButton("New button");
		}
		return btnNewButton_14_2;
	}
	private JButton getBtnNewButton_14_3() {
		if (btnNewButton_14_3 == null) {
			btnNewButton_14_3 = new JButton("New button");
		}
		return btnNewButton_14_3;
	}
	private JButton getBtnNewButton_14_4() {
		if (btnNewButton_14_4 == null) {
			btnNewButton_14_4 = new JButton("New button");
		}
		return btnNewButton_14_4;
	}
	private JButton getBtnNewButton_14_5() {
		if (btnNewButton_14_5 == null) {
			btnNewButton_14_5 = new JButton("New button");
		}
		return btnNewButton_14_5;
	}
	private JButton getBtnNewButton_14_6() {
		if (btnNewButton_14_6 == null) {
			btnNewButton_14_6 = new JButton("New button");
		}
		return btnNewButton_14_6;
	}
	private JButton getBtnNewButton_14_7() {
		if (btnNewButton_14_7 == null) {
			btnNewButton_14_7 = new JButton("New button");
		}
		return btnNewButton_14_7;
	}
	private JButton getBtnNewButton_14_8() {
		if (btnNewButton_14_8 == null) {
			btnNewButton_14_8 = new JButton("New button");
		}
		return btnNewButton_14_8;
	}
	private JButton getBtnNewButton_14_9() {
		if (btnNewButton_14_9 == null) {
			btnNewButton_14_9 = new JButton("New button");
		}
		return btnNewButton_14_9;
	}
	private JButton getBtnNewButton_14_10() {
		if (btnNewButton_14_10 == null) {
			btnNewButton_14_10 = new JButton("New button");
		}
		return btnNewButton_14_10;
	}
	private JButton getBtnNewButton_14_11() {
		if (btnNewButton_14_11 == null) {
			btnNewButton_14_11 = new JButton("New button");
		}
		return btnNewButton_14_11;
	}
	private JButton getBtnNewButton_14_12() {
		if (btnNewButton_14_12 == null) {
			btnNewButton_14_12 = new JButton("New button");
		}
		return btnNewButton_14_12;
	}
	private JButton getBtnNewButton_14_13() {
		if (btnNewButton_14_13 == null) {
			btnNewButton_14_13 = new JButton("New button");
		}
		return btnNewButton_14_13;
	}
	private JButton getBtnNewButton_14_14() {
		if (btnNewButton_14_14 == null) {
			btnNewButton_14_14 = new JButton("New button");
		}
		return btnNewButton_14_14;
	}
	private JButton getBtnNewButton_14_15() {
		if (btnNewButton_14_15 == null) {
			btnNewButton_14_15 = new JButton("New button");
		}
		return btnNewButton_14_15;
	}
	private JButton getBtnNewButton_14_16() {
		if (btnNewButton_14_16 == null) {
			btnNewButton_14_16 = new JButton("New button");
		}
		return btnNewButton_14_16;
	}
	private JButton getBtnNewButton_14_17() {
		if (btnNewButton_14_17 == null) {
			btnNewButton_14_17 = new JButton("New button");
		}
		return btnNewButton_14_17;
	}
	private JButton getBtnNewButton_14_18() {
		if (btnNewButton_14_18 == null) {
			btnNewButton_14_18 = new JButton("New button");
		}
		return btnNewButton_14_18;
	}
	private JButton getBtnNewButton_14_19() {
		if (btnNewButton_14_19 == null) {
			btnNewButton_14_19 = new JButton("New button");
		}
		return btnNewButton_14_19;
	}
	private JButton getBtnNewButton_14_20() {
		if (btnNewButton_14_20 == null) {
			btnNewButton_14_20 = new JButton("New button");
		}
		return btnNewButton_14_20;
	}
	private JButton getBtnNewButton_14_21() {
		if (btnNewButton_14_21 == null) {
			btnNewButton_14_21 = new JButton("New button");
		}
		return btnNewButton_14_21;
	}
	private JButton getBtnNewButton_14_22() {
		if (btnNewButton_14_22 == null) {
			btnNewButton_14_22 = new JButton("New button");
		}
		return btnNewButton_14_22;
	}
	private JButton getBtnNewButton_14_23() {
		if (btnNewButton_14_23 == null) {
			btnNewButton_14_23 = new JButton("New button");
		}
		return btnNewButton_14_23;
	}
	private JButton getBtnNewButton_14_24() {
		if (btnNewButton_14_24 == null) {
			btnNewButton_14_24 = new JButton("New button");
		}
		return btnNewButton_14_24;
	}
	private JButton getBtnNewButton_14_25() {
		if (btnNewButton_14_25 == null) {
			btnNewButton_14_25 = new JButton("New button");
		}
		return btnNewButton_14_25;
	}
	private JButton getBtnNewButton_14_26() {
		if (btnNewButton_14_26 == null) {
			btnNewButton_14_26 = new JButton("New button");
		}
		return btnNewButton_14_26;
	}
	private JButton getBtnNewButton_14_27() {
		if (btnNewButton_14_27 == null) {
			btnNewButton_14_27 = new JButton("New button");
		}
		return btnNewButton_14_27;
	}
	private JButton getBtnNewButton_14_28() {
		if (btnNewButton_14_28 == null) {
			btnNewButton_14_28 = new JButton("New button");
		}
		return btnNewButton_14_28;
	}
	private JButton getBtnNewButton_14_29() {
		if (btnNewButton_14_29 == null) {
			btnNewButton_14_29 = new JButton("New button");
		}
		return btnNewButton_14_29;
	}
	private JButton getBtnNewButton_14_30() {
		if (btnNewButton_14_30 == null) {
			btnNewButton_14_30 = new JButton("New button");
		}
		return btnNewButton_14_30;
	}
	private JButton getBtnNewButton_14_31() {
		if (btnNewButton_14_31 == null) {
			btnNewButton_14_31 = new JButton("New button");
		}
		return btnNewButton_14_31;
	}
	private JButton getBtnNewButton_14_32() {
		if (btnNewButton_14_32 == null) {
			btnNewButton_14_32 = new JButton("New button");
		}
		return btnNewButton_14_32;
	}
	private JButton getBtnNewButton_14_33() {
		if (btnNewButton_14_33 == null) {
			btnNewButton_14_33 = new JButton("New button");
		}
		return btnNewButton_14_33;
	}
	private JButton getBtnNewButton_14_34() {
		if (btnNewButton_14_34 == null) {
			btnNewButton_14_34 = new JButton("New button");
		}
		return btnNewButton_14_34;
	}
	private JButton getBtnNewButton_14_35() {
		if (btnNewButton_14_35 == null) {
			btnNewButton_14_35 = new JButton("New button");
		}
		return btnNewButton_14_35;
	}
	private JButton getBtnNewButton_14_36() {
		if (btnNewButton_14_36 == null) {
			btnNewButton_14_36 = new JButton("New button");
		}
		return btnNewButton_14_36;
	}
	private JButton getBtnNewButton_14_37() {
		if (btnNewButton_14_37 == null) {
			btnNewButton_14_37 = new JButton("New button");
		}
		return btnNewButton_14_37;
	}
	private JButton getBtnNewButton_14_38() {
		if (btnNewButton_14_38 == null) {
			btnNewButton_14_38 = new JButton("New button");
		}
		return btnNewButton_14_38;
	}
	private JButton getBtnNewButton_14_39() {
		if (btnNewButton_14_39 == null) {
			btnNewButton_14_39 = new JButton("New button");
		}
		return btnNewButton_14_39;
	}
	private JButton getBtnNewButton_14_40() {
		if (btnNewButton_14_40 == null) {
			btnNewButton_14_40 = new JButton("New button");
		}
		return btnNewButton_14_40;
	}
	private JButton getBtnNewButton_14_41() {
		if (btnNewButton_14_41 == null) {
			btnNewButton_14_41 = new JButton("New button");
		}
		return btnNewButton_14_41;
	}
	private JButton getBtnNewButton_14_42() {
		if (btnNewButton_14_42 == null) {
			btnNewButton_14_42 = new JButton("New button");
		}
		return btnNewButton_14_42;
	}
	private JButton getBtnNewButton_14_43() {
		if (btnNewButton_14_43 == null) {
			btnNewButton_14_43 = new JButton("New button");
		}
		return btnNewButton_14_43;
	}
}
