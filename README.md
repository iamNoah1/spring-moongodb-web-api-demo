# Spring Mongodb Web Api Demo 

# Prerequisites

* Java 11 installed
* Maven installed
* Docker installed

## Running locally
* `docker pull mongo`
* `docker run -d -p 27017:27017 mongo`
* `./mvnw clean spring-boot:run`

## Running in the cloud
* `cp application-cloud.properties.example application-cloud.properties`
* specify mongodb connection string