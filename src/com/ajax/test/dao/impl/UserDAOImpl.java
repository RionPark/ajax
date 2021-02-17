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

	@Override
	public int updateUser(Map<String, String> user) {
		String sql = " update user_info set ";
		int cnt = 0;
		if(user.get("ui_id")!=null && !"".equals(user.get("ui_id"))) {
			sql += " ui_id=?,";
			cnt++;
		}
		if(user.get("ui_name")!=null && !"".equals(user.get("ui_name"))) {
			sql += " ui_name=?,";
			cnt++;
		}
		if(user.get("ui_email")!=null && !"".equals(user.get("ui_email"))) {
			sql += " ui_email=?,";
			cnt++;
		}
		if(user.get("ui_address")!=null && !"".equals(user.get("ui_address"))) {
			sql += " ui_address=?,";
			cnt++;
		}
		sql = sql.substring(0,sql.length()-1) + " where ui_num=?";
		System.out.println(sql);
		Connection con = DBConn.getConn();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(cnt+1, user.get("ui_num"));
			if(user.get("ui_address")!=null && !"".equals(user.get("ui_address"))) {
				ps.setString(cnt--,user.get("ui_address"));
			}
			if(user.get("ui_email")!=null && !"".equals(user.get("ui_email"))) {
				ps.setString(cnt--,user.get("ui_email"));
			}
			if(user.get("ui_name")!=null && !"".equals(user.get("ui_name"))) {
				ps.setString(cnt--,user.get("ui_name"));
			}
			if(user.get("ui_id")!=null && !"".equals(user.get("ui_id"))) {
				ps.setString(cnt--,user.get("ui_id"));
			}
			return ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConn.close(con,ps);
		}
		return 0;
	}

	@Override
	public int countUserById(String uiId) {
		String sql = "select count(1) as cnt from user_info where ui_id=?";
		Connection con = DBConn.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, uiId);
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getInt("cnt");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConn.close(con,ps,rs);
		}
		return 0;
	}

	@Override
	public int insertUser(Map<String, String> user) {
		String sql = "insert into user_info(UI_NUM," + 
				"UI_NAME," + 
				"UI_ID," + 
				"UI_PWD," + 
				"UI_GENRE," + 
				"UI_EMAIL," + 
				"UI_PHONE1," + 
				"UI_PHONE2," + 
				"UI_ADDRESS," + 
				"UI_HINT," + 
				"UI_ANSWER," + 
				"CREDAT," + 
				"CRETIM," + 
				"MODDAT," + 
				"MODTIM," + 
				"UI_IMG)";
		sql += "values(seq_ui_num.nextval, ?,?,?,?,?,?,?,?,?,?,"
				+ "to_char(sysdate,'YYYYMMDD'),to_char(sysdate,'HH24MISS'),"
				+ "to_char(sysdate,'YYYYMMDD'),to_char(sysdate,'HH24MISS'),?)";
		Connection con = DBConn.getConn();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, user.get("ui_name"));
			ps.setString(2, user.get("ui_id"));
			ps.setString(3, user.get("ui_pwd"));
			ps.setString(4, user.get("ui_genre"));
			ps.setString(5, user.get("ui_email"));
			ps.setString(6, user.get("ui_phone1"));
			ps.setString(7, user.get("ui_phone2"));
			ps.setString(8, user.get("ui_address"));
			ps.setString(9, user.get("ui_hint"));
			ps.setString(10, user.get("ui_answer"));
			ps.setString(11, user.get("ui_img"));
			return ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConn.close(con,ps);
		}
		return 0;
	}

}
