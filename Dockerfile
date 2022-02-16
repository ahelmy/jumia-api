# Stage 1 build
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

# Stage 2
FROM adoptopenjdk/openjdk11-openj9

EXPOSE 8080
RUN mkdir /db
COPY src/main/resources/sample.db /db/sample.db
ENV DB_URL "/db/sample.db"

COPY --from=build  /home/app/target/jumia-task.jar /app.jar

ENTRYPOINT exec java -jar ./app.jar