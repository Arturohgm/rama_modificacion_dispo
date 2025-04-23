package com.coppel.omnicanal.dispositivoiniciosesion.tests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.coppel.omnicanal.dispositivoiniciosesion.config.AppConfig;
import com.coppel.omnicanal.dispositivoiniciosesion.config.WebMvcConfigure;
import com.coppel.omnicanal.dispositivoiniciosesion.controllers.DispositivoController;
import com.coppel.omnicanal.dispositivoiniciosesion.dto.DispositivoDto;
import com.coppel.omnicanal.dispositivoiniciosesion.entities.Dispositivo;
import com.coppel.omnicanal.dispositivoiniciosesion.mappers.DeviceMapper;
import com.coppel.omnicanal.dispositivoiniciosesion.mocks.MockDispositivoService;
import com.coppel.omnicanal.dispositivoiniciosesion.services.DispositivoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.autoconfigure.RefreshAutoConfiguration;

@SpringBootTest(classes = {
    DeviceMapper.class,
    DispositivoDto.class,
    DispositivoService.class,
    Dispositivo.class,
    DispositivoController.class,
    WebMvcConfigure.class,
    AppConfig.class
})
@ImportAutoConfiguration(RefreshAutoConfiguration.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DispositivoControllerTest {
  @MockBean
  private DispositivoService service;
  
  @Autowired
  private DispositivoController controller;
  
  @BeforeEach
  void setUpEach() {
   MockDispositivoService.initialize(service);
  }
  
  private static final String ID_DISPOSITIVO = "Samsung S10";
  private static final String NOMBRE_DISPOSITIVO = "36874156";
  private static final String LOGON_ID = "juan@gmail.com";
  private static final String CIUDAD = "6672541256";
  
  private DispositivoDto setDispositivoDto(String ciudad, String idDispositivo, String logonId, String nombreDispositivo) {
    DispositivoDto device = new DispositivoDto();
    device.setCiudad(ciudad);
    device.setIdDispositivo(idDispositivo);
    device.setLogonId(logonId);
    device.setNombreDispositivo(nombreDispositivo);
    return device;
  }
  
  @Test
  @Order(1)
  void saveDeviceTest() {
    boolean resultado = true;
    
    try {
      DispositivoDto device = new DispositivoDto(ID_DISPOSITIVO, NOMBRE_DISPOSITIVO, LOGON_ID, CIUDAD);
      
      MockDispositivoService.save();
      MockDispositivoService.validateDevice(false);
      controller.saveDevice(device);      
    } catch(Exception e) {
      resultado = false;
    }
    assertTrue(resultado);
  }
  
  @Test
  @Order(2)
  void saveDeviceDispositivoRegistradoTest() {
    boolean resultado = true;
    
    try {
      DispositivoDto device = setDispositivoDto(CIUDAD, ID_DISPOSITIVO, LOGON_ID, NOMBRE_DISPOSITIVO);
      
      MockDispositivoService.save();
      MockDispositivoService.validateDevice(true);
      controller.saveDevice(device);      
    } catch(Exception e) {
      resultado = false;
    }
    assertTrue(resultado);
  }
  
  @Test
  @Order(3)
  void saveDeviceDispositivoInvalidoTest() {
    boolean resultado = true;
    
    try {
      DispositivoDto device = setDispositivoDto(null, null, null, null);
      
      MockDispositivoService.save();
      MockDispositivoService.validateDevice(true);
      controller.saveDevice(device);    
      
      device = setDispositivoDto(null, ID_DISPOSITIVO, LOGON_ID, NOMBRE_DISPOSITIVO);
      controller.saveDevice(device);
      
      device = setDispositivoDto(null, ID_DISPOSITIVO, null, null);
      controller.saveDevice(device); 
      
      device = setDispositivoDto(null, null, LOGON_ID, null);
      controller.saveDevice(device); 
      
      device = setDispositivoDto(null, null, null, NOMBRE_DISPOSITIVO);
      controller.saveDevice(device); 
    } catch(Exception e) {
      resultado = false;
    }
    assertFalse(resultado);
  }
  
  @Test
  @Order(4)
  void primerDispositivoPorIdTest() {
    boolean resultado = true;
    
    try {
      DispositivoDto device = new DispositivoDto();
      device.setCiudad(ID_DISPOSITIVO);
      device.setIdDispositivo(NOMBRE_DISPOSITIVO);
      device.setLogonId(LOGON_ID);
      device.setNombreDispositivo(null);
      
      MockDispositivoService.firstDevice(true);
      controller.primerDispositivoPorId(device);      
    } catch(Exception e) {
      resultado = false;
    }
    assertTrue(resultado);
  }
  
  @Test
  @Order(5)
  void primerDispositivoPorIdValidateFalseTest() {
    boolean resultado = true;
    
    try {
      DispositivoDto device = setDispositivoDto(CIUDAD, ID_DISPOSITIVO, LOGON_ID, null);
      
      MockDispositivoService.firstDevice(false);
      MockDispositivoService.validateDevice(false);
      controller.primerDispositivoPorId(device);      
    } catch(Exception e) {
      resultado = false;
    }
    assertTrue(resultado);
  }
  
  @Test
  @Order(5)
  void primerDispositivoPorIdValidateTrueTest() {
    boolean resultado = true;
    
    try {
      DispositivoDto device = setDispositivoDto(CIUDAD, ID_DISPOSITIVO, LOGON_ID, null);
      
      MockDispositivoService.firstDevice(false);
      MockDispositivoService.validateDevice(true);
      controller.primerDispositivoPorId(device);      
    } catch(Exception e) {
      resultado = false;
    }
    assertTrue(resultado);
  }
  
}
