package com.example.serviceLivreur.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.jwt.NimbusReactiveJwtDecoder;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public ReactiveJwtDecoder reactiveJwtDecoder() {
        String issuerUri = "http://host.docker.internal:8080/realms/projectmicro";
        // On construit un ReactiveJwtDecoder via l'issuer URI
        return NimbusReactiveJwtDecoder.withJwkSetUri(
                issuerUri + "/protocol/openid-connect/certs").build();
    }
}
