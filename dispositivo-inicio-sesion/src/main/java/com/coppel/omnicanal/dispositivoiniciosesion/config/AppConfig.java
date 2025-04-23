package com.coppel.omnicanal.dispositivoiniciosesion.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * AppConfig.
 */
@Component
@ConfigurationProperties(prefix = "configuraciones")
@NoArgsConstructor
@Getter
@Setter
public class AppConfig {

  private String authUri;
  private boolean ignoreSession;
  private String allowedOrigins = "*";
  private String allowedMethods = "GET, POST, PUT, DELETE, OPTIONS";
  private String allowedHeaders =
      "Access-Control-Allow-Origin, Access-Control-Allow-Headers, Access-Control-Allow-Methods, "
          + "Accept, Authorization, Content-Type, Method, Origin, X-Forwarded-For, X-Real-IP";
          private String contentSecurityPolicy = "default-src 'self';"; // Nueva propiedad para CSP
}