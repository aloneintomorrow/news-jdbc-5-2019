package com.laptrinhjavaweb.dao.impl;

import java.util.List;

import com.laptrinhjavaweb.dao.INewDAO;
import com.laptrinhjavaweb.mapper.NewMapper;
import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.paging.Pageble;

public class NewDAO extends AbstractDAO<NewModel> implements INewDAO {

	public List<NewModel> findAll(Pageble pageble) {
		/*String sql = "SELECT * FROM news";
		return query(sql, new NewMapper());*/
		StringBuilder sql =new StringBuilder("SELECT * FROM news");
		sql.append(" ORDER BY "+pageble.getSorter().getSortName()+" "+pageble.getSorter().getSortBy()+" LIMIT "
				+pageble.getOffset()+","+pageble.getLimit());
		return query(sql.toString(), new NewMapper());
	}

	public Long save(NewModel newModel) {
		StringBuilder sql = new StringBuilder("INSERT INTO news(title,shortdescription,content,thumbnail,createddate,categoryid)");
		sql.append(" VALUES(?,?,?,?,?,?)");
		return insert(sql.toString(), newModel.getTitle(),newModel.getShortDescription(),newModel.getContent(),newModel.getThumbnail(),
				newModel.getCreatedDate(),newModel.getCategoryId());
	}

	public NewModel findOne(long id) {
		String sql = "SELECT * FROM news WHERE id=?";
		List<NewModel> list = query(sql, new NewMapper(), id);
		if(list != null) {
			return list.get(0);
		}
		return null;	
	}

	public void update(NewModel updateNew) {
		String sql ="UPDATE news SET title =?, shortdescription = ?, content = ?, thumbnail =? ,categoryid=? WHERE id = ?";
		update(sql, updateNew.getTitle(),updateNew.getShortDescription(),updateNew.getContent(),updateNew.getThumbnail()
				,updateNew.getCategoryId(),updateNew.getId());
	}

	public void delete(long id) {
		String sql ="DELETE FROM news WHERE id=?";
		delete(sql, id);
	}

	public int count() {
		String sql ="SELECT COUNT(*) FROM news";
		return count(sql);
	}

	public List<NewModel> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
