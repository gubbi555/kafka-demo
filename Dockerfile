# Stage 1: Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the local filesystem to the container
COPY target/*.jar app.jar

# Specify the command to run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]

