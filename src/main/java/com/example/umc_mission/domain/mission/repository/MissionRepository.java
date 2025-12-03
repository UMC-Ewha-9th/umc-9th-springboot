package com.example.umc_mission.domain.mission.repository;

import com.example.umc_mission.domain.mission.entity.Mission;
import com.example.umc_mission.domain.store.entity.Location;
import com.example.umc_mission.domain.store.entity.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Long> {

    //지역 미션 목록 조회
    Page<Mission> findByStore_Location(Location store_location, Pageable pageable);

    // 가게별 미션 목록 조회
    Page<Mission> findAllByStore(Store store, PageRequest pageRequest);
}
