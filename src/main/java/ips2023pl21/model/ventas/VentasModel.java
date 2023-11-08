package ips2023pl21.model.ventas;

import java.util.Date;
import java.util.List;

import ips2023pl21.model.activos.Merchandaising;
import ips2023pl21.util.Database;
import ips2023pl21.util.Util;

public class VentasModel {
	
	private Database db=new Database();
	

	public List<VentaDisplayDTO> getVentas(Date fechaInicial, Date fechaFinal){
		String dateInicial=Util.dateToIsoString(fechaInicial);
		String dateFinal=Util.dateToIsoString(fechaFinal);
		String query="SELECT id, concepto, fecha, hora, minuto, cuantia from venta where fecha>=? and fecha<=?";
		return db.executeQueryPojo(VentaDisplayDTO.class,query,dateInicial,dateFinal);
	}
	
	public List<VentaMerchandisingDisplayDto> getVentasMerchandising(int idVenta) {
		String query="SELECT * from VentaMerchandising where id=?";
		return db.executeQueryPojo(VentaMerchandisingDisplayDto.class, query, idVenta);
		
		
	}
	
	public double getIngresosTotales(List<VentaDisplayDTO> ventas) {
		double total=0;
		for(VentaDisplayDTO v:ventas) {
			total+=v.getCuantia();
		}
		return total;
	}
	public List<VentaDisplayDTO> getTotalVentas() {
		String query="SELECT * from venta";
		return db.executeQueryPojo(VentaDisplayDTO.class, query);
	}
	
	//merch
		public List<Merchandaising> getProducto (int id){
			return db.executeQueryPojo(Merchandaising.class, "select * from merchandaising where id=?", id);
		}

}
