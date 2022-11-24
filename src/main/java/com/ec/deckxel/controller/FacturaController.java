package com.ec.deckxel.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ec.deckxel.entidad.DetalleFactura;
import com.ec.deckxel.entidad.Factura;
import com.ec.deckxel.entidad.Producto;
import com.ec.deckxel.modeloionic.FacturaIonic;
import com.ec.deckxel.modeloionic.ParamProducto;
import com.ec.deckxel.repository.DetalleFacturaRepository;
import com.ec.deckxel.repository.FacturaRepository;
import com.ec.deckxel.repository.ProductoRepository;
import com.ec.deckxel.utilidad.PedidoMovil;
import com.ec.deckxel.utilidad.RespuestaProceso;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST }, allowedHeaders = "*")
@Api(tags = "Factura", description = "Metodos de factura electronica")
public class FacturaController {

	@Autowired
	private FacturaRepository facturaRepository;

	@RequestMapping(value = "/facturas/", method = RequestMethod.POST)
	@ApiOperation(tags = "Factura", value = "Lista de facturas por empresa")
	public ResponseEntity<?> productos(@RequestBody ParamProducto prod) {
		final HttpHeaders httpHeaders = new HttpHeaders();
		List<Factura> respuesta = new ArrayList<>();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
		httpHeaders.setCacheControl("no-cache, no-store, max-age=120, must-revalidate");
//		httpHeaders.setETag(HttpHeaders.ETAG);
		try {

			/* CONSULTA EL CATALOGO DE PAISES POR LAS CONSTANTES DEFINIDAS */
			respuesta = (List<Factura>) facturaRepository.findByCodTipoambienteCodTipoambienteAndFacNumeroTextLike(
					prod.getCodTipoambiente(), "%" + prod.getProdNombre() + "%");
//			cfgPais = GlobalValue.LISTACFGPAIS;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR catalogues " + e.getMessage());
			httpHeaders.add("STATUS", "0");
			return new ResponseEntity<List<Factura>>(respuesta, httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		httpHeaders.add("STATUS", "1");
		return new ResponseEntity<List<Factura>>(respuesta, httpHeaders, HttpStatus.OK);
	}

	// OBTENER LOS SERVICIOS
	@RequestMapping(value = "/factura-guardar/", method = RequestMethod.POST)
	@ApiOperation(tags = "Factura", value = "Guarda la factura creada ")
	public ResponseEntity<?> servicios(@RequestBody FacturaIonic factura) {
		final HttpHeaders httpHeaders = new HttpHeaders();
		Factura respuesta = new Factura();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
		httpHeaders.setCacheControl("no-cache, no-store, max-age=120, must-revalidate");
//			httpHeaders.setETag(HttpHeaders.ETAG);
		try {

			/* CONSULTA EL CATALOGO DE PAISES POR LAS CONSTANTES DEFINIDAS */
			respuesta = facturaRepository.save(factura.getFactura());
//				cfgPais = GlobalValue.LISTACFGPAIS;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR catalogues " + e.getMessage());
			httpHeaders.add("STATUS", "0");
			return new ResponseEntity<Factura>(respuesta, httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		httpHeaders.add("STATUS", "1");
		return new ResponseEntity<Factura>(respuesta, httpHeaders, HttpStatus.OK);
	}

}
