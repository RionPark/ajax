package com.ui.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.ui.dao.MemberInfoDAO;
import com.ui.servlet.MybatisServlet;

public class MemberInfoDAOImpl implements MemberInfoDAO {
	@Override
	public List<Map<String, Object>> selectMemberInfoList(Map<String, Object> mi) {
		try(SqlSession ss = MybatisServlet.getSession()){
			return ss.selectList("Member.selectMemberList",mi);
		}
	}
	public static void main(String[] args) {
		MemberInfoDAO midao = new MemberInfoDAOImpl();
		Map<String, Object> param = new HashMap<>();
		param.put("startNum", 51);
		param.put("endNum", 60);
		List<Map<String, Object>> mList = midao.selectMemberInfoList(param);
		for(Map<String, Object> m : mList) {
			System.out.println(m);
		}
	}
}




