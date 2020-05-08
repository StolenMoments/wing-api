#!/bin/bash

REPO=/home/ec2-user/app/step2
PROJECT=wing-api

echo "cp build files"
cp $REPO/zip/*.jar $REPO/

echo "check running app pid"

CURRENT_PID=$(pgrep -fl wing-api | grep)
jar | awk '{print $1}')

if [ -z "$current_pid" ]; then
  echo "> Not found running app"
else
  echo "> kill -15 $CURRENT_PID"
  kill -15 $CURRENT_PID
  sleep 5

fi
echo "deploy new app"

JAR_NAME=$(ls -tr $REPO/*.jar | tail -n 1)

echo "> JAR_Name : $JAR_NAME"
echo "> chmod +x $JAR_NAME"
chmod +x $JAR_NAME

echo "> run $JAR_NAME"
nohup java -jar \
    -Dspring.config.location=classpath:/application.properties,classpath:/application-real.properties,/home/ec2-user/app/application-oauth.properties,/home/ec2-user/app/application-real-db.properties \
    -Dspring.profiles.active=real \
    $JAR_NAME > $REPOSITORY/nohup.out 2>&1 &