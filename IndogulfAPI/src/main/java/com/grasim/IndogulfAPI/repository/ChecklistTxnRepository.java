package com.grasim.IndogulfAPI.repository;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.grasim.IndogulfAPI.model.CategoryRoleMapping;
import com.grasim.IndogulfAPI.model.ChecklistEquipDtl;
import com.grasim.IndogulfAPI.model.ChecklistTxnDtl;
import com.grasim.IndogulfAPI.model.ChecklistTxnHdr;
import com.grasim.IndogulfAPI.model.Settings;

@Repository(value = "chkTxnRepo")
public class ChecklistTxnRepository {
	
	@PersistenceContext
    private EntityManager entityManager;
	
	@Autowired
	private SettingsRepository settingsRepository;
	
	@SuppressWarnings("unchecked")
	public List<ChecklistTxnHdr> getAllByRoleRevIdAndPagination(Long roleId, Long revId, Integer from, Integer size) throws Exception{
		Query query = entityManager.createQuery("select c.categoryId from CategoryRoleMapping c where c.roleId = :roleId and c.active = true");
		query.setParameter("roleId", roleId);
		List<String> categoryIds = query.getResultList();
		Settings settings = settingsRepository.getByName("NO_OF_DAYS_KEEP");
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		if(settings == null) {
			cal.add(Calendar.DATE, -7);
		}else {
			cal.add(Calendar.DATE, - Integer.parseInt(settings.getValue()));
		}
		
		Query query2 = entityManager.createQuery("select c from ChecklistTxnHdr c where c.checklistId in :categoryIds and c.modifiedSrNo > :revId and c.createdOn >= :dt");
		query2.setParameter("categoryIds", categoryIds);
		query2.setParameter("revId", revId);
		query2.setParameter("dt", cal.getTime());
		if(from != null) {
			query2.setFirstResult(from);
		}
		if(size != null) {
			query2.setMaxResults(size);
		}
		return (List<ChecklistTxnHdr>)query2.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<ChecklistTxnHdr> getAllByUserRevIdAndPagination(Long userId, Long revId, Integer from, Integer size) throws Exception{
		Query query = entityManager.createQuery("select c from ChecklistTxnHdr c where c.createdBy = :userId and c.modifiedSrNo > :revId ");
		query.setParameter("userId", userId);
		query.setParameter("revId", revId);
		if(from != null) {
			query.setFirstResult(from);
		}
		if(size != null) {
			query.setMaxResults(size);
		}
		return (List<ChecklistTxnHdr>)query.getResultList();
	}

	public ChecklistTxnHdr getChecklistHdrByTxnRef(String refNo) {
		Query query = entityManager.createQuery("select c from ChecklistTxnHdr c where c.txnRef = :refNo");
		query.setParameter("refNo", refNo);
		return ( ChecklistTxnHdr )query.getSingleResult();
	}
	
	public List<ChecklistEquipDtl> getByTxnRef(String txnRef) {
		Query query = entityManager.createQuery("select c from ChecklistEquipDtl c where c.txnRef = :txnRef");
		query.setParameter("txnRef", txnRef);
		List<ChecklistEquipDtl> list = (List<ChecklistEquipDtl>) query.getResultList();
		return list;
	}
	public List<ChecklistTxnDtl> getChecklistDtlByRef(String refNo) {
		Query query = entityManager.createQuery("select c from ChecklistTxnDtl c where c.txnRef = :refNo");
		query.setParameter("refNo", refNo);
		return (List<ChecklistTxnDtl>)query.getResultList();
	}
	@Transactional
	public ChecklistTxnHdr save(ChecklistTxnHdr checklist) {
		checklist = entityManager.merge(checklist);
		return checklist;
	}
	
	@Transactional
	public ChecklistTxnDtl saveTxnDtl(ChecklistTxnDtl checklistDtl) {
		checklistDtl = entityManager.merge(checklistDtl);
		return checklistDtl;
	}
	
	@Transactional
	public ChecklistEquipDtl saveEquipDtl(ChecklistEquipDtl equipDtl) {
		equipDtl = entityManager.merge(equipDtl);
		return equipDtl;
	}
	
	public Long getSeq() {
	    Query query = entityManager.createNativeQuery("select seq_chklist_txn_hdr_mod.nextval from dual");
	    //System.out.println("seq_chklist_txn_hdr_mod " + query.getSingleResult());
	    BigDecimal b = (BigDecimal) query.getSingleResult();
	    return b.longValue();
	}

}
