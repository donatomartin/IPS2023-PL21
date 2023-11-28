package ips2023pl21.service;

import java.security.NoSuchAlgorithmException;

import ips2023pl21.model.Usuario;
import ips2023pl21.persistence.Persistence;
import ips2023pl21.util.Util;

public class MainService {
	
	Persistence p = Persistence.getInstance();

	public State checkUser(Usuario usuario) {
		String encryptedPassword;
		
		try {
			encryptedPassword = Util.getMD5Hash(usuario.getContrasena());
			usuario.setContrasena(encryptedPassword);
		} catch (NoSuchAlgorithmException e) {
			return State.ENCRYPTION_ERROR;
		}
		
		return p.checkUser(usuario);		
	}

	public State addUser(Usuario usuario) {
		
		
		if (usuario.getRol().equals("entrenador") && usuario.getPid() == 0)
			return State.SINGINFAIL_NOID;
		
		String encryptedPassword;
		
		try {
			encryptedPassword = Util.getMD5Hash(usuario.getContrasena());
			usuario.setContrasena(encryptedPassword);
			p.addUser(usuario);			
		} catch (NoSuchAlgorithmException e) {
			return State.ENCRYPTION_ERROR;
		} catch (Exception se) {
			return State.SINGINFAIL_USEREXISTS;
		}

		return State.SUCCESS;
		
	}
	
	

}
