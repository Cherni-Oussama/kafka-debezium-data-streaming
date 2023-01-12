FROM  openjdk:11 as builder
RUN apt-get update -y && apt-get install maven -y
RUN apt-get install unzip -y
COPY . .
RUN unzip confluentinc-kafka-connect-jdbc-10.5.1.zip
RUN mvn clean package -Dmaven.test.skip=true

FROM confluentinc/cp-kafka-connect:7.0.1
RUN mkdir -p /usr/share/java/
COPY --from=builder confluentinc-kafka-connect-jdbc-10.5.1 /usr/share/java/confluentinc-kafka-connect-jdbc-10.5.1
COPY --from=builder /target/debezium-cqrs-0.0.1-SNAPSHOT.jar /app/debezium-cqrs-0.0.1-SNAPSHOT.jar
COPY --from=builder run_source_connector_script.bash /scripts/run_source_connector_script.bash
USER root
RUN ["chmod", "+x", "/scripts/run_source_connector_script.bash"]
USER appuser
CMD ["bash","-c","../../scripts/run_source_connector_script.bash ${DBZ_CONNECTOR_CLASS} ${DBZ_HOST} ${DBZ_PORT} ${DBZ_USER} ${DBZ_PASSWORD} ${DBZ_NAME} ${CONNECT_URL} ${CONNECT_SINK_URL}"]
