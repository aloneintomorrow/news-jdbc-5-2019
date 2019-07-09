package com.laptrinhjavaweb.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.serivce.IUserService;
import com.laptrinhjavaweb.utils.FormUtil;
import com.laptrinhjavaweb.utils.SessionUtil;


@WebServlet(urlPatterns= {"/trang-chu","/dang-nhap","/thoat"})
public class HomeController extends HttpServlet {

	@Inject IUserService userService;
	
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String view ="";
		if(action != null &&action.equals("login")) {
			view ="/views/login.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
		}else if (action != null &&action.equals("logout")) {
			SessionUtil.getInstance().removeValue("USERMODEL", request);
			response.sendRedirect(request.getContextPath()+"/trang-chu");
		}
		else {
			view="/views/web/home.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
		}
}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action != null && action.equals("login")) {
			UserModel model = FormUtil.mapToModel(UserModel.class, request);
			model = userService.findByUserAndPassword(model.getUserName(), model.getPassword());
			if(model != null) {
				SessionUtil.getInstance().putValue("USERMODEL", model, request);
				
			}
			if(model.getRole().getCode().equals("USER")) {
				response.sendRedirect(request.getContextPath()+"/trang-chu");
			}else if (model.getRole().getCode().equals("ADMIN")) {
				response.sendRedirect(request.getContextPath()+"/admin-home");
			}
		}else {
			response.sendRedirect(request.getContextPath()+"/dang-nhap?action=login");
		}
		
	}
	
}
