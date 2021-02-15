package com.ajax.test.service.impl;

import java.util.List;
import java.util.Map;

import com.ajax.test.dao.FoodDAO;
import com.ajax.test.dao.impl.FoodDAOImpl;
import com.ajax.test.service.FoodService;

public class FoodServiceImpl implements FoodService {
	private FoodDAO foodDAO = new FoodDAOImpl();
	@Override
	public List<Map<String, String>> selectFootList(Map<String, String> food) {
		return foodDAO.selectFootList(food);
	}

}
