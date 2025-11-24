package com.example.umc_mission.domain.store.service.command;

import com.example.umc_mission.domain.store.converter.LocationConverter;
import com.example.umc_mission.domain.store.dto.LocationReqDto;
import com.example.umc_mission.domain.store.dto.LocationResDto;
import com.example.umc_mission.domain.store.entity.Location;
import com.example.umc_mission.domain.store.exception.LocationException;
import com.example.umc_mission.domain.store.exception.code.LocationErrorCode;
import com.example.umc_mission.domain.store.repository.LocationRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LocationCommandServiceImpl implements LocationCommandService {

    private final LocationRepository locationRepository;

    // 지역 추가
    @Override
    @Transactional
    public LocationResDto.addLocationDto addLocation(
            LocationReqDto.addLocationDto dto
    ){
        // 지역 생성
        Location location = LocationConverter.toLocation(dto);

        // 지역 중복 검증
        if (locationRepository.findByName((dto.name())).isPresent()) {
            throw new LocationException(LocationErrorCode.CONFLICT);
        } else {
            // DB 적용
            locationRepository.save(location);
        }

        return LocationConverter.toJoinDto(location);
    }

}
