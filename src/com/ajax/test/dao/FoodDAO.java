package com.ajax.test.dao;

import java.util.List;
import java.util.Map;

public interface FoodDAO {

	List<Map<String,String>> selectFootList(Map<String,String> food);
}
