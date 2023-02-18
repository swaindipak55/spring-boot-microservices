FROM openjdk:11

#RUN gradle -DskipTests bootJar

COPY build/libs/*.jar department-service.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "/department-service.jar"]