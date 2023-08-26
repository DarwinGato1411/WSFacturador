package com.ec.deckxel.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ec.deckxel.entidad.Vacante;

@Repository
public class VacanteRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Vacante> buscarPorNombre(String activa, Integer limit) {
		return entityManager.createQuery(
				"SELECT p FROM Vacante p WHERE p.vacNombre=:vacNombre ORDER BY pvacNombre ASC",
				Vacante.class).setParameter("vacNombre", activa).setMaxResults(limit).getResultList();
	}

}
