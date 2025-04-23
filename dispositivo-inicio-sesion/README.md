dispositivo-inicio-sesion
======================================

## Descripción

Se crea servicio para la validacion de los dispositivos de los clientes registrados en la tabla y en caso de no existir se creara un nuevo registro

## Pre-requisitos

Tener instalados y configurados los siguientes componentes:

1. Gits
2. Apache Maven
3. Java OpenJDK 17
4. Plugin Lombok para tu IDE [Eclipse](https://projectlombok.org/setup/eclipse), [VsCode](https://projectlombok.org/setup/vscode), [IntelliJ](https://projectlombok.org/setup/intellij)
5. Tener el archivo de configuración en la ruta /sysx/progs/conf/application.properties.

## Instalación

La siguiente linea de comandos, realiza la descarga de las dependencias necesarias para compilar el proyecto, posterior compila el proyecto y por último instala en JAR en el repositorio local de maven.

```bash
mvn clean install
```

## Generación de documentación del servicio

Para generar la docuentación del servicio es necesario ejecutar la siguiente linea:

```bash
mvn clean site
```

Esta linea generará los siguientes reportes:

* **Jacoco.-** Reporte de revisión del Coverage de la aplicación.
* **CheckStyle.-** Reporte de revisión de codigo estático.
* **Surefire Report.-** Reporte de la ejecución de casos de prueba.
* **JavaDocs.-** Sitio con la documentación de las clases.

Los archivos generados estarán en la siguiente ruta: {projectPath}/target/site/index.html

## Generación del JAR

Se debe de ejecutar el siguiente comando para generar el jar

```bash
mvn clean package -DskipTests
```

El archivo jar será generado en la siguiente ruta: {projectPath}/target/dispositivo-inicio-sesion-1.0.0.jar

## URL del componente

http://server:port/dispositivo-inicio-sesion/

## Documentación Swagger

En ambiente local y de desarrollo se puede consultar el contrato de interfaz del servicio en:

http://localhost:8080/dispositivo-inicio-sesion/swagger-ui/index.html#/

*En ambientes productivos por seguridad no se activará la documentación.*

## Puntos finales de API(endpoints)


| Método HTTP | Punto final(endpoints)         | Descripción                                 |
|-------------|-------------------------------|---------------------------------------------|
| `POST`      | `/api/v1/dispositivo/guardar` |Guarda los datos del dispositivo     
                                                que esta iniciando sesion 


|`POST`|`/api/v1/dispositivo/primer-dispositivo`|Valida si el usuario ya cuenta con un    
                                                |registro anterior


## Dependencias
```env
bd correosecommercev2
```

## Variables de entorno

```env
datasource.correosecommercev2.jdbcurl= valor pendiente
