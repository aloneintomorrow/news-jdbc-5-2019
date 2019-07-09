package com.laptrinhjavaweb.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.dao.GenericDAO;
import com.laptrinhjavaweb.mapper.RowMapper;

public class AbstractDAO<T> implements GenericDAO<T> {
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url ="jdbc:mysql://localhost:3306/newservlet5_2019";
			String user ="root";
			String password = "123456";
			return DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;	
	}

	public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			List<T> lists = new ArrayList<T>();
			connection = getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			setParameter(statement, parameters);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				lists.add(rowMapper.mapRow(resultSet));
			}
			connection.commit();
			return lists;
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			try {
			if(connection != null) {
				connection.close();
			}
			if(statement != null) {
				statement.close();
			}
			if(resultSet != null) {
				resultSet.close();
			}
		}catch (Exception e) {
			
		}
		}
		return null;
	}

	private void setParameter(PreparedStatement statement, Object... parameters) {
		try {
			for(int i =0; i< parameters.length; i++) {
				Object parameter = parameters[i];
				int index = i + 1;
				if(parameter instanceof String) {
					statement.setString(index, (String) parameter);
				}else if (parameter instanceof Integer) {
					statement.setInt(index, (Integer) parameter);
				}else if (parameter instanceof Long) {
					statement.setLong(index, (Long) parameter);
				}else if(parameter instanceof Timestamp) {
					statement.setTimestamp(index, (Timestamp) parameter);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	public Long insert(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			Long id = null;
			connection = getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql,statement.RETURN_GENERATED_KEYS);
			setParameter(statement, parameters);
			statement.executeUpdate();
			resultSet = statement.getGeneratedKeys();
			while (resultSet.next()) {
				id = resultSet.getLong(1);
			}
			connection.commit();
			return id;
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			try {
				if(connection != null) {
					connection.close();
				}
				if(statement != null) {
					statement.close();
				}
				if(resultSet != null) {
					resultSet.close();
				}
			}catch (Exception e) {
				
			}
			}
			return null;
		}
		
	public void update(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			setParameter(statement, parameters);
			statement.executeUpdate();
			connection.commit();
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			try {
				if(connection != null) {
					connection.close();
				}
				if(statement != null) {
					statement.close();
				}
			}catch (Exception e) {
				
			}
		}
	}

	public void delete(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = getConnection();
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			setParameter(statement, parameters);
			statement.executeUpdate();
			connection.commit();
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally {
			try {
				if(connection != null) {
					connection.close();
				}
				if(statement != null) {
					statement.close();
				}
			}catch (Exception e) {
				
			}
		}
	}

	public int count(String sql) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
		int id = 0;
		connection = getConnection();
		connection.setAutoCommit(false);
		statement = connection.prepareStatement(sql);
		resultSet = statement.executeQuery();
		if(resultSet.next()) {
			id = resultSet.getInt(1);
		}
		return id;
		}catch (SQLException e) {
			return 0;
	}finally {
		try {
		if(connection != null) {
			connection.close();
		}
		if(statement != null) {
			statement.close();
		}
		if(resultSet != null) {
			resultSet.close();
		}
	}catch (Exception e) {
		// TODO: handle exception
	}
	}
	}
	
	
}
