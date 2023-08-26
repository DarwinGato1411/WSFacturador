package com.ec.deckxel.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ec.deckxel.entidad.Tipoambiente;

@Repository
public class EmpresaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Tipoambiente> buscarPorNombre(String buscar, int limit) {
		return entityManager.createQuery(
				"SELECT p FROM Tipoambiente p WHERE ( p.amNombreComercial LIKE :amNombreComercial OR p.amGiro LIKE :amGiro) AND p.amEstado=:amEstado AND p.amDescripcion=:amDescripcion ORDER BY p.idUsuario.usuNombre ASC",
				Tipoambiente.class)
				.setParameter("amNombreComercial", "%" + buscar + "%")
				.setParameter("amGiro", "%" + buscar + "%")
				.setParameter("amEstado", Boolean.TRUE)
				.setParameter("amDescripcion", "PRODUCCION")
				.setMaxResults(limit).getResultList();
	}

}
