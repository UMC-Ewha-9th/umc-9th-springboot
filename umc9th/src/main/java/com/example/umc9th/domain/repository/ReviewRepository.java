package com.example.umc9th.domain.repository;

import com.example.umc9th.domain.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Modifying(clearAutomatically = true)
    @Query("DELETE FROM Review r WHERE r.member.id = :memberId")
    void deleteByMemberId(@Param("memberId") Long memberId);
}
