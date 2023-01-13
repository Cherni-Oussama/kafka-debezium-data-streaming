/etc/confluent/docker/run &

echo "Waiting for Kafka Connect to start listening on localhost ⏳"

while :; do
# shellcheck disable=SC1083
curl_status=$(curl -s -o /dev/null -w %{http_code} http://connectors:8083/connectors)
# shellcheck disable=SC2046
echo -e $(date) " Kafka Connect listener HTTP state: " $$curl_status " (waiting for 200)"
  if [ "$curl_status" -eq 200 ] ; then
    echo "Kafka Connect is listening"
    break
  fi
  sleep 5
done

echo -e "\n--\n+> Creating source connector"
curl -i -X POST localhost:8083/connectors -H 'Content-Type: application/json' -d @configurations/postgres-debezium-config.json

sleep infinity