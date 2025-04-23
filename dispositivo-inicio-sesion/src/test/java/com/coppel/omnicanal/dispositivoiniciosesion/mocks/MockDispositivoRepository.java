package com.coppel.omnicanal.dispositivoiniciosesion.mocks;

import com.coppel.omnicanal.dispositivoiniciosesion.entities.Dispositivo;
import com.coppel.omnicanal.dispositivoiniciosesion.repositories.DispositivoRepository;
import org.mockito.Mockito;

public final class MockDispositivoRepository {
  private static DispositivoRepository repository;
  
  private MockDispositivoRepository() {
  }
  
  public static void initialize(DispositivoRepository repo) {  
    repository = repo;
  }
  
  public static void rules() {
    Dispositivo device = new Dispositivo();
    device.setCiudad("test");
    device.setIdDispositivo("test");
    device.setNombreDispositivo("test");
    device.setLogonId("test");
    
    Mockito.when(repository.countByLogonId(Mockito.anyString())).thenReturn(1);
    Mockito.when(
        repository.existsByIdDispositivoAndLogonId(
            Mockito.anyString(), 
            Mockito.anyString()))
    .thenReturn(true);
    Mockito.when(
        repository.save(Mockito.any(Dispositivo.class)))
    .thenAnswer(i -> i.getArguments()[0]);
  }
  
  public static void countLogonCero() {
    Mockito.when(repository.countByLogonId(Mockito.anyString())).thenReturn(0);
  }
}
