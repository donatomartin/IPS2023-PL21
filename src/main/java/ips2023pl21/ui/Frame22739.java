package ips2023pl21.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ips2023pl21.model.equipos.EquipoDeportivo;
import ips2023pl21.model.equipos.Partido;
import ips2023pl21.service.Service22739;

import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.List;
import java.util.Calendar;
import javax.swing.JCheckBox;
import javax.swing.SpinnerNumberModel;

public class Frame22739 extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private Service22739 service = new Service22739();
	
	private JPanel contentPane;
	private JPanel pnCrearComprar;
	private JPanel pnCrearPartido;
	private JPanel pnSeleccionarPartido;
	private JButton btCrearPartido;
	private JButton btComprarPartido;
	private JPanel pnCrearLabel;
	private JLabel lbCrearPartido;
	private JPanel pnCrearBt;
	private JButton btCrear;
	private JPanel pnCrearContenido;
	private JPanel pnLocal;
	private JPanel pnVisitante;
	private JPanel pnFecha;
	private JPanel pnSuplemento;
	private JLabel lbLocal;
	private JComboBox<String> cbLocal;
	private JLabel lbVisiante;
	private JTextField tfVisitante;
	private JLabel lbFecha;
	private JSpinner spFecha;
	private JCheckBox chckSuplemento;
	private JSpinner spSuplemento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame22739 frame = new Frame22739();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Frame22739() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 847, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		contentPane.add(getPnCrearComprar(), "crearComprar");
		contentPane.add(getPnCrearPartido(), "crear");
		contentPane.add(getPnSeleccionarPartido(), "seleccionar");
	}
	
	private void irAPn(String panel) {
		((CardLayout)contentPane.getLayout()).show(contentPane, panel);
	}

	private JPanel getPnCrearComprar() {
		if (pnCrearComprar == null) {
			pnCrearComprar = new JPanel();
			pnCrearComprar.setLayout(new GridLayout(1, 0, 0, 0));
			pnCrearComprar.add(getBtCrearPartido());
			pnCrearComprar.add(getBtComprarPartido());
		}
		return pnCrearComprar;
	}
	private JPanel getPnCrearPartido() {
		if (pnCrearPartido == null) {
			pnCrearPartido = new JPanel();
			pnCrearPartido.setLayout(new BorderLayout(0, 0));
			pnCrearPartido.add(getPnCrearLabel(), BorderLayout.NORTH);
			pnCrearPartido.add(getPnCrearBt(), BorderLayout.SOUTH);
			pnCrearPartido.add(getPnCrearContenido(), BorderLayout.CENTER);
		}
		return pnCrearPartido;
	}
	private JPanel getPnSeleccionarPartido() {
		if (pnSeleccionarPartido == null) {
			pnSeleccionarPartido = new JPanel();
		}
		return pnSeleccionarPartido;
	}
	private JButton getBtCrearPartido() {
		if (btCrearPartido == null) {
			btCrearPartido = new JButton("Crear Partido");
			btCrearPartido.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					irAPn("crear");
					cargarComboBoxEquipos();
				}
			});
		}
		return btCrearPartido;
	}
	private JButton getBtComprarPartido() {
		if (btComprarPartido == null) {
			btComprarPartido = new JButton("Comprar Entrada a Partido");
			btComprarPartido.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					irAPn("comprar");
					
				}
			});
		}
		return btComprarPartido;
	}
	
	private void cargarComboBoxEquipos() {
		List<EquipoDeportivo> es = service.getEquipos();
		
		for(EquipoDeportivo e : es) {
			getCbLocal().addItem(e.getNombre());
		}
		
		
	}
	
	private JPanel getPnCrearLabel() {
		if (pnCrearLabel == null) {
			pnCrearLabel = new JPanel();
			pnCrearLabel.add(getLbCrearPartido());
		}
		return pnCrearLabel;
	}
	private JLabel getLbCrearPartido() {
		if (lbCrearPartido == null) {
			lbCrearPartido = new JLabel("Crear Partido");
		}
		return lbCrearPartido;
	}
	private JPanel getPnCrearBt() {
		if (pnCrearBt == null) {
			pnCrearBt = new JPanel();
			pnCrearBt.add(getBtCrear());
		}
		return pnCrearBt;
	}
	private JButton getBtCrear() {
		if (btCrear == null) {
			btCrear = new JButton("Crear");
			btCrear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkCrear();
				}
			});
		}
		return btCrear;
	}
	
	private void checkCrear() {
		
		
		if(getTfVisitante().getText().isBlank()) {
			JOptionPane.showMessageDialog(null,"Faltan datos");
		} else {
			
			try {
				
				Partido partido = new Partido();
				
				EquipoDeportivo local = service.getEquipoPorNombre(getCbLocal().getSelectedItem().toString());
				
				partido.setLocal(local);
//				partido.setFecha();
				partido.setVisitante(getTfVisitante().getText());
				
				JOptionPane.showMessageDialog(null,"Partido creado");
				irAPn("crearComprar");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,"No se pudo crear el partido");
			}
			
		}
		
	}
	
	private JPanel getPnCrearContenido() {
		if (pnCrearContenido == null) {
			pnCrearContenido = new JPanel();
			pnCrearContenido.setLayout(null);
			pnCrearContenido.add(getPnLocal());
			pnCrearContenido.add(getPnVisitante());
			pnCrearContenido.add(getPnFecha());
			pnCrearContenido.add(getPnSuplemento());
		}
		return pnCrearContenido;
	}
	private JPanel getPnLocal() {
		if (pnLocal == null) {
			pnLocal = new JPanel();
			pnLocal.setBounds(50, 44, 259, 158);
			pnLocal.add(getLbLocal());
			pnLocal.add(getCbLocal());
		}
		return pnLocal;
	}
	private JPanel getPnVisitante() {
		if (pnVisitante == null) {
			pnVisitante = new JPanel();
			pnVisitante.setBounds(370, 44, 365, 165);
			pnVisitante.add(getLbVisiante());
			pnVisitante.add(getTfVisitante());
		}
		return pnVisitante;
	}
	private JPanel getPnFecha() {
		if (pnFecha == null) {
			pnFecha = new JPanel();
			pnFecha.setBounds(50, 243, 259, 137);
			pnFecha.add(getLbFecha());
			pnFecha.add(getSpFecha());
		}
		return pnFecha;
	}
	private JPanel getPnSuplemento() {
		if (pnSuplemento == null) {
			pnSuplemento = new JPanel();
			pnSuplemento.setBounds(370, 248, 365, 128);
			pnSuplemento.add(getChckSuplemento());
			pnSuplemento.add(getSpSuplemento());
		}
		return pnSuplemento;
	}
	private JLabel getLbLocal() {
		if (lbLocal == null) {
			lbLocal = new JLabel("Local");
		}
		return lbLocal;
	}
	private JComboBox<String> getCbLocal() {
		if (cbLocal == null) {
			cbLocal = new JComboBox<String>();
		}
		return cbLocal;
	}
	
	
	
	private JLabel getLbVisiante() {
		if (lbVisiante == null) {
			lbVisiante = new JLabel("Visitante");
		}
		return lbVisiante;
	}
	private JTextField getTfVisitante() {
		if (tfVisitante == null) {
			tfVisitante = new JTextField();
			tfVisitante.setColumns(10);
		}
		return tfVisitante;
	}
	private JLabel getLbFecha() {
		if (lbFecha == null) {
			lbFecha = new JLabel("Fecha");
		}
		return lbFecha;
	}
	private JSpinner getSpFecha() {
		if (spFecha == null) {
			spFecha = new JSpinner();
			spFecha.setModel(new SpinnerDateModel(new Date(1699052400000L), null, null, Calendar.DAY_OF_YEAR));
		}
		return spFecha;
	}
	private JCheckBox getChckSuplemento() {
		if (chckSuplemento == null) {
			chckSuplemento = new JCheckBox("Suplemento");
			chckSuplemento.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					activarSuplemento();
				}
			});
		}
		return chckSuplemento;
	}
	
	private void activarSuplemento() {
		getSpSuplemento().setEnabled(!getSpSuplemento().isEnabled());
		
		if(!getSpSuplemento().isEnabled()) {
			getSpSuplemento().setValue(0);
		}
		
	}
	
	private JSpinner getSpSuplemento() {
		if (spSuplemento == null) {
			spSuplemento = new JSpinner();
			spSuplemento.setEnabled(false);
			spSuplemento.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		}
		return spSuplemento;
	}
}
