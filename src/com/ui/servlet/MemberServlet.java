package com.ui.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ui.service.MemeberService;
import com.ui.service.impl.MemberServiceImpl;


@WebServlet("/ajax/member")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MemeberService ms = new MemberServiceImpl();   
    private Gson g = new Gson();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String,Object> param = new HashMap<>();
		param.put("page",request.getParameter("page"));
		param.put("pageSize", request.getParameter("pageSize"));
		List<Map<String,Object>> mList = ms.selectMemberInfoList(param);
		PrintWriter pw = response.getWriter();
		Map<String,Object> rMap = new HashMap<>();
		rMap.put("list", mList);
		rMap.put("totalCnt", 10000);
		pw.println(g.toJson(rMap));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
