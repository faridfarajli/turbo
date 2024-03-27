FROM openjdk:21
COPY turbo-0.0.1-SNAPSHOT.jar /app/
WORKDIR /app/
ENTRYPOINT ["java"]
CMD ["-jar", "turbo-0.0.1-SNAPSHOT.jar"]