package com.compassites.channels.dao;

import org.springframework.web.multipart.MultipartFile;

import com.compassites.channels.daoModel.ChannelModel;
public interface ChannelDAO {
	public int createChannels(ChannelModel channels);

	//public ChannelModel retreiveChannles(int channels);
	public ChannelModel retreiveChannles(int channel_id);
	public int deleteChannel(int channel_id);
	public int updateChannels(ChannelModel channelModel,int channel_id);
	public String saveProfileImage(MultipartFile profileImage,String mobnumb,int channel_id);
	public String uploadContent(MultipartFile profileImage,String mobnumb, int channel_id);


}

