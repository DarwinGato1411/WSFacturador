package com.ec.deckxel.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ec.deckxel.entidad.Postulaciones;

@Repository
public class PostulacionRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Postulaciones> buscarPorNombre(Boolean activa, Integer limit) {
		return entityManager.createQuery(
				"SELECT p FROM Postulaciones p WHERE p.posAprobado=:posAprobado ORDER BY p.idVacante.vacNombre ASC",
				Postulaciones.class).setParameter("posAprobado", activa).setMaxResults(limit).getResultList();
	}

}
