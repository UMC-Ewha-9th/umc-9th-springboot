package com.example.umc9th.domain.mission.converter;

import com.example.umc9th.domain.mission.dto.MissionResDTO;
import com.example.umc9th.domain.mission.entity.Mission;
import org.springframework.data.domain.Page;

public class MissionConverter {

    public static MissionResDTO.MissionListDTO toMissionListDTO(Page<Mission> page) {
        return MissionResDTO.MissionListDTO.builder()
                .missions(page.getContent().stream()
                        .map(MissionConverter::toMissionDTO)
                        .toList())
                .listSize(page.getSize())
                .totalPage(page.getTotalPages())
                .totalElements(page.getTotalElements())
                .isFirst(page.isFirst())
                .isLast(page.isLast())
                .build();
    }

    public static MissionResDTO.MissionDTO toMissionDTO(Mission mission) {
        return MissionResDTO.MissionDTO.builder()
                .missionId(mission.getId())
                .title(mission.getTitle())
                .active(mission.isActive())
                .startsAt(mission.getStartsAt())
                .endsAt(mission.getEndsAt())
                .build();
    }
}
