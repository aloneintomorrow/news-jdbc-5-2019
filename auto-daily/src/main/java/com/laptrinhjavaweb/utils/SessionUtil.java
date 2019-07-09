package com.laptrinhjavaweb.utils;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtil {
	public static SessionUtil sessionUtil = null;
	public static SessionUtil getInstance() {
		if(sessionUtil == null) {
			sessionUtil = new SessionUtil();
		}
		return sessionUtil;
	}
	
	public void putValue(String name, Object value, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute(name, value);
	}
	public Object getValue(String name, HttpServletRequest request) {
		return request.getSession().getAttribute(name);
	}
	public void removeValue(String name, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute(name);
	}
}
