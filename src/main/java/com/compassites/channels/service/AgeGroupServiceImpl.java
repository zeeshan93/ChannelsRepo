package com.compassites.channels.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compassites.channels.Exception.AgeGroupException;
import com.compassites.channels.dao.AgeGroupDAO;
import com.compassites.channels.daoModel.AgeGroupModel;
import com.compassites.channels.restModel.AgeGroupRestModel;

@Service
public class AgeGroupServiceImpl implements AgeGroupService {

	@Autowired
	private AgeGroupDAO ageGroupDAO;
	
	@Override
	public String createAgeGroup(AgeGroupRestModel ageGroupRestModel) throws AgeGroupException {
		if(ageGroupRestModel.getAgeGroupMin() < ageGroupRestModel.getAgeGroupMax()){
			if(ageGroupDAO.createAgeGroup(ageGroupRestModel) > 0){
				return "successful";
			} else{
				return "failed";
			}
		} else {
			throw new AgeGroupException("Min age is greater than Max age!!!");
		}
		
		
	}

	@Override
	public AgeGroupModel retrieveAgeGroup(String ageGroupId) throws AgeGroupException {
		return ageGroupDAO.retrieveAgeGroup(ageGroupId);
	}

	@Override
	public String updateAgeGroupEntry(AgeGroupRestModel ageGroupRestModel, String ageGroupId) {
		if(ageGroupDAO.updateAgeGroupEntry(ageGroupRestModel, ageGroupId) > 0){
			return "successful";
		} else{
			return "failed";
		}
	}

	@Override
	public String deleteAgeGroupEntry(String ageGroupId) {
		if(ageGroupDAO.deleteAgeGroupEntry(ageGroupId) > 0){
			return "successful";
		} else{
			return "failed";
		}
	}

	@Override
	public String getAgeGroupIdFromAge(int age) {
		return ageGroupDAO.getAgeGroupIdFromAge(age);
		
	}

}
