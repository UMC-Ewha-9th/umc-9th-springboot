package com.example.umc_mission.domain.mission.service.query;

import com.example.umc_mission.domain.mission.converter.MissionConverter;
import com.example.umc_mission.domain.mission.dto.MissionResDto;
import com.example.umc_mission.domain.mission.entity.Mission;
import com.example.umc_mission.domain.mission.repository.MissionRepository;
import com.example.umc_mission.domain.store.entity.Store;
import com.example.umc_mission.domain.store.exception.StoreException;
import com.example.umc_mission.domain.store.exception.code.StoreErrorCode;
import com.example.umc_mission.domain.store.repository.StoreRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionQueryServiceImpl implements MissionQueryService {

    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;

    // 가게 미션 목록 조회
    @Transactional
    @Override
    public MissionResDto.MissionPreviewListDto getMissionsByStore(
            String storeName,
            Integer page
    ){
        // 가게 조회
        // 없으면 예외
        Store store = storeRepository.findByName(storeName)
                .orElseThrow(() -> new StoreException(StoreErrorCode.NOT_FOUND));

        // 가게 미션 조회
        int pageIndex = Math.max(page - 1, 0);
        PageRequest pageRequest = PageRequest.of(pageIndex, 10);
        Page<Mission> result = missionRepository.findAllByStore(store, pageRequest);

        // 반환
        return MissionConverter.toMissionPreviewListDto(result);
    }

}
