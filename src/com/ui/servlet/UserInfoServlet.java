package com.ui.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ui.service.UserInfoService;
import com.ui.service.impl.UserInfoServiceImpl;
import com.ui.vo.UserInfoVO;

@WebServlet("/ajax/user")
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserInfoService uiService = new UserInfoServiceImpl();   
    private Gson gs = new Gson();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		System.out.println(cmd);
		String json = "";
		PrintWriter pw = response.getWriter();
		if("list".equals(cmd)) {
			json = gs.toJson(uiService.selectUserInfoList(null));
		}else if("view".equals(cmd)) {
			if(request.getParameter("uiNum")==null) {
				throw new ServletException("유저번호를 확인하세요");
			}else {
				int uiNum = Integer.parseInt(request.getParameter("uiNum"));
				UserInfoVO ui = new UserInfoVO();
				ui.setUiNum(uiNum);
				json = gs.toJson(uiService.selectUserInfo(ui));
			}
		}else {
			throw new ServletException("잘못된 접근입니다.");
		}
		pw.print(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		BufferedReader br = request.getReader();
		String str;
		StringBuffer sb = new StringBuffer();
		while((str=br.readLine())!=null) {
			sb.append(str);
		}
		UserInfoVO ui = gs.fromJson(sb.toString(), UserInfoVO.class);
		Map<String,Integer> rMap = new HashMap<>();
		if("insert".equals(ui.getCmd())) {
			rMap.put("result", uiService.insertUserInfo(ui));
		}else if("update".equals(ui.getCmd())) {
			rMap.put("result", uiService.updateUserInfo(ui));
		}else if("delete".equals(ui.getCmd())) {
			rMap.put("result", uiService.deleteUserInfo(ui));
		}
		String json = gs.toJson(rMap);
		PrintWriter pw = response.getWriter();
		pw.print(json);
	}

}
