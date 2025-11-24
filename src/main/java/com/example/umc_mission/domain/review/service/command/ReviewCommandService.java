package com.example.umc_mission.domain.review.service.command;

import com.example.umc_mission.domain.review.dto.ReviewReqDto;
import com.example.umc_mission.domain.review.dto.ReviewResDto;
import jakarta.transaction.Transactional;

public interface ReviewCommandService {
    // 리뷰 추가
    @Transactional
    ReviewResDto.addReviewDto addReview(
            ReviewReqDto.addReviewDto dto
    );
}
