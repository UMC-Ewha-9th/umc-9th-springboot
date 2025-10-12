package com.example.umc_mission.domain.member.entity;

import com.example.umc_mission.domain.member.entity.mapping.MemberTerm;
import com.example.umc_mission.domain.member.enums.FoodName;
import com.example.umc_mission.domain.member.enums.TermName;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity //엔티티 선언
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED) //생성자 (프록시 객체 생성 허용)
@AllArgsConstructor(access = AccessLevel.PRIVATE) //생성자 (new 객체 생성 미허용)
@Getter
@Table(name = "term")
public class Term {

    @Id //기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY) //자동 생성 전략
    private Long id;

    @Column(name = "name", nullable = false)
    @Enumerated(EnumType.STRING)
    private TermName name;

    //연관 관계
    @OneToMany(mappedBy = "term") //양방향 매핑
    private List<MemberTerm> memberTermList = new ArrayList<>();

}
