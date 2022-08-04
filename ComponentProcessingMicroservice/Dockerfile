# define base docker image
FROM openjdk:8
LABEL maintainer="piraneshs"
ADD target/componentProcessingMicroservice-0.0.1-SNAPSHOT.jar component-processing-microservice.jar
ENTRYPOINT ["java", "-jar", "component-processing-microservice.jar"]