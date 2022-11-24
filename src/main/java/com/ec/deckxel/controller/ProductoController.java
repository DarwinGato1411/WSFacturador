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
@Api(tags = "Productos", description = "Metodos de productos")
public class ProductoController {

	@Autowired
	private ProductoRepository productoRepository;
	@Autowired
	private FacturaRepository facturaRepository;
	@Autowired
	private DetalleFacturaRepository detalleFacturaRepository;

	@RequestMapping(value = "/productos/", method = RequestMethod.POST)
	@ApiOperation(tags = "Productos", value = "Lista de productos por empresa")
	public ResponseEntity<List<Producto>> productos(@RequestBody ParamProducto prod) {
		final HttpHeaders httpHeaders = new HttpHeaders();
		List<Producto> respuesta = new ArrayList<>();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
		httpHeaders.setCacheControl("no-cache, no-store, max-age=120, must-revalidate");
//		httpHeaders.setETag(HttpHeaders.ETAG);
		try {

			/* CONSULTA EL CATALOGO DE PAISES POR LAS CONSTANTES DEFINIDAS */
			if (prod.getProdNombre().equals("")) {

				respuesta = (List<Producto>) productoRepository
						.findTop10ByCodTipoambienteCodTipoambiente(prod.getCodTipoambiente());
			} else {
				respuesta = (List<Producto>) productoRepository.findByCodTipoambienteCodTipoambienteAndProdNombreLike(
						prod.getCodTipoambiente(), "%" + prod.getProdNombre() + "%");
			}

//			cfgPais = GlobalValue.LISTACFGPAIS;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR productos " + e.getMessage());
			httpHeaders.add("STATUS", "0");
			return new ResponseEntity<List<Producto>>(respuesta, httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		httpHeaders.add("STATUS", "1");
		return new ResponseEntity<List<Producto>>(respuesta, httpHeaders, HttpStatus.OK);
	}

	@RequestMapping(value = "/productos-crear-editar/", method = RequestMethod.POST)
	@ApiOperation(tags = "Productos", value = "Lista de productos por empresa")
	public ResponseEntity<?> productos(@RequestBody Producto prod) {
		final HttpHeaders httpHeaders = new HttpHeaders();
		Producto respuesta = new Producto();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
		httpHeaders.setCacheControl("no-cache, no-store, max-age=120, must-revalidate");
//		httpHeaders.setETag(HttpHeaders.ETAG);
		try {

			/* CONSULTA EL CATALOGO DE PAISES POR LAS CONSTANTES DEFINIDAS */
			if (prod.getProdNombre().equals("")) {
				respuesta=	productoRepository.save(prod);
			}

//			cfgPais = GlobalValue.LISTACFGPAIS;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR AL CREAR EL PRODUCTO " + e.getMessage());
			httpHeaders.add("STATUS", "0");
			return new ResponseEntity<Producto>(respuesta, httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		httpHeaders.add("STATUS", "1");
		return new ResponseEntity<Producto>(respuesta, httpHeaders, HttpStatus.OK);
	}

	// OBTENER LOS SERVICIOS
	@RequestMapping(value = "/servicios/", method = RequestMethod.POST)
	public ResponseEntity<List<Producto>> servicios(@RequestBody Producto prod) {
		final HttpHeaders httpHeaders = new HttpHeaders();
		List<Producto> respuesta = new ArrayList<>();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
		httpHeaders.setCacheControl("no-cache, no-store, max-age=120, must-revalidate");
//		httpHeaders.setETag(HttpHeaders.ETAG);
		try {

			/* CONSULTA EL CATALOGO DE PAISES POR LAS CONSTANTES DEFINIDAS */
			respuesta = (List<Producto>) productoRepository.findAll();
//			cfgPais = GlobalValue.LISTACFGPAIS;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR catalogues " + e.getMessage());
			httpHeaders.add("STATUS", "0");
			return new ResponseEntity<List<Producto>>(respuesta, httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		httpHeaders.add("STATUS", "1");
		return new ResponseEntity<List<Producto>>(respuesta, httpHeaders, HttpStatus.OK);
	}

//	/* METODO DE PRUEBA PARA GENERAR AUTENTICACION DE PLACE TO PAY */
//	@RequestMapping(value = "/pedido", method = RequestMethod.POST)
//	public ResponseEntity<?> pedido(@RequestBody PedidoMovil pedido) {
//		final HttpHeaders httpHeaders = new HttpHeaders();
//		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
//		RespuestaProceso respuesta = new RespuestaProceso();
//		try {
//			respuesta.setDescripcion(ProductoController.class.getName());
//			respuesta.setError("NO");
//			respuesta.setCodigo(HttpStatus.OK.toString());
//			httpHeaders.add("STATUS", "1");
//			return new ResponseEntity<RespuestaProceso>(respuesta, httpHeaders, HttpStatus.OK);
//		} catch (Exception e) {
//			// TODO: handle exception
//			httpHeaders.add("STATUS", "0");
//			respuesta.setDescripcion(e.getMessage());
//			respuesta.setError("SI");
//			respuesta.setCodigo(HttpStatus.BAD_REQUEST.toString());
//			return new ResponseEntity<RespuestaProceso>(respuesta, httpHeaders, HttpStatus.OK);
//		}
//	}
//
//	@GetMapping("/pedidomovil")
//	public ResponseEntity<List<PedidoMovil>> pedidomovil() {
//		final HttpHeaders httpHeaders = new HttpHeaders();
//		List<PedidoMovil> respuesta = new ArrayList<>();
//		httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
//		httpHeaders.setCacheControl("no-cache, no-store, max-age=120, must-revalidate");
////		httpHeaders.setETag(HttpHeaders.ETAG);
//		try {
//			Factura factura = ((List<Factura>) facturaRepository.findAll()).get(0);
//			List<DetalleFactura> detalle = detalleFacturaRepository.findByIdFactura(factura);
//			/* CONSULTA EL CATALOGO DE PAISES POR LAS CONSTANTES DEFINIDAS */
//			PedidoMovil nuevoPedido = new PedidoMovil();
//			nuevoPedido.setFactura(factura);
//			nuevoPedido.setDetalleFactura(detalle);
//			respuesta.add(nuevoPedido);
////			cfgPais = GlobalValue.LISTACFGPAIS;
//			httpHeaders.add("STATUS", "1");
//			return new ResponseEntity<List<PedidoMovil>>(respuesta, httpHeaders, HttpStatus.OK);
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println("ERROR catalogues " + e.getMessage());
//			httpHeaders.add("STATUS", "0");
//			return new ResponseEntity<List<PedidoMovil>>(respuesta, httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//
//	}

}
