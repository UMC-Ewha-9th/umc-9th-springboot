package com.example.umc9th.domain.repository;

import com.example.umc9th.domain.entity.FoodPreference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FoodPreferenceRepository extends JpaRepository<FoodPreference, Long> {

    @Modifying(clearAutomatically = true)
    @Query("DELETE FROM FoodPreference fp WHERE fp.member.id = :memberId")
    void deleteByMemberId(@Param("memberId") Long memberId);
}
