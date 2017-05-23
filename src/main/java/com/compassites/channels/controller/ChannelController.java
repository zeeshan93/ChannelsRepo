package com.compassites.channels.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.compassites.channels.daoModel.ChannelModel;
import com.compassites.channels.service.ChannelService;


@RestController
@RequestMapping("/channel")
public class ChannelController {
	@Autowired
	ChannelService channelsService;

	// Create Channels
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createChannel(@RequestBody ChannelModel channels) {
		if (channelsService.createChannels(channels) > 0)
			return "success";
		else
			return "failed";
	}

	// Retrieve the Lists of channels based on channel id.
	@RequestMapping(value = "/retreive", method = RequestMethod.GET)
	public ChannelModel retreiveChannles(@RequestParam(value = "channel_id") int channel_id) {
		return channelsService.retreiveChannles(channel_id);
	}
    //Delete the channel by passing the channel_id
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public String deleteUser(@RequestParam(value = "channel_id") int channel_id) {
		channelsService.deleteChannel(channel_id);
		return "success";

	}
   //Update the channel by passing the channel_id
	@RequestMapping(value = "/update", method = RequestMethod.PATCH)
	public String updateUser(@RequestBody ChannelModel channelModel,
			@RequestParam(value = "channel_id") int channel_id) {
		channelsService.updateChannels(channelModel, channel_id);
		return "Success";
	}
   //Upload the user profile image by passing the mobile number, channel_id
	@RequestMapping(value = "/profileImage",  headers = {"content-type=application/json"}, method = RequestMethod.POST)
	public int uploadUserProfileImage(@RequestParam("file") MultipartFile image,
			@RequestParam(value = "mobilenumb") String mobnumb, @RequestParam(value = "channel_id") int channel_id) {
		String channel_profile_image_path = null;
		channel_profile_image_path = channelsService.saveProfileImage(image, mobnumb, channel_id);
		ChannelModel channelModel = channelsService.retreiveChannles(channel_id);
		channelModel.setChannel_profile_image_path(channel_profile_image_path);
		return channelsService.updateChannels(channelModel, channel_id);

	}


}


