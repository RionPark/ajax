package com.ajax.test.dao;

import java.util.List;
import java.util.Map;

public interface UserDAO {

	List<Map<String,String>> selectUserList(Map<String,String> user);
}
