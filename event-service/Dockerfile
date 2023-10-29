FROM openjdk:11
WORKDIR user/lib
EXPOSE 8016

ADD ./target/event-service-0.0.1-SNAPSHOT.jar  /user/lib/event-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","event-service-0.0.1-SNAPSHOT.jar"]