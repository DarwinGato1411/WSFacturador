package com.ec.deckxel.utilidad;

public class ParamEnvioFactura {
	private Integer tipoambiente;
	private Integer numero;

	public ParamEnvioFactura(Integer tipoambiente, Integer numero) {
		super();
		this.tipoambiente = tipoambiente;
		this.numero = numero;
	}

	public Integer getTipoambiente() {
		return tipoambiente;
	}

	public void setTipoambiente(Integer tipoambiente) {
		this.tipoambiente = tipoambiente;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

}
