package com.ajax.test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ajax.test.conn.DBConn;
import com.ajax.test.dao.MovieDAO;

public class MovieDAOImpl implements MovieDAO {

	@Override
	public List<Map<String, String>> selectMovieList(Map<String, String> pMovie) {
		List<Map<String, String>>  movieList = new ArrayList<>();
		String sql = "select * from movie_info where 1=1 ";
		if(pMovie!=null) {
			if(pMovie.get("mi_name")!=null) {
				sql += " and mi_name  like '%' || ? || '%'";
			}
			if(pMovie.get("mi_genre")!=null) {
				sql += " and mi_genre  like '%' || ? || '%'";
			}
		}
		sql += " order by mi_num desc";
		Connection con = DBConn.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(sql);
			if(pMovie!=null) {
				if(pMovie.get("mi_name")!=null) {
					ps.setString(1, pMovie.get("mi_name"));
				}
				if(pMovie.get("mi_genre")!=null) {
					if(pMovie.get("mi_name")!=null) {
						ps.setString(2, pMovie.get("mi_genre"));
					}else {
						ps.setString(1, pMovie.get("mi_genre"));
					}
				}
			}
			rs = ps.executeQuery();
			while(rs.next()) { 
				Map<String,String> movie = new HashMap<>();
				movie.put("mi_num", rs.getString("mi_num"));
				movie.put("mi_name", rs.getString("mi_name"));
				movie.put("mi_genre", rs.getString("mi_genre"));
				movie.put("mi_producer", rs.getString("mi_producer"));
				movie.put("mi_director", rs.getString("mi_director"));
				movie.put("mi_release_date", rs.getString("mi_release_date"));
				movie.put("mi_credat", rs.getString("mi_credat"));
				movie.put("mi_desc", rs.getString("mi_desc"));
				movieList.add(movie);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConn.close(con,ps,rs);
		}
		return movieList;
	}

}
