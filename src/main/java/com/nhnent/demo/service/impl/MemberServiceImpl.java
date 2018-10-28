package com.nhnent.demo.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.nhnent.demo.dao.MemberDao;
import com.nhnent.demo.domain.Member;
import com.nhnent.demo.service.MemberService;
import com.nhnent.demo.stereotype.CustomLogger;

@Service
public class MemberServiceImpl implements MemberService {
	

    private static final Logger LOGGER = LoggerFactory.getLogger(MemberService.class);

    @Autowired
    private MemberDao memberDao;

    @Autowired
    private PlatformTransactionManager transactionManager;

    public Member createMember(String email, String password, String name) {
    	
    	Member member = memberDao.selectByEmail(email);
    	if (member != null)
    		return member;
 
    	member = new Member();
        member.setEmail(email);
        member.setPassword(password);
        member.setName(name);
        member.setCreatedDate(new Date());
        member.setModifiedDate(new Date());

        try {
            memberDao.insert(member);
            member = memberDao.selectByEmail(email);
        } catch (Exception e) {
            LOGGER.error("{}", e);
        }

        return member;
    }

    // TODO 1.
    @CustomLogger
    public Member getMember(String email, String password) {
        Member member = memberDao.exist(email, password);
        if (member == null) {
            return null;
        }
        
        System.out.println("--------------------------------------------");
        System.out.println("member : " +member.toString());
        System.out.println("--------------------------------------------");

        return memberDao.selectOne(member.getNo());
    }

    @Override
    public List<Member> getAllMembers() {
        return memberDao.selectList();
    }

    public void exchangeMemberName(Member member1, Member member2) {
        TransactionStatus status = this.transactionManager.getTransaction(new DefaultTransactionDefinition());

        try {
            String tempName = member1.getName();
            member1.setName(member2.getName());
            member2.setName(tempName);

            memberDao.update(member1);
            memberDao.update(member2);

            this.transactionManager.commit(status);
        } catch (Exception e) {
            this.transactionManager.rollback(status);
            throw e;
        }
    }

}
