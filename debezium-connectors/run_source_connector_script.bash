java -jar debezium-cqrs-0.0.1-SNAPSHOT.jar

/etc/confluent/docker/run &

echo "Waiting for Kafka Connect to start listening on localhost ⏳"

while :; do
# shellcheck disable=SC1083
curl_status=$(curl -s -o /dev/null -w %{http_code} http://"$7"/connectors)
# shellcheck disable=SC2046
echo -e $(date) " Kafka Connect listener HTTP state: " $$curl_status " (waiting for 200)"
  if [ "$curl_status" -eq 200 ] ; then
    echo "Kafka Connect is listening"
    break
  fi
  sleep 5
done

echo -e "\n--\n+> Creating source connector"
curl -X POST -H "Accept:application/json" -H "Content-Type:application/json" http://"$7"/connectors/ \
    -d '{
             "name": "source-connector",
             "config": {
             "connector.class": '\""$1"\"',
             "tasks.max": "1",
             "database.hostname": '\""$2"\"',
             "database.port": '\""$3"\"',
             "database.user": '\""$4"\"',
             "database.password": '\""$5"\"',
             "database.dbname": '\""$6"\"',
             "database.history.kafka.bootstrap.servers": "kafka:9092",
             "topic.prefix": "topic"
             }
        }'
echo -e "\n--\n+> END Creating source connector"

while :; do
curl_status=$(curl -s -o /dev/null -w %{http_code} http://localhost:8083/connectors)
echo -e $(date) " Kafka Connect listener HTTP state: " $$curl_status " (waiting for 200)"
  if [ $curl_status -eq 200 ] ; then
    break
  fi
  sleep 5
done


sleep infinity
