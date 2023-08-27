FROM openjdk:17
ARG JAR_FILE=target/LoginService-0.0.1.jar
COPY ${JAR_FILE} login-service.jar
ENTRYPOINT ["java","-jar","/login-service.jar"]
EXPOSE 8086