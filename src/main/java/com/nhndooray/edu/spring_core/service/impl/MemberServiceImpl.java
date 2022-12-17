package com.nhndooray.edu.spring_core.service.impl;

import com.nhndooray.edu.spring_core.domain.Member;
import com.nhndooray.edu.spring_core.repository.NotiLogDao;
import com.nhndooray.edu.spring_core.service.MemberService;
import com.nhndooray.edu.spring_core.service.NotificationService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class MemberServiceImpl implements MemberService {

    private final NotificationService kakaoService;
    private final NotificationService smsService;

    // TODO : #7 실습 - field injection을 이용하여 NotiLogData 빈을 주입하세요.
    private NotiLogDao notiLogDao;


    public MemberServiceImpl(NotificationService kakaoService,
                             NotificationService smsService) {
        this.kakaoService = kakaoService;
        this.smsService = smsService;
    }

    @Override
    public boolean subscribe(Member member) {
        if (member == null)
            throw new IllegalArgumentException("Member is null");

        if (StringUtils.hasLength(member.getPhoneNumber())) {
            kakaoService.sendNotification(member.getPhoneNumber(), "Success to Subscribe");
            // TODO : #8 noti 발송 내역을 로그로 남깁니다.
            int logId = notiLogDao.insertLog(member, "kakao");
            System.out.println(notiLogDao.getLog(logId));
        }

        if (StringUtils.hasLength(member.getPhoneNumber())) {
            smsService.sendNotification(member.getPhoneNumber(), "Success to Subscribe");
            // TODO : #9 noti 발송 내역을 로그로 남깁니다.
            int logId = notiLogDao.insertLog(member, "sms");
            System.out.println(notiLogDao.getLog(logId));
        }

        return true;
    }

}
