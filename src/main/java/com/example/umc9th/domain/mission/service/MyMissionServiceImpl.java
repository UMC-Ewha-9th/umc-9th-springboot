package com.example.umc9th.domain.mission.service;

import com.example.umc9th.domain.mission.converter.MyMissionConverter;
import com.example.umc9th.domain.mission.dto.MyMissionResDTO;
import com.example.umc9th.domain.mission.entity.MissionChallenge;
import com.example.umc9th.domain.mission.entity.enums.ChallengeStatus;
import com.example.umc9th.domain.mission.repository.MissionChallengeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;

@Service
@RequiredArgsConstructor
public class MyMissionServiceImpl implements MyMissionService {

    private final MissionChallengeRepository missionChallengeRepository;

    @Override
    public MyMissionResDTO.ChallengeListDTO getMyInProgress(Long userId, Integer page) {

        PageRequest pr = PageRequest.of(page, 10);

        Page<MissionChallenge> result =
                missionChallengeRepository.findAllByUser_IdAndStatus(
                        userId,
                        ChallengeStatus.IN_PROGRESS,
                        pr
                );

        return MyMissionConverter.toListDTO(result);
    }
}
