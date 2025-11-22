package com.example.umc9th.domain.review.controller;

import com.example.umc9th.domain.review.dto.ReviewReqDTO;
import com.example.umc9th.domain.review.dto.ReviewResDTO;
import com.example.umc9th.domain.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    // 내가 작성한 리뷰 보기 API (기존 코드)
    @GetMapping("/my")
    public List<ReviewResDTO.ReviewInfoDTO> getMyReviews(
            @RequestParam Long userId,
            @RequestParam(required = false) String storeName,
            @RequestParam(required = false) Integer rating
    ) {
        return reviewService.getMyReviews(userId, storeName, rating);
    }

    // ⭐ 가게에 리뷰 추가 API (신규 추가)
    @PostMapping("/stores/{storeId}")
    public ReviewResDTO.CreateDTO createReview(
            @PathVariable Long storeId,
            @RequestBody ReviewReqDTO.CreateDTO dto
    ) {
        return reviewService.createReview(storeId, dto);
    }
}
