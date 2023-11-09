package ips2023pl21.ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Image;


import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.filechooser.FileNameExtensionFilter;

import ips2023pl21.model.noticias.Noticia;
import ips2023pl21.service.Service22759;

import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Stack;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import javax.swing.BoxLayout;


public class Frame22759 extends JFrame{
	private static final long serialVersionUID = 1L;
	private Service22759 service;
	private JLabel lbTitulo;
	private JPanel pnDecision;
	private JButton btAñadirNoticia;
	private JButton btVisualizarNoticia;
	private JPanel pnIntro;
	private JPanel pnAñadirNoticia;
	private JLabel lbTituloAñadir;
	private JLabel lbTituloNoticia;
	private JLabel lbSubtituloNoticia;
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
	private JPanel pnEscogerNoticia;
	private JLabel lbTituloEsogerNoticia;
	private JPanel pnNoticias;
	private static final int NUMERO_NOTICIAS=5;
	private JPanel pnBotonesEscoger;
	private JButton btAtrasEscoger;
	private JPanel pnTituloEscoger;
	private JPanel pnNoticiaActual;
	private JLabel lbImagenNoticiaActual;
	private JScrollPane scrollPaneCuerpoNoticiaActual;
	private JTextArea textAreaCuerpoNoticiaActual;
	private String dest; //ruta de la imagen a añadir
	private JButton btAtrasAñadir;
	private JPanel pnBotonesVisualizar;
	private JButton btAtrasVisualizar;
	private JPanel pnCentroVisualizar;
	private JButton btSiguiente;
	private int numPagina=0;
	private List<Noticia> noticiasStack=new Stack<Noticia>();
	private JScrollPane scrollPaneTitulo;
	private JScrollPane scrollPaneIAñadirTitulo;
	private JTextArea textAreaAñadirTitulo;
	private JPanel pnAñadirTitulo;
	private JScrollPane scrollPaneAñadirSubtitulo;
	private JTextArea textAreaAñadirSubtitulo;
	private JPanel pnAñadirSubtitulo;
	private JPanel pnAñadirCuerpo;
	private JTextArea textAreaTituloVisualizar;
	private JScrollPane scrollPaneTSuntituloNoticiaActual;
	private JTextArea textAreaSubtituloNoticiaActual;
	private JFrame frame;
	
