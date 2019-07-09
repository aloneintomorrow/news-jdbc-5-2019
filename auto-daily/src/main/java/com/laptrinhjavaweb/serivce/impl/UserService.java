package com.laptrinhjavaweb.serivce.impl;

import javax.inject.Inject;

import com.laptrinhjavaweb.dao.IUserDAO;
import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.serivce.IUserService;

public class UserService implements IUserService {

	@Inject IUserDAO userDAO;
	
	public UserModel findByUserAndPassword(String userName, String password) {
		return userDAO.findByUsernameAndPassword(userName, password);
	}

}
