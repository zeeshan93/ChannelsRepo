package com.compassites.channels.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.compassites.channels.Exception.ChannelException;
import com.compassites.channels.dao.AgeGroupDAO;
import com.compassites.channels.dao.ChannelDAO;
import com.compassites.channels.daoModel.ChannelModel;
import com.compassites.channels.restModel.ChannelRestModel;

@Service
public class ChannelServiceImpl implements ChannelService {
	@Autowired
	private ChannelDAO channelsDAO;
	@Autowired
	private ChannelAgeGroupService channelAgeGroupService;
	@Autowired
	private AgeGroupDAO ageGroupDAO;

	@Override
	public String createChannels(ChannelRestModel channels, String ageGroupId) {
		if (channelsDAO.createChannels(channels) > 0)	{
			ChannelModel channelModel = retreiveChannelsByName(channels.getChannelTitle());
//			AgeGroupModel ageGroupModel = ageGroupDAO.retrieveAgeGroupByMinMaxAge(5, 10);
			channelAgeGroupService.channelAgeGroupTransaction(channelModel.getChannel_id(), ageGroupId);
			return "success";			
		}
		else
			return "failed";
	}

	@Override
	public ChannelModel retreiveChannels(String channelId) throws ChannelException{
		return channelsDAO.retreiveChannels(channelId);
	}
	
	@Override
	public ChannelModel retreiveChannelsByName(String channelName) {
		return channelsDAO.retreiveChannelsByName(channelName);
	}

	@Override
	public String deleteChannel(String channelId) {
		if (channelsDAO.deleteChannel(channelId) > 0)
			return "success";
		else
			return "failed";
	}

	@Override
	public String updateChannels(ChannelRestModel channelModel,String channelId) {
		if (channelsDAO.updateChannels(channelModel,channelId) > 0)
			return "success";
		else
			return "failed";
	}

	@Override
	public String saveProfileImage(MultipartFile profileImage, String mobnumb,String channelId) {
		
	    return channelsDAO.saveProfileImage(profileImage,mobnumb,channelId);
	}

	@Override
	public String uploadContent(MultipartFile profileImage, String mobnumb, String channelId) {

		return channelsDAO.uploadContent(profileImage, mobnumb, channelId);
	}

	
	
}

