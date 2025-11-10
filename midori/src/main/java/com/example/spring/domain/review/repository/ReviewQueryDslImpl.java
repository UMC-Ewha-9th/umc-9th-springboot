package com.example.spring.domain.review.repository;

import com.example.spring.domain.review.entity.QReview;
import com.example.spring.domain.store.entity.QStore;
import com.example.spring.domain.review.entity.Review;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewQueryDslImpl implements ReviewQueryDsl {

    private final EntityManager em;

    @Override
    public List<Review> searchReview(Long userId, String storeName, String starGroup) {

        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        QReview review = QReview.review;
        QStore store = QStore.store;

        BooleanBuilder builder = new BooleanBuilder();

        // 유저 기준 (내 리뷰)
        if (userId != null) {
            builder.and(review.user.userId.eq(userId));
        }

        // 가게 이름 필터
        if (storeName != null && !storeName.isEmpty()) {
            builder.and(store.storeName.containsIgnoreCase(storeName));
        }

        // 별점대 필터 (예: "4" → 4.0~4.9)
        if (starGroup != null) {
            switch (starGroup) {
                case "5": builder.and(review.star.between(5.0, 5.0)); break;
                case "4": builder.and(review.star.between(4.0, 4.9)); break;
                case "3": builder.and(review.star.between(3.0, 3.9)); break;
                case "2": builder.and(review.star.between(2.0, 2.9)); break;
                case "1": builder.and(review.star.between(1.0, 1.9)); break;
            }
        }

        return queryFactory
                .selectFrom(review)
                .leftJoin(review.store, store).fetchJoin()
                .where(builder)
                .orderBy(review.createdAt.desc())
                .fetch();
    }
}

