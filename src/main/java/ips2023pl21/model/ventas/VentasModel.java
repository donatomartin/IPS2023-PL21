package ips2023pl21.model.ventas;

import java.util.Date;
import java.util.List;


import ips2023pl21.util.Database;
import ips2023pl21.util.Util;

public class VentasModel {
	
	private Database db=new Database();
	
//	public VentasModel() {
//		db.createDatabase(false);
//		db.loadDatabase();
//	}

	public List<VentaDisplayDTO> getVentas(Date fechaInicial, Date fechaFinal){
		String dateInicial=Util.dateToIsoString(fechaInicial);
		String dateFinal=Util.dateToIsoString(fechaFinal);
		String query="SELECT id, concepto, fecha, hora, minuto, cuantia from venta where fecha>=? and fecha<=?";
		return db.executeQueryPojo(VentaDisplayDTO.class,query,dateInicial,dateFinal);
//		for(VentaDisplayDTO d : ventas) {
//			System.out.println("venta: "+ d.getConcepto());
//		}
//		return ventas;
	}

	public VentaMerchandisingDisplayDto getVenta(int idVenta) {
		String query="SELECT id, producto, unidades, precioPorProducto, cuantia from ventaMerchandising where id=?";
		List<VentaMerchandisingDisplayDto> ventas=db.executeQueryPojo(VentaMerchandisingDisplayDto.class, query, idVenta);
		//validateCondition(!ventas.isEmpty(),"Id de venta no encontrado: "+idVenta);
		if(ventas.isEmpty()) {
			return null;
		}
		return ventas.get(0);
	}
	
	public double getIngresosTotales(List<VentaDisplayDTO> ventas) {
		double total=0;
		for(VentaDisplayDTO v:ventas) {
			total+=v.getCuantia();
		}
		return total;
	}
	public List<VentaDisplayDTO> getTotalVentas() {
		String query="SELECT  id, concepto, fecha, hora, minuto, cuantia from venta";
		return db.executeQueryPojo(VentaDisplayDTO.class, query);
	}

}
