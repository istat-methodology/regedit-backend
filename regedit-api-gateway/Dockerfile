FROM openjdk:11-jdk-slim
ARG JAR_FILE=target/regedit-api-gateway.jar
COPY ${JAR_FILE} regedit-api-gateway.jar
ENTRYPOINT ["java","-jar","/regedit-api-gateway.jar"]
