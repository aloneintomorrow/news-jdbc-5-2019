package com.laptrinhjavaweb.serivce.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.laptrinhjavaweb.dao.INewDAO;
import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.paging.Pageble;
import com.laptrinhjavaweb.serivce.INewService;

public class NewService implements INewService{

	@Inject INewDAO newDAO;
	
	public List<NewModel> findAll(Pageble pageble) {
		return newDAO.findAll(pageble);
	}

	public NewModel save(NewModel newModel) {
		newModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		long id = newDAO.save(newModel);
		return newDAO.findOne(id);
	}

	public NewModel update(NewModel updateNew) {
		updateNew.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		newDAO.update(updateNew);
		return newDAO.findOne(updateNew.getId());
	}

	public void delete(Long[] ids) {
		for(int i=0 ;i < ids.length; i++) {
			long id =ids[i];
			newDAO.delete(id);
		}
	}

	public int totalItem() {
		return newDAO.count() ;
	}

}
