package com.ec.deckxel.utilidad;

import java.util.List;

public class ModeloGeneralSQLite {

	private ModeloCabeceraSQLite cabecera;
	private List<ModeloPedidoSQLite> detalle;

	public ModeloGeneralSQLite() {
		super();
	}

	public ModeloGeneralSQLite(ModeloCabeceraSQLite cabecera, List<ModeloPedidoSQLite> detalle) {
		super();
		this.cabecera = cabecera;
		this.detalle = detalle;
	}

	public ModeloCabeceraSQLite getCabecera() {
		return cabecera;
	}

	public void setCabecera(ModeloCabeceraSQLite cabecera) {
		this.cabecera = cabecera;
	}

	public List<ModeloPedidoSQLite> getDetalle() {
		return detalle;
	}

	public void setDetalle(List<ModeloPedidoSQLite> detalle) {
		this.detalle = detalle;
	}
	
	

}
