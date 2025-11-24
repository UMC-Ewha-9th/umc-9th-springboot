package com.example.umc_mission.domain.mission.dto;

import java.time.LocalDate;

public class MissionReqDto {

    public record addMissionDto(
      Long storeId,
      String conditional,
      Integer point,
      LocalDate deadline
    ){}

}
