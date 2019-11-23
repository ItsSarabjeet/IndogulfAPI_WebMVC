package com.grasim.IndogulfAPI.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grasim.IndogulfAPI.model.PlantChecklistParamTagLink;

@Repository
public class PlantchecklistParamTagLinkRepository {

	@PersistenceContext
    private EntityManager entityManager;
	
	@Autowired
	private PlantChecklistRepository catgRepo;

	@SuppressWarnings("unchecked")
	public List<PlantChecklistParamTagLink> getByCatgIdAndEquipCode(String catgId, String equipCode) {
		Query query = entityManager.createQuery("select p from PlantChecklistParamTagLink p where p.checklistId = :id and p.descr like :equipCode%");
		query.setParameter("id", catgId);
		query.setParameter("equipCode", equipCode);
		return (List<PlantChecklistParamTagLink>) query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<PlantChecklistParamTagLink> getParamUpdatesByRev(Long revId) {
		List<String> catgIds = catgRepo.getChecklistIdsOfDeptCode("M");
		Query query = entityManager.createQuery("select p from PlantChecklistParamTagLink p where p.checklistId IN :ids and p.modifiedEquipSrNo > :revId");
		query.setParameter("ids", catgIds);
		query.setParameter("revId", revId);
		return (List<PlantChecklistParamTagLink>) query.getResultList();
	}
}
