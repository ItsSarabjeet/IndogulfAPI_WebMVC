package com.grasim.IndogulfAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grasim.IndogulfAPI.model.PlantChecklistParamTagLink;
import com.grasim.IndogulfAPI.model.WebAPIResponse;
import com.grasim.IndogulfAPI.service.PlantchecklistParamTagLinkService;

@RestController
@RequestMapping("param_mstr")
public class ParamController {
	@Autowired
	private PlantchecklistParamTagLinkService pcParamRepo;

	@RequestMapping("/updates/revid/{revid}")
	public WebAPIResponse<PlantChecklistParamTagLink> getEquipCodesByRevId(@PathVariable("revid") Long revid){
		System.out.println("inside getEquipCodesByRevId");
		return pcParamRepo.getParamUpdatesAfterRevId(revid);
	}

}
