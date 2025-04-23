package com.coppel.omnicanal.dispositivoiniciosesion.execeptions;

import com.coppel.omnicanal.dispositivoiniciosesion.dto.ApiResponseDto;
import com.coppel.omnicanal.dispositivoiniciosesion.util.AppMessages;
import com.coppel.omnicanal.dispositivoiniciosesion.util.Meta;
import java.time.LocalDateTime;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Clase para manejo de excepciones no controladas.
 */
@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

  /**
   * Cualquier excepción que no se atendida será tratada en este método.
   * @param ex Recibe la excepción como parámetro.
   * @return ResponseEntity exception
   */
  @ExceptionHandler(value = {ResponseStatusException.class})
  public ResponseEntity<Object> handleResponseStatusException(ResponseStatusException ex) {
    var meta = new Meta();
    meta.setDevMessage(null);
    meta.setStatus(AppMessages.CLIENT_ERROR);
    meta.setStatusCode(ex.getStatusCode().value());
    meta.setMessage(ex.getReason());
    meta.setTimestamp(LocalDateTime.now().toString());
    var httpHeaders = new HttpHeaders();
    httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
    var apiResponse = new ApiResponseDto(null);
    return new ResponseEntity<>(apiResponse, httpHeaders, ex.getStatusCode());
  }

  /**
   * Cualquier excepción que no sea atendida será tratada en este método.
   * 
   * @param runtimeException Excepción que será atendida.
   * @param webRequest WebRequest para ser enviado al cliente.
   * @return ResponseEntity exception
   */
  @ExceptionHandler(value = {Exception.class})
  protected ResponseEntity<Object> handleException(RuntimeException runtimeException,
      WebRequest webRequest) {
    var meta = new Meta();
    meta.setStatus(AppMessages.ERROR);
    meta.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
    meta.setDevMessage(
        runtimeException.getMessage() == null ? runtimeException.getClass().toString()
            : runtimeException.getMessage());
    meta.setTimestamp(LocalDateTime.now().toString());
    meta.setTransactionID(null);
    var apiResponse = new ApiResponseDto(null);
    var httpHeaders = new HttpHeaders();
    httpHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
    return handleExceptionInternal(runtimeException, apiResponse, httpHeaders,
        HttpStatus.INTERNAL_SERVER_ERROR, webRequest);
  }
}