package com.ec.deckxel.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ec.deckxel.entidad.Producto;
import com.ec.deckxel.entidad.Usuario;

/**
 * Spring Data JPA repository for the Products entity.
 */
@SuppressWarnings("unused")
@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
//los productos activados en el sistema web
	List<Usuario> findByUsuActivaMovilAndIdParroquiaIdParroquiaAndUsuActividadLike(Boolean activa,Integer idParroquia, String actividad);
	List<Usuario> findByUsuActivaMovilAndIdParroquiaIdCantonIdCantonAndUsuActividadLike(Boolean activa,Integer idParroquia, String actividad);
	Usuario findByIdUsuario(Integer idUsuario);
	Usuario findByUsuLoginAndUsuPasswordAndUsuEsDrive(String login, String password, Boolean esDrive);
	Usuario findByUsuLoginAndUsuPassword(String login, String password);
}
