package com.example.umc_mission.domain.mission.entity;

import com.example.umc_mission.domain.mission.entity.mapping.MemberMission;
import com.example.umc_mission.domain.store.entity.Store;
import com.example.umc_mission.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name = "mission")
public class Mission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "deadline", nullable = false)
    private LocalDate deadline;

    @Column(name = "conditional", nullable = false)
    private String conditional;

    @Column(name = "point", nullable = false)
    private Integer point;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    //연관 관계
    @OneToMany(mappedBy = "mission") //양방향 매핑
    private List<MemberMission> memberMissionList = new ArrayList<>();
}
