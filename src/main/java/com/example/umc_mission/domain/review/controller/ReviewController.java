package com.example.umc_mission.domain.review.controller;

import com.example.umc_mission.domain.review.dto.ReviewDto;
import com.example.umc_mission.domain.review.service.ReviewQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewQueryService reviewQueryService;

    @GetMapping("/reviews/search")
    public List<ReviewDto> searchReview(
            @RequestParam String query,
            @RequestParam String type
    ){

        // 서비스에게 요청
        return reviewQueryService.searchReview(query, type);

    }

    @GetMapping("/reviews")
    public List<ReviewDto> getMyReviews(
            @RequestParam Long memberId, // 임시 쿼리
            @RequestParam(required = false) String query,
            @RequestParam(required = false) String type
    ){
        return reviewQueryService.getMyReviews(memberId, query, type);
    }

}
