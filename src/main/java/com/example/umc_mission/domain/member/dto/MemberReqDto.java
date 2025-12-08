package com.example.umc_mission.domain.member.dto;

import com.example.umc_mission.domain.member.enums.Address;
import com.example.umc_mission.domain.member.enums.Gender;
import com.example.umc_mission.global.annotation.ExistFoods;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public class MemberReqDto {

    public record MemberJoinDto(
            @NotBlank
            String name,
            @Email
            String email,
            @NotBlank
            String password,
            @NotNull
            Gender gender,
            @NotNull
            LocalDate birth,
            @NotNull
            Address address,
            @NotNull
            String detailAddress,
            @ExistFoods
            List<Long> preferCategory
    ){}

    // 로그인
    public record LoginDto(
            @NotBlank
            String email,
            @NotBlank
            String password
    ){}

}
