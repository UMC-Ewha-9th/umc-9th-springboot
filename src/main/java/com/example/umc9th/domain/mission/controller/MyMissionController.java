package com.example.umc9th.domain.mission.controller;

import com.example.umc9th.domain.mission.dto.MyMissionResDTO;
import com.example.umc9th.domain.mission.service.MyMissionService;
import com.example.umc9th.global.annotation.PageValidate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MyMissionController {

    private final MyMissionService myMissionService;

    @GetMapping("/me")
    public MyMissionResDTO.ChallengeListDTO getMyMissions(
            @RequestParam @PageValidate Integer page,
            @RequestParam Long userId
    ) {
        return myMissionService.getMyInProgress(userId, page);
    }
}
