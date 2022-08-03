FROM maven:3.8.2-jdk-11 AS MAVEN_BUILD
EXPOSE 8080

COPY ./ ./
RUN mvn clean package
FROM openjdk
COPY --from=MAVEN_BUILD /target/usuario-0.0.1-SNAPSHOT.jar /usuario.jar
CMD ["java", "-jar", "/usuario.jar"]