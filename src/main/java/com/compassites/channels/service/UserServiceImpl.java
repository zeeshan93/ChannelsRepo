package com.compassites.channels.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compassites.channels.dao.UserDAO;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;

	@Override
	public String retreiveUserVcardDetails(String userId) {
		// TODO Auto-generated method stub
		return userDAO.retreiveUserVcardDetails(userId);
	}
	
}
