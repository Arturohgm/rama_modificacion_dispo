package com.coppel.omnicanal.dispositivoiniciosesion.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.coppel.omnicanal.dispositivoiniciosesion.dto.ApiResponseDto;
import com.coppel.omnicanal.dispositivoiniciosesion.util.Meta;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ApiResponseDtoTest {
  @Test
  @Order(1)
  void setRespuestaTest() {
    boolean resultado = true;
    
    try {
      Meta respuesta = new Meta();
      respuesta.setData("test");
      respuesta.setStatus("Exitoso");
      
      ApiResponseDto response = new ApiResponseDto();
      response.setRespuesta(respuesta);
    } catch(Exception e) {
      resultado = false;
    }
    
    assertTrue(resultado);
  }
  
  @Test
  @Order(2)
  void constructorTest() {
    boolean resultado = true;
    
    try {
      Meta respuesta = new Meta();
      respuesta.setData("test");
      respuesta.setStatus("Exitoso");
      
      @SuppressWarnings("unused")
      ApiResponseDto response = new ApiResponseDto(respuesta);
    } catch(Exception e) {
      resultado = false;
    }
    
    assertTrue(resultado);
  }
}
