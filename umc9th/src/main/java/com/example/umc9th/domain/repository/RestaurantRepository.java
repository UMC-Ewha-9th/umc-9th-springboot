package com.example.umc9th.domain.repository;

import com.example.umc9th.domain.entity.Member;
import com.example.umc9th.domain.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
