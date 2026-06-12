# Etapa de build
FROM gradle:8.14.3-jdk21 AS build

WORKDIR /app

COPY . .

RUN gradle bootJar --no-daemon

# Imagem final
FROM eclipse-temurin:21-jre-jammy

COPY --from=build /app/build/libs/*.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]