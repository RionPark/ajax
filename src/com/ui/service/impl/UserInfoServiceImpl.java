package com.ui.service.impl;

import java.util.List;

import com.ui.dao.UserInfoDAO;
import com.ui.dao.impl.UserInfoDAOImpl;
import com.ui.service.UserInfoService;
import com.ui.vo.UserInfoVO;

public class UserInfoServiceImpl implements UserInfoService {
	private UserInfoDAO uidao = new UserInfoDAOImpl();
	@Override
	public int insertUserInfo(UserInfoVO ui) {
		return uidao.insertUserInfo(ui);
	}

	@Override
	public int updateUserInfo(UserInfoVO ui) {
		return uidao.updateUserInfo(ui);
	}

	@Override
	public int deleteUserInfo(UserInfoVO ui) {
		return uidao.deleteUserInfo(ui);
	}

	@Override
	public UserInfoVO selectUserInfo(UserInfoVO ui) {
		return uidao.selectUserInfo(ui);
	}

	@Override
	public List<UserInfoVO> selectUserInfoList(UserInfoVO ui) {
		return uidao.selectUserInfoList(ui);
	}

}
