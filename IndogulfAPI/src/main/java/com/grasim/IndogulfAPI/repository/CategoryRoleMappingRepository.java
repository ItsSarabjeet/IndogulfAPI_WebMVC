package com.grasim.IndogulfAPI.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.grasim.IndogulfAPI.model.CategoryRoleMapping;

@Repository("catRoleRepo")
public class CategoryRoleMappingRepository {

	@PersistenceContext
    private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<CategoryRoleMapping> getAllAfterRevId(Long revId) throws Exception {
		Query query = entityManager.createQuery("select c from CategoryRoleMapping c where c.modifiedSrNo > :revId");
		query.setParameter("revId", revId);
		return (List<CategoryRoleMapping>) query.getResultList(); 
	}
}
