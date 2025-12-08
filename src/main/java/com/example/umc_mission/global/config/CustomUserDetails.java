package com.example.umc_mission.global.config;

import com.example.umc_mission.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
public class CustomUserDetails implements UserDetails {

    public final Member member;

    // 권한
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() -> member.getRole().toString());
    }

    // 비밀번호
    @Override
    public String getPassword() {
        return member.getPassword();
    }

    // 아이디(이메일)
    @Override
    public String getUsername() {
        return member.getEmail();
    }

}
