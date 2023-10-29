FROM openjdk:11
WORKDIR user/lib
EXPOSE 8020

ADD ./target/product-webapp-service-0.0.1-SNAPSHOT.jar  /user/lib/product-webapp-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","product-webapp-service-0.0.1-SNAPSHOT.jar"]
