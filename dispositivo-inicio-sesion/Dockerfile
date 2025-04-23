# Usamos la imagen de Maven 3.6.0 para compilar y generar el servicio.
FROM maven:3.9.6-amazoncorretto-21 AS build
# Asignamos la zona horaria
ENV TZ America/Mexico_City
# Copiamos el codigo dentro del container.
COPY src /home/app/src
COPY pom.xml /home/app
# Creamos el paquete de liberacion
RUN mvn -q -f /home/app/pom.xml clean package -DskipTests
#-Dhttps.proxyHost=10.49.115.20 -Dhttps.proxyPort=3128

FROM amazoncorretto:21-alpine3.19
# Exponemos el puerto 8080 y 9901
EXPOSE 8080 9901
ENV JAVA_OPTS=""
# Asignamos la zona horaria.
ENV TZ America/Mexico_City
# Copiamos de build el archivo jar a donde va a quedar en produccion.
COPY --from=build /home/app/target/*.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]