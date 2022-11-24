package com.ec.deckxel.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ec.deckxel.entidad.Canton;
import com.ec.deckxel.entidad.Parroquia;

/**
 * Spring Data JPA repository for the Products entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ParroquiaRepository extends CrudRepository<Parroquia, Long> {
//los productos activados en el sistema web
	List<Parroquia> findByIdCantonIdCantonAndParrEstado(Integer idCanton,Boolean estado);
	List<Parroquia> findByParrEstado(Boolean estado);
	Parroquia findByIdParroquia(Integer idParroqua);
}
