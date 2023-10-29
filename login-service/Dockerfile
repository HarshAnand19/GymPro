FROM openjdk:11
WORKDIR user/lib
EXPOSE 8080

ADD ./target/AuthenticatedBackend-0.0.1-SNAPSHOT.jar  /user/lib/AuthenticatedBackend-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","AuthenticatedBackend-0.0.1-SNAPSHOT.jar"]