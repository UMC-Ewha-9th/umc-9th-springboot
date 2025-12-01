package com.example.umc9th.domain.mission.service;

import com.example.umc9th.domain.mission.converter.MissionConverter;
import com.example.umc9th.domain.mission.dto.MissionResDTO;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.mission.repository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionServiceImpl implements MissionService {

    private final MissionRepository missionRepository;

    @Override
    public MissionResDTO.MissionListDTO getMissionsByStore(Long storeId, Integer page) {
        PageRequest pr = PageRequest.of(page, 10);
        Page<Mission> result = missionRepository.findAllByStore_Id(storeId, pr);
        return MissionConverter.toMissionListDTO(result);
    }
}
