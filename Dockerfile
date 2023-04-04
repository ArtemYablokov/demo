FROM adoptopenjdk/openjdk11
EXPOSE 8080
COPY target/demo-0.1.jar /deployments/demo-0.1.jar
CMD ["java", "-jar", "/deployments/demo-0.1.jar"]
