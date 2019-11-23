package com.grasim.IndogulfAPI.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.grasim.IndogulfAPI.model.Settings;

@Repository
public class SettingsRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Settings> getAllAfterRevId(Long revId) throws Exception {
		Query query = entityManager.createQuery("select s from Settings s where s.modifiedSrNo > :revId");
		query.setParameter("revId", revId);
		return (List<Settings>) query.getResultList(); 
	}
	
	public List<Settings> getAll() throws Exception {
		Query query = entityManager.createQuery("select s from Settings s");
		return (List<Settings>) query.getResultList(); 
	}
	
	public Settings getByName(String name) {
		Settings s = null;
		Query query = entityManager.createQuery("select s from Settings s where s.parameter = :name");
		query.setParameter("name", name);
		try {
			s = (Settings) query.getSingleResult();
		} catch (Exception e) {
		}
		return s;
	}
}
