FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} restaurant-service.jar
ENTRYPOINT ["java","-jar","/restaurant-service.jar"]