package com.laptrinhjavaweb.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.serivce.INewService;
import com.laptrinhjavaweb.utils.HttpUtil;
@WebServlet("/api-admin-new")
public class NewAPI extends HttpServlet {

	@Inject INewService newService;
	
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		NewModel model = HttpUtil.of(request.getReader()).toModel(NewModel.class);
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		model = newService.save(model);
		
		mapper.writeValue(response.getOutputStream(), model);
	}
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		NewModel model = HttpUtil.of(request.getReader()).toModel(NewModel.class);
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		newService.update(model);
		mapper.writeValue(response.getOutputStream(), model);
	}
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		NewModel model = HttpUtil.of(request.getReader()).toModel(NewModel.class);
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		newService.delete(model.getIds());
		mapper.writeValue(response.getOutputStream(), "{ }");
	}
}
