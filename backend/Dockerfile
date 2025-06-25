FROM openjdk:17-jdk-slim

# Instalar netcat para la espera
RUN apt-get update && apt-get install -y netcat

# Copiar el archivo JAR al contenedor
COPY target/demo-0.0.1-SNAPSHOT.jar /usr/app/demo.jar

# Definir el directorio de trabajo
WORKDIR /usr/app

# Exponer el puerto 8080 para el acceso a la app
EXPOSE 8080

# Esperar a que MySQL esté disponible y luego ejecutar la aplicación
CMD sh -c "until nc -z mysql 3306; do sleep 1; done; java -jar demo.jar"
