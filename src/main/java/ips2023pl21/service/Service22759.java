package ips2023pl21.service;

import java.util.List;

import ips2023pl21.model.noticias.Noticia;
import ips2023pl21.persistence.Persistence;


public class Service22759 {
	private Persistence p = Persistence.getInstance();

	public void insertarNoticia(String titulo, String subtitulo, String cuerpo, String dest) {
		p.insertNoticia(titulo, subtitulo, cuerpo, dest);
		
	}

	public List<Noticia> getNoticias() {
		return p.selectNoticias();
	}
	
	

}
