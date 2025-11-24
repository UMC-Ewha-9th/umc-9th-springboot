package com.example.umc_mission.domain.member.repository;

import com.example.umc_mission.domain.member.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
