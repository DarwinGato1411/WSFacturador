package com.ec.deckxel.utilidad;

public class ModeloPagoPayPhone {
	private String secuencialUnico;
	private String total;
	private String cedula;
	private String movil;

	
	public ModeloPagoPayPhone() {
		super();
	;
	}
	public ModeloPagoPayPhone(String secuencialUnico, String total) {
		super();
		this.secuencialUnico = secuencialUnico;
		this.total = total;
	}

	public String getSecuencialUnico() {
		return secuencialUnico;
	}

	public void setSecuencialUnico(String secuencialUnico) {
		this.secuencialUnico = secuencialUnico;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getMovil() {
		return movil;
	}
	public void setMovil(String movil) {
		this.movil = movil;
	}

}
