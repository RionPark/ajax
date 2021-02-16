package com.ajax.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajax.test.service.UserService;
import com.ajax.test.service.impl.UserServiceImpl;
import com.google.gson.Gson;

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService userService = new  UserServiceImpl();
    private Gson g = new Gson();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String url = request.getRequestURI();
		int idx = url.lastIndexOf("/");
		String cmd = url.substring(idx+1);
		String json = "";
		if("list".equals(cmd)) {
			Map<String,String> user = new HashMap<>();
			user.put("ui_name", request.getParameter("ui_name"));
			user.put("ui_id", request.getParameter("ui_id"));
			user.put("ui_email", request.getParameter("ui_email"));
			user.put("ui_address", request.getParameter("ui_address"));
			List<Map<String,String>> userList = userService.selectUserList(user);
			json = g.toJson(userList);
		}else if("view".equals(cmd)) {
			int uiNum = Integer.parseInt(request.getParameter("ui_num"));
			Map<String,String> user = userService.selectUser(uiNum);
			json = g.toJson(user);
		}
		out.print(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
