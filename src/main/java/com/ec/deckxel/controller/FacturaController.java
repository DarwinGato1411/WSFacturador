package com.ec.deckxel.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ec.deckxel.entidad.DetalleFactura;
import com.ec.deckxel.entidad.EstadoFacturas;
import com.ec.deckxel.entidad.Factura;
import com.ec.deckxel.entidad.FormaPago;
import com.ec.deckxel.entidad.Tipoambiente;
import com.ec.deckxel.modeloionic.FacturaIonic;
import com.ec.deckxel.modeloionic.ParamProducto;
import com.ec.deckxel.repository.DetalleFacturaRepository;
import com.ec.deckxel.repository.EstadoFacturaRepository;
import com.ec.deckxel.repository.FacturaRepository;
import com.ec.deckxel.repository.FormaPagoRepository;
import com.ec.deckxel.repository.TipoAmbienteRepository;
import com.ec.deckxel.util.json.Status;
import com.ec.deckxel.utilidad.ParamEnvioFactura;
import com.ec.deckxel.utilidad.RespuestaDocumentos;
import com.ec.deckxel.utilidad.Utilidades;

import com.google.gson.Gson;

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
	@Autowired
	private FormaPagoRepository formaPagoRepository;
	@Autowired
	private TipoAmbienteRepository tipoAmbienteRepository;

	@Autowired
	private EstadoFacturaRepository estadoFacturaRepository;

	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Value("${deckxel.url.factura}")
	String SERVICIOWEBURL;
	

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
			Calendar calendar = Calendar.getInstance();
			String pattern = "yyyy/MM/dd";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			calendar.setTime(prod.getInicio()); // Configuramos la fecha que se recibe

			calendar.add(Calendar.DAY_OF_YEAR, 1);
			String fechaInicio = simpleDateFormat.format(calendar.getTime());

			calendar.setTime(prod.getFin()); // Configuramos la fecha que se recibe

			calendar.add(Calendar.DAY_OF_YEAR, 1);
			String fechaFin = simpleDateFormat.format(calendar.getTime());

			/* CONSULTA EL CATALOGO DE PAISES POR LAS CONSTANTES DEFINIDAS */
			respuesta = (List<Factura>) facturaRepository.findByCodTipoambienteCodTipoambienteAndFacNumeroTextLike(
					prod.getCodTipoambiente(), "%" + prod.getProdNombre() + "%", simpleDateFormat.parse(fechaInicio),
					simpleDateFormat.parse(fechaFin));
//			cfgPais = GlobalValue.LISTACFGPAIS;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR FACTURA " + e.getMessage());
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
			Tipoambiente tipoambineteRecup = null;
			// INSERTAR CABECERA
			if (factura != null) {
				Factura facturaSave = null;
				if (factura.getFactura() != null) {
					List<Factura> ultima = findUltimoSecuencial(factura.getFactura().getCod_tipoambiente());
					Optional<Tipoambiente> optionalTipoAm = tipoAmbienteRepository
							.findById(factura.getFactura().getCod_tipoambiente().getCodTipoambiente());
					if (optionalTipoAm.isPresent()) {

						tipoambineteRecup = optionalTipoAm.get();

					} else {
						return new ResponseEntity<Status>(new Status(HttpStatus.BAD_REQUEST.toString(), "ERROR",
								"Ecurrio un error al crear la factura revise su información", Factura.class.toString()),
								httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
					}

					Integer numero = ultima.get(0).getFacNumero() + 1;
					String numeroText = Utilidades.numeroFacturaTexto(numero);
					Factura saveFact = factura.getFactura();
					saveFact.setFacNumero(numero);
					saveFact.setFacNumeroText(numeroText);
					saveFact.setEstadosri("PENDIENTE");
					FormaPago formaPago = formaPagoRepository.findByIsprincipal(Boolean.TRUE);
					saveFact.setIdFormaPago(formaPago);
					EstadoFacturas estadoFacturas = estadoFacturaRepository.findByIsprincipal(Boolean.TRUE);
//					saveFact.setIdUsuario(factura.getFactura().getIdUsuario());
					saveFact.setIdEstado(estadoFacturas);
					/* GENERAR CLAVE DE ACCESO */

					String claveAcceso = Utilidades.generaClave(saveFact.getFacFecha(), "01",
							tipoambineteRecup.getAmRuc(), tipoambineteRecup.getAmCodigo(),
							tipoambineteRecup.getAmEstab() + tipoambineteRecup.getAmPtoemi(),
							saveFact.getFacNumeroText(), "12345678", "1");
					saveFact.setFacClaveAcceso(claveAcceso);
					saveFact.setFacClaveAutorizacion(claveAcceso);
					saveFact.setFacFechaCobroPlazo(new Date());
					saveFact.setIdUsuario(tipoambineteRecup.getIdUsuario());
					facturaSave = facturaRepository.save(saveFact);

					for (DetalleFactura detalle : factura.getDetalleFactura()) {
						detalle.setIdFactura(facturaSave);
						detalleFacturaRepository.save(detalle);
					}
					respuesta = facturaSave;

				}

			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR AL CREAR LA FACTURA " + e.getMessage());
			httpHeaders.add("STATUS", "0");

			return new ResponseEntity<Status>(
					new Status(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "ERROR",
							"Ecurrio un error al crear la factura revise su información", Factura.class.toString()),
					httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
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
	
	
	
	/* modelo datos */
	@RequestMapping(value = "/facturas-enviar/", method = RequestMethod.POST)
	@ApiOperation(tags = "Factura", value = "Envia factura al SRI ")
	public ResponseEntity<?> envioFacturas(@RequestBody ParamEnvioFactura factura) {
		final HttpHeaders httpHeaders = new HttpHeaders();
		FacturaIonic respuesta = new FacturaIonic();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
		httpHeaders.setCacheControl("no-cache, no-store, max-age=120, must-revalidate");
//		httpHeaders.setETag(HttpHeaders.ETAG);
		try {

			String URLWEBSER=SERVICIOWEBURL + factura.getTipoambiente()+"//"+factura.getNumero();
			RestTemplate restTemplate = new RestTemplate();
			RespuestaDocumentos respueta = restTemplate.getForObject(URLWEBSER,
					RespuestaDocumentos.class);
			Gson gson = new Gson();
			String JSON = gson.toJson(respueta);
			System.out.println("RESPUESTA REENVIO FACTURA" + JSON);
			httpHeaders.add("STATUS", "1");
			return new ResponseEntity<RespuestaDocumentos>(respueta, httpHeaders, HttpStatus.OK);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR catalogues " + e.getMessage());
			httpHeaders.add("STATUS", "0");
			return new ResponseEntity<FacturaIonic>(respuesta, httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
		}
//		httpHeaders.add("STATUS", "1");
//		return new ResponseEntity<FacturaIonic>(respuesta, httpHeaders, HttpStatus.OK);
	}
}
