package com.grasim.IndogulfAPI.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.grasim.IndogulfAPI.model.Role;

@Repository("roleRepo")
public class RoleRepository {
	
	@PersistenceContext
    private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<Role> getAllAfterRevId(Long revId) throws Exception {
		Query query = entityManager.createQuery("select r from Role r where r.modifiedSrNo > :revId");
		query.setParameter("revId", revId);
		return (List<Role>) query.getResultList(); 
	}
}
