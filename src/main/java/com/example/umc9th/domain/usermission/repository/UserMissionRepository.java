package com.example.umc9th.domain.usermission.repository;

import com.example.umc9th.domain.usermission.entity.UserMission;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMissionRepository extends JpaRepository<UserMission, Long> {

    Optional<UserMission> findByUser_IdAndMission_Id(Long userId, Long missionId);

    long countByUser_IdAndStatusAndMission_Store_Region_Id(
            Long userId, UserMission.Status status, Long regionId);
}
