package com.ui.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ui.dao.UserInfoDAO;
import com.ui.servlet.InitServlet;
import com.ui.vo.UserInfoVO;

public class UserInfoDAOImpl implements UserInfoDAO {

	@Override
	public int insertUserInfo(UserInfoVO ui) {
		String sql = "insert into user_info(\r\n" + "ui_name,ui_num, ui_age, ui_birth,\r\n"
				+ "ui_id, ui_password,ui_phone,ui_email,\r\n" + "ui_credat,ui_nickname)\r\n" + "values(\r\n"
				+ "?,seq_ui_num.nextval, ?, ?,\r\n" + "?,?,?,?,\r\n" + "sysdate,?)";
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = InitServlet.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, ui.getUiName());
			ps.setInt(2, ui.getUiAge());
			ps.setString(3, ui.getUiBirth());
			ps.setString(4, ui.getUiId());
			ps.setString(5, ui.getUiPassword());
			ps.setString(6, ui.getUiPhone());
			ps.setString(7, ui.getUiEmail());
			ps.setString(8, ui.getUiNickname());
			int cnt = ps.executeUpdate();
			con.commit();
			return cnt;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			InitServlet.close(ps, con);
		}
		return 0;
	}

	@Override
	public int updateUserInfo(UserInfoVO ui) {
		String sql = "update user_info\r\n" + 
				"set ui_name=?,\r\n" + 
				"ui_age=?,\r\n" + 
				"ui_birth=?,\r\n" + 
				"ui_password=?,\r\n" + 
				"ui_phone=?,\r\n" + 
				"ui_email=?\r\n" + 
				"where ui_num=?";
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = InitServlet.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, ui.getUiName());
			ps.setInt(2, ui.getUiAge());
			ps.setString(3, ui.getUiBirth());
			ps.setString(4, ui.getUiPassword());
			ps.setString(5, ui.getUiPhone());
			ps.setString(6, ui.getUiEmail());
			ps.setInt(7, ui.getUiNum());
			int cnt = ps.executeUpdate();
			con.commit();
			return cnt;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			InitServlet.close(ps, con);
		}
		return 0;
	}

	@Override
	public int deleteUserInfo(UserInfoVO ui) {
		String sql = "delete from user_info where ui_num=?";
		Connection con = null;
		PreparedStatement ps = null;
	
		try {
			con = InitServlet.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, ui.getUiNum());
			int cnt = ps.executeUpdate();
			con.commit();
			return cnt;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			InitServlet.close(ps, con);
		}
		return 0;
	}

	@Override
	public UserInfoVO selectUserInfo(UserInfoVO ui) {
		String sql = "select * from user_info where ui_num=?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = InitServlet.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, ui.getUiNum());
			rs = ps.executeQuery();
			while(rs.next()) {
				UserInfoVO tUi = new UserInfoVO();
				tUi.setUiId(rs.getString("ui_id"));
				tUi.setUiNum(rs.getInt("ui_num"));
				tUi.setUiName(rs.getString("ui_name"));
				tUi.setUiAdmin(rs.getString("ui_admin"));
				tUi.setUiAge(rs.getInt("ui_age"));
				tUi.setUiBirth(rs.getString("ui_birth"));
				tUi.setUiCredat(rs.getString("ui_credat"));
				tUi.setUiEmail(rs.getString("ui_email"));
				tUi.setUiNickname(rs.getString("ui_nickname"));
				return tUi;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			InitServlet.close(ps, con);
		}
		return null;
	}

	@Override
	public List<UserInfoVO> selectUserInfoList(UserInfoVO ui) {
		List<UserInfoVO> uiList = new ArrayList<>();
		String sql = "select * from user_info";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = InitServlet.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				UserInfoVO tUi = new UserInfoVO();
				tUi.setUiId(rs.getString("ui_id"));
				tUi.setUiNum(rs.getInt("ui_num"));
				tUi.setUiName(rs.getString("ui_name"));
				tUi.setUiAdmin(rs.getString("ui_admin"));
				tUi.setUiAge(rs.getInt("ui_age"));
				tUi.setUiBirth(rs.getString("ui_birth"));
				tUi.setUiCredat(rs.getString("ui_credat"));
				tUi.setUiEmail(rs.getString("ui_email"));
				tUi.setUiNickname(rs.getString("ui_nickname"));
				uiList.add(tUi);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			InitServlet.close(ps, con);
		}
		return uiList;
	}

	public static void main(String[] args) {
		InitServlet is = new InitServlet();
		is.init();
		UserInfoDAO uidao = new UserInfoDAOImpl();
		UserInfoVO ui = new UserInfoVO();
//		ui.setUiNum(54);
		System.out.println(uidao.selectUserInfoList(ui));
	}
}
