package com.compassites.channels.service;

import com.compassites.channels.Exception.AgeGroupException;
import com.compassites.channels.daoModel.AgeGroupModel;
import com.compassites.channels.restModel.AgeGroupRestModel;

public interface AgeGroupService {

	String createAgeGroup(AgeGroupRestModel ageGroupRestModel) throws AgeGroupException;

	AgeGroupModel retrieveAgeGroup(String ageGroupId) throws AgeGroupException;

	String updateAgeGroupEntry(AgeGroupRestModel ageGroupRestModel, String ageGroupId);

	String deleteAgeGroupEntry(String ageGroupId);

}
