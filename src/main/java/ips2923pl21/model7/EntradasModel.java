package ips2923pl21.model7;

import java.util.Date;
import java.util.List;

import ip2023pl21.util.Database;
import ip2023pl21.util.Util;

public class EntradasModel {
	
	private Database db=new Database();
	private int asientoInicial=-1;
	private int fila;
	
	public boolean comprarEntradas(String tribuna, String seccion, int numeroEntradas) {
		//no voy a validar los parametros porque habra solo las opciones correctas en la ventana
		
		String queryEntrada="Insert into Entrada(tribuna, seccion, fila, asiento, precio) VALUES (?,?,?,?,?)";
		String queryVenta="Insert into Venta(concepto, fecha, hora, minuto, cuantia) VALUES"
				+ "(?,?,?,?,?)";
		fila=elegirFila(tribuna, seccion, numeroEntradas);
		
		if(fila==-1) {
			return false;
		}else {
			
			//insertar entrada
			for(int i=0;i<numeroEntradas;i++) {
				Date date=new Date();
				db.executeUpdate(queryEntrada, tribuna, seccion, fila, asientoInicial, 30);
				String dateSql=Util.dateToIsoString(date);
//				System.out.println(dateSql);
				db.executeUpdate(queryVenta,"entrada", dateSql,date.getHours(),date.getMinutes(),30);
//				System.out.println("horas: "+date.getHours()+ " minutos: "+date.getMinutes());
//				System.out.println("Entrada insertada: "+tribuna+seccion+fila+asientoInicial);
				asientoInicial++;
				
			}
			//asientoInicial=-1;
			return true;
		}
		//return false;
	}

	private int elegirFila(String tribuna, String seccion, int numeroEntradas) {
		for(int i=0;i<10;i++) { //recorre las filas para una tribuna y seccion dada
			asientoInicial=-1;
			List<EntradaEntity> asientosOcupados=getTotalEntradas(tribuna, seccion, i);
			int asientosOcupadosFila=asientosOcupados.size();
			if(asientosOcupadosFila==0) { 
				//System.out.println(asientosOcupadosFila);
				asientoInicial=0;
				return i;
			}
//			System.out.println(asientosOcupadosFila);
			if(15-asientosOcupadosFila>=numeroEntradas) {//si 15-número de asientos ocupados
				//es mayor que los asientos que quiero-> hay asientos disponibles, pero puede que no sean contiguos
				int asiento=disponibilidadAsiento(asientosOcupadosFila, asientosOcupados, numeroEntradas);
				if(asiento !=-1) {
					asientoInicial=asiento;
					return i;
				}
			}
				 
		}
		return -1;
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
		String query="SELECT * FROM entrada where tribuna=? and seccion=? and fila=?";
		return db.executeQueryPojo(EntradaEntity.class,query, tribuna, seccion, fila);
	}

	public int getFila() {
		return fila;
	}

	public int getAsientoInicial() {
		return asientoInicial;
	}

	

}
