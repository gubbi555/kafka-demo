Kafka Demo Project
This project demonstrates a Kafka integration with Spring Boot and its deployment on Kubernetes via Docker Desktop.

    Table of Contents:

Project Overview
Technologies Used
Prerequisites
Build Instructions
Docker Build and Push to GitLab Registry
Kubernetes Deployment on Docker Desktop
Accessing the Application
CI Pipeline with GitLab
Kubernetes Security Considerations
Troubleshooting



    Project Overview
This project provides an implementation of a Kafka producer-consumer model using Spring Boot. The application is packaged as a Docker image, pushed to GitLab Container Registry, and deployed to Kubernetes (on Docker Desktop).

    Technologies Used:
Java 17
Spring Boot 3.1.0
Apache Kafka
Kubernetes (Docker Desktop) I used for testing Kubernetes locally
GitLab CI
Helm Charts for managing Kubernetes deployments.
3. Prerequisites
Docker Desktop with Kubernetes enabled.
kubectl CLI for interacting with Kubernetes.
GitLab CI for automating Docker build 
Maven installed for building the Java project.
Kafka broker and Zookeeper running (either locally or in a remote environment).
Minikube : Can also be used for testing Kubernetes locally.





    Build Instructions &
    Docker Build and Push to GitLab Registry:
    (.gitlab-ci.yml)

image: maven:3.9.5-eclipse-temurin-17

stages:
  - build
  - docker-build

# Build Maven project with correct JDK version
build:
  stage: build
  script:
    - mvn clean package

# Build Docker image and push it to GitLab Registry
docker-build:
  image: docker:24.0
  stage: docker-build
  services:
    - docker:dind
  script:
    - docker build -t $CI_REGISTRY_IMAGE:$CI_COMMIT_SHA .
    - echo "$CI_REGISTRY_PASSWORD" | docker login -u "$CI_REGISTRY_USER" --password-stdin $CI_REGISTRY
    - docker push $CI_REGISTRY_IMAGE:$CI_COMMIT_SHA
  only:
    - main


    Kubernetes Deployment with Helm on Docker Desktop
helm create Kafka -n <new-namespace> 
helm install Kafka-release Kafka/ -n <new-namespace>
I have updated deployment.yml and service.yml and service.yml in my Kafka-release chart
kubectl get pods -n <new-namespace>
kubectl get deploy/deployment.yml -n <new-namespace>
kubectl get svc/service.yml -n <new-namespace>

    Kubernetes Security Considerations
ConfigMaps & Secrets 


    Troubleshooting
Maven Errors
Issue: The error indicates that the Maven compiler plugin is not configured correctly or the Java version specified is not supported.
Solution: Ensure the maven-compiler-plugin in  pom.xml file is correctly configured for Java 17.
Kubernetes Errors
Issue: imagePullbackoff
solution: need to ensure that we have necessary permission to pull the image and attach imagePullpolicy and use secretes.yml file
