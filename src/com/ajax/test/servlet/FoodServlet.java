package com.ajax.test.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajax.test.service.FoodService;
import com.ajax.test.service.impl.FoodServiceImpl;

public class FoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FoodService foodService = new FoodServiceImpl();
	   
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Map<String,String>> foodList = foodService.selectFootList(null);
		String fiName = request.getParameter("fi_name");
		System.out.println("검색어 : " + fiName);
		
		request.setAttribute("foodList", foodList);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/food-list.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
