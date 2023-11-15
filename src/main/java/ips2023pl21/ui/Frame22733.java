package ips2023pl21.ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.FlowLayout;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import ips2023pl21.model.entradas.EntradaEntity;
import ips2023pl21.service.Service22733;

import ips2023pl21.util.Util;


import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;


public class Frame22733 extends JFrame{
	private static final long serialVersionUID = 1L;
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
	private JPanel panelAsientosOcupados;
	private JPanel panelAsiento;
	private JLabel lblAsiento;
	private JSpinner spinnerAsiento;
	private Service22733 service;
	private ButtonGroup grupoTribuna=new ButtonGroup();
	private ButtonGroup grupoSeccion=new ButtonGroup();
	public static final int NUMFILAS=10;
	public static final int NUMCOLUMNAS=15;
	private JPanel pnIntroduccion;
	private JPanel pnDatos;
	private JLabel lbAsientosOcupados;
	private JPanel pnNombreCliente;
	private JTextField txtFieldNombre;
	private JSpinner spFecha;
	
	public Frame22733(Service22733 service) {
		this.service=service;
		this.frame=new JFrame();
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(getPanelEscoger(), BorderLayout.CENTER);
		getContentPane().add(getPanelTitulo(), BorderLayout.NORTH);
		getContentPane().add(getPanelBotonesSur(), BorderLayout.SOUTH);
		setMinimumSize(new Dimension(1540,540));
		setLocationRelativeTo(null);
		pintaAsientos();
	}
	private void pintaAsientos() {
		for(int i=0;i<NUMFILAS;i++) {
			for(int j=0;j<NUMCOLUMNAS;j++) {
				JButton boton=new JButton();
				boton.setName(""+i+j);
				boton.setBackground(Color.green);
				boton.setForeground(Color.green);
				boton.setEnabled(false);
				panelAsientosOcupados.add(boton);
			}
			
		}
		getAsientosOcupados();
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
	public JButton getBtnComprar() {
		if (btnComprar == null) {
			btnComprar = new JButton("Comprar");
			btnComprar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(comprobarNombre()) {
//						comprobarFecha();
						comprar();
						getAsientosOcupados();
						txtFieldNombre.setText("");
					}
					
					
				}

				
			});
			btnComprar.setBackground(Color.GREEN);
			btnComprar.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnComprar.setMnemonic('m');
		}
		return btnComprar;
	}
	
	private boolean comprobarNombre() {
		if(txtFieldNombre.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Complete su nombre");
		}else {
				return true;
			}
		return false;
	}
	
