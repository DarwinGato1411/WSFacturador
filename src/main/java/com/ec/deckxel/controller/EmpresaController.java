package com.ec.deckxel.controller;

import java.util.ArrayList;
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
import com.ec.deckxel.entidad.Tipoambiente;
import com.ec.deckxel.modeloionic.ParamEmpresa;
import com.ec.deckxel.repository.EmpresaRepository;
import com.ec.deckxel.repository.TipoAmbienteRepository;
import com.ec.deckxel.utilidad.RespuestaProceso;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST }, allowedHeaders = "*")
@Api(tags = "Cliente", description = "Metodos de cliente")
public class EmpresaController {

	@Autowired
	private EmpresaRepository empresaRepository;

	@RequestMapping(value = "/empresas/", method = RequestMethod.POST)
	@ApiOperation(tags = "Empresa", value = "Lista de empresas filtrado por nombre")
	public ResponseEntity<?> productos(@RequestBody ParamEmpresa prod) {
		final HttpHeaders httpHeaders = new HttpHeaders();
		List<Tipoambiente> respuesta = new ArrayList<>();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
		httpHeaders.setCacheControl("no-cache, no-store, max-age=120, must-revalidate");
//		httpHeaders.setETag(HttpHeaders.ETAG);
		try {

			/* CONSULTA EL CATALOGO DE PAISES POR LAS CONSTANTES DEFINIDAS */
			

				respuesta = (List<Tipoambiente>) empresaRepository.buscarPorNombre(prod.getNombreEmpresa(), 25);

			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR catalogues " + e.getMessage());
			httpHeaders.add("STATUS", "0");
			RespuestaProceso error = new RespuestaProceso();
			error.setDescripcion("Error al listar las empresas");
			error.setCodigo("ERROR: " + HttpStatus.INTERNAL_SERVER_ERROR);
			error.setError("ERROR: " + HttpStatus.INTERNAL_SERVER_ERROR);
			httpHeaders.add("STATUS", "0");
			return new ResponseEntity<RespuestaProceso>(error, httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		httpHeaders.add("STATUS", "1");
		return new ResponseEntity<List<Tipoambiente>>(respuesta, httpHeaders, HttpStatus.OK);
	}

}
