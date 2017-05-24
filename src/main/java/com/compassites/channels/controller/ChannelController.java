package com.compassites.channels.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.compassites.channels.service.ChannelService;


@RestController
@RequestMapping("/channel")
public class ChannelController {
	@Autowired
	ChannelService channelsService;

	// Create Channels
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public JSONObject createChannel(@RequestBody ChannelRestModel channels, @RequestParam("age_group_id") String ageGroupId) {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("status", 200);
		jsonObj.put("message", "Adding Channel " + channelsService.createChannels(channels, ageGroupId));
		return jsonObj;
		
	}

	// Retrieve the Lists of channels based on channel id.
	@RequestMapping(value = "/retreive", method = RequestMethod.GET)
	public ChannelModel retreiveChannles(@RequestParam(value = "channel_id") String channelId) throws ChannelException {
		return channelsService.retreiveChannels(channelId);
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
	public JSONObject updateUser(@RequestBody ChannelRestModel channelModel,
			@RequestParam(value = "channel_id") String channelId) {
		
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


}


