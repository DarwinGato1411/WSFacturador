package com.ec.deckxel.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
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

	
	
	@Query("SELECT u FROM Factura u WHERE  u.codTipoambiente.codTipoambiente=:codTipoambiente and facNumeroText LIKE %:facNumeroText% and facFecha between :inicio and :fin order by facNumero ASC ")
	List<Factura> findByCodTipoambienteCodTipoambienteAndFacNumeroTextLike(
			@Param("codTipoambiente") Integer codTipoambiente, @Param("facNumeroText") String facNumeroText,
			@Param("inicio") Date inicio,@Param("fin")Date fin);
}
