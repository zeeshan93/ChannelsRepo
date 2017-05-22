package com.compassites.channels.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compassites.channels.dao.AgeGroupDAO;
import com.compassites.channels.daoModel.AgeGroupModel;
import com.compassites.channels.daoModel.CategoryModel;
import com.compassites.channels.restModel.AgeGroupRestModel;

@Service
public class AgeGroupServiceImpl implements AgeGroupService {

	@Autowired
	private AgeGroupDAO ageGroupDAO;
	
	@Override
	public String createAgeGroup(AgeGroupRestModel ageGroupRestModel) {
		if(ageGroupDAO.createAgeGroup(ageGroupRestModel) > 0){
			return "successful";
		} else{
			return "failed";
		}
	}

	@Override
	public AgeGroupModel retrieveAgeGroup(int ageGroupId) {
		return ageGroupDAO.retrieveAgeGroup(ageGroupId);
	}

	@Override
	public String updateAgeGroupEntry(AgeGroupModel ageGroupModel) {
		if(ageGroupDAO.updateAgeGroupEntry(ageGroupModel) > 0){
			return "successful";
		} else{
			return "failed";
		}
	}

	@Override
	public String deleteAgeGroupEntry(int ageGroupId) {
		if(ageGroupDAO.deleteAgeGroupEntry(ageGroupId) > 0){
			return "successful";
		} else{
			return "failed";
		}
	}

}
