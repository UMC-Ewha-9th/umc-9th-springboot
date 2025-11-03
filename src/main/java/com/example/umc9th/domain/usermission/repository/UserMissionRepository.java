package com.example.umc9th.domain.usermission.repository;

import com.example.umc9th.domain.usermission.entity.UserMission;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserMissionRepository extends JpaRepository<UserMission, Long> {

    //  진행중 목록 (CLAIMED)
    @Query("""
        SELECT um
        FROM UserMission um
        JOIN FETCH um.mission m
        JOIN FETCH m.store s
        WHERE um.user.id = :userId
          AND um.status = 'CLAIMED'
        ORDER BY um.claimedAt DESC
    """)
    List<UserMission> findOngoing(@Param("userId") Long userId, Pageable pageable);

    //  완료 목록 (COMPLETED)
    @Query("""
        SELECT um
        FROM UserMission um
        JOIN FETCH um.mission m
        JOIN FETCH m.store s
        WHERE um.user.id = :userId
          AND um.status = 'COMPLETED'
        ORDER BY
          CASE WHEN um.completedAt IS NULL THEN 1 ELSE 0 END ASC,
          um.completedAt DESC,
          um.id DESC
    """)
    List<UserMission> findCompleted(@Param("userId") Long userId, Pageable pageable);
}
