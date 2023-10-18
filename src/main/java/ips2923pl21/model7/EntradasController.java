package ips2923pl21.model7;

import javax.swing.JOptionPane;

import ip2023pl21.util.SwingUtil;
import ips2023pl12.ui7.EntradasView;

public class EntradasController {
	
//	public static void main(String[] args) {
//		EntradasController c=new EntradasController(new EntradasModel(), new EntradasView());
//	}
	
	private EntradasModel model;
	private EntradasView view;
	
	public EntradasController(EntradasModel model, EntradasView view) {
		this.model = model;
		this.view = view;
		this.initView();
	}
	
	private void initController() {
		view.getBtnComprar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> iniciarCompra()));
		view.getBtnCancelar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> cancelar()));
	}

	
	private void initView() {
		view.getFrame().setVisible(true);
		initController();
		}
	
	private void iniciarCompra() {
		if(!model.comprarEntradas(view.getButtonGroupTribuna().getSelection().getActionCommand(), 
				view.getButtonGroupSecion().getSelection().getActionCommand(), (int)view.getSpinnerNumEntradas().getValue())) {
			JOptionPane.showMessageDialog(null, "No hay suficientes entradas en la tribuna y sección "
					+ "escogidas");
		}
		else {
		JOptionPane.showMessageDialog(null, "Compra realizada. La fila asignada es la fila "+model.getFila()+". "+
				generarMensaje((int)view.getSpinnerNumEntradas().getValue()));
//			view.getFrame().dispose();
		}
		
	}
	
	private String generarMensaje(int numeroEntradas) {
		int asiento=model.getAsientoInicial()-1;
		if(numeroEntradas==1) {
			return "El asiento asignado es el asiento "+asiento;
		}
		String mensaje="Los asientos asignados son: asiento ";
		for(int i=0;i<numeroEntradas-1;i++) {
			mensaje+=asiento+ ", asiento ";
			asiento--;
		}
		mensaje+=asiento;
		return mensaje;
	}
	
	private void cancelar() {
		System.exit(0);
	}

	
	

}
