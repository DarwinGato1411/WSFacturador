package com.ec.deckxel.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ec.deckxel.entidad.Cliente;

/**
 * Spring Data JPA repository for the Products entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

	Cliente findByCliCedula(String cedula);
	List<Cliente> findByCodTipoambienteCodTipoambienteAndCliNombreLike( Integer codTipoambiente,String cliNombre);
	List<Cliente> findTop10ByCodTipoambienteCodTipoambiente( Integer codTipoambiente);
}
