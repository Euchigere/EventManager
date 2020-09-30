FROM openjdk:11

RUN mkdir -p /app/src/main/resources/

WORKDIR /app

COPY target/eventsmanager-0.0.1-SNAPSHOT.jar /app
COPY ./src/main/resources/eventsmanagerdb.mv.db /app/src/main/resources/
COPY ./src/main/resources/eventsmanagerdb.trace.db /app/src/main/resources/

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/eventsmanager-0.0.1-SNAPSHOT.jar"]