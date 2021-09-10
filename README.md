# Spring Mongodb Web Api Demo 

# Prerequisites

* Java 11 installed
* Maven installed
* Docker installed

## Running locally
* `docker pull mongo`
* `docker run -d -p 27017:27017 mongo`
* `./mvnw clean spring-boot:run`

## Running on Kubernetes
* `cp src/main/resources/application-cloud.properties.example src/main/resources/application-cloud.properties`
* specify mongodb connection string
* `./mvnw clean install`
* `docker build -t <registry>/spring-mongo . `
* `docker push <registry>/spring-mongo`
* `cp k8s-manifest.yaml.example k8s-manifest.yaml` and adjust the image containter registry
* `kubectl apply -f k8s-manifest.yaml`
* Use `kubectl get svc` to find out the LoadBalancer IP
* `curl <ip>/todo` or `curl <ip>/todo -X POST -H "Accept: application/json" -H "Content-type: application/json" -d '{"description": "bla" }'`