package com.example.umc9th.domain.review.repository;

import com.example.umc9th.domain.review.entity.Review;
import java.util.List;

public interface ReviewRepositoryCustom {

    /**
     * 내가 작성한 리뷰 목록 조회
     * @param userId 작성자 ID
     * @param storeName 필터링할 가게 이름 (nullable)
     * @param rating 별점 필터 (nullable)
     */
    List<Review> findMyReviews(Long userId, String storeName, Integer rating);
}
