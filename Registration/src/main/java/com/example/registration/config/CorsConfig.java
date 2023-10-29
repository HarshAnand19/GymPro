//package com.example.registration.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//@EnableWebMvc
//public class CorsConfig implements WebMvcConfigurer {
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/auth/**") // You may specify specific paths to allow
//            .allowedOrigins("*") // You can restrict this to specific origins
//            .allowedMethods("GET", "POST", "PUT", "DELETE")
//            .allowCredentials(false); // Adjust as needed
//    }
//}
