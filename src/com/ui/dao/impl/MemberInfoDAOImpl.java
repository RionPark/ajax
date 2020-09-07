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
	@Override
	public int selectCountMember(Map<String, Object> mi) {
		try(SqlSession ss = MybatisServlet.getSession()){
			return ss.selectOne("Member.selectCountMember",mi);
		}
	}
}




