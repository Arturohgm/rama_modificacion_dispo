package com.coppel.omnicanal.dispositivoiniciosesion.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Meta.
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Meta {

  @JsonInclude(value = Include.NON_NULL)
  private String transactionID;

  private String status;

  @JsonInclude(value = Include.NON_NULL)
  private int statusCode;

  @JsonInclude(value = Include.NON_NULL)
  private String timestamp;

  @JsonInclude(value = Include.NON_NULL)
  private String devMessage;

  @JsonInclude(value = Include.NON_NULL)
  private String message;


  @JsonInclude(value = JsonInclude.Include.NON_NULL)
  private Object data;

  /**
   * Objeto de informacion general de la peticion.
   * 
   * @param transactionId Identificador de la peticion.
   * @param status Status de la peticion.
   * @param statusCode Codigo de estatus de la peticion.
   */
  public Meta(String transactionId, String status, int statusCode) {
    this.transactionID = transactionId;
    this.status = status;
    this.statusCode = statusCode;
    this.timestamp = LocalDateTime.now().toString();
  }

  /**
   * Objeto de informacion general de la peticion.
   * 
   * @param transactionId Identificador de la peticion.
   * @param status Status de la peticion.
   * @param statusCode Codigo de estatus de la peticion.
   * @param message Mensaje hacia el cliente.
   */
  public Meta(String transactionId, String status, int statusCode, String message) {
    this.transactionID = transactionId;
    this.status = status;
    this.statusCode = statusCode;
    this.message = message;
    this.timestamp = LocalDateTime.now().toString();
  }
  /**
   * Objeto de informacion general de la peticion.
   *
   * @param status Status de la peticion.
   */
  public Meta(String status, Object data){
    this.status = status;
    this.data = data;
  }
  /**
   * Objeto de informacion general de la peticion.
   *
   * @param status Status de la peticion.
   * @param statusCode Codigo de estatus de la peticion.
   * @param message Mensaje hacia el cliente.
   */
  public Meta(String status,int statusCode,String message,Object data){
    this.status = status;
    this.statusCode = statusCode;
    this.message = message;
    this.data = data;
  }
}