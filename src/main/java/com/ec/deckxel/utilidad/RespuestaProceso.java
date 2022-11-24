package com.ec.deckxel.utilidad;

public class RespuestaProceso {
	private String descripcion;
	private String error;
	private String codigo;
	
	public RespuestaProceso() {
		super();
	}

	public RespuestaProceso(String descripcion, String error, String codigo) {
		super();
		this.descripcion = descripcion;
		this.error = error;
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
}
