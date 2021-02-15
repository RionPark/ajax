package com.ajax.test.service;

import java.util.List;
import java.util.Map;

public interface FoodService {

	List<Map<String,String>> selectFootList(Map<String,String> food);
}
