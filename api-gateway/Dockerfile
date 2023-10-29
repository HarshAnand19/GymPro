FROM openjdk:11
WORKDIR user/lib
EXPOSE 8006

ADD ./target/api-gateway-0.0.1-SNAPSHOT.jar  /user/lib/api-gateway-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","api-gateway-0.0.1-SNAPSHOT.jar"]

