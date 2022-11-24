package com.ec.deckxel.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ec.deckxel.entidad.Canton;
import com.ec.deckxel.entidad.Parroquia;
import com.ec.deckxel.repository.CantonRepository;
import com.ec.deckxel.repository.ParroquiaRepository;
import com.google.gson.Gson;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
public class UbicacionGeograficaController {

	@Autowired
	private CantonRepository cantonRepository;
	@Autowired
	private ParroquiaRepository parroquiaRepository;

	@RequestMapping(value = "/canton", method = RequestMethod.POST)
	public ResponseEntity<?> canton(@RequestBody Canton canton) {
		final HttpHeaders httpHeaders = new HttpHeaders();
		List<Canton> respuesta = new ArrayList<>();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
		httpHeaders.setCacheControl("no-cache, no-store, max-age=120, must-revalidate");

		List<HttpMethod> allowedMethods = new ArrayList<>();

		try {
			Gson gson = new Gson();
			String JSON = gson.toJson(canton);
			/* CONSULTA EL CATALOGO DE PAISES POR LAS CONSTANTES DEFINIDAS */
			respuesta = (List<Canton>) cantonRepository.findByCantEstado(Boolean.TRUE);
//			cfgPais = GlobalValue.LISTACFGPAIS;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR catalogues " + e.getMessage());
			httpHeaders.add("STATUS", "0");
			return new ResponseEntity<List<Canton>>(respuesta, httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		httpHeaders.add("STATUS", "1");
		return new ResponseEntity<List<Canton>>(respuesta, httpHeaders, HttpStatus.OK);
	}

	@RequestMapping(value = "/parroquia", method = RequestMethod.POST)
	public ResponseEntity<?> parroquia(@RequestBody Canton canton) {
		final HttpHeaders httpHeaders = new HttpHeaders();
		List<Parroquia> respuesta = new ArrayList<>();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
		httpHeaders.setCacheControl("no-cache, no-store, max-age=120, must-revalidate");
//		httpHeaders.setETag(HttpHeaders.ETAG);
		try {

			/* CONSULTA EL CATALOGO DE PAISES POR LAS CONSTANTES DEFINIDAS */
			respuesta = (List<Parroquia>) parroquiaRepository.findByIdCantonIdCantonAndParrEstado(canton.getIdCanton(),Boolean.TRUE);
//			cfgPais = GlobalValue.LISTACFGPAIS;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR catalogues " + e.getMessage());
			httpHeaders.add("STATUS", "0");
			return new ResponseEntity<List<Parroquia>>(respuesta, httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		httpHeaders.add("STATUS", "1");
		return new ResponseEntity<List<Parroquia>>(respuesta, httpHeaders, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/allparroquia", method = RequestMethod.POST)
	public ResponseEntity<?> allparroquia(@RequestBody Canton canton) {
		final HttpHeaders httpHeaders = new HttpHeaders();
		List<Parroquia> respuesta = new ArrayList<>();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
		httpHeaders.setCacheControl("no-cache, no-store, max-age=120, must-revalidate");
//		httpHeaders.setETag(HttpHeaders.ETAG);
		try {

			/* CONSULTA EL CATALOGO DE PAISES POR LAS CONSTANTES DEFINIDAS */
			respuesta = (List<Parroquia>) parroquiaRepository.findByParrEstado(Boolean.TRUE);
//			cfgPais = GlobalValue.LISTACFGPAIS;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR catalogues " + e.getMessage());
			httpHeaders.add("STATUS", "0");
			return new ResponseEntity<List<Parroquia>>(respuesta, httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		httpHeaders.add("STATUS", "1");
		return new ResponseEntity<List<Parroquia>>(respuesta, httpHeaders, HttpStatus.OK);
	}

}
