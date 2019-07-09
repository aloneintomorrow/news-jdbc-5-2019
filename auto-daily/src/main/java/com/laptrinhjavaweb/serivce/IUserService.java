package com.laptrinhjavaweb.serivce;

import com.laptrinhjavaweb.model.UserModel;

public interface IUserService {
	UserModel findByUserAndPassword(String userName, String password);
}
