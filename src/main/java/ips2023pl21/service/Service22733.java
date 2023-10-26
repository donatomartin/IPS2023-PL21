package ips2023pl21.service;

import ips2023pl21.ui.Frame22733;
import ips2023pl21.util.SwingUtil;

public class Service22733 {
	private Frame22733 view;
	private Service22733 controller;
	
	public Service22733(Frame22733 view, Service22733 controller) {
		this.view = view;
		this.controller = controller;
		this.initView();
	}

	private void initView() {
		view.getFrame().setVisible(true);
		initController();
		
	}

	private void initController() {
		view.getBtCancelar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> cancelar()));
		
	}

	private void cancelar() {
		view.getFrame().dispose();
	}
	
	

}
