package com.example.umc_mission.domain.review.service.query;

import com.example.umc_mission.domain.member.entity.Member;
import com.example.umc_mission.domain.member.exception.MemberException;
import com.example.umc_mission.domain.member.exception.code.MemberErrorCode;
import com.example.umc_mission.domain.member.repository.MemberRepository;
import com.example.umc_mission.domain.review.converter.ReviewConverter;
import com.example.umc_mission.domain.review.dto.ReviewDto;
import com.example.umc_mission.domain.review.dto.ReviewResDto;
import com.example.umc_mission.domain.review.entity.QReview;
import com.example.umc_mission.domain.review.entity.Review;
import com.example.umc_mission.domain.review.repository.ReviewRepository;
import com.example.umc_mission.domain.store.entity.QLocation;
import com.example.umc_mission.domain.store.entity.QStore;
import com.example.umc_mission.domain.store.entity.Store;
import com.example.umc_mission.domain.store.exception.StoreException;
import com.example.umc_mission.domain.store.exception.code.StoreErrorCode;
import com.example.umc_mission.domain.store.repository.StoreRepository;
import com.querydsl.core.BooleanBuilder;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewQueryServiceImpl implements ReviewQueryService {

    private final ReviewRepository reviewRepository;
    private final EntityManager em;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;

    // Q클래스 정의
    QReview review = QReview.review;
    QLocation location = QLocation.location;
    QStore store = QStore.store;

    // 쿼리 테스트
    @Transactional
    @Override
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

    // 내 리뷰 조회
    @Transactional
    @Override
    public ReviewResDto.ReviewPreviewListDto getMyReviews(
            Long memberId, // 임시 쿼리
            String query,
            String type,
            Integer page
    ) {
        // 사용자 확인
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberException(MemberErrorCode.NOT_FOUND));

        // 페이징 설정
        int pageIndex = Math.max(page - 1, 0);
        PageRequest pageRequest = PageRequest.of(pageIndex, 10);
        Page<Review> result;

        // 필터
        // 필터 미지정
        if (type == null || type.isBlank()) {
            result = reviewRepository.findAllByMember(member, pageRequest);
        } // 가게 필터
        else if ("store".equals(type)) {
            result = reviewRepository.findAllByMemberAndStoreNameContaining(member, query, pageRequest);
        } // 별점 필터
        else if ("star".equals(type)) {
            float star = Float.parseFloat(query);
            result = reviewRepository.findAllByMemberAndStarGreaterThanEqualAndStarLessThan(member, star, star + 1.0f, pageRequest);
        } // 가게 & 별점 필터
        else if ("both".equals(type)) {
            String[] parts = query.split("&", 2);
            String storeQ = parts[0].trim();
            float star = Float.parseFloat(parts[1].trim());

            result = reviewRepository.findAllByMemberAndStoreNameAndStarGreaterThanEqualAndStarLessThan(member, storeQ, star, star + 1.0f, pageRequest);
        } else {
            result = reviewRepository.findAllByMember(member, pageRequest);
        }

        // 결과 반환
        return ReviewConverter.toReviewPreviewListDto(result);

    }

    // 리뷰 조회
    @Transactional
    @Override
    public ReviewResDto.ReviewPreviewListDto findReview(
            String storeName,
            Integer page
    ){
        // 가게 존재 여부 검증
        Store store = storeRepository.findByName(storeName)
                .orElseThrow(() -> new StoreException(StoreErrorCode.NOT_FOUND));

        // 가게에 맞는 리뷰 가져오기 (Offset 페이징)
        int pageIndex = Math.max(page - 1, 0);
        PageRequest pageRequest = PageRequest.of(pageIndex, 5);
        Page<Review> result = reviewRepository.findAllByStore(store, pageRequest);

        // 응답 DTO 변환
        return ReviewConverter.toReviewPreviewListDto(result);
    }

}
