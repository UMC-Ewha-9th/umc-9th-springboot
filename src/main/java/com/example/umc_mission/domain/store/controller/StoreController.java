package com.example.umc_mission.domain.store.controller;

import com.example.umc_mission.domain.store.dto.StoreReqDto;
import com.example.umc_mission.domain.store.dto.StoreResDto;
import com.example.umc_mission.domain.store.exception.code.StoreSuccessCode;
import com.example.umc_mission.domain.store.service.command.StoreCommandService;
import com.example.umc_mission.global.apiPayload.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StoreController {

    private final StoreCommandService storeCommandService;

    // 가게 추가
    @PostMapping("/store")
    public ApiResponse<StoreResDto.addStoreDto> addStore(
            @RequestBody @Valid StoreReqDto.addStoreDto dto
    ){
        return ApiResponse.onSuccess(StoreSuccessCode.CREATED, storeCommandService.addStore(dto));
    }

}
