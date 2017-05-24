package com.compassites.channels.dao;

import org.springframework.web.multipart.MultipartFile;

import com.compassites.channels.Exception.ChannelException;
import com.compassites.channels.daoModel.ChannelModel;
import com.compassites.channels.restModel.ChannelRestModel;
public interface ChannelDAO {
	public int createChannels(ChannelRestModel channels);

	//public ChannelModel retreiveChannles(int channels);
	public ChannelModel retreiveChannels(String channelId) throws ChannelException;
	public int deleteChannel(String channelId);
	public int updateChannels(ChannelRestModel channelModel,String channelId);
	public String saveProfileImage(MultipartFile profileImage,String mobnumb,String channelId);
	public String uploadContent(MultipartFile profileImage,String mobnumb, String channel_id);

	public ChannelModel retreiveChannelsByName(String channelName);

}

