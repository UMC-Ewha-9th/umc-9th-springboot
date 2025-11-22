package com.example.umc9th.domain.review.dto;

import lombok.Builder;

import java.time.LocalDateTime;

public class ReviewResDTO {

    // 리뷰 생성 응답 DTO
    @Builder
    public record CreateDTO(
            Long reviewId,
            LocalDateTime createdAt
    ) {}

    // 기존 리뷰 조회 응답 DTO
    @Builder
    public record ReviewInfoDTO(
            Long id,
            String storeName,
            Integer rating,
            String content,
            LocalDateTime createdAt
    ) {}
}
