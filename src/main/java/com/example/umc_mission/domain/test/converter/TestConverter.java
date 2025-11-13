package com.example.umc_mission.domain.test.converter;

import com.example.umc_mission.domain.test.dto.res.TestResDto;

public class TestConverter {
    
    // 객체 >> DTO
    public static TestResDto.Testing toTestingDTO(
            String testing
    ) {
        return TestResDto.Testing.builder() // TestResDto 객체에 testing 필드 생성
                .testString(testing) // testing 필드에 값 저장
                .build();
    }
    
    // 객체 >> DTO
    public static TestResDto.Exception toExceptionDto(
            String testing
    ) {
        return TestResDto.Exception.builder()
                .testString(testing)
                .build();
    }
    
}
