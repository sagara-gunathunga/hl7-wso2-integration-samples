
Hello-local

This sample create a Docker image in local repo. 

How to build 
mvn clean install 

How to run 

Without Mgt API

docker run --rm -p 8290:8290 hello:1.0.0

With Mgt API
docker run --rm -p 8290:8290 -p 9164:9164 -e   JAVA_OPTS="-DenableManagementApi=true"  hello:1.0.0


How to test 

curl http://localhost:8290/hello/sagara