//	private void comprobarFecha() {
//		String fecha=txtFieldFechaNacimiento.getText();
//		Date date=Util.isoStringToDate(fecha);
//		txtFieldFechaNacimiento.setText(Util.dateToIsoString(date));
//		
//		
//	}
	
	public JButton getBtCancelar() {
		if (btCancelar == null) {
			btCancelar = new JButton("Cancelar");
			btCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cancelar();
				}
			});
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
						.addGap(20)
						.addComponent(getPnIntroduccion(), GroupLayout.PREFERRED_SIZE, 1496, Short.MAX_VALUE)
						.addGap(10))
					.addGroup(gl_panelEscoger.createSequentialGroup()
						.addGap(42)
						.addComponent(getPnDatos(), GroupLayout.PREFERRED_SIZE, 838, Short.MAX_VALUE)
						.addGap(41)
						.addComponent(getPanelAsientosOcupados(), GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
						.addGap(23))
			);
			gl_panelEscoger.setVerticalGroup(
				gl_panelEscoger.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panelEscoger.createSequentialGroup()
						.addGap(21)
						.addComponent(getPnIntroduccion(), GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelEscoger.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panelEscoger.createSequentialGroup()
								.addGap(48)
								.addComponent(getPnDatos(), GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))
							.addGroup(gl_panelEscoger.createSequentialGroup()
								.addGap(17)
								.addComponent(getPanelAsientosOcupados(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGap(93))
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
			grupoTribuna.add(rdbtnTribunaA);
			rdbtnTribunaA.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getAsientosOcupados();
				}
			});

		}
		return rdbtnTribunaA;
	}
	private JRadioButton getRdbtnTribunaB() {
		if (rdbtnTribunaB == null) {
			rdbtnTribunaB = new JRadioButton("B");
			rdbtnTribunaB.setMnemonic('B');
			rdbtnTribunaB.setBackground(Color.WHITE);
			rdbtnTribunaB.setActionCommand("B");
			grupoTribuna.add(rdbtnTribunaB);
			rdbtnTribunaB.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getAsientosOcupados();
				}
			});
		}
		return rdbtnTribunaB;
	}
	private JRadioButton getRdbtnTribunaC() {
		if (rdbtnTribunaC == null) {
			rdbtnTribunaC = new JRadioButton("C");
			rdbtnTribunaC.setMnemonic('C');
			rdbtnTribunaC.setBackground(Color.WHITE);
			rdbtnTribunaC.setActionCommand("C");
			grupoTribuna.add(rdbtnTribunaC);
			rdbtnTribunaC.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getAsientosOcupados();
				}
			});
		}
		return rdbtnTribunaC;
	}
	private JRadioButton getRdbtnTribunaD() {
		if (rdbtnTribunaD == null) {
			rdbtnTribunaD = new JRadioButton("D");
			rdbtnTribunaD.setMnemonic('D');
			rdbtnTribunaD.setBackground(Color.WHITE);
			rdbtnTribunaD.setActionCommand("D");
			grupoTribuna.add(rdbtnTribunaD);
			rdbtnTribunaD.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getAsientosOcupados();
				}
			});
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
			grupoSeccion.add(rdbtnSeccionA);
			rdbtnSeccionA.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getAsientosOcupados();
				}
			});
		}
		return rdbtnSeccionA;
	}
	private JRadioButton getRdbtnSeccionB() {
		if (rdbtnSeccionB == null) {
			rdbtnSeccionB = new JRadioButton("B");
			rdbtnSeccionB.setMnemonic('B');
			rdbtnSeccionB.setBackground(Color.WHITE);
			rdbtnSeccionB.setActionCommand("B");
			grupoSeccion.add(rdbtnSeccionB);
			rdbtnSeccionB.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getAsientosOcupados();
				}
			});
		}
		return rdbtnSeccionB;
	}
	private JRadioButton getRdbtnSeccionC() {
		if (rdbtnSeccionC == null) {
			rdbtnSeccionC = new JRadioButton("C");
			rdbtnSeccionC.setMnemonic('C');
			rdbtnSeccionC.setBackground(Color.WHITE);
			rdbtnSeccionC.setActionCommand("C");
			grupoSeccion.add(rdbtnSeccionC);
			rdbtnSeccionC.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getAsientosOcupados();
				}
			});
		}
		return rdbtnSeccionC;
	}
	private JRadioButton getRdbtnSeccionD() {
		if (rdbtnSeccionD == null) {
			rdbtnSeccionD = new JRadioButton("D");
			rdbtnSeccionD.setMnemonic('D');
			rdbtnSeccionD.setBackground(Color.WHITE);
			rdbtnSeccionD.setActionCommand("D");
			grupoSeccion.add(rdbtnSeccionD);
			rdbtnSeccionD.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getAsientosOcupados();
				}
			});
		}
		return rdbtnSeccionD;
	}
	private JRadioButton getRdbtnSeccionE() {
		if (rdbtnSeccionE == null) {
			rdbtnSeccionE = new JRadioButton("E");
			rdbtnSeccionE.setMnemonic('E');
			rdbtnSeccionE.setBackground(Color.WHITE);
			rdbtnSeccionE.setActionCommand("E");
			grupoSeccion.add(rdbtnSeccionE);
			rdbtnSeccionE.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getAsientosOcupados();
				}
			});
		}
		return rdbtnSeccionE;
	}
	private JRadioButton getRdbtnSeccionF() {
		if (rdbtnSeccionF == null) {
			rdbtnSeccionF = new JRadioButton("F");
			rdbtnSeccionF.setMnemonic('F');
			rdbtnSeccionF.setBackground(Color.WHITE);
			rdbtnSeccionF.setActionCommand("F");
			grupoSeccion.add(rdbtnSeccionF);
			rdbtnSeccionF.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getAsientosOcupados();
				}
			});
		}
		return rdbtnSeccionF;
	}
	
	
	private void getAsientosOcupados() {
		List<EntradaEntity> asientosOcupados=service.getAsientosOcupados(grupoTribuna.getSelection().getActionCommand(),
				grupoSeccion.getSelection().getActionCommand());
		inicializarAsientos();
		int iteracion=0;
		for(int i=0;i<NUMFILAS;i++) {
			for(int j=0;j<NUMCOLUMNAS;j++) {
				for(EntradaEntity asiento : asientosOcupados) {
					int fila=asiento.getFila();
					int numAsiento=asiento.getAsiento();
//					String id=""+fila+numAsiento;
					if(fila==i && numAsiento==j) {
						panelAsientosOcupados.getComponent(iteracion).setBackground(Color.red);
					}
					
				}
				iteracion++;
			}
		}
		
	}
	
	
	private void inicializarAsientos() {
		for(int i=0;i<panelAsientosOcupados.getComponentCount();i++) {
			getPanelAsientosOcupados().getComponent(i).setBackground(Color.green);
		}
		
	}
	private JLabel getLbFila() {
		if (lbFila == null) {
			lbFila = new JLabel("Elija fila:");
			lbFila.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return lbFila;
	}
	@SuppressWarnings("removal")
	private JSpinner getSpinnerFila() {
		if (spinnerFila == null) {
			spinnerFila = new JSpinner();
			spinnerFila.setFont(new Font("Tahoma", Font.PLAIN, 14));
			spinnerFila.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), new Integer(9), new Integer(1)));
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
			panelFechaNacimiento.add(getPnNombreCliente());
			panelFechaNacimiento.add(getLbFechaNacimiento());
			panelFechaNacimiento.add(getSpFecha());
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
	private JPanel getPanelAsientosOcupados() {
		if (panelAsientosOcupados == null) {
			panelAsientosOcupados = new JPanel();
			panelAsientosOcupados.setLayout(new GridLayout(10, 15, 0, 0));
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
	@SuppressWarnings("removal")
	private JSpinner getSpinnerAsiento() {
		if (spinnerAsiento == null) {
			spinnerAsiento = new JSpinner();
			spinnerAsiento.setFont(new Font("Tahoma", Font.PLAIN, 14));
			spinnerAsiento.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), new Integer(14), new Integer(1)));
		}
		return spinnerAsiento;
	}
	
	public ButtonGroup getButtonGroupTribuna() {return grupoTribuna;}
	public ButtonGroup getButtonGroupoSeccion() {return grupoSeccion;}
	
	private void comprar() {
		if(service.comprar(getButtonGroupTribuna().getSelection().getActionCommand(),
				getButtonGroupoSeccion().getSelection().getActionCommand(),
				(int)spinnerFila.getValue(), (int)spinnerAsiento.getValue(),parseFecha(),
				txtFieldNombre.getText())) {
			JOptionPane.showMessageDialog(null, "Compra realizada, su id es "+ service.getIdAbonado());
		}else {
			JOptionPane.showMessageDialog(null, "Asiento ocupado");
		}
		
	}
	private String parseFecha() {
		Date fecha=(Date)getSpFecha().getValue();
		return Util.dateToIsoString(fecha);
		
	}
	private void cancelar() {
		dispose();
	}
	private JPanel getPnIntroduccion() {
		if (pnIntroduccion == null) {
			pnIntroduccion = new JPanel();
			pnIntroduccion.add(getLbDescripcion());
			pnIntroduccion.add(getLblNewLabel());
		}
		return pnIntroduccion;
	}
	private JPanel getPnDatos() {
		if (pnDatos == null) {
			pnDatos = new JPanel();
			pnDatos.setBackground(Color.WHITE);
			pnDatos.add(getPanelFechaNacimiento());
			pnDatos.add(getPanelTribuna());
			pnDatos.add(getPanelSeccion());
			pnDatos.add(getPanelFila());
			pnDatos.add(getPanelAsiento());
			pnDatos.add(getLbAsientosOcupados());
		}
		return pnDatos;
	}
	private JLabel getLbAsientosOcupados() {
		if (lbAsientosOcupados == null) {
			lbAsientosOcupados = new JLabel("El gráfico indica los asientos libres y ocupados para la tribuna y sección escogidos.");
			lbAsientosOcupados.setFont(new Font("Tahoma", Font.PLAIN, 15));
		}
		return lbAsientosOcupados;
	}
	private JPanel getPnNombreCliente() {
		if (pnNombreCliente == null) {
			pnNombreCliente = new JPanel();
			pnNombreCliente.setBackground(Color.WHITE);
			
			JLabel lbIntroduzcaNombre = new JLabel("Introduzca su nombre y apellidos:");
			lbIntroduzcaNombre.setBackground(Color.WHITE);
			lbIntroduzcaNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
			pnNombreCliente.add(lbIntroduzcaNombre);
			
			txtFieldNombre = new JTextField();
			txtFieldNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
			pnNombreCliente.add(txtFieldNombre);
			txtFieldNombre.setColumns(10);
		}
		return pnNombreCliente;
	}
	private JSpinner getSpFecha() {
		if (spFecha == null) {
			spFecha = new JSpinner();
			spFecha.setFont(new Font("Tahoma", Font.PLAIN, 15));
			spFecha.setModel(new SpinnerDateModel(new Date(1697061600000L), null, null, Calendar.DAY_OF_YEAR));

			// Obtén la fecha actual y añade 7 días
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DAY_OF_YEAR, 7);
			Date date = calendar.getTime();

			// Crea un modelo con la fecha y establece el formato para que no muestre las
			// horas
			SpinnerDateModel model = new SpinnerDateModel();
			model.setValue(date);
			spFecha.setModel(model);

			// Establece el formato de la fecha para que no muestre las horas
			JSpinner.DateEditor editor = new JSpinner.DateEditor(spFecha, "dd-MM-yyyy");
			spFecha.setEditor(editor);

		}
		return spFecha;
	}
	}


