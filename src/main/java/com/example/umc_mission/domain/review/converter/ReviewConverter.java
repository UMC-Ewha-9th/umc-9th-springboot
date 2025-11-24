package com.example.umc_mission.domain.review.converter;

import com.example.umc_mission.domain.member.entity.Member;
import com.example.umc_mission.domain.review.dto.ReviewReqDto;
import com.example.umc_mission.domain.review.dto.ReviewResDto;
import com.example.umc_mission.domain.review.entity.Review;
import com.example.umc_mission.domain.store.entity.Store;

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

}
