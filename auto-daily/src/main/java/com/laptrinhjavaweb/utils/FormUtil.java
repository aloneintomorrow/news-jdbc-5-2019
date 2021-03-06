package com.laptrinhjavaweb.utils;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class FormUtil {
	public static <T> T mapToModel(Class<T> tClazz, HttpServletRequest request){
		T object = null;
		try {
			object = tClazz.newInstance();
			BeanUtils.populate(object,request.getParameterMap());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return object;
	}
}
