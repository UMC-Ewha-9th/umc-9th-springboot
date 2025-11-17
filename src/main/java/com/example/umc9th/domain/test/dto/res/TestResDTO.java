package com.example.umc9th.domain.test.dto.res;

import lombok.Builder;
import lombok.Getter;

public class TestResDTO {

    @Getter
    @Builder
    public static class Testing {
        private String testString;
    }

    @Getter
    @Builder
    public static class ExceptionDTO {
        private String testString;
    }
}
