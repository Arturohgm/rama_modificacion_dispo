package com.coppel.omnicanal.dispositivoiniciosesion.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.coppel.omnicanal.dispositivoiniciosesion.entities.DispositivoId;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DispositivoIdTest {
  
  @Test
  @Order(1)
  void dispositivoIdTest() {
    boolean resultado = true;
    
    try {
      DispositivoId device = new DispositivoId("123", "123");
      DispositivoId deviceCompare = new DispositivoId();
      DispositivoId deviceCompare2 = device;
      
      device.hashCode();
      device.equals(deviceCompare);
      device.equals(deviceCompare2);
      
      deviceCompare = null;
      device.equals(deviceCompare);
      
      deviceCompare2 = new DispositivoId("321", "321");
      device.equals(deviceCompare2);
    } catch(Exception e) {
      resultado = false;
    }
    
    assertTrue(resultado);
  }

}
