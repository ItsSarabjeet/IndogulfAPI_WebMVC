package com.grasim.IndogulfAPI.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grasim.IndogulfAPI.model.Settings;
import com.grasim.IndogulfAPI.model.WebAPIResponse;
import com.grasim.IndogulfAPI.model.WebAPIResponseStatus;
import com.grasim.IndogulfAPI.model.WebAPIResponseType;
import com.grasim.IndogulfAPI.repository.SettingsRepository;

@Service
public class SettingsService {

	@Autowired
	private SettingsRepository settingsRepository;
	
	private static final Logger LOGGER = Logger.getLogger(SettingsService.class);
	
	public WebAPIResponse<Settings> getUpdatesAfterRevId(Long revId) {
		WebAPIResponse<Settings> response = new WebAPIResponse<>();
		try {
			List<Settings> chklist = settingsRepository.getAllAfterRevId(revId);
			if(chklist.isEmpty()) {
				response.setType(WebAPIResponseType.EMPTY);
				response.setMessage("No updates found");
				response.setResultList(chklist);
			}else {
				response.setType(WebAPIResponseType.LIST);
				response.setMessage("Settings updates retrieved successfully");
				response.setResultList(chklist);
			}
			response.setResultCount(chklist.size());
			response.setStatus(WebAPIResponseStatus.SUCCESS);
			
			if(!chklist.isEmpty()) {
				List<Long> modifiedSrNos = new ArrayList<Long>();
				Iterator<Settings> itr = chklist.iterator();
				while(itr.hasNext()) {
					modifiedSrNos.add(itr.next().getModifiedSrNo());
				}
				response.setToken(Collections.max(modifiedSrNos).toString());
			}
			
			LOGGER.info("response of API /settings/updates/revid/" + revId + " produced followng response : " + response);

		} catch (Exception e) {
			response.setStatus(WebAPIResponseStatus.FAIL);
			response.setError(e.getMessage());
			LOGGER.error("API /settings/updates/revid/" + revId + " produced followng error : " , e);
		}
		return response;
	}
	
	public WebAPIResponse<Settings> getAll() {
		WebAPIResponse<Settings> response = new WebAPIResponse<>();
		try {
			List<Settings> chklist = (List<Settings>) settingsRepository.getAll();
			if(chklist.isEmpty()) {
				response.setType(WebAPIResponseType.EMPTY);
				response.setMessage("No updates found");
				response.setResultList(chklist);
			}else {
				response.setType(WebAPIResponseType.LIST);
				response.setMessage("Settings updates retrieved successfully");
				response.setResultList(chklist);
			}
			response.setResultCount(chklist.size());
			response.setStatus(WebAPIResponseStatus.SUCCESS);

			if(!chklist.isEmpty()) {
				List<Long> modifiedSrNos = new ArrayList<Long>();
				Iterator<Settings> itr = chklist.iterator();
				while(itr.hasNext()) {
					modifiedSrNos.add(itr.next().getModifiedSrNo());
				}
				response.setToken(Collections.max(modifiedSrNos).toString());
			}
			
			LOGGER.info("response of API /settings/all produced following response : " + response);

		} catch (Exception e) {
			response.setStatus(WebAPIResponseStatus.FAIL);
			response.setError(e.getMessage());
			LOGGER.error(" /settings/all produced following error : " , e);
		}
		return response;
	}

}
