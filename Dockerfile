# Use an official Java runtime as the base image
FROM openjdk:21-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from target directory into the container
COPY target/RentWheelz-0.0.1-SNAPSHOT.jar /app/RentWheelz.jar

# Expose the port the app will run on
EXPOSE 8080

# Command to run the app
CMD ["java", "-jar", "RentWheelz.jar"]
