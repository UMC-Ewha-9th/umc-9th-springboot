package com.example.umc9th.domain.service;

import com.example.umc9th.domain.entity.Bookmark;
import com.example.umc9th.domain.entity.Member;
import com.example.umc9th.domain.entity.Restaurant;
import com.example.umc9th.domain.repository.BookmarkRepository;
import com.example.umc9th.domain.repository.MemberRepository;
import com.example.umc9th.domain.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Book;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookmarkService {

    private final BookmarkRepository bookmarkRepository;
    private final MemberRepository memberRepository;
    private final RestaurantRepository restaurantRepository;

    // 비관적 락 사용 (동시 찜 방지)
    @Transactional
    public void addBookmark(Long memberId, Long restaurantId) {

        // 락을 걸고 조회
        Optional<Bookmark> existing = bookmarkRepository.findForUpdate(memberId, restaurantId);
        if (existing.isPresent()) {
            throw new IllegalStateException("이미 찜한 식당입니다.");
        }

        Member member = memberRepository.getReferenceById(memberId);
        Restaurant restaurant = restaurantRepository.getReferenceById(restaurantId);

        Bookmark bookmark = Bookmark.builder()
                .member(member)
                .restaurant(restaurant)
                .build();

        bookmarkRepository.save(bookmark);
    }

    // 낙관적 락 예시
    /*
    @Transactional
    public void updateBookmarkOptimistic(Long bookmarkId, Long restaurantId) {
        Bookmark bookmark = bookmarkRepository.findById(bookmarkId)
                .orElseThrow(() -> new EntityNotFoundException("Bookmark not found"));

        // 어떤 변경이든 version 필드를 트리거함
        bookmark.setRestaurant(restaurantRepository.getReferenceById(restaurantId));
    }
    */
}