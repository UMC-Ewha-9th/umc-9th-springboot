package com.example.umc_mission.domain.review.repository;

import com.example.umc_mission.domain.review.dto.ReviewDto;
import com.example.umc_mission.domain.review.entity.Review;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

import java.util.List;

public interface ReviewQueryDsl {

    // 검색 API
    List<ReviewDto> searchReview(
            Predicate predicate
    );

    List<ReviewDto> getMyReviews(
            Predicate predicate
    );
}
