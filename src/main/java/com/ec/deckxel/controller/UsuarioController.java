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

import com.ec.deckxel.entidad.Parroquia;
import com.ec.deckxel.entidad.Tipoambiente;
import com.ec.deckxel.entidad.Usuario;
import com.ec.deckxel.modeloionic.ParamLogin;
import com.ec.deckxel.repository.ParroquiaRepository;
import com.ec.deckxel.repository.TipoAmbienteRepository;
import com.ec.deckxel.repository.UsuarioRepository;
import com.ec.deckxel.utilidad.RespuestaProceso;
import com.google.gson.Gson;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@Api(tags = "Usuario", description = "Metodos de usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private ParroquiaRepository parroquiaRepository;
	@Autowired
	private TipoAmbienteRepository tipoAmbienteRepository;

	@RequestMapping(value = "/usuarios", method = RequestMethod.POST)
	public ResponseEntity<?> loginuser(@RequestBody Usuario usuario) {
		final HttpHeaders httpHeaders = new HttpHeaders();
		List<Usuario> respuesta = new ArrayList<>();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
		httpHeaders.setCacheControl("no-cache, no-store, max-age=120, must-revalidate");
//		httpHeaders.setETag(HttpHeaders.ETAG);
		try {
			Gson gson = new Gson();
			String JSON = gson.toJson(usuario);

			System.out.println("REQUEST JSON " + JSON);
			/* CONSULTA EL CATALOGO DE PAISES POR LAS CONSTANTES DEFINIDAS */
			respuesta = (List<Usuario>) usuarioRepository
					.findByUsuActivaMovilAndIdParroquiaIdCantonIdCantonAndUsuActividadLike(Boolean.TRUE,
							usuario.getIdParroquia().getIdCanton().getIdCanton(),
							"%" + usuario.getUsuActividad() + "%");
//			cfgPais = GlobalValue.LISTACFGPAIS;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR catalogues " + e.getMessage());
			httpHeaders.add("STATUS", "0");
			return new ResponseEntity<List<Usuario>>(respuesta, httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		httpHeaders.add("STATUS", "1");
		return new ResponseEntity<List<Usuario>>(respuesta, httpHeaders, HttpStatus.OK);
	}

	@RequestMapping(value = "/logindrive", method = RequestMethod.POST)
	public ResponseEntity<?> logindrive(@RequestBody Usuario usuario) {
		final HttpHeaders httpHeaders = new HttpHeaders();
		Usuario respuesta = new Usuario();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
		httpHeaders.setCacheControl("no-cache, no-store, max-age=120, must-revalidate");
//		httpHeaders.setETag(HttpHeaders.ETAG);
		try {
			Gson gson = new Gson();
			String JSON = gson.toJson(usuario);

			System.out.println("REQUEST JSON USUARIO DRIVE " + JSON);
			/* CONSULTA EL CATALOGO DE PAISES POR LAS CONSTANTES DEFINIDAS */
			respuesta = (Usuario) usuarioRepository.findByUsuLoginAndUsuPasswordAndUsuEsDrive(usuario.getUsuLogin(),
					usuario.getUsuPassword(), Boolean.TRUE);
			// si no encuentra en la base de datos
			if (respuesta == null) {
				respuesta = new Usuario();
				respuesta.setUsuLogin("");
				respuesta.setUsuPassword("");
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR catalogues " + e.getMessage());
			httpHeaders.add("STATUS", "0");
			return new ResponseEntity<Usuario>(respuesta, httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		httpHeaders.add("STATUS", "1");
		return new ResponseEntity<Usuario>(respuesta, httpHeaders, HttpStatus.OK);
	}

	@RequestMapping(value = "/admusuario", method = RequestMethod.POST)
	public ResponseEntity<?> admusuario(@RequestBody Usuario usuario) {
		final HttpHeaders httpHeaders = new HttpHeaders();
		Usuario respuesta = new Usuario();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
		httpHeaders.setCacheControl("no-cache, no-store, max-age=120, must-revalidate");
//		httpHeaders.setETag(HttpHeaders.ETAG);
		try {
			Gson gson = new Gson();
			String JSON = gson.toJson(usuario);

			System.out.println("REQUEST JSON USUARIO DRIVE " + JSON);
			/* CONSULTA EL CATALOGO DE PAISES POR LAS CONSTANTES DEFINIDAS */
			respuesta = (Usuario) usuarioRepository.findByUsuLoginAndUsuPassword(usuario.getUsuLogin(),
					usuario.getUsuPassword());
			// si no encuentra en la base de datos
			switch (usuario.getAccionRest()) {
			case "create":

				respuesta = (Usuario) usuarioRepository.findByUsuLoginAndUsuPassword(usuario.getUsuLogin(),
						usuario.getUsuPassword());

				if (respuesta == null) {
					usuarioRepository.save(usuario);
					respuesta = usuario;

				} else {
					respuesta = new Usuario();
					respuesta.setUsuLogin("EXISTE");
					respuesta.setUsuPassword("EXISTE");

				}
				break;
			case "update":
				respuesta = (Usuario) usuarioRepository.findByUsuLoginAndUsuPassword(usuario.getUsuLogin(),
						usuario.getUsuPassword());
				if (respuesta != null) {
					respuesta.setUsuActivaMovil(usuario.getUsuActivaMovil());
					usuarioRepository.save(respuesta);
				} else {
					respuesta = new Usuario();
					respuesta.setUsuLogin("NO EXISTE EL USUARIO");
					respuesta.setUsuPassword("NO EXISTE EL USUARIO");

				}
				break;
			case "delete":
				respuesta = (Usuario) usuarioRepository.findByUsuLoginAndUsuPassword(usuario.getUsuLogin(),
						usuario.getUsuPassword());
				if (respuesta != null) {
					usuarioRepository.delete(respuesta);
				} else {
					respuesta = new Usuario();
					respuesta.setUsuLogin("NO EXISTE EL USUARIO");
					respuesta.setUsuPassword("NO EXISTE EL USUARIO");

				}
				break;
			default:
				respuesta = new Usuario();
				respuesta.setUsuLogin("NO EJECUTA");
				respuesta.setUsuPassword("NO EJECUTA");
				break;
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR catalogues " + e.getMessage());
			httpHeaders.add("STATUS", "0");
			return new ResponseEntity<Usuario>(respuesta, httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		httpHeaders.add("STATUS", "1");
		return new ResponseEntity<Usuario>(respuesta, httpHeaders, HttpStatus.OK);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ApiOperation(tags = "Usuario", value = "Login del sistema")
	public ResponseEntity<?> login(@RequestBody ParamLogin usuario) {
		final HttpHeaders httpHeaders = new HttpHeaders();
		Usuario respuesta = new Usuario();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
		httpHeaders.setCacheControl("no-cache, no-store, max-age=120, must-revalidate");
//		httpHeaders.setETag(HttpHeaders.ETAG);
		try {
			Gson gson = new Gson();
			String JSON = gson.toJson(usuario);

			System.out.println("REQUEST JSON USUARIO DRIVE " + JSON);
			/* CONSULTA EL CATALOGO DE PAISES POR LAS CONSTANTES DEFINIDAS */
			respuesta = (Usuario) usuarioRepository.findByUsuLoginAndUsuPassword(usuario.getUsuLogin(),
					usuario.getUsuPassword());
			Tipoambiente recuper = tipoAmbienteRepository.findByAmEstadoAndIdUsuario(Boolean.TRUE, respuesta);
			respuesta.setTipoambiente(recuper);
			respuesta.setCodTipoAmbiente(recuper.getCodTipoambiente());
			// si no encuentra en la base de datos
			if (respuesta == null) {
				respuesta = new Usuario();
				respuesta.setUsuLogin("");
				respuesta.setUsuPassword("");
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR catalogues " + e.getMessage());
			httpHeaders.add("STATUS", "0");
			return new ResponseEntity<Usuario>(respuesta, httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		httpHeaders.add("STATUS", "1");
		return new ResponseEntity<Usuario>(respuesta, httpHeaders, HttpStatus.OK);
	}

	/* SERVICIOS EMPLEO */
	@RequestMapping(value = "/crearusuario", method = RequestMethod.POST)
	public ResponseEntity<?> crearusuario(@RequestBody Usuario usuario) {
		final HttpHeaders httpHeaders = new HttpHeaders();
		RespuestaProceso respuesta = new RespuestaProceso();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
		httpHeaders.setCacheControl("no-cache, no-store, max-age=120, must-revalidate");
//		httpHeaders.setETag(HttpHeaders.ETAG);
		try {
			Gson gson = new Gson();
			String JSON = gson.toJson(usuario);
//			Parroquia parroquia = parroquiaRepository.findByIdParroquia(usuario.getIdParroquia().getIdParroquia());
//			usuario.setIdParroquia(parroquia);
			System.out.println("CREAR USUARIO " + JSON);
			/* CONSULTA EL CATALOGO DE PAISES POR LAS CONSTANTES DEFINIDAS */
			usuarioRepository.save(usuario);
			// si no encuentra en la base de datos

			respuesta.setDescripcion("GUardado correctamente");
			respuesta.setCodigo("OK " + HttpStatus.OK);
			respuesta.setError("ORROR " + HttpStatus.OK);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR catalogues " + e.getMessage());
			respuesta.setDescripcion("No guardo");
			respuesta.setCodigo("OK " + HttpStatus.INTERNAL_SERVER_ERROR);
			respuesta.setError("ORROR " + HttpStatus.INTERNAL_SERVER_ERROR);
			httpHeaders.add("STATUS", "0");
			return new ResponseEntity<RespuestaProceso>(respuesta, httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		httpHeaders.add("STATUS", "1");
		return new ResponseEntity<RespuestaProceso>(respuesta, httpHeaders, HttpStatus.OK);
	}

	@RequestMapping(value = "/updateusuario", method = RequestMethod.POST)
	public ResponseEntity<?> updateusuario(@RequestBody Usuario valor) {
		final HttpHeaders httpHeaders = new HttpHeaders();
		RespuestaProceso respuesta = new RespuestaProceso();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
		httpHeaders.setCacheControl("no-cache, no-store, max-age=120, must-revalidate");
//		httpHeaders.setETag(HttpHeaders.ETAG);
		try {
			Usuario usurecup = usuarioRepository.findByIdUsuario(valor.getIdUsuario());
			usurecup.setUsuNombre(valor.getUsuNombre());
			usurecup.setUsuPassword(valor.getUsuPassword());
			usurecup.setUsuLogin(valor.getUsuLogin());
			usurecup.setUsuWhatsapp(valor.getUsuWhatsapp());
			usurecup.setUsuPagina(valor.getUsuPagina());
//			usurecup.setUsuPesonaEmpresa(valor.getUsuPesonaEmpresa());;

			Gson gson = new Gson();
			String JSON = gson.toJson(valor);
			// Parroquia parroquia =
			// parroquiaRepository.findByIdParroquia(valor.getIdParroquia().getIdParroquia());
			usurecup.setIdParroquia(valor.getIdParroquia());
			// TipoActividad actividad=
			// tipoActividadRepository.findByIdTipoActividad(valor.getIdActividad().getIdTipoActividad());
			System.out.println("CREAR USUARIO " + JSON);
			/* CONSULTA EL CATALOGO DE PAISES POR LAS CONSTANTES DEFINIDAS */
//			usurecup.setIdActividad(valor.getIdActividad());
			usuarioRepository.save(usurecup);
			// si no encuentra en la base de datos

			respuesta.setDescripcion("GUardado correctamente");
			respuesta.setCodigo("OK " + HttpStatus.OK);
			respuesta.setError("ORROR " + HttpStatus.OK);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR catalogues " + e.getMessage());
			respuesta.setDescripcion("Error al guardar ");
			respuesta.setCodigo("OK " + HttpStatus.INTERNAL_SERVER_ERROR);
			respuesta.setError("ORROR " + HttpStatus.INTERNAL_SERVER_ERROR);
			httpHeaders.add("STATUS", "0");
			return new ResponseEntity<RespuestaProceso>(respuesta, httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		httpHeaders.add("STATUS", "1");
		return new ResponseEntity<RespuestaProceso>(respuesta, httpHeaders, HttpStatus.OK);
	}

	@RequestMapping(value = "/loginservicios", method = RequestMethod.POST)
	public ResponseEntity<?> loginservicios(@RequestBody Usuario usuario) {
		final HttpHeaders httpHeaders = new HttpHeaders();
		Usuario respuesta = new Usuario();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
		httpHeaders.setCacheControl("no-cache, no-store, max-age=120, must-revalidate");
//		httpHeaders.setETag(HttpHeaders.ETAG);
		try {
			Gson gson = new Gson();
			String JSON = gson.toJson(usuario);

			System.out.println("REQUEST JSON USUARIO loginservicios " + JSON);
			/* CONSULTA EL CATALOGO DE PAISES POR LAS CONSTANTES DEFINIDAS */
			respuesta = (Usuario) usuarioRepository.findByUsuLoginAndUsuPassword(usuario.getUsuLogin(),
					usuario.getUsuPassword());
			// si no encuentra en la base de datos
			if (respuesta == null) {
				respuesta = new Usuario();
				respuesta.setUsuLogin("");
				respuesta.setUsuPassword("");
			} else {
				Tipoambiente recup = tipoAmbienteRepository.findByAmEstadoAndIdUsuario(Boolean.TRUE, respuesta);
				if (recup.getCodTipoambiente() != null) {
					respuesta.setCodTipoAmbiente(recup.getCodTipoambiente());
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR catalogues " + e.getMessage());
			httpHeaders.add("STATUS", "0");
			return new ResponseEntity<Usuario>(respuesta, httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		httpHeaders.add("STATUS", "1");
		return new ResponseEntity<Usuario>(respuesta, httpHeaders, HttpStatus.OK);
	}

}
