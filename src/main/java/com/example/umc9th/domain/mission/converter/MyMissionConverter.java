package com.example.umc9th.domain.mission.converter;

import com.example.umc9th.domain.mission.dto.MyMissionResDTO;
import com.example.umc9th.domain.mission.entity.MissionChallenge;
import org.springframework.data.domain.Page;

public class MyMissionConverter {

    public static MyMissionResDTO.ChallengeListDTO toListDTO(Page<MissionChallenge> page) {
        return MyMissionResDTO.ChallengeListDTO.builder()
                .challenges(page.getContent().stream()
                        .map(MyMissionConverter::toDTO)
                        .toList())
                .listSize(page.getSize())
                .totalPage(page.getTotalPages())
                .totalElements(page.getTotalElements())
                .isFirst(page.isFirst())
                .isLast(page.isLast())
                .build();
    }

    public static MyMissionResDTO.ChallengeDTO toDTO(MissionChallenge mc) {
        return MyMissionResDTO.ChallengeDTO.builder()
                .challengeId(mc.getId())
                .missionId(mc.getMission().getId())
                .missionTitle(mc.getMission().getTitle())
                .createdAt(mc.getCreatedAt())
                .build();
    }
}
