package com.example.umc_mission.domain.member.repository;

import com.example.umc_mission.domain.member.entity.mapping.MemberFood;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberFoodRepository extends JpaRepository<MemberFood, Long> {

}
