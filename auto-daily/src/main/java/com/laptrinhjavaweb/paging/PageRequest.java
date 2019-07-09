package com.laptrinhjavaweb.paging;

import com.laptrinhjavaweb.sorter.Sorter;

public class PageRequest implements Pageble{
	private Integer page;
	private Integer maxPageItem;
	private Sorter sorter;
	
	
	public PageRequest(Integer page, Integer maxPageItem, Sorter sorter) {
		super();
		this.page = page;
		this.maxPageItem = maxPageItem;
		this.sorter = sorter;
	}

	public Integer getLimit() {
		return this.maxPageItem;
	}
	
	public Integer getOffset() {
		return (this.page -1)*this.maxPageItem;
	}

	public Integer getPage() {
		return this.page;
	}

	public Sorter getSorter() {
		if(sorter != null) {
			return this.sorter;
		}
		return null;
	}

}
