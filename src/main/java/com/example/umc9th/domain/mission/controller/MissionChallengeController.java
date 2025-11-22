package com.example.umc9th.domain.mission.controller;

import com.example.umc9th.domain.mission.dto.MissionChallengeReqDTO;
import com.example.umc9th.domain.mission.dto.MissionChallengeResDTO;
import com.example.umc9th.domain.mission.service.MissionChallengeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionChallengeController {

    private final MissionChallengeService missionChallengeService;

    @PostMapping("/{missionId}/challenge")
    public MissionChallengeResDTO.CreateDTO challengeMission(
            @PathVariable Long missionId,
            @RequestBody MissionChallengeReqDTO.CreateDTO dto
    ) {
        return missionChallengeService.challenge(missionId, dto);
    }
}
