package ips2023pl21.service;

import java.security.NoSuchAlgorithmException;

import ips2023pl21.persistence.Persistence;
import ips2023pl21.util.Util;

public class MainService {
	
	Persistence p = Persistence.getInstance();

	public State checkUser(String user, String password) {
		String encrypedPassword;
		
		try {
			encrypedPassword = Util.getMD5Hash(password);
		} catch (NoSuchAlgorithmException e) {
			return State.ENCRYPTION_ERROR;
		}
		
		return p.checkUser(user, encrypedPassword);		
	}
	
	

}
