package com.ec.deckxel.modeloionic;

import java.util.List;

import com.ec.deckxel.entidad.DetalleFactura;
import com.ec.deckxel.entidad.Factura;

public class FacturaIonic {
	private Factura factura;

	private List<DetalleFactura> detalleFactura;

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public FacturaIonic() {
		super();
	}

	public List<DetalleFactura> getDetalleFactura() {
		return detalleFactura;
	}

	public void setDetalleFactura(List<DetalleFactura> detalleFactura) {
		this.detalleFactura = detalleFactura;
	}

}
