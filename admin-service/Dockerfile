FROM openjdk:11
WORKDIR user/lib
EXPOSE 8001

ADD ./target/admin-service-0.0.1-SNAPSHOT.jar  /user/lib/admin-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","admin-service-0.0.1-SNAPSHOT.jar"]