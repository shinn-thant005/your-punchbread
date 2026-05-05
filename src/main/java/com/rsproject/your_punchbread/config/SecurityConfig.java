package com.rsproject.your_punchbread.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(Customizer.withDefaults())
                .csrf(csrf -> csrf.disable())
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

                        /* -- Shared & Dashboard Endpoints -- */
                        .requestMatchers(
                                "/api/v1/dashboard",
                                "/api/v1/status",
                                "/api/v1/get-total-kiss-week",
                                "/api/v1/get-total-punch-week",
                                "/api/v1/stats-30-days"
                        ).hasAnyRole("USER", "ADMIN")

                        /* -- Admin Specific (Including the new Dashboard DTO) -- */
                        .requestMatchers("/api/v1/dashboard/admin").hasRole("ADMIN") // NEW FIX
                        .requestMatchers("/api/v1/get-all-moods/**").hasRole("ADMIN")
                        .requestMatchers("/api/v1/get-moods-type/**").hasRole("ADMIN")
                        .requestMatchers("/api/v1/get-moods-date/**").hasRole("ADMIN")
                        .requestMatchers("/api/v1/get-total-punch").hasRole("ADMIN")
                        .requestMatchers("/api/v1/response/**").hasRole("ADMIN") // Simplified

                        .anyRequest().authenticated()
                )
                .httpBasic(basic -> basic.authenticationEntryPoint((request, response, authException) -> {
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
                }));
        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        // CRITICAL: Replace the placeholder below with your ACTUAL Vercel URL
        // Example: "https://your-punchbread.vercel.app"
        configuration.setAllowedOrigins(Arrays.asList(
                "http://localhost:5173",
                "http://localhost:3000",
                "https://your-punchbread-frontend.vercel.app"
        ));

        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type", "X-Requested-With"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

