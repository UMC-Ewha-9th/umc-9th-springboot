package com.example.umc_mission.domain.mission.controller;

import com.example.umc_mission.domain.mission.dto.MemberMissionReqDto;
import com.example.umc_mission.domain.mission.dto.MemberMissionResDto;
import com.example.umc_mission.domain.mission.dto.MissionReqDto;
import com.example.umc_mission.domain.mission.dto.MissionResDto;
import com.example.umc_mission.domain.mission.exception.code.MemberMissionSuccessCode;
import com.example.umc_mission.domain.mission.exception.code.MissionSuccessCode;
import com.example.umc_mission.domain.mission.service.command.MemberMissionCommandService;
import com.example.umc_mission.domain.mission.service.command.MissionCommandService;
import com.example.umc_mission.global.apiPayload.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MissionController {

    private final MissionCommandService missionCommandService;
    private final MemberMissionCommandService memberMissionCommandService;

    // 미션 추가
    @PostMapping("/mission")
    public ApiResponse<MissionResDto.addMissionDto> addMission(
            @RequestBody MissionReqDto.addMissionDto dto
    ){
        return ApiResponse.onSuccess(MissionSuccessCode.CREATED, missionCommandService.addMission(dto));
    }

    // 미션 도전
    @PostMapping("/mission/challenge")
    public ApiResponse<MemberMissionResDto.addMemberMissionDto> addMemberMission(
            @RequestBody MemberMissionReqDto.addMemberMissionDto dto
    ){
        return ApiResponse.onSuccess(MemberMissionSuccessCode.CREATED, memberMissionCommandService.addMemberMission(dto));
    }

}
