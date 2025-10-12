package com.example.umc_mission.domain.member.entity.mapping;

import com.example.umc_mission.domain.member.entity.Member;
import com.example.umc_mission.domain.member.entity.Term;
import com.example.umc_mission.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity //엔티티 선언
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED) //생성자 (프록시 객체 생성 허용)
@AllArgsConstructor(access = AccessLevel.PRIVATE) //생성자 (new 객체 생성 미허용)
@Getter
@Table(name = "member_term")
public class MemberTerm extends BaseEntity {

    @Id //기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY) //자동 생성 전략
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) //1:N 중 N 정의 (지연 로딩: 프록시 객체 >> 실제 객체)
    @JoinColumn(name = "member_id", nullable = false) //FK 주인
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY) //1:N 중 N 정의 (지연 로딩: 프록시 객체 >> 실제 객체)
    @JoinColumn(name = "term_id", nullable = false) //FK 주인
    private Term term;

}
