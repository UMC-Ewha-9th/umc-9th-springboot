package com.example.umc9th.domain.review.repository;

import com.example.umc9th.domain.review.entity.Review;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewRepositoryCustom { // ✨ 추가됨

    Optional<Review> findByUserMission_Id(Long userMissionId);
    boolean existsByUserMission_Id(Long userMissionId);

    //  가게 상세 - 리뷰 목록 (JPQL + 페이징)
    @Query("""
        SELECT r
        FROM Review r
        JOIN FETCH r.user u
        WHERE r.store.id = :storeId
        ORDER BY r.id DESC
    """)
    List<Review> findByStoreIdOrderByIdDesc(@Param("storeId") Long storeId, Pageable pageable);
}
