FROM openjdk:11
WORKDIR user/lib
EXPOSE 8019

ADD ./target/notification-service-0.0.1-SNAPSHOT.jar  /user/lib/notification-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","notification-service-0.0.1-SNAPSHOT.jar"]