FROM openjdk:14-alpine

LABEL version="1.0.0"
LABEL description="Web api for making links smaller."
MAINTAINER "Adam Balski"
LABEL maintainer="Adam Balski"

# *.jar should work, because there should be only one such file

EXPOSE 8080/tcp
WORKDIR /
ADD target/*.jar /

ENTRYPOINT jar -jar *.jar