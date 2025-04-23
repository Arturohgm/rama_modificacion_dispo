package com.coppel.omnicanal.dispositivoiniciosesion.mappers;

import com.coppel.omnicanal.dispositivoiniciosesion.dto.DispositivoDto;
import com.coppel.omnicanal.dispositivoiniciosesion.entities.Dispositivo;

/**
 * Clase que sirve pra mapear un objeto a otro objeto.
 */
public class DeviceMapper {

  private DeviceMapper() {}
  
  public static DispositivoDto mapDispositivo(Dispositivo device) {
    DispositivoDto dispositivo = new DispositivoDto();
    dispositivo.setNombreDispositivo(device.getNombreDispositivo());
    dispositivo.setCiudad(device.getCiudad());
    dispositivo.setLogonId(device.getLogonId());
    dispositivo.setIdDispositivo(device.getIdDispositivo());
    return dispositivo;
  }

  public static Dispositivo mapDispositivoDto(DispositivoDto dispositivoDto) {
    Dispositivo dispositivo = new Dispositivo();
    dispositivo.setNombreDispositivo(dispositivoDto.getNombreDispositivo());
    dispositivo.setCiudad(dispositivoDto.getCiudad());
    dispositivo.setLogonId(dispositivoDto.getLogonId());
    dispositivo.setIdDispositivo(dispositivoDto.getIdDispositivo());
    return dispositivo;
  }
}