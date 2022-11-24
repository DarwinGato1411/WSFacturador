package com.ec.deckxel.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ec.deckxel.entidad.Producto;

/**
 * Spring Data JPA repository for the Products entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long> {
//los productos activados en el sistema web
//	List<Producto> findTop30ByIdUsuarioIdUsuarioAndProdNombreLike(Integer idUsuario,String descripcion);
	//SOLO PRODUCTOS
//	List<Producto> findTop30ByProdEsproductoIsTrueAndProdNombreLike(String descripcion);
	//SOLO SERVICIOS
//	List<Producto> findTop30ByProdEsproductoIsFalseAndProdNombreLike(String descripcion);
//	List<Producto> findTopByIdUsuarioIdUsuarioAndProdNombreLike(Integer idUsuario,String descripcion);
//	List<Producto> findByProdCodigo(String descripcion);
	List<Producto> findByCodTipoambienteCodTipoambienteAndProdNombreLike( Integer codTipoambiente,String prodNombre);
}
