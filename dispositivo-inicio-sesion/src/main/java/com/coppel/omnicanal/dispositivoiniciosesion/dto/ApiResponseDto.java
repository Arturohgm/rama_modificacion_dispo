package com.coppel.omnicanal.dispositivoiniciosesion.dto;

import com.coppel.omnicanal.dispositivoiniciosesion.util.Meta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase que representa el response del servicio.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ApiResponseDto {
  
  /**
   * Objeto response del servicio.
   */
  private Meta respuesta;
}