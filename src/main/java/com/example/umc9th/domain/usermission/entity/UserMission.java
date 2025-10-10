package com.example.umc9th.domain.usermission.entity;

import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.user.entity.User;
import com.example.umc9th.global.entity.BaseEntity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;

@Getter @Builder
@AllArgsConstructor @NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity @Table(name="user_missions",
        uniqueConstraints = @UniqueConstraint(name="uq_um_user_mission", columnNames={"user_id","mission_id"}),
        indexes = {
                @Index(name="idx_um_user_status", columnList="user_id,status"),
                @Index(name="idx_um_mission", columnList="mission_id")
        })
public class UserMission extends BaseEntity {

    public enum Status { CLAIMED, COMPLETED, CANCELLED }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="user_id", nullable=false, foreignKey=@ForeignKey(name="fk_um_user"))
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="mission_id", nullable=false, foreignKey=@ForeignKey(name="fk_um_mission"))
    private Mission mission;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false, length=10)
    private Status status;

    @Column(nullable=false)
    private LocalDateTime claimedAt;

    private LocalDateTime completedAt;

    @PrePersist void prePersist() {
        if (status == null) status = Status.CLAIMED;
        if (claimedAt == null) claimedAt = LocalDateTime.now();
    }
}
