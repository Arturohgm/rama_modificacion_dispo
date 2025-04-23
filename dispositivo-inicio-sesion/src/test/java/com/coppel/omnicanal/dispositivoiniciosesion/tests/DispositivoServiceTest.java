package com.coppel.omnicanal.dispositivoiniciosesion.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.coppel.omnicanal.dispositivoiniciosesion.dto.DispositivoDto;
import com.coppel.omnicanal.dispositivoiniciosesion.entities.Dispositivo;
import com.coppel.omnicanal.dispositivoiniciosesion.mappers.DeviceMapper;
import com.coppel.omnicanal.dispositivoiniciosesion.mocks.MockDispositivoRepository;
import com.coppel.omnicanal.dispositivoiniciosesion.repositories.DispositivoRepository;
import com.coppel.omnicanal.dispositivoiniciosesion.services.DispositivoService;
import com.coppel.omnicanal.dispositivoiniciosesion.services.impl.DispositivoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest(classes = {
    DeviceMapper.class,
    DispositivoRepository.class,
    DispositivoDto.class,
    DispositivoService.class,
    DispositivoServiceImpl.class,
    Dispositivo.class
})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DispositivoServiceTest {  
  
  @MockBean
  private DispositivoRepository repository;
  
  @Autowired
  private DispositivoServiceImpl service;
  
  @BeforeEach
  void setUpEach() {
    MockDispositivoRepository.initialize(repository);
    MockDispositivoRepository.rules();
  }
  
  @Test
  @Order(1)
  void firstDeviceTest() {
    boolean resultado = true;
    try {
      service.firstDevice("12345");
      MockDispositivoRepository.countLogonCero();
      service.firstDevice("12345");
    } catch(Exception e) {
      resultado = false;
    }
    assertTrue(resultado);
  }
  
  @Test
  @Order(2)
  void validateDeviceTest() {
    boolean resultado = true;
    
    try {
      service.validateDevice("123", "123");
    } catch(Exception e) {
      resultado = false;
    }
    
    assertTrue(resultado);
  }
  
  @Test
  @Order(3)
  void saveDeviceTest() {
    boolean resultado = true;
    
    try {
      DispositivoDto dto = new DispositivoDto();
      dto.setCiudad("test");
      dto.setIdDispositivo("test");
      dto.setNombreDispositivo("test");
      dto.setLogonId("test");
      
      service.saveDevice(dto);
    } catch(Exception e) {
      resultado = false;
    }
    
    assertTrue(resultado);
  }
}
