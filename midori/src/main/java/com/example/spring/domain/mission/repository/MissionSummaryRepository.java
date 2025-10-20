package com.example.spring.domain.mission.repository;

import com.example.spring.domain.mission.dto.MissionSummary;
import com.example.spring.domain.mission.entity.Mission;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface MissionSummaryRepository extends JpaRepository<Mission, Long> {

    @Query("""
        SELECT COUNT(m2) AS missionCount,
               m.missionId AS missionId,
               s.storeName AS storeName,
               m.status AS status,
               m.assignedAt AS assignedAt,
               u.points AS points
        FROM Mission m
        JOIN m.store s
        JOIN m.user u
        LEFT JOIN Mission m2 ON m2.user = u
        WHERE u.userId = :userId
          AND (m.assignedAt < :date
               OR (m.assignedAt = :date AND m.missionId < :missionId))
        GROUP BY m.missionId, s.storeName, m.status, m.assignedAt, u.points
        ORDER BY m.assignedAt DESC, m.missionId DESC
        """)
    List<MissionSummary> findMissionSummary(
            @Param("userId") Long userId,
            @Param("date") LocalDate date,
            @Param("missionId") Long missionId
    );
}