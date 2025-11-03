package com.example.umc9th.domain.user.repository;

import com.example.umc9th.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);
    boolean existsByNickname(String nickname);

    // ✅ 마이페이지 요약(리뷰/진행중/완료 카운트) - JPQL 서브쿼리 3개
    @Query("""
        SELECT
          (SELECT COUNT(r) FROM Review r WHERE r.user.id = :userId) AS reviewCount,
          (SELECT COUNT(um1) FROM UserMission um1 WHERE um1.user.id = :userId AND um1.status = 'CLAIMED') AS inProgressCount,
          (SELECT COUNT(um2) FROM UserMission um2 WHERE um2.user.id = :userId AND um2.status = 'COMPLETED') AS doneCount
        FROM User u
        WHERE u.id = :userId
    """)
    Object findMyPageCounts(@Param("userId") Long userId);
}
