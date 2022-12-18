package com.nhndooray.edu.spring_core.repository;

import com.nhndooray.edu.spring_core.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, String> {
}
