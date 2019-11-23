package com.grasim.IndogulfAPI.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.grasim.IndogulfAPI.model.ChecklistEquipDtl;
import com.grasim.IndogulfAPI.model.ChecklistTxnDtl;
import com.grasim.IndogulfAPI.model.ChecklistTxnHdr;
import com.grasim.IndogulfAPI.model.PlantChecklist;
import com.grasim.IndogulfAPI.model.PlantChecklistParamTagLink;
import com.grasim.IndogulfAPI.model.WebAPIResponse;
import com.grasim.IndogulfAPI.model.WebAPIResponseStatus;
import com.grasim.IndogulfAPI.model.WebAPIResponseType;
import com.grasim.IndogulfAPI.repository.ChecklistTxnRepository;
import com.grasim.IndogulfAPI.util.GlobalFunction;

@Service
public class ChecklistTxnService{

	private static final Logger LOGGER = Logger.getLogger(ChecklistTxnService.class);

	@Autowired
	private ChecklistTxnRepository chkTxnRepo;
	
	GlobalFunction global = new GlobalFunction();
	
	public WebAPIResponse<ChecklistTxnHdr> saveChecklistTxn(ChecklistTxnHdr chklistTxn) {
		//Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		WebAPIResponse<ChecklistTxnHdr> response = new WebAPIResponse<>();
		try {
			chklistTxn.setModifiedSrNo(chkTxnRepo.getSeq().longValue());
			ChecklistTxnHdr chklistTxn1 = chkTxnRepo.save(chklistTxn);
			Iterator<ChecklistTxnDtl> itr = chklistTxn.getChecklistDtls().iterator();
			while(itr.hasNext()) {
				ChecklistTxnDtl chkListDtl = itr.next();
				if(chkListDtl.getTxnVal() != null && !chkListDtl.getTxnVal().isEmpty()) {
					chkTxnRepo.saveTxnDtl(chkListDtl);
				}
			}
			Iterator<ChecklistEquipDtl> itr2 = chklistTxn.getEquipDtls().iterator();
			while(itr2.hasNext()) {
				chkTxnRepo.saveEquipDtl(itr2.next());
			}
			chklistTxn1.setChecklistDtls(chklistTxn.getChecklistDtls());
			
			response.setType(WebAPIResponseType.OBJECT);
			response.setMessage("Checklist transaction saved successfully");
			
			//sending chklistTxn here when infact should be sending checklistTxn1
			response.setResultItem(chklistTxn);
			response.setResultCount(1);
			response.setStatus(WebAPIResponseStatus.SUCCESS);
			response.setToken(chklistTxn1.getModifiedSrNo().toString());
			
			LOGGER.info("saved checklist : " + global.convert_to_json(chklistTxn));
		} catch (Exception e) {
			response.setStatus(WebAPIResponseStatus.FAIL);
			response.setError(e.getMessage());
			LOGGER.error("some error occured in saving checklist : " + global.convert_to_json(chklistTxn) + ". ERROR : ", e);
		}
		return response;
	}
	
	public WebAPIResponse<List<ChecklistTxnHdr>> saveAllChecklistTxn(List<ChecklistTxnHdr> chklistTxn) {
		List<ChecklistTxnHdr> resp = new ArrayList<>();
		WebAPIResponse<List<ChecklistTxnHdr>> response = new WebAPIResponse<List<ChecklistTxnHdr>>();
		try {
			//chklistTxn = (List<ChecklistTxnHdr>) chklistTxnRepo.saveAll(chklistTxn);
			Iterator<ChecklistTxnHdr> itrHdr = chklistTxn.iterator();
			while(itrHdr.hasNext()) {
				ChecklistTxnHdr hdr = itrHdr.next();
				hdr.setModifiedSrNo(chkTxnRepo.getSeq().longValue());
				chkTxnRepo.save(hdr);
				Iterator<ChecklistTxnDtl> itr = hdr.getChecklistDtls().iterator();
				while(itr.hasNext()) {
					ChecklistTxnDtl chkListDtl = itr.next();
					if(chkListDtl.getTxnVal() != null && !chkListDtl.getTxnVal().isEmpty()) {
						chkTxnRepo.saveTxnDtl(chkListDtl);
					}
				}
				Iterator<ChecklistEquipDtl> itr2 = hdr.getEquipDtls().iterator();
				while(itr2.hasNext()) {
					chkTxnRepo.saveEquipDtl(itr2.next());
				}
				resp.add(hdr);
			}
			
			response.setType(WebAPIResponseType.LIST);
			response.setMessage("Checklist transactions saved successfully");
			response.setResultItem(resp);
			response.setResultCount(resp.size());
			response.setStatus(WebAPIResponseStatus.SUCCESS);
			

			ChecklistTxnHdr tmp = chklistTxn.get(0);
			tmp = chkTxnRepo.getChecklistHdrByTxnRef(tmp.getTxnRef());
			Long tmp1 = tmp.getModifiedSrNo() + (chklistTxn.size() - 1);
			response.setToken(tmp1.toString());

			LOGGER.info("saved checklists : " + global.convert_to_json(chklistTxn));
			/*
			if(!resp.isEmpty()) {
				ChecklistTxnHdr hd = resp.stream().max(new Comparator<ChecklistTxnHdr>() {
					@Override
					public int compare(ChecklistTxnHdr o1, ChecklistTxnHdr o2) {
						return o1.getModifiedSrNo().intValue() - o2.getModifiedSrNo().intValue();
					}
				}).get();
				response.setToken(hd.getModifiedSrNo().toString());
			}*/
			
		} catch (Exception e) {
			response.setStatus(WebAPIResponseStatus.FAIL);
			response.setError(e.getMessage());
			LOGGER.error("some error occured in saving checklists : " + global.convert_to_json(chklistTxn) + ". ERROR : ", e);

		}
		return response;
	}

