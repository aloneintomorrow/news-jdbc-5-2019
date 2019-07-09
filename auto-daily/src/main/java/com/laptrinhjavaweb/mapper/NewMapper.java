package com.laptrinhjavaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.model.NewModel;

public class NewMapper implements RowMapper<NewModel>{

	public NewModel mapRow(ResultSet rs) {
		try {
			NewModel news = new NewModel();
			news.setTitle(rs.getString("title"));
			news.setThumbnail(rs.getString("thumbnail"));
			news.setContent(rs.getString("content"));
			news.setId(rs.getLong("id"));
			news.setCategoryId(rs.getLong("categoryid"));
			news.setShortDescription(rs.getString("shortdescription"));
			if(news.getCreatedDate() != null) {
				news.setCreatedDate(rs.getTimestamp("createddate"));
			}if(news.getModifiedDate() != null) {
				news.setModifiedDate(rs.getTimestamp("modifieddate"));
			}
			return news;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
