package com.example.securitydb.service;

import com.example.securitydb.entity.Users;
import com.example.securitydb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

// DB 검색해서 검색 데이터가 있는지 확인 하는 것
public class CustromerDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override // loadUserByUsername 이 부분을 db에 들고가서 찾는
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = userRepository.findByUsername(username); // 사용시에는 타입X
        // userRepository 가서 findByUsername 메소드 보면 리턴타입이 Users
        if(users == null){
            throw new UsernameNotFoundException("User Not Found ");
        }
        return null;
        // user 가 있으면 데이터를 보내고(customerDetails에서 받음..),
        // 없으면 throw ~ 부분
    }
}
