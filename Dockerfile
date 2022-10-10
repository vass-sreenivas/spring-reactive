FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD target/spring-reactive-0.0.1-SNAPSHOT.jar spring-reactive-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["sh","-c","java -jar /spring-reactive-0.0.1-SNAPSHOT.jar"]