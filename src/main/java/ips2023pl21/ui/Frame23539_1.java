package ips2023pl21.ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JPanel;

import ips2023pl21.model.compras.Compra;
import ips2023pl21.model.ventas.VentaDisplayDTO;
import ips2023pl21.service.Service23539;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frame23539_1 extends JFrame{
	private JLabel lbTitulo;
	private JLabel lbAño;
	private JComboBox comboBox;
	private JButton btVerGrafico;
	private JPanel pnCentro;
	private JPanel pnNorte;
	private Service23539 service;
	private JPanel panel;
	
	public Frame23539_1(Service23539 service) {
		this.service=service;
		setTitle("Balance compra-venta");
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(getPnCentro());
		getContentPane().add(getPnNorte(), BorderLayout.NORTH);
		setMinimumSize(new Dimension(400,200));
		;
		setLocationRelativeTo(null);
	}
	private JLabel getLbTitulo() {
		if (lbTitulo == null) {
			lbTitulo = new JLabel("Balance compra - venta");
			lbTitulo.setFont(new Font("Tahoma", Font.BOLD, 22));
		}
		return lbTitulo;
	}
	private JLabel getLbAño() {
		if (lbAño == null) {
			lbAño = new JLabel("Escoja un año:");
			lbAño.setFont(new Font("Tahoma", Font.PLAIN, 17));
		}
		return lbAño;
	}
	public JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			List<VentaDisplayDTO> ventas=service.getTotalVentas();
			List<Compra>compras=service.getTotalCompras();
			List<String> result=combinarListas(ventas, compras);
			for(String r:result) {
				comboBox.addItem(r);
			}
		}
		return comboBox;
	}
	
	private void mostrarGrafico() {
		Frame23539_2 frame=new Frame23539_2(this);
		frame.setVisible(true);
	}
	private JButton getBtVerGrafico() {
		if (btVerGrafico == null) {
			btVerGrafico = new JButton("Ver gráfico");
			btVerGrafico.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btVerGrafico.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarGrafico();
				}
			});
		}
		return btVerGrafico;
	}
	private JPanel getPnCentro() {
		if (pnCentro == null) {
			pnCentro = new JPanel();
			pnCentro.setLayout(new BorderLayout(0, 0));
			pnCentro.add(getBtVerGrafico(), BorderLayout.SOUTH);
			pnCentro.add(getPanel());
		}
		return pnCentro;
	}
	private JPanel getPnNorte() {
		if (pnNorte == null) {
			pnNorte = new JPanel();
			pnNorte.add(getLbTitulo());
		}
		return pnNorte;
	}
	
	private List<String> combinarListas(List<VentaDisplayDTO> ventas, List<Compra> compras) {
		List<String> result=new ArrayList<String>();
		for(VentaDisplayDTO v:ventas) {
			String año=v.getFecha().split("-")[0];
			if(!existsElemento(result,año)) {
				result.add(año);
			}
		}
		
		for(Compra c:compras) {
			String año=c.getFecha().split("-")[0];
			if(!existsElemento(result,año)) {
				result.add(año);
			}
		}
		return result;
	}
	
	private boolean existsElemento(List<String> result, String año) {
		for(String s:result) {
			if(s.equals(año)) {
				return true;
			}
		}
		return false;
	}
	public Service23539 getService() {
		return service;
	}
	
	
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.add(getLbAño());
			panel.add(getComboBox());
		}
		return panel;
	}
}
