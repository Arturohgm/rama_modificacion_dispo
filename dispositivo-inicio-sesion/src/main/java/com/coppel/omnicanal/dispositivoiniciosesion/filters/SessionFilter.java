package com.coppel.omnicanal.dispositivoiniciosesion.filters;

import com.coppel.omnicanal.dispositivoiniciosesion.config.AppConfig;
import com.coppel.omnicanal.dispositivoiniciosesion.dto.ApiResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * SessionFilter Clase que filtra el request para validar el token de sesion.
 */
@Component
@Order(value = 1)
@Log4j2
public class SessionFilter implements Filter {

  @Autowired
  private AppConfig config;

  @Override
  public void doFilter(final ServletRequest request, final ServletResponse response,
      final FilterChain chain) throws IOException, ServletException {

    final HttpServletRequest req = (HttpServletRequest) request;
    final HttpServletResponse res = (HttpServletResponse) response;

    // Agregar el encabezado HSTS sanitiza Missing HSTS Header
    //AHGM
    res.setHeader("Strict-Transport-Security", "max-age=31536000; includeSubDomains; preload");

    if (config.isIgnoreSession()) {
      chain.doFilter(request, response);
      return;
    }

    final var apiResponseDto = new ApiResponseDto();
    final var objectMapper = new ObjectMapper();
    if (req.getHeader(HttpHeaders.AUTHORIZATION) == null) {
      res.reset();

      log.error("No se encontro el HTTPHEADER Authorization");

      res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      res.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, config.getAllowedOrigins());
      res.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, config.getAllowedMethods());
      res.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, config.getAllowedHeaders());
      res.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
      res.setCharacterEncoding("UTF-8");
      res.getWriter().write(objectMapper.writeValueAsString(apiResponseDto));
    } else {
      final var client = new RestTemplate();
      final var authHeaders = new HttpHeaders();
      authHeaders.add(HttpHeaders.AUTHORIZATION, req.getHeader(HttpHeaders.AUTHORIZATION));
      final HttpEntity<String> httpEntity = new HttpEntity<>("body", authHeaders);
      try {
        final ResponseEntity<String> authResponse =
            client.exchange(config.getAuthUri(), HttpMethod.POST, httpEntity, String.class);
        if (authResponse.getStatusCode() == HttpStatus.OK) {
          chain.doFilter(request, response);
        }
      } catch (RestClientException ex) {
        res.reset();

        log.error("Ocurrio un error al validar el token");

        res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        res.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, config.getAllowedOrigins());
        res.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, config.getAllowedMethods());
        res.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, config.getAllowedHeaders());
        res.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        res.setCharacterEncoding("UTF-8");
        res.getWriter().write(objectMapper.writeValueAsString(apiResponseDto));
      }
    }
  }
}