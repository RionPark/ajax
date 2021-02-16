package com.ajax.test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ajax.test.conn.DBConn;
import com.ajax.test.dao.UserDAO;

public class UserDAOImpl implements UserDAO {

	@Override
	public List<Map<String, String>> selectUserList(Map<String, String> pUser) {
		List<Map<String, String>>  userList = new ArrayList<>();
		String sql = "select * from user_info where 1=1 ";
		int cnt = 0;
		if(pUser!=null) {
			if(pUser.get("ui_name")!=null && !"".equals(pUser.get("ui_name"))) {
				sql += " and ui_name  like '%' || ? || '%'";
				cnt++;
			}
			if(pUser.get("ui_id")!=null && !"".equals(pUser.get("ui_id"))) {
				sql += " and ui_id  like '%' || ? || '%'";
				cnt++;
			}
			if(pUser.get("ui_email")!=null && !"".equals(pUser.get("ui_email"))) {
				sql += " and ui_email  like '%' || ? || '%'";
				cnt++;
			}
			if(pUser.get("ui_address")!=null && !"".equals(pUser.get("ui_address"))) {
				sql += " and ui_address  like '%' || ? || '%'";
				cnt++;
			}
		}
		sql += " order by ui_num desc";
		Connection con = DBConn.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			if(pUser!=null) {
				if(pUser.get("ui_address")!=null && !"".equals(pUser.get("ui_address"))) {
					ps.setString(cnt--, pUser.get("ui_address"));
				}
				if(pUser.get("ui_email")!=null && !"".equals(pUser.get("ui_email"))) {
					ps.setString(cnt--, pUser.get("ui_email"));
				}
				if(pUser.get("ui_id")!=null && !"".equals(pUser.get("ui_id"))) {
					ps.setString(cnt--, pUser.get("ui_id"));
				}
				if(pUser.get("ui_name")!=null && !"".equals(pUser.get("ui_name"))) {
					ps.setString(cnt--, pUser.get("ui_name"));
				}
			}
			rs = ps.executeQuery();
			while(rs.next()) { 
				Map<String,String> user = new HashMap<>();
				user.put("ui_num", rs.getString("ui_num"));
				user.put("ui_name", rs.getString("ui_name"));
				user.put("ui_id", rs.getString("ui_id"));
				user.put("ui_genre", rs.getString("ui_genre"));
				user.put("ui_email", rs.getString("ui_email"));
				user.put("ui_address", rs.getString("ui_address"));
				user.put("credat", rs.getString("credat"));
				userList.add(user);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConn.close(con,ps,rs);
		}
		return userList;
	}

	@Override
	public Map<String, String> selectUser(int uiNum) {
		String sql = "select * from user_info where ui_num=?";
		sql += " order by ui_num desc";
		Connection con = DBConn.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, uiNum);
			rs = ps.executeQuery();
			while(rs.next()) { 
				Map<String,String> user = new HashMap<>();
				user.put("ui_num", rs.getString("ui_num"));
				user.put("ui_name", rs.getString("ui_name"));
				user.put("ui_id", rs.getString("ui_id"));
				user.put("ui_genre", rs.getString("ui_genre"));
				user.put("ui_email", rs.getString("ui_email"));
				user.put("ui_address", rs.getString("ui_address"));
				user.put("credat", rs.getString("credat"));
				return user;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConn.close(con,ps,rs);
		}
		return null;
	}

}
