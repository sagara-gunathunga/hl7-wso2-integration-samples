# WSO2 Micro Integrator HL7 Passthrough Samples 

These samples demonstrate the following integration scenarios related to HL7 using WSO2 Micro Integrator 7.X. 

* **Passthrough HL7-ER7 messages over MLLP protocol using a proxy service.**

* **Passthrough HL7-ER7 messages over HTTP protocol using a proxy service.** 

* **Passthrough HL7-ER7 messages over MLLP protocol using HL7 inbound endpoint.**  

* **Convert HL7 2.3 message format in to HL7 2.4 format and deliver to a destination.**  

* **Convert simple JSON message in to HL7 FHIR format and deliver to a destination.**  



## Prerequisites

* Apache Maven to build the samples. 

* Docker to run the samples.

* HAPI TestPanel to send sample messages  
(https://hapifhir.github.io/hapi-hl7v2/hapi-testpanel/)  



## How to Build

The following commands build both Java-based HL7 backend server and WSO2 Integration samples, and package them as Docker images.  


Building the sample backend
```

cd hl7backend

mvn clean install

cd patient-mgt

mvn clean install

```


Building the WSO2 EI (MI) with integration flows. 

```

cd wso2-hl7-integration

mvn clean install

```

### Setting up the HL7 test backend.  


One of the following two options can be used to setup the HL7 test backend. 


**Option A : Running the provided backend as a Docker instance.** 


```

docker run -it --rm -p 9988:9988 hl7-samples/hl7backend


docker run -it --rm -p 8080:8080 hl7-samples/patient-mgt


```
  
  
**Option B : Set up a HL7 listener on HAPI TestPanel**  



Configure a receiving connection on HAPI TestPanel using port 9988 as shown in the following diagram.  


![Configure a receiving connection on HAPI TestPanel](docs/images/1.png "Configure a receiving connection on HAPI TestPanel")

  
  
##  Running WSO2 Micro Integrator using Docker

Use the following docker run command

```
docker run -it --rm -p 8280:8280  -p 9292:9292 -p 8290:8290 -p 20000:20000 -p 9393:9393 -p 9494:9494 -p 9595:9595 -e HL7_BE_URL=hl7://host.docker.internal:9988  hl7-samples/wso2-integration
```


## How to Test

Use one of the steps to test each scenario. 

* [Passthrough HL7 messages over MLLP protocol using a proxy service](https://github.com/sagara-gunathunga/hl7-wso2-integration-samples/blob/master/docs/example-1.md)

* [Passthrough HL7 messages over HTTP protocol using a proxy service](https://github.com/sagara-gunathunga/hl7-wso2-integration-samples/blob/master/docs/example-2.md)

* [Passthrough HL7 messages over MLLP protocol using an Inbound Endpoint](https://github.com/sagara-gunathunga/hl7-wso2-integration-samples/blob/master/docs/example-3.md)


* [Asynchronous delivery of HL7 messages over MLLP protocol using WSO2 Message Store and Message Processors](https://github.com/sagara-gunathunga/hl7-wso2-integration-samples/blob/master/docs/example-4.md)

* [Asynchronous delivery of HL7 messages over MLLP protocol using WSO2 Message Store and Message Processors with acknowledgement processing](https://github.com/sagara-gunathunga/hl7-wso2-integration-samples/blob/master/docs/example-5.md)

* [Mediation from REST/JSON to HL7/LLMP and back](https://github.com/sagara-gunathunga/hl7-wso2-integration-samples/blob/master/docs/example-6.md)

* [Convert HL7 2.3 message format in to HL7 2.4 format and deliver to a destination](https://github.com/sagara-gunathunga/hl7-wso2-integration-samples/blob/master/docs/example-7.md)

* [Convert simple JSON message in to HL7 FHIR format and deliver to a destination.](https://github.com/sagara-gunathunga/hl7-wso2-integration-samples/blob/master/docs/example-8.md)



