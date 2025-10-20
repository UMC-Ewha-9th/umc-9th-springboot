package com.example.spring.domain.mission.dto;

import java.time.LocalDate;

public interface MissionSummary {
    Long getMissionId();
    String getStoreName();
    String getStatus();
    LocalDate getAssignedAt();
    Integer getPoints();
    Long getMissionCount();
}
