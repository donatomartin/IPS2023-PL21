package ips2023pl21.service;

import java.awt.Component;
import java.util.List;
import java.util.stream.Collectors;

import ips2023pl21.model.Empleado;
import ips2023pl21.model.activos.Instalacion;
import ips2023pl21.persistence.Persistence;

public class Service22784 {

	private Persistence p = Persistence.getInstance();
	private Instalacion instalacion;
	private Empleado jardinero;
	

	public List<String> getJardineros(String filter) {
		return p.selectJardineros().stream().map(x -> x.toString())
				.filter(x -> x.toLowerCase().contains(filter.toLowerCase())).collect(Collectors.toList());
	}

	public List<String> getInstalaciones(String filter) {
		return p.selectInstalaciones().stream().map(x -> x.toString())
				.filter(x -> x.toLowerCase().contains(filter.toLowerCase())).collect(Collectors.toList());
	}
	
	public void seleccionaJardinero(String jardinero) {
		this.jardinero = p.getEmpleado(Integer.parseInt(jardinero.strip().split(" ")[0]));
	}
	
	public void seleccionaInstalacion(String instalacion) {
		this.instalacion = p.getInstalacion(Integer.parseInt(instalacion.strip().split(" ")[0]));
	}

	public Instalacion getInstalacion() {
		return instalacion;
	}
	
	public Empleado getJardinero() {
		return jardinero;
	}

}
