package com.example.umc9th.domain.review.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ReviewReqDTO {

    public record CreateDTO(
            @NotNull Integer rating,
            @NotBlank String content
    ) {}
}
