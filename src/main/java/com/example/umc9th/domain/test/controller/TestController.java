package com.example.umc9th.domain.test.controller;

import com.example.umc9th.domain.test.converter.TestConverter;
import com.example.umc9th.domain.test.dto.res.TestResDTO;
import com.example.umc9th.domain.test.service.query.TestQueryService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/temp")
public class TestController {

    private final TestQueryService testQueryService;

    // 정상 응답 테스트
    @GetMapping("/test")
    public ApiResponse<TestResDTO.Testing> test() {
        return ApiResponse.onSuccess(
                GeneralSuccessCode.OK,
                TestConverter.toTestingDTO("This is Test!")
        );
    }

    // 예외 테스트
    @GetMapping("/exception")
    public ApiResponse<TestResDTO.ExceptionDTO> exception(@RequestParam Long flag) {

        testQueryService.checkFlag(flag); // flag==1이면 예외 발생

        return ApiResponse.onSuccess(
                GeneralSuccessCode.OK,
                TestConverter.toExceptionDTO("This is Test Exception!")
        );
    }
}
