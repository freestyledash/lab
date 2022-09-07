FROM openjdk:8-jdk-alpine

RUN mkdir -p /usr/local/app
COPY /target/lab_web.jar /usr/local/app/lab_web.jar
#arthas
COPY --from=hengyunabc/arthas:latest /opt/arthas /opt/arthas
ENV SPRING_PROFILE="prod"
ENV JAVA_PORT="8080"
EXPOSE ${JAVA_PORT}
ENTRYPOINT exec java -Dspring.profiles.active=${SPRING_PROFILE} -Dserver.port=${JAVA_PORT} -jar /usr/local/app/lab_web.jar
MAINTAINER zyq