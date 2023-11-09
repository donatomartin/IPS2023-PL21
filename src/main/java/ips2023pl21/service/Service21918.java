package ips2023pl21.service;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import ips2023pl21.model.activos.Merchandaising;
import ips2023pl21.model.ventas.VentaDisplayDTO;
import ips2023pl21.model.ventas.VentaMerchandisingDisplayDto;
import ips2023pl21.model.ventas.VentasDetalleDisplayDTO;
import ips2023pl21.model.ventas.VentasModel;
import ips2023pl21.ui.Frame21918;
import ips2023pl21.util.SwingUtil;
import ips2023pl21.util.Util;



public class Service21918 {
	private Frame21918 view;
	private VentasModel model;
	private String lastSelectedKey="";
//	private Persistence p=Persistence.getInstance();
	
	public Service21918(Frame21918 view, VentasModel model) {
		this.view = view;
		this.model = model;
		this.initView();
	}

	private void initView() {
		view.getFrame().setVisible(true);
		initController();
		view.getTxFieldFechaInicial().setText(Util.dateToIsoString(new Date()));
		view.getTxFieldFechaFinal().setText(Util.dateToIsoString(new Date()));
	}

	private void initController() {
		view.getBtVerVentas().addActionListener(e -> SwingUtil.exceptionWrapper(() -> getVentas()));
		view.getBtCancelar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> cancelar()));
		view.getBtTodasVentas().addActionListener(e -> SwingUtil.exceptionWrapper(() -> getTotalVentas())); 
		//para detectar la selección de una fila:
		view.getTableVentas().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				SwingUtil.exceptionWrapper(() -> updateDetail());
			}
		});
		
	}

	private void getTotalVentas() {
		List<VentaDisplayDTO> ventas=model.getTotalVentas();
		view.getTableVentas().setModel(setModel(ventas));
		calcularIngresosTotales(ventas);
		SwingUtil.autoAdjustColumns(view.getTableVentas());
		this.restoreDetail();
	}

	private TableModel setModel(List<VentaDisplayDTO> ventas) {
		return SwingUtil.getTableModelFromPojos(ventas, new String[] {"id","concepto", "fecha", "hora", "minuto", 
		"cuantia"});
		
	}

	private void getVentas() {
		List<VentaDisplayDTO> ventas=model.getVentas(Util.isoStringToDate(view.getFechaInicial()),
				Util.isoStringToDate(view.getFechaFinal()));
		view.getTableVentas().setModel(setModel(ventas));
		calcularIngresosTotales(ventas);
		SwingUtil.autoAdjustColumns(view.getTableVentas());
		this.restoreDetail();
		}
	
	private void calcularIngresosTotales(List<VentaDisplayDTO> ventas) {
		double total=model.getIngresosTotales(ventas);
		view.getTxFieldIngresosTotales().setText(String.valueOf(total)+"\u20ac");
		
	}

	private void restoreDetail() {
		//Utiliza la ultimo valor de la clave (que se reiniciara si ya no existe en la tabla)
		this.lastSelectedKey=SwingUtil.selectAndGetSelectedKey(view.getTableVentas(), this.lastSelectedKey);
			//Si hay clave para seleccionar en la tabla muestra el detalle, si no, lo reinicia
			if ("".equals(this.lastSelectedKey)) { 
				view.getTableDetalles().setModel(new DefaultTableModel());		
				} else {
					this.updateDetail();
				}

		
	}

	private void cancelar() {
		view.getFrame().dispose();
	}
	
	public void updateDetail() {
		this.lastSelectedKey=SwingUtil.getSelectedKey(view.getTableVentas());
		int idVenta=Integer.parseInt(this.lastSelectedKey);
		
		//Detalles de la venta seleccionada
		
		List<VentaMerchandisingDisplayDto> ventas=model.getVentasMerchandising(idVenta); 

		if(ventas==null ||ventas.size()==0) {
			view.getTableDetalles().setModel(new DefaultTableModel());
		}else {
			List<VentasDetalleDisplayDTO>merch=convertitADisplay(ventas);
			if(merch==null ||merch.size()==0) {
				view.getTableDetalles().setModel(new DefaultTableModel());
			}else{
					TableModel tmodel=SwingUtil.getTableModelFromPojos(merch, new String[] {"id", "nombre",
				
					"unidades","precioPorProducto", "total"}); 
			view.getTableDetalles().setModel(tmodel);
			SwingUtil.autoAdjustColumns(view.getTableDetalles());
		}
			}
		}
	
	

	private List<VentasDetalleDisplayDTO> convertitADisplay(List<VentaMerchandisingDisplayDto> ventas) {
		//para devolver los prodcutos de cada venta
		List<VentasDetalleDisplayDTO>result=new ArrayList<VentasDetalleDisplayDTO>();
		for(VentaMerchandisingDisplayDto v:ventas) {
			List<Merchandaising>producto=model.getProducto(v.getIdProducto());
			if(producto.isEmpty()) {
				break;
			}else {
				VentasDetalleDisplayDTO detalle=new VentasDetalleDisplayDTO();
				detalle.setId(v.getId());
				detalle.setNombre(producto.get(0).getNombre());
				detalle.setPrecioPorProducto(producto.get(0).getPrecio());
				detalle.setTotal(producto.get(0).getPrecio()*v.getCantidad()); //cantidad=unidades
				detalle.setUnidades(v.getCantidad());
				result.add(detalle);
			}
//				v.setNombreProducto(producto.get(0).getNombre());
//				v.set
//				v.setPrecioPorProducto(producto.get(0).getPrecio());
			}
			return result;
		}
		
	}


