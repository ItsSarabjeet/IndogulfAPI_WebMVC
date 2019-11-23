package com.grasim.IndogulfAPI.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grasim.IndogulfAPI.model.Role;
import com.grasim.IndogulfAPI.model.WebAPIResponse;
import com.grasim.IndogulfAPI.model.WebAPIResponseStatus;
import com.grasim.IndogulfAPI.model.WebAPIResponseType;
import com.grasim.IndogulfAPI.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepo;
	
	private static final Logger LOGGER = Logger.getLogger(RoleService.class);
	
	public WebAPIResponse<Role> getUpdatesAfterRevId(Long revId) {
		WebAPIResponse<Role> response = new WebAPIResponse<>();
		try {
			List<Role> chklist = roleRepo.getAllAfterRevId(revId);
			if(chklist.isEmpty()) {
				response.setType(WebAPIResponseType.EMPTY);
				response.setMessage("No updates found");
				response.setResultList(chklist);
			}else {
				response.setType(WebAPIResponseType.LIST);
				response.setMessage("Role updates retrieved successfully");
				response.setResultList(chklist);
			}
			response.setResultCount(chklist.size());
			response.setStatus(WebAPIResponseStatus.SUCCESS);
			
			if(!chklist.isEmpty()) {
				List<Long> modifiedSrNos = new ArrayList<Long>();
				Iterator<Role> itr = chklist.iterator();
				while(itr.hasNext()) {
					modifiedSrNos.add(itr.next().getModifiedSrNo());
				}
				response.setToken(Collections.max(modifiedSrNos).toString());
			}
			LOGGER.info("response of API /role/updates/revid/" + revId + " produced followng response : " + response);
		} catch (Exception e) {
			response.setStatus(WebAPIResponseStatus.FAIL);
			response.setError(e.getMessage());
			LOGGER.error("response of API /role/updates/revid/" + revId + " produced followng error : ", e);
		}
		return response;
	}
}
