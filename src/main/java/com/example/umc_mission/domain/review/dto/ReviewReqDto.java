package com.example.umc_mission.domain.review.dto;

public class ReviewReqDto {

    public record addReviewDto (
        Long memberId,
        Long storeId,
        Float star,
        String content
    ){}

}
