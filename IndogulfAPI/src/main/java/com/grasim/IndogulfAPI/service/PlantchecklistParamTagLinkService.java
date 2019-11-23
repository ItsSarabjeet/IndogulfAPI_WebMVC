package com.grasim.IndogulfAPI.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grasim.IndogulfAPI.model.Equipment;
import com.grasim.IndogulfAPI.model.PlantChecklist;
import com.grasim.IndogulfAPI.model.PlantChecklistParamTagLink;
import com.grasim.IndogulfAPI.model.WebAPIResponse;
import com.grasim.IndogulfAPI.model.WebAPIResponseStatus;
import com.grasim.IndogulfAPI.model.WebAPIResponseType;
import com.grasim.IndogulfAPI.repository.PlantchecklistParamTagLinkRepository;

@Service
public class PlantchecklistParamTagLinkService {

	@Autowired
	private PlantchecklistParamTagLinkRepository plantchecklistParamTagLinkRepository;
	
	private static final Logger LOGGER = Logger.getLogger(PlantchecklistParamTagLinkService.class);
	
	public WebAPIResponse<Equipment> getEquipUpdatesAfterRevId(Long revId) {
		WebAPIResponse<Equipment> response = new WebAPIResponse<>();
		try {
			List<PlantChecklistParamTagLink> paramList = plantchecklistParamTagLinkRepository.getParamUpdatesByRev(revId);
			Set<Equipment> equipments = new HashSet<Equipment>();
			if(paramList.isEmpty()) {
				response.setType(WebAPIResponseType.EMPTY);
				response.setMessage("No updates found");
			}else {
				response.setType(WebAPIResponseType.LIST);
				response.setMessage("Equipment updates retrieved successfully");
				Iterator<PlantChecklistParamTagLink> itr = paramList.iterator();
				while(itr.hasNext()){
					PlantChecklistParamTagLink ob = itr.next();
					Equipment equip = new Equipment();
					equip.setCategoryId(ob.getChecklistId());
					equip.setCode(ob.getDescr().split("_")[0]);
					equip.setOrderNo(ob.getParamId());
					equipments.add(equip);
				}
			}
			response.setResultList(equipments);
			response.setResultCount(equipments.size());
			response.setStatus(WebAPIResponseStatus.SUCCESS);

			if(!paramList.isEmpty()) {
				List<Long> modifiedSrNos = new ArrayList<Long>();
				Iterator<PlantChecklistParamTagLink> itr = paramList.iterator();
				while(itr.hasNext()) {
					modifiedSrNos.add(itr.next().getModifiedEquipSrNo());
				}
				response.setToken(Collections.max(modifiedSrNos).toString());
			}
			LOGGER.info("response of API /equipment/updates/revid/" + revId + " produced followng response : " + response);

		} catch (Exception e) {
			response.setStatus(WebAPIResponseStatus.FAIL);
			response.setError(e.getMessage());
			LOGGER.error("response of API /equipment/updates/revid/" + revId + " produced followng error : ", e);

		}
		return response;
	}

	public WebAPIResponse<PlantChecklistParamTagLink> getParamUpdatesAfterRevId(Long revId) {
		WebAPIResponse<PlantChecklistParamTagLink> response = new WebAPIResponse<>();
		try {
			List<PlantChecklistParamTagLink> paramList = plantchecklistParamTagLinkRepository.getParamUpdatesByRev(revId);
			Iterator<PlantChecklistParamTagLink> itr = paramList.iterator();
			List<Long> modifiedSrNos = new ArrayList<Long>();
			if(paramList.isEmpty()) {
				response.setType(WebAPIResponseType.EMPTY);
				response.setMessage("No updates found");
			}else {
				
				while(itr.hasNext()) {
					PlantChecklistParamTagLink p = itr.next();
					p.setEquipCode(p.getDescr().split("_")[0]);
					p.setDescr(p.getDescr().split("_",2)[1]);
					modifiedSrNos.add(p.getModifiedEquipSrNo());
				}
				response.setType(WebAPIResponseType.LIST);
				response.setMessage("Parameter updates retrieved successfully");
				
				
			}
			response.setResultList(paramList);
			response.setResultCount(paramList.size());
			response.setStatus(WebAPIResponseStatus.SUCCESS);
			if(!modifiedSrNos.isEmpty()) {
				response.setToken(Collections.max(modifiedSrNos).toString());
			}
			LOGGER.info("response of API /param_mstr/equipment/updates/revid/" + revId + " produced followng response : " + response);
		} catch (Exception e) {
			response.setStatus(WebAPIResponseStatus.FAIL);
			response.setError(e.getMessage());
			LOGGER.info("response of API /param_mstr/equipment/updates/revid/" + revId + " produced followng error : " , e);
		}
		return response;
	}
}
