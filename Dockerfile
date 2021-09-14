# build application
FROM maven:3.6.1-amazoncorretto-11 as build
RUN mkdir -p /opt/springattempt/src
COPY pom.xml /opt/springattempt
COPY src /opt/springattempt/src
EXPOSE 443
RUN cd /opt/springattempt && mvn install

# build docker image
FROM openjdk:11
RUN mkdir -p /opt/app/
COPY --from=build /opt/springattempt/target/springattempt-0.0.1-SNAPSHOT.jar /opt/app/
EXPOSE 8080
CMD ["java", "-jar", "/opt/app/springattempt-0.0.1-SNAPSHOT.jar"]


