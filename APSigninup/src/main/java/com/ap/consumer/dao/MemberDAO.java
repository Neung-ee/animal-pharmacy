package com.ap.consumer.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ap.consumer.vo.Member;

@Mapper
public interface MemberDAO {
	public Member findByMbid(String mb_id);
	public void insertNewAccount(Member member);
}
