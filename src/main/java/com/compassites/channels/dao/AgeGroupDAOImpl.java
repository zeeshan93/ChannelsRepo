package com.compassites.channels.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.compassites.channels.daoModel.AgeGroupModel;
import com.compassites.channels.restModel.AgeGroupRestModel;
import com.compassites.channels.utils.ChannelConstants;

@Repository
public class AgeGroupDAOImpl implements AgeGroupDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int createAgeGroup(AgeGroupRestModel ageGroupRestModel) {
		String sql = ChannelConstants.createAgeGroupQuery;

		return jdbcTemplate.update(sql, ageGroupRestModel.getAgeGroupMin(), ageGroupRestModel.getAgeGroupMax(),ageGroupRestModel.getAgeGroupDescription(),
				ageGroupRestModel.getCreatedDate(), ageGroupRestModel.getModifiedUserId(),
				ageGroupRestModel.getModifiedDate(), ageGroupRestModel.getIsActive());
	}

	@Override
	public AgeGroupModel retrieveAgeGroup(int ageGroupId) {
		String selectQuery = ChannelConstants.selectAgeGroupQuery;

		AgeGroupModel ageGroupModel = (AgeGroupModel) jdbcTemplate.queryForObject(selectQuery,
				new Object[] { ageGroupId }, new BeanPropertyRowMapper(AgeGroupModel.class));

		return ageGroupModel;

	}

	@Override
	public int updateAgeGroupEntry(AgeGroupModel ageGroupModel) {
		String sql = ChannelConstants.updateAgeGroupQuery;
		return jdbcTemplate.update(sql, ageGroupModel.getAgeGroupMin(), ageGroupModel.getAgeGroupMax(),ageGroupModel.getAgeGroupDescription(),
				ageGroupModel.getCreatedDate(), ageGroupModel.getModifiedUserId(),
				ageGroupModel.getModifiedDate(), ageGroupModel.getIsActive(), ageGroupModel.getAgeGroupId());
	}

	@Override
	public int deleteAgeGroupEntry(int ageGroupId) {
		String sql = ChannelConstants.deleteAgeGroupQuery;
		return jdbcTemplate.update(sql, ageGroupId);
	}

}
