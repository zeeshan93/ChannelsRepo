package com.compassites.channels.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ChannelAgeGroupMappingDAOImpl implements ChannelAgeGroupMappingDAO {

	@Autowired
	@Qualifier("channelsJdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<String> getChannelIds(String ageGroupId) {
		String selectQuery = "SELECT channel_id FROM channel_age_group where age_group_id = ?";
		List<String> channelIds = (List<String>) jdbcTemplate.query(selectQuery, new Object[] { ageGroupId },
				new org.springframework.jdbc.core.RowMapper<String>() {
					public String mapRow(ResultSet rs, int rowNum) throws SQLException {
						return rs.getString(1);
					}
				});
		// List<String> channelIds = jdbcTemplate.queryForObject(selectQuery,new
		// Object[] { ageGroupId },List.class);
		/*
		 * List<String> channelIds = new ArrayList<String>();
		 * for(ChannelAgeGroupMappingModel channelAgeGroupMappingModel :
		 * listOfChannelAgeGroupMappingModel){
		 * channelIds.add(channelAgeGroupMappingModel.getChannelId()); }
		 */
		return channelIds;
	}

}
