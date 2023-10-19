package ips2023pl21.p21915.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import ips2023pl21.p21915.service.Service21915;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.JCheckBox;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Frame21915 extends JFrame {

	private Service21915 service;
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pnWork;
	private JPanel pnSeleccionJugador;
	private JPanel pnFiltro;
	private JTextField txFilterEmpleado;
	private JPanel pnList;
	private JList<String> empleadoList;
	private DefaultListModel<String> empleadoListModel = new DefaultListModel<String>();
	private JPanel pnFormulario;
	private JPanel pnCabecera;
	private JLabel lbTitulo;
	private JLabel lblNewLabel;
	private JPanel pnEmpleadoSeleccionado;
	private JTextField txEmpleadoSeleccionado;
	private JPanel pnCuerpo;
	private JPanel pnSeleccionFecha;
	private JLabel lbSeleccionFecha;
	private JSpinner spFecha;
	private JPanel pnFecha;
	private JLabel lbHoraFin;
	private JSpinner spHoraFin;
	private JSpinner spHoraInicio;
	private JLabel lbHoraInicio;
	private JPanel pnInicio;
	private JPanel pnFin;
	private JPanel pnFranjas;
	private JPanel pnSeleccionFecha1;
	private JCheckBox chckbxNewCheckBox;
	private JButton addEntrevista;
	private JPanel panel;
	private JTextField txMedio;
	private JLabel lbDatosMedio;
	private JButton btnVerEntrevistas;
	private JPanel pnEntrevistas;
	private JList<String> listEntrevistas;
	private DefaultListModel<String> entrevistasListModel = new DefaultListModel<String>();
	private JButton btnAtras;
	private JLabel lbJugadoresDisponibles;
	private JLabel lbSubtitulo;

    public Frame21915(Service21915 service) {
		setTitle("Gestion Entrevistas");
        this.service = service;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 750, 350);
        setMinimumSize(getSize());
        contentPane = new JPanel();

        setContentPane(contentPane);
        contentPane.setLayout(new CardLayout(0, 0));
        contentPane.add(getPnWork(), "pnWork");
        contentPane.add(getPanel_1_3(), "pnEntrevistas");
        
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		String horaInicio = format.format(getSpHoraInicio().getValue());
        String horaFin = format.format(getSpHoraFin().getValue());
        format = new SimpleDateFormat("dd-MM-yyyy");
        String fecha = format.format(getSpFecha().getValue());
        
        service.setFecha(fecha);
		service.setHoraInicio(horaInicio);
		service.setHoraFin(horaFin);
    }

    private JPanel getPnWork() {
        if (pnWork == null) {
            pnWork = new JPanel();
            pnWork.setLayout(new BorderLayout(0, 0));
            pnWork.add(getPnSeleccionJugador(), BorderLayout.EAST);
            pnWork.add(getPnFormulario(), BorderLayout.CENTER);
        }
        return pnWork;
    }

    private JPanel getPnSeleccionJugador() {
        if (pnSeleccionJugador == null) {
            pnSeleccionJugador = new JPanel();
            pnSeleccionJugador.setBorder(new EmptyBorder(5, 5, 5, 5));
            pnSeleccionJugador.setLayout(new BorderLayout(5, 5));
            pnSeleccionJugador.add(getPnFiltro(), BorderLayout.NORTH);
            pnSeleccionJugador.add(getPnList(), BorderLayout.CENTER);
        }
        return pnSeleccionJugador;
    }

    private JPanel getPnFiltro() {
        if (pnFiltro == null) {
            pnFiltro = new JPanel();
            pnFiltro.setLayout(new BoxLayout(pnFiltro, BoxLayout.X_AXIS));
            pnFiltro.add(getTxFilterEmpleado());
        }
        return pnFiltro;
    }

    private JTextField getTxFilterEmpleado() {
        if (txFilterEmpleado == null) {
            txFilterEmpleado = new JTextField();
            txFilterEmpleado.setColumns(10);
            txFilterEmpleado.getDocument().addDocumentListener(new DocumentListener() {
                
            	public void changedUpdate(DocumentEvent e) {
                    filter();
                }
                public void removeUpdate(DocumentEvent e) {
                    filter();
                }
                public void insertUpdate(DocumentEvent e) {
                    filter();
                }

            });
        }
        return txFilterEmpleado;
    }
    
    public void filter() {
        loadListModel(getTxFilterEmpleado().getText());
    }

    private JPanel getPnList() {
        if (pnList == null) {
            pnList = new JPanel();
            pnList.setLayout(new BorderLayout(0, 0));
            JScrollPane listScrollPane = new JScrollPane(getListEmpleados());
            pnList.add(listScrollPane);
            listScrollPane.setColumnHeaderView(getLbJugadoresDisponibles());
        }
        return pnList;
    }

    private JList<String> getListEmpleados() {
        if (empleadoList == null) {
            loadListModel("");
            empleadoList = new JList<String>(empleadoListModel);
            empleadoList.setToolTipText("dobleClick o Enter para seleccionar");
            empleadoList.setBorder(new EmptyBorder(5, 5, 5, 5));
            empleadoList.setFont(new Font("Consolas", Font.BOLD, 15));
            
            // Añadir MouseListener para el doble click
            empleadoList.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                	if (evt.getClickCount() == 2) {
                		int index = empleadoList.locationToIndex(evt.getPoint());
                		seleccionarEmpleado(index);
                		
                	}
                }
            });
            
            
         // Añadir KeyListener para el Enter
            empleadoList.addKeyListener(new KeyAdapter() {
 				public void keyPressed(KeyEvent evt) {
 					if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
 						// Enter detectado
 						int index = empleadoList.getSelectedIndex();
 						seleccionarEmpleado(index);
 					}
 				}
 			});
            
        }
        return empleadoList;
    }
    
    private void seleccionarEmpleado(int index) {
        service.seleccionaEmpleado(empleadoListModel.getElementAt(index));
        getTxEmpleadoSeleccionado().setText(service.getNombreEmpleadoSeleccionado());
    }
    
    private void loadListModel(String filter) {
        empleadoListModel.removeAllElements();
        empleadoListModel.addAll(service.getJugadoresLibresString(filter));
    }
	private JPanel getPnFormulario() {
		if (pnFormulario == null) {
			pnFormulario = new JPanel();
			pnFormulario.setLayout(new BorderLayout(0, 0));
			pnFormulario.add(getPanel_1(), BorderLayout.NORTH);
			pnFormulario.add(getPnCuerpo(), BorderLayout.CENTER);
		}
		return pnFormulario;
	}
	private JPanel getPanel_1() {
		if (pnCabecera == null) {
			pnCabecera = new JPanel();
			pnCabecera.setBackground(new Color(192, 192, 192));
			pnCabecera.setBorder(new EmptyBorder(5, 5, 5, 5));
			pnCabecera.setLayout(new BorderLayout(0, 0));
			pnCabecera.add(getLbTitulo(), BorderLayout.NORTH);
			pnCabecera.add(getPnEmpleadoSeleccionado(), BorderLayout.SOUTH);
			pnCabecera.add(getLbSubtitulo(), BorderLayout.WEST);
		}
		return pnCabecera;
	}
	private JLabel getLbTitulo() {
		if (lbTitulo == null) {
			lbTitulo = new JLabel("Gestión de Entrevistas");
			lbTitulo.setFont(new Font("Tahoma", Font.BOLD, 22));
		}
		return lbTitulo;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Seleccionado:");
			lblNewLabel.setBorder(new EmptyBorder(0, 0, 1, 0));
			lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		}
		return lblNewLabel;
	}
	private JPanel getPnEmpleadoSeleccionado() {
		if (pnEmpleadoSeleccionado == null) {
			pnEmpleadoSeleccionado = new JPanel();
			pnEmpleadoSeleccionado.setBorder(new EmptyBorder(5, 5, 5, 5));
			pnEmpleadoSeleccionado.setBackground(new Color(211, 211, 211));
			pnEmpleadoSeleccionado.setLayout(new BorderLayout(5, 0));
			pnEmpleadoSeleccionado.add(getLblNewLabel(), BorderLayout.WEST);
			pnEmpleadoSeleccionado.add(getTxEmpleadoSeleccionado());
		}
		return pnEmpleadoSeleccionado;
	}
	private JTextField getTxEmpleadoSeleccionado() {
		if (txEmpleadoSeleccionado == null) {
			txEmpleadoSeleccionado = new JTextField();
			txEmpleadoSeleccionado.setBackground(new Color(211, 211, 211));
			txEmpleadoSeleccionado.setBorder(null);
			txEmpleadoSeleccionado.setFont(new Font("Tahoma", Font.BOLD, 15));
			txEmpleadoSeleccionado.setText("NONE");
			txEmpleadoSeleccionado.setEditable(false);
			txEmpleadoSeleccionado.setColumns(10);
		}
		return txEmpleadoSeleccionado;
	}
	private JPanel getPnCuerpo() {
		if (pnCuerpo == null) {
			pnCuerpo = new JPanel();
			pnCuerpo.setLayout(new BoxLayout(pnCuerpo, BoxLayout.Y_AXIS));
			pnCuerpo.add(getPnSeleccionFecha());
		}
		return pnCuerpo;
	}
	private JPanel getPnSeleccionFecha() {
		if (pnSeleccionFecha == null) {
			pnSeleccionFecha = new JPanel();
			pnSeleccionFecha.setLayout(new GridLayout(0, 1, 0, 0));
			pnSeleccionFecha.add(getPanel_1_2());
		}
		return pnSeleccionFecha;
	}
	private JLabel getLbSeleccionFecha() {
		if (lbSeleccionFecha == null) {
			lbSeleccionFecha = new JLabel("Fecha");
		}
		return lbSeleccionFecha;
	}
	private JSpinner getSpFecha() {
		if (spFecha == null) {
			Calendar calendar = Calendar.getInstance();
			Date date = calendar.getTime();
			SpinnerDateModel sm = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
			spFecha = new JSpinner(sm);
			spFecha.setFont(new Font("Tahoma", Font.PLAIN, 16));
			JSpinner.DateEditor de = new JSpinner.DateEditor(spFecha, "dd-MM-yyyy");
			spFecha.setEditor(de);
			
			// Agregar ChangeListener al JSpinner
			spFecha.addChangeListener(new ChangeListener() {
	            @Override
	            public void stateChanged(ChangeEvent e) {
	                updateFecha(e);
	            }

	        });
		}
		return spFecha;
	}
	private void updateFecha(ChangeEvent e) {
		JSpinner spinner = (JSpinner) e.getSource();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        String fecha = format.format(spinner.getValue());
        service.setFecha(fecha);
        loadListModel(getTxFilterEmpleado().getText());
	}
	private JPanel getPnFecha() {
		if (pnFecha == null) {
			pnFecha = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnFecha.getLayout();
			flowLayout.setHgap(10);
			pnFecha.add(getLbSeleccionFecha());
			pnFecha.add(getSpFecha());
		}
		return pnFecha;
	}
	private JLabel getLbHoraFin() {
		if (lbHoraFin == null) {
			lbHoraFin = new JLabel("Hora Fin");
		}
		return lbHoraFin;
	}
	private JSpinner getSpHoraFin() {
		if (spHoraFin == null) {
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.HOUR_OF_DAY, 10);
			calendar.set(Calendar.MINUTE, 0);
			Date date = calendar.getTime();
			SpinnerDateModel sm = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
			spHoraFin = new JSpinner(sm);
			spHoraFin.setFont(new Font("Tahoma", Font.PLAIN, 16));
			JSpinner.DateEditor de = new JSpinner.DateEditor(spHoraFin, "HH:mm");
			spHoraFin.setEditor(de);
			
			// Agregar ChangeListener al JSpinner
			spHoraFin.addChangeListener(new ChangeListener() {
	            @Override
	            public void stateChanged(ChangeEvent e) {
	                updateHoraFin(e);
	            }

	        });
			
		}
		return spHoraFin;
	}
	private void updateHoraFin(ChangeEvent e) {
		JSpinner spinner = (JSpinner) e.getSource();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        String horaFin = format.format(spinner.getValue());
        service.setHoraFin(horaFin);
        loadListModel(getTxFilterEmpleado().getText());
	}
	private JSpinner getSpHoraInicio() {
		if (spHoraInicio == null) {
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.HOUR_OF_DAY, 9);
			calendar.set(Calendar.MINUTE, 0);
			Date date = calendar.getTime();
			SpinnerDateModel sm = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
			spHoraInicio = new JSpinner(sm);
			spHoraInicio.setFont(new Font("Tahoma", Font.PLAIN, 16));
			JSpinner.DateEditor de = new JSpinner.DateEditor(spHoraInicio, "HH:mm");
			spHoraInicio.setEditor(de);
			
			// Agregar ChangeListener al JSpinner
	        spHoraInicio.addChangeListener(new ChangeListener() {
	            @Override
	            public void stateChanged(ChangeEvent e) {
	                updateHoraInicio(e);
	            }
	        });
			
		}
		return spHoraInicio;
	}
	private void updateHoraInicio(ChangeEvent e) {
		JSpinner spinner = (JSpinner) e.getSource();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        String horaInicio = format.format(spinner.getValue());
        service.setHoraInicio(horaInicio);
        loadListModel(getTxFilterEmpleado().getText());
	}
	private JLabel getLbHoraInicio() {
		if (lbHoraInicio == null) {
			lbHoraInicio = new JLabel("Hora Inicio");
		}
		return lbHoraInicio;
	}
	private JPanel getPnInicio() {
		if (pnInicio == null) {
			pnInicio = new JPanel();
			pnInicio.setBorder(new EmptyBorder(5, 5, 5, 5));
			pnInicio.setLayout(new GridLayout(0, 2, 0, 0));
			pnInicio.add(getLbHoraInicio());
			pnInicio.add(getSpHoraInicio());
		}
		return pnInicio;
	}
	private JPanel getPanel_1_1() {
		if (pnFin == null) {
			pnFin = new JPanel();
			pnFin.setBorder(new EmptyBorder(5, 5, 5, 5));
			pnFin.setLayout(new GridLayout(0, 2, 0, 0));
			pnFin.add(getLbHoraFin());
			pnFin.add(getSpHoraFin());
		}
		return pnFin;
	}
	private JPanel getPnFranjas() {
		if (pnFranjas == null) {
			pnFranjas = new JPanel();
			pnFranjas.setLayout(new BoxLayout(pnFranjas, BoxLayout.Y_AXIS));
			pnFranjas.add(getChckbxNewCheckBox());
			pnFranjas.add(getPnInicio());
			pnFranjas.add(getPanel_1_1());
		}
		return pnFranjas;
	}
	private JPanel getPanel_1_2() {
		if (pnSeleccionFecha1 == null) {
			pnSeleccionFecha1 = new JPanel();
			pnSeleccionFecha1.setBorder(new EmptyBorder(0, 0, 0, 0));
			GridBagLayout gbl_pnSeleccionFecha1 = new GridBagLayout();
			gbl_pnSeleccionFecha1.columnWidths = new int[]{303, 0};
			gbl_pnSeleccionFecha1.rowHeights = new int[] {33};
			gbl_pnSeleccionFecha1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
			gbl_pnSeleccionFecha1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
			pnSeleccionFecha1.setLayout(gbl_pnSeleccionFecha1);
			GridBagConstraints gbc_pnFecha = new GridBagConstraints();
			gbc_pnFecha.anchor = GridBagConstraints.SOUTHEAST;
			gbc_pnFecha.insets = new Insets(0, 0, 5, 0);
			gbc_pnFecha.gridx = 0;
			gbc_pnFecha.gridy = 0;
			pnSeleccionFecha1.add(getPnFecha(), gbc_pnFecha);
			GridBagConstraints gbc_pnFranjas = new GridBagConstraints();
			gbc_pnFranjas.insets = new Insets(0, 0, 5, 0);
			gbc_pnFranjas.anchor = GridBagConstraints.SOUTHEAST;
			gbc_pnFranjas.gridx = 0;
			gbc_pnFranjas.gridy = 1;
			pnSeleccionFecha1.add(getPnFranjas(), gbc_pnFranjas);
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.insets = new Insets(0, 0, 5, 0);
			gbc_panel.anchor = GridBagConstraints.SOUTHEAST;
			gbc_panel.gridx = 0;
			gbc_panel.gridy = 2;
			pnSeleccionFecha1.add(getPanel(), gbc_panel);
			GridBagConstraints gbc_btnVerEntrevistas = new GridBagConstraints();
			gbc_btnVerEntrevistas.anchor = GridBagConstraints.SOUTHEAST;
			gbc_btnVerEntrevistas.gridx = 0;
			gbc_btnVerEntrevistas.gridy = 3;
			pnSeleccionFecha1.add(getBtnVerEntrevistas(), gbc_btnVerEntrevistas);
		}
		return pnSeleccionFecha1;
	}
	private JCheckBox getChckbxNewCheckBox() {
		if (chckbxNewCheckBox == null) {
			chckbxNewCheckBox = new JCheckBox("Día Completo");
			chckbxNewCheckBox.addItemListener(new ItemListener() {
	            public void itemStateChanged(ItemEvent e) {
	                if (e.getStateChange() == ItemEvent.SELECTED) {
	                	disableFranjas();
	                } else {
	                    enableFranjas();
	                }
	            }
	        });
		}
		return chckbxNewCheckBox;
	}
	private void disableFranjas() {
		getSpHoraInicio().setEnabled(false);
		getSpHoraFin().setEnabled(false);
		service.setHoraInicio("00:00");
		service.setHoraFin("23:59");
		loadListModel(getTxFilterEmpleado().getText());
		
	}
	private void enableFranjas() {
		getSpHoraInicio().setEnabled(true);
		getSpHoraFin().setEnabled(true);
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		String horaInicio = format.format(getSpHoraInicio().getValue());
        String horaFin = format.format(getSpHoraFin().getValue());
		service.setHoraInicio(horaInicio);
		service.setHoraFin(horaFin);
		loadListModel(getTxFilterEmpleado().getText());
	}
	private JButton getAddEntrevista() {
		if (addEntrevista == null) {
			addEntrevista = new JButton("Añadir");
			addEntrevista.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addEntrevista();
				}
			});
			addEntrevista.setBackground(new Color(211, 211, 211));
		}
		return addEntrevista;
	}
	private void addEntrevista() {
		int res = service.addEntrevista(getTxMedio().getText());
		
		if (res == 0) {
			getTxEmpleadoSeleccionado().setText("NONE");
			getTxMedio().setText("");
		}
		if (res == 1) {
			JOptionPane.showMessageDialog(null, "Error: Jugador no seleccionado.", "Error", JOptionPane.ERROR_MESSAGE);
		}
		if (res == 2) {
			JOptionPane.showMessageDialog(null, "Error: Medio no especificado.", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		loadListModel(getTxFilterEmpleado().getText());
		loadEntrevistasModel();
	}
	private void loadEntrevistasModel() {
		
		entrevistasListModel.removeAllElements();
		entrevistasListModel.addAll(service.getEntrevistasString());

	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panel.add(getLbDatosMedio());
			panel.add(getTxMedio());
			panel.add(getAddEntrevista());
		}
		return panel;
	}
	private JTextField getTxMedio() {
		if (txMedio == null) {
			txMedio = new JTextField();
			txMedio.setColumns(10);
		}
		return txMedio;
	}
	private JLabel getLbDatosMedio() {
		if (lbDatosMedio == null) {
			lbDatosMedio = new JLabel("Datos Medio:");
		}
		return lbDatosMedio;
	}
	private JButton getBtnVerEntrevistas() {
		if (btnVerEntrevistas == null) {
			btnVerEntrevistas = new JButton("Ver entrevistas");
			btnVerEntrevistas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((CardLayout)getContentPane().getLayout()).show(getContentPane(), "pnEntrevistas");
				}
			});
			btnVerEntrevistas.setBackground(new Color(211, 211, 211));
		}
		return btnVerEntrevistas;
	}
	private JPanel getPanel_1_3() {
		if (pnEntrevistas == null) {
			pnEntrevistas = new JPanel();
			pnEntrevistas.setLayout(new BorderLayout(0, 0));
			JScrollPane scpn = new JScrollPane(getList());
			pnEntrevistas.add(scpn, BorderLayout.CENTER);
			pnEntrevistas.add(getBtnAtras(), BorderLayout.SOUTH);
		}
		return pnEntrevistas;
	}
	private JList<String> getList() {
		if (listEntrevistas == null) {
			listEntrevistas = new JList<String>(entrevistasListModel);
		}
		return listEntrevistas;
	}
	private JButton getBtnAtras() {
		if (btnAtras == null) {
			btnAtras = new JButton("Atrás");
			btnAtras.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((CardLayout)getContentPane().getLayout()).show(getContentPane(), "pnWork");
				}
			});
		}
		return btnAtras;
	}
	private JLabel getLbJugadoresDisponibles() {
		if (lbJugadoresDisponibles == null) {
			lbJugadoresDisponibles = new JLabel("Jugadores Disponibles");
			lbJugadoresDisponibles.setBorder(new EmptyBorder(5, 5, 5, 5));
		}
		return lbJugadoresDisponibles;
	}
	private JLabel getLbSubtitulo() {
		if (lbSubtitulo == null) {
			lbSubtitulo = new JLabel("Jugadores Profesionales");
			lbSubtitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		return lbSubtitulo;
	}
}
