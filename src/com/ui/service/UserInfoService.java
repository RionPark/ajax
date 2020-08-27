package com.ui.service;

import java.util.List;

import com.ui.vo.UserInfoVO;

public interface UserInfoService {

	int insertUserInfo(UserInfoVO ui);
	int updateUserInfo(UserInfoVO ui);
	int deleteUserInfo(UserInfoVO ui);
	UserInfoVO selectUserInfo(UserInfoVO ui);
	List<UserInfoVO> selectUserInfoList(UserInfoVO ui);
}
