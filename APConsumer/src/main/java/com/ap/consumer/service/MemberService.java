package com.ap.consumer.service;

import com.ap.consumer.vo.Member;

public interface MemberService {
	public Member findByMbid(String mb_id);
	public void insertNewAccount(Member member);
}
