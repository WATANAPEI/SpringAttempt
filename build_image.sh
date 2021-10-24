#!/bin/bash

if [ "$1" == "build" ]; then
  echo "build is called"
  docker image build -t spring-attempt-image:latest .
fi
if [ "$1" == "run" ]; then
  echo "image starts running."
  docker container run -p 8080:8080 spring-attempt-image:latest
fi


echo "Usage: build_image [build/run]"