package com.example.securitydb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired // DB에 user를 조회한 부분이 UserDetail(service) 쪽
    UserDetailsService userDetailsService;
    // DB에 자료를 가져와서 사용하기 위해서는 @Bean 등록해서 사용
    // DB 자료를 가져오기 위해서(공유해서 사용) Authentication Provider 사용
    // new BcryptPasswordEncoder() : DB에 저장된 비밀번호를 복호화 처리

    @Bean
    AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        //service : username, password, auth
        provider.setUserDetailsService(userDetailsService);

        //encode
        provider.setPasswordEncoder(new BCryptPasswordEncoder());


        return provider;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/home").permitAll()
                        .requestMatchers("/users").hasAuthority("USERS ")
                        .requestMatchers("/admin").hasAuthority("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .permitAll()
                )
                .logout((logout) -> logout.permitAll());

        return http.build();
    }

}
