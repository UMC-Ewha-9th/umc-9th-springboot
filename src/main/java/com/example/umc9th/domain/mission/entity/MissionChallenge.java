package com.example.umc9th.domain.mission.entity;

import com.example.umc9th.domain.mission.entity.enums.ChallengeStatus;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class MissionChallenge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Mission mission;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Enumerated(EnumType.STRING)
    private ChallengeStatus status;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;
}
