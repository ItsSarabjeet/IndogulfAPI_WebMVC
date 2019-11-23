package com.grasim.IndogulfAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grasim.IndogulfAPI.model.CategoryRoleMapping;
import com.grasim.IndogulfAPI.model.WebAPIResponse;
import com.grasim.IndogulfAPI.service.CategoryRoleMappingService;

@RestController
@RequestMapping("catrolemap")
public class CategoryRoleMappingController {
	
	@Autowired
	private CategoryRoleMappingService categoryRoleMappingService;

	@RequestMapping("/updates/revid/{revid}")
	public WebAPIResponse<CategoryRoleMapping> getSettingsByRevid(@PathVariable("revid") Long revid){
		System.out.println("inside CategoryRoleMapping updates revid");
		return categoryRoleMappingService.getUpdatesAfterRevId(revid);
	}
}