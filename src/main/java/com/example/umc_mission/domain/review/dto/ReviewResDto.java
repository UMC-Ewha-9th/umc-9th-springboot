package com.example.umc_mission.domain.review.dto;

import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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

    @Builder
    public record ReviewPreviewDto(
            String ownerNickname,
            Float score,
            String body,
            LocalDate createdAt
    ){}

    @Builder
    public record ReviewPreviewListDto(
            List<ReviewPreviewDto> reviewList,
            Integer listSize,
            Integer totalPage,
            Long totalElements,
            Boolean isFirst,
            Boolean isLast
    ){}

}
