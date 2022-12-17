package com.nhndooray.edu.spring_core.repository.impl;

import com.nhndooray.edu.spring_core.domain.Log;
import com.nhndooray.edu.spring_core.domain.Member;
import com.nhndooray.edu.spring_core.repository.NotiLogDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;

@Repository
public class NotiLogDaoImpl implements NotiLogDao {

    private final JdbcTemplate jdbcTemplate;

    public NotiLogDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertLog(Member member, String type) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO NOTI_LOG ( NOTI_TYPE, PHONE_NUMBER, CREATE_AT ) VALUES ( ?, ?, now() )",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, type);
            ps.setString(2, member.getPhoneNumber());

            return ps;
        }, keyHolder);

        return keyHolder.getKey().intValue();
    }

    @Override
    public Log getLog(int logId) {
        return jdbcTemplate.queryForObject("SELECT NOTI_TYPE, PHONE_NUMBER FROM NOTI_LOG WHERE LOG_ID = ?",
                                           new Object[]{logId},
                                           new BeanPropertyRowMapper<>(Log.class));
    }
}
