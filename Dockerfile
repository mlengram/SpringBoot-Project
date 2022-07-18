#H2 datbase is contained in the war file

# Alpine Linux with OpenJDK JRE
FROM openjdk:8-jre-alpine

# Copy war file
COPY employee-0.0.1-SNAPSHOT.jar /marques.war

# run the app
CMD ["/usr/bin/java", "-jar", "/marques.war"]