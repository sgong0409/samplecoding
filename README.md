# samplecoding

## How to build the project
   use maven command "mvn run" to build this project.
## How to run this project
   There are several ways to run this project:
   1. if you run it locally, you can right click project --> Run As --> Spring Boot App
   2. if you want to deploy to server, you can use Jenkins to run maven build and then deploy the jar to the server and run the jar there using "java -jar samplecoding.jar"
   3. after the service is started, you can open a browser and send request to localhost:8080/fibonacci with n you want to send.