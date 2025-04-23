package com.coppel.omnicanal.dispositivoiniciosesion.controllers;

import com.coppel.omnicanal.dispositivoiniciosesion.dto.ApiResponseDto;
import com.coppel.omnicanal.dispositivoiniciosesion.dto.DispositivoDto;
import com.coppel.omnicanal.dispositivoiniciosesion.services.DispositivoService;
import com.coppel.omnicanal.dispositivoiniciosesion.util.Meta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;



/**
 * DispositivoController.
 */
@RestController
@Log4j2
@RequestMapping("/api/v1/dispositivo")
public class DispositivoController {

  private static final String MENSAJE_BAD_REQUEST = "La información que envió no tiene el formato correcto.";
  @Autowired
  private DispositivoService deviceService;
  private static final String STATUSERROR = "ERROR";

  private boolean validarPeticion(DispositivoDto dispositivoDto) {
    return (!dispositivoDto.getNombreDispositivo().isEmpty()
        && !dispositivoDto.getIdDispositivo().isEmpty() && !dispositivoDto.getLogonId().isEmpty());
  }

  /**
   * Método que guarda los datos del dispositivo que se esta iniciando sesion.
   *
   * @param nuevoDispositivo Datos del dispositivo
   * @return Response del servicio
   */
  @Operation(description = "Guarda los datos del dispositivo del que se esta iniciando sesion que se esta enviando.")
  @ApiResponse(responseCode = "200", description = "The request is completed successfully.")
  @ApiResponse(responseCode = "400", description = "Bad request. Some of the inputs provided to the request are not valid.")
  @ApiResponse(responseCode = "401", description = "Not authenticated. The user session is not valid.")
  @ApiResponse(responseCode = "403", description = "The user is not authorized to perform the specified request.")
  @ApiResponse(responseCode = "404", description = "The specified resource couldn't be found.")
  @ApiResponse(responseCode = "500", description = "Internal server error. Additional details will be contained on the server logs.")
  @PostMapping(value = "guardar")
  public ApiResponseDto saveDevice(
      @Parameter(name = "device", description = "Datos de la factura a guardar.",
          required = true) @RequestBody DispositivoDto nuevoDispositivo) {
    if (!this.validarPeticion(nuevoDispositivo)) {
      log.error("Device inválido",
          new Exception("El objeto recibido no corresponde a un dispositivo válido."));
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, MENSAJE_BAD_REQUEST);
    }
    if (!deviceService.validateDevice(nuevoDispositivo.getIdDispositivo(),
        nuevoDispositivo.getLogonId()))
      return new ApiResponseDto(new Meta("SUCCESS", deviceService.saveDevice(nuevoDispositivo)));
    else
      return new ApiResponseDto(new Meta(STATUSERROR, -10, "Dispositivo ya registrado", null));
  }

  @Operation(description = "Valida si el usuario ya cuenta con un registro anterior.")
    @ApiResponse(responseCode = "200", description = "The request is completed successfully.")
    @ApiResponse(responseCode = "400", description = "Bad request. Some of the inputs provided to the request are not valid.")
    @ApiResponse(responseCode = "401", description = "Not authenticated. The user session is not valid.")
    @ApiResponse(responseCode = "403", description = "The user is not authorized to perform the specified request.")
    @ApiResponse(responseCode = "404", description = "The specified resource couldn't be found.")
    @ApiResponse(responseCode = "500", description = "Internal server error. Additional details will be contained on the server logs.")
  @PostMapping(value = "primer-dispositivo")
  public ApiResponseDto primerDispositivoPorId(
      @Parameter(name = "logon_id", description = "usuario a buscar.", example = "juan@gmail.com",
          required = true) @RequestBody DispositivoDto device) {
    if (deviceService.firstDevice(device.getLogonId()))
      return new ApiResponseDto(new Meta(STATUSERROR, -11, "Primer registro", null));
    else if (deviceService.validateDevice(device.getIdDispositivo(), device.getLogonId()))
      return new ApiResponseDto(new Meta(STATUSERROR, -10, "Dispositivo ya registrado", null));
    else
      return new ApiResponseDto(
          new Meta("SUCCESS", 0, "El dispositivo ya cuenta con uno o mas registros", null));
  }
}
