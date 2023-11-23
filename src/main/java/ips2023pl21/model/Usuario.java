package ips2023pl21.model;

public class Usuario {
	
	private String usuario;
	private String contrasena;
	private String rol;
	private int pid;
	
	public Usuario() {
		
	}

	public String getUsuario() {
		return usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public String getRol() {
		return rol;
	}
	
	public int getPid() {
		return pid;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	public void setRol(String rol) {
		this.rol = rol;
	}
	
	public void setPid(int pid) {
		this.pid = pid;
	}

}
