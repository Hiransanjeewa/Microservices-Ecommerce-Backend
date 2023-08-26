FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} login-service.jar
ENTRYPOINT ["java","-jar","/login-service.jar"]
EXPOSE 8086