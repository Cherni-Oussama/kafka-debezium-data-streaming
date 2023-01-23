FROM confluentinc/cp-kafka-connect:7.0.1

USER root

RUN yum install unzip -y
RUN mkdir -p /usr/share/java/

WORKDIR /

COPY ./src ./src

RUN wget https://repo1.maven.org/maven2/io/debezium/debezium-connector-mongodb/2.1.1.Final/debezium-connector-mongodb-2.1.1.Final-plugin.tar.gz -O /tmp/debezium-connector-mongodb.tar.gz \
&& tar -xvzf /tmp/debezium-connector-mongodb.tar.gz --directory /usr/share/java/ \
&& rm /tmp/debezium-connector-mongodb.tar.gz

RUN wget https://d1i4a15mxbxib1.cloudfront.net/api/plugins/confluentinc/kafka-connect-jdbc/versions/10.6.3/confluentinc-kafka-connect-jdbc-10.6.3.zip -O /tmp/confluentinc-kafka-connect-jdbc.zip \
&& unzip /tmp/confluentinc-kafka-connect-jdbc.zip -d /usr/share/java/ \
&& rm /tmp/confluentinc-kafka-connect-jdbc.zip

CMD ["bash","-c","/src/scripts/start_connectors_script.bash \
 CONNECT_PORT=${CONNECT_PORT} \
 DBZ_CONNECTOR_CLASS=${DBZ_CONNECTOR_CLASS} \
 DBZ_HOST=${DBZ_HOST} \
 DBZ_PORT=${DBZ_PORT} \
 DBZ_NAME=${DBZ_NAME} \
 DBZ_USER=${DBZ_USER} \
 DBZ_PASSWORD=${DBZ_PASSWORD} \
 TOPIC_PREFIX=${TOPIC_PREFIX} "]
