package com.example.umc9th.domain.entity;

import com.example.umc9th.domain.enums.FoodName;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "food_type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FoodType extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private FoodName name;
}
