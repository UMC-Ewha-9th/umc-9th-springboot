package com.example.umc_mission.domain.mission.service.command;

import com.example.umc_mission.domain.member.entity.Member;
import com.example.umc_mission.domain.member.exception.MemberException;
import com.example.umc_mission.domain.member.exception.code.MemberErrorCode;
import com.example.umc_mission.domain.member.repository.MemberRepository;
import com.example.umc_mission.domain.mission.converter.MemberMissionConverter;
import com.example.umc_mission.domain.mission.dto.MemberMissionReqDto;
import com.example.umc_mission.domain.mission.dto.MemberMissionResDto;
import com.example.umc_mission.domain.mission.entity.Mission;
import com.example.umc_mission.domain.mission.entity.mapping.MemberMission;
import com.example.umc_mission.domain.mission.exception.MissionException;
import com.example.umc_mission.domain.mission.exception.code.MissionErrorCode;
import com.example.umc_mission.domain.mission.repository.MemberMissionRepository;
import com.example.umc_mission.domain.mission.repository.MissionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService {

    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;

    // 미션 도전
    @Override
    @Transactional
    public MemberMissionResDto.addMemberMissionDto addMemberMission(
            MemberMissionReqDto.addMemberMissionDto dto
    ){
        // 사용자 존재 여부 검증
        Member member = memberRepository.findById(dto.memberId())
                .orElseThrow(() -> new MemberException(MemberErrorCode.NOT_FOUND));

        // 미션 존재 여부 검증
        Mission mission = missionRepository.findById(dto.missionId())
                .orElseThrow(() -> new MissionException(MissionErrorCode.NOT_FOUND));

        // 유저 미션 생성
        MemberMission memberMission = MemberMissionConverter.toMemberMission(dto, member, mission);
        // DB 적용
        memberMissionRepository.save(memberMission);

        return MemberMissionConverter.toAddMemberMissionDto(memberMission);

    }

}
