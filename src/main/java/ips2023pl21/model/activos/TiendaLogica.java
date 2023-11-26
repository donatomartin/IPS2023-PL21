package ips2023pl21.model.activos;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import ips2023pl21.service.Service21914_16;

public class TiendaLogica {

	
	Service21914_16 service = new Service21914_16();
	List<Merchandaising> merchandaising = new ArrayList<Merchandaising>();
	List<Merchandaising> seleccionado = new ArrayList<Merchandaising>();
	double precioTotal;
	int id;
	boolean descuento;

	public TiendaLogica() {
		cargarArticulos();
		this.precioTotal = 0;
		this.id = 0;
		this.descuento = false;
	}

	public List<Merchandaising> getMerchandaising() {
		List<Merchandaising> ret = new ArrayList<Merchandaising>(merchandaising);
		return ret;
	}

	public Merchandaising getArticulo(int indice) {
		return merchandaising.get(indice);
	}

	public List<Merchandaising> getSeleccionado() {
		List<Merchandaising> ret = new ArrayList<Merchandaising>(seleccionado);
		return ret;
	}

	/**
	 * Devuelve el precio total
	 * 
	 * @return
	 */
	public double getPrecioTotal() {
		calcularPrecioTotal();
		return this.precioTotal;
	}

	/**
	 * Carga los articulos de la BD
	 */
	public void cargarArticulos() {
		List<Merchandaising> articulos = service.cargarArticulos();

		merchandaising.addAll(articulos);

	}

	/**
	 * Añade articulos a la cesta
	 * 
	 * @param merch
	 * @param unidades
	 */
	public void actualizarArticulosEnCesta(Merchandaising merch, int unidades) {
		Merchandaising merchSeleccionado = null;
		for (Merchandaising m : seleccionado) {
			if (m.getId() == merch.getId()) {
				merchSeleccionado = m;
				merchSeleccionado.actualizarUnidades(unidades);

				if (merchSeleccionado.getUnidades() <= 0) {

					seleccionado.remove(merchSeleccionado);
					merchSeleccionado.setUnidades(0);
				}
				break;
			}
		}

		if (merchSeleccionado == null) {
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
		for (Merchandaising m : seleccionado) {
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
		for (int i = 0; i < seleccionado.size(); i++) {
			precioTotal = precioTotal + seleccionado.get(i).getPrecioTotalArticulo();
		}

		if(descuento) {
			if(precioTotal < 1000) {
				precioTotal = precioTotal / 2.0;
			} else {
				precioTotal = precioTotal - 500;
			}
			
		} 
		
		this.precioTotal = precioTotal;
	}

	/**
	 * Guarda el precio en la BD
	 */
	public void guardarPrecio() {
		service.añadirVenta(this);
		//TODO si el ganador aplico el descuento quitar que sea ganador
	}
	
	/**
	 * Aplica el descuento a la compra
	 */
	public void setDescuento(boolean descuento) {
		this.descuento = descuento;
	}

	/**
	 * Devuelve si el abonado es ganador del sorteo
	 * @return
	 */
	public boolean isGanadorSorteo() {
		//TODO conseguir si es ganador del sorteo
		//service.isGanadorSorteo();
		return true;
	}

	/**
	 * Envia el correo
	 * 
	 * @param correo
	 */
	public void enviarCorreo(String correo) throws MessagingException {
		Properties props = configureProperties();

		Session session = configureSession(props);

		Message message = crearMensaje(correo, session);
		
		// Envía el correo
		Transport.send(message);
	}

	private Session configureSession(Properties props) {
		return Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("ips2023L21@outlook.es", "2023-IPS");
			}
		});
	}

	private Properties configureProperties() {
		Properties p = new Properties();

		p.put("mail.smtp.host", "smtp-mail.outlook.com");
		p.put("mail.smtp.port", "587");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.starttls.enable", "true");
		
		
		p.put("mail.smtp.ssl.protocols", "TLSv1.2");
		p.put("mail.smtp.ssl.ciphersuites","TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256");

		return p;

	}

	private Message crearMensaje(String correo, Session session) throws MessagingException{
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress("ips2023L21@outlook.es"));
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(correo));
		message.setSubject("Compra Tienda IPS L21");
		
		String mensajeProductos = "";
		for(Merchandaising m : seleccionado) {
			mensajeProductos =  mensajeProductos + " [" + m.toString() +"]";
		}
		
		message.setText("Usted ha realizado una compra en la tienda de IPS Grupo 2-1 "
				+ "La compra tiene los siguientes productos: "
				+ mensajeProductos + " con un precio total de: " + getPrecioTotal() + "€");

		return message;
	}

}
