package com.ajax.test.dao;

import java.util.List;
import java.util.Map;

public interface UserDAO {

	List<Map<String,String>> selectUserList(Map<String,String> user);
	Map<String, String> selectUser(int uiNum);
	int updateUser(Map<String, String> user);
	int countUserById(String uiId);
	int insertUser(Map<String, String> user);
}
