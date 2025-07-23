FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /usr/app
COPY . /usr/app

EXPOSE 8080

RUN mvn clean install
CMD mvn spring-boot:run