package com.example.umc_mission.domain.review.repository;

import com.example.umc_mission.domain.review.entity.QReview;
import com.example.umc_mission.domain.review.entity.Review;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewQueryDsl {

}
