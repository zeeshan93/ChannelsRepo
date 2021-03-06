package com.compassites.channels.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.compassites.channels.Exception.ChannelException;
import com.compassites.channels.daoModel.ChannelModel;
import com.compassites.channels.restModel.ChannelRestModel;

public interface ChannelService {
	


	public String createChannels(ChannelRestModel channels,String ageGroupId);
	public ChannelModel retreiveChannels(String channel_id) throws ChannelException;	
	public String deleteChannel(String channelId);
	public String updateChannels(ChannelRestModel channelModel,String channel_id);
	public String saveProfileImage(MultipartFile profileImage,String mobnumb, String channelId);
	public String uploadContent(MultipartFile profileImage,String mobnumb, String channel_id);
	ChannelModel retreiveChannelsByName(String channelName);
	public List<ChannelModel> getChannelDetails(List<String> channelIds);

}
	
	

