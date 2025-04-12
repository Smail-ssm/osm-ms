package com.osm.oilproductionservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        // Map Swagger UI static resources.
//        registry.addResourceHandler("/swagger-ui/**")
//                .addResourceLocations("classpath:/META-INF/resources/webjars/springdoc-openapi-ui/");
//        // Optionally, map additional static resource locations if needed.
//        registry.addResourceHandler("/**")
//                .addResourceLocations("classpath:/static/");
//    }
}
