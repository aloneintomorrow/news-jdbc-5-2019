package com.laptrinhjavaweb.dao.impl;


import java.util.List;

import com.laptrinhjavaweb.dao.IUserDAO;
import com.laptrinhjavaweb.mapper.UserMapper;
import com.laptrinhjavaweb.model.UserModel;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO {

	public UserModel findByUsernameAndPassword(String userName, String password) {
		StringBuilder sql= new StringBuilder("SELECT * FROM user");
		sql.append(" INNER JOIN role ON role.id = user.roleid");
		sql.append(" WHERE username =? AND password =?");
		List<UserModel> list = query(sql.toString(), new UserMapper(), userName, password);
		return list.get(0);
	}
		
}
