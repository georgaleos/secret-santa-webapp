#!/bin/sh

while ! nc -z config-server 8081 ; do
    echo "Waiting for upcoming Secret Santa Server"
    sleep 2
done

java -jar /opt/spring-cloud/lib/spring-secret-santa.jar