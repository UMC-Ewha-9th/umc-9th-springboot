package com.example.umc_mission.domain.member.service.command;

import com.example.umc_mission.domain.member.converter.MemberConverter;
import com.example.umc_mission.domain.member.dto.MemberReqDto;
import com.example.umc_mission.domain.member.dto.MemberResDto;
import com.example.umc_mission.domain.member.entity.Member;
import com.example.umc_mission.domain.member.entity.mapping.MemberFood;
import com.example.umc_mission.domain.member.exception.FoodException;
import com.example.umc_mission.domain.member.exception.code.FoodErrorCode;
import com.example.umc_mission.domain.member.repository.FoodRepository;
import com.example.umc_mission.domain.member.repository.MemberFoodRepository;
import com.example.umc_mission.domain.member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService {

    private final MemberRepository memberRepository;
    private final MemberFoodRepository memberFoodRepository;
    private final FoodRepository foodRepository;

    // 회원가입
    @Transactional
    @Override
    public MemberResDto.MemberJoinDto signUp(
            MemberReqDto.MemberJoinDto dto
    ) {
        // 사용자 생성
        Member member = MemberConverter.toMember(dto);
        // DB 적용
        memberRepository.save(member);

        // 선호 음식 존재 여부 확인
        if (!dto.preferCategory().isEmpty()) {
            List<MemberFood> memberFood = dto.preferCategory().stream()
                    .map(id -> MemberFood.builder()
                            .member(member)
                            .food(foodRepository.findById(id)
                                    .orElseThrow(() -> new FoodException(FoodErrorCode.NOT_FOUND)))
                            .build()
                    )
                    .toList();
            // 모든 선호 음식 추가: DB 적용
            memberFoodRepository.saveAll(memberFood);
        }
        // 응답 DTO 생성
        return MemberConverter.toJoinDto(member);
    }
}
