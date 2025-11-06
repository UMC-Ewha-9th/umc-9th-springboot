package com.example.spring.domain.review.service;

import com.example.spring.domain.review.entity.Review;
import com.example.spring.domain.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public List<Review> getMyReviews(Long userId, String storeName, String starGroup) {
        return reviewRepository.searchReview(userId, storeName, starGroup);
    }
}
