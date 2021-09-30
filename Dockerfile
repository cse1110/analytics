FROM maven:3.8.2-openjdk-16-slim
COPY src ./src
COPY pom.xml ./
RUN mvn clean package -Dspring.profiles.active=dev

FROM openjdk:16.0.2-jdk
COPY --from=0 /target/analytics-0.0.1-SNAPSHOT.jar ./analytics.jar
ENTRYPOINT ["java", "-jar", "./analytics.jar"]
