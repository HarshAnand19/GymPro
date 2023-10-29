FROM openjdk:11
WORKDIR user/lib
EXPOSE 8761

ADD ./target/Spring-Cloud-0.0.1-SNAPSHOT.jar  /user/lib/Spring-Cloud-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","Spring-Cloud-0.0.1-SNAPSHOT.jar"]
