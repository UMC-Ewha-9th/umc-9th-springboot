package com.example.umc_mission.domain.review.service.command;

import com.example.umc_mission.domain.member.entity.Member;
import com.example.umc_mission.domain.member.exception.MemberException;
import com.example.umc_mission.domain.member.exception.code.MemberErrorCode;
import com.example.umc_mission.domain.member.repository.MemberRepository;
import com.example.umc_mission.domain.review.converter.ReviewConverter;
import com.example.umc_mission.domain.review.dto.ReviewReqDto;
import com.example.umc_mission.domain.review.dto.ReviewResDto;
import com.example.umc_mission.domain.review.entity.Review;
import com.example.umc_mission.domain.review.repository.ReviewRepository;
import com.example.umc_mission.domain.store.entity.Store;
import com.example.umc_mission.domain.store.exception.StoreException;
import com.example.umc_mission.domain.store.exception.code.StoreErrorCode;
import com.example.umc_mission.domain.store.repository.StoreRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;

    // 리뷰 추가
    @Transactional
    @Override
    public ReviewResDto.addReviewDto addReview(
            ReviewReqDto.addReviewDto dto
    ){
        // 사용자 존재 여부 검증
        Member member = memberRepository.findById(dto.memberId())
                .orElseThrow(() -> new MemberException(MemberErrorCode.NOT_FOUND));

        // 가게 존재 여부 검증
        Store store = storeRepository.findById(dto.storeId())
                .orElseThrow(() -> new StoreException(StoreErrorCode.NOT_FOUND));

        // 리뷰 생성
        Review review = ReviewConverter.toReview(dto, member, store);
        // DB 적용
        reviewRepository.save(review);

        return ReviewConverter.toAddReviewDto(review);
    }

}
