package com.coppel.omnicanal.dispositivoiniciosesion.mocks;

import com.coppel.omnicanal.dispositivoiniciosesion.dto.DispositivoDto;
import com.coppel.omnicanal.dispositivoiniciosesion.services.DispositivoService;
import org.mockito.Mockito;

public final class MockDispositivoService {
  private static DispositivoService service;
  
  private MockDispositivoService() {
  }
  
  public static void initialize(DispositivoService dispositivoService) {
    service = dispositivoService;
  }
  
  public static void save() {
    Mockito.when(service.saveDevice(Mockito.any(DispositivoDto.class)))
    .thenAnswer(i -> i.getArguments()[0]);
    Mockito.when(service.validateDevice(Mockito.anyString(), Mockito.anyString()))
    .thenReturn(true);
    Mockito.when(service.firstDevice(Mockito.anyString()))
    .thenAnswer(i -> i.getArguments()[0]);
  }
  
  public static void validateDevice(boolean respuesta) {
    Mockito.when(service.validateDevice(Mockito.anyString(), Mockito.anyString()))
    .thenReturn(respuesta);
  }
  
  public static void firstDevice(boolean respuesta) {
    Mockito.when(service.firstDevice(Mockito.anyString()))
    .thenReturn(respuesta);
  }
}
