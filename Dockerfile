FROM openjdk:17-jdk-slim
WORKDIR /gymSys
COPY target/gymSys.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "gymSys.jar"]