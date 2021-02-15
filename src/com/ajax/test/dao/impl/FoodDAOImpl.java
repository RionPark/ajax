package com.ajax.test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ajax.test.conn.DBConn;
import com.ajax.test.dao.FoodDAO;

public class FoodDAOImpl implements FoodDAO {

	@Override
	public List<Map<String, String>> selectFootList(Map<String, String> pFood) {
		List<Map<String, String>>  foodList = new ArrayList<>();
		String sql = "select * from food_info order by fi_num desc";
		Connection con = DBConn.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Map<String,String> food = new HashMap<>();
				food.put("fi_num", rs.getString("fi_num"));
				food.put("fi_name", rs.getString("fi_name"));
				food.put("fi_price", rs.getString("fi_price"));
				food.put("fi_type", rs.getString("fi_type"));
				food.put("fi_credat", rs.getString("fi_credat"));
				food.put("fi_cretim", rs.getString("fi_cretim"));
				foodList.add(food);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConn.close(con,ps,rs);
		}
		return foodList;
	}

}
