package com.example.umc9th.domain.store.repository;

import com.example.umc9th.domain.store.entity.Store;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
    List<Store> findByRegion_Id(Long regionId);
    boolean existsByRegion_IdAndName(Long regionId, String name);
}
