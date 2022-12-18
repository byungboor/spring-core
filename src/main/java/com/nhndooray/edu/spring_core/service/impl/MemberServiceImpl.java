package com.nhndooray.edu.spring_core.service.impl;

import com.nhndooray.edu.spring_core.domain.Member;
import com.nhndooray.edu.spring_core.repository.MemberDao;
import com.nhndooray.edu.spring_core.repository.NotiLogDao;
import com.nhndooray.edu.spring_core.service.MemberService;
import com.nhndooray.edu.spring_core.service.NotificationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.util.StringUtils;

import java.util.Objects;

@Service
public class MemberServiceImpl implements MemberService {
    private final NotificationService notificationService;

    private final NotiLogDao notiLogDao;

    private final MemberDao memberDao;

    // TODO : #2 transaction manager 빈 주입.
    // TODO : #2 inject the transaction manager bean.
    private final PlatformTransactionManager transactionManager;


    public MemberServiceImpl(NotificationService notificationService,
                             NotiLogDao notiLogDao,
                             MemberDao memberDao,
                             PlatformTransactionManager transactionManager) {
        this.notificationService = notificationService;
        this.notiLogDao = notiLogDao;
        this.memberDao = memberDao;
        this.transactionManager = transactionManager;
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

        // TODO : #3 TransactionDefinition, TransactionStatus 를 사용하여 transaction commit, rollback 적용.
        // TODO : #3 apply transaction commit/rollback using TransactionDefinition and TransactionStatus.
        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());

        try {
            memberDao.updateMember(newMember1);
            memberDao.updateMember(newMember2);

            transactionManager.commit(status);
        } catch (RuntimeException e) {
            transactionManager.rollback(status);
            throw e;
        }
    }
}
