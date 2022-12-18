package com.nhndooray.edu.spring_core.service.impl;

import com.nhndooray.edu.spring_core.assembler.MemberAssembler;
import com.nhndooray.edu.spring_core.domain.Member;
import com.nhndooray.edu.spring_core.entity.MemberEntity;
import com.nhndooray.edu.spring_core.repository.MemberRepository;
import com.nhndooray.edu.spring_core.repository.NotiLogDao;
import com.nhndooray.edu.spring_core.service.MemberService;
import com.nhndooray.edu.spring_core.service.NotificationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.Objects;

@Service
public class MemberServiceImpl implements MemberService {
    private final NotificationService notificationService;

    private final NotiLogDao notiLogDao;

    private final MemberRepository memberRepository;

    private final PlatformTransactionManager transactionManager;


    public MemberServiceImpl(NotificationService notificationService,
                             NotiLogDao notiLogDao,
                             MemberRepository memberRepository,
                             PlatformTransactionManager transactionManager) {
        this.notificationService = notificationService;
        this.notiLogDao = notiLogDao;
        this.memberRepository = memberRepository;
        this.transactionManager = transactionManager;
    }


    @Override
    public boolean subscribe(Member member) {
        if (member == null)
            throw new IllegalArgumentException("Member is null");

        if (member.getPhoneNumber() != null && !member.getPhoneNumber().isEmpty()) {
            notificationService.sendNotification(member.getPhoneNumber(), "Success to Subscribe");

            int logId = notiLogDao.insertLog(member, notificationService.getType());
        }

        return true;
    }

    @Override
    public Member getOrCreateMember(Member member) {
        MemberEntity memberEntity = memberRepository.findById(member.getName()).orElse(null);
        if (Objects.nonNull(memberEntity)) {
            return new MemberAssembler().toDto(memberEntity);
        } else {
            memberRepository.save(new MemberEntity(member.getName(), member.getPhoneNumber()));
            return member;
        }

    }

    @Override
    public void exchangeMembers(Member member1, Member member2) {
        Member newMember1 = new Member(member1.getName(), member2.getPhoneNumber());
        Member newMember2 = new Member(member2.getName(), member1.getPhoneNumber());

        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());

        try {
            memberRepository.save(new MemberEntity(newMember1.getName(), newMember1.getPhoneNumber()));
            memberRepository.save(new MemberEntity(newMember2.getName(), newMember2.getPhoneNumber()));

            transactionManager.commit(status);
        } catch (RuntimeException e) {
            transactionManager.rollback(status);
            throw e;
        }
    }
}
