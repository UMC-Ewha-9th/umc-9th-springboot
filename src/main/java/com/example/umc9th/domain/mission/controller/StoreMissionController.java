package com.example.umc9th.domain.mission.controller;

import com.example.umc9th.domain.mission.dto.MissionResDTO;
import com.example.umc9th.domain.mission.service.MissionService;
import com.example.umc9th.global.annotation.PageValidate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreMissionController {

    private final MissionService missionService;

    @GetMapping("/{storeId}/missions")
    public MissionResDTO.MissionListDTO getStoreMissions(
            @PathVariable Long storeId,
            @RequestParam @PageValidate Integer page
    ) {
        return missionService.getMissionsByStore(storeId, page);
    }
}
