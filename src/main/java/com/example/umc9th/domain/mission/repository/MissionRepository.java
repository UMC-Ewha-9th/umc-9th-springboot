package com.example.umc9th.domain.mission.repository;

import com.example.umc9th.domain.mission.entity.Mission;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MissionRepository extends JpaRepository<Mission, Long> {

    // 기존 메서드 유지
    List<Mission> findByStore_Id(Long storeId);
    boolean existsByStore_IdAndTitle(Long storeId, String title);

    //  홈 화면: 지역 기반 + 활성 + 기간 유효 미션 (페이징 가능)
    @Query("""
        SELECT m
        FROM Mission m
        JOIN m.store s
        WHERE s.region.id = :regionId
          AND m.isActive = true
          AND (m.startsAt IS NULL OR m.startsAt <= CURRENT_TIMESTAMP)
          AND (m.endsAt   IS NULL OR m.endsAt   >= CURRENT_TIMESTAMP)
        ORDER BY
          CASE WHEN m.endsAt IS NULL THEN 1 ELSE 0 END ASC,
          m.endsAt DESC,
          m.id DESC
    """)
    List<Mission> findActiveByRegion(@Param("regionId") Long regionId, Pageable pageable);
}
