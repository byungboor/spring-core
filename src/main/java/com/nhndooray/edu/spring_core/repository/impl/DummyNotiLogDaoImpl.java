package com.nhndooray.edu.spring_core.repository.impl;

import com.nhndooray.edu.spring_core.domain.Log;
import com.nhndooray.edu.spring_core.domain.Member;
import com.nhndooray.edu.spring_core.repository.NotiLogDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


// TODO : 로깅만 하는 NotiLogDao 구현체를 새로 하나 만들었다.
//        기존 구현체는 production profile에서만 동작하도록 하고,
//        새로 만든 구현체는 dev profile에서만 동작하도록 수정하라.
// TODO : practice
//        make NotiLogDaoImpl work only in the production profile.
//        make DummyNotiLogDaoImpl work only in the dev profile.
@Repository
public class DummyNotiLogDaoImpl implements NotiLogDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(DummyNotiLogDaoImpl.class);


    @Override
    public int insertLog(Member member, String type) {
        LOGGER.info("insertLog() called: type={}, member={},{}",
                    type, member.getName(), member.getPhoneNumber());
        return 0;
    }

    @Override
    public Log getLog(int logId) {
        LOGGER.info("getLog() called: log_id={}", logId);
        return new Log("sms", "00000000000");
    }

}
