package com.nhndooray.edu.spring_core.repository.impl;

import com.nhndooray.edu.spring_core.domain.Member;
import com.nhndooray.edu.spring_core.repository.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

// TODO : #4 JdbcTemplate을 이용하여 MemberDao 구현체 생성.
@Repository
public class MemberDaoImpl implements MemberDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Member getMember(String name) {
        try {
            return jdbcTemplate.queryForObject("SELECT NAME, PHONE_NUMBER FROM MEMBER WHERE NAME = ?",
                                               new Object[]{name},
                                               new BeanPropertyRowMapper<>(Member.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void insertMember(Member member) {
        jdbcTemplate.update("INSERT INTO MEMBER ( NAME, PHONE_NUMBER ) VALUES ( ?, ? )",
                            member.getName(),
                            member.getPhoneNumber());
    }

    @Override
    public void updateMember(Member member) {

        // TODO : #8 만약 여기서 exception이 발생하면?
//        if ("global".equals(member.getName())) {
//            throw new RuntimeException("error occurred!!!");
//        }

        jdbcTemplate.update("UPDATE MEMBER SET PHONE_NUMBER = ? WHERE NAME = ?",
                            member.getPhoneNumber(),
                            member.getName());
    }

}
