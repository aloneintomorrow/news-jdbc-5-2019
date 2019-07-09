package com.laptrinhjavaweb.dao;

import java.util.List;

import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.paging.Pageble;

public interface INewDAO {
	List<NewModel> findAll(Pageble pageble);
	NewModel findOne(long id);
	Long save(NewModel newModel);
	void update(NewModel updateNew);
	void delete(long id);
	int count();
}
