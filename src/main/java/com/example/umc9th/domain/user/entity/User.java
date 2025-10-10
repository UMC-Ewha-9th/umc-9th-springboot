package com.example.umc9th.domain.user.entity;

import com.example.umc9th.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter @Builder
@AllArgsConstructor @NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity @Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(name="uq_users_email", columnNames = "email"),
                @UniqueConstraint(name="uq_users_nickname", columnNames = "nickname")
        },
        indexes = @Index(name="idx_users_email", columnList = "email"))
public class User extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, length=255) private String email;
    @Column(nullable=false, length=255) private String passwordHash;
    @Column(nullable=false, length=40)  private String nickname;
    @Column(length=20)                  private String phone;
}
