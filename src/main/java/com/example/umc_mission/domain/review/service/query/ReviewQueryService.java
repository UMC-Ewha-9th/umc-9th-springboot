package com.example.umc_mission.domain.review.service.query;

import com.example.umc_mission.domain.review.dto.ReviewDto;
import com.example.umc_mission.domain.review.dto.ReviewResDto;
import jakarta.transaction.Transactional;

import java.util.List;

public interface ReviewQueryService {
    // 쿼리 테스트
    @Transactional
    List<ReviewDto> searchReview(
            String query,
            String type
    );

    // 내 리뷰 조회
    @Transactional
    ReviewResDto.ReviewPreviewListDto getMyReviews(
            Long memberId, // 임시 쿼리
            String query,
            String type,
            Integer page
    );

    // 리뷰 조회
    @Transactional
    ReviewResDto.ReviewPreviewListDto findReview(
            String storeName,
            Integer page
    );
}
