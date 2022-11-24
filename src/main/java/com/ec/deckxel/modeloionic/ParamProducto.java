package com.ec.deckxel.modeloionic;

import java.io.Serializable;

public class ParamProducto  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String prodNombre;
	private Integer codTipoambiente;

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

}
