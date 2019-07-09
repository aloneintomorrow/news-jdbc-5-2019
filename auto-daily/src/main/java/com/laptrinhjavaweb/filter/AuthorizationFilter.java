package com.laptrinhjavaweb.filter;

import java.io.IOException;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.utils.SessionUtil;

public class AuthorizationFilter implements Filter {
	private ServletContext context;
	
	public void init(FilterConfig filterConfig) throws ServletException {
		this.context = filterConfig.getServletContext();
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse)res;
		String url = request.getRequestURI();
		if(url.startsWith("/auto-daily/admin")) {
			UserModel model = (UserModel) SessionUtil.getInstance().getValue("USERMODEL", request);
			if(model != null) {
				if(model.getRole().getCode().equals("ADMIN")) {
					chain.doFilter(req, res);
				}else if (model.getRole().getCode().equals("USER")) {
				response.sendRedirect(request.getContextPath()+"/dang-nhap?action=login");
			}
		}else {
			response.sendRedirect(request.getContextPath()+"/dang-nhap?action=login");
		}
		}else {
			chain.doFilter(req, res);
		}
	}
	

	public void destroy() {
		
	}
}
