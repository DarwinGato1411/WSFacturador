package com.ec.deckxel.util.json;

public class Status {

	private String codigo;
	private String status;
	private String descripcion;
	private String entidad;

	public Status() {
		super();

	}

	public Status(String codigo, String status, String descripcion, String entidad) {
		super();
		this.codigo = codigo;
		this.status = status;
		this.descripcion = descripcion;
		this.entidad = entidad;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEntidad() {
		return entidad;
	}

	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}

}
