package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.MemberBean;

public interface MemberService {
	//추상메서드 
	public void insertMember(MemberBean mb);
	public MemberBean userCheck(MemberBean mb);
	public MemberBean getMember(String id);
	public void updateMember(MemberBean mb);
	public void deleteMember(MemberBean mb);
	public List<MemberBean> getMemberList();
}
