package com.board.bulldogs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "/css/**", "/js/**", "/images/**").permitAll()  // Allow access to static resources
                        .anyRequest().authenticated()  // Secure other endpoints if needed
                )
                .formLogin((form) -> form.disable())   // Disable form-based authentication
                .httpBasic((httpBasic) -> httpBasic.disable()); // Disable basic HTTP authentication

        return http.build();
    }
}
