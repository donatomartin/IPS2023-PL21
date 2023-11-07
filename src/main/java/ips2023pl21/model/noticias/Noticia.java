package ips2023pl21.model.noticias;

public class Noticia {
	private String titulo;
	private String subtitulo;
	private String cuerpo;
	private String img;
	
	public Noticia(String titulo, String subtitulo, String cuerpo, String img) {
		this.titulo = titulo;
		this.subtitulo = subtitulo;
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

	public String getSubtitulo() {
		return subtitulo;
	}

	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
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
