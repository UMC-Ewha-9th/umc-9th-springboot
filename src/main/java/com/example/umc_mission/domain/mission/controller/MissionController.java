package com.example.umc_mission.domain.mission.controller;

import com.example.umc_mission.domain.mission.dto.MemberMissionReqDto;
import com.example.umc_mission.domain.mission.dto.MemberMissionResDto;
import com.example.umc_mission.domain.mission.dto.MissionReqDto;
import com.example.umc_mission.domain.mission.dto.MissionResDto;
import com.example.umc_mission.domain.mission.enums.Status;
import com.example.umc_mission.domain.mission.exception.code.MemberMissionSuccessCode;
import com.example.umc_mission.domain.mission.exception.code.MissionSuccessCode;
import com.example.umc_mission.domain.mission.service.command.MemberMissionCommandService;
import com.example.umc_mission.domain.mission.service.command.MissionCommandService;
import com.example.umc_mission.domain.mission.service.query.MemberMissionQueryService;
import com.example.umc_mission.domain.mission.service.query.MissionQueryService;
import com.example.umc_mission.global.apiPayload.ApiResponse;
import com.example.umc_mission.global.config.CustomUserDetails;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MissionController implements MissionControllerDocs {

    private final MissionCommandService missionCommandService;
    private final MemberMissionCommandService memberMissionCommandService;
    private final MissionQueryService missionQueryService;
    private final MemberMissionQueryService memberMissionQueryService;

    // 미션 추가
    @PostMapping("/missions")
    public ApiResponse<MissionResDto.addMissionDto> addMission(
            @RequestBody @Valid MissionReqDto.addMissionDto dto
    ){
        return ApiResponse.onSuccess(MissionSuccessCode.CREATED, missionCommandService.addMission(dto));
    }

    // 미션 도전
    @PostMapping("/missions/challenge/{missionId}")
    public ApiResponse<MemberMissionResDto.addMemberMissionDto> addMemberMission(
            @AuthenticationPrincipal CustomUserDetails user,
            @PathVariable Long missionId
    ){
        return ApiResponse.onSuccess(MemberMissionSuccessCode.CREATED, memberMissionCommandService.addMemberMission(user, missionId));
    }

    // 미션 완료
    @PatchMapping("/missions/completed/{memberMissionId}")
    public ApiResponse<MemberMissionResDto.myMissionPreviewListDto> completeMemberMission(
            @AuthenticationPrincipal CustomUserDetails user,
            @PathVariable Long memberMissionId
    ) {
        return ApiResponse.onSuccess(MemberMissionSuccessCode.OK, memberMissionCommandService.completeMemberMission(user, memberMissionId));
    }

    // 내 미션 목록 조회 (도전 중 / 진행 완료)
    @GetMapping("/missions/my")
    public ApiResponse<MemberMissionResDto.myMissionPreviewListDto> getMyMissions(
            @AuthenticationPrincipal CustomUserDetails user,
            @RequestParam Status status,
            @RequestParam(defaultValue = "1") Integer page
    ){
        MemberMissionSuccessCode code = MemberMissionSuccessCode.FOUND;
        return ApiResponse.onSuccess(code, memberMissionQueryService.getMyMissions(user, status, page));
    }

    // 가게 미션 목록 조회
    @GetMapping("/missions/store")
    public ApiResponse<MissionResDto.MissionPreviewListDto> getMissions(
            @RequestParam String storeName,
            @RequestParam(defaultValue = "1") Integer page
    ){
        MissionSuccessCode code = MissionSuccessCode.FOUND;
        return ApiResponse.onSuccess(code, missionQueryService.getMissionsByStore(storeName, page));
    }

}
