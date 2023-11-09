package ips2023pl21.service;

import java.util.List;

import ips2023pl21.model.acciones.Accion;
import ips2023pl21.model.acciones.Accionista;
import ips2023pl21.persistence.Persistence;

public class Service22748_9 {
	
	public static final double PRECIO_POR_ACCION = 34.67;
	
	private Persistence p = Persistence.getInstance();
	private CapitalFase fase;
	private int accionesVendidas;
	private int accionesRestantes;
	private Accionista accionistaActivo;
	
	public enum CapitalFase{
		FUERA_FASE,
		FASE1,
		FASE2,
		FASE3;
	}
	
	public Service22748_9() {
		this.fase = CapitalFase.FUERA_FASE;
		accionesVendidas = 0;
		accionesRestantes = 0;
	}
	
	public int getAccionesVendidas() {
		return accionesVendidas;
	}

	public void setAccionesVendidas(int accionesRestantes) {
		this.accionesVendidas = accionesRestantes;
	}
	
	public int getAccionesRestantes() {
		return accionesRestantes;
	}

	public void setAccionesRestantes(int accionesRestantes) {
		this.accionesRestantes = accionesRestantes;
	}
	
	public CapitalFase getFase() {
		return fase;
	}

	public void setFase(CapitalFase fase) {
		this.fase = fase;
	}

	public Accionista getAccionistaActivo() {
		return accionistaActivo;
	}

	public void setAccionistaActivo(Accionista accionistaActivo) {
		this.accionistaActivo = accionistaActivo;
	}
	
	public float getPorcentajeUnaAccion() {
		float total = p.getAccionesClub();
		return (float)1/total*100;
	}

	public float getCapitalClub() {
		return p.getCapitalClub();
	}

	public float getPrecioPorAccion() {
		return p.getPrecioPorAccion();
	}
	
	public void insertarAmpliacion(int accionesNuevas) {
		p.insertAmpliacion(accionesNuevas);
	}
	
	public void guardarLimiteFaseUno() {
		p.updateLimiteFaseUno();
	}

	public boolean existeAccionista(int numeroAccionista) {
		List<Accionista> list = p.selectAccionista(numeroAccionista);
		if (list.size() > 0) {
			return true;
		}
		return false;
	}

	public boolean existePersona(String nombre, String apellido, String dni) {
		List<Accionista> list = p.selectAccionista(nombre, apellido, dni);
		if(list.size() > 0) {
			return true;
		}
		return false;
	}

	public void añadirAccionista(String nombre, String apellido, String dni, String cuenta) {
		p.insertAccionista(nombre, apellido, dni, cuenta);
	}

	public Accionista obtenerAccionista(int id) {
		return p.selectAccionistaById(id).get(0);
	}

	public List<Accion> getAccionesAccionista() {
		return p.selectAccionesByIdAccionista(accionistaActivo.getIdAccionista());
	}

	public List<Accion> getAccionesEnVenta() {
		return p.selectAccionesEnVenta(accionistaActivo.getIdAccionista());
	}

	public void comprarAccion(Integer idAccion, Integer idVendedor) {
		p.updateAccionCompra(idAccion, accionistaActivo.getIdAccionista(), 
				idVendedor, getPorcentajeUnaAccion());
	}

	public void eliminarAcionistaACero() {
		p.deleteAccionistaACero();
	}

	public int getLimiteFase1() {
		return p.selectLimiteFase1(accionistaActivo.getIdAccionista());
	}

	public void crearAccion() {
		p.insertAccion(accionistaActivo.getIdAccionista(), PRECIO_POR_ACCION);
	}

	public void actualizaLimiteAccionista(Integer numAcciones) {
		p.updateLimiteAccionista(accionistaActivo.getIdAccionista(), numAcciones);
	}

	public void actualizaAccionistaCompraClub() {
		p.updateCompraAccionista(accionistaActivo.getIdAccionista(), getPorcentajeUnaAccion());
	}

	public void ponerEnVentaTodo() {
		p.updateAccionesEnVenta(accionistaActivo.getIdAccionista());
	}

	public void ponerEnVenta(Integer id) {
		p.updatePonerEnVenta(id);
	}

	public int countAccionistas() {
		return p.countAccionistas();
	}
	
}
