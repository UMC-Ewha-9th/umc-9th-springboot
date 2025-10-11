package com.example.umc9th.domain.store.entity;

import com.example.umc9th.domain.region.entity.Region;
import com.example.umc9th.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;   // <-- 추가

@Getter @Builder
@AllArgsConstructor @NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity @Table(name="stores",
        uniqueConstraints = @UniqueConstraint(name="uq_stores_region_name", columnNames={"region_id","name"}),
        indexes = @Index(name="idx_stores_region", columnList="region_id"))
public class Store extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="region_id", nullable=false, foreignKey = @ForeignKey(name="fk_store_region"))
    private Region region;

    @Column(nullable=false, length=120) private String name;
    @Column(length=255)                  private String address;

    @Column(precision = 9, scale = 6)   private BigDecimal lat;  // <-- 변경
    @Column(precision = 9, scale = 6)   private BigDecimal lng;  // <-- 변경

    @Column(nullable=false)              private Boolean isActive;

    @PrePersist void prePersist(){ if (isActive == null) isActive = true; }
}
