package com.example.umc_mission.domain.review.repository;

import com.example.umc_mission.domain.member.entity.QMember;
import com.example.umc_mission.domain.review.dto.ReviewDto;
import com.example.umc_mission.domain.review.entity.QReview;
import com.example.umc_mission.domain.store.entity.QLocation;
import com.example.umc_mission.domain.store.entity.QStore;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // 조회 전용
@RequiredArgsConstructor
public class ReviewQueryDslImpl implements ReviewQueryDsl {

    private final EntityManager em;

    // Q클래스 선언
    QReview review = QReview.review;
    QStore store = QStore.store;
    QLocation location = QLocation.location;
    QMember member = QMember.member;

    // 검색 API
    @Override
    public List<ReviewDto> searchReview(
            Predicate predicate
    ){

        // JPA 세팅
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        return queryFactory
                .select(Projections.constructor(
                        ReviewDto.class,
                        review.id,
                        review.store.name.as("storeName"),
                        review.member.name.as("memberName"),
                        review.star,
                        review.content
                        ))
                .from(review)
                .leftJoin(store).on(store.id.eq(review.store.id))
                .leftJoin(location).on(location.id.eq(store.location.id))
                .leftJoin(member).on(member.id.eq(review.member.id))
                .where(predicate)
                .fetch();
    }

    // 조회 API
    @Override
    public List<ReviewDto> getMyReviews(
            Predicate predicate
    ){

        // JPA 세팅
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        return queryFactory
                .select(Projections.constructor(
                        ReviewDto.class,
                        review.id,
                        review.store.name,
                        review.member.name,
                        review.star,
                        review.content
                ))
                .from(review)
                .leftJoin(review.store, store)
                .leftJoin(review.member, member)
                .where(predicate)
                .fetch();

    }

}