	public Frame22759(Service22759 service ) {
		this.service=service;
		frame=new JFrame();
		setMinimumSize(new Dimension(700,700));
		frame.setLocationRelativeTo(null);
		this.setLocationRelativeTo(null);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		setContentPane(getContentPane());
		getContentPane().setLayout(new CardLayout(0, 0));
		getContentPane().add(getPnIntro(), "intro");
		getContentPane().add(getPanel_1(), "añadir");
		getContentPane().add(getPanel_1_3(), "visualizar");
		getContentPane().add(getPanel_1_4(), "escogerNoticia");
		
		
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
			btVisualizarNoticia.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showPn("escogerNoticia");
				}
			});
			btVisualizarNoticia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return btVisualizarNoticia;
	}
	
	private JPanel crearPanelEscoger() {
		if(pnEscogerNoticia==null) {
			pnEscogerNoticia = new JPanel();
			pnEscogerNoticia.setLayout(new BorderLayout(0, 0));
			pnEscogerNoticia.add(getPanel_1_5());
			pnEscogerNoticia.add(getPanel_1_6(), BorderLayout.SOUTH);
			pnEscogerNoticia.add(getPnTituloEscoger(), BorderLayout.NORTH);
		}
	return pnEscogerNoticia;
}
	
	private JPanel getPanel_1_5() {
			return crearPanelEscogerNoticias();
	}
	private JPanel crearPanelEscogerNoticias() {
			numPagina++;
			pnNoticias = new JPanel();
			pnNoticias.setLayout(new GridLayout(5, 0, 0, 0));
			for(int i=0; i<NUMERO_NOTICIAS ;i++) {
					JButton boton=new JButton("Noticia "+i);
					boton.setName("btnNoticia"+i);
					boton.setMnemonic(i);
					boton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							noticiasStack=service.getNoticias();
							comprobarNoticias(boton.getMnemonic(), noticiasStack.size());
							showPn("visualizar");
							
							}
							
						}
						);
						
						pnNoticias.add(boton);
					}
				
					return pnNoticias;
			}
	
	private void comprobarNoticias(int id, int numNoticias) {
		if(NUMERO_NOTICIAS*(numPagina-1)+id*numPagina>=numNoticias) {
			textAreaTituloVisualizar.setText("No hay noticia");
			textAreaSubtituloNoticiaActual.setText("");
			lbImagenNoticiaActual.setIcon(null);
			textAreaCuerpoNoticiaActual.setText("");
		}else {
			Noticia noticia=noticiasStack.get(NUMERO_NOTICIAS*(numPagina-1)+ id*numPagina);
			cargarNoticias(noticia);
		}
	}
	

	private JPanel getPanel_1_6() {
		if (pnBotonesEscoger == null) {
			pnBotonesEscoger = new JPanel();
			pnBotonesEscoger.add(getBtAtrasEscoger());
			pnBotonesEscoger.add(getBtSiguiente());
		}
		return pnBotonesEscoger;
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
	private JLabel getLbSubtituloNoticia() {
		if (lbSubtituloNoticia == null) {
			lbSubtituloNoticia = new JLabel("Introduzca subtítulo:");
			lbSubtituloNoticia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		}
		return lbSubtituloNoticia;
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
			textAreaCuerpo.setWrapStyleWord(true);
			textAreaCuerpo.setLineWrap(true);
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
			dest=System.getProperty("user.dir")+"/imagenes/"+img.getName();
			Path destino=Paths.get(dest);
			String org=img.getPath();
			Path origen=Paths.get(org);
			try {
				Files.copy(origen, destino, StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				e.printStackTrace();
			}
		
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
						.addComponent(getPanel_1_10(), GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE)
						.addGap(18))
					.addGroup(gl_pnCentro.createSequentialGroup()
						.addComponent(getPnBotones(), GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
						.addContainerGap())
					.addGroup(Alignment.TRAILING, gl_pnCentro.createSequentialGroup()
						.addGroup(gl_pnCentro.createParallelGroup(Alignment.TRAILING)
							.addComponent(getPanel_1_11(), Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
							.addComponent(getPanel_1_12(), GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE))
						.addGap(23))
			);
			gl_pnCentro.setVerticalGroup(
				gl_pnCentro.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnCentro.createSequentialGroup()
						.addComponent(getPanel_1_10(), GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addGap(5)
						.addComponent(getPanel_1_11(), GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(getPanel_1_12(), GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
						.addGap(18)
						.addComponent(getPnBotones(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
			);
			pnCentro.setLayout(gl_pnCentro);
		}
		return pnCentro;
	}
	private JPanel getPnBotones() {
		if (pnBotones == null) {
			pnBotones = new JPanel();
			pnBotones.add(getBtAñadirImagen());
			pnBotones.add(getBtAtrasAñadir());
			pnBotones.add(getBtFinalizar());
		}
		return pnBotones;
	}
	private JButton getBtFinalizar() {
		if (btFinalizar == null) {
			btFinalizar = new JButton("Finalizar");
			btFinalizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					insertarNoticia();
				}

			});
			btFinalizar.setBackground(Color.GREEN);
		}
		return btFinalizar;
	}
	
	private void insertarNoticia() {
		String titulo=textAreaAñadirTitulo.getText();
		if(titulo.isBlank()) {
			JOptionPane.showMessageDialog(null, "El título no puede estar vacío");
		}else {
			String subtitulo=getTextAreaAñadirSubtitulo().getText();
			String cuerpo=getTextAreaCuerpo().getText();
			if(cuerpo.isBlank()) {
				JOptionPane.showMessageDialog(null, "El cuerpo no puede estar vacío");
			}else {
				service.insertarNoticia(titulo, subtitulo, cuerpo, dest);
				JOptionPane.showMessageDialog(null, "Noticia insertada correctamente");
				textAreaAñadirTitulo.setText("");
				getTextAreaAñadirSubtitulo().setText("");
				getTextAreaCuerpo().setText("");
				dest=null;
				getLbImagenNoticiaActual().setIcon(null);
			}
		}
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
			pnVisualizar.setLayout(new BorderLayout(0, 0));
			pnVisualizar.add(getPnTituloVisualizar(), BorderLayout.NORTH);
			pnVisualizar.add(getPanel_1_7());
			pnVisualizar.add(getPanel_1_8(), BorderLayout.SOUTH);
		}
		return pnVisualizar;
		
	}
	
	
	
	private JPanel getPnTituloVisualizar() {
		if (pnTituloVisualizar == null) {
			pnTituloVisualizar = new JPanel();
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
	private JPanel getPanel_1_4() {
		return crearPanelEscoger();
	}
	private JLabel getLbTituloEsogerNoticia() {
		if (lbTituloEsogerNoticia == null) {
			lbTituloEsogerNoticia = new JLabel("Noticias");
			lbTituloEsogerNoticia.setFont(new Font("Verdana Pro Cond Black", Font.PLAIN, 33));
		}
		return lbTituloEsogerNoticia;
	}
	
	
	private void cargarNoticias(Noticia noticia) {
		textAreaTituloVisualizar.setText(noticia.getTitulo());
		textAreaSubtituloNoticiaActual.setText(noticia.getSubtitulo());
		Image imgOriginal=new ImageIcon(noticia.getImg()).getImage();
		
		Image imgEscalada=imgOriginal.getScaledInstance(lbImagenNoticiaActual.getWidth(),
				lbImagenNoticiaActual.getHeight(), Image.SCALE_SMOOTH);
		lbImagenNoticiaActual.setIcon(new ImageIcon(imgEscalada));
		textAreaCuerpoNoticiaActual.setText(noticia.getCuerpo());
		}
		
	
	private JButton getBtAtrasEscoger() {
		if (btAtrasEscoger == null) {
			btAtrasEscoger = new JButton("Atrás");
			btAtrasEscoger.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					comprobarPagina();
					
					
				}

			});
			btAtrasEscoger.setBackground(Color.RED);
		}
		return btAtrasEscoger;
	}
	private void comprobarPagina() {
		numPagina--;
		if(numPagina<=0) {
			numPagina=1;
			showPn("intro");
		}else {
			numPagina--;
			crearPanelEscogerNoticias();
			showPn("escogerNoticia");
		}
		
	}
	private JPanel getPnTituloEscoger() {
		if (pnTituloEscoger == null) {
			pnTituloEscoger = new JPanel();
			pnTituloEscoger.add(getLbTituloEsogerNoticia());
		}
		return pnTituloEscoger;
	}
	private JPanel getPanel_1_7() {
		if (pnNoticiaActual == null) {
			pnNoticiaActual = new JPanel();
			pnNoticiaActual.setLayout(new BoxLayout(pnNoticiaActual, BoxLayout.PAGE_AXIS));
			pnNoticiaActual.add(getPanel_1_9());
		}
		return pnNoticiaActual;
	}
	private JLabel getLbImagenNoticiaActual() {
		if (lbImagenNoticiaActual == null) {
			lbImagenNoticiaActual = new JLabel("");
		}
		return lbImagenNoticiaActual;
	}
	private JScrollPane getScrollPaneCuerpoNoticiaActual() {
		if (scrollPaneCuerpoNoticiaActual == null) {
			scrollPaneCuerpoNoticiaActual = new JScrollPane();
			scrollPaneCuerpoNoticiaActual.setEnabled(false);
			scrollPaneCuerpoNoticiaActual.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPaneCuerpoNoticiaActual.setViewportView(getTextAreaCuerpoNoticiaActual());
		}
		return scrollPaneCuerpoNoticiaActual;
	}
	private JTextArea getTextAreaCuerpoNoticiaActual() {
		if (textAreaCuerpoNoticiaActual == null) {
			textAreaCuerpoNoticiaActual = new JTextArea();
			textAreaCuerpoNoticiaActual.setFont(new Font("Arial", Font.PLAIN, 13));
			textAreaCuerpoNoticiaActual.setWrapStyleWord(true);
			textAreaCuerpoNoticiaActual.setLineWrap(true);
			textAreaCuerpoNoticiaActual.setEditable(false);
			
		}
		return textAreaCuerpoNoticiaActual;
	}
	private JButton getBtAtrasAñadir() {
		if (btAtrasAñadir == null) {
			btAtrasAñadir = new JButton("Atrás");
			btAtrasAñadir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showPn("intro");
				}
			});
			btAtrasAñadir.setBackground(Color.RED);
		}
		return btAtrasAñadir;
	}
	private JPanel getPanel_1_8() {
		if (pnBotonesVisualizar == null) {
			pnBotonesVisualizar = new JPanel();
			pnBotonesVisualizar.add(getBtAtrasVisualizar());
		}
		return pnBotonesVisualizar;
	}
	private JButton getBtAtrasVisualizar() {
		if (btAtrasVisualizar == null) {
			btAtrasVisualizar = new JButton("Atrás");
			btAtrasVisualizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					showPn("escogerNoticia");
				}
			});
			btAtrasVisualizar.setBackground(Color.RED);
		}
		return btAtrasVisualizar;
	}
	private JPanel getPanel_1_9() {
		if (pnCentroVisualizar == null) {
			pnCentroVisualizar = new JPanel();
			pnCentroVisualizar.setBackground(Color.WHITE);
			GroupLayout gl_pnCentroVisualizar = new GroupLayout(pnCentroVisualizar);
			gl_pnCentroVisualizar.setHorizontalGroup(
				gl_pnCentroVisualizar.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnCentroVisualizar.createSequentialGroup()
						.addGroup(gl_pnCentroVisualizar.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_pnCentroVisualizar.createSequentialGroup()
								.addGap(7)
								.addComponent(getScrollPaneTitulo()))
							.addGroup(gl_pnCentroVisualizar.createSequentialGroup()
								.addGroup(gl_pnCentroVisualizar.createParallelGroup(Alignment.TRAILING)
									.addGroup(Alignment.LEADING, gl_pnCentroVisualizar.createSequentialGroup()
										.addGap(7)
										.addComponent(getScrollPaneCuerpoNoticiaActual(), GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE))
									.addGroup(gl_pnCentroVisualizar.createSequentialGroup()
										.addGap(24)
										.addComponent(getLbImagenNoticiaActual(), GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
										.addGap(42)
										.addComponent(getScrollPaneTSuntituloNoticiaActual())))
								.addGap(58)))
						.addGap(0))
			);
			gl_pnCentroVisualizar.setVerticalGroup(
				gl_pnCentroVisualizar.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnCentroVisualizar.createSequentialGroup()
						.addGap(7)
						.addComponent(getScrollPaneTitulo(), GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addGap(27)
						.addGroup(gl_pnCentroVisualizar.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_pnCentroVisualizar.createSequentialGroup()
								.addComponent(getLbImagenNoticiaActual(), GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
								.addGap(18))
							.addGroup(gl_pnCentroVisualizar.createSequentialGroup()
								.addComponent(getScrollPaneTSuntituloNoticiaActual(), GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(getScrollPaneCuerpoNoticiaActual(), GroupLayout.PREFERRED_SIZE, 310, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
			);
			pnCentroVisualizar.setLayout(gl_pnCentroVisualizar);
		}
		return pnCentroVisualizar;
	}
	private JButton getBtSiguiente() {
		if (btSiguiente == null) {
			btSiguiente = new JButton("Siguiente página");
			btSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					crearPanelEscogerNoticias();
					showPn("escogerNoticia");
					
				}
			});
		}
		return btSiguiente;
	}
	private JScrollPane getScrollPaneTitulo() {
		if (scrollPaneTitulo == null) {
			scrollPaneTitulo = new JScrollPane();
			scrollPaneTitulo.setMaximumSize(new Dimension(3275, 3276));
			scrollPaneTitulo.setViewportView(getTextAreaTituloVisualizar());
		}
		return scrollPaneTitulo;
	}
	private JScrollPane getScrollPaneIAñadirTitulo() {
		if (scrollPaneIAñadirTitulo == null) {
			scrollPaneIAñadirTitulo = new JScrollPane();
			scrollPaneIAñadirTitulo.setViewportView(getTextAreaAñadirTitulo());
		}
		return scrollPaneIAñadirTitulo;
	}
	private JTextArea getTextAreaAñadirTitulo() {
		if (textAreaAñadirTitulo == null) {
			textAreaAñadirTitulo = new JTextArea();
			textAreaAñadirTitulo.setWrapStyleWord(true);
			textAreaAñadirTitulo.setLineWrap(true);
			
		}
		return textAreaAñadirTitulo;
	}
	private JPanel getPanel_1_10() {
		if (pnAñadirTitulo == null) {
			pnAñadirTitulo = new JPanel();
			pnAñadirTitulo.setLayout(new BorderLayout(0, 0));
			pnAñadirTitulo.add(getLbTituloNoticia(), BorderLayout.NORTH);
			pnAñadirTitulo.add(getScrollPaneIAñadirTitulo());
		}
		return pnAñadirTitulo;
	}
	private JScrollPane getScrollPaneAñadirSubtitulo() {
		if (scrollPaneAñadirSubtitulo == null) {
			scrollPaneAñadirSubtitulo = new JScrollPane();
			scrollPaneAñadirSubtitulo.setViewportView(getTextAreaAñadirSubtitulo());
		}
		return scrollPaneAñadirSubtitulo;
	}
	private JTextArea getTextAreaAñadirSubtitulo() {
		if (textAreaAñadirSubtitulo == null) {
			textAreaAñadirSubtitulo = new JTextArea();
			textAreaAñadirSubtitulo.setWrapStyleWord(true);
			textAreaAñadirSubtitulo.setLineWrap(true);
		}
		return textAreaAñadirSubtitulo;
	}
	private JPanel getPanel_1_11() {
		if (pnAñadirSubtitulo == null) {
			pnAñadirSubtitulo = new JPanel();
			pnAñadirSubtitulo.setLayout(new BorderLayout(0, 0));
			pnAñadirSubtitulo.add(getLbSubtituloNoticia(), BorderLayout.NORTH);
			pnAñadirSubtitulo.add(getScrollPaneAñadirSubtitulo());
		}
		return pnAñadirSubtitulo;
	}
	private JPanel getPanel_1_12() {
		if (pnAñadirCuerpo == null) {
			pnAñadirCuerpo = new JPanel();
			pnAñadirCuerpo.setLayout(new BorderLayout(0, 0));
			pnAñadirCuerpo.add(getLbCuerpo(), BorderLayout.NORTH);
			pnAñadirCuerpo.add(getScrollPaneCuerpo());
		}
		return pnAñadirCuerpo;
	}
	private JTextArea getTextAreaTituloVisualizar() {
		if (textAreaTituloVisualizar == null) {
			textAreaTituloVisualizar = new JTextArea();
			textAreaTituloVisualizar.setForeground(Color.BLACK);
			textAreaTituloVisualizar.setFont(new Font("Arial", Font.PLAIN, 16));
			textAreaTituloVisualizar.setEnabled(false);
			textAreaTituloVisualizar.setWrapStyleWord(true);
			textAreaTituloVisualizar.setLineWrap(true);
		}
		return textAreaTituloVisualizar;
	}
	private JScrollPane getScrollPaneTSuntituloNoticiaActual() {
		if (scrollPaneTSuntituloNoticiaActual == null) {
			scrollPaneTSuntituloNoticiaActual = new JScrollPane();
			scrollPaneTSuntituloNoticiaActual.setMaximumSize(new Dimension(3275, 3276));
			scrollPaneTSuntituloNoticiaActual.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPaneTSuntituloNoticiaActual.setViewportView(getTextAreaSubtituloNoticiaActual());
		}
		return scrollPaneTSuntituloNoticiaActual;
	}
	private JTextArea getTextAreaSubtituloNoticiaActual() {
		if (textAreaSubtituloNoticiaActual == null) {
			textAreaSubtituloNoticiaActual = new JTextArea();
			textAreaSubtituloNoticiaActual.setFont(new Font("Arial", Font.PLAIN, 16));
			textAreaSubtituloNoticiaActual.setEditable(false);
			textAreaSubtituloNoticiaActual.setWrapStyleWord(true);
			textAreaSubtituloNoticiaActual.setLineWrap(true);
		}
		return textAreaSubtituloNoticiaActual;
	}
	}
