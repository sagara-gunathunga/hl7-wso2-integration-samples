**Introduction** 

This program act as the HL7 backend and receive HL7 messages in ER7 format via MLLP and HTTP protocols. 


**How to Run**  

1. Build the Docker image using Maven.

`mvn clean install dockerfile:build`

2. Run using Docker. 

`docker run -it --rm -p 9988:9988 --name hl7backend hl7-samples/hl7backend`

3. Download HAPI test panel from here and make a connection to the following port (https://hapifhir.github.io/hapi-hl7v2/hapi-testpanel/).

  `9988`
