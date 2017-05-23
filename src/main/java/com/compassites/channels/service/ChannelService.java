package com.compassites.channels.service;

import org.springframework.web.multipart.MultipartFile;

import com.compassites.channels.daoModel.ChannelModel;
import com.compassites.channels.restModel.ChannelRestModel;

public interface ChannelService {
	

	public String createChannels(ChannelRestModel channels);
	public ChannelModel retreiveChannels(String channel_id);	
	public String deleteChannel(String channelId);
	public String updateChannels(ChannelRestModel channelModel,String channel_id);
	public String saveProfileImage(MultipartFile profileImage,String mobnumb, String channelId);
	public String uploadContent(MultipartFile profileImage,String mobnumb, String channel_id);

}
	
	

