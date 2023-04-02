FROM adoptopenjdk/openjdk11
COPY target/demo-0.1.jar /deployments/demo-0.1.jar
CMD ["java", "-jar", "/deployments/demo-0.1.jar"]
