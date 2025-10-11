package com.example.umc9th.domain.region.repository;

import com.example.umc9th.domain.region.entity.Region;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region, Long> {
    Optional<Region> findByName(String name);
    boolean existsByName(String name);
}
