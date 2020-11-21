FROM openjdk:11-jdk-slim
ARG JAR_FILE=target/is2-dataset.jar
COPY ${JAR_FILE} is2-dataset.jar
ENTRYPOINT ["java","-jar","/is2-dataset.jar"]
