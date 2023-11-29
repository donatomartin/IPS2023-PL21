package ips2023pl21.util;


import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
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
			String nombre="factura"+tl.getDni()+".pdf";
			PdfWriter.getInstance(document, new FileOutputStream(nombre));
			
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
			document.add(escribirDatosCliente(tl.getNombre(), tl.getDni())); 
			document.add(escribirMotivo()); 
			document.add(esribirDomicilio(tl.getDomicilio()));
			document.add(saltoDeLinea());
			document.add(escribirSeparador());
			document.add(escribirProductos(tl.getSeleccionado()));
			document.add(escribirSeparador());
			document.add(saltoDeLinea());
			document.add(escribirSubtotal(tl.getPrecioTotal()));
			document.add(saltoDeLinea());
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
		@SuppressWarnings("unused")
		String filePath = "/ips2023pl21-local/imagenes/logo.png";
		String dest=System.getProperty("user.dir")+"/imagenes/"+"logo.png";
		Image image= Image.getInstance(dest);
		image.scaleAbsolute(90, 90);
		image.setAlignment(50);
		p.add(image);
		p.setAlignment(Element.ALIGN_JUSTIFIED);
		return p;
	}
	
	private static Paragraph escribirDatosEmpresa() {
		Paragraph p=new Paragraph();
		p.add("Grupo 1 IPS\n");
		p.add("Calle Valdés Salas, 3\n");
		p.add("33007, Oviedo (Asturias)\n");
		p.setAlignment(Element.ALIGN_LEFT);
		Font f=new Font();
		f.setSize(18);
		p.setFont(f);
		p.setAlignment(Element.ALIGN_JUSTIFIED);
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
	
	private static Paragraph escribirDatosCliente(String nombre, String dni) {
		Paragraph p=new Paragraph();
		p.add("Nombre y apellidos: "+nombre+"\n");
		p.add("DNI/NIF: "+dni);
		p.setAlignment(Element.ALIGN_LEFT);
		Font f=new Font();
		f.setSize(20);
		p.setFont(f);
		p.setAlignment(Element.ALIGN_JUSTIFIED);
		return p;
	}
	
	private static Paragraph escribirMotivo() {
		Paragraph p=new Paragraph();
		p.add("Motivo: Venta Merchandising"); 
		p.setAlignment(Element.ALIGN_LEFT);
		Font f=new Font();
		f.setSize(20);
		p.setFont(f);
		p.setAlignment(Element.ALIGN_JUSTIFIED);
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
		Font f=new Font();
		f.setStyle(Font.ITALIC);
		f.setStyle(Font.BOLD);
		p.setFont(f);
		p.setAlignment(Element.ALIGN_JUSTIFIED);
		p.add("Datos del cliente:");
		return p;
	}
	
	private static Paragraph esribirDomicilio(String domicilio) {
		Paragraph p=new Paragraph();
		p.add("Enviar a: " + domicilio);
		p.setAlignment(Element.ALIGN_LEFT);
		p.setAlignment(Element.ALIGN_JUSTIFIED);
		Font f=new Font();
		f.setSize(20);
		p.setFont(f);
		return p;
	}
	
	private static Paragraph escribirSeparador() {
		Paragraph p=new Paragraph();
		p.add("----------------------------------------------------------------------------------------------------------------------------------\n");
		p.setAlignment(Element.ALIGN_JUSTIFIED_ALL); 
		return p;
	}
	
	private static Paragraph escribirProductos(List<Merchandaising> seleccionado) {
		Paragraph p=new Paragraph();
		p.add("Cantidad       Descripción       Precio unitario       Importe\n");
		p.add("----------------------------------------------------------------------------------------------------------------------------------\n");
		for(Merchandaising m:seleccionado) {
			p.add(m.getUnidades()+"                   "+m.getNombre()+"                   "+m.getPrecio()+"\u20ac                 "+m.getPrecioTotalArticulo()+"\u20ac\n");
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
		p.add("Subtotal: "+d+"\u20ac"+"\n");
		p.add("IVA: 21%\n");
		Font f=new Font();
		f.setSize(18);
		p.setFont(f);
		p.setAlignment(Element.ALIGN_RIGHT);
		return p;
	}
	
	private static Element escribirTotal(double d) {
		Paragraph p=new Paragraph();
		double total=d+d*0.21;
		BigDecimal bigDecimal = BigDecimal.valueOf(total);

		// Redondear utilizando el método setScale()
		@SuppressWarnings("deprecation")
		BigDecimal redondeadoBigDecimal = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);

		// Convertir de nuevo a double
		total= redondeadoBigDecimal.doubleValue();
		Font f=new Font();
		f.setSize(18);
		f.setStyle(Font.BOLD);
		p.setFont(f);
		p.setAlignment(Element.ALIGN_RIGHT);
		p.add("TOTAL: "+total+"\u20ac");
		return p;
	}
}
