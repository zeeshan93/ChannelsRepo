package com.compassites.channels.dao;

import com.compassites.channels.daoModel.AgeGroupModel;
import com.compassites.channels.restModel.AgeGroupRestModel;

public interface AgeGroupDAO {

	int createAgeGroup(AgeGroupRestModel ageGroupRestModel);

	AgeGroupModel retrieveAgeGroup(int ageGroupId);

	int updateAgeGroupEntry(AgeGroupModel ageGroupModel);

	int deleteAgeGroupEntry(int ageGroupId);

}
