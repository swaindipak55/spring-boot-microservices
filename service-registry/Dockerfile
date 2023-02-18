FROM openjdk:11

#RUN gradle -DskipTests bootJar

COPY build/libs/*.jar service-registry.jar

EXPOSE 8761

ENTRYPOINT ["java", "-jar", "/service-registry.jar"]