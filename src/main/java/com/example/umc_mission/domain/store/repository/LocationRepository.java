package com.example.umc_mission.domain.store.repository;

import com.example.umc_mission.domain.store.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocationRepository extends JpaRepository<Location, Long> {
    Optional<Object> findByName(String name);
}
