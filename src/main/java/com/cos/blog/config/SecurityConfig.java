package com.cos.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    BCryptPasswordEncoder encode() {
        return new BCryptPasswordEncoder();
    }
//    @Bean
//    SecurityFilterChain configure(HttpSecurity http) throws Exception {
//        http
//            .authorizeHttpRequests(auth -> auth
//                    .requestMatchers("/auth/**").permitAll()
//                    .anyRequest().authenticated());
//        return http.build();
//    }
}