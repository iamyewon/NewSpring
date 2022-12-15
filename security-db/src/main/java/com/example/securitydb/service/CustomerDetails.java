package com.example.securitydb.service;

import com.example.securitydb.entity.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CustomerDetails implements UserDetails {

    private Users users; //캡슐화
    // private 가 붙는 애들은 this로 사용
    // 아래 생성자 오버로딩에서 받아온 users를 다시 멤버 변수에 담았다가 사용함.

    public CustomerDetails() {
    }

    public CustomerDetails(Users users) { // 생성자 오버로딩
        this.users = users;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // return타입이 Collection
        return Collections.singleton(new SimpleGrantedAuthority(users.getRole()));
    }

    @Override
    public String getPassword() {
        return users.getPassword();
    }

    @Override
    public String getUsername() {
        return users.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
