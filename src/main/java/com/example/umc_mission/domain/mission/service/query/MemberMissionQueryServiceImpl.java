package com.example.umc_mission.domain.mission.service.query;

import com.example.umc_mission.domain.member.entity.Member;
import com.example.umc_mission.domain.member.exception.MemberException;
import com.example.umc_mission.domain.member.exception.code.MemberErrorCode;
import com.example.umc_mission.domain.member.repository.MemberRepository;
import com.example.umc_mission.domain.mission.converter.MemberMissionConverter;
import com.example.umc_mission.domain.mission.dto.MemberMissionResDto;
import com.example.umc_mission.domain.mission.entity.mapping.MemberMission;
import com.example.umc_mission.domain.mission.enums.Status;
import com.example.umc_mission.domain.mission.repository.MemberMissionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberMissionQueryServiceImpl implements MemberMissionQueryService {

    private final MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;

    // 내가 도전 중인 미션 목록 조회
    @Transactional
    @Override
    public MemberMissionResDto.myMissionPreviewListDto getMyMissions(
            Long memberId,
            Status status,
            Integer page
    ){
        // 사용자 확인
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberException(MemberErrorCode.NOT_FOUND));

        // 페이징 설정
        int pageIndex = Math.max(page - 1, 0);
        PageRequest pageRequest = PageRequest.of(pageIndex, 10);
        Page<MemberMission> result;

        // Status별 내 미션 목록 조회
        // 진행 중 미션
        if (status == Status.onProgress) {
            result = memberMissionRepository.findAllByMemberAndStatus(member, Status.onProgress, pageRequest);
        } // 진행 완료 미션
        else {
            result = memberMissionRepository.findAllByMemberAndStatus(member, Status.completed, pageRequest);
        }

        // 반환
        return MemberMissionConverter.toMyMissionPreviewListDto(result);
    }

}
