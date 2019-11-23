package com.grasim.IndogulfAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grasim.IndogulfAPI.model.Equipment;
import com.grasim.IndogulfAPI.model.WebAPIResponse;
import com.grasim.IndogulfAPI.service.PlantchecklistParamTagLinkService;

@RestController
@RequestMapping("equipment")
public class EquipmentController {

	@Autowired
	private PlantchecklistParamTagLinkService pcParamRepo;
	
	/*@RequestMapping("/catg_id/{catgId}")
	public WebAPIResponse<Equipment> getEquipCodes(@PathVariable("catgId") String catgId){
		System.out.println("inside getEquipCodes");
		return pcParamRepo.getEquipUpdatesAfterRevId(revId);
	}*/
	
	@RequestMapping("/updates/revid/{revid}")
	public WebAPIResponse<Equipment> getEquipCodesByRevId(@PathVariable("revid") Long revid){
		System.out.println("inside getEquipCodesByRevId");
		return pcParamRepo.getEquipUpdatesAfterRevId(revid);
	}
}