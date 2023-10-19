package ips2023pl21.p21915.model;

public class JugadorProfesional extends EmpleadoDeportivo {
	
	public JugadorProfesional() {}

	
	@Override
	public boolean equals(Object obj) {

		if(super.equals(obj))
			return true;
		
		if (this.getEid() == ((JugadorProfesional)obj).getEid())
			return true;
		
		return false;
	}
}
