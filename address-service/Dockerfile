FROM openjdk:11

#RUN gradle -DskipTests bootJar

COPY build/libs/*.jar address-service.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "/address-service.jar"]