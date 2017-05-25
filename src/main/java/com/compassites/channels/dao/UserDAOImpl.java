package com.compassites.channels.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.compassites.channels.daoModel.VCardModel;
import com.compassites.channels.utils.ChannelConstants;

@Repository
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	@Qualifier("bushfireJdbcTemplate") 
	private JdbcTemplate jdbcTemplate;

	@Override
	public String retreiveUserVcardDetails(String userId) {
		String selectQuery = ChannelConstants.selectVcardByUserId;
		VCardModel vcard = (VCardModel) jdbcTemplate.queryForObject(selectQuery,
				new Object[] { userId }, new BeanPropertyRowMapper(VCardModel.class));
		return vcard.getvCard();
	}
}
