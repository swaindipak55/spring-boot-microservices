FROM openjdk:11

#RUN gradle -DskipTests bootJar

COPY build/libs/*.jar api-gateway.jar

EXPOSE 9090

ENTRYPOINT ["java", "-jar", "/api-gateway.jar"]