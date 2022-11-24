package com.ec.deckxel.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ec.deckxel.entidad.Factura;
import com.ec.deckxel.entidad.Producto;
import com.ec.deckxel.entidad.Usuario;

/**
 * Spring Data JPA repository for the Products entity.
 */
@SuppressWarnings("unused")
@Repository
public interface FacturaRepository extends CrudRepository<Factura, Integer> {
	List<Factura> findFirst2ByIdUsuarioOrderByIdFacturaDesc(Usuario idUsuario);
//	Factura findByFacSecuencialUnico(String secuencial);

	List<Factura> findByCodTipoambienteCodTipoambienteAndFacNumeroTextLike( Integer codTipoambiente,String facNumeroText);
}
