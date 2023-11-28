package ips2023pl21.ui;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import ips2023pl21.service.Service23523;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

public class Frame23523 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	Service23523 service; 
	private JPanel pnBotonSortear;
	private JPanel pnVolver;
	private JButton btVolver;
	private JButton btSortear;

	/**
	 * Create the frame.
	 */
	public Frame23523() {
		service = new Service23523();
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 589, 485);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setMinimumSize(getSize());
		setContentPane(contentPane);
		
		
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPnBotonSortear(), BorderLayout.CENTER);
		contentPane.add(getPnVolver(), BorderLayout.SOUTH);
		setLocationRelativeTo(this);
		
		setVisible(true);
		
	}
	private JPanel getPnBotonSortear() {
		if (pnBotonSortear == null) {
			pnBotonSortear = new JPanel();
			pnBotonSortear.setLayout(new GridLayout(0, 1, 0, 0));
			pnBotonSortear.add(getBtSortear());
		}
		return pnBotonSortear;
	}
	private JPanel getPnVolver() {
		if (pnVolver == null) {
			pnVolver = new JPanel();
			pnVolver.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			pnVolver.add(getBtVolver());
		}
		return pnVolver;
	}
	private JButton getBtVolver() {
		if (btVolver == null) {
			btVolver = new JButton("Volver");
			btVolver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
		}
		return btVolver;
	}
	private JButton getBtSortear() {
		if (btSortear == null) {
			btSortear = new JButton("Realizar Sorteo");
			btSortear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					sortear();
				}
			});
		}
		return btSortear;
	}
	
	private void sortear() {
		List<String> abonados = service.selectIdsAbonado();
		
		Random r = new Random();
		int resultado = r.nextInt(abonados.size());
		
		service.updateAbonadoSorteo(abonados.get(resultado));
		
		JOptionPane.showMessageDialog(this, "El abonado " + abonados.get(resultado) + " es el ganador");
	}
}
