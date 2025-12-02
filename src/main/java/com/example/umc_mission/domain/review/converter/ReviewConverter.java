package com.example.umc_mission.domain.review.converter;

import com.example.umc_mission.domain.member.entity.Member;
import com.example.umc_mission.domain.review.dto.ReviewReqDto;
import com.example.umc_mission.domain.review.dto.ReviewResDto;
import com.example.umc_mission.domain.review.entity.Review;
import com.example.umc_mission.domain.store.entity.Store;
import org.springframework.data.domain.Page;

import java.time.LocalDate;

public class ReviewConverter {

    // Entity -> Dto
    public static ReviewResDto.addReviewDto toAddReviewDto(
            Review review
    ){
        return ReviewResDto.addReviewDto.builder()
                .reviewId(review.getId())
                .memberId(review.getMember().getId())
                .storeId(review.getStore().getId())
                .star(review.getStar())
                .content(review.getContent())
                .createdAt(review.getCreatedAt())
                .build();
    }

    // Dto -> Entity
    public static Review toReview(
            ReviewReqDto.addReviewDto dto,
            Member member,
            Store store
    ){
        return Review.builder()
                .member(member)
                .store(store)
                .star(dto.star())
                .content(dto.content())
                .build();

    }

    // result -> DTO
    public static ReviewResDto.ReviewPreviewListDto toReviewPreviewListDto(
            Page<Review> result
    ){
        return ReviewResDto.ReviewPreviewListDto.builder()
                .reviewList(result.getContent().stream()
                        .map(ReviewConverter::toReviewPreviewDto)
                        .toList())
                .listSize(result.getSize())
                .totalPage(result.getTotalPages())
                .totalElements(result.getTotalElements())
                .isFirst(result.isFirst())
                .isLast(result.isLast())
                .build();
    }

    public static ReviewResDto.ReviewPreviewDto toReviewPreviewDto(
            Review review
    ){
        return ReviewResDto.ReviewPreviewDto.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getStar())
                .body(review.getContent())
                .createdAt(LocalDate.from(review.getCreatedAt()))
                .build();
    }

}
