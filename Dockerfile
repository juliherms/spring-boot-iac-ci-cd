#Imagm base
FROM openjdk:11-slim

EXPOSE 8080
EXPOSE 5000
#Add Maintainer Info
LABEL maintainer="j.a.vasconcelos321@gmail.com.br"

#Install curl for internal health check
RUN apt-get update
RUN apt-get install -y curl

WORKDIR /opt/app

ARG JAR_FILE=target/demo-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar", "app.jar"]