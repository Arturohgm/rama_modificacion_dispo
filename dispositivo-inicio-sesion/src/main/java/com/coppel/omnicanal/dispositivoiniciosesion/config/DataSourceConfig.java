package com.coppel.omnicanal.dispositivoiniciosesion.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {

  @Value("${datasource.correosecommercev2.jdbcurl}")
  private String conMaeCorreos;
  
  /**
   * Cuando se utilice solo spring con el archivo properties se debe dejar solo de esta linea para
   * abajo lo demas debe ser eliminado. La condicional
   *
   * @return regresa la configuración de la conexión
   */
  @Bean
  public HikariConfig solicitudConfig() {
    var hikari = new HikariConfig();
    hikari.setJdbcUrl(conMaeCorreos);
    hikari.setConnectionInitSql("SET application_name = 'dispositivo-inicio-sesion'");
    return hikari;
  }

  /**
   * Bean que genera el DataSource obteniendo los datos desde el application.properties.
   *
   * @return Regresa un datasource configurado por Hikari
   */
  @Bean
  public DataSource dataSource() {
    return new HikariDataSource(solicitudConfig());
  }
}