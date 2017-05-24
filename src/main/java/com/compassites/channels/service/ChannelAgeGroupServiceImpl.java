package com.compassites.channels.service;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ChannelAgeGroupServiceImpl implements ChannelAgeGroupService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	Logger logger = LoggerFactory.getLogger(ChannelAgeGroupServiceImpl.class);

	@Override
	public String channelAgeGroupTransaction(String channelId, String ageGroupId) {
		UUID uuid = UUID.randomUUID();
		String channelAgeGroupId = uuid.toString();

		String sql = "INSERT INTO channel_age_group (channel_age_group_id,channel_id,age_group_id) values (?,"
				+ "(select channel_id from channels where channel_id = \"" + channelId + "\"),"
				+ "(select age_group_id from age_group where age_group_id = \"" + ageGroupId + "\"))";

		int count = jdbcTemplate.update(sql, channelAgeGroupId);

		if (count > 0) {
			logger.info("success");
		} else {
			logger.info("failed");
		}

		return null;
	}

}