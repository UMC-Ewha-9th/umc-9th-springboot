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
public class ReviewController implements ReviewControllerDocs {

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

    // 내 리뷰 조회
    @GetMapping("/reviews/my")
    public ApiResponse<ReviewResDto.ReviewPreviewListDto> getMyReviews(
            @RequestParam Long memberId, // 임시 쿼리
            @RequestParam(required = false) String query,
            @RequestParam(required = false) String type,
            @RequestParam(defaultValue = "1") Integer page
    ){
        // 응답 코드 정의
        ReviewSuccessCode code = ReviewSuccessCode.FOUND;
        return ApiResponse.onSuccess(
                code,
                reviewQueryService.getMyReviews(memberId, query, type, page)
        );
    }

    // 리뷰 추가
    @PostMapping("/reviews")
    public ApiResponse<ReviewResDto.addReviewDto> addReview(
            @RequestBody ReviewReqDto.addReviewDto dto
    ){
        return ApiResponse.onSuccess(ReviewSuccessCode.CREATED, reviewCommandService.addReview(dto));
    }

    // 가게 리뷰 목록 조회
    @GetMapping("/reviews")
    public ApiResponse<ReviewResDto.ReviewPreviewListDto> getReviews(
            @RequestParam String storeName,
            @RequestParam(defaultValue = "1") Integer page
    ){
        ReviewSuccessCode code = ReviewSuccessCode.FOUND;
        return ApiResponse.onSuccess(code, reviewQueryService.findReview(storeName, page));
    }

}
