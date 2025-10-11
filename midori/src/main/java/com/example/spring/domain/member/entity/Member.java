package com.example.spring.domain.member.entity;
import com.example.spring.domain.mission.entity.Mission;
import com.example.spring.domain.review.entity.Review;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)

public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private String password;

    @Column(name = "user_name", length = 10)
    private String userName;

    @Column(length = 500)
    private String email;

    @Column(name = "phone_number")
    private Integer phoneNumber;

    @Column(name = "is_verified")
    private Boolean isVerified;

    @Column(length = 50)
    private String preference;

    private LocalDate createAt;
    private LocalDate deletedAt;

    private Integer points;

    // 연관 관계
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Mission> missions = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();
}
