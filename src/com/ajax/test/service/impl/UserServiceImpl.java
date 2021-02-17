package com.ajax.test.service.impl;

import java.util.List;
import java.util.Map;

import com.ajax.test.dao.UserDAO;
import com.ajax.test.dao.impl.UserDAOImpl;
import com.ajax.test.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDAO userDAO = new UserDAOImpl();
	@Override
	public List<Map<String, String>> selectUserList(Map<String, String> user) {
		return userDAO.selectUserList(user);
	}
	@Override
	public Map<String, String> selectUser(int uiNum) {
		return userDAO.selectUser(uiNum);
	}
	@Override
	public int updateUser(Map<String, String> user) {
		return userDAO.updateUser(user);
	}
	@Override
	public int countUserById(String uiId) {
		return userDAO.countUserById(uiId);
	}
	@Override
	public int insertUser(Map<String, String> user) {
		// TODO Auto-generated method stub
		return userDAO.insertUser(user);
	}

}
