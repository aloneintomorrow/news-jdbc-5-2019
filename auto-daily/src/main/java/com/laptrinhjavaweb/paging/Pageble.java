package com.laptrinhjavaweb.paging;

import com.laptrinhjavaweb.sorter.Sorter;

public interface Pageble {
	Integer getPage();
	Integer getLimit();
	Integer getOffset();
	Sorter getSorter();
	
	
	
}
