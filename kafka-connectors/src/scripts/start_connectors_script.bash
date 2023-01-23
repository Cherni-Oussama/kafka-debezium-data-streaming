/etc/confluent/docker/run &

echo -e "\033[1;32m Getting all environment variables \033[m"

declare -A hashmap
for ARGUMENT in "$@"
do
   KEY=$(echo "$ARGUMENT" | cut -f1 -d=)
   VALUE=$(echo "$ARGUMENT" | cut -f2 -d=)
   hashmap["$KEY"]="$VALUE"
   echo -e "\033[0;34m $KEY \033[m" = "$VALUE"
done
echo -e "\033[1;32m ${#hashmap[@]} parameters received \033[m"

echo -e "\033[1;33m Waiting for Kafka Connect to start listening on localhost ⏳ \033[m"

while :; do
# shellcheck disable=SC1083
curl_status=$(curl -s -o /dev/null -w %{http_code} http://localhost:"${hashmap["CONNECT_PORT"]}"/connectors)
# shellcheck disable=SC2046
echo -e $(date) " Kafka Connect listener HTTP state: " $$curl_status " (waiting for 200)"
  if [ "$curl_status" -eq 200 ] ; then
    echo "Kafka Connect is listening"
    break
  fi
  sleep 5
done

echo -e "\033[1;32m Verifying if all required parameters are available  \033[m"

echo -e "\033[1;32m Creating source connector \033[m"
curl -i -X POST localhost:"${hashmap["CONNECT_PORT"]}"/connectors -H 'Content-Type: application/json' -d @src/configurations/mongo-debezium-config.json
curl -i -X POST localhost:"${hashmap["CONNECT_PORT"]}"/connectors -H 'Content-Type: application/json' -d @src/configurations/mongodb-sink-connector-config.json
sleep infinity
