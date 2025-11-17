package com.example.umc_mission.domain.review.controller;

import com.example.umc_mission.domain.review.dto.ReviewDto;
import com.example.umc_mission.domain.review.repository.ReviewQueryDslImpl;
import com.example.umc_mission.domain.review.service.ReviewQueryService;
import com.example.umc_mission.global.apiPayload.ApiResponse;
import com.example.umc_mission.global.apiPayload.code.GeneralSuccessCode;
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
    public ApiResponse<List<ReviewDto>> searchReview(
            @RequestParam String query,
            @RequestParam String type
    ){

        // 응답 코드 정의
        GeneralSuccessCode code = GeneralSuccessCode.OK;

        // 서비스에게 요청
        List<ReviewDto> result = reviewQueryService.searchReview(query, type);

        return ApiResponse.onSuccess(
                code,
                result
        );

    }

    @GetMapping("/reviews")
    public ApiResponse<List<ReviewDto>> getMyReviews(
            @RequestParam Long memberId, // 임시 쿼리
            @RequestParam(required = false) String query,
            @RequestParam(required = false) String type
    ){
        // 응답 코드 정의
        GeneralSuccessCode code = GeneralSuccessCode.OK;

        List<ReviewDto> result = reviewQueryService.getMyReviews(memberId, query, type);

        return ApiResponse.onSuccess(
                code,
                result
        );
    }

}
