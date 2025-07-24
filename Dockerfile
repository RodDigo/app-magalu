#FROM maven:3.8.4-openjdk-17-slim AS build
FROM jelastic/maven:3.9.5-openjdk-21 AS build
WORKDIR /usr/app
COPY . /usr/app

EXPOSE 8084

RUN mvn clean install
CMD mvn spring-boot:run