package com.grasim.IndogulfAPI.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grasim.IndogulfAPI.model.CategoryRoleMapping;
import com.grasim.IndogulfAPI.model.WebAPIResponse;
import com.grasim.IndogulfAPI.model.WebAPIResponseStatus;
import com.grasim.IndogulfAPI.model.WebAPIResponseType;
import com.grasim.IndogulfAPI.repository.CategoryRoleMappingRepository;

@Service
public class CategoryRoleMappingService {

	@Autowired
	private CategoryRoleMappingRepository catRoleRepo;
	
	private static final Logger LOGGER = Logger.getLogger(CategoryRoleMappingService.class);

	public WebAPIResponse<CategoryRoleMapping> getUpdatesAfterRevId(Long revId) {
		WebAPIResponse<CategoryRoleMapping> response = new WebAPIResponse<>();
		try {
			List<CategoryRoleMapping> chklist = catRoleRepo.getAllAfterRevId(revId);
			if(chklist.isEmpty()) {
				response.setType(WebAPIResponseType.EMPTY);
				response.setMessage("No updates found");
				response.setResultList(chklist);
			}else {
				response.setType(WebAPIResponseType.LIST);
				response.setMessage("CategoryRoleMapping updates retrieved successfully");
				response.setResultList(chklist);
			}
			response.setResultCount(chklist.size());
			response.setStatus(WebAPIResponseStatus.SUCCESS);
			
			if(!chklist.isEmpty()) {
				List<Long> modifiedSrNos = new ArrayList<Long>();
				Iterator<CategoryRoleMapping> itr = chklist.iterator();
				while(itr.hasNext()) {
					modifiedSrNos.add(itr.next().getModifiedSrNo());
				}
				response.setToken(Collections.max(modifiedSrNos).toString());
			}
			LOGGER.info("response of API /catrolemap/updates/revid/" + revId + " produced followng response : " + response);

		} catch (Exception e) {
			response.setStatus(WebAPIResponseStatus.FAIL);
			response.setError(e.getMessage());
			LOGGER.error("response of API /catrolemap/updates/revid/" + revId + " produced followng error : ", e);

		}
		return response;
	}
}
