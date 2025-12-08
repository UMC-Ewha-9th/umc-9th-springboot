package com.example.umc_mission.domain.mission.controller;

import com.example.umc_mission.domain.mission.dto.MemberMissionReqDto;
import com.example.umc_mission.domain.mission.dto.MemberMissionResDto;
import com.example.umc_mission.domain.mission.dto.MissionResDto;
import com.example.umc_mission.domain.mission.enums.Status;
import com.example.umc_mission.global.apiPayload.ApiResponse;
import com.example.umc_mission.global.config.CustomUserDetails;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface MissionControllerDocs {

    @Operation(
            summary = "가게별 미션 조회 API (개발 중)",
            description = "가게별 등록된 미션을 모두 조회합니다. 페이지네이션으로 제공합니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "실패")
    })
    ApiResponse<MissionResDto.MissionPreviewListDto> getMissions(String storeName, Integer page);

    @Operation(
            summary = "내가 도전 중 혹은 도전 완료한 미션 조회 API (개발 중)",
            description = "내가 도전 중 혹은 도전 완료한 미션 목록을 모두 조회합니다. 페이지네이션으로 제공합니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "실패")
    })
    ApiResponse<MemberMissionResDto.myMissionPreviewListDto> getMyMissions(CustomUserDetails user, Status status, Integer page);

    @Operation(
            summary = "가게 미션에 도전 API (개발 중)",
            description = "가게의 미션을 나의 도전 중 미션 목록에 추가합니다. 페이지네이션으로 제공합니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "실패")
    })
    ApiResponse<MemberMissionResDto.addMemberMissionDto> addMemberMission(CustomUserDetails user, Long memberMissionId);

    @Operation(
            summary = "도전 중인 미션을 진행 완료로 변경 API (개발 중)",
            description = "도전 완료한 미션의 상태를 변경합니다. 페이지네이션으로 제공합니다."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "실패")
    })
    ApiResponse<MemberMissionResDto.myMissionPreviewListDto> completeMemberMission(CustomUserDetails user, Long memberMissionId);

}
