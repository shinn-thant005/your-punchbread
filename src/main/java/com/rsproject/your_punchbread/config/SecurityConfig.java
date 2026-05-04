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
                // 1. Enable CORS using the bean below
                .cors(Customizer.withDefaults())
                // 2. Disable CSRF for REST APIs
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

                        /* -- Shared Endpoints -- */
                        .requestMatchers(
                                "/api/v1/dashboard",
                                "/api/v1/status", // can delete this since it is replaced by "/api/v1/dashboard"
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
                .httpBasic(basic -> basic.authenticationEntryPoint((request, response, authException) -> {
                    // This tells Spring to just send a plain 401 error WITHOUT the popup header
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
                }));
        return http.build();
    }

    // 3. Define the CORS configuration
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        // ADD YOUR VERCEL URL TO THIS LIST
        configuration.setAllowedOrigins(Arrays.asList(
                "http://localhost:5173",
                "http://localhost:3000",
                "https://your-punchbread-frontend.vercel.app" // <--- Replace with your real Vercel URL later
        ));

        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));
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

