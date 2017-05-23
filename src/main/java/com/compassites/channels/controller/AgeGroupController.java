package com.compassites.channels.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.compassites.channels.Exception.AgeGroupException;
import com.compassites.channels.daoModel.AgeGroupModel;
import com.compassites.channels.restModel.AgeGroupRestModel;
import com.compassites.channels.service.AgeGroupService;

@RestController
@RequestMapping("/age-group")
public class AgeGroupController {
	
	@Autowired
	private AgeGroupService ageGroupService;
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public JSONObject createCategory(@RequestBody AgeGroupRestModel ageGroupRestModel) throws AgeGroupException{
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("status", 200);
		try {
			jsonObj.put("message", "Adding age-group "+ageGroupService.createAgeGroup(ageGroupRestModel));
		} catch (AgeGroupException e) {
			throw new AgeGroupException(e.getMessage());
		}
		return jsonObj;
	}
	
	@RequestMapping(value = "/retrieve", method = RequestMethod.GET)
	public AgeGroupModel retrieveAgeGroupEntry(@RequestParam(value = "ageGroupId") String ageGroupId){
		return ageGroupService.retrieveAgeGroup(ageGroupId);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PATCH)
	public JSONObject updateAgeGroupEntry(@RequestBody AgeGroupRestModel ageGroupRestModel, @RequestParam("ageGroupId") String ageGroupId){		
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("status", 200);
		jsonObj.put("message", "Updating age group entry is "+ageGroupService.updateAgeGroupEntry(ageGroupRestModel, ageGroupId));
		return jsonObj;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public JSONObject deleteAgeGroupEntry(
			@RequestParam(value = "ageGroupId") int ageGroupId) {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("status", 200);
		jsonObj.put("message", "Deleting age group entry is "+ageGroupService.deleteAgeGroupEntry(ageGroupId));
		return jsonObj;
	}

}
