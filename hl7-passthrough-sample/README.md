**Introduction** 

This sample demonstrates the following integration scenarios related to HL7 using WSO2 Micro Integrator 7.X products. 

* Passthrough HL7-ER7 message over MLLP protocol using proxy service. 
* Passthrough HL7-ER7 message over HTTP protocol using proxy service. 
* Passthrough HL7-ER7 message over MLLP protocol using HL7 inbound endpoint. 


**Prerequisites**

1. Apache Maven to build the samples. 

2. Docker to run the samples.

3. HAPI TestPanel to send sample messages (https://hapifhir.github.io/hapi-hl7v2/hapi-testpanel/)


**How to Build**  

The following commands build both Java-based HL7 backend server and WSO2 Integration samples, and package them as Docker images.  

`cd hl7-passthrough-sample/hl7backend`
`mvn clean install`

`cd hl7-passthrough-sample/wso2-hl7-integration`
`mvn clean install` 


**How to Run**

Running HL7 backend using Docker.

`docker run -it --rm -p 9988:9988 hl7-samples/hl7backend`

Running WSO2 Micro Integration using Docker.
`docker run -it --rm  -p 9292:9292 -p 8290:8290 -p 20000:20000 -e HL7_BE_URL=hl7://host.docker.internal:9988 hl7-samples/integration`

**How to Test**

1. Start HAPI TestPanel and create two new connection as follows. 

- 9292 - To test HL7 proxy service over MLLP.
- 20000 - To test HL7 inbound endpoint MLLP.


2. Generate sample HL7-ER7 messages and send, you should able to see response messages from the backend servers. 

3. To test HL7 proxy service over HTTP use a HTTP client such as cURL or Postman. 

HTTP URL : POST http://localhost:8290/services/hl7Testproxy
Content-Type : application/edi-hl7

`curl -v -N -H "Content-Type : application/edi-hl7" -d "MSH|^~\&|||||20200113103350.823+1300||ADT^A01^ADT_A01|1901|T|2.4" http://localhost:8290/services/hl7Testproxy`



