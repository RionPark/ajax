package com.ui.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.tribes.membership.McastServiceImpl;

import com.ui.dao.MemberInfoDAO;
import com.ui.dao.impl.MemberInfoDAOImpl;
import com.ui.service.MemeberService;

public class MemberServiceImpl implements MemeberService {
	private MemberInfoDAO midao = new MemberInfoDAOImpl();
	@Override
	public List<Map<String, Object>> selectMemberInfoList(Map<String, Object> mi) {
		int page = Integer.parseInt(mi.get("page").toString());
		int pageSize = Integer.parseInt(mi.get("pageSize").toString());
		int startNum = (page-1) * pageSize + 1;
		int endNum = (startNum-1) + pageSize;
		mi.put("startNum", startNum);
		mi.put("endNum", endNum);
		return midao.selectMemberInfoList(mi);
	}
	@Override
	public int selectCountMember(Map<String, Object> mi) {
		return midao.selectCountMember(mi);
	}

}
