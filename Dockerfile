FROM openjdk:21-jdk-slim
WORKDIR /app
COPY target/empweb-1.0.jar /app/empweb-1.0.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/empweb-1.0.jar"]
