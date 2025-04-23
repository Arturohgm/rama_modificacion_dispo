package com.coppel.omnicanal.dispositivoiniciosesion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * Clase principal para ejecutar la aplicacion SpringBoot.
 * 
 * @author Omnicanal
 *
 */

@SpringBootApplication
@EntityScan("com.coppel.omnicanal.dispositivoiniciosesion.entities")
@ComponentScan("com.coppel.omnicanal.dispositivoiniciosesion")
public class MainApplication {

  public static void main(String[] args) {
    SpringApplication.run(MainApplication.class, args);
  }

}