package com.laptrinhjavaweb.dao;

import com.laptrinhjavaweb.model.UserModel;

public interface IUserDAO {
	UserModel findByUsernameAndPassword(String userName, String password);
}
