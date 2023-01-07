FROM  openjdk:11 as builder
RUN apt-get update -y && apt-get install maven -y
COPY . .
RUN mvn clean package -Dmaven.test.skip=true

FROM openjdk:11
COPY --from=builder /target/upstream-application-0.0.1-SNAPSHOT.jar /app/upstream-application-0.0.1-SNAPSHOT.jar
WORKDIR /app

CMD ["java", "-jar", "upstream-application-0.0.1-SNAPSHOT.jar"]