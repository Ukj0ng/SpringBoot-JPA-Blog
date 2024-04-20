package com.cos.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // Bean등록(IoC관리)
public class SecurityConfig {

    @Bean
    BCryptPasswordEncoder encode() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
            .csrf((csrf) -> csrf
                .disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/auth/**", "/js/**", "/css/**", "/image/**").permitAll()
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/auth/login")
                .permitAll()
            );

        return http.build();
    }
}
