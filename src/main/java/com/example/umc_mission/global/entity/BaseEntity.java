package com.example.umc_mission.global.entity;

import jakarta.persistence.Column;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

public class BaseEntity {

    @CreatedDate //생성 일자 자동 기록
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate //수정 일자 자동 기록
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

}
