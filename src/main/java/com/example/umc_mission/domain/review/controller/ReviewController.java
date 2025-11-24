package com.example.umc_mission.domain.review.controller;

import com.example.umc_mission.domain.review.dto.ReviewDto;
import com.example.umc_mission.domain.review.dto.ReviewReqDto;
import com.example.umc_mission.domain.review.dto.ReviewResDto;
import com.example.umc_mission.domain.review.exception.code.ReviewSuccessCode;
import com.example.umc_mission.domain.review.service.command.ReviewCommandService;
import com.example.umc_mission.domain.review.service.query.ReviewQueryService;
import com.example.umc_mission.global.apiPayload.ApiResponse;
import com.example.umc_mission.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewQueryService reviewQueryService;
    private final ReviewCommandService reviewCommandService;

    // 리뷰 검색
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

    // 리뷰 조회
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

    // 리뷰 추가
    @PostMapping("/reviews")
    public ApiResponse<ReviewResDto.addReviewDto> addReview(
            @RequestBody ReviewReqDto.addReviewDto dto
    ){
        return ApiResponse.onSuccess(ReviewSuccessCode.CREATED, reviewCommandService.addReview(dto));
    }

}
