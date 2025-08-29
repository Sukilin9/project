package com.fsse2502.fsse2502projectbackend.security;

import jakarta.servlet.DispatcherType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.security.web.DefaultSecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
    private String issuer;

    @Bean
    public DefaultSecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .dispatcherTypeMatchers(DispatcherType.ERROR).permitAll()
                        .requestMatchers("/products").permitAll()
                        .anyRequest().authenticated())
                .csrf(csrf -> csrf.disable());
        http
                .oauth2ResourceServer(
                        oAuth2ResourceServer -> oAuth2ResourceServer.jwt(
                        jwt -> jwt.decoder(
                                JwtDecoders.fromIssuerLocation(issuer))
                        )
                );
        return http.build();
    }
}
