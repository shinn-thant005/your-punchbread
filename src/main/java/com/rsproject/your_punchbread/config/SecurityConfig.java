package com.rsproject.your_punchbread.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain  securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        /* -- Public Endpoints --- */
                        .requestMatchers("/login", "/error").permitAll()

                        /* -- Su Su Module -- */
                        .requestMatchers(
                                "/api/v1/add-mood",
                                "/api/v1/punch",
                                "/api/v1/kiss",
                                "/api/v1/response/current",
                                "/api/v1/get-random-message"
                        ).hasAnyRole("USER", "ADMIN")

                        /* -- Shared Endpoints -- */
                        .requestMatchers(
                                "/api/v1/status",
                                "/api/v1/get-total-kiss-week",
                                "/api/v1/get-total-punch-week",
                                "/api/v1/stats-30-days"
                        ).hasAnyRole("USER", "ADMIN")

                        /* -- Admin Module -- */
                        .requestMatchers("/api/v1/get-all-moods/**").hasRole("ADMIN")
                        .requestMatchers("/api/v1/get-moods-type/**").hasRole("ADMIN")
                        .requestMatchers("/api/v1/get-moods-date/**").hasRole("ADMIN")
                        .requestMatchers("/api/v1/get-total-punch").hasRole("ADMIN")
                        .requestMatchers("/api/v1/response/reset-all-stats").hasRole("ADMIN")
                        .requestMatchers("/api/v1/response/delete").hasRole("ADMIN")
                        .requestMatchers("/api/v1/response/update").hasRole("ADMIN")

                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults()); // Good for initial testing with Postman
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
