package com.grasim.IndogulfAPI.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.grasim.IndogulfAPI.model.PlantChecklist;

@Repository
public class PlantChecklistRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public List<PlantChecklist> getAllAfterRevId(Long revId) {
		Query query = entityManager.createQuery("select p from PlantChecklist p where p.modifiedSrNo > :revId and p.deptCode = :deptCode");
		query.setParameter("revId", revId);
		query.setParameter("deptCode", "M");
		return (List<PlantChecklist>) query.getResultList();
	}
	
	public List<String> getChecklistIdsOfDeptCode(String deptCode){
		Query query = entityManager.createQuery("select p.id from PlantChecklist p where p.deptCode = :deptCode");
		query.setParameter("deptCode", deptCode);
		return (List<String>) query.getResultList();
	}
}
