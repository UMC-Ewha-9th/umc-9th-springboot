package com.example.umc_mission.domain.mission.converter;

import com.example.umc_mission.domain.mission.dto.MissionReqDto;
import com.example.umc_mission.domain.mission.dto.MissionResDto;
import com.example.umc_mission.domain.mission.entity.Mission;
import com.example.umc_mission.domain.store.entity.Store;

public class MissionConverter {

    // Entity -> Dto
    public static MissionResDto.addMissionDto toAddMissionDto(
            Mission mission
    ){
        return MissionResDto.addMissionDto.builder()
                .storeId(mission.getStore().getId())
                .conditional(mission.getConditional())
                .point(mission.getPoint())
                .deadline(mission.getDeadline())
                .createdAt(mission.getCreatedAt())
                .build();
    }

    // Dto -> Entity
    public static Mission toMission(
            MissionReqDto.addMissionDto dto,
            Store store
    ){
        return Mission.builder()
                .store(store)
                .conditional(dto.conditional())
                .point(dto.point())
                .deadline(dto.deadline())
                .build();
    }


}
