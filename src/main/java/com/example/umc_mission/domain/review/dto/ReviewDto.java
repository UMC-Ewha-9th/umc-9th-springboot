package com.example.umc_mission.domain.review.dto;

import lombok.*;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDto {

    private Long id;
    private String content;
    private Float star;
    private Long storeId;
    private Long memberId;

}
