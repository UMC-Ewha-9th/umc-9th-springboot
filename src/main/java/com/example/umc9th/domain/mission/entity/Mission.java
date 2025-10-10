package com.example.umc9th.domain.mission.entity;

import com.example.umc9th.domain.store.entity.Store;
import com.example.umc9th.global.entity.BaseEntity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;

@Getter @Builder
@AllArgsConstructor @NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity @Table(name="missions",
        uniqueConstraints = @UniqueConstraint(name="uq_missions_store_title", columnNames={"store_id","title"}),
        indexes = @Index(name="idx_missions_store", columnList="store_id"))
public class Mission extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="store_id", nullable=false, foreignKey=@ForeignKey(name="fk_mission_store"))
    private Store store;

    @Column(nullable=false, length=120) private String title;
    @Lob private String description;

    @Column(nullable=false) private Integer minSpend;
    @Column(nullable=false) private Integer rewardPoints;

    private LocalDateTime startsAt;
    private LocalDateTime endsAt;

    @Column(nullable=false) private Boolean isActive;

    @PrePersist void prePersist() {
        if (minSpend == null) minSpend = 0;
        if (rewardPoints == null) rewardPoints = 100;
        if (isActive == null) isActive = true;
    }
}
