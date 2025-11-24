package com.example.umc9th.domain.review.service;

import com.example.umc9th.domain.review.dto.ReviewReqDTO;
import com.example.umc9th.domain.review.dto.ReviewResDTO;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.repository.ReviewRepository;
import com.example.umc9th.domain.review.converter.ReviewConverter;
import com.example.umc9th.domain.store.entity.Store;
import com.example.umc9th.domain.store.repository.StoreRepository;
import com.example.umc9th.domain.user.entity.User;
import com.example.umc9th.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final UserRepository userRepository;

    @Override
    public List<ReviewResDTO.ReviewInfoDTO> getMyReviews(Long userId, String storeName, Integer rating) {
        List<Review> reviews = reviewRepository.findMyReviews(userId, storeName, rating);
        return reviews.stream().map(ReviewConverter::toReviewInfoDTO).toList();
    }

    @Override
    @Transactional
    public ReviewResDTO.CreateDTO createReview(Long storeId, ReviewReqDTO.CreateDTO dto) {

        // 로그인 없으므로 유저 하드코딩
        User user = userRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new RuntimeException("Store not found"));

        Review review = Review.builder()
                .store(store)
                .user(user)
                .rating(dto.rating())
                .content(dto.content())
                .build();

        reviewRepository.save(review);

        return ReviewConverter.toCreateDTO(review);
    }
}
