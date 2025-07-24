#!/bin/bash

APP="app-magalu"
VERSION="0.0.1"

echo "############# VERSAO DO APP :  $APP:$VERSION ###############"

docker stop $APP
docker rm $APP
docker rmi "$APP:$VERSION" 
docker build -t "$APP:$VERSION" .

# DOCKER HUB

#docker tag "$APP:$VERSION" $REGISTRY

# DOCKER CONTAINER

docker run --name $APP -p 8080:80  -e JAVA_OPTS="-Djava.awt.headless=true" "$APP:$VERSION" 