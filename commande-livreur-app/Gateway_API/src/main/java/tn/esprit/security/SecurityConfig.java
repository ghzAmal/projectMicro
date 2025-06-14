package tn.esprit.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/commandes/**").authenticated()  // nécessite un token
                        .anyRequest().denyAll() // bloque toute autre requête
                )
                .oauth2ResourceServer(oauth2 -> oauth2.jwt()) // Active le serveur ressource JWT
                .csrf().disable(); // désactive CSRF pour les APIs

        return http.build();
    }
}



