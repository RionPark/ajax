package com.ajax.test.service;

import java.util.List;
import java.util.Map;

public interface UserService {

	List<Map<String,String>> selectUserList(Map<String,String> user);
}
