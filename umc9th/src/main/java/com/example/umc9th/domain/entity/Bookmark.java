package com.example.umc9th.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        name = "bookmark"
        ,uniqueConstraints = {
                @UniqueConstraint(name = "uk_member_restaurant", columnNames = {"member_id", "restaurant_id"})
        }
)
public class Bookmark extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    // 낙관적 락을 위한 버전 필드 추가
    /*@Version
    private Long version;
    */
}
