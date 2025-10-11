package com.example.umc9th.domain.review.repository;

import com.example.umc9th.domain.review.entity.Review;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Optional<Review> findByUserMission_Id(Long userMissionId);
    boolean existsByUserMission_Id(Long userMissionId); // 한 이력당 리뷰 1개 검증용
}
