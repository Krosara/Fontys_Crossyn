FROM gradle:7-jdk16-openj9 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build -x test --no-daemon

FROM eclipse-temurin:16.0.2_7-jdk-alpine
RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/crossyn-0.0.1-SNAPSHOT.jar /app/
ENTRYPOINT ["java", "-jar","/app/crossyn-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080
