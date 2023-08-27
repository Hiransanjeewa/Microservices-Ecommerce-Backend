FROM openjdk:17
ARG JAR_FILE=target/ServiceRegistry-0.0.1.jar
COPY ${JAR_FILE} service-registry.jar
ENTRYPOINT ["java","-jar","/service-registry.jar"]
EXPOSE 8761