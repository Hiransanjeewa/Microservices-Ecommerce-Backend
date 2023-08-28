FROM openjdk:17
ARG JAR_FILE=target/RegisterService-0.0.1.jar
COPY ${JAR_FILE} register-service.jar
ENTRYPOINT ["java","-jar","/register-service.jar"]
EXPOSE 8085