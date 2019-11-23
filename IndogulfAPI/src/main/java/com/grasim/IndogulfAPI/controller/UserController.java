package com.grasim.IndogulfAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grasim.IndogulfAPI.model.User;
import com.grasim.IndogulfAPI.model.WebAPIResponse;
import com.grasim.IndogulfAPI.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/updates/revid/{revid}")
	public WebAPIResponse<User> getSettingsByRevid(@PathVariable("revid") Long revid){
		System.out.println("inside user updates revid");
		return userService.getUpdatesAfterRevId(revid);
	}

	@RequestMapping("/all")
	public WebAPIResponse<User> getAll(){
		System.out.println("inside user all");
		return userService.getAll();
	}
	
	@RequestMapping("/username/{username}")
	public WebAPIResponse<User> getByUsername(@PathVariable("username") String username){
		System.out.println("inside user name");
		return userService.getByUsername(username);
	}
}
