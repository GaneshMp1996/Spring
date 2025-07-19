# Use OpenJDK base image with Maven
FROM maven:3.9.6-eclipse-temurin-17

# Set working directory
WORKDIR /app

# Copy everything into the image
COPY . .

# Build the project
RUN mvn clean install -DskipTests

# Expose the port (optional for documentation)
EXPOSE 8080

# Start the app
CMD ["java", "-jar", "target/Newspaper-App-0.0.1-SNAPSHOT.jar"]
