package com.example.umc9th.domain.repository;

import com.example.umc9th.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
