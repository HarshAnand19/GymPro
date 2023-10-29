FROM openjdk:11
WORKDIR user/lib
EXPOSE 8003

ADD ./target/chatting-service-0.0.1-SNAPSHOT.jar  /user/lib/chatting-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","chatting-service-0.0.1-SNAPSHOT.jar"]