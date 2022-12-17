package com.nhndooray.edu.spring_core.repository;

import com.nhndooray.edu.spring_core.domain.Log;
import com.nhndooray.edu.spring_core.domain.Member;

public interface NotiLogDao {
    int insertLog(Member member, String type);

    Log getLog(int logId);

}