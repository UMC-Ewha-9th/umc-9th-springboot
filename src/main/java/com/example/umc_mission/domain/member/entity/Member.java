package com.example.umc_mission.domain.member.entity;

import com.example.umc_mission.domain.member.entity.mapping.MemberFood;
import com.example.umc_mission.domain.member.entity.mapping.MemberTerm;
import com.example.umc_mission.domain.member.enums.Address;
import com.example.umc_mission.domain.member.enums.Gender;
import com.example.umc_mission.domain.member.enums.SocialType;
import com.example.umc_mission.domain.mission.entity.mapping.MemberMission;
import com.example.umc_mission.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity //엔티티 선언
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED) //생성자 (프록시 객체 생성 허용)
@AllArgsConstructor(access = AccessLevel.PRIVATE) //생성자 (new 객체 생성 미허용)
@Getter
@Table(name = "member")
public class Member extends BaseEntity {

    @Id //기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY) //자동 생성 전략
    private Long id;

    @Column(name = "name", length = 3, nullable = false) //글자수 제한, NOT NULL 설정
    private String name;

    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    @Builder.Default //초기값 설정
    private Gender gender = Gender.NONE;

    @Column(name = "birth", nullable = false)
    private LocalDate birth;

    @Column(name = "address", nullable = false)
    @Enumerated(EnumType.STRING)
    private Address address;

    @Column(name = "detail_address", nullable = false)
    private String detailAddress;

    @Column(name = "social_uid", nullable = false)
    private String socialUid;

    @Column(name = "social_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @Column(name = "point", nullable = false)
    private Integer point;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    //연관 관계
    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE) //양방향 매핑
    private List<MemberFood> memberFoodList = new ArrayList<>();

    @OneToMany(mappedBy = "member") //양방향 매핑
    private List<MemberTerm> memberTermList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE) //양방향 매핑
    private List<MemberMission> memberMissionList = new ArrayList<>();

}
