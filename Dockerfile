# ================================
#  Etapa 1: Construir el proyecto
# ================================
FROM maven:3.9.4-eclipse-temurin-17 AS build

# Carpeta de trabajo dentro del contenedor
WORKDIR /app

# Copiamos pom.xml y el código fuente
COPY pom.xml .
COPY src ./src

# Compilamos y empaquetamos el proyecto (sin tests)
RUN mvn clean package -DskipTests

# ================================
#  Etapa 2: Ejecutar la aplicación
# ================================
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copiamos el JAR generado en la etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Render expone el puerto mediante la variable PORT,
# y tu app usa server.port=${PORT:8080}, así que está perfecto.
EXPOSE 8080

# Comando de arranque
ENTRYPOINT ["java", "-jar", "app.jar"]
