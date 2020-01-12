FROM openjdk:8-jdk-alpine
MAINTAINER sagara

WORKDIR /opt

# --------------------------------
# Copy scripts, packages & plugins
# --------------------------------
COPY target/hl7backend-1.0.0.jar /opt/


#----------------------
# Expose container ports
# ----------------------
EXPOSE 9090

ENTRYPOINT java -jar /opt/hl7backend-1.0.0.jar