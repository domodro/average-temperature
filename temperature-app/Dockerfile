FROM eclipse-temurin:21-alpine AS build
ADD . /src
WORKDIR /src
RUN ./gradlew clean assemble

FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=build /src/build/libs/temperature-app.jar /app/temperature-app.jar
ENTRYPOINT java -jar temperature-app.jar
