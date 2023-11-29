package ips2023pl21.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import ips2023pl21.model.acciones.Accion;
import ips2023pl21.model.acciones.Accionista;
import ips2023pl21.persistence.Persistence;
import ips2023pl21.util.Util;

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
		this.fase = getFase();
		accionesRestantes = getAccionesRestantes();
		accionesVendidas = getAccionesVendidas();
	}

	public int getAccionesVendidas() {
		accionesVendidas =  p.selectAccionesVendidas();
		return accionesVendidas;
	}

	public void setAccionesVendidas(int accionesVendidas) {
		p.updateAccionesVendidas(accionesVendidas);
	}
	
	public int getAccionesRestantes() {
		if (fase.equals(CapitalFase.FUERA_FASE)) {
			accionesRestantes = 0;
			return accionesRestantes;
		}
		else if(fase.equals(CapitalFase.FASE1)) {
			accionesRestantes = p.selectRestantesFase1();
			return accionesRestantes;
		}
		else if (fase.equals(CapitalFase.FASE2)) {
			accionesRestantes = p.selectRestantesFase2();
			return accionesRestantes;
		}
		accionesRestantes = p.selectRestantesFase3();
		return accionesRestantes;
	}

	public void setAccionesRestantes(int accionesRestantes) {
		String fase = p.getFase();
		
		if(fase.equals("Fase 1")) {
			p.updateAccionesFase1(accionesRestantes);
		}
		else if (fase.equals("Fase 2")) {
			p.updateAccionesFase2(accionesRestantes);
		}
		p.updateAccionesFase3(accionesRestantes);
	}
	
	public CapitalFase getFase() {
		String fase = p.getFase();
		
		if (fase.equals("Fuera fase")) {
			return CapitalFase.FUERA_FASE;
		}
		else if(fase.equals("Fase 1")) {
			return CapitalFase.FASE1;
		}
		else if(fase.equals("Fase 2")) {
			return CapitalFase.FASE2;
		}
		return CapitalFase.FASE3;
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
		
		LocalDateTime fechaActual = LocalDateTime.now();
		Date d = Date.from(fechaActual.atZone(ZoneId.systemDefault()).toInstant());
		String fecha = Util.dateToIsoString(d);
		int horaVenta = fechaActual.getHour();
		int minutoventa = fechaActual.getMinute();
		p.insertarVentaAccion
		(fecha, horaVenta, minutoventa, PRECIO_POR_ACCION);
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
	
	public void setAccionista() {
		this.accionistaActivo = p.selectAccionista(countAccionistas()).get(0);
	}

	public void updateFase(String fase) {
		p.updateFase(fase);
	}

	public void actualizarCapitalTotal() {
		double capitalNuevo = getCapitalClub() + (getAccionesVendidas()*PRECIO_POR_ACCION);
		p.updateCapitalTotal(capitalNuevo);
	}
	
	
	
}
