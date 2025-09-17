
# 1st Stage: Build the application
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
# Copy pom.xml and download dependencies first
COPY pom.xml .
RUN mvn dependency:go-offline
# Copy source code and build
COPY src ./src
RUN mvn clean package -DskipTests
# 2nd Stage: Run the application
FROM openjdk:17-jdk-slim
WORKDIR /app
# Copy jar from build stage
COPY --from=build /app/target/*.jar app.jar
# Expose port 8082
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
