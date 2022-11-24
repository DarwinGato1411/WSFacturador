package com.ec.deckxel.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
import com.ec.deckxel.entidad.Tipoambiente;
import com.ec.deckxel.modeloionic.FacturaIonic;
import com.ec.deckxel.modeloionic.ParamProducto;
import com.ec.deckxel.repository.DetalleFacturaRepository;
import com.ec.deckxel.repository.FacturaRepository;
import com.ec.deckxel.repository.ProductoRepository;
import com.ec.deckxel.utilidad.PedidoMovil;
import com.ec.deckxel.utilidad.RespuestaProceso;
import com.ec.deckxel.utilidad.Utilidades;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST }, allowedHeaders = "*")
@Api(tags = "Factura", description = "Metodos de factura electronica")
public class FacturaController {

	@Autowired
	private FacturaRepository facturaRepository;
	@Autowired
	private DetalleFacturaRepository detalleFacturaRepository;

	@PersistenceContext
	private EntityManager entityManager;

	public List<Factura> findUltimoSecuencial(Tipoambiente tipoambiente) {
		return entityManager.createQuery(
				"SELECT f FROM Factura f WHERE f.facTipo=:facTipo AND f.facNumero IS NOT NULL AND f.codTipoambiente=:codTipoambiente ORDER BY f.facNumero DESC",
				Factura.class).setParameter("codTipoambiente", tipoambiente).setParameter("facTipo", "FACT")
				.setMaxResults(2).getResultList();
//		   return new Page<>(lsta,12,1);
	}

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

			// INSERTAR CABECERA
			if (factura != null) {
				Factura facturaSave = null;
				if (factura.getFactura()!=null) {
					List<Factura> ultima = findUltimoSecuencial(
							factura.getFactura().getCod_tipoambiente());
					Integer numero = ultima.get(0).getFacNumero() + 1;
					String numeroText = Utilidades.numeroFacturaTexto(numero);
					Factura saveFact=factura.getFactura();
					saveFact.setFacNumero(numero);
					saveFact.setFacNumeroText(numeroText);
					//saveFact.setIdFormaPago(null)
					saveFact.setIdUsuario(factura.getFactura().getCod_tipoambiente().getIdUsuario());
					facturaSave = facturaRepository.save(saveFact);
					
					respuesta = facturaSave;
					
					for (DetalleFactura detalle : factura.getDetalleFactura()) {
						detalle.setIdFactura(facturaSave);
						detalleFacturaRepository.save(detalle);
					}

				}

				
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR catalogues " + e.getMessage());
			httpHeaders.add("STATUS", "0");
			return new ResponseEntity<Factura>(respuesta, httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		httpHeaders.add("STATUS", "1");
		return new ResponseEntity<Factura>(respuesta, httpHeaders, HttpStatus.OK);
	}

	/* modelo datos */
	@RequestMapping(value = "/facturas-modelo/", method = RequestMethod.POST)
	@ApiOperation(tags = "Factura", value = "Lista el modelo de envio de datos ")
	public ResponseEntity<?> modelo(@RequestBody Factura factura) {
		final HttpHeaders httpHeaders = new HttpHeaders();
		FacturaIonic respuesta = new FacturaIonic();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
		httpHeaders.setCacheControl("no-cache, no-store, max-age=120, must-revalidate");
//		httpHeaders.setETag(HttpHeaders.ETAG);
		try {

			Optional<Factura> recuper = facturaRepository.findById(factura.getIdFactura());
			/* CONSULTA EL CATALOGO DE PAISES POR LAS CONSTANTES DEFINIDAS */
			List<DetalleFactura> detalle = (List<DetalleFactura>) detalleFacturaRepository.findByIdFactura(factura);
			FacturaIonic facturaIo = new FacturaIonic();
			facturaIo.setDetalleFactura(detalle);
			facturaIo.setFactura(recuper.get());
			respuesta = facturaIo;
//			respuesta.add(facturaIo);
//			cfgPais = GlobalValue.LISTACFGPAIS;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR catalogues " + e.getMessage());
			httpHeaders.add("STATUS", "0");
			return new ResponseEntity<FacturaIonic>(respuesta, httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		httpHeaders.add("STATUS", "1");
		return new ResponseEntity<FacturaIonic>(respuesta, httpHeaders, HttpStatus.OK);
	}
}
