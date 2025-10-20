package com.example.spring.domain.mission.repository;

import com.example.spring.domain.mission.entity.Mission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface MissionRepository extends JpaRepository<Mission, Long> {

    @Query("""
        SELECT m
        FROM Mission m
        JOIN FETCH m.store s
        WHERE m.user.userId = :userId
          AND (m.assignedAt < :date
               OR (m.assignedAt = :date AND m.missionId < :missionId))
        ORDER BY m.assignedAt DESC, m.missionId DESC
        """)
    List<Mission> findUserMissions(
            @Param("userId") Long userId,
            @Param("date") LocalDate date,
            @Param("missionId") Long missionId
    );
}