package com.nhndooray.edu.spring_core.service.impl;

import com.nhndooray.edu.spring_core.domain.Member;
import com.nhndooray.edu.spring_core.repository.MemberDao;
import com.nhndooray.edu.spring_core.repository.NotiLogDao;
import com.nhndooray.edu.spring_core.service.MemberService;
import com.nhndooray.edu.spring_core.service.NotificationService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Objects;

@Service
public class MemberServiceImpl implements MemberService {
    private final NotificationService notificationService;

    private final NotiLogDao notiLogDao;

    private final MemberDao memberDao;


    public MemberServiceImpl(NotificationService notificationService,
                             NotiLogDao notiLogDao,
                             MemberDao memberDao) {
        this.notificationService = notificationService;
        this.notiLogDao = notiLogDao;
        this.memberDao = memberDao;
    }


    @Override
    public boolean subscribe(Member member) {
        if (member == null)
            throw new IllegalArgumentException("Member is null");

        if (member.getPhoneNumber() != null && !member.getPhoneNumber().isEmpty()) {
            notificationService.sendNotification(member.getPhoneNumber(), "Success to Subscribe");
            int logId = notiLogDao.insertLog(member, notificationService.getType());
            System.out.println(notiLogDao.getLog(logId));
        }

        return true;
    }

    // TODO : #6 멤버를 조회 및 생성, 교체할 수 있는 메쏘드 구현.
    // TODO : #6 implementation of getOrCreateMember().
    @Override
    public Member getOrCreateMember(Member member) {
        Member dbMember = memberDao.getMember(member.getName());
        if (Objects.nonNull(dbMember)) {
            return dbMember;
        } else {
            memberDao.insertMember(member);
            return member;
        }
    }

    @Override
    public void exchangeMembers(Member member1, Member member2) {
        Member newMember1 = new Member(member1.getName(), member2.getPhoneNumber());
        Member newMember2 = new Member(member2.getName(), member1.getPhoneNumber());

        memberDao.updateMember(newMember1);
        memberDao.updateMember(newMember2);
    }


}
