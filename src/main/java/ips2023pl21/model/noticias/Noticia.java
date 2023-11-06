package ips2023pl21.model.noticias;

public class Noticia {
	private String titulo;
	private String subtititulo;
	private String cuerpo;
	private String img;
	
	public Noticia(String titulo, String subtititulo, String cuerpo, String img) {
		this.titulo = titulo;
		this.subtititulo = subtititulo;
		this.cuerpo = cuerpo;
		this.img = img;
	}
	

	public Noticia() {
		super();
	}
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSubtititulo() {
		return subtititulo;
	}

	public void setSubtititulo(String subtititulo) {
		this.subtititulo = subtititulo;
	}

	public String getCuerpo() {
		return cuerpo;
	}

	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	
	

}
