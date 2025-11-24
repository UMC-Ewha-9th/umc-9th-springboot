package com.example.umc_mission.domain.store.converter;

import com.example.umc_mission.domain.store.dto.LocationReqDto;
import com.example.umc_mission.domain.store.dto.LocationResDto;
import com.example.umc_mission.domain.store.entity.Location;

public class LocationConverter {

    // Entity -> Dto
    public static LocationResDto.addLocationDto toJoinDto(
            Location location
    ){
        return LocationResDto.addLocationDto.builder()
                .locationId(location.getId())
                .name(location.getName())
                .build();
    }


    // Dto -> Entity
    public static Location toLocation(
            LocationReqDto.addLocationDto dto
    ){
        return Location.builder()
                .name(dto.name())
                .build();
    }

}
