package com.example.umc_mission.domain.store.service.command;

import com.example.umc_mission.domain.store.converter.StoreConverter;
import com.example.umc_mission.domain.store.dto.StoreReqDto;
import com.example.umc_mission.domain.store.dto.StoreResDto;
import com.example.umc_mission.domain.store.entity.Location;
import com.example.umc_mission.domain.store.entity.Store;
import com.example.umc_mission.domain.store.exception.LocationException;
import com.example.umc_mission.domain.store.exception.code.LocationErrorCode;
import com.example.umc_mission.domain.store.repository.LocationRepository;
import com.example.umc_mission.domain.store.repository.StoreRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;
    private final LocationRepository locationRepository;

    // 가게 추가
    @Override
    @Transactional
    public StoreResDto.addStoreDto addStore(
            StoreReqDto.addStoreDto dto
    ){

        // 가게 생성
        Store store = StoreConverter.toStore(dto);
        // 지역 연결
        Location location = locationRepository.findById(dto.locationId())
                .orElseThrow(() -> new LocationException(LocationErrorCode.NOT_FOUND));
        store.setLocation(location);

        // DB 적용
        storeRepository.save(store);

        // 응답 DTO 생성ㄴ
        return StoreConverter.toJoinDto(store);
    }

}
