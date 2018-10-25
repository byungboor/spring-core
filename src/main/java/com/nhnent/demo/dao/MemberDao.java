package com.nhnent.demo.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nhnent.demo.domain.Member;

@Repository
public class MemberDao {
	private static final String NAMESPACE = "memberDao.";

    @Autowired
    SqlSessionTemplate sqlSessionTemplate;


    public Member exist(String email, String password) {
        Member member = new Member();
        member.setEmail(email);
        member.setPassword(password);

        return sqlSessionTemplate.selectOne(NAMESPACE + "selectMemberExist", member);
    }

    public int insert(Member member) {
        return sqlSessionTemplate.insert(NAMESPACE + "insertMember", member);
    }

    public List<Member> selectList() {
        return sqlSessionTemplate.selectList(NAMESPACE + "selectMemberList");
    }

    public Member selectOne(int no) {
        return sqlSessionTemplate.selectOne(NAMESPACE + "selectMember", no);
    }

    public Member selectByEmail(String email) {
        return sqlSessionTemplate.selectOne(NAMESPACE + "selectMemberByEmail", email);
    }

    public int update(Member member) {
        return sqlSessionTemplate.update(NAMESPACE + "updateMember", member);
    }

    public int delete(int no) {
        return sqlSessionTemplate.delete(NAMESPACE + "deleteMember", no);
    }

}