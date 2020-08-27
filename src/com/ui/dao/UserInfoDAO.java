package com.ui.dao;

import java.util.List;

import com.ui.vo.UserInfoVO;

public interface UserInfoDAO {

	int insertUserInfo(UserInfoVO ui);
	int updateUserInfo(UserInfoVO ui);
	int deleteUserInfo(UserInfoVO ui);
	UserInfoVO selectUserInfo(UserInfoVO ui);
	List<UserInfoVO> selectUserInfoList(UserInfoVO ui);
}
