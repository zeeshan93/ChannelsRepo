package com.compassites.channels.service;

import com.compassites.channels.daoModel.AgeGroupModel;
import com.compassites.channels.restModel.AgeGroupRestModel;

public interface AgeGroupService {

	String createAgeGroup(AgeGroupRestModel ageGroupRestModel);

	AgeGroupModel retrieveAgeGroup(int ageGroupId);

	String updateAgeGroupEntry(AgeGroupModel ageGroupModel);

	String deleteAgeGroupEntry(int ageGroupId);

}
