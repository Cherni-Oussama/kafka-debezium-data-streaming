/etc/confluent/docker/run &

echo "Waiting for Kafka Connect to start listening on localhost ⏳"

while :; do
# shellcheck disable=SC1083
curl_status=$(curl -s -o /dev/null -w %{http_code} http://localhost:"$8"/connectors)
# shellcheck disable=SC2046
echo -e $(date) " Kafka Connect listener HTTP state: " $$curl_status " (waiting for 200)"
  if [ "$curl_status" -eq 200 ] ; then
    echo "Kafka Connect is listening"
    break
  fi
  sleep 5
done

echo "Updating Source Connector with parameters ⏳"

cat src/configurations/postgres-debezium-config.json

sed -i 's/DBZ_CONNECTOR_CLASS/'"$1"'/' src/configurations/postgres-debezium-config.json
sed -i 's/DBZ_HOST/'"$2"'/' src/configurations/postgres-debezium-config.json
sed -i 's/DBZ_PORT/'"$3"'/' src/configurations/postgres-debezium-config.json
sed -i 's/DBZ_USER/'"$4"'/' src/configurations/postgres-debezium-config.json
sed -i 's/DBZ_PASSWORD/'"$5"'/' src/configurations/postgres-debezium-config.json
sed -i 's/DBZ_NAME/'"$6"'/' src/configurations/postgres-debezium-config.json
sed -i 's/TOPIC_PREFIX/'"$7"'/' src/configurations/postgres-debezium-config.json

cat src/configurations/postgres-debezium-config.json

echo -e "\n--\n+> Creating source connector"
curl -i -X POST localhost:"$8"/connectors -H 'Content-Type: application/json' -d @src/configurations/postgres-debezium-config.json

sleep infinity