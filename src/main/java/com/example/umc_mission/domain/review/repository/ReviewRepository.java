package com.example.umc_mission.domain.review.repository;

import com.example.umc_mission.domain.member.entity.Member;
import com.example.umc_mission.domain.review.entity.Review;
import com.example.umc_mission.domain.store.entity.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewQueryDsl {

    Page<Review> findAllByStore(Store store, PageRequest pageRequest);

    Page<Review> findAllByMember(Member member, PageRequest pageRequest);

    Page<Review> findAllByMemberAndStarGreaterThanEqualAndStarLessThan(Member member, float star, float v, PageRequest pageRequest);

    Page<Review> findAllByMemberAndStoreNameContaining(Member member, String query, PageRequest pageRequest);

    Page<Review> findAllByMemberAndStoreNameAndStarGreaterThanEqualAndStarLessThan(Member member, String storeQ, float star, float v, PageRequest pageRequest);
}
