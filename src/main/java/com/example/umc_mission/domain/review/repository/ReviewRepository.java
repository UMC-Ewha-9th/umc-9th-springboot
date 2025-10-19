package com.example.umc_mission.domain.review.repository;

import com.example.umc_mission.domain.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    //리뷰 작성
    //Review save(Review review);

}
