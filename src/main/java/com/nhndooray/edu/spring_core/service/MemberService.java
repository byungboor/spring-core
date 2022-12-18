package com.nhndooray.edu.spring_core.service;

import com.nhndooray.edu.spring_core.domain.Member;

public interface MemberService {
    boolean subscribe(Member member);

    // TODO : #5 멤버를 조회 및 생성, 교체할 수 있는 메쏘드 추가.
    Member getOrCreateMember(Member member);

    void exchangeMembers(Member member1, Member member2);
}
