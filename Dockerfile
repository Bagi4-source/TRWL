FROM gradle:jdk19 as build
RUN mkdir /app && mkdir /src

WORKDIR /src
COPY . .

RUN gradle openApiGenerate
RUN gradle bootJar
RUN chmod +x build/libs/TRWL.jar

FROM openjdk:19-jdk

COPY --from=build ./src/build/libs/TRWL.jar /app/
WORKDIR /app

EXPOSE 8081
CMD ["java", "-jar", "TRWL.jar"]