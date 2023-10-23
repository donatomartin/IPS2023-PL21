package ips2023pl21.model.equipos;

public class EquipoEnFormacion extends EquipoDeportivo{
	
	private static final int EDAD_MAX_DEFAULT = 18;
	private static final int EDAD_MAX_JUVENIL = 18;
	private static final int EDAD_MAX_CADETE = 15;
	private static final int EDAD_MAX_INFANTIL = 13;
	private static final int EDAD_MAX_ALEVIN = 11;
	private static final int EDAD_MAX_BENJAMIN = 9;
	private static final int EDAD_MAX_PREBENJAMIN = 7;
	
	public CategoriaEquipo categoria;
	
	
	public EquipoEnFormacion() {
		super();
	}
	
	
	public void setCategoria(CategoriaEquipo ce) {
		this.categoria = ce;
	}
	
	
	public int getEdadMaximaPorCategoria() {
		switch(categoria) {
			case JUVENIL:
				return EDAD_MAX_JUVENIL;
			case CADETE:
				return EDAD_MAX_CADETE;
			case INFANTIL:
				return EDAD_MAX_INFANTIL;
			case ALEVIN:
				return EDAD_MAX_ALEVIN;
			case BENJAMIN:
				return EDAD_MAX_BENJAMIN;
			case PREBENJAMIN:
				return EDAD_MAX_PREBENJAMIN;
			default:
				return EDAD_MAX_DEFAULT;
		}
	}

}
