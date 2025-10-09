package com.example.umc9th.domain.service;

import com.example.umc9th.domain.repository.BookmarkRepository;
import com.example.umc9th.domain.repository.FoodPreferenceRepository;
import com.example.umc9th.domain.repository.MemberRepository;
import com.example.umc9th.domain.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final FoodPreferenceRepository foodPreferenceRepository;
    private final ReviewRepository reviewRepository;
    private final BookmarkRepository bookmarkRepository;

    @Transactional
    public void deleteMemberAndRelatedData(Long memberId) {
        // 관련 데이터 일괄 삭제
        foodPreferenceRepository.deleteByMemberId(memberId);
        bookmarkRepository.deleteByMemberId(memberId);
        reviewRepository.deleteByMemberId(memberId);

        // 마지막에 회원 삭제
        memberRepository.deleteById(memberId);
    }
}
