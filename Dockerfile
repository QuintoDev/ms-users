FROM eclipse-temurin:21-jre-alpine

WORKDIR /app
COPY ms-users*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]