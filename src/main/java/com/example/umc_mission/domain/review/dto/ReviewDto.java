package com.example.umc_mission.domain.review.dto;

import lombok.*;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDto {

    private Long id;
    private String storeName;
    private String memberName;
    private Float star;
    private String content;

}
