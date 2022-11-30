package com.ec.deckxel.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ec.deckxel.entidad.Canton;
import com.ec.deckxel.entidad.Producto;
import com.ec.deckxel.entidad.Tipoambiente;
import com.ec.deckxel.entidad.Usuario;

/**
 * Spring Data JPA repository for the Products entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TipoAmbienteRepository extends CrudRepository<Tipoambiente, Integer> {
	Tipoambiente findByAmEstado(Boolean estado);
	Tipoambiente findByAmEstadoAndIdUsuario(Boolean estado, Usuario usuario);

}
