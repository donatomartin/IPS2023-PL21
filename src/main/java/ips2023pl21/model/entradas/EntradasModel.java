package ips2023pl21.model.entradas;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ips2023pl21.persistence.Persistence;
import ips2023pl21.util.Util;

public class EntradasModel {
	
	
	private int asientoInicial=-1;
	private int fila;
	private Persistence p=Persistence.getInstance();
	
	@SuppressWarnings("deprecation")
	public boolean comprarEntradas(String tribuna, String seccion, int numeroEntradas) {
		//no voy a validar los parametros porque habrá solo las opciones correctas en la ventana
		
		
		fila=elegirFila(tribuna, seccion, numeroEntradas);
		
		if(fila==-1) {
			return false;
		}else {
			
			//insertar entrada
			for(int i=0;i<numeroEntradas;i++) {
				Date date=new Date();
				p.insertarEntrada(tribuna, seccion, fila, asientoInicial, 30);
				String dateSql=Util.dateToIsoString(date);
				p.insertarVenta("entrada",dateSql, date.getHours(), date.getMinutes(),30);
				asientoInicial++;
				
			}
		return true;
		}
	}

	private int elegirFila(String tribuna, String seccion, int numeroEntradas) {
		for(int i=0;i<10;i++) { //recorre las filas para una tribuna y seccion dada
			asientoInicial=-1;
			List<EntradaEntity> asientosOcupados=getTotalEntradas(tribuna, seccion, i);
			List<EntradaEntity> abonos=getAbonosFila(tribuna, seccion, i);
			int asientosOcupadosFila=asientosOcupados.size()+abonos.size();
			if(asientosOcupadosFila==0) { 
				asientoInicial=0;
				return i;
			}
			if(15-asientosOcupadosFila>=numeroEntradas) {//si 15-número de asientos ocupados
				//es mayor que los asientos que quiero-> hay asientos disponibles, pero puede que no sean contiguos
				List<EntradaEntity> asientosOcupadosEntradasYAbonos=getTodosAsientos(asientosOcupados, abonos);
				int asiento=disponibilidadAsiento(asientosOcupadosFila, asientosOcupadosEntradasYAbonos, numeroEntradas);
				if(asiento !=-1) {
					asientoInicial=asiento;
					return i;
				}
			}
				 
		}
		return -1;
	}

	private List<EntradaEntity> getTodosAsientos(List<EntradaEntity> asientosOcupados, List<EntradaEntity> abonos) {
		List<EntradaEntity>result=new ArrayList<EntradaEntity>();
		for(EntradaEntity e:asientosOcupados) {
			result.add(e);
		}
		for(EntradaEntity e:abonos) {
			result.add(e);
		}
		return result;
	}

	private int disponibilidadAsiento(int asientosOcupadosFila, List<EntradaEntity> asientosOcupados, int numeroEntradas ) {
		int count=0;
		boolean result=true;
		for(int j=0;j<15;j++) { //recorro los asientos de cada fila
			for(int k=0;k<asientosOcupadosFila;k++) { //recorro los asientos ocupados
				if(asientosOcupados.get(k).getAsiento()==j) {//si el asiento ocupado != el asiento que quiero
					result=false;
					count=0;
					break;
			}}
				if(result) {
					count++;
					if(count==numeroEntradas) {
						return j-numeroEntradas+1; //devuelvo el asiento final-el numero de entradas=inicio de los asientos
					}
			}
				result=true;
		
	}
		return -1;
}
		

	private List<EntradaEntity> getTotalEntradas(String tribuna, String seccion, int fila) {
		return p.getTotalEntradas(tribuna, seccion, fila);
	}

	public int getFila() {
		return fila;
	}

	public int getAsientoInicial() {
		return asientoInicial;
	}

	public List<EntradaEntity> getAbonosFila(String tribuna, String seccion, int fila) {
		return p.getAbonosFila(tribuna, seccion, fila);
	}
	

}
