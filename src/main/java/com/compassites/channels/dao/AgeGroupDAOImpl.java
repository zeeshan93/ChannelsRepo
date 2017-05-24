package com.compassites.channels.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.compassites.channels.Exception.AgeGroupException;
import com.compassites.channels.Exception.CategoryException;
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

		String createdDate = null;

		UUID uuid = UUID.randomUUID();
		String randomUUIDString = uuid.toString();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		createdDate = sdf.format(new Date());

		return jdbcTemplate.update(sql, randomUUIDString, ageGroupRestModel.getAgeGroupMin(),
				ageGroupRestModel.getAgeGroupMax(), ageGroupRestModel.getAgeGroupDescription(), createdDate,
				ageGroupRestModel.getModifiedUserId());
	}

	@Override
	public AgeGroupModel retrieveAgeGroup(String ageGroupId) throws AgeGroupException {

		Integer count = jdbcTemplate.queryForObject("SELECT count(*) FROM age_group where age_group_id = ?",
				Integer.class, ageGroupId);
		if (count > 0) {
			String selectQuery = ChannelConstants.selectAgeGroupQuery;

			AgeGroupModel ageGroupModel = (AgeGroupModel) jdbcTemplate.queryForObject(selectQuery,
					new Object[] { ageGroupId }, new BeanPropertyRowMapper(AgeGroupModel.class));

			return ageGroupModel;
		} else {
			throw new AgeGroupException("Invalid Age Group Id. Please Enter a valid Age Group Id.");
		}
	}
	
	/*@Override
	public AgeGroupModel retrieveAgeGroupByMinMaxAge(int minAge, int maxAge) {
		String selectQuery = "select * from age_group where age_group_min = ? AND age_group_max = ?";

		AgeGroupModel ageGroupModel = (AgeGroupModel) jdbcTemplate.queryForObject(selectQuery,
				new Object[] { minAge, maxAge }, new BeanPropertyRowMapper(AgeGroupModel.class));

		return ageGroupModel;

	}*/

	@Override
	public int updateAgeGroupEntry(AgeGroupRestModel ageGroupRestModel, String ageGroupId) {
		String sql = ChannelConstants.updateAgeGroupQuery;
		return jdbcTemplate.update(sql, ageGroupRestModel.getAgeGroupMin(), ageGroupRestModel.getAgeGroupMax(),
				ageGroupRestModel.getAgeGroupDescription(), ageGroupRestModel.getModifiedUserId(), ageGroupId);
	}

	@Override
	public int deleteAgeGroupEntry(String ageGroupId) {
		String sql = ChannelConstants.deleteAgeGroupQuery;
		return jdbcTemplate.update(sql, ageGroupId);
	}

}
