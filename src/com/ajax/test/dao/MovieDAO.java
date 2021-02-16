package com.ajax.test.dao;

import java.util.List;
import java.util.Map;

public interface MovieDAO {

	List<Map<String,String>> selectMovieList(Map<String,String> movie);
}
