# Passthrough HL7 messages over HTTP protocol using a proxy service

This samples demonstrates passthrough HL7 messages over MLLP protocol and implemented as proxy service on WSO2 Micro Integrator 7.0. 

![Passthrough HL7 messages over MLLP protocol using a proxy service ](images/case-1.png)

## Prerequisites

* Build and run the sample backends and integration flows as described  [here.](https://github.com/sagara-gunathunga/hl7-wso2-integration-samples/blob/master/README.md#how-to-build)



## How to Test



* Send a HL7 message over HTTP transport using a HTTP client such as cURL or Postman. 

* HTTP URL : POST http://localhost:8290/services/hl7Testproxy
* Content-Type : application/edi-hl7

```

curl -v -N -H "Content-Type : application/edi-hl7" -d "MSH|^~\&|||||20200113103350.823+1300||ADT^A01^ADT_A01|1901|T|2.4" http://localhost:8290/services/hl7PassthroughProxy

```


* In case if you have used receiving connection in the HAPI TestPanel, you should able to see the received message in the 
HAPI TestPanel; otherwise, if you have used provided test backend, you should able to see received messages in the 
server console.  

![Sending a message to HL7 InboundEndpoint ](images/3.png?raw=true)

 


