package com.example.umc_mission.domain.store.repository;

import com.example.umc_mission.domain.store.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
