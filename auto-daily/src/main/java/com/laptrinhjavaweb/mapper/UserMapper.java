package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjavaweb.model.RoleModel;
import com.laptrinhjavaweb.model.UserModel;

public class UserMapper implements RowMapper<UserModel> {

	public UserModel mapRow(ResultSet rs) {
		try {
			UserModel user = new UserModel();
			user.setId(rs.getLong("id"));
			user.setUserName(rs.getString("username"));
			user.setFullName(rs.getString("fullname"));
			user.setPassword(rs.getString("password"));
			user.setRoleId(rs.getLong("roleid"));
			RoleModel role = new RoleModel();
			role.setName(rs.getString("name"));
			role.setCode(rs.getString("code"));
			user.setRole(role);
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
