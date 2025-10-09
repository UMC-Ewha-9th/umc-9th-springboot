package com.example.umc9th.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "food_preference")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FoodPreference extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id")
    private FoodType foodType;
}
