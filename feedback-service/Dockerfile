FROM openjdk:11
WORKDIR user/lib
EXPOSE 8007

ADD ./target/feedback-service-0.0.1-SNAPSHOT.jar  /user/lib/feedback-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","feedback-service-0.0.1-SNAPSHOT.jar"]