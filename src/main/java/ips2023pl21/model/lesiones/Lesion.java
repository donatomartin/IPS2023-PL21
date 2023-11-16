package ips2023pl21.model.lesiones;

public class Lesion {
	
	private Integer id;
	private int eqid;
	private int eid;
	private String causa;
	private int pid;
	private int enid;
	private String descripcion;
	private String fecha;
	private String tipo;
	
	public Lesion() {}

	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public int getEqid() {
		return eqid;
	}

	public void setEqid(int eqid) {
		this.eqid = eqid;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getCausa() {
		return causa;
	}

	public void setCausa(String causa) {
		this.causa = causa;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getEnid() {
		return enid;
	}

	public void setEnid(int enid) {
		this.enid = enid;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	

}
