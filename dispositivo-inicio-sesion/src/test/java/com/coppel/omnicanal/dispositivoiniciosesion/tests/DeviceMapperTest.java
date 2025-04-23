package com.coppel.omnicanal.dispositivoiniciosesion.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.coppel.omnicanal.dispositivoiniciosesion.dto.DispositivoDto;
import com.coppel.omnicanal.dispositivoiniciosesion.entities.Dispositivo;
import com.coppel.omnicanal.dispositivoiniciosesion.mappers.DeviceMapper;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {
    DeviceMapper.class,
    Dispositivo.class,
    DispositivoDto.class
})
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DeviceMapperTest{
 @Test
 @Order(1)
 void mapDispositivoTest() {
   boolean resultado = true;
   
   try {
     Dispositivo device = new Dispositivo();
     device.setCiudad("Samsung S10");
     device.setIdDispositivo("36874156");
     device.setLogonId("juan@gmail.com");
     device.setNombreDispositivo("6672541256");
     DispositivoDto dispositivoDto = DeviceMapper.mapDispositivo(device);
     
     if(!dispositivoDto.getCiudad().equals(device.getCiudad()) ||
         !dispositivoDto.getIdDispositivo().equals(device.getIdDispositivo()) ||
         !dispositivoDto.getLogonId().equals(device.getLogonId()) ||
         !dispositivoDto.getNombreDispositivo().equals(device.getNombreDispositivo())) {
       resultado = false;       
     }
   } catch(Exception exp) {
     resultado = false;
   }
   
   assertTrue(resultado);
 }
 
 @Test
 @Order(2)
 void mapDispositivoDtoTest() {
   boolean resultado = true;
   
   try {
     DispositivoDto device = new DispositivoDto();
     device.setCiudad("Samsung S10");
     device.setIdDispositivo("36874156");
     device.setLogonId("juan@gmail.com");
     device.setNombreDispositivo("6672541256");
     Dispositivo dispositivo = DeviceMapper.mapDispositivoDto(device);
     
     if(!dispositivo.getCiudad().equals(device.getCiudad()) ||
         !dispositivo.getIdDispositivo().equals(device.getIdDispositivo()) ||
         !dispositivo.getLogonId().equals(device.getLogonId()) ||
         !dispositivo.getNombreDispositivo().equals(device.getNombreDispositivo())) {
       resultado = false;       
     }
   } catch(Exception exp) {
     resultado = false;
   }
   
   assertTrue(resultado);
 }
}