	public WebAPIResponse<ChecklistTxnHdr> getAllByUserRevIdAndPagination(Long userId, Long revId, Integer from,
			Integer size) {
		WebAPIResponse<ChecklistTxnHdr> response = new WebAPIResponse<ChecklistTxnHdr>();
		try {
			List<ChecklistTxnHdr> chklistTxns = (List<ChecklistTxnHdr>) chkTxnRepo.getAllByUserRevIdAndPagination(userId, revId, from, size);
			Iterator<ChecklistTxnHdr> itrHdr = chklistTxns.iterator();
			while(itrHdr.hasNext()) {
				ChecklistTxnHdr hdr = itrHdr.next();
				hdr.setChecklistDtls(chkTxnRepo.getChecklistDtlByRef(hdr.getTxnRef()));
				hdr.setEquipDtls(chkTxnRepo.getByTxnRef(hdr.getTxnRef()));
			}

			if(chklistTxns.isEmpty()) {
				response.setType(WebAPIResponseType.EMPTY);
				response.setMessage("No updates found");
				response.setResultList(chklistTxns);
			}else {
				response.setType(WebAPIResponseType.LIST);
				response.setMessage("Checklist transactions retrieved successfully");
				response.setResultList(chklistTxns);
			}
			response.setResultCount(chklistTxns.size());
			response.setStatus(WebAPIResponseStatus.SUCCESS);
			
			if(!chklistTxns.isEmpty()) {
				List<Long> modifiedSrNos = new ArrayList<Long>();
				Iterator<ChecklistTxnHdr> itr = chklistTxns.iterator();
				while(itr.hasNext()) {
					modifiedSrNos.add(itr.next().getModifiedSrNo());
				}
				response.setToken(Collections.max(modifiedSrNos).toString());
			}
			LOGGER.info("response of API /chklist_txn/user/" + userId + "/revid/" + revId + "?from=" + from + "&size=" + size + " is " + global.convert_to_json(response));

		} catch (Exception e) {
			response.setStatus(WebAPIResponseStatus.FAIL);
			response.setError(e.getMessage());
			LOGGER.error("Some error occured during call of API /chklist_txn/user/" + userId + "/revid/" + revId + "?from=" + from + "&size=" + size , e);			
		}
		return response;
	}
	
	public WebAPIResponse<ChecklistTxnHdr> getAllByRoleRevIdAndPagination(Long roleId, Long revId, Integer from,
			Integer size) {
		WebAPIResponse<ChecklistTxnHdr> response = new WebAPIResponse<ChecklistTxnHdr>();
		try {
			List<ChecklistTxnHdr> chklistTxns = (List<ChecklistTxnHdr>) chkTxnRepo.getAllByRoleRevIdAndPagination(roleId, revId, from, size);
			Iterator<ChecklistTxnHdr> itrHdr = chklistTxns.iterator();
			while(itrHdr.hasNext()) {
				ChecklistTxnHdr hdr = itrHdr.next();
				hdr.setChecklistDtls(chkTxnRepo.getChecklistDtlByRef(hdr.getTxnRef()));
				hdr.setEquipDtls(chkTxnRepo.getByTxnRef(hdr.getTxnRef()));
			}

			if(chklistTxns.isEmpty()) {
				response.setType(WebAPIResponseType.EMPTY);
				response.setMessage("No updates found");
				response.setResultList(chklistTxns);
			}else {
				response.setType(WebAPIResponseType.LIST);
				response.setMessage("Checklist transactions retrieved successfully");
				response.setResultList(chklistTxns);
			}
			response.setResultCount(chklistTxns.size());
			response.setStatus(WebAPIResponseStatus.SUCCESS);
			
			if(!chklistTxns.isEmpty()) {
				List<Long> modifiedSrNos = new ArrayList<Long>();
				Iterator<ChecklistTxnHdr> itr = chklistTxns.iterator();
				while(itr.hasNext()) {
					modifiedSrNos.add(itr.next().getModifiedSrNo());
				}
				response.setToken(Collections.max(modifiedSrNos).toString());
			}
			LOGGER.info("response of API /chklist_txn/role/" + roleId + "/revid/" + revId + "?from=" + from + "&size=" + size + " is " + global.convert_to_json(response));

		} catch (Exception e) {
			response.setStatus(WebAPIResponseStatus.FAIL);
			response.setError(e.getMessage());
			LOGGER.error("Some error occured during call of API /chklist_txn/role/" + roleId + "/revid/" + revId + "?from=" + from + "&size=" + size , e);			
		}
		return response;
	}
}
