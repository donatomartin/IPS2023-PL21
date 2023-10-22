package ips2023pl21.model;

public class EquipoProfesional extends EquipoDeportivo{
	
	boolean esFilial;
	
	public EquipoProfesional() {
		super();
	}

	public boolean isFilial() {
		return this.esFilial;
	}
	
	public void setFilial(boolean esFilial) {
		this.esFilial = esFilial;
	}
}
