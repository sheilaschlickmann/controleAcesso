FROM maven:3.8.2-jdk-11 AS MAVEN_BUILD
EXPOSE 8081

COPY ./ ./
RUN mvn clean package
FROM openjdk
COPY --from=MAVEN_BUILD /target/fila-acesso-0.0.1-SNAPSHOT.jar /fila-acesso.jar
CMD ["java", "-jar", "/fila-acesso.jar"]