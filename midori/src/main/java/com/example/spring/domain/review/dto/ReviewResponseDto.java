package com.example.spring.domain.review.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
public class ReviewResponseDto {
    private Long reviewId;
    private String storeName;
    private String content;
    private Double star;
    private String reply;
    private LocalDate createdAt;
}