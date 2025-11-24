package com.example.umc_mission.domain.mission.service.command;

import com.example.umc_mission.domain.mission.converter.MissionConverter;
import com.example.umc_mission.domain.mission.dto.MissionReqDto;
import com.example.umc_mission.domain.mission.dto.MissionResDto;
import com.example.umc_mission.domain.mission.entity.Mission;
import com.example.umc_mission.domain.mission.repository.MissionRepository;
import com.example.umc_mission.domain.store.entity.Store;
import com.example.umc_mission.domain.store.exception.StoreException;
import com.example.umc_mission.domain.store.exception.code.StoreErrorCode;
import com.example.umc_mission.domain.store.repository.StoreRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {

    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;

    // 미션 추가
    @Transactional
    @Override
    public MissionResDto.addMissionDto addMission(
            MissionReqDto.addMissionDto dto
    ){
        // 가게 존재 여부 검증
        Store store = storeRepository.findById(dto.storeId())
                .orElseThrow(() -> new StoreException(StoreErrorCode.NOT_FOUND));

        // 미션 생성
        Mission mission = MissionConverter.toMission(dto, store);
        // DB 적용
        missionRepository.save(mission);

        return MissionConverter.toAddMissionDto(mission);
    }

}
