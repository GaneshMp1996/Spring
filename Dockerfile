# Use official OpenJDK 17 base image
FROM openjdk:17-jdk-slim

# Set working directory inside container
WORKDIR /app

# Copy everything into container
COPY . .

# Build the project using Maven Wrapper
RUN ./mvnw clean install -DskipTests

# Expose port (not required by Render, but good practice)
EXPOSE 8080

# Run the built JAR file (adjust name if needed)
CMD ["java", "-jar", "target/Newspaper-App-0.0.1-SNAPSHOT.jar"]
