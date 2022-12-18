package com.nhndooray.edu.spring_core.repository;

import com.nhndooray.edu.spring_core.domain.Member;

// TODO : #3 MemberDao 인터페이스 생성.
// TODO : #3 MemberDao interface.
public interface MemberDao {
    Member getMember(String name);

    void insertMember(Member member);

    void updateMember(Member member);

}
