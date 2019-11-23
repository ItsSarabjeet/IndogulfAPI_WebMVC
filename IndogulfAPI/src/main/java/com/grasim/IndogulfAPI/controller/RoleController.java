package com.grasim.IndogulfAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grasim.IndogulfAPI.model.Role;
import com.grasim.IndogulfAPI.model.WebAPIResponse;
import com.grasim.IndogulfAPI.service.RoleService;

@RestController
@RequestMapping("role")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@RequestMapping("/updates/revid/{revid}")
	public WebAPIResponse<Role> getSettingsByRevid(@PathVariable("revid") Long revid){
		System.out.println("inside role updates revid");
		return roleService.getUpdatesAfterRevId(revid);
	}
}