FROM confluentinc/cp-kafka-connect:7.0.1

USER root

RUN yum install unzip -y
RUN mkdir -p /usr/share/java/

WORKDIR /

COPY . .

RUN wget https://repo1.maven.org/maven2/io/debezium/debezium-connector-postgres/2.1.1.Final/debezium-connector-postgres-2.1.1.Final-plugin.tar.gz -O /tmp/debezium-connector-postgres.tar.gz \
&& tar -xvzf /tmp/debezium-connector-postgres.tar.gz --directory /usr/share/java/ \
&& rm /tmp/debezium-connector-postgres.tar.gz

CMD ["bash","-c","/scripts/start_connectors_script.bash"]
