FROM openjdk:11

#RUN gradle -DskipTests bootJar

COPY build/libs/*.jar employee-service.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/employee-service.jar"]