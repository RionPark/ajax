package com.ajax.test.service;

import java.util.List;
import java.util.Map;

public interface UserService {

	List<Map<String,String>> selectUserList(Map<String,String> user);
	Map<String,String> selectUser(int uiNum);
	int updateUser(Map<String,String> user);
	int countUserById(String uiId);
	int insertUser(Map<String, String> user);
}
