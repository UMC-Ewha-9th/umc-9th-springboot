package com.example.umc9th.domain.review.repository;

import com.example.umc9th.domain.review.entity.QReview;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.store.entity.QStore;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Review> findMyReviews(Long userId, String storeName, Integer rating) {
        QReview review = QReview.review;
        QStore store = QStore.store;

        BooleanBuilder builder = new BooleanBuilder();

        //  작성자 필터
        builder.and(review.user.id.eq(userId));

        //  가게 이름 필터
        if (storeName != null && !storeName.isBlank()) {
            builder.and(review.store.name.containsIgnoreCase(storeName));
        }

        //  별점 필터
        if (rating != null) {
            builder.and(review.rating.eq(rating));
        }

        //  Query 실행
        return queryFactory
                .selectFrom(review)
                .leftJoin(review.store, store).fetchJoin()
                .where(builder)
                .orderBy(review.createdAt.desc())
                .fetch();
    }
}
