package com.example.umc9th.domain.repository;

import com.example.umc9th.domain.entity.Bookmark;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {

    // Batch Delete (성능 최적화)
    @Modifying(clearAutomatically = true)
    @Query("DELETE FROM Bookmark b WHERE b.member.id = :memberId")
    void deleteByMemberId(@Param("memberId") Long memberId);

    // 중복 조회
    Optional<Bookmark> findByMemberIdAndRestaurantId(Long memberId, Long restaurantId);

    // 비관적 락 (중복 찜 방지)
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT b FROM Bookmark b WHERE b.member.id = :memberId AND b.restaurant.id = :restaurantId")
    Optional<Bookmark> findForUpdate(@Param("memberId") Long memberId, @Param("restaurantId") Long restaurantId);
}
