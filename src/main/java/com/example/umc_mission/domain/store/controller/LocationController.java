package com.example.umc_mission.domain.store.controller;

import com.example.umc_mission.domain.store.dto.LocationReqDto;
import com.example.umc_mission.domain.store.dto.LocationResDto;
import com.example.umc_mission.domain.store.exception.code.LocationSuccessCode;
import com.example.umc_mission.domain.store.service.command.LocationCommandService;
import com.example.umc_mission.global.apiPayload.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LocationController {

    private final LocationCommandService locationCommandService;

    // 지역 추가
    @PostMapping("/location")
    public ApiResponse<LocationResDto.addLocationDto> addLocation(
            @RequestBody @Valid LocationReqDto.addLocationDto dto
    ){
        return ApiResponse.onSuccess(LocationSuccessCode.CREATED, locationCommandService.addLocation(dto));
    }

}
