package com.compassites.channels.service;

import org.springframework.web.multipart.MultipartFile;

import com.compassites.channels.daoModel.ChannelModel;

public interface ChannelService {
	

	public int createChannels(ChannelModel channels);
	public ChannelModel retreiveChannles(int channel_id);	
	public int deleteChannel(int channel_id);
	public int updateChannels(ChannelModel channelModel,int channel_id);
	public String saveProfileImage(MultipartFile profileImage,String mobnumb, int channel_id);
	public String uploadContent(MultipartFile profileImage,String mobnumb, int channel_id);

}
	
	

