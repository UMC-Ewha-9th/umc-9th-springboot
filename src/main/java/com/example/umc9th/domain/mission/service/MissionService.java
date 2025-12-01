package com.example.umc9th.domain.mission.service;

import com.example.umc9th.domain.mission.dto.MissionResDTO;

public interface MissionService {
    MissionResDTO.MissionListDTO getMissionsByStore(Long storeId, Integer page);
}
