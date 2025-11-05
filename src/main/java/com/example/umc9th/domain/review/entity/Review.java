package com.example.umc9th.domain.review.entity;

import com.example.umc9th.domain.usermission.entity.UserMission;
import com.example.umc9th.domain.user.entity.User;
import com.example.umc9th.domain.store.entity.Store;
import com.example.umc9th.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(
        name = "reviews",
        uniqueConstraints = @UniqueConstraint(name = "uq_reviews_um", columnNames = "user_mission_id")
)
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //  기존 필드
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_mission_id", nullable = false, foreignKey = @ForeignKey(name = "fk_review_um"))
    private UserMission userMission;

    @Column(nullable = false)
    private Integer rating; // 1~5

    @Lob
    private String content;

    @PrePersist
    void validate() {
        if (rating == null || rating < 1 || rating > 5)
            throw new IllegalArgumentException("rating must be 1~5");
    }

    //  JPQL 인식용 연관관계 추가 (쿼리 동작용)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", insertable = false, updatable = false)
    private Store store;
}
