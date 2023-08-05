FROM openjdk:17-alpine
COPY target/demo2-0.0.1-SNAPSHOT.jar demo.jar
ENTRYPOINT ["java", "-jar", "/demo.jar"]