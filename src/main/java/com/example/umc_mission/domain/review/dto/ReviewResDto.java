package com.example.umc_mission.domain.review.dto;

import lombok.Builder;

import java.time.LocalDateTime;

public class ReviewResDto {

    @Builder
    public record addReviewDto (
            Long reviewId,
            Long memberId,
            Long storeId,
            Float star,
            String content,
            LocalDateTime createdAt
    ){}

}
