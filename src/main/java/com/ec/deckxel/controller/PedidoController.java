package com.ec.deckxel.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ec.deckxel.entidad.Cliente;
import com.ec.deckxel.entidad.DetalleFactura;
import com.ec.deckxel.entidad.EstadoFacturas;
import com.ec.deckxel.entidad.Factura;
import com.ec.deckxel.entidad.Tipoadentificacion;
import com.ec.deckxel.entidad.Tipoambiente;
import com.ec.deckxel.entidad.Usuario;
import com.ec.deckxel.repository.ClienteRepository;
import com.ec.deckxel.repository.DetalleFacturaRepository;
import com.ec.deckxel.repository.EstadoFacturaRepository;
import com.ec.deckxel.repository.FacturaRepository;
import com.ec.deckxel.repository.FormaPagoRepository;
import com.ec.deckxel.repository.ProductoRepository;
import com.ec.deckxel.repository.TipoAmbienteRepository;
import com.ec.deckxel.repository.TipoIdentificacionRepository;
import com.ec.deckxel.repository.UsuarioRepository;
import com.ec.deckxel.utilidad.ModeloCabeceraSQLite;
import com.ec.deckxel.utilidad.ModeloGeneralSQLite;
import com.ec.deckxel.utilidad.ModeloPedidoSQLite;
import com.ec.deckxel.utilidad.PedidoMovil;
import com.ec.deckxel.utilidad.RespuestaProceso;
import com.google.gson.Gson;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
public class PedidoController {
//
//	@Autowired
//	private ProductoRepository productoRepository;
//	@Autowired
//	private FacturaRepository facturaRepository;
//	@Autowired
//	private DetalleFacturaRepository detalleFacturaRepository;
//	@Autowired
//	private ClienteRepository clienteRepository;
//	@Autowired
//	private TipoIdentificacionRepository identificacionRepository;
//	@Autowired
//	private EstadoFacturaRepository estadoFacturaRepository;
//	@Autowired
//	private UsuarioRepository usuarioRepository;
//	@Autowired
//	private FormaPagoRepository formaPagoRepository;
//	@Autowired
//	private TipoAmbienteRepository tipoAmbienteRepository;
//
//	private String numeroFacturaText = "";
//    private Integer numeroFactura = 0;
//	
//	@RequestMapping(value = "/registrapedido", method = RequestMethod.POST)
//	public ResponseEntity<?> registrapedido(@RequestBody ModeloGeneralSQLite modelosql) {
//		final HttpHeaders httpHeaders = new HttpHeaders();
//		RespuestaProceso respuesta = new RespuestaProceso();
//		httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
//		httpHeaders.setCacheControl("no-cache, no-store, max-age=120, must-revalidate");
////		httpHeaders.setETag(HttpHeaders.ETAG);
//		
//		Gson gson = new Gson();
//		String JSON = gson.toJson(modelosql);
//		System.out.println(" JSON ENVIO PAYPHONE " + JSON);
//		ModeloCabeceraSQLite modelo = modelosql.getCabecera();
//		try {
//			Cliente cliNuevo = new Cliente();
//			SimpleDateFormat sm = new SimpleDateFormat("yyy-MM-dd");
//			//Date fechaFact = sm.parse(modelo.getCOLUMN_NAME_FECHA());
//			Cliente clirecup = clienteRepository.findByCliCedula(modelo.getCEDULA());
//			if (clirecup == null) {
//				 
//				cliNuevo.setCliCedula(modelo.getCEDULA());
//				cliNuevo.setCiudad("OTAVALO");
//				cliNuevo.setCliNombre(modelo.getNOMBRECLI());
//				cliNuevo.setCliRazonSocial(modelo.getNOMBRECLI());
//				cliNuevo.setCliDireccion(modelo.getDIRECCION());
//				cliNuevo.setCliCorreo(modelo.getCORREO());
//				cliNuevo.setCliMontoAsignado(BigDecimal.valueOf(100000.0));
//				cliNuevo.setCliMovil(modelo.getMOVIL());
//				String nombreApellido[] = modelo.getNOMBRECLI().split(" ");
//				String nombrePersona = "";
//				String apellidoPersona = "";
//				switch (nombreApellido.length) {
//				case 1:
//					nombrePersona = nombreApellido[0];
//					apellidoPersona = "A";
//					break;
//				case 2:
//					nombrePersona = nombreApellido[0];
//					apellidoPersona = nombreApellido[1];
//					break;
//				case 3:
//					nombrePersona = nombreApellido[0] + " " + nombreApellido[1];
//					apellidoPersona = nombreApellido[2];
//					break;
//				case 4:
//					nombrePersona = nombreApellido[0] + " " + nombreApellido[1];
//					apellidoPersona = nombreApellido[2] + " " + nombreApellido[3];
//					break;
//				default:
//					break;
//				}
//				cliNuevo.setCliNombres(nombrePersona);
//				cliNuevo.setCliApellidos(apellidoPersona);
//				cliNuevo.setCliTelefono(modelo.getMOVIL());
//				cliNuevo.setClieFechaRegistro(new Date());
//				cliNuevo.setClietipo(0);
//				Tipoadentificacion tipIdent = null;
//				if (modelo.getCEDULA().length() == 10) {
//					tipIdent = identificacionRepository.findByTidCodigo("05");
//				}
//				if (modelo.getCEDULA().length() == 13) {
//					tipIdent = identificacionRepository.findByTidCodigo("04");
//				}
//				cliNuevo.setIdTipoIdentificacion(tipIdent);
//				clienteRepository.save(cliNuevo);
//			}
//
//			/* CABECERA DE LA FACTURA */
//			BigDecimal subtota = BigDecimal.ZERO;
//			BigDecimal iva = BigDecimal.ZERO;
//			BigDecimal totaFactura = BigDecimal.valueOf(Double.valueOf(modelo.getTOTAL()));
//			subtota = totaFactura.divide(BigDecimal.valueOf(Double.valueOf(1.12)), 2, RoundingMode.FLOOR);
//			iva = totaFactura.subtract(subtota);
//
//			Usuario usuarecup = usuarioRepository.findByIdUsuario(Integer.valueOf(modelo.getCOLUMN_NAME_IDUSUARIO()));
//			Factura nuevacabecera = new Factura();
//			//nuevacabecera.setIdEstado(estadoFacturaRepository.findByEstCodigo("PE"));
//			nuevacabecera.setIdUsuario(usuarecup);
//			nuevacabecera.setFacFecha(new Date());
//			nuevacabecera.setFacEstado("PE");
//			
//			nuevacabecera.setFacNumProforma(numeroFactura(usuarecup));
//			nuevacabecera.setFacNumero(0);
//			nuevacabecera.setFacNumeroText("000000000");
//			
//			if (clirecup != null) {
//				nuevacabecera.setIdCliente(clirecup);
//			} else {
//				nuevacabecera.setIdCliente(cliNuevo);
//			}
//
//			nuevacabecera.setFacSaldoAmortizado(BigDecimal.ZERO);
//			nuevacabecera.setFacDescuento(BigDecimal.ZERO);
//			nuevacabecera.setFacCodIce("3");
//			nuevacabecera.setFacCodIva("2");
//			nuevacabecera.setCod_tipoambiente(tipoAmbienteRepository.findByAmEstado(Boolean.TRUE));
////             1.4010
//			nuevacabecera.setFacTotalBaseCero(BigDecimal.ZERO);
//			/* 0 SI NO LLEVA IVA Y 2 SI LLEVA IVA */
//			nuevacabecera.setCodigoPorcentaje("2");
//			nuevacabecera.setFacPorcentajeIva("12");
//			nuevacabecera.setFacMoneda("DOLAR");
//			nuevacabecera.setFacSubtotal(subtota);
//			// nuevacabecera.setIdFormaPago(formaPagoSelected);
//			nuevacabecera.setFacPlazo(BigDecimal.valueOf(Double.valueOf(30)));
//			nuevacabecera.setFacUnidadTiempo("DIAS");
//			nuevacabecera.setIdEstado(estadoFacturaRepository.findByEstCodigo("PA"));
//			nuevacabecera.setFacTotalBaseGravaba(subtota);
//			nuevacabecera.setFacAbono(BigDecimal.ZERO);
//			nuevacabecera.setFacSaldo(BigDecimal.ZERO);
//			nuevacabecera.setFacIva(iva);
//			nuevacabecera.setFacTotal(totaFactura);
//			nuevacabecera.setFacTipo("PROF");
//			nuevacabecera.setTipodocumento("01");
//			nuevacabecera.setPuntoemision("001");
//			nuevacabecera.setCodestablecimiento("001");
//			nuevacabecera.setIdFormaPago(formaPagoRepository.findByIsprincipal(Boolean.TRUE));
//			nuevacabecera.setEstadosri("PENDIENTE");
//			nuevacabecera.setFacClaveAcceso("000000000000000");
//			nuevacabecera.setFacClaveAutorizacion("00000000000");
//			nuevacabecera.setFacSubsidio(BigDecimal.ZERO);
//			facturaRepository.save(nuevacabecera);
//
//			/* DETALE DE LA FACTURA */
//			DetalleFactura nuevoDetalle = null;
//
//			for (ModeloPedidoSQLite detalle : modelosql.getDetalle()) {
//				nuevoDetalle = new DetalleFactura();
//				nuevoDetalle.setDetCantidad(BigDecimal.valueOf(Double.valueOf(detalle.getCOLUMN_NAME_CANTIDAD())));
//				nuevoDetalle.setDetDescripcion(detalle.getCOLUMN_NAME_DESCRIPCION());
//				nuevoDetalle.setIdProducto(productoRepository.findByProdCodigo(detalle.getCOLUMN_NAME_PRODUCTO()).get(0));
//				BigDecimal subTot=BigDecimal.valueOf(Double.valueOf(detalle.getCOLUMN_NAME_PRECIOUNIT())).divide(BigDecimal.valueOf(Double.valueOf(1.12)),2,RoundingMode.FLOOR);
//				BigDecimal ivaDet=BigDecimal.valueOf(Double.valueOf(detalle.getCOLUMN_NAME_PRECIOUNIT())).subtract(subTot);
//				nuevacabecera.setFacSecuencialUnico(modelo.getSECUENCIALUNICO());
//				nuevoDetalle.setDetSubtotal(subTot);
//				nuevoDetalle.setDetIva(ivaDet);
//				nuevoDetalle.setDetTotal(BigDecimal.valueOf(Double.valueOf(detalle.getCOLUMN_NAME_TOTAL())));
//				nuevoDetalle.setDetSubtotaldescuento(subTot);
//				
//				nuevoDetalle.setIdFactura(nuevacabecera);
//				nuevoDetalle.setDetCodTipoVenta("0");
//				nuevoDetalle.setDetTipoVenta("NORMAL");
//				nuevoDetalle.setDetTotalconiva(BigDecimal.valueOf(Double.valueOf(detalle.getCOLUMN_NAME_TOTAL())));
//				nuevoDetalle.setDetPordescuento(BigDecimal.ZERO);
//				nuevoDetalle.setDetValdescuento(BigDecimal.ZERO);
//				nuevoDetalle.setDetTotaldescuento(BigDecimal.valueOf(Double.valueOf(detalle.getCOLUMN_NAME_TOTAL())));
//				nuevoDetalle
//						.setDetTotaldescuentoiva(BigDecimal.valueOf(Double.valueOf(detalle.getCOLUMN_NAME_TOTAL())));
//				nuevoDetalle.setDetCantpordescuento(BigDecimal.ZERO);
//				nuevoDetalle.setDetSubtotaldescuentoporcantidad(
//						BigDecimal.valueOf(Double.valueOf(detalle.getCOLUMN_NAME_TOTAL())));
//				nuevoDetalle.setDetCodTipoVenta("0");
//				nuevoDetalle.setDetCodIva("2");
//				nuevoDetalle.setDetCodPorcentaje("2");
//				nuevoDetalle.setDetTarifa(BigDecimal.ZERO);
//				detalleFacturaRepository.save(nuevoDetalle);
//			}
//			// PARA VERIFICAR EN EL MOVI SI EJECUTO CORRECTAMENTE
//			respuesta.setCodigo("D01");
//			respuesta.setDescripcion("CORRECTO");
//			respuesta.setError("PROCESO CORRECTO");
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println("ERROR catalogues " + e.getMessage());
//			respuesta.setCodigo("E01");
//			respuesta.setDescripcion("ERROR" + HttpStatus.INTERNAL_SERVER_ERROR);
//			respuesta.setError(e.getMessage());
//			
//			httpHeaders.add("STATUS", "0");
//			return new ResponseEntity<RespuestaProceso>(respuesta, httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		httpHeaders.add("STATUS", "1");
//		return new ResponseEntity<RespuestaProceso>(respuesta, httpHeaders, HttpStatus.OK);
//	}
//	
////	  private String numeroFacturaTexto() {
////	        numeroFacturaText = "";
////	        for (int i = numeroFactura.toString().length(); i < 9; i++) {
////	            numeroFacturaText = numeroFacturaText + "0";
////	        }
////	        numeroFacturaText = numeroFacturaText + numeroFactura;
////	        System.out.println("nuemro texto " + numeroFacturaText);
////	        return numeroFacturaText;
////	    }
//
//	    private Integer numeroFactura(Usuario usu) {
//	        List<Factura> recuperada = facturaRepository.findFirst2ByIdUsuarioOrderByIdFacturaDesc(usu);
//	        if (recuperada.size()>0 ) {
//	            // System.out.println("numero de factura " + recuperada);
//	        	Factura factUltima=recuperada.get(0);
//	            numeroFactura = factUltima.getFacNumProforma()+ 1;
//	           
//	        } else {
//	            numeroFactura = 1;
//  
//	        }
//	        return numeroFactura;
//	    }

}
