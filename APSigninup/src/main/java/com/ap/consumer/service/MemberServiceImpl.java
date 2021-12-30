package com.ap.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ap.consumer.dao.MemberDAO;
import com.ap.consumer.vo.Member;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO memberDAO;

	@Override
	public Member findByMbid(String mb_id) {
		// TODO Auto-generated method stub
		return memberDAO.findByMbid(mb_id);
	}

	@Override
	public void insertNewAccount(Member member) {
		// TODO Auto-generated method stub
		memberDAO.insertNewAccount(member);
	}

}
