package com.laptrinhjavaweb.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.model.NewModel;
import com.laptrinhjavaweb.paging.PageRequest;
import com.laptrinhjavaweb.paging.Pageble;
import com.laptrinhjavaweb.paging.PageRequest;
import com.laptrinhjavaweb.serivce.INewService;
import com.laptrinhjavaweb.sorter.Sorter;
import com.laptrinhjavaweb.utils.FormUtil;
@WebServlet("/admin-new")
public class NewController extends HttpServlet {

	@Inject INewService newService;
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*NewModel model = new NewModel();*/
		/*String pageStr = request.getParameter("page");
		String maxPageStr = request.getParameter("maxPageItem");
		String sortNameStr = request.getParameter("sortName");
		String sortByStr = request.getParameter("sortBy");
		if(pageStr != null) {
			model.setPage(Integer.parseInt(pageStr));
		}
		if(maxPageStr != null) {
			model.setMaxPageItem(Integer.parseInt(maxPageStr));
		}
		if(sortByStr != null) {
			model.setSortBy(sortByStr);
		}
		if(sortNameStr != null) {
			model.setSortName(sortNameStr);;
		}*/
		/*int total = newService.totalItem();*/
		//vi tri cua item khi dung LIMIT(0,2) 
				/*model.setOffSet((model.getPage()-1) * model.getMaxPageItem());*/
		NewModel model = FormUtil.mapToModel(NewModel.class, request);
		Pageble pageble = new PageRequest(model.getPage(), model.getMaxPageItem(), new Sorter(model.getSortName(), model.getSortBy()));
		model.setTotalPage((int) Math.ceil(((double) newService.totalItem() / (double)model.getMaxPageItem())));
		model.setListResult(newService.findAll(pageble));
		request.setAttribute("model", model);
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/new/list.jsp");
		rd.forward(request, response);
	}

}
