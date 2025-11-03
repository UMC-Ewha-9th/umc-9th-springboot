package com.example.umc9th.domain.mission.entity;

import com.example.umc9th.domain.store.entity.Store;
import com.example.umc9th.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "missions")
public class Mission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @Column(name = "starts_at")
    private java.time.LocalDateTime startsAt;

    @Column(name = "ends_at")
    private java.time.LocalDateTime endsAt;

    @Column(name = "reward_points")
    private Integer rewardPoints;

    @Column(name = "min_spend")
    private Integer minSpend;

    //  JPQL 인식용 연관관계 추가
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", insertable = false, updatable = false)
    private Store store;
}
