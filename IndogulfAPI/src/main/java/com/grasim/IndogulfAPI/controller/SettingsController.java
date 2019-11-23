package com.grasim.IndogulfAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grasim.IndogulfAPI.model.Settings;
import com.grasim.IndogulfAPI.model.WebAPIResponse;
import com.grasim.IndogulfAPI.service.SettingsService;

@RestController
@RequestMapping("settings")
public class SettingsController {

	@Autowired
	private SettingsService settingsService;

	@RequestMapping("/updates/revid/{revid}")
	public WebAPIResponse<Settings> getSettingsByRevid(@PathVariable("revid") Long revid){
		System.out.println("inside settings updates revid");
		return settingsService.getUpdatesAfterRevId(revid);
	}

	@RequestMapping("/all")
	public WebAPIResponse<Settings> getAll(){
		System.out.println("inside settings all");
		return settingsService.getAll();
	}
}
