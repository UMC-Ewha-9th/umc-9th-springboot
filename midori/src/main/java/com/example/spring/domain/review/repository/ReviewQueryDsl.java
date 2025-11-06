package com.example.spring.domain.review.repository;

import com.example.spring.domain.review.entity.Review;
import java.util.List;

public interface ReviewQueryDsl {

    // 내가 작성한 리뷰 조회 (필터: 가게명 + 별점대)
    List<Review> searchReview(Long userId, String storeName, String starGroup);
}

