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
	public static void main(String[] args) {
		Map<String, Object> param = new HashMap<>();
		param.put("page",3);
		param.put("pageSize", 30);
		MemeberService ms = new MemberServiceImpl();
		List<Map<String, Object>> mList = ms.selectMemberInfoList(param);
		for(Map<String, Object> m : mList) {
			System.out.println(m);
		}
	}

}
