package com.osm.oilproductionservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static com.osm.oilproductionservice.config.CorsConfig.corsFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .cors(httpSecurityCorsConfigurer -> corsFilter())  // This will use the CorsConfigurationSource bean
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/**").permitAll() // Permit all for this path
                        .anyRequest().authenticated()
                );

        return http.build();
    }


}
