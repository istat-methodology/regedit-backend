FROM openjdk:11-jdk-slim
ARG JAR_FILE=target/regedit.jar
COPY ${JAR_FILE} regedit.jar
ENTRYPOINT ["java","-jar","/regedit.jar"]
