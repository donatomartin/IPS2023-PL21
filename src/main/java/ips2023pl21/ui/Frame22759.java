package ips2023pl21.ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import ips2023pl21.service.Service22759;

import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class Frame22759 extends JFrame{
	private Service22759 service;
	private JLabel lbTitulo;
	private JPanel pnDecision;
	private JButton btAñadirNoticia;
	private JButton btVisualizarNoticia;
	private JPanel pnIntro;
	private JPanel pnAñadirNoticia;
	private JLabel lbTituloAñadir;
	private JLabel lbTituloNoticia;
	private JTextField txTituloNoticia;
	private JLabel lbSubtituloNoticia;
	private JTextField txSubtitulo;
	private JLabel lbCuerpo;
	private JTextArea textArea;
	private JButton btAñadirImagen;
	private JFileChooser selector;
	
	public Frame22759(Service22759 service ) {
		this.service=service;
		getContentPane().setLayout(new CardLayout(0, 0));
		getContentPane().add(getPnIntro(), "name_491152897869100");
		getContentPane().add(getPanel_1(), "name_491262234128700");
	}
	

	private JLabel getLbTitulo() {
		if (lbTitulo == null) {
			lbTitulo = new JLabel("Noticias");
			lbTitulo.setFont(new Font("Verdana Pro Cond Black", Font.PLAIN, 33));
		}
		return lbTitulo;
	}
	private JPanel getPnDecision() {
		if (pnDecision == null) {
			pnDecision = new JPanel();
			pnDecision.setLayout(new GridLayout(1, 0, 0, 0));
			pnDecision.add(getBtAñadirNoticia());
			pnDecision.add(getBtVisualizarNoticia());
		}
		return pnDecision;
	}
	private JButton getBtAñadirNoticia() {
		if (btAñadirNoticia == null) {
			btAñadirNoticia = new JButton("Añadir noticia");
			btAñadirNoticia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return btAñadirNoticia;
	}
	private JButton getBtVisualizarNoticia() {
		if (btVisualizarNoticia == null) {
			btVisualizarNoticia = new JButton("Visualizar noticia");
			btVisualizarNoticia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return btVisualizarNoticia;
	}
	private JPanel getPnIntro() {
		if (pnIntro == null) {
			pnIntro = new JPanel();
			pnIntro.setLayout(new BorderLayout(0, 0));
			pnIntro.add(getLbTitulo(), BorderLayout.NORTH);
			pnIntro.add(getPnDecision());
		}
		return pnIntro;
	}
	private JPanel getPanel_1() {
		if (pnAñadirNoticia == null) {
			pnAñadirNoticia = new JPanel();
			pnAñadirNoticia.setLayout(null);
			pnAñadirNoticia.add(getLbTituloAñadir());
			pnAñadirNoticia.add(getLbTituloNoticia());
			pnAñadirNoticia.add(getTxTituloNoticia());
			pnAñadirNoticia.add(getLbSubtituloNoticia());
			pnAñadirNoticia.add(getTxSubtitulo());
			pnAñadirNoticia.add(getLbCuerpo());
			pnAñadirNoticia.add(getTextArea());
			pnAñadirNoticia.add(getBtAñadirImagen());
		}
		return pnAñadirNoticia;
	}
	private JLabel getLbTituloAñadir() {
		if (lbTituloAñadir == null) {
			lbTituloAñadir = new JLabel("Noticias");
			lbTituloAñadir.setFont(new Font("Verdana Pro Cond Black", Font.PLAIN, 33));
			lbTituloAñadir.setBounds(0, 0, 806, 41);
		}
		return lbTituloAñadir;
	}
	private JLabel getLbTituloNoticia() {
		if (lbTituloNoticia == null) {
			lbTituloNoticia = new JLabel("Introduzca título:");
			lbTituloNoticia.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lbTituloNoticia.setBounds(39, 96, 117, 41);
		}
		return lbTituloNoticia;
	}
	private JTextField getTxTituloNoticia() {
		if (txTituloNoticia == null) {
			txTituloNoticia = new JTextField();
			txTituloNoticia.setBounds(171, 96, 344, 41);
			txTituloNoticia.setColumns(10);
		}
		return txTituloNoticia;
	}
	private JLabel getLbSubtituloNoticia() {
		if (lbSubtituloNoticia == null) {
			lbSubtituloNoticia = new JLabel("Introduzca subtítulo:");
			lbSubtituloNoticia.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lbSubtituloNoticia.setBounds(39, 174, 152, 41);
		}
		return lbSubtituloNoticia;
	}
	private JTextField getTxSubtitulo() {
		if (txSubtitulo == null) {
			txSubtitulo = new JTextField();
			txSubtitulo.setColumns(10);
			txSubtitulo.setBounds(201, 174, 344, 41);
		}
		return txSubtitulo;
	}
	private JLabel getLbCuerpo() {
		if (lbCuerpo == null) {
			lbCuerpo = new JLabel("Introduzca cuerpo:");
			lbCuerpo.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lbCuerpo.setBounds(39, 264, 152, 41);
		}
		return lbCuerpo;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setBounds(229, 251, 314, 98);
		}
		return textArea;
	}
	private JButton getBtAñadirImagen() {
		if (btAñadirImagen == null) {
			btAñadirImagen = new JButton("Añadir imagen");
			btAñadirImagen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					abrirImagenes();
				}

			});
			btAñadirImagen.setBounds(627, 96, 117, 28);
		}
		return btAñadirImagen;
	}
	
	private void abrirImagenes() {
		int resp=getSelector().showOpenDialog(null);
		if(resp==JFileChooser.APPROVE_OPTION) {
			service.insertarNoticia();
		}
	}
	
	private JFileChooser getSelector() {
		if(selector==null) {
			selector=new JFileChooser();
			//establecer filtro
			selector.setFileFilter(new FileNameExtensionFilter("imágenes", "jpg", "jpeg", "png"));
			//fijar una carpeta de despliegue
			String ruta=System.getProperty("user.home");
			selector.setCurrentDirectory(new File(ruta));
		}
		return selector;
	}
}
