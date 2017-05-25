package com.compassites.channels.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compassites.channels.dao.ChannelAgeGroupMappingDAO;

@Service
public class ChannelAgeGroupMappingServiceImpl implements ChannelAgeGroupMappingService {

	@Autowired
	private ChannelAgeGroupMappingDAO channelAgeGroupMappingDAO;
	
	@Override
	public List<String> getChannelIds(String ageGroupId) {
		// TODO Auto-generated method stub
		return channelAgeGroupMappingDAO.getChannelIds(ageGroupId);
	}

}
