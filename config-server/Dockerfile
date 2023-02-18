FROM openjdk:11

#RUN gradle -DskipTests bootJar

COPY build/libs/*.jar config-server.jar

EXPOSE 8762

ENTRYPOINT ["java", "-jar", "/config-server.jar"]