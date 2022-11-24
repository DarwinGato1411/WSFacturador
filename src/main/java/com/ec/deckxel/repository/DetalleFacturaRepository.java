package com.ec.deckxel.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ec.deckxel.entidad.DetalleFactura;
import com.ec.deckxel.entidad.Factura;

/**
 * Spring Data JPA repository for the Products entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DetalleFacturaRepository extends CrudRepository<DetalleFactura, Long> {
//los productos activados en el sistema web
	List<DetalleFactura> findByIdFactura(Factura factura);
}
