package com.example.bean.server.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * The {@code MVCConfiguration} class is a Spring configuration class that customizes the behavior
 * of Spring MVC components.
 *
 * @version 1.0
 * @since 2023-08-04
 */
@Configuration
public class MVCConfiguration implements WebMvcConfigurer {

  /**
   * Configures Cross-Origin Resource Sharing (CORS) for the application. Allows cross-origin
   * requests from any source for API paths.
   *
   * @param registry The CorsRegistry instance to configure CORS settings.
   */
  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/api/**").allowedOrigins("*");
  }
}