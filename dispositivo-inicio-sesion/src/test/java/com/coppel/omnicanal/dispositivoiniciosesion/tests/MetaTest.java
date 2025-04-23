package com.coppel.omnicanal.dispositivoiniciosesion.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.coppel.omnicanal.dispositivoiniciosesion.util.Meta;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {Meta.class})

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MetaTest {
  private static final String TRANSACTION = "123";
  private static final String STATUS = "Exitoso";
  private static final int STATUSCODE = 200;
  private static final String MEESAGE = "Exito";

  @Test
  @Order(1)
  void metaConstructorUno() {
    boolean resultado = true;

    try {
      @SuppressWarnings("unused")
      Meta meta = new Meta(TRANSACTION, STATUS, STATUSCODE);
    } catch (Exception e) {
      resultado = false;
    }

    assertTrue(resultado);
  }

  @Test
  @Order(2)
  void metaConstructorDos() {
    boolean resultado = true;

    try {
      @SuppressWarnings("unused")
      Meta meta = new Meta(TRANSACTION, STATUS, STATUSCODE, MEESAGE);
    } catch (Exception e) {
      resultado = false;
    }

    assertTrue(resultado);
  }

  @Test
  @Order(3)
  void metaConstructorTres() {
    boolean resultado = true;

    try {
      @SuppressWarnings("unused")
      Meta meta = new Meta("STATUS", null);
    } catch (Exception e) {
      resultado = false;
    }

    assertTrue(resultado);
  }

  @Test
  @Order(1)
  void metaConstructorCuatro() {
    boolean resultado = true;

    try {
      @SuppressWarnings("unused")
      Meta meta = new Meta(TRANSACTION, STATUSCODE, MEESAGE, null);
    } catch (Exception e) {
      resultado = false;
    }

    assertTrue(resultado);
  }
}
