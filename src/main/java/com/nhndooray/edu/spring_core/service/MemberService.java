package com.nhndooray.edu.spring_core.service;

import com.nhndooray.edu.spring_core.domain.Member;

public interface MemberService {
    boolean subscribe(Member member);

    Member getOrCreateMember(Member member);

    void exchangeMembers(Member member1, Member member2);
}
