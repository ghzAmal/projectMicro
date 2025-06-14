package com.example.serviceLivreur.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        System.out.println("⚠️ SecurityFilterChain ACTIVE");


        http
                .authorizeHttpRequests(authz -> authz
                        .anyRequest().authenticated() // Exige token valide
                )
                .oauth2ResourceServer(oauth2 -> oauth2.jwt())  // JWT token validation
                .csrf().disable();

        return http.build();
    }
}
