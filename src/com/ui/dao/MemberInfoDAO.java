package com.ui.dao;

import java.util.List;
import java.util.Map;

import com.ui.vo.MemberInfoVO;

public interface MemberInfoDAO {
	List<Map<String, Object>> selectMemberInfoList(Map<String,Object> mi);
	int selectCountMember(Map<String,Object> mi);
}
