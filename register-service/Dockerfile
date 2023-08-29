FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} register-service.jar
ENTRYPOINT ["java","-jar","/register-service.jar"]
EXPOSE 9002