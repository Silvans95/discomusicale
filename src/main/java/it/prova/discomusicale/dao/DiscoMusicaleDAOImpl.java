package it.prova.discomusicale.dao;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.discomusicale.model.DiscoMusicale;

public class DiscoMusicaleDAOImpl implements DiscoMusicaleDAO {

	private EntityManager entityManager;

	@Override
	public List<DiscoMusicale> list() throws Exception {
		return entityManager.createQuery("from DiscoMusicale", DiscoMusicale.class).getResultList();
	}

	@Override
	public DiscoMusicale findOne(Long id) throws Exception {
		return entityManager.find(DiscoMusicale.class, id);
	}

	@Override
	public void update(DiscoMusicale input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		input = entityManager.merge(input);
	}

	@Override
	public void insert(DiscoMusicale input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(input);
	}

	@Override
	public void delete(DiscoMusicale input) throws Exception {
		// TODO Auto-generated method stub
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(input));
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
