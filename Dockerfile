# Etapa 1: Build
FROM maven:3.8.1-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2: Execução
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/orderservice-0.0.1-SNAPSHOT.jar orderservice.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "orderservice.jar"]