package com.ec.deckxel.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ec.deckxel.entidad.Cliente;
import com.ec.deckxel.entidad.EstadoFacturas;
import com.ec.deckxel.entidad.Factura;
import com.ec.deckxel.entidad.Producto;
import com.ec.deckxel.entidad.Tipoadentificacion;

/**
 * Spring Data JPA repository for the Products entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EstadoFacturaRepository extends CrudRepository<EstadoFacturas, Long> {

	//EstadoFacturas findByEstCodigo(String principal);
	EstadoFacturas findByEstCodigo(String principal);
	EstadoFacturas findByIsprincipal(Boolean isprincipal);
}
