FROM openjdk:8-jdk-alpine
MAINTAINER sagara

WORKDIR /opt

# --------------------------------
# Copy scripts, packages & plugins
# --------------------------------
COPY target/patient-mgt-1.0.0.jar /opt/


#----------------------
# Expose container ports
# ----------------------
EXPOSE 8080

ENTRYPOINT java -jar /opt/patient-mgt-1.0.0.jar