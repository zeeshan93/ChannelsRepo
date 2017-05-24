package com.compassites.channels.dao;

import com.compassites.channels.daoModel.AgeGroupModel;
import com.compassites.channels.restModel.AgeGroupRestModel;

public interface AgeGroupDAO {

	int createAgeGroup(AgeGroupRestModel ageGroupRestModel);

	AgeGroupModel retrieveAgeGroup(String ageGroupId);

	int updateAgeGroupEntry(AgeGroupRestModel ageGroupRestModel, String ageGroupId);

	int deleteAgeGroupEntry(String ageGroupId);

//	AgeGroupModel retrieveAgeGroupByMinMaxAge(int minAge, int maxAge);

}
