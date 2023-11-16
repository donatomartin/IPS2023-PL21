package ips2023pl21.util;


import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.List;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import ips2023pl21.model.activos.Merchandaising;
import ips2023pl21.model.activos.TiendaLogica;


public class PDFGenerator {
	private static int numeroSerie=0;
	private static String IdFiscal="A1234567A";
	
	public static void generarPDF(TiendaLogica tl) {
		//1.Crear documento
		Document document=new Document();
		
		try {
			//2.Crear el escritor de PDF
			PdfWriter.getInstance(document, new FileOutputStream("factura.pdf"));
			
			//3.Abrir documento
			document.open();
			
			//4.Escribir
			document.add(escribirTitulo());
			document.add(escribirDatosEmpresa());
			document.add(escribirNumeroSerie());
			document.add(fechaExpedicion());
			document.add(escribirIdFiscal());
			document.add(saltoDeLinea());
			document.add(tituloDatosCliente());
			document.add(escribirNombreApellido(tl.getNombre())); 
			document.add(escribirMotivo()); 
			document.add(esribirDomicilio(tl.getDomicilio()));
			document.add(escribirProductos(tl.getSeleccionado()));
			document.add(escribirSubtotal(tl.getPrecioTotal()));
			document.add(escribirTotal(tl.getPrecioTotal()));
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			numeroSerie++;
			document.close();
		}
		
	}



	private static Paragraph escribirTitulo() throws BadElementException, MalformedURLException, IOException {
		Paragraph p=new Paragraph();
		p.setAlignment(Element.ALIGN_LEFT);
		Font f=new Font();
		f.setStyle(Font.BOLD);
		f.setSize(40);
		p.setFont(f);
		p.add("FACTURA");
		String filePath = "/ips2023pl21-local/imagenes/logo.png";
		String dest=System.getProperty("user.dir")+"/imagenes/"+"logo.png";
		Image image= Image.getInstance(dest);
		image.scaleAbsolute(80, 80);
		image.setAlignment(50);
		p.add(image);
		return p;
	}
	
//	private static Image insertarFoto() throws BadElementException, MalformedURLException, IOException  {
////		String imageFile = "/ips2023pl21-local/imagenes/logo.png"; 
////		String dest=System.getProperty("user.dir")+"/imagenes/"+"logo.png";
////		Image imagen = new Image(ImageDataFactory.create(dest));
////		return imagen;
//		 String filePath = "/ips2023pl21-local/imagenes/logo.png";
//		 String dest=System.getProperty("user.dir")+"/imagenes/"+"logo.png";
//		Image image= Image.getInstance(dest);
//		image.scaleAbsolute(90, 90);
//		image.setAlignment(50);
//		return image;
//		
//	}
	
	private static Paragraph escribirDatosEmpresa() {
		Paragraph p=new Paragraph();
		p.add("Grupo 1 IPS\n");
		p.add("Calle Valdés Salas, 3\n");
		p.add("33007, Oviedo (Asturias)\n");
		p.setAlignment(Element.ALIGN_LEFT);
		Font f=new Font();
		f.setSize(18);
		p.setFont(f);
		return p;
	}

	private static Paragraph escribirNumeroSerie() {
		Paragraph p=new Paragraph();
		p.add("Número de serie: "+numeroSerie);
		p.setAlignment(Element.ALIGN_RIGHT);
		Font f=new Font();
		f.setSize(18);
		p.setFont(f);
		return p;
	}
	
	private static Paragraph fechaExpedicion() {
		Paragraph p=new Paragraph();
		p.add("Fecha de expedición: "+Util.dateToIsoString(new Date()));
		p.setAlignment(Element.ALIGN_RIGHT);
		Font f=new Font();
		f.setSize(18);
		p.setFont(f);
		return p;
	}
	
	private static Paragraph escribirNombreApellido(String nombre) {
		Paragraph p=new Paragraph();
		p.add("Nombre y apellidos: "+nombre);
		p.setAlignment(Element.ALIGN_LEFT);
		Font f=new Font();
		f.setSize(20);
		p.setFont(f);
		return p;
	}
	
	private static Paragraph escribirMotivo() {
		Paragraph p=new Paragraph();
		p.add("Motivo: Venta Merchandising"); 
		p.setAlignment(Element.ALIGN_LEFT);
		Font f=new Font();
		f.setSize(20);
		p.setFont(f);
		return p;
	}
	
	private static Paragraph escribirIdFiscal() {
		Paragraph p=new Paragraph();
		p.add("Número de identificación fiscal: " + IdFiscal);
		p.setAlignment(Element.ALIGN_RIGHT);
		Font f=new Font();
		f.setSize(20);
		p.setFont(f);
		return p;
	}
	

	private static Paragraph saltoDeLinea() {
		Paragraph p=new Paragraph();
		p.add("\n");
		return p;
	}
	
	private static Element tituloDatosCliente() {
		Paragraph p=new Paragraph();
		p.add("Datos del cliente:");
		Font f=new Font();
		f.setFamily("Courier");
		f.setStyle("bold");
		return p;
	}
	
	private static Paragraph esribirDomicilio(String domicilio) {
		Paragraph p=new Paragraph();
		p.add("Enviar a: " + domicilio);
		p.setAlignment(Element.ALIGN_LEFT);
		Font f=new Font();
		f.setSize(20);
		p.setFont(f);
		return p;
	}
	
	private static Paragraph escribirProductos(List<Merchandaising> seleccionado) {
		Paragraph p=new Paragraph();
		p.add("----------------------------------------------------------------------------------------------------------------------------------\n");
		p.add("Cantidad       Descripción       Precio unitario       Importe\n");
		p.add("----------------------------------------------------------------------------------------------------------------------------------\n");
		for(Merchandaising m:seleccionado) {
			p.add(m.getUnidades()+"                   "+m.getNombre()+"                   "+m.getPrecio()+"                 "+m.getPrecioTotalArticulo()+"\n");
		}
		p.setAlignment(Element.ALIGN_LEFT);
		p.setAlignment(Element.ALIGN_JUSTIFIED_ALL); 
		Font f=new Font();
		f.setSize(20);
		f.setColor(BaseColor.RED);
		p.setFont(f);
		return p;
	}
	
	private static Paragraph escribirSubtotal(double d) {
		Paragraph p=new Paragraph();
		p.add("Subtotal: "+d+"\n");
		p.add("IVA: 21%\n");
		Font f=new Font();
		f.setSize(18);
		p.setFont(f);
		p.setAlignment(Element.ALIGN_RIGHT);
		return p;
	}
	
	private static Element escribirTotal(double d) {
		Paragraph p=new Paragraph();
		p.add("TOTAL: "+d+d*0.21);
		Font f=new Font();
		f.setSize(18);
		p.setFont(f);
		p.setAlignment(Element.ALIGN_RIGHT);
		return p;
	}
}
