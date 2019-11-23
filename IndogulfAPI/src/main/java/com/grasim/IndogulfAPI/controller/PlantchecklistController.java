package com.grasim.IndogulfAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grasim.IndogulfAPI.model.PlantChecklist;
import com.grasim.IndogulfAPI.model.WebAPIResponse;
import com.grasim.IndogulfAPI.service.PlantChecklistService;

@RestController
@RequestMapping("category_mstr")
public class PlantchecklistController {

	@Autowired
	private PlantChecklistService pcService;
	
	@RequestMapping("/updates/revid/{revid}")
	public WebAPIResponse<PlantChecklist> getUpdatesAfterRevId(@PathVariable("revid") Long revId){
		System.out.println("inside getUpdatesAfterRevId");
		return pcService.getUpdatesAfterRevId(revId);
	}
	
	
}
