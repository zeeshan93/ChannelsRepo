package com.compassites.channels.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.compassites.channels.dao.ChannelDAO;
import com.compassites.channels.daoModel.ChannelModel;

@Service
public class ChannelServiceImpl implements ChannelService {
	@Autowired
	ChannelDAO channelsDAO;

	@Override
	public int createChannels(ChannelModel channels) {
		return channelsDAO.createChannels(channels);
	}

	@Override
	public ChannelModel retreiveChannles(int channel_id) {
		return channelsDAO.retreiveChannles(channel_id);

	}

	@Override
	public int deleteChannel(int channel_id) {
		return channelsDAO.deleteChannel(channel_id);
	}

	@Override
	public int updateChannels(ChannelModel channelModel,int channel_id) {
		return channelsDAO.updateChannels(channelModel,channel_id);
	}

	@Override
	public String saveProfileImage(MultipartFile profileImage, String mobnumb,int channel_id) {
		
	    return channelsDAO.saveProfileImage(profileImage,mobnumb,channel_id);
	}

	@Override
	public String uploadContent(MultipartFile profileImage, String mobnumb, int channel_id) {

		return channelsDAO.uploadContent(profileImage, mobnumb, channel_id);
	}

	
	
}

