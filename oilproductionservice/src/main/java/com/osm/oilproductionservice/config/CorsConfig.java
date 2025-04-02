package com.osm.oilproductionservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public static CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();

        // Allow specific origin (your Angular app URL)
        config.addAllowedOrigin("http://localhost:4200");

        // Allow all HTTP methods (PUT, POST, GET, DELETE, OPTIONS)
        config.addAllowedMethod("*");

        // Allow headers (content-type, authorization, etc.)
        config.addAllowedHeader("*");

        // Allow credentials (cookies, etc.)
        config.setAllowCredentials(true);

        // Apply CORS configuration to all URL patterns
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
}
