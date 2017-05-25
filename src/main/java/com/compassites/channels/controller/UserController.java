package com.compassites.channels.controller;

import java.text.ParseException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.compassites.channels.service.AgeGroupService;
import com.compassites.channels.service.ChannelAgeGroupMappingService;
import com.compassites.channels.service.ChannelService;
import com.compassites.channels.service.UserService;
import com.compassites.channels.service.XStreamParsingService;
import com.compassites.channels.utils.ChannelsUtil;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AgeGroupService ageGroupService;
	
	@Autowired
	private ChannelAgeGroupMappingService channelAgeGroupMappingService;
	
	@Autowired
	private ChannelService channelService;
	
	@Autowired
	private XStreamParsingService xStreamParsingService;
	
	@RequestMapping(value = "/retrieve", method = RequestMethod.GET)
	public JSONObject retreiveUserVcardDetails(@RequestParam("userId") String userId) throws ParseException{
		JSONObject json = new JSONObject();
		json.put("vcardDetails", userService.retreiveUserVcardDetails(userId));
		//parse  the vcard and get dob
		String dob = xStreamParsingService.getDOBfromVcardXML(userService.retreiveUserVcardDetails(userId));
		
		int age = ChannelsUtil.calculateAgeFromDOB(dob);
		json.put("age", age);
		
		// get id of age group table for specied age
		//SELECT age_group_id FROM channels.age_group WHERE 26 between age_group_min and age_group_max;
		String ageGroupId = ageGroupService.getAgeGroupIdFromAge(age);
		json.put("ageGroupId", ageGroupId);
		
		//get list of channels
		List<String> channelIds = channelAgeGroupMappingService.getChannelIds(ageGroupId);
		json.put("list of channel ids", channelIds.get(0)+" , "+channelIds.get(1));
		
		//query channels to get channel info
		json.put("Channel Details are ", channelService.getChannelDetails(channelIds));
		return json;
	}
}
