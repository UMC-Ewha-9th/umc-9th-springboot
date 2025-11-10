package com.example.spring.domain.review.controller;

import com.example.spring.domain.review.entity.Review;
import com.example.spring.domain.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/my")
    public List<Review> getMyReviews(
            @RequestParam Long userId,
            @RequestParam(required = false) String storeName,
            @RequestParam(required = false) String starGroup
    ) {
        return reviewService.getMyReviews(userId, storeName, starGroup);
    }
}
