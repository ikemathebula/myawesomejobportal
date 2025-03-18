package com.example.myawesomejobportal;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Minimal SecurityConfig allowing free access to /api/register and /api/authenticate.
 * Everything else requires authentication (basic).
 */
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests()
                .antMatchers("/api/register", "/api/authenticate").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic(); // or formLogin(), etc.

        return http.build();
    }
}
