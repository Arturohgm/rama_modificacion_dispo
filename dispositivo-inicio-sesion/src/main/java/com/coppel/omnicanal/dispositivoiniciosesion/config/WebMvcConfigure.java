package com.coppel.omnicanal.dispositivoiniciosesion.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class WebMvcConfigure {

  @Autowired
  private AppConfig config;
  
  /**
   * Bean que configura los permisos para consumir el api.
   * 
   * @return Regresa la configuración de los CORS
   */
  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/*").allowedOrigins(config.getAllowedOrigins())
            .allowedMethods(config.getAllowedMethods()).allowedHeaders(config.getAllowedHeaders());
      }
    };
  }
}