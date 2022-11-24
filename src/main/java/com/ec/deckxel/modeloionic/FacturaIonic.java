package com.ec.deckxel.modeloionic;

import com.ec.deckxel.entidad.DetalleFactura;
import com.ec.deckxel.entidad.Factura;

public class FacturaIonic {
	private Factura factura;
	private DetalleFactura detalleFactura;

	public FacturaIonic() {
		super();
	}

	public FacturaIonic(Factura factura, DetalleFactura detalleFactura) {
		super();
		this.factura = factura;
		this.detalleFactura = detalleFactura;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public DetalleFactura getDetalleFactura() {
		return detalleFactura;
	}

	public void setDetalleFactura(DetalleFactura detalleFactura) {
		this.detalleFactura = detalleFactura;
	}

}
