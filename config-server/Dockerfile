FROM openjdk:17
ARG JAR_FILE=target/cloud-config-server-0.0.1.jar
COPY ${JAR_FILE} config-server.jar
ENTRYPOINT ["java","-jar","/config-server.jar"]
EXPOSE 9296