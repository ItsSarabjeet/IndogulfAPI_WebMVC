package com.grasim.IndogulfAPI.service;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.persistence.NoResultException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.grasim.IndogulfAPI.model.User;
import com.grasim.IndogulfAPI.model.WebAPIResponse;
import com.grasim.IndogulfAPI.model.WebAPIResponseStatus;
import com.grasim.IndogulfAPI.model.WebAPIResponseType;
import com.grasim.IndogulfAPI.repository.UserRepository;
import com.grasim.IndogulfAPI.util.GlobalFunction;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	GlobalFunction global = new GlobalFunction();
	
	private static final Logger LOGGER = Logger.getLogger(UserService.class);
	
	public WebAPIResponse<User> getUpdatesAfterRevId(Long revId) {
		WebAPIResponse<User> response = new WebAPIResponse<>();
		try {
			List<User> users = userRepository.getAllAfterRevId(revId);
			if(users.isEmpty()) {
				response.setType(WebAPIResponseType.EMPTY);
				response.setMessage("No updates found");
				response.setResultList(users);
			}else {
				response.setType(WebAPIResponseType.LIST);
				response.setMessage("User updates retrieved successfully");
				response.setResultList(users);
			}
			response.setResultCount(users.size());
			response.setStatus(WebAPIResponseStatus.SUCCESS);
			
			if(!users.isEmpty()) {
				List<Long> modifiedSrNos = new ArrayList<Long>();
				Iterator<User> itr = users.iterator();
				while(itr.hasNext()) {
					modifiedSrNos.add(itr.next().getModifiedSrNo());
				}
				response.setToken(Collections.max(modifiedSrNos).toString());
			}
			
			LOGGER.info("response of API /user/updates/revid/" + revId + " produced followng response : " + response);
			
		} catch (Exception e) {
			response.setStatus(WebAPIResponseStatus.FAIL);
			response.setError(e.getMessage());
			LOGGER.error("API /user/updates/revid/" + revId + " produced followng error : " , e);
		}
		return response;
	}

	public WebAPIResponse<User> getAll() {
		WebAPIResponse<User> response = new WebAPIResponse<>();
		try {
			List<User> users = (List<User>) userRepository.getAll();
			if(users.isEmpty()) {
				response.setType(WebAPIResponseType.EMPTY);
				response.setMessage("No updates found");
				response.setResultList(users);
			}else {
				response.setType(WebAPIResponseType.LIST);
				response.setMessage("User updates retrieved successfully");
				response.setResultList(users);
			}
			response.setResultCount(users.size());
			response.setStatus(WebAPIResponseStatus.SUCCESS);
			
			if(!users.isEmpty()) {
				List<Long> modifiedSrNos = new ArrayList<Long>();
				Iterator<User> itr = users.iterator();
				while(itr.hasNext()) {
					modifiedSrNos.add(itr.next().getModifiedSrNo());
				}
				response.setToken(Collections.max(modifiedSrNos).toString());
			}
			
			LOGGER.info("response of API /user/all produced following response : " + response);
			
		} catch (Exception e) {
			response.setStatus(WebAPIResponseStatus.FAIL);
			response.setError(e.getMessage());
			
			LOGGER.error("response of API /user/all caused following error : " , e);
		}
		return response;
	}

	public WebAPIResponse<User> getByUsername(String username) {
		WebAPIResponse<User> response = new WebAPIResponse<>();
		try {
			User user = userRepository.getByUsername(username);
			
			response.setType(WebAPIResponseType.OBJECT);
			response.setMessage("User retrieved successfully");
			response.setResultItem(user);
			response.setResultCount(1);
			response.setStatus(WebAPIResponseStatus.SUCCESS);
			
			LOGGER.info("response of API /user/username/" + username + " produced following response : " + response);
			
		}catch(NoResultException e) {
			response.setStatus(WebAPIResponseStatus.SUCCESS);
			response.setType(WebAPIResponseType.EMPTY);
			response.setMessage("No user found");
			LOGGER.error("response of API /user/username/" + username + " produced following error : ",e);
		}
		catch (Exception e) {
			response.setStatus(WebAPIResponseStatus.FAIL);
			response.setError(e.getMessage());
			LOGGER.error("response of API /user/username/" + username + " produced following error : ",e);
		}
		return response;
	}

	public User save(User user) {
		LOGGER.info("saving user " + user);
		return userRepository.save(user);
	}

}