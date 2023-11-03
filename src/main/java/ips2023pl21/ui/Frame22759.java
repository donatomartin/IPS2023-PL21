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
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import ips2023pl21.service.Service22759;

import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Color;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

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
	private JTextArea textAreaCuerpo;
	private JButton btAñadirImagen;
	private JFileChooser selector;
	private JScrollPane scrollPaneCuerpo;
	private JPanel pnCentro;
	private JPanel pnBotones;
	private JButton btFinalizar;
	private JPanel pnTitulo;
	private JPanel pnVisualizar;
	private JPanel pnTituloVisualizar;
	private JLabel lbTituloAñadir_1;
	private JLabel lbTituloNoticiaActual;
	private JPanel pnEscogerNoticia;
	private JLabel lbTituloEsogerNoticia;
	private JPanel pnNoticias;
	private static final int NUMERO_NOTICIAS=5;
	
	
	public Frame22759(Service22759 service ) {
		this.service=service;
		getContentPane().setLayout(new CardLayout(0, 0));
		getContentPane().add(getPnIntro(), "intro");
		getContentPane().add(getPanel_1(), "añadir");
		getContentPane().add(getPanel_1_3(), "name_581097196720000");
		getContentPane().add(getPanel_1_4(), "escogerNoticia");
		setLocationRelativeTo(null);
		setMinimumSize(new Dimension(700,500));
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
			btAñadirNoticia.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showPn("añadir");
				}
			});
			btAñadirNoticia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return btAñadirNoticia;
	}
		

		private void showPn(String panel) {
			((CardLayout)getContentPane().getLayout()).show(getContentPane(),panel);
			
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
			pnAñadirNoticia.setMinimumSize(new Dimension(400,400));
			pnAñadirNoticia.setLayout(new BorderLayout(0, 0));
			pnAñadirNoticia.add(getPanel_1_1());
			pnAñadirNoticia.add(getPnBotones(), BorderLayout.SOUTH);
			pnAñadirNoticia.add(getPanel_1_2(), BorderLayout.NORTH);
		}
		return pnAñadirNoticia;
	}
	private JLabel getLbTituloAñadir() {
		if (lbTituloAñadir == null) {
			lbTituloAñadir = new JLabel("Noticias");
			lbTituloAñadir.setFont(new Font("Verdana Pro Cond Black", Font.PLAIN, 33));
		}
		return lbTituloAñadir;
	}
	private JLabel getLbTituloNoticia() {
		if (lbTituloNoticia == null) {
			lbTituloNoticia = new JLabel("Introduzca título:");
			lbTituloNoticia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lbTituloNoticia;
	}
	private JTextField getTxTituloNoticia() {
		if (txTituloNoticia == null) {
			txTituloNoticia = new JTextField();
			txTituloNoticia.setColumns(10);
		}
		return txTituloNoticia;
	}
	private JLabel getLbSubtituloNoticia() {
		if (lbSubtituloNoticia == null) {
			lbSubtituloNoticia = new JLabel("Introduzca subtítulo:");
			lbSubtituloNoticia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lbSubtituloNoticia;
	}
	private JTextField getTxSubtitulo() {
		if (txSubtitulo == null) {
			txSubtitulo = new JTextField();
			txSubtitulo.setColumns(10);
		}
		return txSubtitulo;
	}
	private JLabel getLbCuerpo() {
		if (lbCuerpo == null) {
			lbCuerpo = new JLabel("Introduzca cuerpo:");
			lbCuerpo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lbCuerpo;
	}
	private JTextArea getTextAreaCuerpo() {
		if (textAreaCuerpo == null) {
			textAreaCuerpo = new JTextArea();
		}
		return textAreaCuerpo;
	}
	private JButton getBtAñadirImagen() {
		if (btAñadirImagen == null) {
			btAñadirImagen = new JButton("Añadir imagen");
			btAñadirImagen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					abrirImagenes();
				}

			});
		}
		return btAñadirImagen;
	}
	
	private void abrirImagenes() {
		int resp=getSelector().showOpenDialog(null);
		if(resp==JFileChooser.APPROVE_OPTION) {
			File img=getSelector().getSelectedFile();
			String dest="/ips2023pl21/imagenes";
			Path destino=Paths.get(dest);
			String org=img.getPath();
			Path origen=Paths.get(org);
			try {
				Files.copy(origen, destino);
			} catch (IOException e) {
				e.printStackTrace();
			}
			String titulo=getTxTituloNoticia().getText();
			String subtitulo=getTxSubtitulo().getText();
			String cuerpo=getTextAreaCuerpo().getText();
			service.insertarNoticia(titulo, subtitulo, cuerpo, dest);
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
	private JScrollPane getScrollPaneCuerpo() {
		if (scrollPaneCuerpo == null) {
			scrollPaneCuerpo = new JScrollPane();
			scrollPaneCuerpo.setViewportView(getTextAreaCuerpo());
		}
		return scrollPaneCuerpo;
	}
	private JPanel getPanel_1_1() {
		if (pnCentro == null) {
			pnCentro = new JPanel();
			GroupLayout gl_pnCentro = new GroupLayout(pnCentro);
			gl_pnCentro.setHorizontalGroup(
				gl_pnCentro.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnCentro.createSequentialGroup()
						.addGap(33)
						.addGroup(gl_pnCentro.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_pnCentro.createSequentialGroup()
								.addGroup(gl_pnCentro.createParallelGroup(Alignment.LEADING)
									.addComponent(getLbSubtituloNoticia(), GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
									.addComponent(getLbCuerpo(), GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
								.addGap(53))
							.addGroup(gl_pnCentro.createSequentialGroup()
								.addComponent(getLbTituloNoticia(), GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)))
						.addGroup(gl_pnCentro.createParallelGroup(Alignment.LEADING)
							.addComponent(getTxSubtitulo(), GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
							.addComponent(getScrollPaneCuerpo(), GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
							.addComponent(getTxTituloNoticia(), GroupLayout.PREFERRED_SIZE, 508, GroupLayout.PREFERRED_SIZE))
						.addContainerGap())
			);
			gl_pnCentro.setVerticalGroup(
				gl_pnCentro.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnCentro.createSequentialGroup()
						.addGap(34)
						.addGroup(gl_pnCentro.createParallelGroup(Alignment.BASELINE)
							.addComponent(getTxTituloNoticia(), GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
							.addComponent(getLbTituloNoticia(), GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
						.addGap(4)
						.addGroup(gl_pnCentro.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_pnCentro.createSequentialGroup()
								.addGap(101)
								.addComponent(getLbCuerpo())
								.addGap(106))
							.addGroup(Alignment.TRAILING, gl_pnCentro.createSequentialGroup()
								.addGroup(gl_pnCentro.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_pnCentro.createSequentialGroup()
										.addComponent(getLbSubtituloNoticia(), GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
										.addGap(30))
									.addGroup(gl_pnCentro.createSequentialGroup()
										.addComponent(getTxSubtitulo(), GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
										.addGap(18)))
								.addGap(13)
								.addComponent(getScrollPaneCuerpo(), GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
								.addGap(152))))
			);
			pnCentro.setLayout(gl_pnCentro);
		}
		return pnCentro;
	}
	private JPanel getPnBotones() {
		if (pnBotones == null) {
			pnBotones = new JPanel();
			pnBotones.add(getBtAñadirImagen());
			pnBotones.add(getBtFinalizar());
		}
		return pnBotones;
	}
	private JButton getBtFinalizar() {
		if (btFinalizar == null) {
			btFinalizar = new JButton("Finalizar");
			btFinalizar.setBackground(Color.GREEN);
		}
		return btFinalizar;
	}
	private JPanel getPanel_1_2() {
		if (pnTitulo == null) {
			pnTitulo = new JPanel();
			pnTitulo.add(getLbTituloAñadir());
		}
		return pnTitulo;
	}
	private JPanel getPanel_1_3() {
		if (pnVisualizar == null) {
			pnVisualizar = new JPanel();
			pnVisualizar.setLayout(null);
			pnVisualizar.add(getPnTituloVisualizar());
			pnVisualizar.add(getLbTituloNoticiaActual());
		}
		return pnVisualizar;
	}
	private JPanel getPnTituloVisualizar() {
		if (pnTituloVisualizar == null) {
			pnTituloVisualizar = new JPanel();
			pnTituloVisualizar.setBounds(321, 5, 132, 51);
			pnTituloVisualizar.add(getLbTituloAñadir_1());
		}
		return pnTituloVisualizar;
	}
	private JLabel getLbTituloAñadir_1() {
		if (lbTituloAñadir_1 == null) {
			lbTituloAñadir_1 = new JLabel("Noticias");
			lbTituloAñadir_1.setFont(new Font("Verdana Pro Cond Black", Font.PLAIN, 33));
		}
		return lbTituloAñadir_1;
	}
	private JLabel getLbTituloNoticiaActual() {
		if (lbTituloNoticiaActual == null) {
			lbTituloNoticiaActual = new JLabel("New label");
			lbTituloNoticiaActual.setBounds(37, 90, 223, 28);
		}
		return lbTituloNoticiaActual;
	}
	private JPanel getPanel_1_4() {
		if (pnEscogerNoticia == null) {
			pnEscogerNoticia = new JPanel();
			pnEscogerNoticia.setLayout(null);
			pnEscogerNoticia.add(getLbTituloEsogerNoticia());
			pnEscogerNoticia.add(getPanel_1_5());
		}
		return pnEscogerNoticia;
	}
	private JLabel getLbTituloEsogerNoticia() {
		if (lbTituloEsogerNoticia == null) {
			lbTituloEsogerNoticia = new JLabel("Noticias");
			lbTituloEsogerNoticia.setBounds(326, 5, 122, 41);
			lbTituloEsogerNoticia.setFont(new Font("Verdana Pro Cond Black", Font.PLAIN, 33));
		}
		return lbTituloEsogerNoticia;
	}
	private JPanel getPanel_1_5() {
		if (pnNoticias == null) {
			pnNoticias = new JPanel();
			pnNoticias.setBounds(41, 96, 673, 284);
			pnNoticias.setLayout(new GridLayout(5, 0, 0, 0));
			for(int i=0; i<NUMERO_NOTICIAS;i++) {
				JButton boton=new JButton("btnNoticia"+i);
				boton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						showPn("escogerNoticia");
					}
				});
		}
		
}
		return pnNoticias;
	}
	}
