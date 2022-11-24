package com.ec.deckxel.utilidad;

import java.util.List;

import com.ec.deckxel.entidad.DetalleFactura;
import com.ec.deckxel.entidad.Factura;

public class PedidoMovil {
	private Factura factura;
	private List<DetalleFactura> detalleFactura;

	public PedidoMovil() {
		super();
	}

	public PedidoMovil(Factura factura, List<DetalleFactura> detalleFactura) {
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

	public List<DetalleFactura> getDetalleFactura() {
		return detalleFactura;
	}

	public void setDetalleFactura(List<DetalleFactura> detalleFactura) {
		this.detalleFactura = detalleFactura;
	}

}
