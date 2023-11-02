package ips2023pl21.service;

import ips2023pl21.persistence.Persistence;

public class Service22759 {
	private Persistence p = Persistence.getInstance();

	public void insertarNoticia(String titulo, String subtitulo, String cuerpo, String dest) {
		p.insertNoticia(titulo, subtitulo, cuerpo, dest);
		
	}
	
	

}
