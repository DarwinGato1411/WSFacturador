package com.ec.deckxel.modeloionic;

import java.io.Serializable;
import java.util.Date;

public class ParamProducto  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String prodNombre;
	private Integer codTipoambiente;
	private Date inicio;
	private Date fin;

	public String getProdNombre() {
		return prodNombre;
	}

	public void setProdNombre(String prodNombre) {
		this.prodNombre = prodNombre;
	}

	public Integer getCodTipoambiente() {
		return codTipoambiente;
	}

	public void setCodTipoambiente(Integer codTipoambiente) {
		this.codTipoambiente = codTipoambiente;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFin() {
		return fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}
	
	

}
