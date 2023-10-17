package ips2023pl21.tienda;

import java.util.ArrayList;
import java.util.List;

public class TiendaLogica {
	
	List<Merchandaising> merchandaising = new ArrayList<Merchandaising>();
	List<Merchandaising> seleccionado = new ArrayList<Merchandaising>(); 
	double precioTotal;
	int id;
	
	public TiendaLogica() {
		cargarArticulos();
		this.precioTotal = 0;
		this.id = 0;
	}
	
	public List<Merchandaising> getMerchandaising() {
		List<Merchandaising> ret = new ArrayList<Merchandaising>(merchandaising);
		return ret;
	}
	
	public Merchandaising getArticulo(int indice) {
		return merchandaising.get(indice);
	}
	
	public List<Merchandaising> getSeleccionado(){
		List<Merchandaising> ret = new ArrayList<Merchandaising>(seleccionado);
		return ret;
	}
	
	/**
	 * Devuelve el precio total
	 * @return
	 */
	public double getPrecioTotal() {
		return this.precioTotal;
	}
	
	/**
	 * Carga los articulos de la BD
	 */
	public void cargarArticulos() {
//		merchandaising.add(new Merchandaising("Gorra", "Ropa", 10));
//		merchandaising.add(new Merchandaising("Bufanda", "Ropa", 20));
//		merchandaising.add(new Merchandaising("Camiseta", "Ropa", 10));
//		merchandaising.add(new Merchandaising("Taza", "Decoracion", 20));
//		merchandaising.add(new Merchandaising("Balon","Material Deportivo",1000));
		
		List<Merchandaising> articulos = TiendaData.cargarArticulos();

		merchandaising.addAll(articulos);
		
	}
	
	/**
	 * Añade articulos a la cesta 
	 * @param merch
	 * @param unidades
	 */
	public void actualizarArticulosEnCesta(Merchandaising merch, int unidades) {
		Merchandaising merchSeleccionado = null;
		for(Merchandaising m : seleccionado) {
			if(m.getNombre().equals(merch.getNombre())) {
				merchSeleccionado = m;
				merchSeleccionado.actualizarUnidades(unidades);
				
				if(merchSeleccionado.getUnidades() <= 0) {
					
					seleccionado.remove(merchSeleccionado);
					merchSeleccionado.setUnidades(0);
				} 
				break;
			}
		}
		
		if(merchSeleccionado == null) {
			merchSeleccionado = merch;
			merchSeleccionado.actualizarUnidades(unidades);
			seleccionado.add(merchSeleccionado);
		}
		
		
		calcularPrecioTotal();
	}
	
	/**
	 * Vacia la lista de elementos seleccionados
	 */
	public void eliminarSeleccion() {
		for(Merchandaising m : seleccionado) {
			m.setUnidades(0);
		}
		seleccionado.clear();
		calcularPrecioTotal();
	}
	
	/**
	 * Calcula el precio cada vez que se realiza una operacion en la tienda
	 */
	private void calcularPrecioTotal() {
		double precioTotal = 0;
		for(int i = 0; i < seleccionado.size(); i++) {
			precioTotal = precioTotal + seleccionado.get(i).getPrecioTotalArticulo();
		}
		
		this.precioTotal = precioTotal;
	}

	/**
	 * Guarda el precio en la BD
	 */
	public void guardarPrecio() {
		TiendaData.añadirPrecio(id,precioTotal);
		id++;
	}

	
	
}
