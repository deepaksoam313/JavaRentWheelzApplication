# Use Eclipse Temurin for a stable, maintained Java 21 runtime
FROM eclipse-temurin:21-jdk-jammy

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from target directory into the container
# Ensure your Maven build stage produces this exact filename
COPY target/RentWheelz-0.0.1-SNAPSHOT.jar /app/RentWheelz.jar

# Expose the port the app will run on
EXPOSE 8080

# Command to run the app
ENTRYPOINT ["java", "-jar", "RentWheelz.jar"]
