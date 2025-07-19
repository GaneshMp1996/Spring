# Use Maven with Java 17
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

# Copy entire source
COPY . .

# Build project
RUN mvn clean install -DskipTests

# Use JDK for running the app (smaller image)
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copy jar from previous build
COPY --from=build /app/Newspaper-Application/target/Newspaper-App-0.0.1-SNAPSHOT.jar app.jar

# Expose port (not mandatory for Render)
EXPOSE 8080

# Run jar
CMD ["java", "-jar", "app.jar"]
