FROM gradle:8.5-jdk17-focal AS BUILD
COPY . /usr/app
WORKDIR /usr/app
RUN gradle build -x test 

FROM openjdk:17
COPY --from=BUILD /usr/app/build/libs/dad_assembly_vote-0.0.1-SNAPSHOT.jar /app/app.jar
WORKDIR /app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]