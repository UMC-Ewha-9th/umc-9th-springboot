package com.example.umc9th.domain.review.service;

import com.example.umc9th.domain.review.dto.ReviewReqDTO;
import com.example.umc9th.domain.review.dto.ReviewResDTO;

import java.util.List;

public interface ReviewService {

    // 기존 API
    List<ReviewResDTO.ReviewInfoDTO> getMyReviews(Long userId, String storeName, Integer rating);

    // 신규 추가 API
    ReviewResDTO.CreateDTO createReview(Long storeId, ReviewReqDTO.CreateDTO dto);
}
