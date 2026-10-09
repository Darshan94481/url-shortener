FROM maven:3.9.9-eclipse-temurin-24 AS build
WORKDIR /app
COPY pom.xml ./
COPY src ./src
RUN mvn -B -DskipTests package

FROM eclipse-temurin:24-jre AS runtime
WORKDIR /app
ENV JAVA_OPTS=""
COPY --from=build --chown=10001:10001 /app/target/url-shortener-1.0-SNAPSHOT.jar /app/app.jar
USER 10001:10001
EXPOSE 8080
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -XX:MaxRAMPercentage=75 -Dserver.port=${PORT:-8080} -jar /app/app.jar"]