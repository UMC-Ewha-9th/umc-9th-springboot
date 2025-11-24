package com.example.umc_mission.domain.review.service.query;

import com.example.umc_mission.domain.review.dto.ReviewDto;
import com.example.umc_mission.domain.review.entity.QReview;
import com.example.umc_mission.domain.review.repository.ReviewRepository;
import com.example.umc_mission.domain.store.entity.QLocation;
import com.example.umc_mission.domain.store.entity.QStore;
import com.querydsl.core.BooleanBuilder;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewQueryService {

    private final ReviewRepository reviewRepository;
    private final EntityManager em;

    // Q클래스 정의
    QReview review = QReview.review;
    QLocation location = QLocation.location;
    QStore store = QStore.store;

    // 쿼리 테스트
    public List<ReviewDto> searchReview(
            String query,
            String type
    ){

        // BooleanBuilder 정의
        BooleanBuilder builder = new BooleanBuilder();

        // BooleanBuilder 사용

        // 동적 쿼리: 검색 조건
        if (type.equals("location")) {
            builder.and(location.name.contains(query));
        }
        if (type.equals("star")) {
            builder.and(review.star.goe(Float.parseFloat(query)));
        }
        if (type.equals("both")) {

            // & 기준 변환
            String firstQuery = query.split("&")[0];
            String secondQuery = query.split("&")[1];

            // 동적 쿼리
            builder.and(location.name.contains(firstQuery));
            builder.and(review.star.goe(Float.parseFloat(secondQuery)));

        }

        // Repository 사용 & 결과 매핑
        List<ReviewDto> reviewList = reviewRepository.searchReview(builder);

        // 리턴
        return reviewList;
    }

    public List<ReviewDto> getMyReviews(
            Long memberId, // 임시 쿼리
            String query,
            String type
    ) {

        // BooleanBuilder 정의
        BooleanBuilder builder = new BooleanBuilder();

        // BooleanBuilder 사용

        // 동적 쿼리: 필터 적용

        builder.and(review.member.id.eq(memberId));

        // 필터 미지정 시 내 리뷰 조회
        if (type == null || type.isBlank()) {
            return reviewRepository.getMyReviews(builder);
        }

        if (type.equals("store")) {
            builder.and(store.name.contains(query));
        }

        if (type.equals("star")) {
            float star = Float.parseFloat(query);
            builder.and(review.star.goe(star))
                    .and(review.star.lt(star + 1.0f));
        }

        if (type.equals("both")) {

            String[] parts = query.split("&",2);

            String storeQ = parts[0].trim();
            float star = Float.parseFloat(parts[1].trim());

            builder.and(store.name.contains(storeQ));
            builder.and(review.star.goe(star))
                    .and(review.star.lt(star + 1.0f));

        }

        // Repository 사용 & 결과 매핑
        List<ReviewDto> reviewList = reviewRepository.searchReview(builder);

        // 리턴
        return reviewList;

    }
}
