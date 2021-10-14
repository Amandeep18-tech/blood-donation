package com.dalhousie.bloodDonation.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig {
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/books-rest")
                        .allowedOrigins("http://localhost:8080")
                        .allowedOrigins("https://blood-donation-system-stage.herokuapp.com/")
                        .allowedOrigins("https://blood-donation-system-prod.herokuapp.com/");
            }
        };
    }
}
