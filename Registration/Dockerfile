FROM openjdk:11
WORKDIR user/lib
EXPOSE 8082

ADD ./target/Registration-0.0.1-SNAPSHOT.jar  /user/lib/Registration-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","Registration-0.0.1-SNAPSHOT.jar"]