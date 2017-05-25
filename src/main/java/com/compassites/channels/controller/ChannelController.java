package com.compassites.channels.controller;

import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.compassites.channels.Exception.CategoryException;
import com.compassites.channels.Exception.ChannelException;
import com.compassites.channels.daoModel.ChannelModel;
import com.compassites.channels.restModel.ChannelRestModel;
import com.compassites.channels.service.AgeGroupService;
import com.compassites.channels.service.ChannelAgeGroupMappingService;
import com.compassites.channels.service.ChannelService;
import com.compassites.channels.service.UserService;
import com.compassites.channels.service.XStreamParsingService;
import com.compassites.channels.utils.ChannelsUtil;
import com.compassites.channels.utils.JsonObject;


@RestController
@RequestMapping("/channel")
public class ChannelController {
	@Autowired
	ChannelService channelsService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AgeGroupService ageGroupService;
	
	@Autowired
	private ChannelAgeGroupMappingService channelAgeGroupMappingService;
	
	@Autowired
	private XStreamParsingService xStreamParsingService;

	// Create Channels
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public JSONObject createChannel(@RequestBody @Valid ChannelRestModel channels,BindingResult bindingResult,@RequestParam("age_group_id") String ageGroupId) {
		
		if (bindingResult.hasErrors()) {
			return JsonObject.getJsonObjectFromBindingResult(bindingResult);
		}
		
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("status", 200);
		jsonObj.put("message", "Adding Channel " + channelsService.createChannels(channels, ageGroupId));
		return jsonObj;
		
	}

	// Retrieve the Lists of channels based on channel id.
	@RequestMapping(value = "/retreive", method = RequestMethod.GET)
	public ChannelModel retreiveChannles(@RequestParam(value = "channel_id") String channelId) throws ChannelException {
		try {
		return channelsService.retreiveChannels(channelId);
		}catch(ChannelException e){
			throw new ChannelException(e.getMessage());
		}
	}
    //Delete the channel by passing the channel_id
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public JSONObject deleteUser(@RequestParam(value = "channel_id") String channelId) {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("status", 200);
		jsonObj.put("message", "Deleting Channel with channel_id = " + channelId + " is "
				+ channelsService.deleteChannel(channelId));
		return jsonObj;
	}
   //Update the channel by passing the channel_id
	@RequestMapping(value = "/update", method = RequestMethod.PATCH)
	public JSONObject updateUser(@RequestBody @Valid ChannelRestModel channelModel,BindingResult bindingResult ,
			@RequestParam(value = "channel_id") String channelId) {
		if (bindingResult.hasErrors()) {
			return JsonObject.getJsonObjectFromBindingResult(bindingResult);
		}
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("status", 200);
		jsonObj.put("message", "Updating channel with channel_id = " + channelId + " is "
				+ channelsService.updateChannels(channelModel, channelId));
		return jsonObj;
	}
   //Upload the user profile image by passing the mobile number, channel_id
	@RequestMapping(value = "/profileImage",  headers = {"content-type=application/json"}, method = RequestMethod.POST)
	public String uploadUserProfileImage(@RequestParam("file") MultipartFile image,
			@RequestParam(value = "mobilenumb") String mobnumb, @RequestParam(value = "channel_id") String channelId) throws ChannelException {
		String channel_profile_image_path = null;
		channel_profile_image_path = channelsService.saveProfileImage(image, mobnumb, channelId);
		ChannelModel channelModel = channelsService.retreiveChannels(channelId);
		channelModel.setChannel_profile_image_path(channel_profile_image_path);
		ChannelRestModel channelRestModel = new ChannelRestModel();
		channelRestModel.setChannelCreatedUserId(channelModel.getChannel_created_user_id());
		channelRestModel.setChannelDescription(channelModel.getChannel_description());
		channelRestModel.setChannelPreferGender(channelModel.getChannel_prefer_gender());
		channelRestModel.setChannelProfileImagePath(channelModel.getChannel_profile_image_path());
		channelRestModel.setChannelTitle(channelModel.getChannel_title());
		channelRestModel.setModifiedUserId(channelModel.getModified_user_id());
		return channelsService.updateChannels(channelRestModel, channelId);

	}
	
	@RequestMapping(value = "/fetch", method = RequestMethod.GET)
	public JSONObject fetchAllChannels(@RequestParam("userId") String userId) throws ParseException {
		JSONObject json = new JSONObject();
		//get the date of birth from vcard
		String dob = xStreamParsingService.getDOBfromVcardXML(userService.retreiveUserVcardDetails(userId));
		//calculate the age
		int age = ChannelsUtil.calculateAgeFromDOB(dob);
		//get the age group id
		String ageGroupId = ageGroupService.getAgeGroupIdFromAge(age);
		//get channel ids for that age group
		List<String> channelIds = channelAgeGroupMappingService.getChannelIds(ageGroupId);
		//get channels based on that channel id
		List<ChannelModel> channelModelList = channelsService.getChannelDetails(channelIds); 
		if(channelModelList.isEmpty() || channelModelList == null){
			json.put("Channels","No Channels available");
		} else{
			json.put("Channels", channelsService.getChannelDetails(channelIds));
		}
		return json;

	}


}


