package com.example.umc9th.domain.entity;

import com.example.umc9th.domain.enums.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "member")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String birthday;
    private String placeConsent;
    private String marketingConsent;
    private String email;
    private String phoneVerify;
    private String phoneNumber;
    private String isOwner;
    private String alarmSetting;
    private String point;
    private String city;
    private String district;
    private String neighborhood;

    @OneToMany(mappedBy = "member", orphanRemoval = true) // batch delete를 위해 cascade = CascadeType.ALL 제거
    private Set<FoodPreference> foodPreferences = new HashSet<>();
}
