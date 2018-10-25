package com.nhnent.demo.service;

import java.util.List;

import com.nhnent.demo.domain.Member;

public interface MemberService {

	Member createMember(String email, String password, String name);

    Member getMember(String email, String password) throws Exception;

    List<Member> getAllMembers() throws Exception;

    void exchangeMemberName(Member member1, Member member2);

}
