package com.laptrinhjavaweb.model;

import java.sql.Timestamp;
import java.util.List;

public class AbstractModel<T> {
	private Long id;
	private Timestamp createdDate;
	private String createdBy;
	private Timestamp modifiedDate;
	private String modifiedBy;
	private Long[] ids;
	private Integer page;
	private List<T> listResult;
	private Integer maxPageItem;
	private Integer totalPage;
	private int offSet;
	private String sortName;
	private String sortBy;
	
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Timestamp getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long[] getIds() {
		return ids;
	}
	public void setIds(Long[] ids) {
		this.ids = ids;
	}
	public List getListResult() {
		return listResult;
	}
	public void setListResult(List listResult) {
		this.listResult = listResult;
	}
	
	public int getOffSet() {
		return offSet;
	}
	public void setOffSet(int offSet) {
		this.offSet = offSet;
	}
	public String getSortName() {
		return sortName;
	}
	public void setSortName(String sortName) {
		this.sortName = sortName;
	}
	public String getSortBy() {
		return sortBy;
	}
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getMaxPageItem() {
		return maxPageItem;
	}
	public void setMaxPageItem(Integer maxPageItem) {
		this.maxPageItem = maxPageItem;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	
	
}
